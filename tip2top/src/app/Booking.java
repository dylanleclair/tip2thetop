package app;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.ObservableList;

public class Booking implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String owner;
	private int roomNumber;
	private String roomType;
	
	/**
	 * Return's the owner of a booking (string)
	 * @return owner, a String, the name of the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Return's the room number of a booking (int)
	 * @return roomNumber, an int, the room number for the booking.
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * Returns the room type.
	 * @return
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * Set's the owner of the booking according to the String parameter.
	 * @param owner - a String, the new owner.
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Sets the room number of a booking
	 * @param roomNumber - an int, the new room number to be set.
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * Sets the room type of a booking.
	 * @param roomType, a String, the type of room being booked.
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * Creates a default booking, with a set owner. 
	 * @param owner - a String, the name of the owner.
	 */
	public Booking(String owner) {
		setOwner(owner);
		this.roomNumber = 0;
		this.roomType = null;
	}
	/**
	 * Creates a booking with a set owner, room number and roomtype. 
	 * @param owner - a String, the name of the owner
	 * @param roomNumber - an int, the room number
	 * @param roomType - a String, the type of room.
	 */
	public Booking(String owner, int roomNumber, String roomType) {
		this.owner = owner;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
	}
	
	/**
	 * Returns a viewable format of a booking for use with ListView.
	 */
	public String toString () {
		String toReturn = "Guest: " + owner + " | " + "Room #" + roomNumber + " | " + "Room Type: " + roomType;
		return toReturn;
	}
	
	/**
	 * Checks if characters in a list are checked in and adds their name to the bookings if they are.
	 * @param allCharacters an ArrayList of NPCs to iterate through.
	 * @param bookings an Observable list, for use with ListView.
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
