package app;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	public static void intializeCharacters(int day) { // finish this to modify per day
		switch(day) {
		
		case 1:
			List<NPC> namesList = Arrays.asList(new NPC("Aleksandra"), new NPC("Dylan"), new NPC("Jason"),new NPC("Yvonne"), new NPC("Harriet"), new NPC("Patricia"));
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
			
		} else if (character.equalsIgnoreCase("Tiff")) {
			queue.add("lmao");
		} else if (character.equalsIgnoreCase("Yvonne")) {
			queue.add("rip");
		} else if (character.equalsIgnoreCase("Jason")) {
			
		} else if (character.equalsIgnoreCase("Harriet")) {
			
		}
			
		/*
		
		switch (character) {
		
		case "Dylan":
			
			queue.add("lol");
		
		case "Tiff":
		
			queue.add("rip");
			
		case "Yvonne":

			queue.add("ugh");
			
		case "Patricia":

			queue.add("wow");
			
		case "Jason":

			queue.add("lmao");
			
		case "Aleksandra":

			queue.add("yeet");
			
		}
		*/
		
		return queue;
		
		
		
	}
		
		
}
