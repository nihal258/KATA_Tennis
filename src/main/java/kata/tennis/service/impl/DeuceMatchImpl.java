package kata.tennis.service.impl;

import kata.tennis.TennisMatchSimulator;
import kata.tennis.model.Player;
import kata.tennis.service.DisplayScore;

public class DeuceMatchImpl implements DisplayScore {

	@Override
	public boolean isActivated(Player p1, Player p2) {
		return ((p1.getGameScore() >= 3 && p2.getGameScore() >= 3)
				&& (p1.getSetScore()== 0 && p2.getSetScore() == 0));
	}

	@Override
	public String displayScore(Player p1, Player p2, TennisMatchSimulator tennisMatchSimulator) {
		String display = "";
		
		if(p1.isAdv() && p2.isAdv()) {
			display = new String("Actual Score : Deuce - Deuce");
		}
		else {
			if (Math.abs(p1.getGameScore() - p2.getGameScore()) == 1)
				display = (p1.isAdv() && ! p2.isAdv()) ? new String("Player 1 win the ADV") : new String("Player 2 win the ADV");
			else {
				display = (p1.getGameScore() > p2.getGameScore()) ? new String("Player 1 win the game") : (new String("Player 2 win the game"));
			}
		}

		return display;
	}

}
