<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>個案資料管理</title>
<jsp:include page="/jsp/head.jsp"></jsp:include>
<jsp:include page="/jsp/menberData.jsp"></jsp:include>
<script type="text/javascript">

	function itemclick(item){
		switch (item.id){
			case "save":
				save();
			break;
			case "back":
				location.href="jsp/manage/socialWork_list.jsp";
			break;
		}
		
	}
	
	function save(){
		
		$("#Button1").click();	
	}
    
	$(function(){
		if($("#recordID").val() != "" && $("#recordID").val() != 'null' && $("#recordID").val() != 'undefined'){
			setTabTitle(parent.$("#framecenter"),"社工編輯")
		}else{
			setTabTitle(parent.$("#framecenter"),"社工新增")
		}
		
		$(".toptoolbar").ligerToolBar({ items: [
            { text: '保存', click: itemclick, icon: 'save' , id:"save" },
            { line: true },
            { text: '取消', click: itemclick, icon: 'back' , id:"back" }
          ]
          });
		
		ligerForm("form1");
		
		
    })
    </script>
</head>
<body>
	<div class="toptoolbar"></div>
	<form name="form1" class="liger-form" method="post" action="SocialWork/submit.do" id="form1" style="margin: 20px;">
	<input type="hidden" name="workID" id="workID" value="${socialWorkPojo.workID }">
	<input type="hidden" name="custID" value="${socialWorkPojo.custID }">
	<input type="hidden" name="custType2" value="${customer.custType2 }">
	
	
	<div class="inline-group row max-width-group-300 label-width-100">
		<div class="col-md-3">
			<label>社工編號：</label>
			<input type="text" ltype="text" width="120px" name="workNO" value="${socialWorkPojo.workNO }">
		</div>
		<div class="col-md-3">
			<label>會員類別：</label>
			<select name="custType" id="custType" ltype="select" width="120px">
           		<option value="1" <c:if test="${customer.custType == '1' }">selected="selected"</c:if> >永久會員</option>
           		<option value="2" <c:if test="${customer.custType == '2' }">selected="selected"</c:if> >臨時會員</option>
           		<option value="0" <c:if test="${customer.custType != '1' and customer.custType != '2'  }">selected="selected"</c:if> >非會員</option>
           	</select>
		</div>
		<div class="col-md-3">
			<label>會員編號：</label>
			<input type="text" ltype="text" width="120px" name="custCode" value="${customer.custCode }">
		</div>
		<div class="col-md-3">
			<label>社工姓名：</label>
			<input type="text" ltype="text" width="120px" name="fullName" value="${customer.fullName }">
		</div>
	</div>
	<div class="inline-group row max-width-group-300 label-width-100">
		<div class="col-md-3">
			<label>社工性別：</label>
			<div class="radio-group">
				<input id="sex1" type="radio" name="sex"  value="1" <c:if test="${customer.sex != 2 }">checked="checked"</c:if> /><label for="sex1">男</label> 
				<input id="sex2" type="radio" name="sex" value="2" <c:if test="${customer.sex == 2 }">checked="checked"</c:if> /><label for="sex2">女</label>
			</div>
		</div>
		<div class="col-md-3">
			<label>出生日期：</label>
			<input type="text" ltype="date" width="120px" name="birthday_Chn" value="${customer.birthday_ChnStr }">
		</div>
		<div class="col-md-3">
			<label>聯繫電話：</label>
			<input type="text" ltype="text" width="120px" name="mobileTelNO" value="${customer.mobileTelNO }">
		</div>
	</div>
	<div class="inline-group row max-width-group-300 label-width-100">
		<div class="col-md-3">
			<label>職業：</label>
			<input type="text" ltype="text" width="120px" name="job" value="${customer.job }">
		</div>
		<div class="col-md-3">
			<label>備註：</label>
			<input type="text" ltype="text" width="120px" name="note" value="${socialWorkPojo.note }">
		</div>
		<div class="col-md-3">
			<label>活動工作：</label>
			<input type="text" ltype="text" width="120px" name="work" value="${socialWorkPojo.work }">
		</div>
	</div>
	
		<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
          </form>
        
        
        
        
    
    
    
</body>
</html>