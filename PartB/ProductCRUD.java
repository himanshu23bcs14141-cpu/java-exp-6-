import java.sql.*;
import java.util.*;

public class ProductCRUD {
    static Connection con;

    public static void connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","password");
    }

    public static void insertProduct(String name,double price,int qty) throws Exception {
        PreparedStatement ps = con.prepareStatement("INSERT INTO product(name,price,quantity) VALUES(?,?,?)");
        ps.setString(1,name);
        ps.setDouble(2,price);
        ps.setInt(3,qty);
        ps.executeUpdate();
    }

    public static void updateProduct(int id,double price) throws Exception {
        PreparedStatement ps = con.prepareStatement("UPDATE product SET price=? WHERE id=?");
        ps.setDouble(1,price);
        ps.setInt(2,id);
        ps.executeUpdate();
    }

    public static void deleteProduct(int id) throws Exception {
        PreparedStatement ps = con.prepareStatement("DELETE FROM product WHERE id=?");
        ps.setInt(1,id);
        ps.executeUpdate();
    }

    public static void viewProducts() throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM product");
        while(rs.next()){
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getInt(4));
        }
    }

    public static void main(String[] a) throws Exception {
        connect();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1.Insert 2.Update 3.Delete 4.View 5.Exit");
            int c = sc.nextInt();
            if(c==1){
                System.out.print("Name: "); String n=sc.next();
                System.out.print("Price: "); double p=sc.nextDouble();
                System.out.print("Qty: "); int q=sc.nextInt();
                insertProduct(n,p,q);
            } else if(c==2){
                System.out.print("Id: "); int id=sc.nextInt();
                System.out.print("New Price: "); double p=sc.nextDouble();
                updateProduct(id,p);
            } else if(c==3){
                System.out.print("Id: "); int id=sc.nextInt();
                deleteProduct(id);
            } else if(c==4){
                viewProducts();
            } else break;
        }
    }
}
