

import java.util.Random;
import java.util.Scanner;

public class passenger {

	private String name;
	private String address;
	private String clas;

	private String loginName;
	private String password;

	private int age;
	private int passportNum;
	private int referenceNo;

	// constructor

	passenger() {
		name = "";
		address = "";
		clas = "";
		age = 0;
		passportNum = 0;
		referenceNo = new Random().nextInt(900000) + 100000;;
		loginName = "";
		password = "";
	}

//************************setters*****************************//

	public void setName(String n) {
		name = n;
	}

	public void setAdress(String a) {
		address = a;
	}

	public void setClass(String g) {
		clas = g;
	}

	public void setAge(int a) {
		age = a;
	}

	public void setPassportNum(int p) {
		passportNum = p;
	}

	public void setUsername(String l) {
		loginName = l;
	}

	public void setPassword(String p) {
		password = p;
	}

	public String setReferenceNo() {
		 Random rnd = new Random();
		 int number = rnd.nextInt(999999);

		 // this will convert any number sequence into 6 character.
		 return String.format("%06d", number);
	}

//******************getters*******************************//

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getClas() {
		return clas;
	}

	public int getAge() {
		return age;
	}

	public int getPassportNum() {
		return passportNum;
	}

	public int getReferenceNo() {
		return referenceNo;
	}

	public String getUsername() {
		return loginName;
	}

	public String getPassword() {
		return password;
	}

	public void addPassengerDetails() {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter your name");
		name = sc.nextLine();

		System.out.println("enter your address");
		address = sc.nextLine();

		System.out.println("enter class you wish to select (buisness is 1.2 times more expensive than economy)");
		clas = sc.nextLine();

		System.out.println("enter your age");
		age = sc.nextInt();

		sc.nextLine();

		System.out.println("enter your login name");
		loginName = sc.nextLine();

		System.out.println("enter your password");
		password = sc.nextLine();

		// passCount++; // increase count of passengers

	}

//*************************************************************//

}
