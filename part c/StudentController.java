package controller;
import dao.StudentDAO;
import model.Student;

public class StudentController {
    StudentDAO dao;

    public StudentController() throws Exception {
        dao = new StudentDAO();
    }

    public void add(int id,String name,String course) throws Exception {
        dao.addStudent(new Student(id,name,course));
    }

    public void view() throws Exception {
        dao.viewStudents();
    }
}
