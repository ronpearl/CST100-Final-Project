import java.util.ArrayList;

/** 
* 	Program: My Team
* 	File: MyTeam.java
* 	Summary: Class that builds your selected team
* 	Author: Ronald Pearl
* 	Date: Aug 1, 2016 
**/

public class MyTeam {
	
	public ArrayList<OffensivePlayer> myTeamOffObjects = new ArrayList<OffensivePlayer>();
	public ArrayList<DefensivePlayer> myTeamDefObjects = new ArrayList<DefensivePlayer>();
	
	MyTeam() {
		// Initialize class
	}
	
	/*
	 * Add offensive player
	 */
	public void addOffPlayer(OffensivePlayer player) {
		myTeamOffObjects.add(player);
	}
	
	/*
	 * Returns the arraylist of myteam offensive players
	 */
	public ArrayList<OffensivePlayer> getMyTeamOffense() {
		return myTeamOffObjects;
	}
	
	/*
	 * Returns the arraylist of myteam defensive players
	 */
	public ArrayList<DefensivePlayer> getMyTeamDefense() {
		return myTeamDefObjects;
	}
}