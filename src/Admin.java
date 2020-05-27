import java.util.concurrent.atomic.AtomicInteger;

public class Admin {
    private static final AtomicInteger count = new AtomicInteger(0);
    int id = count.incrementAndGet();
    String email;
    String password;
}
