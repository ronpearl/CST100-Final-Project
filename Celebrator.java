/** 
* 	Program: Celebrator Interface
* 	File: Celebrator.java
* 	Summary: 
* 		Students will create an interface which the NFLPlayer class will “implement.” 
* 		This interface will determine the player’s reaction when they are drafted.
* 	Author: Ronald Pearl
* 	Date: July 29, 2016 
**/

public interface Celebrator {
	
	public String[] waysToCelebrate = { "dances", "wiggles", "jumps up and down", "gives a peace sign", 
			"smiles and nods", "gives high fives", "shouts", "drinks his milkshake" };
	
	public void celebrate();
	
}