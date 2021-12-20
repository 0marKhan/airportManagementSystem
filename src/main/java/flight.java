

public class flight {
	private String origin;
	private String destination;
	private String planeType;

	private int passCount;
	private double ticketPrice;
	private int seatCount;
	public String flightClass;
	
	private String flightType;

	passenger passObj[]; // passengers in the flight
	private DateAndTime date;

	flight() {
		flightClass="economy";
		origin = "";
		destination = "";
		planeType = "";
		ticketPrice = 0;
		passCount = 0; // number of passengers
		seatCount = 5;

		passObj = new passenger[5];
		for (int i = 0; i < 5; i++) {
			passObj[i] = new passenger();

		}
		date = new DateAndTime();

	}

	flight(String orig, String dest, String planeT, double price, DateAndTime d, int noOfSeats) {
		origin = orig;
		destination = dest;
		planeType = planeT;
		ticketPrice = price;
		date = d;
		seatCount = noOfSeats;
		passObj = new passenger[5];
		for (int i = 0; i < 5; i++) {
			passObj[i] = new passenger();

		}

	}

//****************setters*********************//

	public void setOrigin(String o) {
		origin = o;
	}
	
	public void setClass(String c) {
		flightClass=c;
	}
	
	public void setFlightType(String t) {
		flightType=t;
	}

	public void setDestination(String d) {
		destination = d;
	}

	public void setPlaneType(String p) {
		planeType = p;
	}

	public void setTicketPrice(double p) {
		ticketPrice = p;
	}

	public void setDate(DateAndTime d) {
		date = d;
	}

	public void setSeats(int s) {
		seatCount = s;
	}

//**************getters************************//

	public String getOrigin() {
		return origin;
	}
	

	public String getDestination() {
		return destination;
	}

	public String getPlaneType() {
		return planeType;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public DateAndTime getDate() {
		return date;
	}

	public int getPassCount() {
		return passCount;
	}

	public int getSeatCount() {
		return seatCount;
	}

//***************************************************//

	public void addPassenger(passenger p) throws passengerOutOfBoundsException {
		// to add passenger to flight

		if (passCount >= 1) { // exception thrown if limit of 5 seats exceeded
			throw new passengerOutOfBoundsException("the limit for passengers in the flight is 5\n");
		}

		passObj[passCount] = p;
		passCount++;
		seatCount--;
	}

	public void removePassenger(String usr, String pass) {
		passenger p = new passenger();

		for (int i = 0; i < passCount; i++) {
			if (passObj[i].getName().equals(usr) && passObj[i].getUsername().equals(pass)) {
				passObj[i] = p;
			}
		}
		passCount--;
		seatCount++;
	}
	

	public void printFLight() { // print flight details

		System.out.println("flight origin: " + origin);
		System.out.println("flight destination: " + destination);
		System.out.println("plane type: " + planeType);
		System.out.println("flight class: " + flightClass);
		System.out.println("price: " + ticketPrice);
		System.out.println("seats available: " + seatCount);
		DateAndTime d = getDate(); // gets date of departure

		System.out.print("date of departure: ");
		d.displayDate();
		System.out.println("");
	}

}
