import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Admin is responsible for add other admins and view requested playgrounds
 * and choose which playgound to add and which to delete
 */
public class Admin {
    private static final AtomicInteger count = new AtomicInteger(0);
    int id = count.incrementAndGet();
    String email;
    String password;

    public void view(Requested_playground r){
        for(int i=0;i<r.req_pl_gd.size();i++){
            System.out.println("The Id of playground"+r.req_pl_gd.get(i).id);
            System.out.println("The playground owner name : "+r.req_pl_gd.get(i).plo.name);
            System.out.println("The playground name : "+r.req_pl_gd.get(i).name);
            System.out.println(" Location : "+r.req_pl_gd.get(i).location);
            System.out.println(" price : "+r.req_pl_gd.get(i).price);

            System.out.println("The Playground Size : "+r.req_pl_gd.get(i).size);
            for(int j=0;j<r.req_pl_gd.get(i).available_hours.size();j++) {
                System.out.println("The booking is available at : "+r.req_pl_gd.get(i).available_hours.get(j)+" pm");
            }
        }

    }
    public playground accept_playground(int id,Requested_playground r){
        for(int i=0;i<r.req_pl_gd.size();i++){
            if(r.req_pl_gd.get(i).id==id){
                return r.req_pl_gd.get(i);
            }
        }

            return null;
    }
    public Requested_playground  delete_playground(int id,Requested_playground r){
        for(int i=0;i<r.req_pl_gd.size();i++){
            if(r.req_pl_gd.get(i).id==id){
                    r.req_pl_gd.remove(i);
                    break;
            }
        }
        return r;
    }
}
