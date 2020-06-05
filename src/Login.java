import java.util.ArrayList;

public class Login {
    String email;
    String password;
   private player us;
   private playground_owner pl;
   private Admin ad;
    Login(String e,String p){
        this.email=e;
        this.password=p;
    }
public boolean check_players(ArrayList<player> u){
    for (int i=0;i<u.size();i++){
       if(u.get(i).email.equals(email)&&u.get(i).password.equals(password)){
           us=u.get(i);
           return true;
       }
    }
    return false;
}
    public boolean check_playground_owners(ArrayList<playground_owner> u){
        for (int i=0;i<u.size();i++){
            if(u.get(i).email.equals(email)&&u.get(i).password.equals(password)){
                pl=u.get(i);
                return true;
            }
        }
        return false;
    }
    public boolean check_admin(ArrayList<Admin> u){
        for (int i=0;i<u.size();i++){
            if(u.get(i).email.equals(email)&&u.get(i).password.equals(password)){
                ad=u.get(i);
                return true;
            }
        }
        return false;
    }




public player get_logged_player(){
        return us;
}
    public playground_owner gpayground_owner(){
        return pl;
    }
    public Admin get_admin(){
        return ad;
    }
}

