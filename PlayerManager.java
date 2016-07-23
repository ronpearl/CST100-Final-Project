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

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
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
				if (positionCategory == "DEF") {
					DefensivePlayer dPlayer = new DefensivePlayer(name, position, Integer.parseInt(number), team);
					dPlayer.setTackles(Integer.parseInt(tackles));
					dPlayer.setSacks(Integer.parseInt(sacks));
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
	 * Returns the arraylist of Offensive players
	 */
	public ArrayList<OffensivePlayer> getOffPlayerList() {
		return offPlayerObjects;
	}
	
	
	/*
	 * Returns the arraylist of Defensive players
	 */
	public ArrayList<DefensivePlayer> getDefPlayerList() {
		return defPlayerObjects;
	}
}