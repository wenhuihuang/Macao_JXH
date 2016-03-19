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
	<input type="hidden" name="workID" id="workID" value="${socialWork.workID }">
	
	
	<div class="inline-group row max-width-group-300 label-width-100">
		<div class="col-md-3">
			<label>社工編號：</label>
			<input type="text" ltype="text" width="120px" name="workNO" value="${socialWork.workNO }">
		</div>
		<div class="col-md-3">
			<label>會員編號：</label>
			<input type="text" ltype="text" width="120px" name="custNO" value="${socialWork.custNO }">
		</div>
		<div class="col-md-3">
			<label>非會員編號：</label>
			<input type="text" ltype="text" width="120px" name="custNewNO" value="${socialWork.custNewNO }">
		</div>
		<div class="col-md-3">
			<label>社工姓名：</label>
			<input type="text" ltype="text" width="120px" name="workName" value="${socialWork.workName }">
		</div>
	</div>
	<div class="inline-group row max-width-group-300 label-width-100">
		<div class="col-md-3">
			<label>社工性別：</label>
			<div class="radio-group">
				<input id="sex1" type="radio" name="sex"  value="1" <c:if test="${socialWork.sex != 2 }">checked="checked"</c:if> /><label for="sex1">男</label> 
				<input id="sex2" type="radio" name="sex" value="2" <c:if test="${socialWork.sex == 2 }">checked="checked"</c:if> /><label for="sex2">女</label>
			</div>
		</div>
		<div class="col-md-3">
			<label>社工年齡：</label>
			<input type="text" ltype="text" width="120px" name="age" value="${socialWork.age }">
		</div>
		<div class="col-md-3">
			<label>出生日期：</label>
			<input type="text" ltype="date" width="120px" name="birthday" value="${socialWork.birthday_str }">
		</div>
		<div class="col-md-3">
			<label>聯繫電話：</label>
			<input type="text" ltype="text" width="120px" name="phone" value="${socialWork.phone }">
		</div>
	</div>
	<div class="inline-group row max-width-group-300 label-width-100">
		<div class="col-md-3">
			<label>職位：</label>
			<input type="text" ltype="text" width="120px" name="work" value="${socialWork.work }">
		</div>
		<div class="col-md-3">
			<label>備註：</label>
			<input type="text" ltype="text" width="120px" name="note" value="${socialWork.note }">
		</div>
	</div>
	
		<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
          </form>
        
        
        
        
    
    
    
</body>
</html>