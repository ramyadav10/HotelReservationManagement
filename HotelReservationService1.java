package workshop;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


public class HotelReservationService {

	private List<Hotel> hotelList = new ArrayList<>();

    public void addHotel(Hotel hotel){
        hotelList.add(hotel);
    }

    public List<Hotel> getHotels(){
        return hotelList;
    }
    
    public int CountDays(String firstDate, String lastDate) {
        LocalDate startDate = LocalDate.parse(firstDate);
        LocalDate endDate = LocalDate.parse(lastDate);
        return  (int) ChronoUnit.DAYS.between(startDate,endDate);
    }
 
    public Hotel findCheapestHotel(int countDays) {
        hotelList.stream().map(p -> {p.setRate(countDays); return p.getRate(); }).collect(Collectors.toList());
        Hotel cheapestRate =  hotelList.stream().min(Comparator.comparing(Hotel::getRate)).orElseThrow(NoSuchElementException::new);
        return cheapestRate;
    }
}