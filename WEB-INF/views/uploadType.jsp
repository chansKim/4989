<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>

<!-- Modal HTML -->
<div id="media" class="modal fade">
	<div class="modal-dialog">
		<form id="pdsupload" action="./pdsupload_movie.do" method="post" name="mForm" 
			modelAttribute="pdsdto" enctype="multipart/form-data" onSubmit="formChk();return false">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true" >&times;</button>
					<h4 class="modal-title">
						<font color="#A4A4A4">거래 상품 동영상 등록</font> 
						
					</h4>
				</div>
				<div class="modal-body">
					<table>
						<col width="200" />
						<col width="500" />
						<div class="form-group">
						<input type="hidden" name='m_mail' value='${login.m_mail}' />
							<label for="m_mail"> <font color="#A4A4A4">${login.m_mail}</font></label>
						</div>
						<input type="text" name='r_title' id='r_title' class="form-control"
							placeholder="제목" /><hr>
						<div class="fileload">
							<input type="file" name="fileload" class="form-control"
								placeholder="FILE" />
						</div>
						<div class="link">
							<input type="text" name='r_link' id='r_link' class="form-control"
								placeholder="임베드 코드나 동영상 URL" />
						</div>
						
						<div class="radio">
						  <label>
						    <input type="radio" name="post_type" value="1" checked>
						    팝니다 &nbsp; &nbsp; &nbsp;
						    <input type="radio" name="post_type"  value="2">삽니다
						  </label>
						</div>
						<hr>
						<select name="number_type">
						  <option value="1">핸드폰 번호 비공개</option>
						  <option value="2">핸드폰 번호 공개</option>
						</select>
						
						<div class="content">
							<textarea name='r_content' id='r_content' class="form-control"
								placeholder="동영상 설명" /></textarea>
						</div>
						<div class="k_name">
							<input type="text" name='k_name' class="form-control"
								placeholder="키워드들을 입력해주세요." /></input>
						</div>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary" >POST</button>
				</div>
			</div>
		</form>
	</div>
</div>

<!-- Modal HTML -->
<div id="photo" class="modal fade">
	<div class="modal-dialog">
		<form id="pdsupload" action="./pdsupload_photo.do" method="post" name="pForm" 
			modelAttribute="pdsdto" enctype="multipart/form-data" onSubmit="formChk_picture();return false">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">
						<font color="#A4A4A4">거래 상품 사진 등록</font>
					</h4>
				</div>
				<div class="modal-body">
					<table>
						<col width="200" />
						<col width="500" />
						<div class="form-group">
							<label for="m_mail"> <font color="#A4A4A4">${login.m_mail}</font></label>
						</div>
						<div class="title">
							<input type="text" name='r_title' id="r_title" class="form-control"
								placeholder="제목" />
						</div>
						<div class="radio">
						  <label>
						    <input type="radio" name="post_type" value="1" checked>
						    팝니다 &nbsp; &nbsp; &nbsp;
						    <input type="radio" name="post_type"  value="2">삽니다
						  </label>
						</div>		
						<hr>					
						<div class="fileload">
						<input type="file" name="fileload" id="profile_pt" onchange="previewImage(this,'View_area')">
						<center><div id='View_area' style='position:relative; width: 100%px; 
						height: 300px; color: black; border: 0px solid black; dispaly: inline; '></div></center>
						
						</div>
						<div class="link">
							<input type="hidden" name='r_link' value='null'
								class="form-control" placeholder="LINK" />
						</div>
						<hr>
						<select name="number_type">
						  <option value="1">핸드폰 번호 비공개</option>
						  <option value="2">핸드폰 번호 공개</option>
						</select>
						
						<div class="content">
							<textarea name='r_content' id="r_content" class="form-control"
								placeholder="사진 설명" /></textarea>
						</div>
						<div class="k_name">
							<input type="text" name='k_name' class="form-control"
								placeholder="키워드들을 입력해주세요." /></input>
						</div>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">POST</button>
				</div>
			</div>
		</form>
	</div>
</div>

<!-- Modal HTML -->
<div id="context" class="modal fade">
	<div class="modal-dialog">
		<form id="pdsupload" name="textForm" action="./pdsupload_text.do" method="post" 
			modelAttribute="pdsdto" enctype="multipart/form-data" onSubmit="formChk_text();return false">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">
						<font color="#A4A4A4">거래 상품 텍스트 등록</font>
					</h4>
				</div>
				<div class="modal-body">
					<table>
						<col width="200" />
						<col width="500" />
						<div class="form-group">
							<label for="m_mail"> <font color="#A4A4A4">${login.m_mail}</font></label>
						</div>
						<div class="title">
							<input type="text" id='r_title' name="r_title" class="form-control"
								placeholder="제목" />
						</div>
						
						<div class="radio">
						  <label>
						    <input type="radio" name="post_type" value="1" checked>
						    팝니다 &nbsp; &nbsp; &nbsp;
						    <input type="radio" name="post_type"  value="2">삽니다
						  </label>
						</div>
						
						<hr>
						<select name="number_type">
						  <option value="1">핸드폰 번호 비공개</option>
						  <option value="2">핸드폰 번호 공개</option>
						</select>
						
						<div class="content">
							<textarea id='r_content' name="r_content" class="form-control"
								placeholder="내용" /></textarea>
						</div>
						<div class="k_name">
							<input type="text" name='k_name' class="form-control"
								placeholder="키워드들을 입력해주세요." /></input>
						</div>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">POST</button>
				</div>
			</div>
		</form>
	</div>
