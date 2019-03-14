package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class NPC {

	private static ArrayList<NPC> dailyCharacters= new ArrayList<>();
	
	private String name;
	private int roomNumber;
	
	// Constructors
	
	public NPC(String name, int roomNumber) {
		this.name = name;
		this.roomNumber = roomNumber;
	}
	public NPC(String name) {
		this.name = name;
	}
	
	// Getters/Setters
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public static ArrayList<NPC> getDailyCharacters() {
		return dailyCharacters;
	}
	
	public static void setDailyCharacters(ArrayList<NPC> dailyCharacters) {
		NPC.dailyCharacters = dailyCharacters;
	}

	// Static methods for use with dailyCharacters in other classes
	
	public static void initializeCharacters(int day) { // finish this to modify per day
		switch(day) {
		
		case 1:

			List<NPC> namesList = Arrays.asList(new NPC("Dylan"), new NPC("Jason"),new NPC("Yvonne"), new NPC("Harriet"), new NPC("Patricia"));
			Collections.shuffle(namesList);
			namesList.add(new NPC("Tiff"));
			namesList.add(0, new NPC("Aleksandra"));
			dailyCharacters.clear();
			dailyCharacters.addAll(namesList);
		
		}
	}
		
	public String toString() {
		return name + " " + roomNumber;
	}
		
		
	public static ArrayList<String> getDialogue(String character, int day) {
		// returns the dialogue for the character given the day and previous variables
		
		ArrayList<String> queue = new ArrayList<String>();
		
		if (character.equalsIgnoreCase("Dylan")) {
			
			if (day == 1) {
				
				queue.add("Dylan: I like skittles.");
				queue.add("I also like to code.");
				queue.add("Yeah, this isn't really relevant.");
				
				// dialogue for dylans first day 
				
				//ex for a branch -- make variables global so i can toString them
				
				// stuff leading up to a split / branch

			} else if (day == 2) { 
				
			} else if (day == 3) {
				
			} else if (day == 4) { 
				
			} else if (day == 5) {
				
			} else if (day == 6) {
				
			} else if (day == 7) {
				
			}
			
		} else if (character.equalsIgnoreCase("Tiff")) {
			queue.add("Dylan: I'm the last character today..");
			queue.add("Each character has their own personality..");
			queue.add("I'm the quiet one..");
		} else if (character.equalsIgnoreCase("Yvonne")) {
			queue.add("Yvonne: Right now, not everything is");
			queue.add("not quite as complete as we want, but we have a");
			queue.add("good idea of what needs to be done.");
		} else if (character.equalsIgnoreCase("Jason")) {
			queue.add("Jason: I like to make money,");
			queue.add("which is why our game isn't quite finished.");
			queue.add("Honestly, so many deadlines...");
		} else if (character.equalsIgnoreCase("Harriet")) {
			queue.add("Harriet: Characters are played in random order.");
			queue.add("Each character has different choices");
			queue.add("That chnage how they act in the following days");
			queue.add("and determine how the score for the player.");
		} else if (character.equalsIgnoreCase("Aleksandra")) {
			queue.add("Aleksandra: Hello! Welcome to our demo!");
			queue.add("While there's still a lot to be added,");
			queue.add("A lot of our baseline work is complete!");
			queue.add("We still need to iron out a couple of features.");
			queue.add("Like making animation smoother and integrating");
			queue.add("dialogue from our script into the game.");
		} else if (character.equalsIgnoreCase("Patricia")) {
			queue.add("Patricia: The computer is kinda");
			queue.add("old so don't pay too much attention");
			queue.add("if it doesn't really work.. for now.");
		}
				
		return queue;
		
		
		
	}
		
		
}
