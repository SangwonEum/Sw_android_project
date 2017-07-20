<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% String s= (String)request.getParameter("msg");
   //request.removeAttribute("msg");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="insertChild" name="formname">

		Login:<input type="text" name="login"><br /> password:<input
			type="password" name="password"><br /> <input type="submit"
			name="submit" value="login">

	</form>
	<script>
		function warning() {
			
		
			alert("아이디나 패스워드가 잘못되었습니다");			
		
		
		}
		function check() {
			console.log("<%=s %>");
			var value = "<%=s %>";
			if(value != "null") {
	
				warning();
			}
		}

		window.onload = check;
	</script>

</body>



</html>