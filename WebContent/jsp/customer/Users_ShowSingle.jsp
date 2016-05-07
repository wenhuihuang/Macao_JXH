<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
	
	<jsp:include page="/jsp/head.jsp"></jsp:include>
    <script type="text/javascript" src="windows/toptoolbar.js"></script>
	<script type="text/javascript" src="ajaxfileupload.js"></script>
	
	
	<script type="text/javascript" src="windows/keycode.js"></script>
	<script type="text/javascript" src="windows/jsUnitCore.js"></script>
	
	<script type="text/javascript">
		var usersForm;
		var dialog = frameElement.dialog; //调用页面的dialog对象(ligerui对象)
		$(function(){
			renewData();
		});
		
		
		function renewData(){
			//1、设置 frmBaseEditActionName 用于保存数据时调用方法 (可以在toptoolbar.js中查到)
	    	frmBaseEditActionName = "UsersAction";
			//2、 设置要保存的表的主键名 frmBaseEditIdName(可以在toptoolbar.js中查到)
	    	frmBaseEditIdName = "userId";
	    	$("#navtabMain").ligerTab();
	    	isCoverSave = true;
	    	loadUserForm();
		}
		
	</script>
	
	<!-- 读取Form -->
	<script type="text/javascript">
		function loadUserForm(){
			//3、获取数据
			var typeCodesData = <%=request.getAttribute("typeCodes")%>;
			var formData ;
			$.ajax({
				type:"POST",
				async:true,
				url:"User/loadMasterFromDB.do",
				data:{"editPrimaryKey":editPrimaryKey},
				dataType:"json",
				success:function(data){
					formData = data;
					formData.orgPassword = formData.password;
					formData.password2 = formData.password;
					usersForm.setData(formData);
				},
				error:function(){
					alert("網絡出錯！");
				}
			});
			
			usersForm = $("#usersForm").ligerForm({
	            inputWidth: 150, labelWidth:120, space: 20,
	            fields: [
					{ name: "userId",  type: "hidden" },
					{ name: "orgPassword",type:"hidden"},
					{ display: "操作員編號",  name: "userCode", newline: true, type: "text", group: "操作員屬性", groupicon: groupicon},
					{ display: "操作員名稱",  name: "userName", newline: true, type: "text"},
					{ display: "描述",  name: "note", newline: true, type: "text",width:300},
					{ display: "密碼",  name: "password", newline: true, type: "password"},
					{ display: "確認密碼",  name: "password2", newline: true, type: "password"},
					{ display: "用戶所屬機構",  name: "belongOrg", newline: true, type: "combobox",textField:"typeName",editor:{
						selectBoxWidth: 200,
	                    selectBoxHeight: 120,
	                    textField: 'text',
	                    valueField : 'id',
	                    grid:{
	                    	columns: [
	            	                { display: '所屬機構', name: 'text', width:150 }
	            	            ],
	                    	data : typeCodesData,
	                    	isScroll: false,
	                    	sortName: 'text',
	                    	usePager:false
	                    },render:function(item){
	                    	
							for(var i = 0;i<typeCodesData.Rows.length;i++){
	                    		if(typeCodesData.Rows[i].id==item){
	                    			return typeCodesData.Rows[i].text; 
	                    		}
	                    	}
	                    }
						
					}},
					
				],
	       	 	onAfterSetFields :function(){
	           		
	            }
	            
		   	 });

			
		}
	</script>
	
	
	<!-- 保存操作 -->
	<script type="text/javascript">
		function frmBaseEditSave(){
			var resultForm = usersForm.getData();
			if(resultForm.userCode==null||resultForm.userCode==""){
				alert("請輸入操作員編號！");
				return false;
			}
			
			
			
			if(resultForm.userName==null||resultForm.userName==""){
				alert("請輸入操作員名稱！");
				return false;
			}
			if(resultForm.password==null||resultForm.password==""){
				alert("請輸入密碼！");
				return false;
			}
			
			if(resultForm.password!=resultForm.password2){
				alert("兩次密碼不一致");
				return false;
			}
			
			
			$.ajax({
				type:"POST",
				url:"User/checkUserCode.do",
				data:{"userCode":resultForm.userCode},
				dataType:"json",
				async:false,
				success:function(data){
					if(data == true){
						saveUser(resultForm);
					}else{
						alert("操作員編號已經存在，請填寫其他編號！");
					}
					
				} ,
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					  alert("服务器获取数据失败："+errorThrown);
					
 				}
			});
			
			
		}
	function saveUser(resultForm){
		
		$.ajax({
			type:"POST",
			url:"User/saveUser.do",
			data:resultForm,
			//dataType:"json",
			async:false,
			success:function(data){
				if(data == true || data == 'true'){
					dialog.close();
				}else{
					alert("保存失敗！")
				}
			} ,
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				  alert("服务器获取数据失败："+errorThrown);
				}
			
		});
	}
	
	</script>
	
	<!-- String 转为日期 -->
	<script>
		function tranStrToDate(str){
			return new  Date(Date.parse(str.replace(/-/g,   "/"))); 
		}
	</script>
	
	

	
  </head>
  
  <body>
    <div id="frmBaseEdit_toptoolbar"></div>
     <div id="usersForm" style="padding:10px" >   	
	</div>
  </body>
</html>

