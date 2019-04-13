package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NPC implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	 * @return - the name of the NPC(String)
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the NPC from the inputted
	 * @param name, sets the name of the NPC from inputted
	 */
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
		return this.key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * Uses to retrieve a specific NPC from a given ArrayList of NPCs. 
	 * @param name - the name of the NPC to retrieve
	 * @param allCharacters - the ArrayList of NPC characters to look through.
	 * @return the desired NPC, if they are in the list.
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
		List<String> characters_day_3 = Arrays.asList("Benjamin", "Yvonne", "Jason", "Dylan");
		List<String> characters_day_4 = Arrays.asList("Tiff","Patricia","Jason", "Yvonne", "Dylan", "Benjamin");
		List<String> characters_day_5 = Arrays.asList("Jason", "Anna", "Dylan", "Yvonne", "Tiff", "Dimitri");//partricia is an email on day 5

		List<String> characters_day_6 = Arrays.asList("Yvonne","Dimitri", "Dylan", "Tiff", "Patricia", "Anna");
		List<String> characters_day_7 = Arrays.asList("Yvonne", "Dylan", "Patricia");
		// need a Mystery character image
				
		ArrayList<List<String>> lol = new ArrayList<List<String>>();
		lol.add(characters_day_1);
		lol.add(characters_day_2);
		lol.add(characters_day_3);
		lol.add(characters_day_4);
		lol.add(characters_day_5);
		lol.add(characters_day_6);
		lol.add(characters_day_7);
		
		
		if (day != 1) {
			dailyCharacters.clear();
		}
		
		for (NPC character: allcharacters ) {
			if (lol.get(day - 1).contains(character.getName())) {
				dailyCharacters.add(character);
			}
		}
		
	}
	
	/**
	 * Used on day 1, to load the initial list of all characters to be used for the save. 
	 * @param allCharacters - the ArrayList of NPCs to populate with desired NPCs for the game.
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
	 * Returns a String which reflects information of the NPC.
	 */
	public String toString() {
		return name + " " + roomNumber;
	}
		
		
		
}
