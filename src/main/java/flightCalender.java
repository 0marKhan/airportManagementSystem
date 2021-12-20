
import java.io.FileWriter;
import java.io.IOException;

public class flightCalender {
	flight farr[];
	int flightCount;
	int flightNo;

	flightCalender() {
		farr = new flight[17];
		for (int i = 0; i < 17; i++) {
			farr[i] = new flight();
		}

		flightCount = 0;
	}

	public int getFlightCount() {
		return flightCount;
	}

	public void setFlight(flight f) {
		farr[flightCount] = f;
		flightCount++;
	}

	public flight[] searchByOriAndDest(String origin, String dest) {

		flight[] f = new flight[17];

		int count = 0;
		for (int i = 0; i < flightCount; i++) {
			if (farr[i].getOrigin().equals(origin) && farr[i].getDestination().equals(dest)) {
				f[count] = farr[i];
				count++;
			}
		}
		return f;
	}

	public flight[] searchByOrigin(String searchOrigin) {

		flight[] f = new flight[17];
		int count = 0;
		for (int i = 0; i < flightCount; i++) {
			if (farr[i].getOrigin().equals(searchOrigin)) {
				f[count] = farr[i];
				count++;
			}
		}
		return f;

	}

	public flight[] searchByDestination(String searchDestination) {

		flight[] f = new flight[17];
		int count = 0;
		for (int i = 0; i < flightCount; i++) {
			if (farr[i].getDestination().equals(searchDestination)) {
				f[count] = farr[i];
				count++;
			}
		}
		return f;

	}

	public flight[] searchByPlaneType(String planeSearch) {

		flight[] f = new flight[17];
		int count = 0;
		for (int i = 0; i < flightCount; i++) {
			if (farr[i].getPlaneType().equals(planeSearch)) {
				f[count] = farr[i];
				count++;
			}
		}
		return f;

	}

	public flight[] searchByDate(DateAndTime searchDate) {

		flight[] f = new flight[17];
		int count = 0;
		for (int i = 0; i < flightCount; i++) {
			if (farr[i].getDate().equals(searchDate)) {
				f[count] = farr[i];
				count++;
			}
		}
		return f;

	}

	public flight[] searchByPrice(double searchPrice) {

		flight[] f = new flight[17];
		int count = 0;
		for (int i = 0; i < flightCount; i++) {
			if (farr[i].getTicketPrice() == searchPrice) {
				f[count] = farr[i];
				count++;
			}
		}
		return f;

	}

	public flight[] searchIndirectRoutes(String origin, String dest) {

		flight[] f = new flight[17];

		String tmpDest = "";

		int count1 = 0;

		for (int i = 0; i < flightCount; i++) {
			if (farr[i].getOrigin().equals(origin)) {
				tmpDest = farr[i].getDestination();
				f[count1] = farr[i];
				count1++;
			}
		}
		// count1 = 0;
		for (int i = 0; i < flightCount; i++) {
			if (farr[i].getOrigin().equals(tmpDest) && farr[i].getDestination().equals(dest)) {
				f[count1] = farr[i];
				count1++;

			}
		}

		return f;

	}

	public void printTicket(int flightNo, passenger p) {
		int year = 2021;
		try {

			FileWriter myWriter = new FileWriter("ticket.txt");
			myWriter.write("e-ticket\n");
			myWriter.write("name: " + p.getName() + "\n");
			myWriter.write("address: " + p.getAddress() + "\n");
			myWriter.write("plane class: " + p.getClas() + "\n");
			myWriter.write("origin city: " + farr[flightNo - 1].getOrigin() + "\n");
			myWriter.write("destination city: " + farr[flightNo - 1].getDestination() + "\n");
			myWriter.write("plane type: " + farr[flightNo - 1].getPlaneType() + "\n");
			myWriter.write("price paid: " + farr[flightNo - 1].getTicketPrice() + "\n");
			DateAndTime d = farr[flightNo - 1].getDate();

			myWriter.write("date of flight: " + d.getDay() + ", " + d.getMonth() + ", " + year + "\n");
			myWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error creating file");
		}
	}

	public void printToFile() {

		FileWriter fr;
		try {
			fr = new FileWriter("flightDetails.txt");
			for (int i = 0; i < flightCount; i++) {
				fr.write("flight number: " + (i + 1) + "\n");
				fr.write("flight origin: " + farr[i].getOrigin() + "\n");
				fr.write("flight destination: " + farr[i].getDestination() + "\n");
				fr.write("plane type: " + farr[i].getPlaneType() + "\n");
				fr.write("price: " + farr[i].getTicketPrice() + "\n");
				fr.write("seats available: " + farr[i].getSeatCount() + "\n");
				DateAndTime d = farr[i].getDate(); // gets date of departure
				fr.write("date: " + d.getDay() + ", " + d.getMonth() + ", " + 2021 + "\n\n");

				fr.write("passengers\n");
				for (int j = 0; j < farr[i].getPassCount(); j++) {
					fr.write("passenger name: " + farr[i].passObj[j].getName() + "\n");
					fr.write("passenger address: " + farr[i].passObj[j].getAddress() + "\n");
					fr.write("passenger age: " + farr[i].passObj[j].getAge() + "\n");
					fr.write("\n\n");
				}
			}
			fr.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
