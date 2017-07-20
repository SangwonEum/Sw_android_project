package Controller;


import java.io.IOException;


import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Bean.Person;
import Database.DbUtil;

@WebServlet("/insertC")
public class InsertChild extends HttpServlet{
	
	

	DbUtil db = new DbUtil();
	
	
	public InsertChild(){
		
		super();
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doGet(req, res);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		try{
		
		System.out.println("insertChild");
		String name = req.getParameter("name");
		String parentId = req.getParameter("parentId");
		System.out.println(name + " "+ parentId);
		Person ps  = null;
		Connection con = null;
		
		if(name != null && parentId != null){
			ps = new Person();
			ps.setId(name);
			ps.setParent_id(Integer.parseInt(parentId));
			
			
		}
		
		String sql = "insert into student values(?,?);";
		con = db.Connect();
		Statement stmt =  con.createStatement();
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, Integer.parseInt(parentId));
		st.setString(2, name);
		int rest= st.executeUpdate();
		System.out.println("결과 값: "+ rest);
		
		
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
