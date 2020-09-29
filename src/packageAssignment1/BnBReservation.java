package packageAssignment1;

public class BnBReservation extends HotelReservation{
	public BnBReservation(String clientName,Hotel name, String typeOfRoom, int numNights ) {		
		super(clientName, name, typeOfRoom, numNights);											//creates new
	}
	public int getCost() {
		return super.getCost()+ getNumOfNights()*1000;										//adds $10 for breakfast
	}
}
