package kata.tennis.service.impl;

import kata.tennis.service.DisplayScore;
import kata.tennis.model.Player;

public class StandardMatchImpl implements DisplayScore {
	
	@Override
	public boolean isActivated(Player p1, Player p2) {
		return (p1.getGameScore() <= 3 && p2.getGameScore() <= 3);
	}
	
	@Override
	public String displayScore(Player p1, Player p2) {
		String display = "";
		
		if(p1.getGameScore() <= 3 && p1.getGameScore() <= 3) {
			display = new String("Actual Score : "+p1.getScoreGameFromPoint() + "-" +p2.getScoreGameFromPoint());
		}
		else {
			display = (p1.getGameScore() > p2.getGameScore()) ? new String("Player 1 win the game") : (new String("Player 2 win the game"));
		}

		return display;
	}
}
