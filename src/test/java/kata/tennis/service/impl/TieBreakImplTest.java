package kata.tennis.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import kata.tennis.TennisMatchSimulator;
import kata.tennis.model.Player;
import kata.tennis.service.DisplayScore;

/**
 * Unit test for TieBreak Rule Tennis Match.
 */

@RunWith(JUnitParamsRunner.class)
public class TieBreakImplTest {
	
	private Player p1;
	private Player p2;
	private TennisMatchSimulator tennisMatchSimulator;
    
    @Before
    public void setUp() {
    	p1 = new Player("Player 1");
    	p2 = new Player("Player 2");
    	tennisMatchSimulator = new TennisMatchSimulator(p1, p2);
    }
    
    @Test
    @Parameters({"3, 3, 5, 6, TieBreak Rule Activated"})
    public void should_display_tie_break_match_activated_when_p1_is_6_and_p2_is_6(int player1gGamecore, int player2GameScore,
    																		      int player1TieBreakScore, int player2TieBreakScore, String expectedScore)
    {   	
    	p1.setGameScore(player1gGamecore);
    	p2.setGameScore(player2GameScore);
    	
    	p1.setTieBreakScore(player1TieBreakScore);
    	p2.setTieBreakScore(player2TieBreakScore);    	
    	
    	p1.markOnePoint();
    	
    	DisplayScore play = tennisMatchSimulator.getDisplayScore();
        
        String actualScore = play.displayScore(p1, p2, tennisMatchSimulator);        
        Assert.assertEquals(expectedScore, actualScore);
    }
}
