package src.services;

import java.util.ArrayList;
import java.util.List;
import src.model.student.*;

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

     public void printAllStudents(){
        for(student s:Students){
     System.out.println(s.getStudentName()+ "-"+s.getStudentID()+"-"+s.getStudentBranch());
        }
     }


}
