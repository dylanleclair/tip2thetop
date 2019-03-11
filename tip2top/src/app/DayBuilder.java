package app;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


/**
 * Builds the scenes / related objects necessary for each day of the game. 
 */
public class DayBuilder {
	
	private static StackPane today = new StackPane();
	// one layer for background (index 0)
	// one layer for character (index 1)
	// one layer for desk/foreground (index 2)
	// one layer for borderpane w buttons n shit to make it interactive?
	
	private static boolean dialogueActive;
	private static int satisfaction;
	private static int gulagPoints;
	private static ObservableList<String> guests = FXCollections.observableArrayList();
	private static ObservableList<String> email = FXCollections.observableArrayList();
	private static BorderPane amigo = new BorderPane();
	private static NPC currentCharacter = new NPC("null");
	
	/**
	 * Fills "today" StackPane with it's basic elements for the day.
	 */
	public static void initializeDay() {
		
		try {
			
			// initialize background 
			
			Image background = new Image(new FileInputStream("pathtothebackgroundimage"));
		    ImageView imageView = new ImageView(background); 
		    today.getChildren().add(imageView);
		    
			// initialize placeholder character (off-screen) --- is replaced when current character is switched
		    
			Image fakeCharacter = new Image(new FileInputStream("pathtothebackgroundimage"));
		    ImageView fake = new ImageView(fakeCharacter); 
		    today.getChildren().add(fake);
			
			// initialize desk/foreground
		    
			Image deskimg = new Image(new FileInputStream("pathtothebackgroundimage"));
		    ImageView desk = new ImageView(deskimg); 
		    today.getChildren().add(desk);
		    
			// intialize ui (so we can interact with elements on screen) -- includes interactive elements of desk
			
		    BorderPane handler = new BorderPane();
		    today.getChildren().add(handler);
		    
		} catch (Exception e) {
			
		}
		
	}
	
	/**
	 * Main logical programming system for each day - move to whatever class handles each day
	 * This is literally the SUBSTANCE of our program, so don't fuck with it.
	 */
	public static void buildDay (int day) { // called every day --- move to Game
		
		// instantiate characters
		
		int characterNumber = 0;
		
		switch (day) {
		
		case 1 : // day 1
			
			NPC.intializeCharacters(day);
			ArrayList<NPC> dailyCharacters = NPC.getDailyCharacters();
			
			// loading amigo 1000 resources
			for (NPC i : dailyCharacters) {
				guests.add(i.toString());
			}
			
			
			// actual logic for each character 
			
			Collections.shuffle(dailyCharacters); // shuffle (to randomize order)
			
			for (NPC character: dailyCharacters) {
				characterNumber++;
				try {
					Image image = new Image(new FileInputStream("./resources/characters/" + character.getName() + ".jpg"));
				    ImageView characterView = new ImageView(image); 
				    today.getChildren().set(1, characterView); 
				    
				    // if statement to see whether character needs to be animated out before being animated in (use character)
					if (characterNumber == 1) {
						// animate character in only
						
						dialogueActive = true;
					} else {
						// animate out and then animate in
						
						dialogueActive = true;
					}
				    
				} catch (Exception e) {}
				
				
				dialogueActive = true; // we might need this variable to keep listeners muted
				NPC.getDialogue(character.getName(),day);	
				// do character dialogue -- listeners / etc will be muted so the player can't screw around while dealing w customers
				dialogueActive = false;
				// leave some time for the character to use computer / etc (maybe depends on if they'll actually need to use it)
				
				// animate character out
				
				}
			
		// all the way to day 7 baby
		}
		
	}
	
	
	public static void buildAmigoScreen () {
		
		// set the background image
		try {
			Image background = new Image(new FileInputStream("./resources/menuimg/amigo.jpg"));
			BackgroundImage bgImg = new BackgroundImage(background,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    null);
			Background emailbkg = new Background(bgImg);
			amigo.setBackground(emailbkg);
		} catch (Exception e) {}
		
		Button viewGuests = new Button();
		Button viewEmails = new Button();
		
		VBox amigoButtons = new VBox(20);
		amigoButtons.getChildren().addAll(viewGuests, viewEmails);
		
		
		amigo.getChildren().add(amigoButtons);
		
		//viewGuests.setOnAction(e -> amigo.setCenter(checkins));
		//viewEmails.setOnAction(e -> amigo.setCenter(emails));
	
	}
	
	public static void buildEmailScreen(BorderPane amigo) { // focus on this AFTER the email screen is built
		try {
			Image background = new Image(new FileInputStream("./resources/menuimg/email.jpg"));
			BackgroundImage bgImg = new BackgroundImage(background,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    null);
			Background emailbkg = new Background(bgImg);
			amigo.setBackground(emailbkg);
		} catch (Exception e) {}
		
		ListView<String> emails = new ListView<>(email);
		if (email.isEmpty()) email.add("You have no new emails!");
	}
	
	public static void buildCheckInScreen(ArrayList<NPC> dailyCharacters) {
		try {
			// clearing the borderpane and setting an appropriate background
			amigo.getChildren().clear();
			Image background = new Image(new FileInputStream("./resources/menuimg/checkin.jpg"));
			BackgroundImage bgImg = new BackgroundImage(background,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    null);
			Background checkinbkg = new Background(bgImg);
			amigo.setBackground(checkinbkg);
		} catch (Exception e) {}
		
		// building actual elements
		// initialize background 
		ListView<String> guestlist = new ListView<>(guests);
		TextField guestName = new TextField("Name");
		TextField roomNumber = new TextField("Room#");
		Button addGuest = new Button();
		Button checkOut = new Button();
		Button back = new Button();
		
		HBox addName = new HBox(20);
		addName.getChildren().addAll(guestName, roomNumber, addGuest);
		
		VBox buttons = new VBox(20);
		buttons.getChildren().addAll(checkOut, back);
		
		
		
		amigo.setTop(addName);
		amigo.setCenter(guestlist);
		amigo.setRight(buttons);
		
		
		// event handling for buttons 
		
		addGuest.setOnAction(e -> {
			NPC temp = new NPC(guestName.getText(), Integer.parseInt(roomNumber.getText()));
			guests.add(temp.toString());
		});
		checkOut.setOnAction(e -> guests.remove(guestlist.getSelectionModel().getSelectedIndex()));
		back.setOnAction(e -> {
			amigo.getChildren().clear();
			buildAmigoScreen();
		});
	}
	
	/**
	 * This function will review activity in the Amigo 1000 for the day, and add points to satisfaction/gulag points as needed. 
	 */
	public static void verifyAmigo() {
		
	}
	
	
	// I heard you like light theme
	
}
