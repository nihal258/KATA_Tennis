package kata.tennis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kata.tennis.model.Player;
import kata.tennis.service.DisplayScore;
import kata.tennis.service.impl.DeuceMatchImpl;
import kata.tennis.service.impl.StandardMatchImpl;

/**
 * @author Nihal
 *
 */
public class TennisMatchSimulator 
{
	private List<Player> players = new ArrayList<Player>();
	private List<DisplayScore> displays = new ArrayList<DisplayScore>();
	
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
		this.displays = Arrays.asList(new StandardMatchImpl(), new DeuceMatchImpl());
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
}
