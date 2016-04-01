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
            	case "delete":deleteRow();break;
            	case "save":
    				save();
    			break;
            	default : break;
            }
        }
        
        function addRow(){
        	maingrid.addRow();
        	//location.href = "ChargeRecord/add.do?";
        }
        
        function deleteRow(){
        	maingrid.deleteSelectedRow()
        }
        
        function save(){
        	alert("d")
        	var chargeRecordAdds = getAddedRows(maingrid);
     		var chargeRecordUpdates = getEditedRows(maingrid);
     	   	var chargeRecordDeletes = getDeletedRows(maingrid);
     	   	$.ajax({
     	   		type:'post',
	     	   	url:"ChargeRecord/submit.do",
	 			data:"chargeRecordAdds="+chargeRecordAdds+"&chargeRecordUpdates="+chargeRecordAdds+"&chargeRecordDeletes="+chargeRecordDeletes,
	 			success:function(msg){
	 				alert(msg)
	 				if(msg == "true" || msg == true){
	 				}else{
	 					alert("刪除失敗！");
	 				}
	 				 
	 			},
	 			error:function(){
	 				alert("刪除失敗！");
	 			}
     	   	})
        }
        
        
        $(function ()
        {
        	setTabTitle(parent.$("#framecenter"),"收費記錄") 
        	
            var columns = [
						{ display: '收費項目編號', name: 'projectNO', minWidth: 100,type:"text",editor: { type: 'text' }},
    	                { display: '收費項目名稱', name: 'projectName', minWidth: 140,type:"text",editor: { type: 'text' } },
    	                { display: '收費開始日期', name: 'chargeBDate', minWidth: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
    	                { display: '收費結束日期', name: 'chargeEDate', minWidth: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
    	                { display: '收費金額', name: 'money', minWidth: 140,type:"float",editor: { type: 'float' } },
    	                { display: '繳費日期', name: 'payDate', minWidth: 140, type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'} },
    	                { display: '繳費金額', name: 'payMoney', minWidth: 140,type:"float",editor: { type: 'float' }},
    	                { display: '備註', name: 'note', minWidth: 140 ,type:"text",editor: { type: 'text' }}
                    ] ;
            
            var gridToolBar = [
                               { text: '增加', click: itemclick, icon: 'add' , id:"add" },
                               { line: true },
                               { text: '保存', click: itemclick, icon: 'save' , id:"save" },
                               { line: true },
                               { text: '删除', click: itemclick, icon: 'delete' , id:"delete" }
                             ];
            maingrid = ligerGrid("maingrid",'99%',columns,"ChargeRecord/list.do?",gridToolBar,false,true);
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