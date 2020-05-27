public class eWallet {
   private double balance;
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
