package kata.tennis.model;

import lombok.Data;

/**
 * @author Nihal
 *
 */
@Data
public class Player {
	private String name;
	
	private Integer gameScore=0;
	private Integer setScore=0;
	private Integer tieBreakScore=0;
	
	private boolean adv=false;
	
	public Player(String name) {
		this.name = name;
	}
	
	public void resetAllScores () {
		this.gameScore = 0;
		this.setScore = 0;
		this.tieBreakScore = 0;
		
		this.adv = false;
	}
	
	public void markOnePoint () {
		this.gameScore = this.gameScore +1;
		
		if (this.gameScore > 3) {
        	this.adv = true;
        	this.setScore = this.setScore +1;
        	this.tieBreakScore = this.tieBreakScore +1;
		}
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
	                return "not found";
	        }
	}
}
