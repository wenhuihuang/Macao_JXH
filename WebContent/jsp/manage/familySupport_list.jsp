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
        	location.href = "FamilySupport/add.do";
        }
        
        function modifyRow(){
        	var supportID = getRowCell(maingrid,"supportID");
        	if(supportID!="" && supportID!=null){
	        	location.href = "FamilySupport/edit.do?supportID="+supportID;        		
        	}
        }
        function deleteRow(){
        	var supportID = getRowCell(maingrid,"supportID");
      		if(confirm("是否刪除？")){
     			$.ajax({
         			type:"post",
         			url:"FamilySupport/deleteFamilySupport.do",
         			data:"supportID="+supportID,
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
        	/* setTabTitle(parent.$("#framecenter"),"家庭支援列表")  */
        	
            var columns = [
    	                { display: '家庭支援編號', name: 'supportID', minWidth: 100 },
    	                { display: '家庭支援名稱', name: 'supportName', minWidth: 140 },
    	                { display: '人數控制方式', name: 'way', minWidth: 140 },
    	                { display: '線上可報名名額', name: 'onlineCan', minWidth: 140 },
    	                { display: '線下可報名名額', name: 'offlineCan', minWidth: 140 },
    	                { display: '報名開始日期', name: 'applyBDate', minWidth: 140 },
    	                { display: '報名結束日期', name: 'applyEDate', minWidth: 140 },
    	                { display: '支援開始日期', name: 'supportBDate', minWidth: 140 },
    	                { display: '支援結束日期', name: 'supportEDate', minWidth: 140 },
    	                { display: '支援地址', name: 'address', minWidth: 140 },
    	                { display: '贊助機構', name: 'org', minWidth: 140 },
    	                { display: '支援負責人', name: 'principal', minWidth: 140 },
    	                { display: '報名總人數', name: 'applyTotal', minWidth: 140 },
    	                { display: '接受支援總人數', name: 'participationTotal', minWidth: 140 },
    	                { display: '備註', name: 'note', minWidth: 140 }
                    ] ;
            
            var gridToolBar = [
                               { text: '增加', click: itemclick, icon: 'add' , id:"add" },
                               { line: true },
                               { text: '修改', click: itemclick, icon: 'modify' , id:"modify" },
                               { line: true },
                               { text: '删除', click: itemclick, icon: 'delete' , id:"delete" }
                             ];
            maingrid = ligerGrid("maingrid",'99%',columns,"FamilySupport/list.do?",gridToolBar,false,true);
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