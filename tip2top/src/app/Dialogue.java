package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Dialogue {

	private static ArrayList<String> dailyCharacters= new ArrayList<>();
	
	
	public static ArrayList<String> getDailyCharacters() {
		return dailyCharacters;
	}


	public static void setDailyCharacters(ArrayList<String> dailyCharacters) {
		Dialogue.dailyCharacters = dailyCharacters;
	}


	public static void intializeCharacters(int day) { // finish this to modify per day
		switch(day) {
		
		case 1:
			List<String> namesList = Arrays.asList( "Aleksandra", "Dylan", "Jason","Yvonne", "Tiff", "Harry", "Patricia" );
			dailyCharacters.clear();
			dailyCharacters.addAll(namesList);
		
		case 2:
			List<String> namesList2 = Arrays.asList( "Aleksandra", "Dylan", "Jason","Yvonne", "Tiff", "Harry", "Patricia" );
			dailyCharacters.clear();
			dailyCharacters.addAll(namesList2);
		case 3:
			List<String> namesList3 = Arrays.asList( "Aleksandra", "Dylan", "Jason","Yvonne", "Tiff", "Harry", "Patricia" );
			dailyCharacters.clear();
			dailyCharacters.addAll(namesList3);
		case 4:
			List<String> namesList4 = Arrays.asList( "Aleksandra", "Dylan", "Jason","Yvonne", "Tiff", "Harry", "Patricia" );
			dailyCharacters.clear();
			dailyCharacters.addAll(namesList4);
		case 5:
		
		
		}
	}
	
	
	// Methods
		
		
		public static String getDialogue(String character, int day) {
			// returns the dialogue for the character given the day and previous variables
			
			switch (character) {
			
			case "Dylan":
				
				switch(day) {
				
				case 1:
					// build string for dialogue
					//dialogue.display()
				case 2:
					
				case 3:
					
				case 4:
					
				case 5:
					
				case 6:
					
				case 7:
				
				}
			
			case "Tiff":

			case "Yvonne":
			
			case "Patricia":
				
			case "Jason":
				
			case "Aleksandra":
				
				
			}
			
			return "";
			
			
			
		}
		
		
		
}
