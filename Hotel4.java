package workshop;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

class Hotel{
    public String getHotelName() {
        return hotelName;
    }
    public Hotel(){};

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelPriceWeekDays() {
        return hotelPriceWeekDays;
    }

    public void setHotelPriceWeekDays(int hotelPriceWeekDays) {
        this.hotelPriceWeekDays = hotelPriceWeekDays;
    }

    public int getHotelPriceWeekEnds() {
        return hotelPriceWeekEnds;
    }

    public void setHotelPriceWeekEnds(int hotelPriceWeekEnds) {
        this.hotelPriceWeekEnds = hotelPriceWeekEnds;
    }
    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ",hotelPriceWeekDays=" + hotelPriceWeekDays +
                ",hotelPriceWeekEnds=" + hotelPriceWeekEnds +
                '}'+"\n";
    }

    public Hotel(String hotelName, int hotelPriceWeekDays, int hotelPriceWeekEnds) {
        this.hotelName = hotelName;
        this.hotelPriceWeekDays = hotelPriceWeekDays;
        this.hotelPriceWeekEnds = hotelPriceWeekEnds;
    }

    private String hotelName;
    private int hotelPriceWeekDays;
    private int hotelPriceWeekEnds;

}

//this class will do booking hotels and list of hotels and finding weekdays count and finding best rate hotel
public class HotelReservation extends Hotel {
    public ArrayList<Hotel> hotelDetails = new ArrayList<Hotel>();

    //ooking hotels and list of hotels
    public void addHotel(String hotelName, int hotelPriceWeekDays, int hotelPriceWeekEnds) {
        Hotel adder = new Hotel(hotelName, hotelPriceWeekDays, hotelPriceWeekEnds);
        hotelDetails.add(adder);
    }
    public void getHotelDetails(){
        System.out.println(hotelDetails);
    }
   // finding weekEnds count
    public int getWeekDaysCount(LocalDate dateStart, int noOfDays){
        int weekEnds = 0;
        int temp = noOfDays;
        while (noOfDays>0){
            String d = dateStart.getDayOfWeek().toString();
            if ( (d.equals("SUNDAY")) || (d.equals("SATURDAY")) ) {
                weekEnds++;
            }
            dateStart = dateStart.plusDays(1);
            noOfDays--;
        }
        System.out.println("WeekEnd days count is :"+weekEnds);
        System.out.println("WeekDay days count is :"+(temp-weekEnds));
        return weekEnds;
    }
    //finding best rate hotel
    public void getMinPriceHotel(int weekEndsCount, int weekDaysCount){
        Hotel minWeekDays =  hotelDetails.stream().min(Comparator.comparing(Hotel::getHotelPriceWeekDays)).orElseThrow();
        Hotel minWeekEnd =  hotelDetails.stream().min(Comparator.comparing(Hotel::getHotelPriceWeekEnds)).orElseThrow();
        long totalRate1=0;
        long totalRate2=0;
        totalRate1 =  (weekEndsCount) * (minWeekDays.getHotelPriceWeekEnds()) + (weekDaysCount) * (minWeekDays.getHotelPriceWeekDays());
        totalRate2 = (weekEndsCount) * (minWeekEnd.getHotelPriceWeekEnds()) + (weekDaysCount) * (minWeekEnd.getHotelPriceWeekDays());

        if (totalRate1<totalRate2){
            System.out.println("Best rate Hotel is : "+minWeekDays.getHotelName());
            System.out.println(minWeekDays);
            System.out.println(minWeekDays.getHotelName()+" Total Rate is : "+totalRate1);
        } else{
            System.out.println("Best Price rate Hotel is : "+minWeekEnd.getHotelName());
            System.out.println(minWeekEnd);
            System.out.println(minWeekEnd.getHotelName()+" Total Rate is : "+totalRate2);
        }
    }

}