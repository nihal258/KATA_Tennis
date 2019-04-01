package kata.tennis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kata.tennis.model.Player;
import kata.tennis.service.DisplayScore;
import kata.tennis.service.impl.DeuceMatchImpl;
import kata.tennis.service.impl.SetMatchImpl;
import kata.tennis.service.impl.StandardMatchImpl;
import kata.tennis.service.impl.TieBreakImpl;
import lombok.Data;

/**
 * @author Nihal
 *
 */
@Data
public class TennisMatchSimulator 
{
	private List<Player> players = new ArrayList<Player>();
	private List<DisplayScore> displays = new ArrayList<DisplayScore>();
	
	private DisplayScore display = new StandardMatchImpl();
	
	private boolean newMatchFlag = false;
	
	private Player getFirstPlayer() {
		return this.players.get(0);
	}
	
	private Player getSecondPlayer() {
		return this.players.get(1);
	}
	
	public boolean isNewMatchFlag() {
		if(getFirstPlayer().getSetScore() == 6 && getSecondPlayer().getSetScore() == 5 || getFirstPlayer().getSetScore() == 5 && getSecondPlayer().getSetScore() == 6) {
			setNewMatchFlag(true);
		}
		
		return newMatchFlag;
	}
	
	/**
	 * @return availables rules displays
	 */
	public List<DisplayScore> getDisplays() {
		return displays;
	}

	/**
	 * @param player1 : first player
	 * @param player2 : second player
	 */
	public TennisMatchSimulator(Player player1, Player player2) {
		this.players = Arrays.asList(player1, player2);
		this.displays = Arrays.asList(new StandardMatchImpl(), new DeuceMatchImpl(), new SetMatchImpl(), new TieBreakImpl());
	}
	
	/**
	 * reset all players scores
	 */
	public void resetAllPlayersScores() {
		this.players.stream().forEach(player -> resetAllScores(player));
	}

	/**
	 * @param player to reset all scores
	 */
	private void resetAllScores(Player p1) {
		p1.resetAllScores();
	}
	
	public DisplayScore getDisplayScore() {
		if(isStandardMatch()) {
			display =  new StandardMatchImpl();
		}
		if(isDeuceMatch()) {
			display = new DeuceMatchImpl();
		}
		if (isSetMatch()) {
			display = new SetMatchImpl();
		}
		if(isTieBreakMatch()) {
			display = new TieBreakImpl();
		}
		return display;
	}
	
	private boolean isStandardMatch() {
		return (getFirstPlayer().getGameScore() <= 3 || getSecondPlayer().getGameScore() <= 3)
				&& (!getFirstPlayer().isAdv() || !getSecondPlayer().isAdv())
				&& (getFirstPlayer().getTieBreakScore() == 0 && getSecondPlayer().getTieBreakScore() == 0);
	}
	
	private boolean isDeuceMatch() {
		return getFirstPlayer().getGameScore() >= 3 && getSecondPlayer().getGameScore() >= 3
				&& (getFirstPlayer().isAdv() || getSecondPlayer().isAdv());
	}
	
	private boolean isSetMatch() {
		return (getFirstPlayer().getGameScore() >= 3 && getSecondPlayer().getGameScore() >= 3)
				&& (getFirstPlayer().getSetScore() > 0 && getSecondPlayer().getSetScore() > 0)
				&& (getFirstPlayer().getTieBreakScore() == 0 && getSecondPlayer().getTieBreakScore() == 0)
				&& (!getFirstPlayer().isAdv() && !getSecondPlayer().isAdv())
				&& !isTieBreakMatch();
	}
	
	public boolean isTieBreakMatch() {
		return getFirstPlayer().getTieBreakScore() == 6 && getSecondPlayer().getTieBreakScore()==6;
	}
}
