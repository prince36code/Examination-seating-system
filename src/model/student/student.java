package src.model.student;

public class Student {
    private String studentName;
    private String studentRollNumber;
    private String studentBranch;
    private String studentSection;
    private  int attandance;
  

    public Student(String Name,String ID ,String Branch, int attandance, String studentSection){
        this.studentName = Name;
        this.studentRollNumber = ID;
        this.studentBranch = Branch;
        this.attandance = attandance;
        this.studentSection = studentSection;       
    }

    public String getStudentName(){
        return studentName;
    }

    public String getStudentID(){
        return studentRollNumber;
    }

    public String getStudentBranch(){
        return studentBranch;
    }

    public int getStudentAttandance(){
        return attandance;
    }
}
