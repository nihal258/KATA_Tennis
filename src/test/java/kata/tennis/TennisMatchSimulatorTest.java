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
    @Parameters({"30, 40, Actual Score : 40-40"})
    public void should_display_standard_match_40_40_when_p1_win_one_point(int player1Score, int player2Score, String expectedScore) {   	
    	p1.setGameScore(player1Score);
    	p2.setGameScore(player2Score);
    	
    	Optional<DisplayScore> play = tennisMatchSimulator.getDisplays().stream().filter(d -> d.isActivated(p1, p2)).findAny();
        
    	p1.setGameScore(2);
    	p2.setGameScore(3);
    	
    	p1.markOnePoint();
    	
        String actualScore = play.get().displayScore(p1, p2);        
        Assert.assertEquals(expectedScore, actualScore);
    }
    
    @Test
    @Parameters({"40, 40, Player 1 win the game"})
    public void should_display_standard_match_p1_is_the_winner_when_p1_win_one_point(int player1Score, int player2Score, String expectedScore) {   	
    	p1.setGameScore(player1Score);
    	p2.setGameScore(player2Score);
    	
    	Optional<DisplayScore> play = tennisMatchSimulator.getDisplays().stream().filter(d -> d.isActivated(p1, p2)).findAny();
        
    	p1.setGameScore(3);
    	p2.setGameScore(3);
    	
    	p1.markOnePoint();
    	
        String actualScore = play.get().displayScore(p1, p2);        
        Assert.assertEquals(expectedScore, actualScore);
    }
    
}
