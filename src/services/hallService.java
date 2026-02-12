package src.services;

import java.util.ArrayList;
import java.util.List;
import src.exceptions.*;
import src.model.examhall.*;


public class hallService {

    private final  List<ExamHall> ExamHalls;
   public hallService(){
    ExamHalls = new ArrayList<>();
   }
    
   public void addExamHalls(ExamHall hall){
      ExamHalls.add(hall);
   }

   public List<ExamHall> getExamHalls(){
    return ExamHalls;
   }

  public ExamHall getExamHallByID(String ID){
       
    for(ExamHall examhall: ExamHalls){
      if(examhall.getHallID().equals(ID)){
        return examhall;
      }
    }
    throw new ExamHallNotFoundExecption("Exam Hall with ID "+ID+" is not  found");
     
  }

  public void removeExamHallbyID(String ID){

    ExamHall examhall = getExamHallByID(ID);
    ExamHalls.remove(examhall);
    
  }

}
