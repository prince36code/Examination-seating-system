package src.model.student;

public class student {
    private String studentName;
    private String studentID;
    private String studentBranch;
    private  int attandance;
  

    public student(String Name,String ID ,String Branch, int attandance ){
        this.studentName = Name;
        this.studentID = ID;
        this.studentBranch = Branch;
        this.attandance = attandance;
       
    }

    public String getStudentName(){
        return studentName;
    }

    public String getStudentID(){
        return studentID;
    }

    public String getStudentBranch(){
        return studentBranch;
    }

    public int getStudentAttandance(){
        return attandance;
    }
}
