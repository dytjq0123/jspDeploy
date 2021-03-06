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
	// localhost:8180/jsp/implict/pageContext.jsp
	// request, response, session, out, application
	// config
	// pageContext : 다른 객체에 대한 전반적인 정보를 갖고 있다.
	
	pageContext.getRequest();			// request 기본객체와 비교

	// application -->
	pageContext.getServletContext();	// application
	pageContext.getSession();			// session
	pageContext.getOut();				// out
%>
	<!-- html -->
	pageContext.getRequest() == request : 
	<%=request.equals(pageContext.getRequest()) %><br>
	
	pageContext.getServletContext() == application :
	<%=application.equals(pageContext.getServletContext()) %><br>
	
	pageContext.getSession() == session :
	<%=session.equals(pageContext.getSession()) %><br>
	
	pageContext.getOut() == out :
	<%=out.equals(pageContext.getOut()) %><br>
</body>
</html>