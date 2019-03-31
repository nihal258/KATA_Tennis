package kata.tennis;

import java.util.Optional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import kata.tennis.model.Player;
import kata.tennis.service.DisplayScore;

/**
 * Unit test for Tennis Match Simulator.
 */

@RunWith(JUnitParamsRunner.class)
public class TennisMatchSimulatorTest {

	private Player p1;
	private Player p2;
	private TennisMatchSimulator tennisMatchSimulator;
    
    @Before
    public void setUp() {
    	p1 = new Player();
    	p2 = new Player();
    	tennisMatchSimulator = new TennisMatchSimulator(p1, p2);
    }
    
    @After
    public void resetAllPlayersScores () {
    	tennisMatchSimulator.resetAllPlayersScores();
    }
    
    @Test
    @Parameters({"2, 3, Actual Score : 40-40"})
    public void should_display_standard_match_40_40_when_p1_win_one_point(int player1Score, int player2Score, String expectedScore) 
    {   	
    	p1.setGameScore(player1Score);
    	p2.setGameScore(player2Score);
    	
    	p1.markOnePoint();
    	
    	Optional<DisplayScore> play = tennisMatchSimulator.getDisplays().stream().filter(d -> d.isActivated(p1, p2)).findAny();
    	
        String actualScore = play.get().displayScore(p1, p2);        
        Assert.assertEquals(expectedScore, actualScore);
    }
    
    /** Test not more applicable in Sprint 2*/
    /*@Test
    @Parameters({"3, 3, Player 1 win the game"})
    public void should_display_standard_match_p1_is_the_winner_when_p1_win_one_point(int player1Score, int player2Score, String expectedScore) {   	
    	p1.setGameScore(player1Score);
    	p2.setGameScore(player2Score);
    	
    	p1.markOnePoint();
    	
    	Optional<DisplayScore> play = tennisMatchSimulator.getDisplays().stream().filter(d -> d.isActivated(p1, p2)).findAny();
        
        String actualScore = play.get().displayScore(p1, p2);        
        Assert.assertEquals(expectedScore, actualScore);
    }*/
    
    @Test
    @Parameters({"3, 3, false, false, Player 1 win the ADV"})
    public void should_display_deuce_match_p1_win_adv_when_p1_win_one_point(int player1Score, int player2Score,
    																		 boolean player1Adv, boolean player2Adv, String expectedScore) 
    {   	
    	p1.setGameScore(player1Score);
    	p2.setGameScore(player2Score);
    	
    	p1.setAdv(player1Adv);
    	p2.setAdv(player2Adv);
    	
    	p1.markOnePoint();
    	
    	Optional<DisplayScore> play = tennisMatchSimulator.getDisplays().stream().filter(d -> d.isActivated(p1, p2)).findAny();
        
        String actualScore = play.get().displayScore(p1, p2);        
        Assert.assertEquals(expectedScore, actualScore);
    }
    
    @Test
    @Parameters({"4, 3, true, false, Actual Score : Deuce - Deuce"})
    public void should_display_deuce_match_deuce_deuce_when_p2_win_one_point(int player1Score, int player2Score,
    																		 boolean player1Adv, boolean player2Adv, String expectedScore) 
    {   	
    	p1.setGameScore(player1Score);
    	p2.setGameScore(player2Score);
    	
    	p1.setAdv(player1Adv);
    	p2.setAdv(player2Adv);
    	
    	p2.markOnePoint();
    	
    	Optional<DisplayScore> play = tennisMatchSimulator.getDisplays().stream().filter(d -> d.isActivated(p1, p2)).findAny();
        
        String actualScore = play.get().displayScore(p1, p2);        
        Assert.assertEquals(expectedScore, actualScore);
    }
    
    @Test
    @Parameters({"5, 4, true, false, Player 1 win the game"})
    public void should_display_deuce_match_p1_win_the_match_when_p1_win_one_point(int player1Score, int player2Score,
    																		 boolean player1Adv, boolean player2Adv, String expectedScore)
    {   	
    	p1.setGameScore(player1Score);
    	p2.setGameScore(player2Score);
    	
    	p1.setAdv(player1Adv);
    	p2.setAdv(player2Adv);
    	
    	p1.markOnePoint();
    	
    	Optional<DisplayScore> play = tennisMatchSimulator.getDisplays().stream().filter(d -> d.isActivated(p1, p2)).findAny();
        
        String actualScore = play.get().displayScore(p1, p2);        
        Assert.assertEquals(expectedScore, actualScore);
    }
    
}
