/** 
* 	Program: Defensive Player Class
* 	File: DefensivePlayer.java
* 	Summary: Class that builds a defensive player and their stats
* 	Author: Ronald Pearl
* 	Date: July 23, 2016 
**/

public class DefensivePlayer extends NFLPlayer {
	
	protected int tackles = 0;
	protected int sacks = 0;
	protected int safeties = 0;
	protected int interceptions = 0;
	
	DefensivePlayer(String playerName, String playerPosition, int playerNum, String playerTeam) {
		super(playerName, playerPosition, playerNum, playerTeam);
	}
	
	// Getters
	public int getTackles() {
		return tackles;
	}
	
	public int getSacks() {
		return sacks;
	}
	
	public int getSafeties() {
		return safeties;
	}
	
	public int getInterceptions() {
		return interceptions;
	}
	
	// Setters
	public void setTackles(int plyrTackles) {
		tackles = plyrTackles;
	}
	
	public void setSacks(int plyrSacks) {
		sacks = plyrSacks;
	}
	
	public void setSafeties(int plyrSafeties) {
		safeties = plyrSafeties;
	}
	
	public void setInterceptions(int plyrInt) {
		interceptions = plyrInt;
	}
}