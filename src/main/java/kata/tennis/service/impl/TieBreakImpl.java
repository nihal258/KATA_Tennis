package kata.tennis.service.impl;

import kata.tennis.TennisMatchSimulator;
import kata.tennis.model.Player;
import kata.tennis.service.DisplayScore;

public class TieBreakImpl implements DisplayScore {
	
	@Override
	public String displayScore(Player p1, Player p2, TennisMatchSimulator tennisMatchSimulator) {
		if (p1.getTieBreakScore() == 7 || p2.getTieBreakScore() == 7) {
			return getTheWinnerOfTheTieBreak(p1, p2);
		}
		return "TieBreak Rule Activated";
	}
	
	private String getTheWinnerOfTheTieBreak(Player p1, Player p2) {
		return (p1.getTieBreakScore() > p2.getTieBreakScore()) ? "Player 1 win the TieBreak and the Set and the Match"
				  											   : "Player 2 win the TieBreak and the Set and the Match";
	}
	
}
