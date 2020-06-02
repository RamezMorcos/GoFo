public class booking {

    int start_time;
    int end_time;
    int number_of_hours;
   private double price;
   playground pg;
   player p;
   boolean finished=false;
   booking(){
       number_of_hours=end_time-start_time;
   }
    public double calculate_price(int price_per_hour){
        this.price=number_of_hours*price_per_hour;
        return price;
    }
    public void print(){
        System.out.println("number of hours "+number_of_hours);
        System.out.println("from "+start_time+" to "+end_time);
        System.out.println("The price of hours "+price);
    }

}
