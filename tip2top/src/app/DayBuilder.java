package app;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;


/**
 * Builds the scenes / related objects necessary for each day of the game. 
 */
public class DayBuilder {
	
	public static StackPane today = new StackPane();
	// one layer for background (index 0)
	// one layer for character (index 1)
	// one layer for desk/foreground (index 2)
	
	public static boolean dialogueActive;
	
	/**
	 * Fills "today" StackPane with it's basic elements for the day.
	 */
	public static void initializeDay () {
		
		try {
			
			// initialize background 
			
			
			// initialize placeholder character (off-screen)
			
			
			// initialize desk/foreground
			
			// 
			
		} catch (Exception e) {
			
		}
		
		
		
		
	}
	
	/**
	 * Main logical programming system for each day - move to whatever class handles each day
	 */
	public static void runDay (int day) { // called every day --- move to Game
		
		// instantiate characters
		ArrayList<String> dailyCharacters = new ArrayList<>();
		
		
		
		int characterNumber = 0;
		
		switch (day) {
		
		case 1 : // day 1
			
			Dialogue.intializeCharacters(day);
			dailyCharacters.addAll(Dialogue.getDailyCharacters());
			
			Collections.shuffle(dailyCharacters); // shuffle (to randomize order)
			
			for (String character: dailyCharacters) {
				characterNumber++;
				try {
					Image image = new Image(new FileInputStream("./resources/characters/" + character + ".jpg"));
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
				Dialogue.getDialogue(character,day);	
				// do character dialogue -- listeners / etc will be muted so the player can't screw around while dealing w customers
				dialogueActive = false;
				// leave some time for the character to use computer / etc (maybe depends on if they'll actually need to use it)
				
				// animate character out
				
				}
			
		// all the way to day 7 baby
		}
		
	}
	
	
	// I heard you like light theme
	
}
