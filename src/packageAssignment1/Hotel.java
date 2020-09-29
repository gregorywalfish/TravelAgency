package packageAssignment1;

public class Hotel {
	
	private String nameOfHotel;													//indicating the name of the hotel.
	private Room[] hotelRooms;													//An array of Rooms indicating the rooms in the hotel.
	
	public Hotel (String type,Room[] r) {
		this.nameOfHotel = type;
		this.hotelRooms=new Room[r.length];
			for (int i = 0; i < r.length; i++){
				this.hotelRooms[i] = new Room(r[i]);							// deep copy of the input array.
			}
	}
	public int reserveRoom (String typeOfRoom) {
		Room availableRoom = Room.findAvailableRoom(hotelRooms, typeOfRoom);	//changes the availability of the first available room of the specified type in the hotel
		if(availableRoom==null) {
			throw new IllegalArgumentException();
		}else {
			availableRoom.changeAvailability();
			return availableRoom.getPrice();									//If successful, the method returns the price of the room.
		}
	}
	public boolean cancelRoom (String typeOfRoom) {								//The method makes a room of that type available again.
		return Room.makeRoomAvailable(hotelRooms, typeOfRoom);
	}
}
