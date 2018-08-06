<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-1.12.4.js"></script>
</head>
<body>
<form action="/localeSelect">
<% Object o = request.getAttribute("pa");%>
<%=request.getAttribute("pa") %>
<c:set var="sel" value="<%=o %>"></c:set>


<select id="select" name="locale">	
	<option value="ko" ${pa eq 'ko' ? "selected" : '' }>한국어</option>
	<option value="ja" ${pa eq 'ja' ? "selected" : '' }>日本語</option>
	<option value="en" ${pa eq 'en' ? "selected" : '' }>English</option>
</select>
<input type="submit" value="button">



<fmt:setLocale value="${sel }"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="hello"/><br>
	<fmt:message key="visitor">
		<fmt:param value="${userId }"/>
	</fmt:message>
</fmt:bundle>
</form>
</body>

</html>