package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NPC {
	
	private String name;
	private int roomNumber;
	private Booking booking;
	private boolean checkedIn = false;
	
	private boolean populated = false;
	
	
	// Constructors
	
	public NPC(String name) {
		this.name = name;
		booking = new Booking(name);
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
	public Booking getBooking() {
		return booking;
	}
	public boolean isCheckedIn() {
		return checkedIn;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	
	public NPC getCharacter (String name, ArrayList<NPC> allCharacters) {
		for (NPC character : allCharacters) {
			if (name.equals(character.getName()) ) {
				return character;
			}
		}
		return null;
	}
	
	/**
	 * Returns a list of NPCs for the current day, selecting them from the list of all characters 
	 * @param day - an int, the day # to load the characters for
	 * @param allcharacters - the array of all character NPCs to retreive objects from
	 * @return the list of daily characters
	 */
	public ArrayList<NPC> initializeCharacters(int day, ArrayList<NPC> allcharacters) { // finish this to modify per day
		ArrayList<NPC> dailyCharacters= new ArrayList<>();
		
		List<String> characters_day_1 = Arrays.asList("Dylan", "Jason", "Yvonne", "Harriet", "Patricia");
		
		switch(day) {
		
		case 1:
			
			dailyCharacters.clear();
			for (NPC character : allcharacters) {
				if (characters_day_1.contains(character.getName())) {
					dailyCharacters.add(character);
				}
			}
		
		}
		return dailyCharacters;
	}
	
	public void populateAllCharacters(ArrayList<NPC> allCharacters) {
		if (populated == false) {

			NPC jason = new NPC("Jason");
			jason.setBooking(new Booking("Jason", 5, "Basic"));
			jason.setCheckedIn(true);
			
			allCharacters.add(new NPC("Dylan"));
			allCharacters.add(jason);
			allCharacters.add(new NPC("Yvonne"));
			allCharacters.add(new NPC("Harriet"));
			allCharacters.add(new NPC("Patricia"));
			allCharacters.add(new NPC("Aleksandra"));
			allCharacters.add(new NPC("Tiff"));
			allCharacters.add(new NPC("???"));
			allCharacters.add(new NPC("Benjamin"));
			allCharacters.add(new NPC("Anna"));
			allCharacters.add(new NPC("Dimitri"));
			allCharacters.add(new NPC("Gloria"));
		
			populated = true;
		}
	}
		
	public String toString() {
		return name + " " + roomNumber;
	}
		
		
	public ArrayList<String> getDialogue(String character, int day) {
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
