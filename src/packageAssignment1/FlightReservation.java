package packageAssignment1;

public class FlightReservation extends Reservation {
	
	private Airport placeOfDeparture;																//An Airport indicating the place of departure.
	private Airport placeOfArrival;																	//An Airport indicating the place of arrival.
								
	public FlightReservation(String name, Airport placeOfDeparture, Airport placeOfArrival) {
		super(name);																				//because of the abstract class
		this.placeOfArrival = placeOfDeparture;														//initializing variables
		this.placeOfDeparture = placeOfArrival;
			if(placeOfDeparture.equals(placeOfArrival)) {
				throw new IllegalArgumentException();
			}
	}
	public int getCost() {
		int costOfReservations=0;																	//in cents
		double costPerGallon = 124; 																//in cents
		double distancePerGallon = 167.52; 															//kilometer per gallon of fuel.
		int departureFees = placeOfDeparture.getFees();
		int arrivalFees = placeOfArrival.getFees();
		double planeCosts = 5375; //in cents
		double extras = departureFees+arrivalFees+planeCosts;
		int kmFlown = Airport.getDistance(placeOfDeparture, placeOfArrival);
		costOfReservations = (int)Math.ceil(((kmFlown/distancePerGallon)*costPerGallon)+extras);
		return costOfReservations;
	}
	public boolean equals(Object o) {
		boolean status = false;
		if (o instanceof FlightReservation) {	
			FlightReservation current=(FlightReservation) o;
				if((current.reservationName().equalsIgnoreCase(this.reservationName()) 				//checking if equals
						&& (current.placeOfArrival.equals(this.placeOfArrival))
						&& (current.placeOfDeparture.equals(this.placeOfDeparture)))) {
					status =true;
				}
		}
		return status;
	}
}
