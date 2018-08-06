<%@page import="java.sql.SQLException"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
	Context context = new InitialContext();

	DataSource datasource = (DataSource)context.lookup("java:comp/env/jdbc/oracleDB");
	
	
	Connection conn = null;
	int i = 0;
	try{
		long statTime = System.currentTimeMillis();
		
		// 커넥션을 100번 얻어오고 해제한다.
		for(; i < 30; i++){
			conn =  datasource.getConnection();
			out.write(i+"scheme : " + conn.getSchema() + "<br>");
			conn.close();
		}
		
		long endTime = System.currentTimeMillis();
		
		out.write("during : " + (endTime - statTime) + "ms");
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally{
		// 6. 사용했던 자원 반납
		if(conn!=null) try {
			conn.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	
	}
	
	// localhost:8180/jdbc/jndi.jsp
	
%>
</body>
</html>