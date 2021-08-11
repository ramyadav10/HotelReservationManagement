package workshop;

public class Hotel {

	private String name;
	private int rate;
    private int weekendRate;
    private int weekdayRate;
    public Hotel(String name, int rate) {
        this.name = name;
        this.rate = rate;
    }
    public Hotel(String name, int weekendRate, int weekdayRate) {
        this.name = name;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
    }

    public String toString() {
        return "Hotel: " + name + "  Rate for weekend Rate: " + weekendRate+" Rate for weekend Rate:"+weekdayRate;
    }
 
    public void setRate(int count) {
        this.rate = this.rate*count;
    }

    public int getRate() {
        return rate;
    }

}
