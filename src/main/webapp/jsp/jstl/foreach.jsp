<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table td{border:1px solid black;}	
	td:hover{background-color:rgba(0, 0, 0, .5)}
</style>

</head>
<body>
<table cellspacing="0" cellpadding="0">
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>CALL_CNT</th>
	</tr>

<c:forEach items="${studentList }" var="vo" varStatus="status">
	<tr>
		<td>${vo.id } / ${status.index }</td>
		<td>${vo.name }</td>
		<td>${vo.call_cnt }</td>
	</tr>
</c:forEach>
</table>

<h3>foreach map</h3>
<%-- map에 있는 값들을 전부 조회해서 출력
	map.get("name"), map.get("alias") --%>
<c:forEach items="${map }" var="entry">
	${entry.key } / ${entry.value } <br>
</c:forEach>

<h3>forTokens</h3>
<c:forTokens items="${lineRangers }" delims="," var="ranger">
	${ranger } <br>
</c:forTokens>
</body>
</html>