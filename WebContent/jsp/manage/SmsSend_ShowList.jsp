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
<script type="text/javascript" src="windows/toptoolbar.js"></script>
<script type="text/javascript" src="windows/keycode.js"></script>
<script type="text/javascript" src="windows/jsUnitCore.js"></script>
<title>信息平臺</title>
<script type="text/javascript">

	 var gridMain; 
	var gridLeft ;
	


	  
 $(function ()
 {
	  var width = document.body.clientWidth*70/100;
	  var makeUserData;
     $("#layout1").ligerLayout({ leftWidth: width});
     $("#navtabMain").ligerTab();
     $("#navtabDetail").ligerTab();
     $.ajax({
    	 type:'POST',
    	 url:'SmsSendServlet/getAllUsers.do',
    	 async:false,
    	 success:function(data){
    		 makeUserData=data;
    	 },
    	 error:function(){
    		 $.ligerDialog.error('網絡出錯了！');

    	 }
    	 
     })
   
   gridLeft = $("#gridLeft").ligerGrid({
         columns: [
				
						 	{ display: '狀態', name: 'state', align: 'left'	
						 		, width: '70' 
						 		 
						 			,editor:{ type: 'select' ,data: [{ id:'2',text:'發送成功' },{ id:'1',text:'正在發送中' },{ id:'0',text:'待發送' },{ id:'9',text:'發送失敗' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'2',text:'發送成功' },{ id:'1',text:'正在發送中' },{ id:'0',text:'待發送' },{ id:'9',text:'發送失敗' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.state){ return tmpdata[i].text } }  }
						 		
						 		}
						 		,
						 
						 	{ display: '編寫日期', name: 'billDate_str', align: 'left'	
						 		, width: '120' 
						 		
						 		}
						 		,
						 
						 	{ display: '發送人', name: 'makeUserID', align: 'left'	
						 		, width: '70' 
						 		 
						 			,editor:{ type: 'select' ,data:JSON.parse(makeUserData), valueColumnName: 'makeUserID'  , displayColumnName :'userName' }, render:function (item){  var tmpData = JSON.parse(makeUserData);  for(var i = 0;i<tmpData.Rows.length;i++){ if(item.makeUserID==tmpData.Rows[i].userId){ return tmpData.Rows[i].userName} }  }
						 		
						 		}
						 		,
						 
						 	{ display: '接收人數', name: 'peopleCount', align: 'left'	
						 		, width: '50' 
						 		
						 		}
						 		,
						 
						 	{ display: '短信內容', name: 'sms', align: 'left'	
						 		, width: '300' 
						 		
						 		}
						 		
						 
				
				
				
         ],  
         pagesizeParmName :"page.pageSize",
         pageParmName  :"page.currentPage",
         dataAction : "server",
         statusName :"_status",
         enabledEdit: true,
         clickToEdit:false,
         fixedCellHeight:false,
         pageSize:30,
         usePager:true,
         url:'SmsSendServlet/getGridMastersFromUrl.do?actType=null',
         width: '100%',height:'100%',
         onSelectRow : function(data,rowid,rowdata){
       	  var currentMasterID = data['billMasterID'];
       	  loadDetail(currentMasterID);
       	  
       	  
         },
         onSuccess : function(data, grid){
       	  if(data.Rows.length>0){
       		  var currentMasterID = data.Rows[0]['billMasterId'];
       		  loadDetail(currentMasterID);
       	  }
         }
     });
     

     $("#pageloading").hide();
     
 });
 
 
 
 
 function loadDetail(currentMasterID){
	  
	  gridMain = $("#gridMain").ligerGrid({
         columns: [
				
						 	{ display: '狀態', name: 'state', align: 'left'	
						 		, width: '70' 
						 		 
						 			,editor:{ type: 'select' ,data: [{ id:'3',text:'發送成功' },{ id:'2',text:'等待發送報告' },{ id:'1',text:'正在發送中' },{ id:'0',text:'待發送' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'3',text:'發送成功' },{ id:'2',text:'等待發送報告' },{ id:'1',text:'正在發送中' },{ id:'0',text:'待發送' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.state){ return tmpdata[i].text } }  }
						 		
						 		}
						 		,
						 
						 	{ display: '用戶名稱', name: 'telName', align: 'left'	
						 		, width: '120' 
						 		
						 		}
						 		,
						 
						 	{ display: '手機號碼', name: 'telNO', align: 'left'	
						 		, width: '150' 
						 		
						 		}
						 		,
						 
						 	{ display: '發送時間', name: 'sendDateTime_str', align: 'left'	
						 		, width: '150' 
						 		
						 		}
						 		,
						 
				
				
         ],  
         checkbox:true,
         pagesizeParmName :"page.pageSize",
         pageParmName  :"page.currentPage",
         enabledEdit: true,
         clickToEdit:false,
         fixedCellHeight:false,
         pageSize:30,
         statusName :"_status",
         dataAction : "server",
         url : 'SmsSendServlet/getGridDetailsFromUrl.do',
         parms : {"currentMasterid" :currentMasterID},
         usePager:true,
         width: '100%',height:'100%'
     });
 }
 

</script>
<script type="text/javascript">


