import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox; 
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView; 

public class TestPlayerManager extends Application  {
	
	// Build player library
	PlayerManager doPlayerManager = new PlayerManager();
	
	// Setup my team
	private MyTeam myTeam = new MyTeam();
	
	// Left box
	private Button btnOffRemove = new Button("Remove Off. Player");
	private Button btnDefRemove = new Button("Remove Def. Player");
	private Label removeOffPlayerError = new Label();
	private Label removeDefPlayerError = new Label();
	ListView<String> offenseTeamList = new ListView<String>();
	ListView<String> defenseTeamList = new ListView<String>();
	private ObservableList<String> offList;
	private ObservableList<String> defList;
	
	// Right box
	ListView<String> availOffPlayerList = new ListView<String>();
	private ObservableList<String> availOffList;
	ListView<String> availDefPlayerList = new ListView<String>();
	private ObservableList<String> availDefList;
	private Label viewOffPlayerError = new Label();
	private Label viewDefPlayerError = new Label();
	private Button btnViewOffPlayer = new Button("View Off. Player");
	private Button btnViewDefPlayer = new Button("View Def. Player");
	
	// Center box
	private Label playerMainInfo = new Label();
	private Label playerTeam = new Label();
	private Button addOffPlayerBtn = new Button("Add To My Team");
	private Button addDefPlayerBtn = new Button("Add To My Team");
	
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
		
