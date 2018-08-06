<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<link href="/css/common.css" rel="stylesheet">

<script>
$(function(){
	$("table tbody tr").on("click", function(){
		//tr태그의 data-id 속성 값을 읽어서 input 태그의 id 값으로 설정
		//form 태그를 submit
		$("#id").val($(this).data("id"));
		$("#frm").submit();
	});
});
</script>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
$(function(){
	//주소찾기 버튼 클릭 이벤트
	$("#findAddr").on("click",function(){
		new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            //주소 변경
	            $("#addr1Label").text(data.address);
	            $("#addr1Input").val(data.address);
	            
	            $("#zipcdLabel").text(data.zonecode);
	            $("#zipcdInput").val(data.zonecode);
	            
	            //상세주소를 공백으로 초기화
	            $("#addr2").val("").focus();
	            
	        }
	    }).open();	
	});
	
	//학생 수정 버튼 클릭 이벤트
	$("#updateBtn").on("click", function(){
		//학생 이름, 상세주소
		if($("#name").val().length < 2){
			alert("학생이름을 입력해주세요.");
			$("#name").focus();
			return false;
		}
		
		if($("#addr2").val().length < 5){
			alert("상세주소를 입력해주세요.");
			$("#addr2").focus();
			return false;
		}
		
		//여기까지 진행되면 validation 통과 --> submit
		console.log($("#frm").serialize());
		$("#frm").submit();
		
		
	});
});
    
</script>

</head>

<body>   
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">JSP/SPRING 			
			<c:if test="${userVo != null }">
				[${userVo.userId }]
			</c:if>
			</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Help</a></li>
				<li><a href="/logout">Logout</a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</nav>