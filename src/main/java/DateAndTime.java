

public class DateAndTime {

	private int day;
	private String month;
	private int year;

	DateAndTime() {
		day = 0;
		month = "";
		year = 2021;
	}

	DateAndTime(int d, String m) {
		day = d;
		month = m;
		year = 2021;
	}

//***********************setters****************************//

	public void setDay(int d) {
		day = d;
	}

	public void setMonth(String m) {
		month = m;
	}

	public void setYear(int y) {
		year = y;
	}

//**********************getters*****************************//	

	public int getDay() {
		return day;
	}

	public String getMonth() {
		return month;
	}

	public void displayDate() {
		System.out.println(day + ", " + month + ", " + year);
	}
}
