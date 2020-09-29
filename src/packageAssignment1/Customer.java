package packageAssignment1;

public class Customer extends Basket {
	
	private String name;
	private int balance; 																			//in cents
	private Basket customerResos;
	
	public Customer (String name, int balance)  {
		super();
		this.customerResos = new Basket() ;
		this.balance = balance;
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public int getBalance() {
		return this.balance;
	}
	public Basket getBasket() {
		return customerResos;
	}
	public int addFunds (int a) {
		if (a<=0) {
			throw new IllegalArgumentException("negative funds declined");
		}
		else {
			this.balance+=a;
		}
		return this.balance;
	}
	public int addToBasket (Reservation r1) {									//adds
		customerResos.add(r1);
		return customerResos.getNumOfReservations();
	}
	public int addToBasket (Hotel h, String n, int i, boolean b) {	//this is a hotel reservation
		if(b==true) {
		BnBReservation r2b = new BnBReservation(name,h,n,i);
		customerResos.add(r2b);
		}else {
		HotelReservation r2 = new HotelReservation(name,h, n, i);
		customerResos.add(r2);
		}
		return customerResos.getNumOfReservations();
	}
	public int addToBasket (Airport one, Airport two) {	//this is a flight reservation
		FlightReservation r3 = new FlightReservation(name, one, two);
		customerResos.add(r3);
		return customerResos.getNumOfReservations();
	}
	public boolean removeFromBasket (Reservation r) {							//removes
		boolean res = customerResos.remove(r);
		return res;
	}
	public int checkOut() {
		//System.out.println(getTotalCost());
		if (getTotalCost() > getBalance()) {
			throw new IllegalStateException();
		}else {
			balance = getBalance() - customerResos.getTotalCost();
			System.out.println(getBalance());
			customerResos.clear();
		}
		return balance;
	}
}
