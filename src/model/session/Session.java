package src.model.session;

public class Session {
    private String sessionID;
    private String sessionName;

    public Session(String sessionID, String sessionName ){
       this.sessionID = sessionID;
       this.sessionName = sessionName;
    }

    public String getSessionID(){
        return sessionID;
    }

    public String getSessionName(){
        return sessionName;
    }
}
