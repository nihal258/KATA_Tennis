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
 * Unit test for Standard Tennis Match.
 */

@RunWith(JUnitParamsRunner.class)
public class StandardMatchImplTest {
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
    @Parameters({"2, 3, Actual Score : 40-40"})
    public void should_display_standard_match_40_40_when_p1_win_one_point(int player1Score, int player2Score, String expectedScore) 
    {   	
    	p1.setGameScore(player1Score);
    	p2.setGameScore(player2Score);
    	
    	p1.markOnePoint();
    	
    	DisplayScore play = tennisMatchSimulator.getDisplayScore();
    	
        String actualScore = play.displayScore(p1, p2, tennisMatchSimulator);        
        Assert.assertEquals(expectedScore, actualScore);
    }
}
