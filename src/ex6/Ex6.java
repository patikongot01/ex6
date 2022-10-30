package ex6;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.lang.model.SourceVersion;
import utilities.DatabaseDriver;
import utilities.DatabaseHandler;

public class Ex6 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost:1527/student";
        String user = "app";
        String passwd = "app";
        
        DatabaseDriver dbDriver = new DatabaseDriver(driver, url, user, passwd);
        DatabaseHandler dbHandler = new DatabaseHandler(dbDriver);
        Student std1 = new Student(155, "Patikorn", 3.34);
        Student std2 = new Student(165, "WASAWA",3.34);
        StudentTable.insertStudent(dbHandler, std1);
        StudentTable.insertStudent(dbHandler, std2);
        
        ArrayList<Student> studentList = StudentTable.findAllStudent(dbHandler);
        if (studentList != null) {
            printAllStudent(studentList);
        }
        dbHandler.closeConnection();
    }
    
    public static void printAllStudent(ArrayList<Student> studentList) {
        for(int i = 0; i < studentList.size(); i++) {
            System.out.print(studentList.get(i).getId() + " ");
            System.out.print(studentList.get(i).getName() + " ");
            System.out.println(studentList.get(i).getGPA() + " ");
        }
    }
    
}
