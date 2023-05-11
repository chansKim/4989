<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>

<script src="${pageContext.request.contextPath}/js/reply.js" /></script>

<!-- Modal HTML -->

<body>
	<div id="reply" class="modal fade">
		<div class="modal-dialog" style="overflow-y:scroll;width:700px;height:700px;overflow:auto;">
			<form name="rForm" >
				<div class="modal-content" >
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true" >&times;</button>
						<h4 class="modal-title">
							<span class="glyphicons glyphicons-lock"></span><font color="#A4A4A4">댓글</font>
						</h4>
					</div>
					<div class="modal-body">
						<div id="replyList"></div>
					</div>
					<div class="modal-footer">
						<input type="text" name="r_content" id="r_content" class="form-control" placeholder="댓글">
						<br>
						<div>	
							<div style="float:left;"><input type="checkbox" id="secret_reply" name="secret_reply" value="secret_reply">&nbsp; 비밀댓글</div>
							<input type="button" id="n" class="btn btn-primary" value="전송" onclick="sendReply()"/>
							<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>	
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<br>
</body>	

