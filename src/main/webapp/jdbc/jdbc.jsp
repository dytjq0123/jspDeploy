<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- db connection 얻는 방법 3가지
		1. jdbc
		2. application connection pool
		3. was connection pool (jndi)
		
		각 방법별로 커넥션을 생성하는 시간 profiling
	 -->
	 
<%
	// db 설정에 대한 값 설정
	String driverClassName = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "pc05";
	String password = "java";
	
	Class.forName(driverClassName);
	
	Connection conn = null;
	
	try{
		long statTime = System.currentTimeMillis();
		
		// 커넥션을 100번 얻어오고 해제한다.
		for(int i = 0; i < 30; i++){
			conn =  DriverManager.getConnection(url, username, password);
			out.write(i+"scheme : " + conn.getSchema() + "<br>");
			conn.close();
		}
		
		long endTime = System.currentTimeMillis();
		
	out.write("during : " + (endTime - statTime) + "ms");
	} catch (SQLException e) {
		// TODO: handle exception
	} finally{
		// 6. 사용했던 자원 반납
		if(conn!=null) try {
			conn.close();
		} catch (SQLException e2) {
			// TODO: handle exception
		}
	
	}
	
	// localhost:8180/jdbc/jdbc.jsp
	
%>
	
</body>
</html>