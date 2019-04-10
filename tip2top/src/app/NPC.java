package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NPC implements Serializable{
	
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
	/**
	 * Returns the name of NPC
	 * @return - returns the name of the NPC(String)
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the NPC to the parameter
	 * @param name, sets the name of the NPC to the parameter
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns ArrayList prompt
	 * @return - returns the ArrayList prompts(ArrayList<String>)
	 */
	public ArrayList<String> getPrompts() {
		return prompts;
	}

	/**
	 * Sets the ArrayList prompts to the parameter
	 * @param prompts, sets the ArrayList prompts to the parameter
	 */
	public void setPrompts(ArrayList<String> prompts) {
		this.prompts = prompts;
	}

	/**
	 * Returns the room number 
	 * @return - returns the room number(int)
	 */
	public int getRoomNumber() {
		return roomNumber;
	}
	
	/**
	 * Sets the room number to the parameter
	 * @param roomNumber, sets the room number to the parameter
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	/**
	 * Returns the booking object
	 * @return - returns the booking object(Booking)
	 */
	public Booking getBooking() {
		return booking;
	}
	
	/**
	 * Returns the NPC check in state
	 * @return, returns checkedin(boolean)
	 */
	public boolean isCheckedIn() {
		return checkedIn;
	}
	
	/**
	 * Sets the booking object to the parameter
	 * @param booking, sets the booking to the parameter
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	/**
	 * Sets the NPC check in state to the parameter
	 * @param checkedIn, sets the checkedin state to the parameter
	 */
	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	/**
	 * Returns the key number
	 * @return - returns the key number(int)
	 */
	public int getKey() {
		return this.key;
	}
	
	/**
	 * Sets the key number to the parameter
	 * @param key, sets the key number to the parameter
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * 
	 * @param name
	 * @param allCharacters
	 * @return - returns the NPC object
	 */
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
		List<String> characters_day_2 = Arrays.asList("Dylan", "Jason", "Mystery", "Patricia", "Tiff");
		
		// need a Mystery character image
		
		if (day == 1) {
			//dailyCharacters.clear();
			for (NPC character : allcharacters) {
				if (characters_day_1.contains(character.getName())) {
					dailyCharacters.add(character);
				}
			}
		}
			

		if (day == 2) {
			dailyCharacters.clear();
			for (NPC character : allcharacters) {
				if (characters_day_2.contains(character.getName())) {
					dailyCharacters.add(character);
				}
			}
		}
	
	}
	
	/**
	 * Populates all the charcters into our all character arraylist
	 * @param allCharacters, ArrayList to add all possible game NPC's
	 */
	public void populateAllCharacters(ArrayList<NPC> allCharacters) {
		if (populated == false) {

			NPC jason = new NPC("Jason");
			jason.setBooking(new Booking("Jason", 4, "Basic"));
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
		
	/**
	 * Creates a string that displays characters name and room number
	 */
	public String toString() {
		return name + " " + roomNumber;
	}
		
		
		
}
