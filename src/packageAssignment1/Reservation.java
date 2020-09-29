package packageAssignment1;

abstract class Reservation {
	
	String name;									//client name
	
	public Reservation(String name) {
		this.name = name;
	}
	public final String reservationName() {			//final because we cannot change the name of the client
		return this.name;
	}
	public abstract int getCost();					//not implemented because how to determine the cost depends on the type of reservation.
	public abstract boolean equals(Object o);		//not implemented because how to determine the cost depends on the type of reservation.
}
