package app;

public class Booking extends AmigoBuilder {

	private int roomNumber;
	private String roomType;
	private String owner;
	
	
	public Booking(String owner, int roomNumber, String roomType) {
		this.owner = owner;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
	}
	
	public String toString () {
		String toReturn = "Guest: " + owner + " | " + "Room #: " + roomNumber + " | " + "Room Type: " + roomType;
		return toReturn;
	}
	
	// finish once you have several days functional
}
