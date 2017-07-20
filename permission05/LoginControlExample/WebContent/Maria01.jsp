<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.sql.*"
    
    %>
    
<%


String url = "jdbc:mysql://dev-db-maria:3306/test";
//String url = "jdbc:mariadb://dev-db-maria:3306/test";
String id = "ammt";
String pw = "!1ammt123";
Connection conn = null;
ResultSet rs = null;
Statement stmp   = null;

String sql1= "select * from child";
try{
	 Class.forName("com.mysql.jdbc.Driver");
	 //Class.forName("com.mariadb.jdbc.Driver");
	 conn = DriverManager.getConnection(url,id,pw);
	 System.out.println("데이터 베이스에 정상적으로 접속하였습니다");
	 
	  stmp = conn.createStatement();
	  rs =  stmp.executeQuery(sql1);
	 
	 
	 
	 

}catch(Exception e){
	
	System.out.println("해당 클래스 찾을수 없음");
	e.printStackTrace();
	
}



%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

while(rs.next()){
%>
<tr>
	<td><%=rs.getString(1) %></td>
	<td><%=rs.getString(2) %></td>

</tr>

<% }

rs.close();
stmp.close();
conn.close();


%>

</body>
</html>