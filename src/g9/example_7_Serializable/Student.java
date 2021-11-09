package g9.example_7_Serializable;

import java.io.Serializable;

public class Student implements Serializable {
    protected static String faculty;
    private String name;
    private int id;
    private transient String password;
    private static final long serialVersionUID = 1L;
    /*значение этого поля для класса будет дано далее*/

    public Student(String nameOfFaculty, String name,
                   int id, String password){
        faculty = nameOfFaculty;
        this.name = name;
        this.id = id;
        this.password = password;
    }
    public String toString(){
        return "\nfaculty " + faculty + "\nname " + name
                + "\nID " + id + "\npassword " + password;
    }
}
