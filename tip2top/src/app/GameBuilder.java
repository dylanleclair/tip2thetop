package app;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameBuilder {
	
	private int openingCount = 10;
	private boolean saveSet = false;
	private int countend;
	private boolean clickable = true;
	
	
	/**
	 * Loads the ending by stacking images into a StackPane, similar to the opening sequence.
	 * @param endPane - the StackPane to build images into
	 * @param ending - the String which decides the ending to be played
	 * @param menusc - main menu scene, which is swapped to after the game is finished. 
	 * @param window - the Stage of the game, used to switch scenes.
	 */
	public void loadEnding (StackPane endPane, String ending, Scene menusc, Stage window) {

		File directory = new File("./resources/gameimg/endings/"+ending);
		String[] filesInDir = directory.list();
		countend = filesInDir.length;
	
		
		
		for (int i = filesInDir.length + 1; i >= 2; i--) {
			
			
			try {
				Image image = new Image(new FileInputStream("./resources/gameimg/endings/" + ending + "/" + (i - 1)+ ".png"));
				ImageView imageView = new ImageView(image); 
				endPane.getChildren().add(imageView);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		
	}
	
	
	/**
	 * Loads opening scene onto a StackPane, reading files named "screen(digit)" from path.
	 * @param pane - the StackPane to load images onto, from back to front.
	 */
	public void loadOpening (StackPane pane) {
		for (int i = 11; i >= 1; i--) {
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
	public void fadeImageDown (Node node) {
		TranslateTransition translate = new TranslateTransition();
		translate.setDuration(Duration.millis(1800)); 
		translate.setNode(node);
		translate.setByY(720);
		translate.setCycleCount(1); 
		translate.setAutoReverse(false); 
		translate.setOnFinished(e -> clickable = true);
		translate.play();
		
		
	}
	
	/**
	 * Translates a node downward and off the screen, animates a button onto screen when the last image is reached.
	 * @param node - the node to be animated off screen 
	 * @param endPane - the StackPane which is accessed in order to add the button.
	 * @param window - the Stage of the game, to switch back to menu scene when the button is pressed.
	 * @param menusc - a Scene, the  menu scene which is switched back to upon button press. 
	 */
	public void fadeImageDown (Node node, StackPane endPane, Stage window, Scene menusc) {
		TranslateTransition translate = new TranslateTransition();
		translate.setDuration(Duration.millis(1800)); 
		translate.setNode(node);
		translate.setByY(720);
		translate.setCycleCount(1); 
		translate.setAutoReverse(false);
		translate.setOnFinished(a -> clickable = true);
		
		
		if (countend == 2) {
			translate.setOnFinished(e -> {
				
	    		try {
	    			Button exit = new Button();
	    			
	    			Image exitbtn = new Image(new FileInputStream("./resources/gameimg/amigo/buttons/exit.jpg"));
	    			ImageView imgview = new ImageView(exitbtn);
	    			exit.setGraphic(imgview);
	    			exit.setDefaultButton(false);
	    			exit.setOnAction(a -> {
	    				window.setScene(menusc);
	    			});
	    			
	    			exit.setManaged(false);
	    			
	    			exit.setLayoutX(620);
	    			exit.setLayoutY(550);
	    			exit.setVisible(true);

	    			exit.setStyle("-fx-base: #000000;");
	    			
	    			exit.setOpacity(0);
	    			
	    			
	    		     FadeTransition ft = new FadeTransition(Duration.millis(1000), exit);
	    		     ft.setFromValue(0);
	    		     ft.setToValue(100);
	    		     ft.setCycleCount(1);
	    		     ft.setAutoReverse(false);

	    			
	    			endPane.getChildren().set(endPane.getChildren().size() - 1, exit);
	    			
	    			ft.play();
	    			
	    			
	    			
	    		}catch (Exception a1) {
	    			a1.printStackTrace();
	    		}
				
				
				
			});
		}
		
		translate.play();
		

		
		
	}
	
	
	/**
	 * Handles the actions for when the start playing button is pressed.
	 * @param window a Stage, used to switch to the main scene for the game
	 * @param opening, the Scene to switch to after.
	 * @param text, the TextField to retreive the name of the player from.
	 * @param emanager
	 */
	public void startPlayingButton(Stage window, Scene opening, TextField text) {
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
	public void buildMenu (BorderPane menu, Stage window, Scene opening, Scene loadsc, Scene helpsc, Scene createsavesc) {
		try {
		Text title = new Text("");
		title.setFont(new Font(120));
		VBox menuButtons = new VBox(20);
		Button newGame = new Button();
		Button loadGame = new Button();

		Image newimg = new Image(new FileInputStream("./resources/menuimg/newgame.jpg"));
		newGame.setGraphic(new ImageView(newimg));
		Image loadimg = new Image(new FileInputStream("./resources/menuimg/loadgame.jpg"));
		loadGame.setGraphic(new ImageView(loadimg));
		
		// Event handling for menu buttons
		
		newGame.setOnAction(e -> window.setScene(createsavesc));
		loadGame.setOnAction(e -> window.setScene(loadsc));
	
		
		// Styling menu buttons (replace with images later)
		
		newGame.setStyle("-fx-base: #000000;");
		loadGame.setStyle("-fx-base: #000000;");
		
		menuButtons.getChildren().addAll(newGame, loadGame);

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
	
	
	// Create a save screen
	
	
	/**
	 * Allows the user to define a save name, "between" the menu scene and the opening screen/sequence.
	 * @param window - the Stage of the program where we want to build the save screen. 
	 * @param openingsc - the Scene we want to switch to after the save is created.
	 * @param menusc - the Scene we want to switch back to when "Back" is pressed.
	 * @return a BorderPane, which is the Pane we want to display
	 */
	public BorderPane buildSaveScreen(Stage window, Scene openingsc, Scene menusc) {
		BorderPane setSaveName = new BorderPane();
		
		TextField enterName = new TextField();
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
	
	
	/**
	 * Builds the opening scene, which is played after the save screen. 
	 * @param openingPane - the StackPane which stores the images for the opening sequence.
	 * @param opening - the Scene for the opening, which we build an eventhandler onto.
	 */
	public void buildOpeningScreen (StackPane openingPane, Scene opening, Stage window, Scene mainscene) {
		
		loadOpening(openingPane); // loads the images for the opening sequence and display them on top of each other
		
		opening.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		    	
		    	/*  calls fadeImageDown on an object in openingPane when the mouse is pressed.
		    	 *  (remember that these are the images added by loadOpening() )
		    	 *  This is performed once per image, for a total of 10 times. */

		    		if (openingCount >= 0 && saveSet == true && clickable) { // set > to not let end frame
		    			clickable = false;
			    		fadeImageDown(openingPane.getChildren().get(openingCount));
			    		openingCount--;
			    		//Pat added to change scene to start of day
			    		if (openingCount == -1) {
			    			mainscene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			    			
			    			Game.dayb.runDay(window, Game.transitionsc);
			    			
			    			window.setScene(mainscene);
							
			    			//Scene dayIntro = new Scene(DayBuilder.startDay(window), 1280, 720);
			    			//window.setScene(dayIntro);
		    		}
		    	
		    }
		}});
		
	}
	
	
	/**
	 * Builds the ending screen onto a StackPane according to a specified ending prompt.
	 * @param endPane a StackPane, which the ending is loaded onto
	 * @param ending a String, which is used to specify desired ending
	 * @param menusc a Scene, the menu scene to switch to after the game ends.
	 * @param window a Stage, to switch the scenes as needed.
	 */
	public void buildEndingScreen (StackPane endPane,String ending, Scene menusc, Stage window) {
		
		
		loadEnding(endPane, ending, menusc, window);
		
		endPane.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent mouseEvent) {
				// TODO Auto-generated method stub
				if (countend > 1 && clickable) {
					clickable = false;
					fadeImageDown(endPane.getChildren().get(countend - 1), endPane, window, menusc);
		    		countend--;
		    		
				}
				
				
			} 
			
		});
		
		
		
	}
	
	// Load screen
		
	
	
	/**
	 * Builds the screen for "Load Game" from the menu. 
	 * @param window - the Stage of the application window.
	 * @param menusc - the menu scene (needed for user to return to menu)
	 * @return the built "Load Game" screen (BorderPane), to be built into a scene (as a root node).
	 */
	public BorderPane buildLoadScreen(Stage window, Scene menusc) {
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
	 * Handles events for the load save button on the load screen
	 * @param listview  a ListView, the ListView displayed on the load screen.
	 */
	public void loadSaveButton(ListView<String> listview) {
		//Save.selectSave(index);
		String selected = (String) listview.getSelectionModel().getSelectedItem();
		Save.loadSave(selected);
		// finish implementing -- this is for the load save button on loading screen
	}
	
	
	
	// Help Screen 
	
	/**
	 * Builds and returns the help screen of the game (BorderPane). 
	 * @param window - the Stage of the application window.
	 * @param menusc - the menu scene (needed for user to return to menu)
	 * @return the built "Help" screen (BorderPane), to be built into a scene (as a root node)
	 */
	public BorderPane buildHelpScreen(Stage window, Scene menusc) {
		BorderPane helpScreen = new BorderPane();
		Button backToMenuH = new Button("Back to the menu");
		backToMenuH.setOnAction(e -> window.setScene(menusc));
		helpScreen.setBottom(backToMenuH);
		return helpScreen;
	}
	
	/**
	 * Builds the transition screen, calculating daily score along the way. 
	 * @param transition - the StackPane to build elements onto. 
	 * @param window the Stage of the application to switch scenes of.
	 * @param nextDay - the Scene of the next day (mainscene)
	 * @param dayb - the DayBuilder used by the game.
	 * @param transitionsc - a Scene, which contains the transition StackPane
	 * @param menusc - a Scene, the menu scene to return to.
	 */
	public void buildTransitionScreen(StackPane transition,Stage window, Scene nextDay, DayBuilder dayb, Scene transitionsc, Scene menusc) {
		
		transition.getChildren().clear();
		
		ChoiceCenter cc = dayb.getChoiceManager();
		Money mirror = dayb.getMoneyManager();
		
		int dm = cc.getDaymistakes();
		int gulag = cc.getGulagPoints();
		int cs = cc.getCustomerSatisfaction();
		double tips = cc.getTips();
		double bonus = cc.getBonus();	
		double spendings = cc.getSpendings();
		
		double[] toDisplay = mirror.calc(dm, cs, gulag, tips, bonus, spendings);
		
		Text bp = new Text(Double.toString(toDisplay[0]));
		Text penalty = new Text(Double.toString(toDisplay[1]));
		Text bonuses = new Text(Double.toString(toDisplay[2]));
		Text tip = new Text(Double.toString(toDisplay[3]));
		Text ds = new Text(Double.toString(toDisplay[4]));
		
		
		Text[] textlist = {bp, penalty, bonuses,tip,ds};
		
		for (Text text : textlist) {
			text.setFill(Color.GHOSTWHITE);
			text.setFont(new Font(24));
		}
		
				
		
		Text st = new Text(Double.toString(toDisplay[5]));
		Text total = new Text(Double.toString(toDisplay[6]));
		
		if (toDisplay[6] < 0) { // checks if the user is bankrupt / has lost
			// end the game
			buildEndingScreen(transition, "oom", menusc, window);
		} else if (dayb.getDay() == 7) { // if it's the last day, ends the game
			
			if (cc.getChoiceFinale() == 4) {
				buildEndingScreen(transition, "correct", menusc, window);
			} else {
				buildEndingScreen(transition, "incorrect", menusc, window);
			}
			
		} else { // builds the proper screen if they aren't bankrupt / has lost
			
			
			Text[] totallist = {st, total};
			
			for (Text text : totallist) {
				text.setFill(Color.GHOSTWHITE);
				text.setFont(new Font(24));
			}
			
			VBox amounts = new VBox(48);
			VBox totals = new VBox(48);
			
			amounts.getChildren().addAll(bp,penalty,bonuses,tip,ds);
			totals.getChildren().addAll(st,total);
			
			amounts.setManaged(false);
			amounts.setLayoutX(530);
			amounts.setLayoutY(262);
			
			totals.setManaged(false);
			totals.setLayoutX(1000);
			totals.setLayoutY(310);			
			
			try {
				Image image = new Image(new FileInputStream("./resources/gameimg/transition/dailyreport.jpg"));
			    ImageView imageView = new ImageView(image); 
			    transition.getChildren().add(imageView);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}  
			
			
			
			
			transition.getChildren().addAll(amounts, totals);
			
			
			
			try {
				
				Image keepplaying = new Image(new FileInputStream("./resources/gameimg/transition/keep.png"));
			    ImageView keepplayingimg = new ImageView(keepplaying); 
			    
			    Image savequit = new Image(new FileInputStream("./resources/gameimg/transition/savequit.png"));
			    ImageView savequitimg = new ImageView(savequit); 
				
				
				Button savequitbtn = new Button();
				Button keepergoing = new Button();
				
				keepergoing.setGraphic(keepplayingimg);
				savequitbtn.setGraphic(savequitimg);
				
				
				keepergoing.setStyle("-fx-base: #000000;");
				savequitbtn.setStyle("-fx-base: #000000;");
				
				keepergoing.setOnAction(e -> {
					window.setScene(nextDay);
					dayb.triggerNewDay(window, transitionsc);
				});
				
				savequitbtn.setOnAction(a -> {
					ArrayList<NPC> allCharacters = dayb.getAllCharacters();
					ArrayList<Email> emails = dayb.getEmail_list();
					int keys[] = dayb.getKeys();
					int day = dayb.getDay();
					
					double money = mirror.getMoney();
					double bonusamt = cc.getBonus();
					boolean tiff_icecream = cc.isTiff_icecream();
					boolean jason_mints = cc.isJason_mint();
					boolean has_toaster = cc.isHas_toaster();
					File saveFile = Save.getSave();
					
					
					Save.saveWriter(saveFile, allCharacters, emails, keys, day, money, bonusamt, tiff_icecream, jason_mints, has_toaster);
					
					window.setScene(menusc);
					Save.initializeSaves();
					buildLoadScreen(window, menusc);
					
				});
				
				
				//savequitbtn.setOnAction();
				
				VBox buttonbaby = new VBox(10);
				buttonbaby.getChildren().addAll(keepergoing, savequitbtn);
				buttonbaby.setManaged(false);
				buttonbaby.setLayoutX(720);
				buttonbaby.setLayoutY(490);
				
				transition.getChildren().add(buttonbaby);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
		}
		

		
		

	}
	
}
