import java.util.Random;

/** 
* 	Program: Defensive Player Class
* 	File: DefensivePlayer.java
* 	Summary: Class that builds a defensive player and their stats
* 	Author: Ronald Pearl
* 	Date: July 23, 2016 
**/

public class DefensivePlayer extends NFLPlayer implements Celebrator {
	
	protected int tackles = 0;
	protected double sacks = 0;
	protected int safeties = 0;
	protected int interceptions = 0;
	// overrides
	protected String playerName = "";
	protected int playerNum;
	
	DefensivePlayer(String playerName, String playerPosition, int playerNum, String playerTeam) {
		super(playerPosition, playerTeam);
		setPlayerName(playerName);
		setPlayerNum(playerNum);
	}
	
	// Celebrate method from Celebrator interface
	public void celebrate() {
		// Get random celebrate option
		int celebRandomInt = new Random().nextInt(Celebrator.waysToCelebrate.length);
		String randCelebration = (Celebrator.waysToCelebrate[celebRandomInt]);
		
		System.out.println(this.playerName + " " + randCelebration + " to celebrate his draft!");
	}
	
	// Getters
	public int getTackles() {
		return tackles;
	}
	
	public double getSacks() {
		return sacks;
	}
	
	public int getSafeties() {
		return safeties;
	}
	
	public int getInterceptions() {
		return interceptions;
	}
	
	@Override
	public String getPlayerName() {
		return playerName;
	}
	
	@Override
	public int getPlayerNum() {
		return playerNum;
	}
	
	
	// Setters
	public void setTackles(int plyrTackles) {
		tackles = plyrTackles;
	}
	
	public void setSacks(double plyrSacks) {
		sacks = plyrSacks;
	}
	
	public void setSafeties(int plyrSafeties) {
		safeties = plyrSafeties;
	}
	
	public void setInterceptions(int plyrInt) {
		interceptions = plyrInt;
	}
	
	@Override
	public void setPlayerName(String plyrName) {
		playerName = plyrName;
	}
	
	@Override
	public void setPlayerNum(int plyrNum) {
		playerNum = plyrNum;
	}
}