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
	
	ListView<String> availOffPlayerList = new ListView<String>();
	private ObservableList<String> availOffList;
	ListView<String> availDefPlayerList = new ListView<String>();
	private ObservableList<String> availDefList;
	private Label viewOffPlayerError = new Label();
	private Label viewDefPlayerError = new Label();
	private Button btnViewOffPlayer = new Button("View Off. Player");
	private Button btnViewDefPlayer = new Button("View Def. Player");
	
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
		
		// Fill the available players lists
		availOffList = doPlayerManager.createAvailOffenseObservableList();
		availDefList = doPlayerManager.createAvailDefenseObservableList();
		availOffPlayerList.setItems(availOffList);
		availDefPlayerList.setItems(availDefList);
		
		
		// TEMP.............
		// ADD PLAYERS
		myteam.addOffPlayer(doPlayerManager.offPlayerObjects.get(1));
		myteam.addDefPlayer(doPlayerManager.defPlayerObjects.get(2));
		offList = FXCollections.observableArrayList ("1 - No Players Yet");
		defList = FXCollections.observableArrayList ("1 - No Players Yet");
		offenseTeamList.setItems(offList);
		defenseTeamList.setItems(defList);
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
		
		return vBox; 
	}
	
	/*
	 * Show the details for the selected offensive player
	 */
	private void showOffPlayer() {
		if (availOffPlayerList.getSelectionModel().getSelectedIndex() == -1) {
			viewOffPlayerError.setText("Please select a player");
		} else {
			viewOffPlayerError.setText(" ");
		}
	}
	
	/*
	 * Show the details for the selected defensive player
	 */
	private void showDefPlayer() {
		if (availDefPlayerList.getSelectionModel().getSelectedIndex() == -1) {
			viewDefPlayerError.setText("Please select a player");
		} else {
			viewDefPlayerError.setText(" ");
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
