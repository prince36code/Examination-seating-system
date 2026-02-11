package src.model.hall;

public class Hall {
     private String hallName;
     private String hallID;
     private int hallCapacity;

     public  Hall(String hallName, String hallID, int hallCapacity ){
        this.hallName = hallName;
        this.hallID = hallID;
        this.hallCapacity = hallCapacity;
     }

     public String getHallName(){
      return hallName;
     }

     public String getHallID(){
      return hallID;
     }

     public int gethallCapacity(){
      return hallCapacity;
     }
}
