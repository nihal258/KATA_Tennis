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
    	
        String actualScore = play.get().displayScore(p1, p2, tennisMatchSimulator);        
        Assert.assertEquals(expectedScore, actualScore);
    }
    
    /** Test not more applicable in Sprint 2*/
    /*@Test
    @Parameters({"3, 3, Player 1 win the game"})
    public void should_display_standard_match_p1_is_the_winner_when_p1_win_one_point(int player1Score, int player2Score, 
    																				 String expectedScore) {   	
    	p1.setGameScore(player1Score);
    	p2.setGameScore(player2Score);
    	
    	p1.markOnePoint();
    	
    	Optional<DisplayScore> play = tennisMatchSimulator.getDisplays().stream().filter(d -> d.isActivated(p1, p2)).findAny();
        
        String actualScore = play.get().displayScore(p1, p2, tennisMatchSimulator);        
        Assert.assertEquals(expectedScore, actualScore);
    }*/
    
    /** Deuce Tests not more applicables in Sprint 3*/
    /*@Test
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
    	
    	Optional<DisplayScore> play = tennisMatchSimulator.getDisplays().stream().filter(d -> d.isActivated(p1, p2)).findAny();
        
        String actualScore = play.get().displayScore(p1, p2, tennisMatchSimulator);        
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
    	
    	Optional<DisplayScore> play = tennisMatchSimulator.getDisplays().stream().filter(d -> d.isActivated(p1, p2)).findAny();
        
        String actualScore = play.get().displayScore(p1, p2, tennisMatchSimulator);        
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
    	
    	Optional<DisplayScore> play = tennisMatchSimulator.getDisplays().stream().filter(d -> d.isActivated(p1, p2)).findAny();
        
        String actualScore = play.get().displayScore(p1, p2, tennisMatchSimulator);        
        Assert.assertEquals(expectedScore, actualScore);
    }*/
    
    @Test
    @Parameters({"3, 3, 5, 3, Player 1 win the Set"})
    public void should_display_set_match_p1_win_the_set_when_p1_is_6_and_p2_is_3(int player1gGamecore, int player2GameScore,
    																		     int player1SetScore, int player2SetScore, 
    																		     String expectedScore)
    {   	
    	p1.setGameScore(player1gGamecore);
    	p2.setGameScore(player2GameScore);
    	
    	p1.setSetScore(player1SetScore);
    	p2.setSetScore(player2SetScore);    	
    	
    	p1.markOnePoint();
    	
    	Optional<DisplayScore> play = tennisMatchSimulator.getDisplays().stream().filter(d -> d.isActivated(p1, p2)).findAny();
        
        String actualScore = play.get().displayScore(p1, p2, tennisMatchSimulator);        
        Assert.assertEquals(expectedScore, actualScore);
    }
    
    @Test
    @Parameters({"3, 3, 5, 5, A new match must be player and the first player who reach the score of 7 wins the match"})
    public void should_display_set_match_new_match_when_p1_is_6_and_p2_is_5(int player1gGamecore, int player2GameScore,
    																		int player1SetScore, int player2SetScore, 
    																		String expectedScore)
    {   	
    	p1.setGameScore(player1gGamecore);
    	p2.setGameScore(player2GameScore);
    	
    	p1.setSetScore(player1SetScore);
    	p2.setSetScore(player2SetScore);    	
    	
    	p1.markOnePoint();
    	
    	Optional<DisplayScore> play = tennisMatchSimulator.getDisplays().stream().filter(d -> d.isActivated(p1, p2)).findAny();
        
        String actualScore = play.get().displayScore(p1, p2, tennisMatchSimulator);        
        Assert.assertEquals(expectedScore, actualScore);
    }
    
    @Test
    @Parameters({"3, 3, 6, 3, true, Player 1 win the Match"})
    public void should_display_set_match_p1_win_the_match_when_p1_is_7_and_p2_is_3_and_new_match(int player1gGamecore, int player2GameScore,
    																		     				 int player1SetScore, int player2SetScore, 
    																		     				 boolean newMatch, String expectedScore)
    {   	
    	p1.setGameScore(player1gGamecore);
    	p2.setGameScore(player2GameScore);
    	
    	p1.setSetScore(player1SetScore);
    	p2.setSetScore(player2SetScore);
    	
    	tennisMatchSimulator.setNewMatchOn(newMatch);
    	
    	p1.markOnePoint();
    	
    	Optional<DisplayScore> play = tennisMatchSimulator.getDisplays().stream().filter(d -> d.isActivated(p1, p2)).findAny();
        
        String actualScore = play.get().displayScore(p1, p2, tennisMatchSimulator);        
        Assert.assertEquals(expectedScore, actualScore);
    }
    
}
