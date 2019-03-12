package app;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Game extends Application {

	//protected static boolean loadingFromSave = false;
	
	Stage window;
	Scene menusc, opening, loadsc, helpsc, createsavesc, mainscene;
	
	/**
	 * Launches the menu screen, which has three different paths. 
	 * New game, load a game, or "Help". Defines a different scene for each
	 * of these options and implements methods to animate the 
	 * opening sequence for the game. After which, a save will be generated 
	 * through which the game continues. 
	 */
	@Override
	public void start(Stage primaryStage) {
		try {	
			window = primaryStage; // renaming primaryStage to window for the sake of clarification
			
			// Initializing the Menu Scene
			
			BorderPane menu = new BorderPane();
			menusc = new Scene(menu,1280,720, Color.BLACK);
			
			// Opening Scene
			StackPane openingPane = new StackPane(); // Container objects for this scene
			opening = new Scene(openingPane,1280,720); // Creates actual scene
			GameBuilder.buildOpeningScreen(openingPane, opening, window);
			
			// Load Screen (creates new scene using load screen from GameBuilder		
			loadsc = new Scene (GameBuilder.buildLoadScreen(window, menusc), 1280, 720);
	
			// Help Screen (creates new scene using help screen from GameBuilder as root note)
			helpsc = new Scene(GameBuilder.buildHelpScreen(window, menusc), 1280,720);

			// Loading and starting the screen. 
			
			createsavesc = new Scene(GameBuilder.buildSaveScreen(window, opening, menusc), 1280,720);
			
			
			// Main scene for the game
			// 	load save or whatever will switch to the main scene after loading the save
			//	DayBuilder.initializeDay()
			//	mainscene = new Scene(DayBuilder.today, 1280, 720); // placeholder 
			
			//menusc.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			GameBuilder.buildMenu(menu, window, opening, loadsc, helpsc, createsavesc);
			window.setScene(menusc);
			window.setTitle("Tip to the Top");
			window.setResizable(false);
			
			// plays the main theme when the game starts up
			Sound.mainTheme();
			
			
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
		boolean textV = false; // in case of text version integration
		if (textV == false) {
			
			Save.initializeSaves();
			launch(args);
			
		}
		else {
			
		}
	}
}
