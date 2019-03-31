package kata.tennis.service;

import kata.tennis.model.Player;

public interface DisplayScore {
	/**
	 * @param P1 : First player
	 * @param P2 : Second player
	 * @return true if the play rule is actived
	 */
	boolean isActivated(Player p1, Player p2);
	
	/**
	 * @param P1 : First player
	 * @param P2 : Second player
	 * @return a string value with the final score and the winner of the match
	 */
	String displayScore(Player p1, Player p2);	
}
