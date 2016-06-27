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



    <script type="text/javascript" src="windows/keycode.js"></script>
	<script type="text/javascript" src="windows/jsUnitCore.js"></script>

	<script type="text/javascript">

	var gridMain,gridLeft;
	
	$(function(){
		 //var width = document.body.clientWidth*70/100;
         $("#layout1").ligerLayout({ leftWidth: 300});
         $("#navtabMain").ligerTab();
         $("#navtabDetail").ligerTab();
         
         gridLeft = $("#gridLeft").ligerGrid({
             columns: [
							 	{ display: '用戶編碼', name: 'userCode', align: 'left'	
							 		, width: '100' 
							 		}
							 	,
							 	{ display: '用戶名稱', name: 'userName', align: 'left'	
							 		, width: '150' 
							 		}
							 	,
							 	{ display: '停用', name: 'isStop', align: 'left'	
							 		, width: '150' 
							 			,editor:{ type: 'select' ,data: [{ id:'1',text:'是' },{ id:'0',text:'否' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'1',text:'是' },{ id:'0',text:'否' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.isStop){ return tmpdata[i].text } }  }
							 		}
							 	,
							 	{ display: '說明', name: 'note', align: 'left'	
							 		, width: '150' 
							 		}
             ],  
             pagesizeParmName :"page.pageSize",
             pageParmName  :"page.currentPage",
             dataAction : "server",
             statusName :"_status",
             enabledEdit: true,
             clickToEdit:false,
             usePager:true,
             fixedCellHeight:false,
             url:'User/loadMastersFromDB.do',
             width: '100%',height:'97%',
             onSelectRow : function(data,rowid,rowdata){
            	 
            	 
           	  	var currentMasterID = data['userId'];
           	  	loadDetail(currentMasterID);
           	  	
             },
             onSuccess : function(data, grid){
            	 
               	  if(data.Rows.length>0){
               		  var currentMasterID = data.Rows[0]['userId'];
               		  loadDetail(currentMasterID);
               	  }
           	  	
             }
         });
        
         
         
         
	});
	

		
	</script>
	<script type="text/javascript">

	function loadDetail(currentMasterId){
		 
		gridMain = $("#gridMain").ligerGrid({
            columns: [
					
							 	{ display: '模塊類型', name: 'funcType', align: 'left'	
							 		, width: '130' 
							 		 
							 			,editor:{ data:{Rows:[{"forder":5000,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"WJGL","funcName":"文件管理","funcType":"常用功能","isHide":0},{"forder":5050,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"XQBGL","funcName":"興趣班管理","funcType":"常用功能","isHide":0},{"forder":5070,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"FWXMGL","funcName":"服務項目管理","funcType":"常用功能","isHide":0},{"forder":200160,"funcBelong":"通用功能","funcBit":"00000000000000000000","funcId":"SJTB","funcName":"數據同步","funcType":"常用功能","isHide":0},{"forder":5080,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"HDGL","funcName":"活動管理","funcType":"常用功能","isHide":0},{"forder":8090,"funcBelong":"通用功能","funcBit":"00000000000010000000","funcId":"HYQD","funcName":"會員簽到","funcType":"常用功能","isHide":0},{"forder":30000,"funcBelong":"会员管理","funcBit":"11110111110000000000","funcId":"HYZLGL","funcName":"會員資料管理","funcType":"会员管理","isHide":0},{"forder":30002,"funcBelong":"会员管理","funcBit":"10000000000010000000","funcId":"HYZZ","funcName":"會員製證","funcType":"会员管理","isHide":0},{"forder":30003,"funcBelong":"会员管理","funcBit":"00000000000000000000","funcId":"GAGL","funcName":"個案管理","funcType":"会员管理","isHide":0},{"forder":200150,"funcBelong":"会员管理","funcBit":"00000000000000000000","funcId":"DXPT","funcName":"短信平臺","funcType":"会员管理","isHide":0},{"forder":100160,"funcBelong":"通用功能","funcBit":"11110000000000000000","funcId":"ZJGG","funcName":"組織機構","funcType":"基础资料","isHide":0},{"forder":100170,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"ZDBGL","funcName":"字典表管理","funcType":"基础资料","isHide":0},{"forder":200130,"funcBelong":"通用功能","funcBit":"10000111000000000000","funcId":"CZRZ","funcName":"操作日誌","funcType":"系统维护","isHide":0},{"forder":200030,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"YHJQXGL","funcName":"用户及权限管理","funcType":"系统维护","isHide":0}],Total:1}, valueColumnName: 'funcType'  , displayColumnName :'funcType' }, render:function (item){  var tmpData = {Rows:[{"forder":5000,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"WJGL","funcName":"文件管理","funcType":"常用功能","isHide":0},{"forder":5050,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"XQBGL","funcName":"興趣班管理","funcType":"常用功能","isHide":0},{"forder":5070,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"FWXMGL","funcName":"服務項目管理","funcType":"常用功能","isHide":0},{"forder":200160,"funcBelong":"通用功能","funcBit":"00000000000000000000","funcId":"SJTB","funcName":"數據同步","funcType":"常用功能","isHide":0},{"forder":5080,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"HDGL","funcName":"活動管理","funcType":"常用功能","isHide":0},{"forder":8090,"funcBelong":"通用功能","funcBit":"00000000000010000000","funcId":"HYQD","funcName":"會員簽到","funcType":"常用功能","isHide":0},{"forder":30000,"funcBelong":"会员管理","funcBit":"11110111110000000000","funcId":"HYZLGL","funcName":"會員資料管理","funcType":"会员管理","isHide":0},{"forder":30002,"funcBelong":"会员管理","funcBit":"10000000000010000000","funcId":"HYZZ","funcName":"會員製證","funcType":"会员管理","isHide":0},{"forder":30003,"funcBelong":"会员管理","funcBit":"00000000000000000000","funcId":"GAGL","funcName":"個案管理","funcType":"会员管理","isHide":0},{"forder":200150,"funcBelong":"会员管理","funcBit":"00000000000000000000","funcId":"DXPT","funcName":"短信平臺","funcType":"会员管理","isHide":0},{"forder":100160,"funcBelong":"通用功能","funcBit":"11110000000000000000","funcId":"ZJGG","funcName":"組織機構","funcType":"基础资料","isHide":0},{"forder":100170,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"ZDBGL","funcName":"字典表管理","funcType":"基础资料","isHide":0},{"forder":200130,"funcBelong":"通用功能","funcBit":"10000111000000000000","funcId":"CZRZ","funcName":"操作日誌","funcType":"系统维护","isHide":0},{"forder":200030,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"YHJQXGL","funcName":"用户及权限管理","funcType":"系统维护","isHide":0}],Total:1};  for(var i = 0;i<tmpData.Rows.length;i++){ if(item.funcType==tmpData.Rows[i].funcId){ return tmpData.Rows[i].funcType} }  }
							 		
							 		}
							 	,
								 
							 	{ display: '模塊名稱', name: 'funcName', align: 'left'	
							 		, width: '150' 
							 		 
							 			,editor:{ data:{Rows:[{"forder":5000,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"WJGL","funcName":"文件管理","funcType":"常用功能","isHide":0},{"forder":5050,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"XQBGL","funcName":"興趣班管理","funcType":"常用功能","isHide":0},{"forder":5070,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"FWXMGL","funcName":"服務項目管理","funcType":"常用功能","isHide":0},{"forder":200160,"funcBelong":"通用功能","funcBit":"00000000000000000000","funcId":"SJTB","funcName":"數據同步","funcType":"常用功能","isHide":0},{"forder":5080,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"HDGL","funcName":"活動管理","funcType":"常用功能","isHide":0},{"forder":8090,"funcBelong":"通用功能","funcBit":"00000000000010000000","funcId":"HYQD","funcName":"會員簽到","funcType":"常用功能","isHide":0},{"forder":30000,"funcBelong":"会员管理","funcBit":"11110111110000000000","funcId":"HYZLGL","funcName":"會員資料管理","funcType":"会员管理","isHide":0},{"forder":30002,"funcBelong":"会员管理","funcBit":"10000000000010000000","funcId":"HYZZ","funcName":"會員製證","funcType":"会员管理","isHide":0},{"forder":30003,"funcBelong":"会员管理","funcBit":"00000000000000000000","funcId":"GAGL","funcName":"個案管理","funcType":"会员管理","isHide":0},{"forder":200150,"funcBelong":"会员管理","funcBit":"00000000000000000000","funcId":"DXPT","funcName":"短信平臺","funcType":"会员管理","isHide":0},{"forder":100160,"funcBelong":"通用功能","funcBit":"11110000000000000000","funcId":"ZJGG","funcName":"組織機構","funcType":"基础资料","isHide":0},{"forder":100170,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"ZDBGL","funcName":"字典表管理","funcType":"基础资料","isHide":0},{"forder":200130,"funcBelong":"通用功能","funcBit":"10000111000000000000","funcId":"CZRZ","funcName":"操作日誌","funcType":"系统维护","isHide":0},{"forder":200030,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"YHJQXGL","funcName":"用户及权限管理","funcType":"系统维护","isHide":0}],Total:1}, valueColumnName: 'funcName'  , displayColumnName :'funcName' }, render:function (item){  var tmpData = {Rows:[{"forder":5000,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"WJGL","funcName":"文件管理","funcType":"常用功能","isHide":0},{"forder":5050,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"XQBGL","funcName":"興趣班管理","funcType":"常用功能","isHide":0},{"forder":5070,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"FWXMGL","funcName":"服務項目管理","funcType":"常用功能","isHide":0},{"forder":200160,"funcBelong":"通用功能","funcBit":"00000000000000000000","funcId":"SJTB","funcName":"數據同步","funcType":"常用功能","isHide":0},{"forder":5080,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"HDGL","funcName":"活動管理","funcType":"常用功能","isHide":0},{"forder":8090,"funcBelong":"通用功能","funcBit":"00000000000010000000","funcId":"HYQD","funcName":"會員簽到","funcType":"常用功能","isHide":0},{"forder":30000,"funcBelong":"会员管理","funcBit":"11110111110000000000","funcId":"HYZLGL","funcName":"會員資料管理","funcType":"会员管理","isHide":0},{"forder":30002,"funcBelong":"会员管理","funcBit":"10000000000010000000","funcId":"HYZZ","funcName":"會員製證","funcType":"会员管理","isHide":0},{"forder":30003,"funcBelong":"会员管理","funcBit":"00000000000000000000","funcId":"GAGL","funcName":"個案管理","funcType":"会员管理","isHide":0},{"forder":200150,"funcBelong":"会员管理","funcBit":"00000000000000000000","funcId":"DXPT","funcName":"短信平臺","funcType":"会员管理","isHide":0},{"forder":100160,"funcBelong":"通用功能","funcBit":"11110000000000000000","funcId":"ZJGG","funcName":"組織機構","funcType":"基础资料","isHide":0},{"forder":100170,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"ZDBGL","funcName":"字典表管理","funcType":"基础资料","isHide":0},{"forder":200130,"funcBelong":"通用功能","funcBit":"10000111000000000000","funcId":"CZRZ","funcName":"操作日誌","funcType":"系统维护","isHide":0},{"forder":200030,"funcBelong":"通用功能","funcBit":"11110111000000000000","funcId":"YHJQXGL","funcName":"用户及权限管理","funcType":"系统维护","isHide":0}],Total:1};  for(var i = 0;i<tmpData.Rows.length;i++){ if(item.funcName==tmpData.Rows[i].funcId){ return tmpData.Rows[i].funcName} }  }
							 		
							 		}
							 	,
								 
							 	{ display: '執行', name: 'fexecute', align: 'left'	
							 		, width: '70' 
							 		 
							 			,editor:{ type: 'select' ,data: [{ id:'1',text:'有' },{ id:'0',text:'無' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'1',text:'有' },{ id:'0',text:'無' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.fexecute){ return tmpdata[i].text } }  }
							 		
							 		}
							 	,
								 
							 	{ display: '瀏覽', name: 'fview', align: 'left'	
							 		, width: '70' 
							 		 
							 			,editor:{ type: 'select' ,data: [{ id:'1',text:'有' },{ id:'0',text:'無' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'1',text:'有' },{ id:'0',text:'無' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.fview){ return tmpdata[i].text } }  }
							 		
							 		}
							 	,
								 
							 	{ display: '增加', name: 'fadd', align: 'left'	
							 		, width: '70' 
							 		 
							 			,editor:{ type: 'select' ,data: [{ id:'1',text:'有' },{ id:'0',text:'無' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'1',text:'有' },{ id:'0',text:'無' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.fadd){ return tmpdata[i].text } }  }
							 		
							 		}
							 	,
								 
							 	{ display: '編輯', name: 'fmodify', align: 'left'	
							 		, width: '70' 
							 		 
							 			,editor:{ type: 'select' ,data: [{ id:'1',text:'有' },{ id:'0',text:'無' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'1',text:'有' },{ id:'0',text:'無' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.fmodify){ return tmpdata[i].text } }  }
							 		
							 		}
							 	,
								 
							 	{ display: '刪除', name: 'fdelete', align: 'left'	
							 		, width: '70' 
							 		 
							 			,editor:{ type: 'select' ,data: [{ id:'1',text:'有' },{ id:'0',text:'無' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'1',text:'有' },{ id:'0',text:'無' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.fdelete){ return tmpdata[i].text } }  }
							 		
							 		}
							 	,
								 
							 	{ display: '列印', name: 'fprint', align: 'left'	
							 		, width: '70' 
							 		 
							 			,editor:{ type: 'select' ,data: [{ id:'1',text:'有' },{ id:'0',text:'無' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'1',text:'有' },{ id:'0',text:'無' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.fprint){ return tmpdata[i].text } }  }
							 		
							 		}
							 	,
								 
							 	{ display: '報表設計', name: 'fdesignReport', align: 'left'	
							 		, width: '70' 
							 		 
							 			,editor:{ type: 'select' ,data: [{ id:'1',text:'有' },{ id:'0',text:'無' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'1',text:'有' },{ id:'0',text:'無' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.fdesignReport){ return tmpdata[i].text } }  }
							 		
							 		}
							 	,
								 
							 	{ display: '導出', name: 'fexportData', align: 'left'	
							 		, width: '70' 
							 		 
							 			,editor:{ type: 'select' ,data: [{ id:'1',text:'有' },{ id:'0',text:'無' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'1',text:'有' },{ id:'0',text:'無' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.fexportData){ return tmpdata[i].text } }  }
							 		
							 		}
							 	,
								 
							 	{ display: '審覈', name: 'fcheck', align: 'left'	
							 		, width: '70' 
							 		 
							 			,editor:{ type: 'select' ,data: [{ id:'1',text:'有' },{ id:'0',text:'無' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'1',text:'有' },{ id:'0',text:'無' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.fcheck){ return tmpdata[i].text } }  }
							 		
							 		}
							 	,
								 
							 	{ display: '反審覈', name: 'funCheck', align: 'left'	
							 		, width: '70' 
							 		 
							 			,editor:{ type: 'select' ,data: [{ id:'1',text:'有' },{ id:'0',text:'無' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'1',text:'有' },{ id:'0',text:'無' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.funCheck){ return tmpdata[i].text } }  }
							 		
							 		}
							 	
								 
					
					
            ],  
            pagesizeParmName :"page.pageSize",
            pageParmName  :"page.currentPage",
            enabledEdit: true,
            clickToEdit:false,
            fixedCellHeight:false,
            statusName :"_status",
            dataAction : "server",
            url : 'User/loadDetailsFromDB.do',
            parms : {"currentMasterid" :currentMasterId},
            usePager:false,
            width: '100%',height:'96%'
            
        });
		
	}
	
	</script>
	
	<script type="text/javascript">

	  function addByfrmMDIChild_DB(){
			
			
			$.ligerDialog.open({ url: 'User/showSingle.do?addOrEdit=0&editForeignKey='+editForeignKey+"&actType="+null,
				title:"操作員管理",
				data : { editPrimaryKey : "" , editForeignKey : ""},
				height: '450', width: '500', buttons: [
		    { text: '返回', onclick: function (item, dialog) {dialog.close();gridLeft.reload(); },cls:'l-dialog-btn-highlight' }
		 ], isResize: true,onClosed:function(){
			 gridLeft.reload();
		 }
		});
			
		}
	  
	  
	  function editByfrmMDIChild_DB(){
			var row = gridLeft.getSelectedRow();
			if(row==null){
				alert("请选择一行记录");
				return;
			}
			
			var editPrimaryKey = row.userId;
			
			
			$.ligerDialog.open({ url: 'User/showSingle.do?addOrEdit=1&editPrimaryKey='+editPrimaryKey+"&actType="+null,
					title:"操作員管理",
					data : { editPrimaryKey : editPrimaryKey },
					height: '450', width: '500', buttons: [
			    { text: '返回', onclick: function (item, dialog) {dialog.close();gridLeft.reload(); },cls:'l-dialog-btn-highlight' }
			 ], isResize: true,onClosed:function(){
				 gridLeft.reload();
			 }
			});
		}
	
	</script>
	
	
	<script>

	function deleteRow()
    {
		$.ligerDialog.confirm('确定删除?', function (yes) {
			if(yes){
		      	var row = gridLeft.getSelectedRow();
	        	
	        	$.ajax({
					   type: "POST",
					   url: 'User/deleteMasterRowByfrmMDIChild_DB.do',
					   data: 'userId='+row.userId,
					   dataType:"json", 
					   success: function(msg){
						  
						   if(msg == true || msg == 'true'){
						   		gridLeft.deleteRow(row);
						   }else{
							   alert("刪除失敗！");
						   }
					   	   
					   },
						error : function(XMLHttpRequest, textStatus, errorThrown) {
							alert("服务器获取数据失败："+errorThrown);
							
						}
					});
			}

		});
    }

	</script>
	<script type="text/javascript">

	function editUserRights(){
		var row = gridLeft.getSelectedRow();
		if(row==null){
			alert("請選擇需要修改權限的操作員！");
			return;
		}
		
		gridMain.set("clickToEdit",true);
		
	}
	
	function saveUserRights(){
		var row = gridLeft.getSelectedRow();
		var editPrimaryKey = row.userId;
		
		gridMain.endEdit();
		
		var updatedRows = gridMain.getUpdated();
		
		$.ajax({
			type:"POST",
			url:"User/saveUserRights.do",
			data:{"updatedRows":JSON.stringify(updatedRows)},
			dataType:"json",
			async:false,
			success : function(msg){
				alert(msg)
			},
		  error : function(XMLHttpRequest, textStatus, errorThrown) {
			  
			  alert("服务器获取数据失败："+errorThrown);
				
			}
		});
		
	}

	</script>

  </head>
  
  <body>
    <div id='Users_ShowList_toptoolbar'></div>
    <div id="layout1">
		<div position="left" title="主表数据">
			<div id="navtabMain" style="width: 100%;height:98%; overflow:hidden; border:1px solid #A3C0E8; ">
			<div tabid="home" title="数据列表" lselected="true"   > <!-- showClose="true" -->
				
					<div id="gridLeft" style="margin:0; padding:0" disabled="disabled"></div>
				
			</div>
			</div>
		
		</div>
		<div position="center" title="會員列表">
            	<div id="navtabDetail" style="width: 100%;height:100%; overflow:hidden; border:1px solid #A3C0E8; ">
				<div tabid="home" title="数据列表" lselected="true"   > <!-- showClose="true" -->
          			<div id="gridMain" style="margin:0; padding:0"></div>
          		</div>
          		</div>
            </div>  
	</div>
    
  </body>
</html>
