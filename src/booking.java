/**
 * booking class that is used for booking process to calculate number of hours  and price
 *
 */

public class booking {

    int start_time;
    int end_time;
   private int number_of_hours;
   private double price;
   playground pg;
   player p;
   boolean finished=false;

    public double calculate_price(double price_per_hour){
        number_of_hours=getNumber_of_hours();
        this.price=number_of_hours*price_per_hour;
        return price;
    }

    public int getNumber_of_hours() {
       number_of_hours=end_time-start_time;
        return number_of_hours;
    }

    public void print(){
        System.out.println("number of hours "+number_of_hours);
        System.out.println("from "+start_time+" to "+end_time);
        System.out.println("The price of hours "+price);
    }

}
