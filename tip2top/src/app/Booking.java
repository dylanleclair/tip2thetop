package app;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.ObservableList;

public class Booking implements Serializable{

	private String owner;
	private int roomNumber;
	private String roomType;
	
	public String getOwner() {
		return owner;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Booking(String owner) {
		setOwner(owner);
		this.roomNumber = 0;
		this.roomType = null;
	}
	
	public Booking(String owner, int roomNumber, String roomType) {
		this.owner = owner;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
	}
	
	public String toString () {
		String toReturn = "Guest: " + owner + " | " + "Room #" + roomNumber + " | " + "Room Type: " + roomType;
		return toReturn;
	}
	
	public void loadBookings(ArrayList<NPC> allCharacters, ObservableList<String> bookings) {
		for (NPC c : allCharacters) {
			if (c.isCheckedIn()) {
				 bookings.add(c.getBooking().toString());
			}
		} 
	}
	
	// finish once you have several days functional
}
