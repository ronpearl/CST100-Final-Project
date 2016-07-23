public class TestPlayerManager {
	public static void main(String[] args) {
		PlayerManager doPlayerManager = new PlayerManager();
		String[][] playerStatsArray = doPlayerManager.getPlayerArray();
				
		for (int i = 0; i < playerStatsArray.length; i++) {
			for (int j = 0; j < playerStatsArray[i].length; j++) {
				switch(j) {
					case 0:
						System.out.print("Name: ");
						break;
					case 1:
						System.out.print("Position: ");
						break;
					case 2:
						System.out.print("Position Category: ");
						break;
					case 3:
						System.out.print("Number: ");
						break;
					case 4:
						System.out.print("Team: ");
						break;
					case 5:
						System.out.print("Tackles: ");
						break;
					case 6:
						System.out.print("Sacks: ");
						break;
					case 7:
						System.out.print("Safeties: ");
						break;
					case 8:
						System.out.print("Receptions: ");
						break;
					case 9:
						System.out.print("FG's Made: ");
						break;
					case 10:
						System.out.print("Rushing Attempts: ");
						break;
					case 11:
						System.out.print("Rushing Yards Per Attempt: ");
						break;
					case 12:
						System.out.print("Rushing Yards: ");
						break;
					case 13:
						System.out.print("Touchdowns: ");
						break;
					case 14:
						System.out.print("Interceptions: ");
						break;
					case 15:
						System.out.print("Passing Yards Per Attempt: ");
						break;
					case 16:
						System.out.print("Receiving Yards Per Reception: ");
						break;
				}
				
				System.out.println(playerStatsArray[i][j]);
			}
			
			System.out.println("\n");
		}
	}
}