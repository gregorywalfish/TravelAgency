package packageAssignment1;

public class HotelReservation extends Reservation{
	
	private Hotel hotelName;
	private String typeOfRoom;
	private int numNights;
	private int pricePerNight;
	
	public HotelReservation(String name, Hotel hotelName,String typeOfRoom, int numNights ) {
		super(name);
		this.hotelName = hotelName;
		this.typeOfRoom = typeOfRoom;
		this.numNights = numNights;
		this.pricePerNight = this.hotelName.reserveRoom(typeOfRoom);							//indicating the price (in cents) for one night in a room
	}
	public int getNumOfNights() {																//getter
		return this.numNights;
	}
	public int getCost() {
		return this.numNights*this.pricePerNight;
	}
	public boolean equals(Object o) {
		boolean status = false;
			if (o instanceof HotelReservation) {
				HotelReservation current=(HotelReservation) o;
					if((current.reservationName().equalsIgnoreCase(this.reservationName()) 			//checking if equals
						&& (current.typeOfRoom.equals(this.typeOfRoom))
						&& (current.getNumOfNights() == this.getNumOfNights())
						&& (current.hotelName.equals(this.hotelName))
						&& (current.getCost() == this.getCost()))){
					status =true;	
					}
			}
		return status;
	}
}
