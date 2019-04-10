package app;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.ObservableList;

public class Booking extends AmigoBuilder implements Serializable{

	private String owner;
	private int roomNumber;
	private String roomType;
	
	/**
	 * Returns the bookings owner
	 * @return - returns the owner(String)
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Returns the room number of booking
	 * @return - returns the room number(int)
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * Returns the room type of booking
	 * @return - returns the room type(String)
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * Sets the owner of booking
	 * @param owner, sets the owner to the parameter
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Sets the room number of booking
	 * @param roomNumber, sets the room number to the parameter
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * Sets the room type of booking
	 * @param roomType, sets the room type to the parameter
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * Creates default booking with a set owner
	 * @param owner, sets the owner of the booking
	 */
	public Booking(String owner) {
		setOwner(owner);
		this.roomNumber = 0;
		this.roomType = null;
	}
	
	/**
	 * Constructs full booking
	 * @param owner, sets the owner
	 * @param roomNumber, sets the room number
	 * @param roomType, sets the room type
	 */
	public Booking(String owner, int roomNumber, String roomType) {
		this.owner = owner;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
	}
	
	/**
	 * Creates a string with a full bookings info
	 */
	public String toString () {
		String toReturn = "Guest: " + owner + " | " + "Room #" + roomNumber + " | " + "Room Type: " + roomType;
		return toReturn;
	}
	
	/**
	 * loads all the bookings currently in the amigo system
	 * @param allCharacters, all characters available in the game
	 * @param bookings, list of all current bookings made
	 */
	public void loadBookings(ArrayList<NPC> allCharacters, ObservableList<String> bookings) {
		for (NPC c : allCharacters) {
			if (c.isCheckedIn()) {
				 bookings.add(c.getBooking().toString());
			}
		} 
	}
	
	// finish once you have several days functional
}
