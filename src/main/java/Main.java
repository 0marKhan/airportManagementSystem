

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		// flight calender obj//
		flightCalender fcObj = new flightCalender();

//******************************dates***************************************//

		DateAndTime d1 = new DateAndTime(15, "October");
		DateAndTime d2 = new DateAndTime(21, "October");
		DateAndTime d3 = new DateAndTime(29, "October");
		DateAndTime d4 = new DateAndTime(30, "October");
		DateAndTime d5 = new DateAndTime(5, "November");
		DateAndTime d6 = new DateAndTime(10, "November");
		DateAndTime d7 = new DateAndTime(15, "November");
		DateAndTime d8 = new DateAndTime(15, "December");
		DateAndTime d9 = new DateAndTime(30, "October");

//***************************15 flights**************************************//		

		flight f1 = new flight("Islamabad", "Riyadh", "Boeing 737", 50000, d1, 5); // indirect 1
		flight f2 = new flight("Riyadh", "Chicago", "Airbus A320", 80000, d1, 5); // indirect 2
		flight f3 = new flight("Peshawar", "Karachi", "Boeing 737", 18000, d2, 5);
		flight f4 = new flight("Islamabad", "Karachi", "Boeing 737", 18000, d3, 5); // indirect 1
		flight f5 = new flight("Karachi", "Dubai", "Airbus A320", 50000, d4, 5); // indirect 2
		flight f6 = new flight("Peshawar", "Hunza", "Boeing 737", 9000, d5, 5);
		flight f7 = new flight("Islamabad", "Hunza", "Boeing 737", 9000, d5, 5);
		flight f8 = new flight("Riyadh", "Peshawar", "Boeing 777-300ER", 50000, d6, 5);
		flight f9 = new flight("Riyadh", "Karachi", "Boeing 777-300ER", 50000, d7, 5);
		flight f10 = new flight("Gwadar", "Karachi", "Boeing 737", 18000, d7, 5);
		flight f11 = new flight("Gwader", "Hunza", "Boeing 737", 9000, d8, 5);
		flight f12 = new flight("Gwader", "Riyadh", "Boeing 777-300ER", 50000, d8, 5);
		flight f13 = new flight("Riyadh", "Gwader", "Boeing 777-300ER", 50000, d9, 5); // shows lower price1
		flight f14 = new flight("Riyadh", "Gwader", "Boeing 777-300ER", 30000, d7, 5); //
		flight f15 = new flight("Chicago", "Islamabad", "Boeing 737", 80000, d4, 5);

		fcObj.setFlight(f1); // storing flights in calender
		fcObj.setFlight(f2);
		fcObj.setFlight(f3);
		fcObj.setFlight(f4);
		fcObj.setFlight(f5);
		fcObj.setFlight(f6);
		fcObj.setFlight(f7);
		fcObj.setFlight(f8);
		fcObj.setFlight(f9);
		fcObj.setFlight(f10);
		fcObj.setFlight(f11);
		fcObj.setFlight(f12);
		fcObj.setFlight(f13);
		fcObj.setFlight(f14);
		fcObj.setFlight(f15);

