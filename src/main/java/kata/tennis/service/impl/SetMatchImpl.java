package kata.tennis.service.impl;

import kata.tennis.TennisMatchSimulator;
import kata.tennis.model.Player;
import kata.tennis.service.DisplayScore;

public class SetMatchImpl implements DisplayScore {

	@Override
	public String displayScore(Player p1, Player p2, TennisMatchSimulator tennisMatchSimulator) {
		
		if(!tennisMatchSimulator.isNewMatchFlag() && (p1.getSetScore() == 6 || p2.getSetScore() == 6) && (Math.abs(p1.getSetScore() - p2.getSetScore()) >= 2)) {
			return getWinnerOfTheSet(p1, p2);
		}
		else if (tennisMatchSimulator.isNewMatchFlag() && (p1.getSetScore() == 7 || p2.getSetScore() == 7)) {
			return getWinnerOfTheMatch(p1, p2);
		}
		
		p1.setGameScore(0);
		p2.setGameScore(0);
				
		return "A new match must be player and the first player who reach the score of 7 wins the match";
	}
	 
	private String getWinnerOfTheSet(Player p1, Player p2) {
		return (p1.getGameScore() > p2.getGameScore()) ? new String("Player 1 win the Set") : (new String("Player 2 win the Set"));
	}
	
	private String getWinnerOfTheMatch(Player p1, Player p2) {
		return (p1.getGameScore() > p2.getGameScore()) ? new String("Player 1 win the Match") : (new String("Player 2 win the Match"));
	}
}