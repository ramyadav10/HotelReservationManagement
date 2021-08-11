package workshop;

import java.time.LocalDate;

import java.time.Month;
import java.time.temporal.ChronoUnit;

public class HotelReservationMain {
    public static void main(String[] args) {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("LakeWood", 110, 90, 3);
        hotelReservation.addHotel("BridgeWood", 150, 50, 4);
        hotelReservation.addHotel("RidgeWood", 220, 150, 5);
        //list out hotel Details
        hotelReservation.getHotelDetails();

        //giving start and end dates of the schedule
        LocalDate dateStart = LocalDate.of(2021, Month.AUGUST, 11);
        LocalDate dateEnd = LocalDate.of(2021, Month.AUGUST, 20);
        System.out.println("Starting date : "+dateStart);
        System.out.println("Ending date : "+dateEnd);
        int noOfDays = (int) ChronoUnit.DAYS.between(dateStart, dateEnd);
        System.out.println("Total days is : "+noOfDays);
        //finding getWeekDaysCount
        int weekEndsCount = hotelReservation.getWeekDaysCount(dateStart, noOfDays);
        int weekDaysCount = noOfDays - weekEndsCount;

        //find getMinPriceHotel
        hotelReservation.getMinPriceHotel(weekEndsCount, weekDaysCount);

    }
}