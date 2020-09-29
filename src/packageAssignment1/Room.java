package packageAssignment1;

public class Room {
	
	private String typeOfRoom; 
	private int priceOfRoom;															//the price (in cents)
	private boolean roomAvailability; 													//whether or not the room is available.
	
	public Room (String typeOfRoom) {
		if (typeOfRoom.equalsIgnoreCase("double")) {
			this.priceOfRoom = 9000;													//price in cents
			this.roomAvailability = true;												//sets availability to true
			this.typeOfRoom = typeOfRoom.toLowerCase();
		}
		else if (typeOfRoom.equalsIgnoreCase("queen")) {
			this.priceOfRoom = 11000;													//price in cents
			this.roomAvailability = true;												//sets availability to true
			this.typeOfRoom = typeOfRoom.toLowerCase();
		}
		else if (typeOfRoom.equalsIgnoreCase("king")) {
			this.priceOfRoom = 15000;													//price in cents
			this.roomAvailability = true;												//sets availability to true
			this.typeOfRoom = typeOfRoom.toLowerCase();
		}
		else {
			throw new IllegalArgumentException("no room of such type can be created");
		}
	}
	public Room (Room room) {
		this.priceOfRoom = room.priceOfRoom;
		this.roomAvailability = room.roomAvailability;
		this.typeOfRoom = room.typeOfRoom;
	}
	public String getType() {															//getter to return type of room
		return this.typeOfRoom;
	}
	public int getPrice() { 															//getter to return price of room 
		return this.priceOfRoom;
	}
	public void changeAvailability() {													//method to change availability to opposite
		this.roomAvailability=!this.roomAvailability;									//changes it to the opposite 
	}
	public static Room findAvailableRoom (Room[]rooms, String typeOfRoom) {				//the first available room
		for (int i = 0; i < rooms.length; i++){
	      if ((rooms[i].roomAvailability == true) && (rooms[i].getType().equalsIgnoreCase(typeOfRoom)))
	    	  return rooms[i];  
	    }
		return null;   																	//otherwise
	}
	public static boolean makeRoomAvailable (Room[]rooms, String typeOfRoom) {
		boolean check = false;															//setting check to false
		for (int i = 0; i < rooms.length; i++){
	           if (rooms[i].roomAvailability == false && rooms[i].getType().equalsIgnoreCase(typeOfRoom)){
	        	  rooms[i].changeAvailability();										//changes availability
	        	  check = rooms[i].roomAvailability;
	           }else {
	    	  check = rooms[i].roomAvailability;
	           }   
		}
		return check;
	}
}
