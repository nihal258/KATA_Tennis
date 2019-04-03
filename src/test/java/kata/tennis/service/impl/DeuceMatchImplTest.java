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
 * Unit test for Deuce Rule Tennis Match.
 */

@RunWith(JUnitParamsRunner.class)
public class DeuceMatchImplTest {
	
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
    @Parameters({"3, 3, false, false, Player 1 win the ADV"})
    public void should_display_deuce_match_p1_win_adv_when_p1_win_one_point(int player1Score, int player2Score,
    																		 boolean player1Adv, boolean player2Adv, 
    																		 String expectedScore) 
    {   	
    	p1.setGameScore(player1Score);
    	p2.setGameScore(player2Score);
     	
    	p1.setAdv(player1Adv);
    	p2.setAdv(player2Adv);
    	
    	p1.markOnePoint();
    	
    	DisplayScore play = tennisMatchSimulator.getDisplayScore();
    	
        String actualScore = play.displayScore(p1, p2, tennisMatchSimulator);        
        Assert.assertEquals(expectedScore, actualScore);
    }
    
	
    @Test
    @Parameters({"4, 3, true, false, Actual Score : Deuce - Deuce"})
    public void should_display_deuce_match_deuce_deuce_when_p2_win_one_point(int player1Score, int player2Score,
    																		 boolean player1Adv, boolean player2Adv, 
    																		 String expectedScore) 
    {   	
    	p1.setGameScore(player1Score);
    	p2.setGameScore(player2Score);
    	
    	p1.setAdv(player1Adv);
    	p2.setAdv(player2Adv);
    	
    	p2.markOnePoint();
    	
    	DisplayScore play = tennisMatchSimulator.getDisplayScore();
        
        String actualScore = play.displayScore(p1, p2, tennisMatchSimulator);        
        Assert.assertEquals(expectedScore, actualScore);
    }

    @Test
    @Parameters({"5, 4, true, false, Player 1 win the game"})
    public void should_display_deuce_match_p1_win_the_match_when_p1_win_one_point(int player1Score, int player2Score,
    																		      boolean player1Adv, boolean player2Adv, 
    																		      String expectedScore)
    {   	
    	p1.setGameScore(player1Score);
    	p2.setGameScore(player2Score);
    	
    	p1.setAdv(player1Adv);
    	p2.setAdv(player2Adv);
    	
    	p1.markOnePoint();
    	
    	DisplayScore play = tennisMatchSimulator.getDisplayScore();
        
        String actualScore = play.displayScore(p1, p2, tennisMatchSimulator);        
        Assert.assertEquals(expectedScore, actualScore);
    }
}
