import java.util.ArrayList;

public class TestPlayerManager {
	public static void main(String[] args) {
		PlayerManager doPlayerManager = new PlayerManager();
		ArrayList<OffensivePlayer> offPlayerObjects = doPlayerManager.getOffPlayerList();
		ArrayList<DefensivePlayer> defPlayerObjects = doPlayerManager.getDefPlayerList();
		
		// Print out all Players
		printOffensivePlayers(offPlayerObjects);
		printDefensivePlayers(defPlayerObjects);
	}
	
	/*
	 * 	printOffensivePlayers(ArrayList<OffensivePlayer> offPlayers)
	 * 
	 * Print out list for the Offensive players info
	 */
	public static void printOffensivePlayers(ArrayList<OffensivePlayer> offPlayers) {
		for (int i = 0; i < offPlayers.size(); i++) {
			System.out.print(
				"Name: " + offPlayers.get(i).getPlayerName() + "\t" +
				"Position: " + offPlayers.get(i).getPlayerPosition() + "\t" +
				"Number: " + offPlayers.get(i).getPlayerNum() + "\t" +
				"Team: " + offPlayers.get(i).getPlayerTeam() +
				"\n"
			);
		}
	}
	
	/*
	 * 	printDefensivePlayers(ArrayList<DefensivePlayer> defPlayers)
	 * 
	 * Print out list for the Defensive players info
	 */
	public static void printDefensivePlayers(ArrayList<DefensivePlayer> defPlayers) {
		for (int i = 0; i < defPlayers.size(); i++) {
			System.out.print(
					"Name: " + defPlayers.get(i).getPlayerName() + "\t" +
					"Position: " + defPlayers.get(i).getPlayerPosition() + "\t" +
					"Number: " + defPlayers.get(i).getPlayerNum() + "\t" +
					"Team: " + defPlayers.get(i).getPlayerTeam() +
					"\n"
				);
		}
	}
}