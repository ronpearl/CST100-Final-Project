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

public class MyTeam {
	
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
			tempListOfPlayers[i] = i + " - " + myTeamOffObjects.get(i).playerName + ",";
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
			tempListOfPlayers[i] = i + " - " + myTeamDefObjects.get(i).playerName + " - " + myTeamDefObjects.get(i).playerPosition;
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
	public void addOffPlayer(OffensivePlayer player) {
		myTeamOffObjects.add(player);
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
	public void addDefPlayer(DefensivePlayer player) {
		myTeamDefObjects.add(player);
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