package dao;
import java.sql.*;
import model.Student;

public class StudentDAO {
    Connection con;

    public StudentDAO() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","password");
    }

    public void addStudent(Student s) throws Exception {
        PreparedStatement ps = con.prepareStatement("INSERT INTO student VALUES (?,?,?)");
        ps.setInt(1,s.id);
        ps.setString(2,s.name);
        ps.setString(3,s.course);
        ps.executeUpdate();
    }

    public void viewStudents() throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student");
        while(rs.next()){
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
        }
    }
}
