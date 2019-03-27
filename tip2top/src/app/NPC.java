package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NPC {
	
	private String name;
	private int roomNumber;
	private Booking booking;
	private boolean checkedIn = false;
	private ArrayList<String> prompts = new ArrayList<String>();
	
	private boolean populated = false;

	private int key;

	
	
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
	
	public ArrayList<String> getPrompts() {
		return prompts;
	}

	public void setPrompts(ArrayList<String> prompts) {
		this.prompts = prompts;
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

	public int getKey() {
		return this.getKey();
	}
	
	public void setKey(int key) {
		this.key = key;
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
	public void initializeCharacters(int day, ArrayList<NPC> allcharacters, ArrayList<NPC> dailyCharacters) { // finish this to modify per day
		
		List<String> characters_day_1 = Arrays.asList("Dylan", "Jason", "Yvonne", "Harriet");
		
		switch(day) {
		
		case 1:
			
			//dailyCharacters.clear();
			for (NPC character : allcharacters) {
				if (characters_day_1.contains(character.getName())) {
					dailyCharacters.add(character);
				}
			}
		
		}
		
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
			allCharacters.add(new NPC("Mystery"));
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
		
		
		
}
