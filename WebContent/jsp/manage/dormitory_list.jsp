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
        	location.href = "Dormitory/add.do";
        }
        
        function modifyRow(){
        	var recordID = getRowCell(maingrid,"recordID");
        	var custID = getRowCell(maingrid,"custID");
        	if(recordID!="" && recordID!=null){
	        	location.href = "Dormitory/edit.do?recordID="+recordID+"&custID="+custID;        		
        	}
        }
        function deleteRow(){
        	var recordID = getRowCell(maingrid,"recordID");
        	var custID = getRowCell(maingrid,"custID");
        	alert(treatmentID)
      		if(confirm("是否刪除？")){
     			$.ajax({
         			type:"post",
         			url:"Dormitory/deleteDormitory.do",
         			data:"recordID="+recordID+"&custID="+custID,
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
        	setTabTitle(parent.$("#framecenter"),"院舍記錄列表") 
        	
            var isMemberData = [{isMember:0,text:'非會員'},{isMember:1,text:'會員'}];
            var recordTypeData = [{recordType:0,text:'輪候'},{recordType:1,text:'入住'},{recordType:2,text:'離開'}];
        	
            var columns = [
       	                { display: '住客編號', name: 'recordNO', align: 'left', width: 100, minWidth: 60 },
    	                { display: '姓名', name: 'fullName', minWidth: 100 },
    	                { display: '會員/非會員', name: 'isMember',width:70 
    	                	,editor: { data: isMemberData, valueField: 'isMember' },
	                        render: function (item)
	                        {
	                        	return getGridSelectedData(isMemberData[parseInt(item.isMember)]);
	                        } },
    	                { display: '申請日期', name: 'applyDate', width: 100, minWidth: 60 },
    	                { display: '入住狀態', name: 'RecordType', minWidth: 100
    	                	,editor: { data: recordTypeData, valueField: 'recordType' },
	                        render: function (item)
	                        {
	                        	return getGridSelectedData(recordTypeData[parseInt(item.recordType)]);
	                        }  },
    	                { display: '入住日期', name: 'inDate', minWidth: 140 },
    	                { display: '執行職員', name: 'worker', minWidth: 140 },
    	                { display: '離開日期', name: 'outDate', minWidth: 140 },
    	                { display: '備註', name: 'note', minWidth: 140 }
                    ] ;
            
            var gridToolBar = [
                               { text: '增加', click: itemclick, icon: 'add' , id:"add" },
                               { line: true },
                               { text: '修改', click: itemclick, icon: 'modify' , id:"modify" },
                               { line: true },
                               { text: '删除', click: itemclick, icon: 'delete' , id:"delete" }
                             ];
            maingrid = ligerGrid("maingrid",'99%',columns,"Dormitory/list.do",gridToolBar,false,true);
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