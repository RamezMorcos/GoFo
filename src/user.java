import java.util.concurrent.atomic.AtomicInteger;

public abstract class user {
    private static final AtomicInteger count = new AtomicInteger(0);
    int id = count.incrementAndGet();
    String name;
    String email;
    String password;
    String telephone_number;
    eWallet ew;


    public void update_profile(String n, String eml, String pass, String tn) {
        this.name = n;
        this.email = eml;
        this.password = pass;
        this.telephone_number = tn;
    }
}