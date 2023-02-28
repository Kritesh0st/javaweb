package Service;
import DBConnection.DBConnection;
import Model.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {
    public void insertUser(Student stu){
        String query = "insert into userinfo(username,fullname,password)" + "values(?,?,?)";
        PreparedStatement ps = new DBConnection().getStatement(query);
        try{
            ps.setString(1,stu.getUsername());
            ps.setString(2,stu.getFullname());
            ps.setString(3,stu.getPassword());
            ps.execute();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public Student getUser(String username, String password){
        Student st = null;
        String query = "select * from userinfo where username=? and password=?";
        PreparedStatement ps = new DBConnection().getStatement(query);
        try{
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                st = new Student();
                st.setId(rs.getInt("id"));
                st.setUsername(rs.getString("username"));
                st.setFullname(rs.getString("fullname"));
                st.setPassword(rs.getString("password"));
            }
        }
         catch(SQLException e){
            e.printStackTrace();
        }
        return st;
    }
    
    public List<Student> getUserList(){
        List<Student> userlist = new ArrayList<>();
        
        String query = "select * from userinfo";
        PreparedStatement ps = new DBConnection().getStatement(query);
        
        try{
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student st = new Student();
                st.setId(rs.getInt("id"));
                st.setFullname(rs.getString("fullname"));
                st.setUsername(rs.getString("username"));
                st.setPassword(rs.getString("password"));
                
                userlist.add(st);
            }
        }
         catch(SQLException e){
            e.printStackTrace();
        }
        
        return userlist;
    }
    
    public Student getUserRow(int id){
        Student st = null;
        String query = "select * from userinfo where id=?";
        PreparedStatement ps = new DBConnection().getStatement(query);
        
        try {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                st = new Student();
                st.setId(rs.getInt("id"));
                st.setUsername(rs.getString("username"));
                st.setFullname(rs.getString("fullname"));
                st.setPassword(rs.getString("password"));
            }
            
        } 
        catch(SQLException e){
            e.printStackTrace();
        }
        return st;
    }
    public void deleteUser(int id){
        String query = "delete from userinfo where id = ?";
        PreparedStatement ps = new DBConnection().getStatement(query);
        try{
            ps.setInt(1,id);
            ps.execute();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void editUser(int id,Student stu) throws SQLException{
        String query = "update userinfo set username=?, fullname=?, password=? "+"where id=?";
        PreparedStatement ps = new DBConnection().getStatement(query);
        ps.setString(1,stu.getUsername());
        ps.setString(2,stu.getFullname());
        ps.setString(3,stu.getPassword());
        ps.setInt(4,id);
        ps.execute();
    }
    public static void main(String[] args) {
        UserService us = new UserService();
        System.out.println("USER SERVICE");
    }
}