// ********************* variables used in code ******************************//

		admin Admin = new admin();

		int count = 0; // counting number of flights
		int passCount = 0;
		int choice; // choice entered by user
		int choice2; // getting choice entered by user after login

		String searchOrigin, searchDestination; // for searching flight
		String loggedinUser = "", loggedinPass = ""; // user currently logged in

		boolean adminCheck = false; // check if an admins been created
		boolean bookingCheck[] = new boolean[50]; // checks if a user has booked a seat already or not
		for (int i = 0; i < 50; i++) {
			bookingCheck[i] = false;
		}

		passenger users[] = new passenger[50]; // for storing accounts of passengers
		for (int i = 0; i < 50; i++) {
			users[i] = new passenger();
		}

		// ****************************************************************************//

		do {
			System.out.println("_______________________________________________");
			System.out.println("|enter 1 to create an admin account            |");
			System.out.println("|enter 2 to create a user account	       |   ");
			System.out.println("|enter 3 to login into admin account           |");
			System.out.println("|enter 4 to login into an existing account     |");
			System.out.println("|enter 5 to print schedule and flight          |");
			System.out.println("|enter 0 to exit                               |");
			System.out.println("|______________________________________________|");
			choice = sc.nextInt();

			if (choice == 2) { // user creating an account
				String tmpUser, tmpPass;

				passenger u = new passenger();
				sc.nextLine();
				System.out.println("enter your username");
				tmpUser = sc.nextLine();

				System.out.println("enter your password");
				tmpPass = sc.nextLine();
				u.setUsername(tmpUser);
				u.setPassword(tmpPass);

				users[count] = u;
				count++;
				System.out.println("user account created successflly\n");
			} else if (choice == 1) {

				if (adminCheck == false) {

					sc.nextLine();
					System.out.println("enter admin username");
					Admin.setUsername(sc.nextLine());

					System.out.println("enter password");
					Admin.setPassword(sc.nextLine());

					System.out.println("admin created!");
					adminCheck = true;
				} else {
					System.out.println("an admin already exists");
				}

			} else if (choice == 3) { // login into admin account
				String tmpUser, tmpPass;

				sc.nextLine();
				System.out.println("enter admin username");
				tmpUser = sc.nextLine();

				System.out.println("enter admin password");
				tmpPass = sc.nextLine();

				if (Admin.getUsername().equals(tmpUser) && Admin.getPassword().equals(tmpPass)) {
					int adminChoice;

					System.out.println("login succcesful!\n");
					do { // if admin login successful
						System.out.println("enter 1 to add a flight");
						System.out.println("enter 0 to exit");
						adminChoice = sc.nextInt();

						if (adminChoice == 1) {
							try {
								Admin.addFlight(fcObj);
							} catch (flightOutOfBoundException e) {
								e.printStackTrace();
							}
						}

					} while (adminChoice != 0);
				} else {
					System.out.println("incorrect username or password");
				}
			} else if (choice == 4) {
				String tmpName, pass; // temp variables to store inputed name and password
				boolean check = false;

				sc.nextLine();
				System.out.println("enter your login name");
				tmpName = sc.nextLine();

				System.out.println("enter your password");
				pass = sc.nextLine();

				for (int i = 0; i < count; i++) {
					if (users[i].getUsername().equals(tmpName) && users[i].getPassword().equals(pass)) {
						check = true;
						loggedinUser = users[i].getUsername();
						loggedinPass = users[i].getPassword();
						// loggedinName = users[i].getName();
						break;
					}
				}
				if (check == true) {

					System.out.println("login successful!"); // successful login
					do {
						System.out.println("_________________________________________");
						System.out.println("|enter 1 to see all available flights    |");
						System.out.println("|enter 2 to search for a flight          |");
						System.out.println("|enter 3 to book a seat                  |");
						System.out.println("|enter 4 to see booking made             |");
						System.out.println("|enter 5 to cancel booking               |");
						System.out.println("|enter 0 to exit                         |");
						System.out.println("|________________________________________|");
						// System.out.println();
						choice2 = sc.nextInt();
						sc.nextLine();
						passenger p = new passenger();
						if (choice2 == 1) {
							for (int i = 0; i < fcObj.getFlightCount(); i++) {
								System.out.println("----------------------------------------------------");
								System.out.println("flight number: " + (i + 1));
								fcObj.farr[i].printFLight();

							}
						} else if (choice2 == 2) {
							int choice3;
							System.out.println(
									"flights available in Islamabad, Karachi, Peshawar, Riyadh, Chicago, Hunza");
							do {
								System.out.println("enter 1 to search for direct routes");
								System.out.println("enter 2 to search for indirect routes");
								System.out.println("enter 0 to exit");
								choice3 = sc.nextInt();

								if (choice3 == 1) {
									sc.nextLine();
									System.out.println("enter a origin city to search");
									searchOrigin = sc.nextLine();
									System.out.println("enter a destination city to search");
									searchDestination = sc.nextLine();

									flight[] arr1 = new flight[15];
									arr1 = fcObj.searchByOriAndDest(searchOrigin, searchDestination);
									for (int i = 0; arr1[i] != null; i++) {
										System.out.println("----------------------------------------------------");
										// System.out.println("flight number: " + (i + 1));
										arr1[i].printFLight(); // printing flight details
									}
									for (int i = 0; arr1[i] != null; i++) {
										for (int j = i + 1; arr1[j] != null; j++) {
											if (arr1[i].getOrigin().equals(arr1[j].getOrigin())
													&& arr1[i].getDestination().equals(arr1[j].getDestination())) {
												if (arr1[i].getTicketPrice() > arr1[j].getTicketPrice()) {
													DateAndTime d = arr1[j].getDate();
													System.out.println("on date: " + d.getDay() + ", " + d.getMonth()
															+ ", " + 2021 + " the price is cheaper for this flight\n");
												} else {
													DateAndTime d = arr1[i].getDate();
													System.out.println("on date: " + d.getDay() + ", " + d.getMonth()
															+ ", " + 2021 + " the price is cheaper for this flight\n");
												}
											}
										}
									}

								} else if (choice3 == 2) {
									sc.nextLine();
									System.out.println("enter a origin city to search");
									searchOrigin = sc.nextLine();
									System.out.println("enter a destination city to search");
									searchDestination = sc.nextLine();
									flight[] arr1 = new flight[15];
									arr1 = fcObj.searchIndirectRoutes(searchOrigin, searchDestination);
									for (int i = 0; arr1[i] != null; i++) {
										arr1[i].printFLight();
									}
								}
							} while (choice3 != 0);

						} else if (choice2 == 3) {
							int flightNo;
							for (int i = 0; i < fcObj.getFlightCount(); i++) {
								System.out.println("----------------------------------------------------");
								System.out.println("flight number: " + (i + 1));
								fcObj.farr[i].printFLight();
							}
							System.out.println("enter flight no to book it: ");
							flightNo = sc.nextInt();

							System.out.println("enter the rest of your details to confirm booking");
							p.addPassengerDetails();
							if (p.getUsername().equals(loggedinUser) == false
									|| p.getPassword().equals(loggedinPass) == false) {
								System.out.println("incorrect username or password entered"); // if user name or
																								// password incorrect
								break;
							}
						
							double tmp=fcObj.farr[flightNo-1].getTicketPrice();
							
							try {
						
								fcObj.farr[flightNo - 1].addPassenger(p); // adding passenger to flight
							} catch (passengerOutOfBoundsException e) {

								e.printStackTrace();
							}
							
							String tmpClass=p.getClas();
							fcObj.farr[flightNo-1].setClass(tmpClass);
							
							if(p.getClas().equals("buisness")) {	//setting price if buisness
								tmp=tmp+(tmp*1.2);
								fcObj.farr[flightNo-1].setTicketPrice(tmp);
							}
							
							
							System.out.println("enter your credit card number to confirm payment");
							int cardno = sc.nextInt();

							fcObj.printTicket(flightNo, p);

							System.out.println("e-ticket has been printed");
							p.setReferenceNo();	//giving reference number a random num
							System.out.println("your reference number is " + p.getReferenceNo());
							System.out.println("ticket in flight " + flightNo + " successfully booked!\n");
						} else if (choice2 == 4) { // showing current booking
							System.out.println("booking currently made");
							for (int i = 0; i < fcObj.getFlightCount(); i++) {
								for (int j = 0; j < fcObj.farr[i].getPassCount(); j++) {
									if (fcObj.farr[i].passObj[j].getUsername().equals(loggedinUser)
											&& fcObj.farr[i].passObj[j].getPassword().equals(loggedinPass)) {
										fcObj.farr[i].printFLight();
									}
								}
							}

						} else if (choice2 == 5) { // cancelling booking
							for (int i = 0; i < fcObj.getFlightCount(); i++) {
								for (int j = 0; j < fcObj.farr[i].getPassCount(); j++) {
									if (fcObj.farr[i].passObj[j].getUsername().equals(loggedinUser)
											&& fcObj.farr[i].passObj[j].getPassword().equals(loggedinPass)) {
										fcObj.farr[i].removePassenger(loggedinUser, loggedinPass);
									}
								}
							}
							System.out.println("booking cancelled");
						}

					} while (choice2 != 0);
				} else {
					System.out.println("incorrect username or password\n"); // if username or login not found
				}

			} else if (choice == 5) {
				fcObj.printToFile();
				System.out.println("details printed successfully!\n\n");
			}

		} while (choice != 0);

	}

}
