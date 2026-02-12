package src.services;

import java.util.ArrayList;
import java.util.List;
import src.model.session.*;

public class sessionService {
    List<Session> Sessions;

    public sessionService(){
        Sessions = new ArrayList<>();
    }

    public void addSession(Session session){
        Sessions.add(session);
    }

    public List<Session> getSessions(){
        return Sessions;
    }

    public void  removeSessionByID(String ID){
        for(Session session:Sessions){
             
            if(session.getSessionID().equals(ID)){
                Sessions.remove(session);
            }
        }
    }
}
