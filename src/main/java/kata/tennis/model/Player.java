package kata.tennis.model;

import lombok.Data;

/**
 * @author Nihal
 *
 */
@Data
public class Player {
	private Integer gameScore=0;
	
	public Player() {
	}
	
	public void resetAllScores () {
		this.gameScore = 0;
	}
	
	public void markOnePoint () {
        this.gameScore++;
    }
	
	public String getScoreGameFromPoint() {
	        switch (this.gameScore) {
	            case 0:
	                return "0";
	            case 1:
	                return "15";
	            case 2:
	                return "30";
	            case 3:
	                return "40";
	            default:
	                return null;
	        }
	}
}
