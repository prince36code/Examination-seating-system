package src.model.examhall;
public class ExamHall {
     private String hallName;
     private String hallID;
     private String hallBlock;
     private int hallCapacity;

     public  ExamHall(String hallName, String hallID, int hallCapacity , String hallBlock){
        this.hallName = hallName;
        this.hallID = hallID;
        this.hallCapacity = hallCapacity;
        this.hallBlock = hallBlock;
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
     public String getHallBlock(){
      return hallBlock;
     }
}
