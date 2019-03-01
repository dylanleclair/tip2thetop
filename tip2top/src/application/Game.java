package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Game extends Application {

	int clickCount = 9;
	Stage window;
	Scene menusc, opening, loadsc, helpsc;
	
	
	/**
	 * Loads opening scene onto a StackPane
	 * @param pane - the stackpane to load images onto, from back to front.
	 */
	public static void loadOpening (StackPane pane) {
		for (int i = 10; i >= 1; i--) {
			Image image;
			try {
				image = new Image(new FileInputStream("./src/application/introimg/screen" + i + ".jpg"));
			    ImageView imageView = new ImageView(image); 
			    pane.getChildren().add(imageView);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}  
		}
	}
	/**
	 * Translates a node downward and off of the screen. 
	 * @param node a node, to be translated off the screen.
	 */
	public static void fadeImageDown (Node node) {
		TranslateTransition translate = new TranslateTransition();
		translate.setDuration(Duration.millis(3000)); 
		translate.setNode(node);
		translate.setByY(720);
		translate.setCycleCount(1); 
		translate.setAutoReverse(false); 
		translate.play(); 
	}
	
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
			StackPane openingPane = new StackPane();
			opening = new Scene(openingPane,1280,720);
		    
			loadOpening(openingPane);
			opening.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			    @Override
			    public void handle(MouseEvent mouseEvent) {
			    	fadeImageDown(openingPane.getChildren().get(clickCount));
			    	clickCount--;
			    }
			});
			
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
