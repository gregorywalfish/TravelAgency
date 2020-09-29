package packageAssignment1;

public class Basket {
	
	private Reservation[] resArray;
	private int size;
	
	
	public Basket() {
		this.resArray = new Reservation[10];								//initializes
		this.size = 0;
		
	}
	public Reservation[] getProducts() {
		Reservation[] products = new Reservation [size];
		int i=0;										//creates shallow copy
		for (; i<products.length;i++) {
			products[i]=resArray[i];
		}
		return products;
	}
	public int add (Reservation r) {
		if (this.resArray.length== this.size) {								//if array is too small to add
			int lengthUpdate = (this.resArray.length*2);					//we double the length
			Reservation [] newArray= new Reservation [lengthUpdate];		//doubling the length
			int i =0;
			for (; i<lengthUpdate/2; i++) {									//go through array to put eveerything in new one
					newArray[i] = this.resArray[i];
			}
			newArray[i]=r;													//now point the new array to r
			this.size++;													//increasing the size every time
			this.resArray =newArray;
		}else {
			resArray[size]=r;												//if array is big enough just add new one
			this.size++;													//and increase size
		}
		return this.size;													//returns the size
	}
//	private int indexOf (Reservation r) {
//		for (int i = 0; i < size; i++) {
//			if (getProducts()[i].equals(r)) {
//				return i;
//			}
//		}
//		return -1;
//	}
	public boolean remove (Reservation r) {
		boolean status = false;												//at first we set to false
		for (int i = 0; i < size; i++) {									//going through the array
			if (resArray[i].equals(r)){										//to see if it equals

					for (int k = i; k < size-1; k++) {						//now we are shifting
						resArray[k] = resArray[k+ 1];
					}
					resArray [size]=null;
					size = size-1;											//make size smaller
																			//remove the spot
					status = true;											//set to true
				}
			}	
		return status;		
	}
	public void clear() {													//clear method
		for (int i = 0; i < this.size; i++) {									//going through array
			resArray[i]=null;											//set everything to null
		}
		size=0;
	}
	public int getNumOfReservations() {
		int numOfReservations =0;											//set to 0
		for (int i = 0; i < size; i++) {									//go through array
			if (this.resArray[i] == null){									//if nothing there we dont care
			}	
			else {
				numOfReservations++;										//otherwise increase the num of res
			}
		}
		return numOfReservations;											//return total
	}
	public int getTotalCost() {	
		int sum=0;
		
		for (int i = 0; i < this.size; i++) { 
			
			sum+= resArray[i].getCost();
		
		}
		
		
		return sum;								
	}
}


