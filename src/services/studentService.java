package src.services;

import java.util.ArrayList;
import java.util.List;
import src.exceptions.*;
import src.model.student.*;

public class studentService {
     private  final List<Student> Students;

     public studentService(){
        Students = new ArrayList<>();
     }

     public void addStudents(Student std){
        Students.add(std);
     }

     public List<Student> getStudents(){
        return Students;
     }    
     
      public Student getStudentByID(String ID){            
         for(Student s:Students){
             if(s.getStudentID().equals(ID)){
               return s;
             }
         }
      throw new StudentNotFoundExecption("Student with id "+ID+"not found");
      }

      public void removeStudentByID(String ID){
          
         Student RemovedStudent = getStudentByID(ID);
          Students.remove(RemovedStudent.getStudentID().equals(RemovedStudent));
      }


}
