import java.util.concurrent.atomic.AtomicInteger;

/**
 * the class that will be inherited which contain themain common attributes
 */
public  class user {
    private static final AtomicInteger count = new AtomicInteger(0);
    int id = count.incrementAndGet();
    String name;
    String email;
    String password;
    String telephone_number;
    eWallet ew=new eWallet();



}