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
        	location.href = "Treatment/add.do?treatmentType=3";
        }
        
        function modifyRow(){
        	var treatmentID = getRowCell(maingrid,"treatmentID");
        	var custID = getRowCell(maingrid,"custID");
        	alert(custID+"=custID");
        	if(treatmentID!="" && treatmentID!=null){
	        	location.href = "Treatment/edit.do?treatmentType=3&treatmentID="+treatmentID+"&custID="+custID;        		
        	}
        }
        function deleteRow(){
        	var treatmentID = getRowCell(maingrid,"treatmentID");
        	var custID = getRowCell(maingrid,"custID");
        	alert(treatmentID)
      		if(confirm("是否刪除？")){
     			$.ajax({
         			type:"post",
         			url:"Treatment/deleteTreatment.do",
         			data:"treatmentID="+treatmentID+"&custID="+custID,
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
        	/* setTabTitle(parent.$("#framecenter"),"物理治療列表") */ 
        	
            var custTypeData = [{custType:0,text:'非會員'},{custType:1,text:'會員'},{custType:2,text:'會員'}];
            var serviceStatusData = [{serviceStatus:0,text:'沒有服務'},{serviceStatus:1,text:'服務中'},{serviceStatus:2,text:'服務完成'}];
        	
            var columns = [
       	                { display: '物理治療編號', name: 'treatmentNO', align: 'left', width: 100, minWidth: 60 },
    	                { display: '姓名', name: 'fullName', minWidth: 100 },
    	                { display: '會員/非會員', name: 'custType',width:70 
    	                	,editor: { data: custTypeData, valueField: 'custType' },
	                        render: function (item)
	                        {
	                        	return getGridSelectedData(custTypeData[parseInt(item.custType)]);
	                        } },
    	                { display: '治療師', name: 'worker', width: 100, minWidth: 60 },
    	                { display: '申服務日期', name: 'applyDate', width: 100, minWidth: 60 },//暫時沒有寫
    	                { display: '評估日期', name: 'assessDate', minWidth: 140 },
    	                { display: '服務狀態', name: 'serviceStatus', minWidth: 100
    	                	,editor: { data: serviceStatusData, valueField: 'serviceStatus' },
	                        render: function (item)
	                        {
	                        	return getGridSelectedData(serviceStatusData[parseInt(item.serviceStatus)]);
	                        }  },
    	                { display: '輸候開始日期', name: 'awaitDate', minWidth: 140 },
    	                { display: '治療開始日期', name: 'startDate', minWidth: 140 },
    	                { display: '治療結束日期', name: 'closeDate', minWidth: 140 },
    	                { display: '中止/結案原因', name: 'reason', minWidth: 140 },
    	                { display: '備註', name: 'note', minWidth: 140 }
                    ] ;
            
            var gridToolBar = [
                               { text: '增加', click: itemclick, icon: 'add' , id:"add" },
                               { line: true },
                               { text: '修改', click: itemclick, icon: 'modify' , id:"modify" },
                               { line: true },
                               { text: '删除', click: itemclick, icon: 'delete' , id:"delete" }
                             ];
            maingrid = ligerGrid("maingrid",'99%',columns,"Treatment/list.do?treatmentType=3",gridToolBar,false,true);
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