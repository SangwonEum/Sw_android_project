package Controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Bean.MemberInfo;
import Database.naver;

@WebServlet("/login")
public class login2 extends HttpServlet{

	MemberInfo minfo;
	public login2(){
		
		super();
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doGet(req, res);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

		
		PrintWriter out = res.getWriter();
		
		
		naver nav = new naver();
		MemberInfo m1 = new MemberInfo("kim","1234");
		MemberInfo m2 = new MemberInfo("dong","1234");
		
		nav.InsertMember(m1);
		nav.InsertMember(m2);
		
		
		MemberInfo newM = new MemberInfo(req.getParameter("login"),req.getParameter("password"));
		
		RequestDispatcher dispatcher = null;
		
		System.out.println(req.getParameter("login")+ " and "+ req.getParameter("passsword"));
		if(nav.MemberCheck(newM)){
			 //dispatcher = req.getRequestDispatcher("success.jsp");
			 //dispatcher.forward(req, res);
			res.sendRedirect("success.jsp");
			
		}else{
//			req.setAttribute("msg", "fail");
			//
			//dispatcher.forward(req, res);
			//			JOptionPane.showMessageDialog(null, "아이디나 패스워드가 잘못되었습니다");
			
			res.sendRedirect("login.jsp?msg=fail");
		}
		
	}
	
}