		// Fill the available players lists
		fillPlayerLists();
	}
	
	private void fillPlayerLists() {
		// Fill available player lists
		availOffList = doPlayerManager.createAvailOffenseObservableList();
		availDefList = doPlayerManager.createAvailDefenseObservableList();
		availOffPlayerList.setItems(availOffList);
		availDefPlayerList.setItems(availDefList);
		
		// Fill my team lists
		offList = myTeam.createOffenseObservableList();
		offenseTeamList.setItems(offList);
		defList = myTeam.createDefenseObservableList();
		defenseTeamList.setItems(defList);
	}
	
	private HBox getHBox() {
		HBox hBox = new HBox(15);
		hBox.setPadding(new Insets(15,15,15,15));
		hBox.setStyle("-fx-background-color: grey");
		ImageView imageView = new ImageView(new Image("images/footballLogo.gif"));
		hBox.getChildren().add(imageView);
		
		return hBox;
	}
	
	private VBox getVBoxLeft() {
		VBox vBox = new VBox(5);
		vBox.setPrefWidth(230);
		vBox.setPrefHeight(500);
		vBox.setPadding(new Insets(15,5,5,5));
		
		// Add offense team list
		vBox.getChildren().add(new Label("Your Offense:"));
		offenseTeamList.setMaxHeight(200);
		vBox.getChildren().add(offenseTeamList);
		vBox.getChildren().add(btnOffRemove);
		removeOffPlayerError.setStyle("-fx-text-fill: #FF0000");
		vBox.getChildren().add(removeOffPlayerError);
		
		// Add defense team list
		vBox.getChildren().add(new Label("Your Offense:"));
		defenseTeamList.setMaxHeight(200);
		vBox.getChildren().add(defenseTeamList);
		vBox.getChildren().add(btnDefRemove);
		removeDefPlayerError.setStyle("-fx-text-fill: #FF0000");
		vBox.getChildren().add(removeDefPlayerError);
				
		// Set handler for removePlayer button
		btnOffRemove.setOnAction(e -> removeOffPlayer());
		btnDefRemove.setOnAction(e -> removeDefPlayer());
				
		return vBox; 
	}
	
	private VBox getVBoxRight() {
		VBox vBox = new VBox(5);
		vBox.setPrefWidth(230);
		vBox.setPadding(new Insets(15,5,5,5));
		vBox.getChildren().add(new Label("Available Offense Players::"));
		availOffPlayerList.setMaxHeight(200);
		vBox.getChildren().add(availOffPlayerList);
		vBox.getChildren().add(btnViewOffPlayer);
		viewOffPlayerError.setStyle("-fx-text-fill: #FF0000");
		vBox.getChildren().add(viewOffPlayerError);
		
		vBox.getChildren().add(new Label("Available Defense Players::"));
		availDefPlayerList.setMaxHeight(200);
		vBox.getChildren().add(availDefPlayerList);
		vBox.getChildren().add(btnViewDefPlayer);
		viewDefPlayerError.setStyle("-fx-text-fill: #FF0000");
		vBox.getChildren().add(viewDefPlayerError);
		
		// Set handlers on buttons
		btnViewOffPlayer.setOnAction(e -> showOffPlayer());
		btnViewDefPlayer.setOnAction(e -> showDefPlayer());
		
		return vBox; 
	}
	
	private VBox getVBoxCenter() {
		VBox vBox = new VBox(5);
		vBox.setPrefWidth(460);
		vBox.setPrefHeight(500);
		vBox.setPadding(new Insets(15,5,5,5));
		vBox.getChildren().add(new Label("Player Details:"));
		
		// Setup grid for the stats
		GridPane grid = new GridPane();
		
		playerMainInfo.setFont(Font.font ("Verdana", 20));
		playerMainInfo.setText("Select a Player");
		
		grid.add(playerMainInfo, 0, 0);
		grid.add(playerTeam, 0, 1);
		
		grid.add(addOffPlayerBtn, 0, 4);
		addOffPlayerBtn.setVisible(false);
		grid.add(addDefPlayerBtn, 0, 4);
		addDefPlayerBtn.setVisible(false);
		
		vBox.getChildren().add(grid);
		
		// Set handlers on buttons
		addOffPlayerBtn.setOnAction(e -> addOffPlayerToMyTeam());
		addDefPlayerBtn.setOnAction(e -> addDefPlayerToMyTeam());
		
		return vBox; 
	}
	
	private void removeOffPlayer() {
		// Make sure a player is selected to be removed
		if (offenseTeamList.getSelectionModel().getSelectedIndex() == -1) {
			removeOffPlayerError.setText("Please select a player");
		} else {
			// Get the selected players name
			String[] parts = offenseTeamList.getSelectionModel().getSelectedItem().split(" - ");
			
			// Add player to available list
			doPlayerManager.addOffPlayer(myTeam.getOffPlayerObject(parts[1]));
			
			// Remove player from our team
			int playerIndexToRemove = offenseTeamList.getSelectionModel().getSelectedIndex();
			myTeam.removeOffPlayer(playerIndexToRemove);
			
			// Fill Player Lists
			fillPlayerLists();
			
			removeOffPlayerError.setText("Player Removed");
		}
	}
	
	private void removeDefPlayer() {
		// Make sure a player is selected to be removed
		if (defenseTeamList.getSelectionModel().getSelectedIndex() == -1) {
			removeDefPlayerError.setText("Please select a player");
		} else {
			// Get the selected players name
			String[] parts = defenseTeamList.getSelectionModel().getSelectedItem().split(" - ");
			
			// Add player to available list
			doPlayerManager.addDefPlayer(myTeam.getDefPlayerObject(parts[1]));
			
			// remove the player
			int playerIndexToRemove = defenseTeamList.getSelectionModel().getSelectedIndex();
			myTeam.removeDefPlayer(playerIndexToRemove);
			
			// Fill Player Lists
			fillPlayerLists();
			
			removeDefPlayerError.setText("Player Removed");
			
		}
	}

	
	/*
	 * Show the details for the selected offensive player
	 */
	private void showOffPlayer() {
		if (availOffPlayerList.getSelectionModel().getSelectedIndex() == -1) {
			viewOffPlayerError.setText("Please select a player");
		} else {
			addDefPlayerBtn.setVisible(false);
			viewOffPlayerError.setText(" ");
			
			// Get the selected player and split up the string to pull the name out
			String[] parts = availOffPlayerList.getSelectionModel().getSelectedItem().split(" - ");
			
			OffensivePlayer playerToView = doPlayerManager.getOffPlayerObject(parts[1]);
			
			playerMainInfo.setText(String.valueOf(playerToView.playerNum) + " - " + playerToView.playerName + " - " + playerToView.playerPosition);
			playerTeam.setText(playerToView.playerTeam);
			
			addOffPlayerBtn.setVisible(true);
		}
	}
	
	/*
	 * Show the details for the selected defensive player
	 */
	private void showDefPlayer() {
		if (availDefPlayerList.getSelectionModel().getSelectedIndex() == -1) {
			viewDefPlayerError.setText("Please select a player");
		} else {
			addOffPlayerBtn.setVisible(false);
			
			viewDefPlayerError.setText(" ");
			
			// Get the selected player and split up the string to pull the name out
			String[] parts = availDefPlayerList.getSelectionModel().getSelectedItem().split(" - ");
			
			DefensivePlayer playerToView = doPlayerManager.getDefPlayerObject(parts[1]);
			
			playerMainInfo.setText(String.valueOf(playerToView.playerNum) + " - " + playerToView.playerName + " - " + playerToView.playerPosition);
			playerTeam.setText(playerToView.playerTeam);
			
			addDefPlayerBtn.setVisible(true);
		}
	}
	
	private void addOffPlayerToMyTeam() {
		// Get the selected players name
		String[] parts = availOffPlayerList.getSelectionModel().getSelectedItem().split(" - ");

		// Add player to my team
		myTeam.addOffPlayer(doPlayerManager.getOffPlayerObject(parts[1]));
		
		// remove the player from the available list
		doPlayerManager.removeOffPlayer(parts[1]);
		
		// Fill Player Lists
		fillPlayerLists();
		
		// hide the button
		addOffPlayerBtn.setVisible(false);
	}
	
	
	private void addDefPlayerToMyTeam() {
		// Get the selected players name
		String[] parts = availDefPlayerList.getSelectionModel().getSelectedItem().split(" - ");

		// Add player to my team
		myTeam.addDefPlayer(doPlayerManager.getDefPlayerObject(parts[1]));
		
		// remove the player from the available list
		doPlayerManager.removeDefPlayer(parts[1]);
		
		// Fill Player Lists
		fillPlayerLists();
		
		// hide the button
		addDefPlayerBtn.setVisible(false);
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
