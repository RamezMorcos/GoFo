import java.util.ArrayList;

/**
 * playground owner which have one or many playgrounds
 * he can view his playgrounds and his ewallet
 * he can add playground and wait untill the approve of admin to be added to system
 * he also can update his play ground
 */
public class playground_owner extends user {
    ArrayList<playground>my_playgrounds=new ArrayList<playground>();

    public void added_playground(playground new_playground){
        my_playgrounds.add(new_playground);
    }
    public void print_ewallet(){
        System.out.println(ew.view_balance());
    }
    public void get_all_my_playgrounds(){
        for(int i=0;i<my_playgrounds.size();i++){
            System.out.println(my_playgrounds.get(i).id +"  "+my_playgrounds.get(i).name);
        }
    }
    public void get_a_specific_playground(int id){
        for(int i=0;i<my_playgrounds.size();i++){
            if(my_playgrounds.get(i).id==id) {
                System.out.println(my_playgrounds.get(i).id );
                System.out.println(my_playgrounds.get(i).name);
                System.out.println(my_playgrounds.get(i).location);
                System.out.println(my_playgrounds.get(i).size);
                for(int j=0;j<my_playgrounds.get(i).available_hours.size();i++) {
                    System.out.println(" The playground is  available at "+my_playgrounds.get(i).available_hours.get(j));
                }
            break;
            }
            }
    }

public void update_playground(int id ,String up_name,int up_start_time,int end_time,int up_price){
    for(int i=0;i<my_playgrounds.size();i++){
        if(my_playgrounds.get(i).id==id) {
            my_playgrounds.get(i).available_hours.clear();
            my_playgrounds.get(i).name=up_name;
            my_playgrounds.get(i).price=up_price;
            for(int j=up_start_time;j<=end_time;j++){
                Reserved_hours rh=new Reserved_hours();
                rh.hour=j;
                my_playgrounds.get(i).available_hours.add(rh);
            }
            break;
        }
    }
}

}
