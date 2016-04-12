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
        	location.href = "GroupSetting/add.do?";
        }
        
        function modifyRow(){
        	var gSID = getRowCell(maingrid,"gSID");
        	if(gSID!="" && gSID!=null){
	        	location.href = "GroupSetting/edit.do?gSID="+gSID;        		
        	}
        }
        function deleteRow(){
        	var gSID = getRowCell(maingrid,"gSID");
      		if(confirm("是否刪除？")){
     			$.ajax({
         			type:"post",
         			url:"GroupSetting/deleteGroupSetting.do",
         			data:"gSID="+gSID,
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
        	/* setTabTitle(parent.$("#framecenter"),"小組設置列表")  */
        	
            var isMemberData = [{isMember:0,text:'非會員'},{isMember:1,text:'會員'}];
            var serviceStatusData = [{serviceStatus:0,text:'沒有服務'},{serviceStatus:1,text:'服務中'},{serviceStatus:2,text:'服務完成'}];
        	
            var columns = [
    	                { display: '小組編號', name: 'gSNO', minWidth: 100 },
    	                { display: '小組名稱', name: 'groupName', minWidth: 140 },
    	                { display: '小組目標', name: 'target', minWidth: 140 },
    	                { display: '負責人', name: 'handler', minWidth: 140 },
    	                { display: '開始日期', name: 'beginDate', minWidth: 140 },
    	                { display: '結束日期', name: 'endDate', minWidth: 140 },
    	                { display: '參與人數', name: 'qty', minWidth: 140 },
    	                { display: '收費', name: 'toll', minWidth: 140 },
    	                { display: '備註', name: 'note', minWidth: 140 }
                    ] ;
            
            var gridToolBar = [
                               { text: '增加', click: itemclick, icon: 'add' , id:"add" },
                               { line: true },
                               { text: '修改', click: itemclick, icon: 'modify' , id:"modify" },
                               { line: true },
                               { text: '删除', click: itemclick, icon: 'delete' , id:"delete" }
                             ];
            maingrid = ligerGrid("maingrid",'99%',columns,"GroupSetting/list.do?",gridToolBar,false,true);
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