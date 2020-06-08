/**
 * ewallet class is responsible for payment
 * each user has account we assume it is his bank acount which have money which is balance and account number
 */

public class eWallet {
   private double balance;
   public String visa_account_number;
   eWallet(){
       balance=0;
   }
    eWallet(double b){
        this.balance=b;
    }
    public void add_to_balance(double added){
        balance+=added;
    }
    public double view_balance(){
        return balance;
    }

}