</div>

<!-- Modal HTML -->
<div id="audio" class="modal fade">
	<div class="modal-dialog">
		<form id="pdsupload" action="./pdsupload_audio.do" method="post" name="aForm" 
			modelAttribute="pdsdto" enctype="multipart/form-data" onSubmit="formChk_audio();return false">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">
						<font color="#A4A4A4">거래 상품 오디오 등록</font>
					</h4>
				</div>
				<div class="modal-body">
					<table>
						<col width="200" />
						<col width="500" />
						<div class="form-group">
						<input type="hidden" name='m_mail' value='${login.m_mail}' />
							<label for="m_mail"> <font color="#A4A4A4">${login.m_mail}</font></label>
						</div>
						<div class="title">
							<input type="text" name='r_title' class="form-control"
								placeholder="제목" />
						</div>
						<div class="radio">
						  <label>
						    <input type="radio" name="post_type" value="1" checked>
						    팝니다 &nbsp; &nbsp; &nbsp;
						    <input type="radio" name="post_type"  value="2">삽니다
						  </label>
						</div>
						<hr>
						<div class="fileload">
							<input type="file" name="fileload" class="form-control"
								placeholder="FILE" />
						</div>
						<div class="link">
							<input type="text" name='r_link' class="form-control"
								placeholder="외부 URL" />
						</div>
						
						<hr>
						<select name="number_type">
						  <option value="1">핸드폰 번호 비공개</option>
						  <option value="2">핸드폰 번호 공개</option>
						</select>
						
						<div class="content">
							<textarea name='r_content' class="form-control"
								placeholder="오디오 설명" /></textarea>
						</div>
						<div class="k_name">
							<input type="text" name='k_name' class="form-control"
								placeholder="키워드들을 입력해주세요." /></input>
						</div>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">POST</button>
				</div>
			</div>
		</form>
	</div>
</div>

<!-- Modal HTML -->
<div id="photo2" class="modal fade">
	<div class="modal-dialog">
		<form id="pdsupload" action="./pdsupload_photo.do" method="post" name="pForm" 
			modelAttribute="pdsdto" enctype="multipart/form-data" onSubmit="formChk_picture();return false">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">
						<font color="#A4A4A4">사진</font>
					</h4>
				</div>
				<div class="modal-body">
					<table>
						<col width="200" />
						<col width="500" />
						<div class="form-group">
							<label for="m_mail"> <font color="#A4A4A4">${login.m_mail}</font></label>
							
							<span class="example" data-dropdown="#dropdown-2">카테고리</span>
						
						<div id="dropdown-2" class="dropdown dropdown-tip">
						
							<ul class="dropdown-menu">
								<li><label><input type="checkbox" />  등록된 키워드1</label></li>
								<li><label><input type="checkbox" />  등록된 키워드2</label></li>
								<li><label><input type="checkbox" />  등록된 키워드3</label></li>
								<li><label><input type="checkbox" />  ...</label></li>
								<li class="dropdown-divider"></li>
								<li><label><input type="radio" name="radio-group" checked="checked" /> Radio 1</label></li>
								<li><label><input type="radio" name="radio-group" /> Radio 2</label></li>
								<li><label><input type="radio" name="radio-group" /> Radio 3</label></li>
							</ul>
						</div>
	
							
						</div>
						<div class="title">
						
							<input type="text" name='r_title' id="r_title" class="form-control"
								placeholder="제목" />
						</div>
						
						<div id="dragandrophandler">Drag & Drop Files Here</div>
						<br><br>
						<div id="status1"></div>
						
						
						<div class="fileload">
						<input type="file" name="fileload" id="profile_pt" onchange="previewImage(this,'View_area')">
						<center><div id='View_area' style='position:relative; width: 100%px; 
						height: 300px; color: black; border: 0px solid black; dispaly: inline; '></div></center>
						
						</div>
						<div class="link">
							<input type="hidden" name='r_link' value='null'
								class="form-control" placeholder="LINK" />
						</div>
						<div class="content">
							<textarea name='r_content' id="r_content" class="form-control"
								placeholder="사진 설명" /></textarea>
						</div>
						<div class="k_name">
							<input type="text" name='k_name' class="form-control"
								placeholder="키워드들을 입력해주세요." /></input>
						</div>
						
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">POST</button>
				</div>
			</div>
		</form>
	</div>
</div>
