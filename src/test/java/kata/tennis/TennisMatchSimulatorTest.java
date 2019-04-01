package kata.tennis;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import kata.tennis.model.Player;

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
    	this.p1 = new Player();
    	this.p2 = new Player();
    	this.tennisMatchSimulator = new TennisMatchSimulator(this.p1, this.p2);
    }
    
    @After
    public void resetAllPlayersScores () {
    	tennisMatchSimulator.resetAllPlayersScores();
    }
  
    @Test
    public void it_should_start_with_zero_score() {
	    Assert.assertEquals(0, p1.getGameScore().intValue());
	    Assert.assertEquals(0, p2.getGameScore().intValue());
    }

    @Test
    public void it_should_display_players_score() {
    	p1.markOnePoint();
	    p2.markOnePoint();
	    p1.markOnePoint();
	
	    Assert.assertEquals("30-15", p1.getScoreGameFromPoint()+"-"+p2.getScoreGameFromPoint());
    }
    
    @Test
    public void it_should_have_no_more_than_2_players() {
	    Assert.assertEquals(2, tennisMatchSimulator.getPlayers().size());
    }
}
