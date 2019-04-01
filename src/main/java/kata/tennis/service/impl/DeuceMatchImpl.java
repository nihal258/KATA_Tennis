package kata.tennis.service.impl;

import kata.tennis.TennisMatchSimulator;
import kata.tennis.model.Player;
import kata.tennis.service.DisplayScore;

public class DeuceMatchImpl implements DisplayScore {

	@Override
	public String displayScore(Player p1, Player p2, TennisMatchSimulator tennisMatchSimulator) {
		if(!p1.isAdv() || !p2.isAdv()) {
			if (Math.abs(p1.getGameScore() - p2.getGameScore()) == 1)
				return getAdvantage(p1, p2);
			
			return getWinner(p1, p2);
		}
			
		return new String("Actual Score : Deuce - Deuce");
	}

	private String getAdvantage(Player p1, Player p2) {
		if(p1.isAdv()) {
			return new String("Player 1 win the ADV");
		}
		return new String("Player 2 win the ADV");
	}
	
	private String getWinner(Player p1, Player p2) {
		if(p1.getGameScore() > p2.getGameScore()) {
			return new String("Player 1 win the game");
		}
		return new String("Player 2 win the game");
	}
}
