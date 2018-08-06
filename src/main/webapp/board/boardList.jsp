<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%List<BoardVo> boardList = (List<BoardVo>)request.getAttribute("boardList"); %>
	<%SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); %>
	<table border="1" cellpadding="5" cellspacing="0">
		<thead style="background-color:#333; color:#fff" >
			<tr>
				<th>제목</th>
				<th>내용</th>
				<th>사용자 아이디</th>
				<th>별명</th>
				<th>등록일(yyyy-MM-dd)</th>
			</tr>
		</thead>
	
	
	
	
		<tbody>
		<%for(BoardVo boardVo : (List<BoardVo>)request.getAttribute("boardList")){%>
			<tr>
				<td><%=boardVo.getTitle() %></td>
				<td><%=boardVo.getContent() %></td>
				<td><%=boardVo.getUserId() %></td>
				<td><%=boardVo.getAlias() %></td>
				<td><%=sdf.format(boardVo.getRegDt()) %></td>
			</tr>
		<%} %>
		<%for(int i = 0; i < boardList.size(); i++){ %>
				<tr>
					<td><%=boardList.get(i).getTitle() %></td>
					<td><%=boardList.get(i).getContent() %></td>
					<td><%=boardList.get(i).getUserId() %></td>
					<td><%=boardList.get(i).getAlias() %></td>
					<td><%=sdf.format(boardList.get(i).getRegDt()) %></td>
				</tr>
		<%} %>
		</tbody>
	</table>
</body>
</html>