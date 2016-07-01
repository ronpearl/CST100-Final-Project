/** Program: NFL PLayer Class
* File: NFLPlayer.java
* Summary: Class to create players and their stats
* Author: Ronald Pearl
* Date: July 1, 2016 
**/

public class NFLPlayer {
	// Player Common Stats
	private String playerName = "";
	private String playerPosition = "";
	private Int playerNum = "";
	private String playerTeam = "";
	private String playerStatus = "ACT";

	// Player stats based on position
	private int tackles = 0;
	private int sacks = 0;
	private int receptions = 0;
	private int fieldGoalsMade = 0;
	private int carries = 0;
	private int yardsPerCarry = 0;
	private int totalYards = 0;
	private int touchdowns = 0;
	private int interceptions = 0;

	NFLPlayer() {
		// Instansiate class
	}

	// Getters
	public String getPlayerName() {
		return playerName;
	}
	public String getPlayerPosition() {
		return playerPosition;
	}
	public Int getPlayerNum() {
		return playerNum;
	}
	public String getPlayerTeam() {
		return playerTeam;
	}
	public String getPlayerStatus() {
		return playerStatus;
	}
	public int getTackles() {
		return tackles;
	}
	public int getSacks() {
		return sacks;
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
	public int getYardsPerCarry() {
		return yardsPerCarry;
	}
	public int getTotalYards() {
		return totalYards;
	}
	public int getTouchdowns() {
		return touchdowns;
	}
	public int getInterceptions() {
		return interceptions;
	}

	// Setters
	public void setPlayerName(String plyrName) {
		playerName = plyrName;
	}
	public void setPlayerPosition(String plyrPosition) {
		playerPosition = plyrPosition;
	}
	public void setPlayerNum(Int plyrNum) {
		playerNum = plyrNum;
	}
	public void setPlayerTeam(String plyrTeam) {
		playerTeam = plyrTeam;
	}
	public void setPlayerStatus(String plyrStatus) {
		playerStatus = plyrStatus;
	}
	public void setTackles(int plyrTackles) {
		tackles = plyrTackles;
	}
	public void setSacks(int plyrSacks) {
		sacks = plyrSacks;
	}
	public void setReceptions(int plyrReceptions) {
		receptions = plyrReceptions;
	}
	public void setFieldGoalsMade(int plyrFGMade) {
		fieldGoalsMade = plyrFGMade;
	}
	public void setCarries(int plyrCarries) {
		carries = plyrCarries;
	}
	public void setYardsPerCarry(int plyrYPC) {
		yardsPerCarry = plyrYPC;
	}
	public void setTotalYards(int plyrTotalYds) {
		totalYards = plyrTotalYds;
	}
	public void setTouchdowns(int plyrTDs) {
		touchdowns = plyrTDs;
	}
	public void setInterceptions(int plyrInt) {
		interceptions = plyrInt;
	}
}