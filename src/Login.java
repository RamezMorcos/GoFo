import java.util.ArrayList;

public class Login {
    String email;
    String password;
    Login(String e,String p){
        this.email=e;
        this.password=p;
    }
public boolean check_players(ArrayList<player> u){
    for (int i=0;i<u.size();i++){
       if(u.get(i).email.equals(email)&&u.get(i).password.equals(password)){
           return true;
       }
    }
    return false;
}
    public boolean check_playground_owners(ArrayList<playground_owner> u){
        for (int i=0;i<u.size();i++){
            if(u.get(i).email.equals(email)&&u.get(i).password.equals(password)){
                return true;
            }
        }
        return false;
    }
    public boolean check_admin(ArrayList<Admin> u){
        for (int i=0;i<u.size();i++){
            if(u.get(i).email.equals(email)&&u.get(i).password.equals(password)){
                return true;
            }
        }
        return false;
    }




}

