import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class playground {
    private static final AtomicInteger count = new AtomicInteger(0);
    int id = count.incrementAndGet();
    String name;
    String location;
    int size;
    int price;
    ArrayList<Reserved_hours> available_hours;
    playground_owner plo;
    ArrayList<booking>reservations;
    public void get_free_hours(){
        for(int i=0;i<reservations.size();i++){
            for(int j=0;j<available_hours.size();j++){
                if(available_hours.get(j).hour==reservations.get(i).start_time){
                    for(int k=j;k<reservations.get(i).number_of_hours;k++){
                        available_hours.get(j).free_to_reserve=false;

                    }
                }
            }

        }

    }
    public void print_playground(){
        System.out.println("It is number to reserve is "+id);
        System.out.println("The playground name is "+name);
        System.out.println("The location "+ location);
        System.out.println("The playground size "+size);
        System.out.println("The playground price per hour is "+price);





    }

}
