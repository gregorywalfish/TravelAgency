package packageAssignment1;

public class Airport {
	
	private int x; 																//An int indicating the x-coordinate of the airport on a world map with a scale to 1 km.
	private int y; 																//An int indicating the y-coordinate of the airport on a world map with a scale to 1 km.
	private int airportFees; 													//An int indicating the airport fees (in cents) associated to this airport.
	
	public Airport(int x, int y, int airportFees) {								//constructor that takes three int as input to initialize the corresponding fields.
		this.x = x;																//x-coordinate
		this.y = y;																//y-coordinate
		this.airportFees = airportFees;											//airport fees
	}
	public int getFees() {														//method to retrieve the fees of the airport
		return this.airportFees;
	}
	public static int getDistance(Airport airportOne, Airport airportTwo) {		//A static method getDistance which takes as input two airport 
		int distance =(int) Math.ceil( Math.sqrt(Math.pow(airportOne.x - airportTwo.x, 2) + Math.pow(airportOne.y - airportTwo.y, 2)));
		return distance;														//returns a integer indicating the distance in kilometer between the two airports
	}
}