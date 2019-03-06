package app;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameBuilder {
	
	private static int openingCount = 9;
	private static boolean saveSet = false;
	
	/**
	 * Loads opening scene onto a StackPane, reading files named "screen(digit)" from path.
	 * @param pane - the StackPane to load images onto, from back to front.
	 */
	public static void loadOpening (StackPane pane) {
		for (int i = 10; i >= 1; i--) {
			Image image;
			try {
				image = new Image(new FileInputStream("./resources/introimg/screen" + i + ".jpg"));
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
	
	
	public static void startPlayingButton(Stage window, Scene opening, TextField text) {
		window.setScene(opening);
		saveSet = true;
		String savename = text.getText();
		Save.createSaveFile(savename);
	}
	
	/**
	 * Builds the menu into a BorderPane. 
	 * @param menu the BorderPane to add resources of menu into. 
	 * @param window the Stage which controls what scene is displayed (needed to change scenes)
	 * @param opening a Scene - the opening animation screen to build into "New Game" of the menu.
	 * @param loadsc a Scene - the load screen to build into the "Load Screen" button of the menu.
	 * @param helpsc a Scene - the help screen to build into the "Help" button of the menu. 
	 */
	public static void buildMenu (BorderPane menu, Stage window, Scene opening, Scene loadsc, Scene helpsc, Scene createsavesc) {
		try {
		Text title = new Text("");
		title.setFont(new Font(120));
		VBox menuButtons = new VBox(20);
		Button newGame = new Button();
		Button loadGame = new Button();
		Button help = new Button();

		Image newimg = new Image(new FileInputStream("./resources/menuimg/newgame.jpg"));
		newGame.setGraphic(new ImageView(newimg));
		Image loadimg = new Image(new FileInputStream("./resources/menuimg/loadgame.jpg"));
		loadGame.setGraphic(new ImageView(loadimg));
		Image helpimg = new Image(new FileInputStream("./resources/menuimg/help.jpg"));
		help.setGraphic(new ImageView(helpimg));
		
		// Event handling for menu buttons
		
		newGame.setOnAction(e -> window.setScene(createsavesc));
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
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static BorderPane buildSaveScreen(Stage window, Scene openingsc, Scene menusc) {
		BorderPane setSaveName = new BorderPane();
		
		TextField enterName = new TextField("Enter the name for your save here. Do NOT use special characters.");
		Button confirmName = new Button();
		Button backbtn = new Button();
		VBox container = new VBox(20);
		
		HBox btnbar = new HBox(20);
		btnbar.getChildren().addAll(confirmName, backbtn);
		
		container.getChildren().addAll(enterName,btnbar);
		
		backbtn.setOnAction(e -> window.setScene(menusc));
		
		try {
		Image start = new Image(new FileInputStream("./resources/menuimg/startplaying.jpg"));
		confirmName.setGraphic(new ImageView(start));
		confirmName.setStyle("-fx-base: #000000;");
		
		Image back = new Image(new FileInputStream("./resources/menuimg/back2.jpg"));
		backbtn.setGraphic(new ImageView(back));
		backbtn.setStyle("-fx-base: #000000;");
		} catch (Exception e) { }
		
		String image = Game.class.getResource("creategame.jpg").toExternalForm();
		setSaveName.setStyle("-fx-background-image: url('" + image + "'); " +
		           "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;");
		
		BorderPane.setMargin(container, new Insets(300,500, 70 ,130));
		setSaveName.setCenter(container);
		
		confirmName.setOnAction(e -> startPlayingButton(window,openingsc,enterName));
		
		return setSaveName;
	}
	
	public static void buildOpeningScreen (StackPane openingPane, Scene opening) {
		
		loadOpening(openingPane); // loads the images for the opening sequence and display them on top of each other
		
		opening.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		    	/*  calls fadeImageDown on an object in openingPane when the mouse is pressed.
		    	 *  (remember that these are the images added by loadOpening() )
		    	 *  This is performed once per image, for a total of 10 times. */

		    		if (openingCount >= 0 && saveSet == true) { // set > to not let end frame
			    		fadeImageDown(openingPane.getChildren().get(openingCount));
			    		openingCount--;
		    		}
		    	
		    }
		});
		
	}
	
	public static void loadSaveButton(ListView<String> listview) {
		//Save.selectSave(index);
		String selected = (String) listview.getSelectionModel().getSelectedItem();
		Save.loadSave(selected);
		// finish implementing -- this is for the load save button on loading screen
	}
	
	/**
	 * Builds the screen for "Load Game" from the menu. 
	 * @param window - the Stage of the application window.
	 * @param menusc - the menu scene (needed for user to return to menu)
	 * @return the built "Load Game" screen (BorderPane), to be built into a scene (as a root node).
	 */
	public static BorderPane buildLoadScreen(Stage window, Scene menusc) {
		BorderPane loadScreen = new BorderPane();
		Button backToMenu = new Button();
		backToMenu.setOnAction(e -> window.setScene(menusc));
		Button selectSave = new Button();
		
		VBox buttons = new VBox(20);
		buttons.getChildren().addAll(selectSave, backToMenu);
		

		//Formatting for buttons

		try {
		Image backimg = new Image(new FileInputStream("./resources/menuimg/back.jpg"));
		backToMenu.setGraphic(new ImageView(backimg));
		Image selectimg = new Image(new FileInputStream("./resources/menuimg/loadsave.jpg"));
		selectSave.setGraphic(new ImageView(selectimg));
		} catch (Exception e) { }
		
		backToMenu.setStyle("-fx-base: #000000;");
		selectSave.setStyle("-fx-base: #000000;");
		
		
		ListView<String> listView = new ListView<String>(Save.getSaves());
		

		selectSave.setOnAction(e -> loadSaveButton(listView));
		
		
		BorderPane.setMargin(listView, new Insets(250,80, 120 ,200));
		BorderPane.setMargin(buttons, new Insets(270,300,0,0));
		loadScreen.setRight(buttons);
		loadScreen.setCenter(listView);
		
		
		String image = Game.class.getResource("loadmenu.jpg").toExternalForm();
		loadScreen.setStyle("-fx-background-image: url('" + image + "'); " +
		           "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;");
		
		return loadScreen;
	}
	
	/**
	 * Builds and returns the help screen of the game (BorderPane). 
	 * @param window - the Stage of the application window.
	 * @param menusc - the menu scene (needed for user to return to menu)
	 * @return the built "Help" screen (BorderPane), to be built into a scene (as a root node)
	 */
	public static BorderPane buildHelpScreen(Stage window, Scene menusc) {
		BorderPane helpScreen = new BorderPane();
		Button backToMenuH = new Button("Back to the menu");
		backToMenuH.setOnAction(e -> window.setScene(menusc));
		helpScreen.setBottom(backToMenuH);
		return helpScreen;
	}
	
	
}
