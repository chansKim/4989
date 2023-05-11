<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>

<!-- Modal HTML -->
<div id="re" class="modal fade">
	<div class="modal-dialog">
		<!-- <form name="textForm" action="./send_report.do" method="post"  -->
		<form name="textForm" modelAttribute="pdsdto">
			<!-- modelAttribute="pdsdto" enctype="multipart/form-data" onSubmit="formChk_text();return false"> -->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">
						<font color="#A4A4A4">신고하기</font>
					</h4>
				</div>
				<div class="modal-body">
					<table>
						<col width="200" />
						<col width="500" />			
						<div class="content">
							<textarea name="e_content" id="e_content" class="form-control"
								placeholder="신고 사유를 입력해주세요. (ex. 욕설/사기 등)" /></textarea>
						</div>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<input type="button" btn btn-primary"  onclick="sendR_idReport();" value="신고하기" /> 
					<!--<button type="submit" class="btn btn-primary">신고하기</button>-->
				</div>
			</div>
		</form>
	</div>
</div>