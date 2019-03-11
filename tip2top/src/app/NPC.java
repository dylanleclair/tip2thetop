package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class NPC {

	private static ArrayList<NPC> dailyCharacters= new ArrayList<>();
	
	private String name;
	private int roomNumber;
	private ImageView appearance;
	
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
			List<NPC> namesList = Arrays.asList(new NPC("Aleksandra"), new NPC("Dylan"), new NPC("Jason"),new NPC("Yvonne"), new NPC("Tiff"), new NPC("Harry"), new NPC("Patricia"));
			dailyCharacters.clear();
			dailyCharacters.addAll(namesList);
		
		}
	}
		
	public String toString() {
		return name + " " + roomNumber;
	}
		
		
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
