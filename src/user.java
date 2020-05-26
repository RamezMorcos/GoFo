import java.util.concurrent.atomic.AtomicInteger;

public abstract class user {
    private static final AtomicInteger count = new AtomicInteger(0);
    int id=count.incrementAndGet();
    String name;
    String email;
    String password;
    String telephone_number;
    eWallet ew;

}
