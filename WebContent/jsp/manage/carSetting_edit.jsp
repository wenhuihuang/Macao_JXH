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
				location.href="jsp/manage/carSetting_list.jsp";
			break;
		}
		
	}
	
	function save(){
		$("#Button1").click();	
	}
    
	$(function(){
		if($("#carID").val() != "" && $("#carID").val() != 'null' && $("#carID").val() != 'undefined'){
			setTabTitle(parent.$("#framecenter"),"校車設置編輯")
		}else{
			setTabTitle(parent.$("#framecenter"),"校車設置新增")
		}
		
		$(".toptoolbar").ligerToolBar({ items: [
            { text: '保存', click: itemclick, icon: 'save' , id:"save" },
            { line: true },
            { text: '取消', click: itemclick, icon: 'back' , id:"back" }
          ]
          });
		
		
		ligerForm("form1");
	 var siteArray;
	 function site(arr){
		 var site = $("#site").val();
		 	siteArray=site.split(",");
		 	function init(siteArray){
		 	
			 	var html="";
			 	for(var i = 0;i < siteArray.length;i++){
			 		if(i == siteArray.length-1){
			 			html+="<div class='site-"+i+"'><i class='i-no'>"+(i+1)+"</i><input class='site-input' type='text' value='"+siteArray[i]+"'><a href='javascript:;' class='btn site-del'>刪除</a></div>";
			 		}else{
			 			html+="<div class='site-"+i+"'><i class='i-no'>"+(i+1)+"</i><input class='site-input' type='text' value='"+siteArray[i]+"'><a href='javascript:;' class='btn site-del'>刪除</a><i class='arrows'></i></div>";
			 		}
			 	}
			 	$("#site-wrap").html(html);
				var s="";
		 		for(var i = 0;i < siteArray.length;i++){
		 			if(i != siteArray.length-1)
		 			s += siteArray[i]+",";
		 			else
		 			s += siteArray[i];
		 		}
		 		$("#site").val(s);
		 		del()
		 		changeFn()
		 	}
		 	init(siteArray)
		 	function del(){
			 	$(".site-del").click(function(){
			 		var div = $(this).parents("div").attr("class").toString();
			 		var i = parseInt(div.replace(/^\w+\-/,""));
			 		//$("."+div).remove()
			 		siteArray.splice(i,1);
			 		init(siteArray)
			 		
			 	})
		 	}
		 	function changeFn(){
			 	$("#site-wrap input").change(function(){
			 		var self=$(this)
			 		var div = $(this).parents("div").attr("class").toString();
			 		var i = parseInt(div.replace(/^\w+\-/,""));
			 		//$("."+div).remove()
			 		var v = $(this).val();
			 		var re = /\,+/g;
			 		if(re.test(v)){
			 			v = self.val().replace(/\,+/g," ")
			 		}
			 		siteArray.splice(i,1,v);
			 		init(siteArray)
			 		
			 	})
		 	}
	
		$(".site-add").click(function(){
	 		siteArray.push("0");
	 		init(siteArray)
	 	})
	 }
	 site()

	 
    })
        
    </script>
</head>
<body>
	<div class="toptoolbar"></div>
	<form name="form1" class="liger-form" method="post" action="CarSetting/submit.do" id="form1" style="margin: 20px;">
	<input type="hidden" name="carID" id="carID" value="${carSetting.carID }">
	
	<input type="hidden" name="site" id="site"  value="${carSetting.site }">
	
	
	<div id="tab">
		  	<div tabid="carSetting" title="校車設置">
		  		<div class="inline-group">
		  			<label>校車編號：</label>
		  			<input width="120px" value="${carSetting.carNO }" name="carNO" type="text" ltype="text" />
		  			<label>校車車牌號：</label>
		  			<input width="120px" value="${carSetting.carNumber }" name="carNumber" type="text" ltype="text" />
		  			<label>司機：</label>
		  			<input width="120px" value="${carSetting.worker }" name="worker" type="text" ltype="text" />
		  		</div>
		  		<div class="inline-group">
		  			<label>隨車人員：</label>
		  			<input width="120px" value="${carSetting.assistant }" name="assistant" type="text" ltype="text" />
		  			<label>發車時間：</label>
		  			<input width="120px" value="${carSetting.beginDate_str }" name="beginDate" type="text" ltype="date" />
		  			<label>終點站時間：</label>
		  			<input width="120px" value="${carSetting.endDate_str }" name="endDate" type="text" ltype="date" />
		  		</div>
		  		<div class="panel panel-default">
					<div class="panel-heading">站點設置</div>
					<div class="panel-body">
						<div id="site-wrap">
						</div>
						<a href='javascript:;' class='btn site-add'>增加</a>
					</div>
				</div>
		  		
		  	</div>
		  	
	  </div>
       
		<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
          </form>
    
</body>
</html>