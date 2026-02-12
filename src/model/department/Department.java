package src.model.department;

public class Department {
    private String  departmentName;
    private String  departmentID;
    private String  branch;
    private String section;

    public Department(String departmentName, String departmentID, String branch, String section){
        this.departmentName = departmentName;
        this.departmentID = departmentID;
        this.branch = branch;
        this.section = section;
    }

    public String getDepartmentName(){
        return departmentName;
    }

    public String getDepartmentID(){
        return departmentID;
    }
}
