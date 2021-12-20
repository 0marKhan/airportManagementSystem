

import java.util.Scanner;

public class admin {

	private String username;
	private String password;

	admin() {
		username = "";
		password = "";
	}

	public void setUsername(String n) {
		username = n;
	}

	public void setPassword(String p) {
		password = p;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void addFlight(flightCalender fObj) throws flightOutOfBoundException {

		if (fObj.getFlightCount() > 17) {
			throw new flightOutOfBoundException("maximum number of flights are 17");
		} else {

			Scanner sc = new Scanner(System.in);
			DateAndTime d = new DateAndTime();

			flight f = new flight();
			System.out.println("enter origin city");
			f.setOrigin(sc.nextLine());

			System.out.println("enter the destination");
			f.setDestination(sc.nextLine());

			System.out.println("enter the plane type");
			f.setPlaneType(sc.nextLine());

			System.out.println("enter the price");
			f.setTicketPrice(sc.nextDouble());
			sc.nextLine();

			System.out.println("enter the day of the flight");
			d.setDay(sc.nextInt());
			sc.nextLine();

			System.out.println("enter the month of the flight");
			d.setMonth(sc.nextLine());

			d.setYear(2021);

			f.setDate(d);
			f.setSeats(5);

			fObj.setFlight(f);
			System.out.println("flight added successfully");
		}
	}
}
