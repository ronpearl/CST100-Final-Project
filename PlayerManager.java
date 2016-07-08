/** Program: NFL PLayer Manager Class
* File: PlayerManager.java
* Summary: Build Player library for use in Fantasy program
* Author: Ronald Pearl
* Date: July 8, 2016 
**/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class PlayerManager {
	static String[][] playerStats = new String[243][15];
	
	PlayerManager() {
		createPlayers();
	}
	
	/*
	 * JSON parser to pull from json file and create player array
	 */
	public static void createPlayers() {
		JSONParser parser = new JSONParser();
		JSONArray a = null;
		
		try {
			a = (JSONArray) parser.parse(new FileReader("fourNflTeams_PlayerData.json"));
			int playerCounter = 0;
			
			for (Object o : a)
			{
				JSONObject player = (JSONObject) o;
		
				String name = (String) player.get("Name");
				String position = (String) player.get("Position");
				String number = String.valueOf(player.get("Number"));
				String team = (String) player.get("Team");
		//		String status = (String) player.get("");
				String tackles = String.valueOf(player.get("Tackles"));
				String sacks = String.valueOf(player.get("Sacks"));
				String receptions = String.valueOf(player.get("Receptions"));
				String fieldGoalsMade = String.valueOf(player.get("FieldGoalsMade"));
				String carries = String.valueOf(player.get("RushingAttempts"));
				String yardsPerCarry = String.valueOf(player.get("RushingYardsPerAttempt"));
				String rushingYards = String.valueOf(player.get("RushingYards"));
				String touchdowns = String.valueOf(player.get("Touchdowns"));
				String interceptions = String.valueOf(player.get("Interceptions"));
				String yardsPerPass = String.valueOf(player.get("PassingYardsPerAttempt"));
				String yardsPerReception = String.valueOf(player.get("ReceivingYardsPerReception"));
				
				String[] playerStatsArray = {name, position, number, team, tackles, sacks, receptions, fieldGoalsMade, 
					carries, yardsPerCarry, rushingYards, touchdowns, interceptions, yardsPerPass, yardsPerReception
				};
								
				for(int i = 0; i < playerStatsArray.length; i++) {
					playerStats[playerCounter][i] = playerStatsArray[i];
				}
				
				playerCounter++;
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
	 * Returns the array of players
	 */
	public String[][] getPlayerArray() {
		return playerStats;
	}
}