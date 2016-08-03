import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox; 
import javafx.scene.layout.VBox; 
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView; 

public class TestPlayerManager extends Application  {
	
	private MyTeam myteam = new MyTeam();
	private Button btnOffRemove = new Button("Remove Off. Player");
	private Button btnDefRemove = new Button("Remove Def. Player");
	private Label removeOffPlayerError = new Label();
	private Label removeDefPlayerError = new Label();
	ListView<String> offenseTeamList = new ListView<String>();
	ListView<String> defenseTeamList = new ListView<String>();
	private ObservableList<String> offList;
	private ObservableList<String> defList;
	
	@Override
	public void start(Stage primaryStage) {
		// Create a border pane 
		BorderPane pane = new BorderPane();
		
		pane.setTop(getHBox());
		pane.setLeft(getVBoxLeft());
		pane.setCenter(getVBoxCenter());
		pane.setRight(getVBoxRight());
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("NFL Player Draft");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// Build player library
		PlayerManager doPlayerManager = new PlayerManager();
		
		// TEMP.............
		// ADD PLAYERS
		myteam.addOffPlayer(doPlayerManager.offPlayerObjects.get(1));
		myteam.addDefPlayer(doPlayerManager.defPlayerObjects.get(2));
		offList = FXCollections.observableArrayList ("1 - No Players Yet");
		defList = FXCollections.observableArrayList ("1 - No Players Yet");
		offenseTeamList.setItems(offList);
		defenseTeamList.setItems(defList);
		
		
		
//		PlayerManager doPlayerManager = new PlayerManager();
//		ArrayList<OffensivePlayer> offPlayerObjects = doPlayerManager.getOffPlayerList();
//		ArrayList<DefensivePlayer> defPlayerObjects = doPlayerManager.getDefPlayerList();
//		
//		// Print out all Players
//		printOffensivePlayers(offPlayerObjects);
//		printDefensivePlayers(defPlayerObjects);
	}
	
	private HBox getHBox() {
		HBox hBox = new HBox(15);
		hBox.setPadding(new Insets(15,15,15,15));
		hBox.setStyle("-fx-background-color: grey");
//		hBox.getChildren().add(new Button("Computer Science"));
//		hBox.getChildren().add(new Button("Chemistry"));
		ImageView imageView = new ImageView(new Image("images/footballLogo.gif"));
		hBox.getChildren().add(imageView);
		
		return hBox;
	}
	
	private VBox getVBoxLeft() {
		VBox vBox = new VBox(5);
		vBox.setPrefWidth(180);
		vBox.setPrefHeight(500);
		vBox.setPadding(new Insets(15,5,5,5));
		vBox.getChildren().add(new Label("Your Team:"));
		
		// Add offense team list
//		ObservableList<String> tempItems = FXCollections.observableArrayList ("1 - No Players Yet");
//		theTeam.setItems(tempItems);
		vBox.getChildren().add(offenseTeamList);
		vBox.getChildren().add(btnOffRemove);
		removeOffPlayerError.setStyle("-fx-text-fill: #FF0000");
		vBox.getChildren().add(removeOffPlayerError);
		
		// Add defense team list
		vBox.getChildren().add(defenseTeamList);
		vBox.getChildren().add(btnDefRemove);
		removeDefPlayerError.setStyle("-fx-text-fill: #FF0000");
		vBox.getChildren().add(removeDefPlayerError);
		
		// Add grid for the removal button/textbox
//		GridPane grid = new GridPane();
//		grid.setHgap(10);
//		grid.add(btnRemove, 1, 0);
//		vBox.getChildren().add(grid);
		
		
		
		// Set handler for removePlayer button
		btnOffRemove.setOnAction(e -> removeOffPlayer());
		btnDefRemove.setOnAction(e -> removeDefPlayer());
				
		return vBox; 
	}
	
	private void removeOffPlayer() {
		// Make sure a player is selected to be removed
		if (offenseTeamList.getSelectionModel().getSelectedIndex() == -1) {
			removeOffPlayerError.setText("Please select a player");
		} else {
			int playerIndexToRemove = offenseTeamList.getSelectionModel().getSelectedIndex();
			
			// remove the player
			myteam.removeOffPlayer(playerIndexToRemove);
			
			// Create new observable list for view
			offList = myteam.createOffenseObservableList();
			
			// Show the new list
			offenseTeamList.setItems(offList);
			
			// TODO: Remove the player and re-do the list
			removeOffPlayerError.setText("Player Removed");
		}
	}
	
	private void removeDefPlayer() {
		// Make sure a player is selected to be removed
		if (defenseTeamList.getSelectionModel().getSelectedIndex() == -1) {
			removeDefPlayerError.setText("Please select a player");
		} else {
			int playerIndexToRemove = defenseTeamList.getSelectionModel().getSelectedIndex();
			
			// remove the player
			myteam.removeDefPlayer(playerIndexToRemove);
			
			// Create new observable list for view
			defList = myteam.createDefenseObservableList();
			
			// Show the new list
			defenseTeamList.setItems(defList);
			
			// TODO: Remove the player and re-do the list
			removeDefPlayerError.setText("Player Removed");
			
		}
	}
	
	private VBox getVBoxRight() {
		VBox vBox = new VBox(5);
		vBox.setPrefWidth(200);
		vBox.setPadding(new Insets(15,5,5,5));
		vBox.getChildren().add(new Label("Courses"));
		Label[] courses = {new Label("CSCI 1301"),new Label("CSCI 1302"),new Label("CSCI 2410"),new Label("CSCI 3720")};
		
		for (Label course: courses) {
			VBox.setMargin(course, new Insets(0,0,0,15));
			vBox.getChildren().add(course);
		}
		
		return vBox; 
	}
	
	private VBox getVBoxCenter() {
		VBox vBox = new VBox(5);
		vBox.setPrefWidth(300);
		vBox.setPrefHeight(500);
		vBox.setPadding(new Insets(15,5,5,5));
		vBox.getChildren().add(new Label("Player Details:"));
		
		return vBox; 
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
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
