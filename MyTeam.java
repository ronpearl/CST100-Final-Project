/** 
* 	Program: My Team
* 	File: MyTeam.java
* 	Summary: Class that builds your selected team
* 	Author: Ronald Pearl
* 	Date: Aug 1, 2016 
**/

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MyTeam extends PlayerManager {
	
	public ArrayList<OffensivePlayer> myTeamOffObjects = new ArrayList<OffensivePlayer>();
	public ArrayList<DefensivePlayer> myTeamDefObjects = new ArrayList<DefensivePlayer>();
	
	MyTeam() {
		// Initialize class
	}
	
	/*
	 * Create offense observable list
	 */
	public ObservableList<String> createOffenseObservableList() {
		String[] tempListOfPlayers = new String[myTeamOffObjects.size()];
		
		for (int i = 0; i < myTeamOffObjects.size(); i++) {
			tempListOfPlayers[i] = myTeamOffObjects.get(i).playerNum + " - " + myTeamOffObjects.get(i).playerName + " - " + myTeamOffObjects.get(i).playerPosition;
		}
		
		ObservableList<String> theOffObsList = FXCollections.observableArrayList (tempListOfPlayers);
		
		return theOffObsList;
	}
	
	/*
	 * Create defense observable list
	 */
	public ObservableList<String> createDefenseObservableList() {
		String[] tempListOfPlayers = new String[myTeamDefObjects.size()];
		
		for (int i = 0; i < myTeamDefObjects.size(); i++) {
			tempListOfPlayers[i] = myTeamDefObjects.get(i).playerNum + " - " + myTeamDefObjects.get(i).playerName + " - " + myTeamDefObjects.get(i).playerPosition;
		}
		
		ObservableList<String> theDefObsList = FXCollections.observableArrayList (tempListOfPlayers);
		
		return theDefObsList;
	}
	
	/*
	 * Remove offensive player
	 */
	public void removeOffPlayer(int index) {
		myTeamOffObjects.remove(index);
	}
	
	/*
	 * Add offensive player
	 */
	public void addOffPlayer(OffensivePlayer playerObject) {
		myTeamOffObjects.add(playerObject);
	}
	
	/*
	 * Remove defensive player
	 */
	public void removeDefPlayer(int index) {
		myTeamDefObjects.remove(index);
	}
	
	/*
	 * Add defensive player
	 */
	public void addDefPlayer(DefensivePlayer playerObject) {
		myTeamDefObjects.add(playerObject);
	}
	
	/*
	 * Returns a single Offensive player object
	 */
	public OffensivePlayer getOffPlayerObject(String playerName) {
		OffensivePlayer playerObject = null;
		
		for(OffensivePlayer player : myTeamOffObjects) {
			if (player.playerName.equals(playerName))
				playerObject = player;
		}
		
		return playerObject;
	}
	
	/*
	 * Returns a single Defensive player object
	 */
	public DefensivePlayer getDefPlayerObject(String playerName) {
		DefensivePlayer playerObject = null;
		
		for(DefensivePlayer player : myTeamDefObjects) {
			if (player.playerName.equals(playerName))
				playerObject = player;
		}
		
		return playerObject;
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