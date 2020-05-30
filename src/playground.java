import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class playground {
    private static final AtomicInteger count = new AtomicInteger(0);
    int id = count.incrementAndGet();
    String name;
    String location;
    int size;
    int price;
    ArrayList<Integer> available_hours;
    playground_owner plo;
    ArrayList<booking>reservations;
    public void get_free_hours(){

    }

}
