import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * playground class which has playground with it is information and refresh its free time after each reservation
 */
public class playground {
    private static final AtomicInteger count = new AtomicInteger(0);
    int id = count.incrementAndGet();
    String name;
    String location;
    int size;
    double price;
    ArrayList<Reserved_hours> available_hours=new ArrayList<Reserved_hours>();
    playground_owner plo=new playground_owner();
    ArrayList<booking>reservations=new ArrayList<booking>();
    public void get_free_hours(){
        for(int i=0;i<reservations.size();i++){
            for(int j=0;j<available_hours.size();j++){
                if(available_hours.get(j).hour==reservations.get(i).start_time){
                    for(int k=j;k<reservations.get(i).getNumber_of_hours();k++){
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
        System.out.println("The playground avail hours ");
        for(int i=0;i<available_hours.size();i++){
            System.out.println(available_hours.get(i).hour);
        }




    }
    public boolean check_avail(int start_time,int end_time){
        get_free_hours();
        int counter=0;
        for(int j=start_time;j<end_time;j++){
            for(int i=0;i<available_hours.size();i++){
                if(available_hours.get(i).hour==j&&available_hours.get(i).free_to_reserve==true){
                    counter ++;
                }
            }
        }
        if((counter-1)==(end_time-start_time)){
            return true;
        }
        return false;
    }


}
