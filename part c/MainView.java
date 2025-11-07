package view;
import controller.StudentController;
import java.util.*;

public class MainView {
    public static void main(String[] args) throws Exception {
        StudentController c = new StudentController();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1.Add 2.View 3.Exit");
            int ch = sc.nextInt();
            if(ch==1){
                System.out.print("ID: "); int id=sc.nextInt();
                System.out.print("Name: "); String n=sc.next();
                System.out.print("Course: "); String cr=sc.next();
                c.add(id,n,cr);
            } else if(ch==2){
                c.view();
            } else break;
        }
    }
}
