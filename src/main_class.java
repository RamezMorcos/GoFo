import java.util.ArrayList;
import java.util.Scanner;

/**
 * main class which we use all operations on it
 */
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
    ArrayList<Requested_team>requested_teams=new ArrayList<Requested_team>();
    ArrayList<booking>bo=new ArrayList<booking>();
    Requested_playground re_p=new Requested_playground();

    public void regestration (){
       Scanner sc=new Scanner(System.in);

        System.out.println("Enter true if u want to regester as a normal player , Enter false if u want to regester as playground owner ");
        boolean b=sc.nextBoolean();
        if(b==true){
            player us=new player();
            s=new sign();
            user u=  s.regestration();
          us.id=u.id;
          us.ew=u.ew;
          us.name=u.name;
          us.email=u.email;
          us.password=u.password;
          us.telephone_number=u.telephone_number;
          players.add(us);


        }
        else {
            playground_owner us = new playground_owner();
            s = new sign();

            user u=  s.regestration();
            us.id=u.id;
            us.ew=u.ew;
            us.name=u.name;
            us.email=u.email;
            us.password=u.password;
            us.telephone_number=u.telephone_number;
            pl_ow.add(us);
        }

    }
    public String login(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your email");
        String email=sc.next();
        System.out.println("Enter your password");
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
      admin.view(re_p);
    }
    boolean check_ewallet(double price_booking){
        if(price_booking<logged_player.ew.view_balance()){
            for(int i=0;i<players.size();i++){
                if (logged_player.id==players.get(i).id){
                    players.get(i).ew.add_to_balance(-price_booking);
                    logged_player.ew.add_to_balance(-price_booking);
                }
            }
            return true;
        }
        return false;
    }
    public void add_to_playground_owner(int id,double price){
        for(int i=0;i<pl_ow.size();i++){
            if(pl_ow.get(i).id==id){
                pl_ow.get(i).ew.add_to_balance(price);
            }
        }
    }
    public void booking_playground(int plygrou_id){
        Scanner sc=new Scanner(System.in);
    for(int i=0;i<pl.size();i++){
        if(pl.get(i).id==plygrou_id){
            booking b=new booking();
            System.out.println("Enter start time");
            b.start_time=sc.nextInt();
            System.out.println("Enter end time");
            b.end_time=sc.nextInt();
            boolean check=pl.get(i).check_avail(b.start_time,b.end_time);
            if(check=false){
             System.out.println("not avail at that time ");
             return;
            }
            if(check_ewallet(b.calculate_price(pl.get(i).price))==false){
                System.out.println("You do not have enough money to reserve");
            }
            add_to_playground_owner(pl.get(i).plo.id,b.calculate_price(pl.get(i).price));
            b.p=logged_player;
            b.pg=pl.get(i);
            logged_player.book(b);
            pl.get(i).reservations.add(b);
            bo.add(b);
            for(int j=0;j<players.size();j++){
                if(players.get(i).id==logged_player.id){
                    players.get(i).book(b);
                }
            }
           System.out.println("booking process is successfully done ");
            b.print();
            break;
        }
    }
    }
      /*  public void show_playground(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please Enter the location u want to search in ");
       String location=sc.next();
       logged_player.search_playground_by_location(location,pl);
        }*/
        public Requested_team get_player(int id) {
            for(int i=0;i<requested_teams.size();i++){
                if(id==requested_teams.get(i).sender.id){
                   Requested_team r= requested_teams.get(i);
                   requested_teams.remove(i);
                    return r;
                }
            }
            return null;
        }
        public void show_friends_request(){
         logged_player.show_requested_friends(requested_teams);
        }
        public void accept_friend(){
              logged_player.show_requested_friends(requested_teams);
            System.out.println("please write the id of your friend that u want to add");
            Scanner sc=new Scanner(System.in);
            int id =sc.nextInt();
            Requested_team r=get_player(id);
            logged_player.accept_team_member(r.sender);
            for(int i=0;i<players.size();i++){
                if(players.get(i).id==r.sender.id){
                    players.get(i).accept_team_member(r.reciever);
                }
                if(players.get(i).id==r.reciever.id){
                    players.get(i).accept_team_member(r.sender);
                }
            }
            System.out.println("process is done successfully");
        }
        public void update_playground(int id,String up_name,int up_start_time,int end_time,int up_price){
            for(int i=0;i<pl.size();i++){
                if(id==pl.get(i).id){
                    pl.get(i).name=up_name;
                    pl.get(i).price=up_price;
                    pl.get(i).available_hours.clear();
                    for(int j=up_start_time;j<=end_time;j++){
                        Reserved_hours rh=new Reserved_hours();
                        rh.hour=j;
                        pl.get(i).available_hours.add(rh);
                    }
                }
            }
        }
        public void Findfriends(){
        Scanner sc=new Scanner(System.in);
        System.out.println("please Enter the name of your friend u want to add to ypur team ");
        String friend=sc.next();
        logged_player.find_friends(players,friend);
        }
        public void add__admin(){
            Scanner sc=new Scanner(System.in);
            Admin admin=new Admin();
            System.out.println("Please enter email");
            admin.email=sc.next();
            System.out.println("Please enter password");
            admin.password=sc.next();
            ad.add(admin);
        }

        public void send_friend_request(){
            Scanner sc=new Scanner(System.in);
            System.out.println("please enter the id of the friend u want to add");
            int id=sc.nextInt();
            player p=logged_player.send_friend_request(players,id);
            Requested_team requested_team=new Requested_team();
            requested_team.sender=logged_player;
            requested_team.reciever=p;
            requested_teams.add(requested_team);
            System.out.println("process is successfully done");
        }
        public void signout(){
            logged_player=null;
            logged_playground_owner=null;
            admin=null;
        }

        public String Main_page(){
            while(true){
                Scanner sc=new Scanner(System.in);
                System.out.println("To sign up enter 1 to log in enter 2");
                int choice=sc.nextInt();
                if(choice==1){
                    regestration();
                }
                if(choice==2){
                String st=login();
                if(st!=null&&(st.equals("player")||st.equals("playground_owner")||st.equals("Admin"))){
                    return st;
                }
                }
            }
        }
        public String player_options(){
            Scanner sc=new Scanner(System.in);
            while(true){
                System.out.println("press 1 to book a playground");
                System.out.println("press 2 to show playgrounds by location");
                System.out.println("press 3 to show my booking");
                System.out.println("press 4 to view ewallet");
                System.out.println("press 5 to show_friends_request");
                System.out.println("press 6 to add_friend");
                System.out.println("press 7 to accept_friend ");
                System.out.println("press 8 to signout ");
                System.out.println("press 9 to exit ");



                int choice=sc.nextInt();
                if(choice==1){
                    System.out.println("Enter the location u want to reserve in");
                    String location =sc.next();
                    logged_player.search_playground_by_location(location,pl);
                    System.out.println("Enter the id of the playground u choose");
                    int id=sc.nextInt();
                            booking_playground(id);
                }
                else if(choice==2){
                    System.out.println("Enter the location u want to reserve in");
                    String location =sc.next();
                    logged_player.search_playground_by_location(location,pl);
                }
                else if(choice==3){
                    logged_player.get_mybooking();
                }
                else if(choice==4){
                    System.out.println("enter your account number ");
                    String str=sc.next();
                    if(str.equals(logged_playground_owner.ew.visa_account_number)){
                        System.out.print(logged_playground_owner.ew.view_balance());
                    }                }
                else if(choice==5){
                        show_friends_request();
                }
                else if(choice==6){
                    Findfriends();
                    send_friend_request();
                }
                else if(choice==7){
                    show_friends_request();
                    accept_friend();
                }
                else if(choice==8){
                    signout();
                    return "continue";
                }
                else if(choice==9){
                    return null;
                }
            }
        }
    public String playground_owner_options(){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("press 1 to add playground");
            System.out.println("press 2 to my show playgrounds");
            System.out.println("press 3 to view ewallet");
            System.out.println("press 4 to supdate playground");
            System.out.println("press 5 to signout ");
            System.out.println("press 6 to exit ");

            int choice=sc.nextInt();
            if(choice==1){
                    request_to_add_playground();
                }
            else if(choice==2){
                    logged_playground_owner.get_all_my_playgrounds();
            }

            else if(choice==3){
            System.out.println("enter your account number ");
            String str=sc.next();
            if(str.equals(logged_playground_owner.ew.visa_account_number)){
              System.out.print(logged_playground_owner.ew.view_balance());
            }
            }
            else if(choice==4){
                    System.out.println("Enter id of the playground u want to update");
                    int id=sc.nextInt();
                System.out.println("Enter name of the playground u want to update");
                String name=sc.next();
                    System.out.println("Enter the start time ");
                    int start=sc.nextInt();
                System.out.println("Enter the end time ");
                int end=sc.nextInt();
                System.out.println("Enter the price ");
                int price=sc.nextInt();
                update_playground(id,name,start,end,price);
                logged_playground_owner.update_playground(id,name,start,end,price);
            }
            else if(choice==5){
                signout();
                return "continue";
            }
            else if(choice==6){
                return null;
            }
        }
    }
    public String admin_options(){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("press 1 to approve playground");
            System.out.println("press 2 to my delete playground");
            System.out.println("press 3 to view playgrounds");
            System.out.println("press 4 to add admin");
            System.out.println("press 5 to signout ");
            System.out.println("press 6 to exit ");

            int choice=sc.nextInt();
            if(choice==1){
                show_playground_requests();
                approve_playground();
            }
            else if(choice==2){
                show_playground_requests();
                    delete_playground();
            }

            else if(choice==3){
                show_playground_requests();
            }
            else if(choice==4){
                add__admin();
            }
            else if(choice==5){
                signout();
                return "continue";
            }
            else if(choice==6){
                return null;
            }
    }
    }


    public static void main(String[] args) {
            main_class m=new main_class();
            while (true) {
                Admin admin=new Admin();
                admin.email="admin@gofo.com";
                admin.password="admingofo123456789";
                m.ad.add(admin);
                String type_user = m.Main_page();
                if (type_user.equals("player")) {
                    m.show_profle_main_page_player();
                    String str=m.player_options();
                    if(str==null){break;}
                } else if (type_user.equals("playground_owner")) {
                    m.show_profle_main_page_playground_owner();
                  String str=  m.playground_owner_options();
                    if(str==null){break;}
                } else {
                    String str=   m.admin_options();
                    if(str==null){break;}
                }
            }
    }
}
