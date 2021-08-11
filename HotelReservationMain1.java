package workshop;


public class HotelReservationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HotelReservationService hRS = new HotelReservationService();
		Hotel ramada=new Hotel("Ramada", 120, 90);
		Hotel taj=new Hotel("Taj", 100,80);
		hRS.addHotel(ramada);
		hRS.addHotel(taj);
		

        int countDays = hRS.CountDays("2020-08-10","2020-08-12");
        System.out.println("Total Number of Days are: "+countDays);
        Hotel result = hRS.findCheapestHotel(countDays);
        System.out.println(result);
	
	}

}
