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
        
        ligerUiFn.addGridRow=function(){
        	location.href = "CustCase/add.do";
        }
        
        ligerUiFn.modifyGridRow=function(){
        	var caseID = getRowCell(maingrid,"caseID");
        	var custID = getRowCell(maingrid,"custID");
        	if(caseID!=""){
	        	location.href = "CustCase/edit.do?caseID="+caseID+"&custID="+custID;        		
        	}
        }
        
     	ligerUiFn.deleteGridRow=function(){
     		var caseID = getRowCell(maingrid,"caseID");
     		if(confirm("是否刪除？")){
     			$.ajax({
         			type:"post",
         			url:"CustCase/deleteCustCase.do",
         			data:"caseID="+caseID,
         			success:function(msg){
         				if(msg == true || msg == "true"){
         					maingrid.deleteSelectedRow()  
         				}else{
         					alert("刪除失敗！");
         				}
         				
         			},
         			error:function(){
         				alert("刪除失敗！")
         			}
         		})
     		}
     	}
        
        
        $(function ()
        {
        	setTabTitle(parent.$("#framecenter"),"個案列表")
            var custTypeData = [{custType:0,text:'非會員'},{custType:1,text:'會員'},{custType:2,text:'會員'}];
            var caseStatusData = [{caseStatus:0,text:'跟進'},{caseStatus:1,text:'結案'},{caseStatus:2,text:'轉介'}];
            var cardStatusData = [{cardStatus:0,text:'退會'},{cardStatus:1,text:'正常'},{cardStatus:2,text:'欠費'}];
            var cardTypeData = [{cardType:1,text:'永久身份證'},{cardType:2,text:'非永久身份證'},{cardType:3,text:'其他'}];
        	
            var columns = [
       	                { display: '個案編號', name: 'caseNO', align: 'left', width: 100, minWidth: 60 },
    	                { display: '姓名', name: 'fullName', minWidth: 100 },
    	                { display: '會員/非會員', name: 'custType',width:70 
    	                	,editor: { data: custTypeData, valueField: 'custType' },
	                        render: function (item)
	                        {
	                        	return getGridSelectedData(custTypeData[parseInt(item.custType)]);
	                        } },
    	                { display: '接案日期', name: 'receiveDate', width: 100, minWidth: 60 },
    	                //{ display: '會談日期', name: '', width: 100, minWidth: 60 },//暫時沒有寫
    	                { display: '結案日期', name: 'closeDate', minWidth: 140 },
    	                { display: '個案狀態', name: 'caseStatus', minWidth: 100
    	                	,editor: { data: caseStatusData, valueField: 'caseStatus' },
	                        render: function (item)
	                        {
	                        	return getGridSelectedData(caseStatusData[parseInt(item.caseStatus)]);
	                        }  },
    	                { display: '接案社工', name: 'caseWorker', minWidth: 140 },
    	                { display: '結案社工', name: 'closeWorker', minWidth: 140 },
    	                { display: '備註', name: 'note', minWidth: 140 }
                    ] ;
            
            var gridToolBar = [
                               { text: '增加', click: ligerUiFn.itemClick, icon: 'add' , id:"add" },
                               { line: true },
                               { text: '修改', click: ligerUiFn.itemClick, icon: 'modify' , id:"modify" },
                               { line: true },
                               { text: '删除', click: ligerUiFn.itemClick, icon: 'delete' , id:"delete" }
                             ];
            maingrid = ligerGrid("maingrid",'99%',columns,"CustCase/listPojos.do",gridToolBar,true);
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
