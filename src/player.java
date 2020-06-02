import java.util.ArrayList;

public class player extends user {
    ArrayList<booking>booked_playground_to_play;
    ArrayList<player>myteam;

    public void search_playground_by_location(String location,ArrayList<playground>pl_g){
        boolean check_if_there_playground_or_not=false;
        for(int i=0;i<pl_g.size();i++){
            if(pl_g.get(i).location.equals(location)){
                pl_g.get(i).print_playground();
                check_if_there_playground_or_not=true;
            }
        }
        if(check_if_there_playground_or_not==false){
            System.out.println("There is no playgrounds in that place");
        }

    }
    public void book(booking b){
        booked_playground_to_play.add(b);
    }
    public void cancel_booking(int index){
        booked_playground_to_play.remove(index);
    }
    public void get_available_hours(playground p){
        p.get_free_hours();
        for(int i=0;i<p.available_hours.size();i++){
            if(p.available_hours.get(i).free_to_reserve==true){
                System.out.println("The playground is available at : "+p.available_hours.get(i).hour);
            }
        }
    }
    public void accept_team_member(player p){
        myteam.add(p);
    }
    public void show_requested_friends(ArrayList<Requested_team>req){
        for (int i=0;i<req.size();i++){
            if(req.get(i).reciever.id==id){
                System.out.println(req.get(i).sender.id );
                System.out.println(req.get(i).sender.name );

            }
        }

    }
    public void find_friends(ArrayList<player>pl,String n) {
                for(int i=0;i<pl.size();i++){
                    if(pl.get(i).name.contains(n)){
                        System.out.println(pl.get(i).id);
                        System.out.println(pl.get(i).name );
                    }
                }
    }
    public player send_friend_request(ArrayList<player>pl,int id) {
        for(int i=0;i<pl.size();i++){
            if(pl.get(i).id==id){
                return pl.get(i);
            }
        }
        return null;
    }


}
