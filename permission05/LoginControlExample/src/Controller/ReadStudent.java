package Controller;


import java.io.IOException;
import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Student;
import Database.DbUtil;

@WebServlet("/read")
public class ReadStudent extends HttpServlet {
	DbUtil db = new DbUtil();
	List<Student> students  =null;
	
	RequestDispatcher dispatcher = null;
	Connection con  = null;
	ResultSet rs = null;
	
	public ReadStudent(){
		
		super();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doGet(req, res);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		try{
			List<Student> students  = new ArrayList<Student>();
			System.out.println(students.size());
			System.out.println("reading...");
			con = db.Connect();
			String sql = "select * from student;";
			rs = con.createStatement().executeQuery(sql);
			while(rs.next()){
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				students.add(s);
			}
			
			req.setAttribute("stu",students);
			dispatcher = req.getRequestDispatcher("result.jsp");
			dispatcher.forward(req, res);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				db.Disconnect();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

}
