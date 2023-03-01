package controller;

import Hashing.HashPassword;
import Model.Student;
import Service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "NewServlet", urlPatterns = {"/user"})
public class NewServlet extends HttpServlet {
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String page = request.getParameter("page");
        PrintWriter out = response.getWriter();
        if(page.equalsIgnoreCase("newUsers")){
            Student st = new Student();
           
            st.setFullname(request.getParameter("fullname"));
            st.setUsername(request.getParameter("username"));
            st.setPassword( HashPassword.hashThisPass(request.getParameter("password")));
            new UserService().insertUser(st);
            out.print("Data inserted");
        } else if(page.equalsIgnoreCase("register")){
            RequestDispatcher rd = request.getRequestDispatcher("pages/register.jsp");
            rd.forward(request,response);
        }else if(page.equalsIgnoreCase("newLogin")){
            RequestDispatcher rd1 = request.getRequestDispatcher("index.jsp");
            rd1.forward(request,response);
        }
        
        if(page.equalsIgnoreCase("insert")){
            String name = request.getParameter("username");
//            String password = request.getParameter("password");    
            String password = HashPassword.hashThisPass(request.getParameter("password"));
            Student st = new UserService().getUser(name, password);
            if(st != null){
                HttpSession sess = request.getSession();
                sess.setAttribute("username",name);
                
                RequestDispatcher rd2 = request.getRequestDispatcher("pages/dashboard.jsp");
                rd2.forward(request,response);
            }
            else{
                out.println("incorrecnt");
                RequestDispatcher rd3 = request.getRequestDispatcher("index.jsp");
                rd3.forward(request,response);
            }
        }
        if(page.equalsIgnoreCase("userlist")){
            
            Student st = new Student();
            List<Student> stList = new UserService().getUserList();
            out.println(stList.size());
            request.setAttribute("user", st);
            request.setAttribute("userlist", stList);
            RequestDispatcher rd = request.getRequestDispatcher("pages/userlist.jsp");
            rd.forward(request,response);
        }
        if(page.equalsIgnoreCase("userdetails")){
            int id = Integer.parseInt(request.getParameter("id"));
            Student st = new UserService().getUserRow(id);
            request.setAttribute("id", id);
            request.setAttribute("st", st);
            
            RequestDispatcher rd = request.getRequestDispatcher("pages/userdetails.jsp");
            rd.forward(request,response);
        }
        if(page.equalsIgnoreCase("deleteuser")){
//            int id = Integer.parseInt(request.getParameter("id"));
//            new UserService().deleteUser(id);
//            out.print("Cat");
            Student st = new Student();
            List<Student> stList = new UserService().getUserList();
            out.println(stList.size());
            request.setAttribute("user", st);
            request.setAttribute("userlist", stList);
            RequestDispatcher rd = request.getRequestDispatcher("pages/userlist.jsp");
            rd.forward(request,response);
            
        }
        if(page.equalsIgnoreCase("edituser")){

            int id = Integer.parseInt(request.getParameter("id"));
            Student st = new UserService().getUserRow(id);
            
            
            request.setAttribute("student", st);
            request.setAttribute("id", id);
            
            
            RequestDispatcher rd = request.getRequestDispatcher("pages/edituser.jsp");
            rd.forward(request,response);
        }
        if(page.equalsIgnoreCase("updateuser")){
            int id = Integer.parseInt(request.getParameter("id"));
            Student st = new Student();
           
            st.setFullname(request.getParameter("fullname"));
            st.setUsername(request.getParameter("username"));
            st.setPassword(request.getParameter("password"));
            try{
                new UserService().editUser(id,st);
            }
            catch(SQLException e){
//                e.printStackTrace();
                System.out.println("ERRORR"+e);
            }
            List<Student> stList = new UserService().getUserList();
            request.setAttribute("user", st);
            request.setAttribute("userlist", stList);
            RequestDispatcher rd = request.getRequestDispatcher("pages/userlist.jsp");
            rd.forward(request,response);
        }
        if(page.equalsIgnoreCase("logout")){
            HttpSession sess = request.getSession(false);
            sess.invalidate();
            
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        doPost(request,response);
    }
    
}
