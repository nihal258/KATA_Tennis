package kata.tennis.service.impl;

import kata.tennis.TennisMatchSimulator;
import kata.tennis.model.Player;
import kata.tennis.service.DisplayScore;

public class TieBreakImpl implements DisplayScore {

	@Override
	public boolean isActivated(Player p1, Player p2, TennisMatchSimulator tennisMatchSimulator) {
		return tennisMatchSimulator.isTieBreak();
	}

	@Override
	public String displayScore(Player p1, Player p2, TennisMatchSimulator tennisMatchSimulator) {
		
		String display = "";
		
		if (p1.getSetScore() == 6 && p2.getSetScore() == 6) {
			display = new String("TieBreak Rule Activated");
		}
		
		if ((p1.getTieBreakScore() == 7 || p2.getTieBreakScore() == 7) && (Math.abs(p1.getTieBreakScore() - p2.getTieBreakScore()) == 2)) {
			display = (p1.getTieBreakScore() > p2.getTieBreakScore()) ? new String("Player 1 win the TieBreak and the Set and the Match") 
																	  : (new String("Player 2 win the TieBreak and the Set and the Match"));
		}
		
		return display;
	}
}
