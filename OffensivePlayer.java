/** 
* 	Program: Offensive Player Class
* 	File: OffensivePlayer.java
* 	Summary: Class that builds an offensive player and their stats
* 	Author: Ronald Pearl
* 	Date: July 23, 2016 
**/

import java.util.Random;

public class OffensivePlayer extends NFLPlayer implements Celebrator {
	
	protected int receptions = 0;
	protected int fieldGoalsMade = 0;
	protected int carries = 0;
	protected double yardsPerCarry = 0;
	protected int rushingYards = 0;
	protected int touchdowns = 0;
	protected double yardsPerPass = 0;
	protected double yardsPerReception = 0;
	// overrides
	protected String playerName = "";
	protected int playerNum;
	
	OffensivePlayer(String playerName, String playerPosition, int playerNum, String playerTeam) {
		super(playerPosition, playerTeam);
		setPlayerName(playerName);
		setPlayerNum(playerNum);
	}
	
	// Celebrate method from Celebrator interface
	public String celebrate() {
		// Get random celebrate option
		int celebRandomInt = new Random().nextInt(Celebrator.waysToCelebrate.length);
		String randCelebration = (Celebrator.waysToCelebrate[celebRandomInt]);
		
		return this.playerName + " " + randCelebration + " to celebrate his draft!";
	}
	
	public int getReceptions() {
		return receptions;
	}
	
	public int getFieldGoalsMade() {
		return fieldGoalsMade;
	}
	
	public int getCarries() {
		return carries;
	}
	
	public double getYardsPerCarry() {
		return yardsPerCarry;
	}
	
	public int getTotalYards() {
		return rushingYards;
	}
	
	public int getTouchdowns() {
		return touchdowns;
	}
	
	public double getYardsPerPass() {
		return yardsPerPass;
	}
	
	public double getYardsPerReception() {
		return yardsPerReception;
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
	public void setReceptions(int plyrReceptions) {
		receptions = plyrReceptions;
	}
	
	public void setFieldGoalsMade(int plyrFGMade) {
		fieldGoalsMade = plyrFGMade;
	}
	
	public void setCarries(int plyrCarries) {
		carries = plyrCarries;
	}
	
	public void setYardsPerCarry(double plyrYPC) {
		yardsPerCarry = plyrYPC;
	}
	
	public void setRushingYards(int plyrTotalYds) {
		rushingYards = plyrTotalYds;
	}
	
	public void setTouchdowns(int plyrTDs) {
		touchdowns = plyrTDs;
	}
	
	public void setYardsPerPass(double plyrYPP) {
		yardsPerPass = plyrYPP;
	}
	
	public void setYardsPerReception(double plyrYPR) {
		yardsPerReception = plyrYPR;
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