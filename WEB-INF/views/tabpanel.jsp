<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
  <li role="presentation" style="padding-top:10px;"> 
    <div class="btn-group" align="right">
    <a class="menu2" href="./home_list.do"><span class="glyphicon glyphicon-th-list"></span></a> &nbsp;&nbsp;
    <a class="menu2" href="./home_baduk.do"><span class="glyphicon glyphicon-th"></span></a> &nbsp;&nbsp;
    <a class="menu2" href="./home.do"><span class="glyphicon glyphicon-th-large"></span></a>
    </div>
    </li>
    <li role="presentation"><a class="main_menu" href="./home.do?param=complete" aria-controls="complete" data-toggle="tab">거래완료</a></li>
    <li role="presentation"><a class="main_menu" href="./home.do?param=buy" aria-controls="buy" role="tab" data-toggle="tab">구매</a></li>
    <li role="presentation"><a class="main_menu" href="./home.do?param=sell" aria-controls="sell" role="tab" data-toggle="tab">판매</a></li>
    <li role="presentation"><a class="main_menu" href="./home.do?param=all" aria-controls="all" role="tab" data-toggle="tab">전체</a></li>
    
  </ul>
<!-- Tab panes -->
<div class="tab-content">
	<div role="tabpanel" class="tab-pane" id="complete">거래완료 물품만.</div>
	<div role="tabpanel" class="tab-pane" id="buy">삽니다 등록 물품만.</div>
	<div role="tabpanel" class="tab-pane" id="sell">판매중인 물품만.</div>
	<div role="tabpanel" class="tab-pane active" id="all">전체</div>
</div>