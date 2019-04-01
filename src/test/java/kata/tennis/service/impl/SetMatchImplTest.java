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
 * 
 * Unit test for Set Rule Tennis Match.
 *
 */
@RunWith(JUnitParamsRunner.class)
public class SetMatchImplTest {
	
	private Player p1;
	private Player p2;
	private TennisMatchSimulator tennisMatchSimulator;
    
    @Before
    public void setUp() {
    	p1 = new Player();
    	p2 = new Player();
    	tennisMatchSimulator = new TennisMatchSimulator(p1, p2);
    }
    
	@Test
    @Parameters({"3, 3, 5, 3, Player 1 win the Set"})
    public void should_display_set_match_p1_win_the_set_when_p1_is_6_and_p2_is_3(
    		int player1gGamecore, 
    		int player2GameScore,
    		int player1SetScore, 
    		int player2SetScore, 
    		String expectedScore
    ){   	
    	p1.setGameScore(player1gGamecore);
    	p2.setGameScore(player2GameScore);
    	
    	p1.setSetScore(player1SetScore);
    	p2.setSetScore(player2SetScore);    	
    	
    	p1.markOnePoint();
    	
    	p1.setAdv(false);
    	p2.setAdv(false);
    	
    	p1.setTieBreakScore(0);
    	p2.setTieBreakScore(0);
    	
    	DisplayScore play = tennisMatchSimulator.getDisplayScore();
        
        String actualScore = play.displayScore(p1, p2, tennisMatchSimulator);        
        Assert.assertEquals(expectedScore, actualScore);
    }
    
    @Test
    @Parameters({"3, 3, 5, 5, A new match must be player and the first player who reach the score of 7 wins the match"})
    public void should_display_set_match_new_match_when_p1_is_6_and_p2_is_5(
    		int player1gGamecore,
    		int player2GameScore,
    		int player1SetScore, 
    		int player2SetScore, 
    		String expectedScore
    ){   	
    	p1.setGameScore(player1gGamecore);
    	p2.setGameScore(player2GameScore);
    	
    	p1.setSetScore(player1SetScore);
    	p2.setSetScore(player2SetScore);    	
    	
    	p1.markOnePoint();
    	
    	p1.setAdv(false);
    	p2.setAdv(false);    	
    	
    	p1.setTieBreakScore(0);
    	p2.setTieBreakScore(0);
    	
    	DisplayScore play = tennisMatchSimulator.getDisplayScore();
        
        String actualScore = play.displayScore(p1, p2, tennisMatchSimulator);        
        Assert.assertEquals(expectedScore, actualScore);
    }
    
    @Test
    @Parameters({"3, 3, 6, 3, true, Player 1 win the Match"})
    public void should_display_set_match_p1_win_the_match_when_p1_is_7_and_p2_is_3_and_new_match(
    		int player1gGamecore,
    		int player2GameScore,
    		int player1SetScore, 
    		int player2SetScore, 
    		boolean newMatchFlag,
    		String expectedScore
    ){   	
    	p1.setGameScore(player1gGamecore);
    	p2.setGameScore(player2GameScore);
    	
    	p1.setSetScore(player1SetScore);
    	p2.setSetScore(player2SetScore);
    	
    	tennisMatchSimulator.setNewMatchFlag(newMatchFlag);
    	
    	p1.markOnePoint();
    	
    	p1.setAdv(false);
    	p2.setAdv(false);
    	
    	p1.setTieBreakScore(0);
    	p2.setTieBreakScore(0);
    	
    	DisplayScore play = tennisMatchSimulator.getDisplayScore();
        
        String actualScore = play.displayScore(p1, p2, tennisMatchSimulator);        
        Assert.assertEquals(expectedScore, actualScore);
    }
}
