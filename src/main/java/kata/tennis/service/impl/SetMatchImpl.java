package kata.tennis.service.impl;

import kata.tennis.TennisMatchSimulator;
import kata.tennis.model.Player;
import kata.tennis.service.DisplayScore;

public class SetMatchImpl implements DisplayScore {

	@Override
	public boolean isActivated(Player p1, Player p2, TennisMatchSimulator tennisMatchSimulator) {
		return ((p1.getGameScore() >= 3 && p2.getGameScore() >= 3)
				&& (p1.getSetScore() > 0 && p2.getSetScore() > 0)
				&& !tennisMatchSimulator.isTieBreak());
	}

	@Override
	public String displayScore(Player p1, Player p2, TennisMatchSimulator tennisMatchSimulator) {
		String display = "";
		
		if((p1.getSetScore() == 6 || p2.getSetScore() == 6) && (Math.abs(p1.getSetScore() - p2.getSetScore()) >= 2)) {
			display = (p1.getGameScore() > p2.getGameScore()) ? new String("Player 1 win the Set") : (new String("Player 2 win the Set"));
		}
		else if((p1.getSetScore() == 6 || p2.getSetScore() == 6) && (Math.abs(p1.getSetScore() - p2.getSetScore()) == 1)) {
			display = new String("A new match must be player and the first player who reach the score of 7 wins the match");
			tennisMatchSimulator.setNewMatchOn(true);
			p1.setGameScore(0);
			p2.setGameScore(0);
		}
		else if (tennisMatchSimulator.isNewMatchOn() && (p1.getSetScore() == 7 || p2.getSetScore() == 7)) {
			display = (p1.getGameScore() > p2.getGameScore()) ? new String("Player 1 win the Match") : (new String("Player 2 win the Match"));
		}
		
		return display;
	}
}