<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>

<script src="${pageContext.request.contextPath}/js/message.js" /></script>

<!-- Modal HTML -->
<body>
<div id="me" class="modal fade">
	<div class="modal-dialog">
		<form name="textForm" action="./send_message.do" method="post" 
			modelAttribute="pdsdto" enctype="multipart/form-data">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">
						<font color="#A4A4A4">쪽지 보내기</font>
					</h4>
				</div>
				<div class="modal-body" >
					<table>
						<col width="200" />
						<col width="500" />
					        <span class="glyphicon glyphicon-plus"></span>
							<div class="row" align="center">
							  <div class="col-lg-6">
							    <div class="input-group">
							      <input type="text" id="face_mail" name="face_mail" class="form-control" placeholder="보낼 사람의 이메일을 입력해주세요">
							      <span class="input-group-btn">
							      	<input type="button" class="btn btn-default" value="검색" onclick="searchMail()"/> 
							      </span>
								</div><!-- /input-group -->
								
							    <div id="m_message"></div><!-- 추가 -->
							    <br>
							  </div><!-- /.col-lg-6 -->
							</div><!-- /.row -->
						<div class="content">
							<textarea name="n_content" class="form-control"
								placeholder="내용" /></textarea>
						</div>
					</table>
				</div>
				<div class="modal-footer">
					<div id="submit_button"><button type="button" class="btn btn-default" data-dismiss="modal">닫기</button></div>				</div>
			</div>
		</form>
	</div>
</div>
</body>