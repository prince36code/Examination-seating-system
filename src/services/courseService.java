package src.services;
import java.util.ArrayList;
import java.util.List;
import src.model.course.*;

public class courseService {
   private final List<Course> courses;

     public courseService(){
        courses = new ArrayList<>();
     }

     public void addCourse(Course course){
        courses.add(course);
     }

     public List<Course> getCourses(){
        return courses;
     }

     public void printAllCourses(){

        for(Course c : courses )
        System.out.println(c.getCourseName()+"-"+c.getCourseID());
     }
     
}
