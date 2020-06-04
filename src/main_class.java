import java.util.ArrayList;
import java.util.Scanner;

public class main_class {
    sign s;
    Login l;
    ArrayList<player>players=new ArrayList<player>();
    ArrayList<playground>pl=new ArrayList<playground>();
    ArrayList<playground_owner>pl_ow=new ArrayList<playground_owner>();
    ArrayList<booking>bo=new ArrayList<booking>();
    Requested_playground re_p=new Requested_playground();

    public void regestration (){
       Scanner sc=new Scanner(System.in);
        boolean b=sc.nextBoolean();
        System.out.println("Enter true if u want to regester as a normal player , Enter false if u want to regester as playground owner ");
        if(b==true){
            player us=new player();
            s=new sign(us);
            s.regestration();
            players.add(us);


        }
        playground_owner us=new playground_owner();
        s=new sign(us);
        s.regestration();
        pl_ow.add(us);


    }


    public static void main(String[] args) {


    }
}
