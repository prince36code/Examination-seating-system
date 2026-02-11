package src.model.student;

public class student {
    private String studentName;
    private String studentID;
    private String studentBranch;
  

    public student(String Name,String ID ,String Branch ){
        this.studentName = Name;
        this.studentID = ID;
        this.studentBranch = Branch;
       
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
}
