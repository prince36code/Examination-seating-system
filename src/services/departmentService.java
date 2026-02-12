package src.services;

import java.util.ArrayList;
import java.util.List;
import src.exceptions.*;
import src.model.department.*;

public class departmentService {
    
    List<Department> Departments;

     public departmentService(){
        Departments = new ArrayList<>();
     }
   
     public void addDepartment(Department department){
        Departments.add(department);
     }

     public Department getDepartmentByID(String ID){
         
        for(Department department:Departments){
            if(department.getDepartmentID().equals(ID)){
                return department;
            }
        }
         throw new DepartmentNotFoundException("The department with give Id "+ID+" not found");
     }

     public void removeDepartmentByID(String ID){

        Department department = getDepartmentByID(ID);
        Departments.remove(department);
     }
}
