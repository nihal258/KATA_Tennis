package kata.tennis.service.impl;

import kata.tennis.service.DisplayScore;
import kata.tennis.TennisMatchSimulator;
import kata.tennis.model.Player;

public class StandardMatchImpl implements DisplayScore {
	
	@Override
	public String displayScore(Player p1, Player p2, TennisMatchSimulator tennisMatchSimulator) {
		if(p1.getGameScore() <= 3 && p1.getGameScore() <= 3) {
			return new String("Actual Score : "+p1.getScoreGameFromPoint() + "-" +p2.getScoreGameFromPoint());
		}
		
		return getWinner(p1, p2);
	}
	
	private String getWinner(Player p1, Player p2) {
		return (p1.getGameScore() > p2.getGameScore()) ? new String("Player 1 win the game") : (new String("Player 2 win the game"));
	}
}
