/** Program: NFL PLayer Manager Class
* File: PlayerManager.java
* Summary: Build Player library for use in Fantasy program
* Author: Ronald Pearl
* Date: July 8, 2016 
**/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.json.simple.parser.JSONParser;

public class PlayerManager {
	
	public ArrayList<OffensivePlayer> offPlayerObjects = new ArrayList<OffensivePlayer>();
	public ArrayList<DefensivePlayer> defPlayerObjects = new ArrayList<DefensivePlayer>();
	
	PlayerManager() {
		createPlayers();
	}
	
	/*
	 * JSON parser to pull from json file and create player array
	 */
	public void createPlayers() {
		JSONParser parser = new JSONParser();
		JSONArray a = null;
		
		try {
			a = (JSONArray) parser.parse(new FileReader("fourNflTeams_PlayerData.json"));
			
			for (Object o : a)
			{
				JSONObject player = (JSONObject) o;
		
				String name = (String) player.get("Name");
				String position = (String) player.get("Position");
				String positionCategory = (String) player.get("PositionCategory");
				String number = String.valueOf(player.get("Number"));
				String team = (String) player.get("Team");
				String tackles = String.valueOf(player.get("Tackles"));
				String sacks = String.valueOf(player.get("Sacks"));
				String safeties = String.valueOf(player.get("Safeties"));
				String receptions = String.valueOf(player.get("Receptions"));
				String fieldGoalsMade = String.valueOf(player.get("FieldGoalsMade"));
				String carries = String.valueOf(player.get("RushingAttempts"));
				String yardsPerCarry = String.valueOf(player.get("RushingYardsPerAttempt"));
				String rushingYards = String.valueOf(player.get("RushingYards"));
				String touchdowns = String.valueOf(player.get("Touchdowns"));
				String interceptions = String.valueOf(player.get("Interceptions"));
				String yardsPerPass = String.valueOf(player.get("PassingYardsPerAttempt"));
				String yardsPerReception = String.valueOf(player.get("ReceivingYardsPerReception"));
				
				// Create player objects based on position
				if (positionCategory.equals("DEF")) {
					DefensivePlayer dPlayer = new DefensivePlayer(name, position, Integer.parseInt(number), team);
					dPlayer.setTackles(Integer.parseInt(tackles));
					dPlayer.setSacks(Double.parseDouble(sacks));
					dPlayer.setSafeties(Integer.parseInt(safeties));
					dPlayer.setInterceptions(Integer.parseInt(interceptions));
					
					// Add player to ArrayList
					defPlayerObjects.add(dPlayer);
				} else {
					OffensivePlayer oPlayer = new OffensivePlayer(name, position, Integer.parseInt(number), team);
					oPlayer.setCarries(Integer.parseInt(carries));
					oPlayer.setFieldGoalsMade(Integer.parseInt(fieldGoalsMade));
					oPlayer.setReceptions(Integer.parseInt(receptions));
					oPlayer.setRushingYards(Integer.parseInt(rushingYards));
					oPlayer.setTouchdowns(Integer.parseInt(touchdowns));
					oPlayer.setYardsPerCarry(Double.parseDouble(yardsPerCarry));
					oPlayer.setYardsPerPass(Double.parseDouble(yardsPerPass));
					oPlayer.setYardsPerReception(Double.parseDouble(yardsPerReception));
					
					// Add player to ArrayList
					offPlayerObjects.add(oPlayer);
				}
			}
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	
	
	/*
	 * Create offensive observable list
	 */
	public ObservableList<String> createAvailOffenseObservableList() {
		String[] tempListOfPlayers = new String[offPlayerObjects.size()];
		
		for (int i = 0; i < offPlayerObjects.size(); i++) {
			tempListOfPlayers[i] = offPlayerObjects.get(i).playerNum + " - " + offPlayerObjects.get(i).playerName + " - " + offPlayerObjects.get(i).playerPosition;
		}
		
		ObservableList<String> theOffObsList = FXCollections.observableArrayList (tempListOfPlayers);
		
		return theOffObsList;
	}
	
	
	/*
	 * Create defensive observable list
	 */
	public ObservableList<String> createAvailDefenseObservableList() {
		String[] tempListOfPlayers = new String[defPlayerObjects.size()];
		
		for (int i = 0; i < defPlayerObjects.size(); i++) {
			tempListOfPlayers[i] = defPlayerObjects.get(i).playerNum + " - " + defPlayerObjects.get(i).playerName + " - " + defPlayerObjects.get(i).playerPosition;
		}
		
		ObservableList<String> theDefObsList = FXCollections.observableArrayList (tempListOfPlayers);
		
		return theDefObsList;
	}
	
	
	/*
	 * Create offense observable list from search parameters
	 */
	public ObservableList<String> createSearchOffenseObservableList(String searchName, String searchTeam, String searchPosition) {
		String[] tempListOfPlayers = new String[0];
		boolean okToAdd = false;
		
		for (int i = 0; i < offPlayerObjects.size(); i++) {			
			if (searchName != "") {
				if ((int) offPlayerObjects.get(i).playerName.toLowerCase().indexOf(searchName.toLowerCase()) >= 0) {
					okToAdd = true;
				}
			}

			if (searchTeam != "Team") {
				if (offPlayerObjects.get(i).playerTeam.equals(searchTeam)) {
					if (okToAdd)
						okToAdd = true;
				} else {
					okToAdd = false;
				}
			}

			if (searchPosition != "Position") {
				if (offPlayerObjects.get(i).playerPosition.equals(searchPosition)) {
					if (okToAdd)
						okToAdd = true;
				} else {
					okToAdd = false;
				}
			}

			if (okToAdd) {
				tempListOfPlayers = Arrays.copyOf(tempListOfPlayers, tempListOfPlayers.length + 1);
				tempListOfPlayers[tempListOfPlayers.length - 1] = offPlayerObjects.get(i).playerNum + " - " + 
						offPlayerObjects.get(i).playerName + " - " + 
						offPlayerObjects.get(i).playerPosition;
			}
			
			// Reset bool
			okToAdd = false;
		}
		
		ObservableList<String> theSearchObsList = FXCollections.observableArrayList(tempListOfPlayers);
		
		return theSearchObsList;
	}
	
	/*
	 * Create defense observable list from search parameters
	 */
	public ObservableList<String> createSearchDefenseObservableList(String searchName, String searchTeam, String searchPosition) {
		String[] tempListOfPlayers = new String[0];
		boolean okToAdd = false;
		
		for (int i = 0; i < defPlayerObjects.size(); i++) {			
			if (searchName != "") {
				if ((int) defPlayerObjects.get(i).playerName.toLowerCase().indexOf(searchName.toLowerCase()) >= 0) {
					okToAdd = true;
				}
			}

			if (searchTeam != "Team") {
				if (defPlayerObjects.get(i).playerTeam.equals(searchTeam)) {
					if (okToAdd)
						okToAdd = true;
				} else {
					okToAdd = false;
				}
			}

			if (searchPosition != "Position") {
				if (defPlayerObjects.get(i).playerPosition.equals(searchPosition)) {
					if (okToAdd)
						okToAdd = true;
				} else {
					okToAdd = false;
				}
			}

			if (okToAdd) {
				tempListOfPlayers = Arrays.copyOf(tempListOfPlayers, tempListOfPlayers.length + 1);
				tempListOfPlayers[tempListOfPlayers.length - 1] = defPlayerObjects.get(i).playerNum + " - " + 
						defPlayerObjects.get(i).playerName + " - " + 
						defPlayerObjects.get(i).playerPosition;
			}
			
			// Reset bool
			okToAdd = false;
		}
		
		ObservableList<String> theSearchObsList = FXCollections.observableArrayList(tempListOfPlayers);
		
		return theSearchObsList;
	}
	
	/*
	 * Removes an offensive player from the list
	 */
	public void removeOffPlayer(String playerToRemove) {
		OffensivePlayer playerObject = null;
		
		for(OffensivePlayer player : offPlayerObjects) {
			if (player.playerName.equals(playerToRemove))
				playerObject = player;
		}
		
		offPlayerObjects.remove(playerObject);
	}
	
	/*
	 * Removes an defensive player from the list
	 */
	public void removeDefPlayer(String playerToRemove) {
		DefensivePlayer playerObject = null;
		
		for(DefensivePlayer player : defPlayerObjects) {
			if (player.playerName.equals(playerToRemove))
				playerObject = player;
		}
		
		defPlayerObjects.remove(playerObject);
	}
	
	/*
	 * Adds an offensive player to the list
	 */
	public void addOffPlayer(OffensivePlayer playerObject) {
		offPlayerObjects.add(playerObject);
	}
	
	/*
	 * Adds a defensive player to the list
	 */
	public void addDefPlayer(DefensivePlayer playerObject) {
		defPlayerObjects.add(playerObject);
	}
	
	/*
	 * Returns a single Offensive players object
	 */
	public OffensivePlayer getOffPlayerObject(String playerName) {
		OffensivePlayer playerObject = null;
		
		for(OffensivePlayer player : offPlayerObjects) {
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
		
		for(DefensivePlayer player : defPlayerObjects) {
			if (player.playerName.equals(playerName))
				playerObject = player;
		}
		
		return playerObject;
	}
}