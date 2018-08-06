<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%@ include file="/common/top.jsp" %>
	
	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<form id="frm" class="form-horizontal" role="form" action="/studentUpdate" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">프로필</label>
						<div class="col-sm-10">
							<img src="/pic?id=${studentVo.id }">
							<input type="file" name="pic">
						</div>
					</div>
					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">학생 아이디</label>
						<div class="col-sm-10">
						<label class="control-label">${studentVo.id }</label>
							<input type="hidden" class="form-control" id="id" name="id"
								value="${studentVo.id }">
						</div>
					</div>

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">학생 이름</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="name" name="name"
								value="${studentVo.name }" placeholder="학생 이름">
						</div>
					</div>
					<div class="form-group">
						<label for="call_cnt" class="col-sm-2 control-label">호출횟수</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.call_cnt }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<label id="addr1Label" class="control-label">${studentVo.addr1 }</label>
							<input id="addr1Input" type="hidden" name="addr1" value="${studentVo.addr1 }">
							<button type="button" id="findAddr">주소찾기</button>
						</div>
					</div>
					
					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">주소2</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="addr2" name="addr2"
								value="${studentVo.addr2 }" placeholder="상세주소">
						</div>
					</div>
					
					<div class="form-group">
						<label for="zipcd" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label id="zipcdLabel" class="control-label">${studentVo.zipcd }</label>
							<input id="zipcdInput" type="hidden" name="zipcd" value="${studentVo.zipcd }">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="updateBtn" type="button" class="btn btn-default">수정</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
