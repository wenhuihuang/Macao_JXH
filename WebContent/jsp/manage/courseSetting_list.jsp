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
        	location.href = "CourseSetting/add.do?";
        }
        
        function modifyRow(){
        	var courseID = getRowCell(maingrid,"courseID");
        	if(courseID!="" && courseID!=null){
	        	location.href = "CourseSetting/edit.do?courseID="+courseID;        		
        	}
        }
        function deleteRow(){
        	var courseID = getRowCell(maingrid,"courseID");
      		if(confirm("是否刪除？")){
     			$.ajax({
         			type:"post",
         			url:"CourseSetting/deleteCourse.do",
         			data:"courseID="+courseID,
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
        	setTabTitle(parent.$("#framecenter"),"課程設置列表") 
        	
        	
            var columns = [
    	                { display: '課程編號', name: 'courseNO', minWidth: 100 },
    	                { display: '課程名稱', name: 'courseName', minWidth: 140 },
    	                { display: '開始日期', name: 'beginDate', minWidth: 140 },
    	                { display: '結束日期', name: 'endDate', minWidth: 140 },
    	                { display: '上課時間', name: 'courseDate', minWidth: 140 },
    	                { display: '上課地點', name: 'place', minWidth: 140 },
    	                { display: '上課導師', name: 'leader', minWidth: 140 },
    	                { display: '上課助教', name: 'assistant', minWidth: 140 },
    	                { display: '學費(MOP)', name: 'pay', minWidth: 140 },
    	                { display: '名額', name: 'qty', minWidth: 140 },
    	                { display: '課時', name: 'classHour', minWidth: 140 },
    	                { display: '課程簡介', name: 'classNote', minWidth: 140 },
    	                { display: '備註', name: 'note', minWidth: 140 },
                    ] ;
            
            var gridToolBar = [
                               { text: '增加', click: itemclick, icon: 'add' , id:"add" },
                               { line: true },
                               { text: '修改', click: itemclick, icon: 'modify' , id:"modify" },
                               { line: true },
                               { text: '删除', click: itemclick, icon: 'delete' , id:"delete" }
                             ];
            maingrid = ligerGrid("maingrid",'99%',columns,"CourseSetting/list.do?",gridToolBar,false,true);
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