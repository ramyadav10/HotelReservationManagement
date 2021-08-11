package workshop;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddHotel {

	public static Map<String, Integer> hotel = new HashMap<String, Integer>();
	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation Program in HotelReservation");
		NewEntry();
		System.out.println(hotel);
	}

	public static void NewEntry() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Hotel Name: ");
		String hotelName=sc.next();
		System.out.println("Enter the Per Day Rate for Regular Customers: ");
		int ratePerDay=sc.nextInt();
		hotel.put(hotelName,ratePerDay );

	}
}
