package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NPC {

	private static ArrayList<NPC> dailyCharacters= new ArrayList<>();
	
	private String name;
	private int roomNumber;
	private static boolean dylan_1_yes;
	
	
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
				
				queue.add("Dylan: Hello!");
				queue.add("You: Hi, can I help you with anything!");
				queue.add("This is line 3");
				queue.add("This is line 4");
				queue.add("This is line 5");
				queue.add("This is line 6");
				
				// dialogue for dylans first day 
				
				//ex for a branch -- make variables global so i can toString them
				
				// stuff leading up to a split / branch
				
				if (dylan_1_yes) {
					// yes
				}
				else {
					// no
				}
				
			} else if (day == 2) { 
				
			} else if (day == 3) {
				
			} else if (day == 4) { 
				
			} else if (day == 5) {
				
			} else if (day == 6) {
				
			} else if (day == 7) {
				
			}
			
		} else if (character.equalsIgnoreCase("Tiff")) {
			queue.add("Dylan: Hello!");
			queue.add("You: Hi, can I help you with anything!");
			queue.add("This is line 3");
			queue.add("This is line 4");
			queue.add("This is line 5");
			queue.add("This is line 6");
		} else if (character.equalsIgnoreCase("Yvonne")) {
			queue.add("Dylan: Hello!");
			queue.add("You: Hi, can I help you with anything!");
			queue.add("This is line 3");
			queue.add("This is line 4");
			queue.add("This is line 5");
			queue.add("This is line 6");
		} else if (character.equalsIgnoreCase("Jason")) {
			queue.add("Dylan: Hello!");
			queue.add("You: Hi, can I help you with anything!");
			queue.add("This is line 3");
			queue.add("This is line 4");
			queue.add("This is line 5");
			queue.add("This is line 6");
		} else if (character.equalsIgnoreCase("Harriet")) {
			queue.add("Dylan: Hello!");
			queue.add("You: Hi, can I help you with anything!");
			queue.add("This is line 3");
			queue.add("This is line 4");
			queue.add("This is line 5");
			queue.add("This is line 6");
		} else if (character.equalsIgnoreCase("Aleksandra")) {
			queue.add("Dylan: Hello!");
			queue.add("You: Hi, can I help you with anything!");
			queue.add("This is line 3");
			queue.add("This is line 4");
			queue.add("This is line 5");
			queue.add("This is line 6");
		} else if (character.equalsIgnoreCase("Patricia")) {
			queue.add("This is line 3");
			queue.add("This is line 4");
			queue.add("This is line 5");
			queue.add("This is line 6");
		}
				
		return queue;
		
		
		
	}
		
		
}
