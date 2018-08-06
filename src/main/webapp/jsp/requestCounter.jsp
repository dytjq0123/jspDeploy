<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- application : requestCounter : Map<String, Integer>
el, jstl --%>


<c:forEach items="${requestCount }" var="req">
	${req.key }  / ${req.value } <br>
</c:forEach>


</body>
</html>