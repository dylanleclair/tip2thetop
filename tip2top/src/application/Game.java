package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.Animation.Status;
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

	int clickCount = 9; // starts at 9, since stackpane loads from front to back. 
	Stage window;
	Scene menusc, opening, loadsc, helpsc;
	
	
	/**
	 * Loads opening scene onto a StackPane, reading files named "screen(digit)" from path.
	 * @param pane - the stackpane to load images onto, from back to front.
	 */
	public static void loadOpening (StackPane pane) {
		for (int i = 10; i >= 1; i--) {
			Image image;
			try {
				image = new Image(new FileInputStream("./src/application/resources/introimg/screen" + i + ".jpg"));
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
		translate.setDuration(Duration.millis(2500)); 
		translate.setNode(node);
		translate.setByY(720);
		translate.setCycleCount(1); 
		translate.setAutoReverse(false); 
		translate.play(); 
	}
	
	/**
	 * Launches the menu screen, which has three different paths. 
	 * New game, load a game, or "Help". Defines a different scene for each
	 * of these options and implements the above two functions to animate the 
	 * opening sequence for the game. After which, a save will be generated 
	 * through which the game continues. 
	 */
	@Override
	public void start(Stage primaryStage) {
		try {	
			window = primaryStage;
			
			/// Menu Screen

			//plays the main theme
			Sound.mainTheme();

			BorderPane menu = new BorderPane();
			menusc = new Scene(menu,1280,720);
			
			Text title = new Text("");
			title.setFont(new Font(120));
			
			VBox menuButtons = new VBox(20);
			Button newGame = new Button();
			Button loadGame = new Button();
			Button help = new Button();

			Image newimg = new Image(new FileInputStream("./src/application/resources/menuimg/newgame.jpg"));
			newGame.setGraphic(new ImageView(newimg));
			Image loadimg = new Image(new FileInputStream("./src/application/resources/menuimg/loadgame.jpg"));
			loadGame.setGraphic(new ImageView(loadimg));
			Image helpimg = new Image(new FileInputStream("./src/application/resources/menuimg/help.jpg"));
			help.setGraphic(new ImageView(helpimg));
			
			// Event handling for menu buttons
			
			newGame.setOnAction(e -> window.setScene(opening));
			loadGame.setOnAction(e -> window.setScene(loadsc));
			help.setOnAction(e -> window.setScene(helpsc));
			
			// Styling menu buttons (replace with images later)
			
			newGame.setStyle("-fx-base: #000000;");
			loadGame.setStyle("-fx-base: #000000;");
			help.setStyle("-fx-base: #000000;");
			
			menuButtons.getChildren().addAll(newGame, loadGame, help);

			// for Insets (padding), the order is (top, right, bottom, left)
			
			menu.setCenter(menuButtons);
			menu.setTop(title);
			BorderPane.setMargin(menuButtons, new Insets(40,0,0,150));
			BorderPane.setMargin(title, new Insets(70, 0, 0, 120));
			
			String image = Game.class.getResource("menu.jpg").toExternalForm();
			menu.setStyle("-fx-background-image: url('" + image + "'); " +
			           "-fx-background-position: center center; " +
			           "-fx-background-repeat: stretch;");
			
			// Opening Scene
			StackPane openingPane = new StackPane(); // Container objects for this scene
			opening = new Scene(openingPane,1280,720); // Creates actual scene
		    
			// Make it impossible to start next animation unless current finished 
			
			loadOpening(openingPane);
			
			opening.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			    @Override
			    public void handle(MouseEvent mouseEvent) {

			    	/*  calls fadeImageDown on an object in openingPane when the mouse is pressed.
			    	 *  (remember that these are the images added by loadOpening() )
			    	 *  This is performed once per image, for a total of 10 times. */
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
			
			// Loading and starting the screen. 
			
			window.setScene(menusc);
			window.setTitle("Tip to the Top");
			window.setResizable(false);
			window.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Main function, executes the program. A boolean switch can change between versions (we've opted for full GUI) 
	 * @param args
	 */
	public static void main(String[] args) {
		boolean textV = false;
		
		if (textV == false) {
			launch(args);
		}
		else {
			
		}
	}
}
