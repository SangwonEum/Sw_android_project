package Database;




import java.sql.*;



import Bean.Person;

public class DbUtil {
	String url = null;
	//String url = "jdbc:mariadb://dev-db-maria:3306/test";
	String id = null;
	String pw = null;
	Connection conn = null;
	ResultSet rs = null;
	Statement stmp   = null;
	

	
	public DbUtil(){
			
		//url = "jdbc:mysql://dev-db-maria:3306/test";
		url = "jdbc:mariadb://dev-db-maria:3306/test";
		id = "ammt";
		pw = "!1ammt123";
		conn = null;
		rs = null;
		stmp   = null;
		
		
	}

	
	public Connection Connect(){
		try{
			 Class.forName("org.mariadb.jdbc.Driver");
			 //Class.forName("com.mariadb.jdbc.Driver");
			 conn = DriverManager.getConnection(url,id,pw);
			 System.out.println("데이터 베이스에 정상적으로 접속하였습니다");
			 
			  //stmp = conn.createStatement();
			  //rs =  stmp.executeQuery(sql1);
			 
			 
			 
		

		}catch(Exception e){
			
			System.out.println("해당 클래스 찾을수 없음");
			e.printStackTrace();
			
		}finally{
			
			return conn;
		}
		
	}
	
	
	public void Disconnect() throws SQLException{
		if(rs != null) rs.close();
		if(stmp != null) stmp.close();
		if(conn != null) conn.close();
	}
	


}
