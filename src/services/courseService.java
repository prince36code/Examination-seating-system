package src.services;
import java.util.ArrayList;
import java.util.List;
import src.exceptions.*;
import src.model.course.*;

public class courseService {
   private final List<Course> Courses;

     public courseService(){
        Courses = new ArrayList<>();
     }

     public void addCourse(Course course){
        Courses.add(course);
     }

     public List<Course> getCourses(){
        return Courses;
     }

     public  Course getCourseByID(String ID){
           for(Course course:Courses){
               if(course.getCourseID().equals(ID)){
                  return course;
               } 
           }

           throw new CourseNotFoundExecption("Course with ID "+ID+" is not found");
     }

     public void removeCourseByID(String ID){
       Course course = getCourseByID(ID);
       Courses.remove(course.getCourseID().equals(ID));
     }
}
