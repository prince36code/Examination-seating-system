package src.services;

import java.util.ArrayList;
import java.util.List;
import src.model.hall.*;

public class hallService {

    private final  List<Hall> halls;

   public hallService(){
    halls = new ArrayList<>();
   }

    
   public void addExamHalls(Hall hall){
       halls.add(hall);
   }

   public List<Hall> getExamHalls(){
    return halls;
   }

   public void printAllExamHalls(){
      for(Hall h:halls){
        System.out.println(h.getHallName()+"-"+h.getHallID()+"-"+h.gethallCapacity());
      }
   }

}
