package src.services;

import java.util.ArrayList;
import java.util.List;
import src.model.student.*;
import src.exeception.*;

public class studentService {
     private  final List<student> Students;

     public studentService(){
        Students = new ArrayList<>();
     }

     public void addStudents(student std){
        Students.add(std);
     }

     public List<student> getStudents(){
        return Students;
     }    
     
      public student getStudentID(String ID){            
         for(student s:Students){
             if(s.getStudentID().equals(ID)){
               return s;
             }
         }
      throw new StudentNotFoundExecption("Student with id "+ID+"not found");
      }


}
