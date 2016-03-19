<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<jsp:include page="/jsp/head.jsp"></jsp:include>
<title>社工個案管理</title>
<script type="text/javascript">
        
		var maingrid = null;
        
        function itemclick(item)
        {
            switch(item.id){
            	case "add":addRow();break;
            	case "modify":modifyRow();break;
            	case "delete":deleteRow();break;
            	default : break;
            }
        }
        
        function addRow(){
        	location.href = "SocialWork/add.do?";
        }
        
        function modifyRow(){
        	var workID = getRowCell(maingrid,"workID");
        	if(workID!="" && workID!=null){
	        	location.href = "SocialWork/edit.do?workID="+workID;        		
        	}
        }
        function deleteRow(){
        	var workID = getRowCell(maingrid,"workID");
      		if(confirm("是否刪除？")){
     			$.ajax({
         			type:"post",
         			url:"SocialWork/deleteSocialWork.do",
         			data:"workID="+workID,
         			success:function(msg){
         				if(msg == "true" || msg == true){
         					maingrid.deleteSelectedRow();
         				}else{
         					alert("刪除失敗！");
         				}
         				 
         			},
         			error:function(){
         				alert("刪除失敗！");
         			}
         		})
     		} 
        }
        
        
        $(function ()
        {
        	setTabTitle(parent.$("#framecenter"),"社工列表") 
        	
            var serviceStatusData = [{serviceStatus:0,text:'沒有服務'},{serviceStatus:1,text:'服務中'},{serviceStatus:2,text:'服務完成'}];
        	
            var columns = [
    	                { display: '社工編號', name: 'workNO', minWidth: 100 },
    	                { display: '會員編號', name: 'custNO', minWidth: 140 },
    	                { display: '非會員編號', name: 'custNewNO', minWidth: 140 },
    	                { display: '社工姓名', name: 'workName', minWidth: 140 },
    	                { display: '社工性別', name: 'sex', minWidth: 140 },
    	                { display: '出生日期', name: 'birthday', minWidth: 140 },
    	                { display: '聯繫電話', name: 'phone', minWidth: 140 },
    	                { display: '職位', name: 'work', minWidth: 140 },
    	                { display: '備註', name: 'note', minWidth: 140 }
                    ] ;
            
            var gridToolBar = [
                               { text: '增加', click: itemclick, icon: 'add' , id:"add" },
                               { line: true },
                               { text: '修改', click: itemclick, icon: 'modify' , id:"modify" },
                               { line: true },
                               { text: '删除', click: itemclick, icon: 'delete' , id:"delete" }
                             ];
            maingrid = ligerGrid("maingrid",'99%',columns,"SocialWork/list.do?",gridToolBar,false,true);
            $("#pageloading").hide();
        });


        
        
    </script>
</head>
<body style="overflow-x:hidden; padding:2px;">
<div class="l-loading" style="display:block" id="pageloading"></div>
	<!-- <div id="toptoolbar"></div> --> 
	
	
	<div class="l-clear"></div>
	
	<div id="maingrid"></div>
	  
	<div style="display:none;">
	  
	</div>
 
</body>
</html>