function addByfrmMDIChild_DB(){
		
		
		$.ligerDialog.open({ url: 'SmsSendServlet/showSingle.do?addOrEdit=0&editPrimaryKey='+editForeignKey,
			title:"編輯短信",
			data : { editPrimaryKey : "" , editForeignKey : ""},
			height: '700', width: '1024', buttons: [
	    { text: '返回', onclick: function (item, dialog) {dialog.close();gridLeft.reload(); },cls:'l-dialog-btn-highlight' }
	 ], isResize: true
	});
		
	}
	
	
	
	function editByfrmMDIChild_DB(){
		var row = gridLeft.getSelectedRow();
		if(row==null){
			alert("請選擇一條短信");
			return;
		}
		var editPrimaryKey = row.billMasterID;
		
		if(row.state=="2"){
			alert("該條短信已經發送成功了，不能進行修改！");
			return;
		}
		
		
		
		$.ligerDialog.open({ url: 'SmsSendServlet/showSingle.do?addOrEdit=1&editPrimaryKey='+editPrimaryKey, 
				title:"編輯短信",
				data : { editPrimaryKey : editPrimaryKey },
				height: '700', width: '1024', buttons: [
		    { text: '返回', onclick: function (item, dialog) {dialog.close();gridLeft.reload(); },cls:'l-dialog-btn-highlight' }
		 ], isResize: true
		});
	}
	
	
	function deleteMasterRow(){
		var row = gridLeft.getSelectedRow();
		if(row==null){
			alert("請選擇需要刪除的短信！");
			return;
		}
		$.ligerDialog.confirm('确定删除?',function(yes){
			   
					$.ajax({
						   type: "POST",
						   url: 'SmsSendServlet/deleteMasterRowById.do',
						   data: row,
						   dataType:"json", 
						   success: function(msg){
						   		if(msg || msg == 'true'){
						   			gridLeft.deleteRow(row.__id);
						   		}else{
						   			alert("刪除失敗！")
						   		}
						   },
							error : function(XMLHttpRequest, textStatus, errorThrown) {
								alert("服务器获取数据失败："+errorThrown);
								
							}
						});
		     
		})
  
	}
	
	function deleteDetailRow(){
		var masterRow = gridLeft.getSelectedRow();
		if(masterRow==null){
			alert("請選擇一條短信");
			return;
		}
		if(masterRow.state=="2"){
			alert("該條短信已經發送成功了，不能進行修改！");
			return;
		}
		
		
		
		var rows = gridMain.getSelectedRows();
		if(rows==null||rows==""||rows.length<=0){
			alert("請選擇需要刪除的會員！");
			return;
		}
		
		
		
		for(var i = 0;i<rows.length;i++){
			var row = rows[i];
	  		$.ajax({
	  			type:"POST",
	  			url:"SmsSendServlet/deleteDetailById.do",
	  			data:"billDetailID="+row.billDetailID,
	  			//dataType:"json",
	  			async:false,
	  			success:function(data){
	  				if(data){
	  					gridMain.deleteRow(row.__id);
	  				}else{
	  					
	  				}
	  			},
	  			error:function(){
	  				alert("網絡出錯了！")
	  			}
	  			
	  		});
		}
		
	}
	


</script>
<script type="text/javascript">

	function sendSelectMessage(){
		var row = gridLeft.getSelectedRow();
		if(row==null){
			alert("請選擇需要發送的短信！");
			return;
		}
		var message = $.ligerDialog.waitting('正在發送,请稍候...');

	$.ajax({
		type:"POST",
		url:"SmsSendServlet/sendSelectedMessages.do",
		data:{"editPrimaryKey":row.billMasterID},
		/* dataType:"json", */
		asnyc:false,
		success:function(data){
			if(data.indexOf("成功") > 0 ){
				message.close();
				$.ligerDialog.success(data);
				gridLeft.reload();
			}else{
				$.ligerDialog.error(data);
			}
			
		},
		error:function(msg){
			$.ligerDialog.error("網絡出錯！")
		}
	});
		
	}
	function cancelSelectMessage(){
		var row = cancelSelectMessage();
		if(row==null){
			alert("請選擇需要取消發送的短信！");
			return;
		}


		$.ajax({
		type:"POST",
		url:"SmsSendServlet/cancelSendSelectedMessages.do",
		data:{"editPrimaryKey":row.billMasterId},
		dataType:"json",
		asnyc:false,
		success:function(data){
			
		}
	});
	}
	
	function count(){
		alert("暂未开放");
		
	}
	

</script>
</head>
<body>
  	<div id='SmsSend_ShowList_toptoolbar'></div>
      <div id="layout1">
            <div position="left" title="主表数据">
            	<div id="navtabMain" style="width: 100%;height:100%; overflow:hidden; border:1px solid #A3C0E8; ">
				<div tabid="home" title="数据列表" lselected="true"   > <!-- showClose="true" -->
					<div id="gridLeft" style="margin:0; padding:0"></div>
				</div>
				</div>
            </div>
            <div position="center" title="明细表数据">
            	<div id="navtabDetail" style="width: 100%;height:100%; overflow:hidden; border:1px solid #A3C0E8; ">
				<div tabid="home" title="数据列表" lselected="true"   > <!-- showClose="true" -->
          			<div id="gridMain" style="margin:0; padding:0"></div>
          		</div>
          		</div>
            </div>  
        </div> 
  </body>
</html>