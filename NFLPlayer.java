/** Program: NFL PLayer Class
* File: NFLPlayer.java
* Summary: Class to create players and their stats
* Author: Ronald Pearl
* Date: July 1, 2016 
**/

public class NFLPlayer {
	// Player Common Stats
	protected String playerName = "";
	protected String playerPosition = "";
	protected int playerNum;
	protected String playerTeam = "";
	
	NFLPlayer(String playerName, String playerPosition, int playerNum, String playerTeam) {
		this.playerName = playerName;
		this.playerPosition = playerPosition;
		this.playerNum = playerNum;
		this.playerTeam = playerTeam;
	}

	// Getters
	public String getPlayerName() {
		return playerName;
	}
	
	public String getPlayerPosition() {
		return playerPosition;
	}
	
	public int getPlayerNum() {
		return playerNum;
	}
	
	public String getPlayerTeam() {
		return playerTeam;
	}
	
	// Setters
	public void setPlayerName(String plyrName) {
		playerName = plyrName;
	}
	
	public void setPlayerPosition(String plyrPosition) {
		playerPosition = plyrPosition;
	}
	
	public void setPlayerNum(int plyrNum) {
		playerNum = plyrNum;
	}
	
	public void setPlayerTeam(String plyrTeam) {
		playerTeam = plyrTeam;
	}
}