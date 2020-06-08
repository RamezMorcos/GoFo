import java.util.Scanner;

/**
 * that class is responsible for the reqestration
 * and there is check mail to check if the mail is formal or not
 */
public class sign {
    user u;
    sign(){
            u=new user();
    }

    public boolean check_email(String email){
if(email.contains("@")&&email.contains(".com")){
    return true;
}
        return false ;
    }
    public user regestration(){

        Scanner s=new Scanner(System.in);
        System.out.println(" Enter your name ");
        u.name=s.next();
        while(true) {
            System.out.println(" Enter your email ");
            u.email = s.next();
        boolean check_email=check_email(u.email);
            if(check_email==true){
                break;
            }
            System.out.println(" Email is not correct try again ");
        }
        while (true) {
            System.out.println(" Enter your password ");
            u.password = s.next();
            System.out.println(" confirm password ");
            String confirm  = s.next();
            if(u.password.equals(confirm)) {
                break;
            }
            System.out.println("Does not match please try again ");

        }
        System.out.println(" Enter your telephone number ");
        u.telephone_number=s.next();
        System.out.println(" Enter your ewallet visa account number ");
        u.ew.visa_account_number=s.next();
        System.out.println(" Enter your the number of money you want to add to your wallet ");
        double b=s.nextDouble();
        u.ew.add_to_balance(b);
        System.out.println("Regestered  successfully to system");
    return u;
    }
}
