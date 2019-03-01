package application;
	
import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Game extends Application {

	
	Stage window;
	Scene menusc, opening, loadsc, helpsc;
	
	@Override
	public void start(Stage primaryStage) {
		try {	
			window = primaryStage;
			
			/// Menu Screen 
			
			BorderPane menu = new BorderPane();
			menusc = new Scene(menu,1280,720);
			
			Text title = new Text("Tip to the Top");
			title.setFont(new Font(120));
			
			VBox menuButtons = new VBox(20);
			Button newGame = new Button("New Game");
			Button loadGame = new Button("Load Game");
			Button help = new Button("Help");
			
			
			// Event handling for menu buttons
			
			newGame.setOnAction(e -> window.setScene(opening));
			loadGame.setOnAction(e -> window.setScene(loadsc));
			help.setOnAction(e -> window.setScene(helpsc));
			
			// Styling menu buttons
			
			newGame.setStyle("-fx-font: 30 arial;");
			loadGame.setStyle("-fx-font: 30 arial;");
			help.setStyle("-fx-font: 30 arial;");
			
			menuButtons.getChildren().addAll(newGame, loadGame, help);

		
			// for Insets, it goes (top, right, bottom, left)
			
			menu.setCenter(menuButtons);
			menu.setTop(title);
			BorderPane.setMargin(menuButtons, new Insets(40,0,0,150));
			BorderPane.setMargin(title, new Insets(70, 0, 0, 120));
			
			String image = Game.class.getResource("west.jpg").toExternalForm();
			menu.setStyle("-fx-background-image: url('" + image + "'); " +
			           "-fx-background-position: center center; " +
			           "-fx-background-repeat: stretch;");
			
			// Opening Scene
			Pane openingPane = new Pane();
			opening = new Scene(openingPane,1280,720);
			Text placeholder = new Text("Hello!");
			placeholder.setFont(new Font(50));
			placeholder.setLayoutX(50);
			placeholder.setLayoutY(50); 

			openingPane.getChildren().addAll(placeholder);
			
			// Load Screen
			
			BorderPane loadScreen = new BorderPane();
			loadsc = new Scene (loadScreen, 1280, 720);
			Button backToMenuL = new Button("Back to the menu");
			backToMenuL.setOnAction(e -> window.setScene(menusc));
			loadScreen.setBottom(backToMenuL);
			
			
			// Help Screen
			BorderPane helpScreen = new BorderPane();
			helpsc = new Scene(helpScreen, 1280,720);
			Button backToMenuH = new Button("Back to the menu");
			backToMenuH.setOnAction(e -> window.setScene(menusc));
			helpScreen.setBottom(backToMenuH);
		
			
			menusc.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			window.setScene(menusc);
			window.setTitle("Tip to the Top");
			window.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		boolean textV = false;
		
		if (textV == false) {
			launch(args);
		}
		else {
			
		}
	}
}
