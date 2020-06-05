import java.util.ArrayList;
import java.util.Scanner;

public class main_class {
    sign s;
    Login l;
    player logged_player;
    Admin admin;
    playground_owner logged_playground_owner;
    ArrayList<Admin>ad=new ArrayList<Admin>();
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
    public String login(){
        Scanner sc=new Scanner(System.in);
        String email=sc.next();
        String password =sc.next();
        Login login=new Login(email,password);
        if(login.check_players(players)){
            logged_player=login.get_logged_player();
            return "player";
        }
        else if(login.check_playground_owners(pl_ow)){
           logged_playground_owner=login.gpayground_owner();
            return "playground_owner";
        }
        else if(login.check_admin(ad)){
            admin=login.get_admin();
            return "Admin";

        }
        return null;
    }

    public void show_profle_main_page_player(){
        System.out.println(logged_player.id);
        System.out.println(logged_player.name);
        System.out.println(logged_player.telephone_number);
        System.out.println(logged_player.email);
        System.out.println(logged_player.ew.view_balance());
        if(logged_player.myteam.size()!=0) {
            System.out.println("My team members are : ");

            for (int i = 0; i < logged_player.myteam.size(); i++) {
                System.out.println(logged_player.myteam.get(i).name);
            }
        }
    }
    public void show_profle_main_page_playground_owner(){
        System.out.println(logged_playground_owner.id);
        System.out.println(logged_playground_owner.name);
        System.out.println(logged_playground_owner.telephone_number);
        System.out.println(logged_playground_owner.email);
        System.out.println(logged_playground_owner.ew.view_balance());
        if(logged_playground_owner.my_playgrounds.size()!=0) {
            System.out.println("My playgrounds are  : ");

            for (int i = 0; i < logged_playground_owner.my_playgrounds.size(); i++) {
                System.out.println(logged_playground_owner.my_playgrounds.get(i).id);
                System.out.println(logged_playground_owner.my_playgrounds.get(i).name);
                System.out.println(logged_playground_owner.my_playgrounds.get(i).location);
                System.out.println(logged_playground_owner.my_playgrounds.get(i).size);
                System.out.println(logged_playground_owner.my_playgrounds.get(i).price);

            }
        }
    }
    public void request_to_add_playground(){
        Scanner sc=new Scanner(System.in);
        playground p=new playground();
        System.out.println("Enter playground name : ");
        p.name=sc.next();
        System.out.println("Enter playground locaion");
        p.location=sc.next();
        System.out.println("Enter playground size");
        p.size=sc.nextInt();
        System.out.println("Enter playground price per hour");
        p.price=sc.nextInt();
        System.out.println("Enter  number of hours to be reserved ");
        int number_of_available_hours_to_reserve=sc.nextInt();
        for(int i=0;i<number_of_available_hours_to_reserve;i++){
            Reserved_hours r=new Reserved_hours();
            System.out.println("Enter the hour that u want to reserve");
            r.hour=sc.nextInt();
            p.available_hours.add(r);
        }
        p.plo=logged_playground_owner;
        re_p.req_pl_gd.add(p);
        System.out.println("The Request is successfully done waiting for admin approve");
        p.print_playground();
    }
    public void approve_playground(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the id of the playground u want to add");
        int id=sc.nextInt();
        playground p=admin.accept_playground(id,re_p);
        if(p!=null){
            pl.add(p);
            for(int i=0;i<pl_ow.size();i++){
                if(pl_ow.get(i).id==p.plo.id){
                    pl_ow.get(i).added_playground(p);
                    break;
                }
            }
            for(int i=0;i<re_p.req_pl_gd.size();i++){
                if(p.id==re_p.req_pl_gd.get(i).id){
                    re_p.req_pl_gd.remove(i);
                }
            }

        }
        System.out.println("Added to system successfully");
    }
    public void delete_playground(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the id of the playground u want to remove");
        int id=sc.nextInt();
        re_p=admin.delete_playground(id,re_p);
        System.out.println("deleyed successfully");
    }
    public void show_playground_requests(){
        for (int i=0;i<re_p.req_pl_gd.size();i++){
            re_p.req_pl_gd.get(i).print_playground();
        }
    }
    public static void main(String[] args) {


    }
}
