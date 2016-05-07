<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'frmMDIChild_DB_MultiEdit.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">



<link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"
	type="text/css" />
<script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/core/base.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerLayout.js" type="text/javascript"></script>
<link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
<script src="lib/ligerUI/js/plugins/ligerMenu.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerMenuBar.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerToolBar.js" type="text/javascript"></script>
<script type="text/javascript" src="windows/toptoolbar.js"></script>
<script src="lib/ligerUI/js/plugins/ligerTab.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerPanel.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerPortal.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script>
<script src="windows/CustomersData.js" type="text/javascript"></script>

<script src="lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerDateEditor.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerSpinner.js" type="text/javascript"></script>

<script>


	var gridMain; 
	var gridLeft ;
   	<%
			String actionName = (String)request.getAttribute("actionName");
			actionName = actionName==null?"":actionName;
			Class masterVOClass = (Class)request.getAttribute("masterVO");
			String masterVO = masterVOClass==null?"":masterVOClass.getName();
			String masterPrimaryKey =  (String)request.getAttribute("masterPrimaryKey");
			masterPrimaryKey = masterPrimaryKey ==null?"":masterPrimaryKey;
			List<Class> detailVOClass = (List<Class>)request.getAttribute("detailVOs");
			List<String> detailPrimaryKeys = (List<String>)request.getAttribute("detailPrimaryKeys");
	%>


	$(function() {

			$("#layout1").ligerLayout({
				leftWidth : 300
			});
			$("#navtabMain").ligerTab({
				showSwitch:true
			});
			$("#navtabDetail").ligerTab();
			
			$("#portalMain").ligerPortal({
	            columns: [{
	                width: "100%",
	                panels: [{
	                    title: '主表数据',
	                    width: '100%',
	                    height: "100%",
	                    content: '内容。。。<br>内容。。。'
	                }]
	            }]
	        }); 
		
		
		
			gridLeft = $("#gridLeft").ligerGrid({
			columns: [
						<%
							 Map<String,String> masterTitles =  (HashMap<String,String>)request.getAttribute("masterTitles");
							if(masterTitles!=null&&masterTitles.size()>0){
								 for(Map.Entry<String,String> map:masterTitles.entrySet()){
									 String name = map.getKey();
									 String display = map.getValue().split("&")[0];
									 String width = map.getValue().split("&")[1];
									 
									 %>
									 	{ display: '<%=display %>', name: '<%=name %>', align: 'left', width: <%=width %>,type:"text",editor: { type: 'text'} },
									 <%
								 }
								 }
							%>
							
							{ display: '操作', isSort: false, width: 120, render: function (rowdata, rowindex, value)
	                          {
	                    	  
	                    	  	
	                              var h = "";
	                              if (!rowdata._editing)
	                              {
	                                  h += "<a class='l-button' style='width:40px;float:left; margin-left:10px;' href='javascript:beginLeftEdit(" + rowindex + ")'>修改</a> ";
	                                  h += "<a class='l-button' style='width:40px;float:left; margin-left:10px;' href='javascript:deleteLeftRow(" + rowindex + ")'>删除</a> "; 
	                              }
	                              else
	                              {
	                                  h += "<a class='l-button' style='width:40px;float:left; margin-left:10px;' href='javascript:endLeftEdit(" + rowindex + ")'>提交</a> ";
	                                  h += "<a class='l-button' style='width:40px;float:left; margin-left:10px;' href='javascript:cancelLeftEdit(" + rowindex + ")'>取消</a> "; 
	                              }
	                              return h;
	                          }
	                       }
	            ],  
	            pagesizeParmName :"page.pageSize",
	            pageParmName  :"page.currentPage",
	            dataAction : "server",
                statusName :"_status",
                enabledEdit: true,
                clickToEdit:false,
	            usePager:true,
	            url:'<%=actionName+"getGridMastersFromUrl" %>',
	            width: '100%',height:'98%',
	            onSelectRow : function(data,rowid,rowdata){
	          	  var currentMasterID = data.id;
	          	  loadDetail(currentMasterID);
	          	  
	          	  
	            },
	            onSuccess : function(data, grid){
	          	  if(data.Rows.length>0){
	          		  var currentMasterID = data.Rows[0].id;
	          		  
	          		  loadDetail(currentMasterID);
	          	  }
	            }
	        });
			
			
			$("#pageloading").hide();
			
		});
	
	
	
		function loadDetail(currentMasterID){
	  	  
	  	  gridMain = $("#gridMain").ligerGrid({
	            columns: [
						<%
						Map<String,String> detailTitles =  (HashMap<String,String>)request.getAttribute("detailTitles");
						if(detailTitles!=null&&detailTitles.size()>0){
							 for(Map.Entry<String,String> map:detailTitles.entrySet()){
								 String name = map.getKey();
								 String display = map.getValue().split("&")[0];
								 String width = map.getValue().split("&")[1];
								 
								 %>
								 	{ display: '<%=display %>', name: '<%=name %>', align: 'left', width: <%=width %>,type:"text",editor: { type: 'text'}},
								 <%
							 }
							 }
						%>
						
						{ display: '操作', isSort: false, width: 120, render: function (rowdata, rowindex, value)
	                          {
	                    	  
	                    	  	
	                              var h = "";
	                              if (!rowdata._editing)
	                              {
	                                  h += "<a class='l-button' style='width:40px;float:left; margin-left:10px;' href='javascript:beginDetailEdit(" + rowindex + ")'>修改</a> ";
	                                  h += "<a class='l-button' style='width:40px;float:left; margin-left:10px;' href='javascript:deleteDetailRow(" + rowindex + ")'>删除</a> "; 
	                              }
	                              else
	                              {
	                                  h += "<a class='l-button' style='width:40px;float:left; margin-left:10px;' href='javascript:endDetailEdit(" + rowindex + ")'>提交</a> ";
	                                  h += "<a class='l-button' style='width:40px;float:left; margin-left:10px;' href='javascript:cancelDetailEdit(" + rowindex + ")'>取消</a> "; 
	                              }
	                              return h;
	                          }
	                       }
	            ],  
	            pagesizeParmName :"page.pageSize",
	            pageParmName  :"page.currentPage",
	            dataAction : "server",
                statusName :"_status",
                enabledEdit: true,
                clickToEdit:false,
	            url : '<%=actionName+"getGridDetailsFromUrl" %>',
	            parms : {"currentMasterid" :currentMasterID},
	            usePager:true,
	            width: '100%',height:'97%'
	        });
    	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//开始修改（主表）
        function beginLeftEdit(rowid) { 
      	  
      	  gridLeft.beginEdit(rowid);
        }
        //取消修改（主表）
        function cancelLeftEdit(rowid) { 
      	  gridLeft.cancelEdit(rowid);
        }
        //增加一行（主表）
        function addByfrmMDIChild_DB(){
      	  $.ajax({
        		type : "POST",
        		url : '<%=actionName+"addMasterRowByfrmMDIChild_DB" %>',
        		dataType:"json",
        		success: function(msg){
        			var rowdata = msg;
        			gridLeft.addEditRow(rowdata) ;
			   },
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("服务器获取数据失败："+errorThrown);
					
				}
        	});
        };
        //修改完成 （主表）
        function endLeftEdit(rowid)
        {
            
      	  gridLeft.endEdit(rowid);
            var row = gridLeft.getSelectedRow();
            
            if (!row) {
            	//alert('请选择行'); 
            	return;
            }else{
            	
            	$.ajax({
  				   type: "POST",
  				   url: '<%=actionName+"addOrEditMasterRowByfrmMDIChild_DB?masterVO="+masterVO+"&masterPrimaryKey="+masterPrimaryKey %>',
  				   data: row,
  				   dataType:"json", 
  				   success: function(msg){
  				   		
  					   alert(msg.title);
  				   		
  				   		if(row._status=="add"){
  				   			//将状态设置为nochanged  防止再次添加
  				   			row._status = "nochanged";
  				   			gridLeft.endEdit(rowid);
  				   		}
  				   		
  				   		
  				   },
  					error : function(XMLHttpRequest, textStatus, errorThrown) {
  						alert("服务器获取数据失败："+errorThrown);
  						
  					}
  				});
            }
        }
        //删除主表行记录
        function deleteLeftRow(rowid){
      	  
      	  if (confirm('确定删除?'))
            {
            	var row = gridLeft.getSelectedRow();
            	
            	$.ajax({
 				   type: "POST",
 				   url: '<%=actionName+"deleteMasterRowByfrmMDIChild_DB?masterPrimaryKey="+masterPrimaryKey %>',
 				   data : row,
 				   dataType:"json", 
 				   success: function(msg){
 				   		
 						gridLeft.deleteRow(rowid);
 				   		alert(msg.title);
 				   },
 					error : function(XMLHttpRequest, textStatus, errorThrown) {
 						alert("服务器获取数据失败："+errorThrown);
 						
 					}
 				});
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //开始修改（从表）
        function beginDetailEdit(rowid) { 
      	  
      	  gridMain.beginEdit(rowid);
        }
        //取消修改（从表）
        function cancelDetailEdit(rowid) { 
      	  gridMain.cancelEdit(rowid);
        }
        //增加一行（从表）
        function addByfrmMDIChild_DB_Detail(){
			 
      	  var masterRow = gridLeft.getSelectedRow();
      	  if(masterRow==null){
      		  alert("请选择主表行！");
      		  return;
      	  }
      	  var currentMasterid = masterRow['<%=masterPrimaryKey%>'];
      	  
         	  $.ajax({
             		type : "POST",
             		url : '<%=actionName+"addDetailRowByfrmMDIChild_DB" %>',
             		dataType:"json",
             		data:{"currentMasterid":currentMasterid },
             		success: function(msg){
             			
             			var rowdata = null;
             			if(msg!=null){
             				rowdata = msg[0];	
             			}
             			gridMain.addEditRow(rowdata) ;
     			   },
     				error : function(XMLHttpRequest, textStatus, errorThrown) {
     					alert("服务器获取数据失败："+errorThrown);
     					
     				}
             	});
        }
		  //删除一行从表
        function deleteDetailRow(rowid){
      	  
      	  if (confirm('确定删除?'))
            {
      		  var row = gridMain.getSelectedRow();
              	
              	$.ajax({
   				   type: "POST",
   				   url: '<%=actionName+"deleteDetailRowByfrmMDIChild_DB?detailIndex=0&detailPrimaryKey="+detailPrimaryKeys.get(0) %>',
   				   data : row,
   				   dataType:"json", 
   				   success: function(msg){
   					   
   					  	gridMain.deleteRow(rowid);
   				   		alert(msg.title);
   				   },
   					error : function(XMLHttpRequest, textStatus, errorThrown) {
   						alert("服务器获取数据失败："+errorThrown);
   						
   					}
   				});
            }
        }
        
		  //修改完成 （从表）
        function endDetailEdit(rowid)
        {
			  
            
      	  gridMain.endEdit(rowid);
      	  
            var row = gridMain.getSelectedRow();
            
            if (!row) {
            	//alert('请选择行'); 
            	return;
            }else{
          	  
          	  
         	  var masterRow = gridLeft.getSelectedRow();
         	  if(masterRow==null){
         		  alert("请选择主表行！");
         		  return;
         	  }
         	  var currentMasterid = masterRow['<%=masterPrimaryKey%>'];
          	  
         	  
         	  
         	  
            	$.ajax({
  				   type: "POST",
  				   url: '<%=actionName+"editDetailRowByfrmMDIChild_DB?detailIndex=0&&detailVO="+detailVOClass.get(0).getName()+"&&detailPrimaryKey="+detailPrimaryKeys.get(0) %>',
  				   data: row,
  				   dataType:"json", 
  				   success: function(msg){
  				   		
  					   alert(msg.title);
  				   		
  				   		if(row._status=="add"){
  				   			//将状态设置为nochanged  防止再次添加
  				   			row._status = "nochanged";
  				   			gridMain.endEdit(rowid);
  				   		}
  				   		
  				   		
  				   },
  					error : function(XMLHttpRequest, textStatus, errorThrown) {
  						alert("服务器获取数据失败："+errorThrown);
  						
  					}
  				});
            }
        }
</script>



</head>

<body>
	<div id="frmMDIChild_DB_toptoolbar"></div>
	<div id="layout1">
		<div position="left" title="主表数据">
			<div id="navtabMain" style="width: 100%;height:100%; overflow:hidden; border:1px solid #A3C0E8; ">
			<div tabid="home" title="数据列表" lselected="true"   > <!-- showClose="true" -->
				<div id="gridLeft" style="margin:0; padding:0"></div>
			</div>
			</div>
		</div>
		<div position="center" title="明细表数据">
		 	<div style="width:100%; margin-bottom: -15px;" id="portalMain">
		 		 
       	 	</div> 
			<div id="navtabDetail" style="width: 100%;overflow:hidden; border:1px solid #A3C0E8; ">
				<div tabid="home" title="数据列表" lselected="true"   > <!-- showClose="true" -->
					<div id="gridMain" style="margin:0; padding:0"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
