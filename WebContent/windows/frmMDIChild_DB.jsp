<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.lang.reflect.Field"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
    
  <head>
	<base href="<%=basePath%>">
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<title></title>
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script> 
    <script src="lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerMenu.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerMenuBar.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerToolBar.js" type="text/javascript"></script>
    <script type="text/javascript" src="windows/toptoolbar.js"></script>
	<script src="lib/ligerUI/js/plugins/ligerTab.js" type="text/javascript"></script>
	<script src="lib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
	<script src="lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script> 
	<script src="lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerDateEditor.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerSpinner.js" type="text/javascript"></script>
	
	
    <script src="windows/CustomersData.js" type="text/javascript"></script>
    
    
    <script type="text/javascript">
    
        var menu1 = { width: 120, items:
            [
            { text: '保存', click: itemclick },
            { text: '列存为', click: itemclick },
            { line: true },
            { text: '关闭', click: itemclick }
            ]
        };

        var menu2 = { width: 120, items:
            [
            {
                text: '文件', children:
                [
                    { text: 'Excel', click: itemclick },
                    { text: 'Word', click: itemclick },
                    { text: 'PDF', click: itemclick },
                    { text: 'TXT', click: itemclick },
                    { line: true },
                    { text: 'XML', click: itemclick }
                ]
            },
            ]
        };
        
       
    </script>
   
    
     <script type="text/javascript">
     
	     <%
		 	String actionName = (String)request.getAttribute("actionName");
			actionName = actionName==null?"":actionName;
			Class masterVOClass = (Class)request.getAttribute("masterVO");
			String masterVO = masterVOClass==null?"":masterVOClass.getName();
			String masterPrimaryKey =  (String)request.getAttribute("masterPrimaryKey");
			masterPrimaryKey = masterPrimaryKey ==null?"":masterPrimaryKey;
		 %>
     
        var grid = null;
        var manager;
        $(function () {
        	
        	$("#navtabMain").ligerTab();
        	
            grid = manager = $("#grid").ligerGrid({
                columns: [
                          
                      <%
                     	 Map<String,String> titles =  (HashMap<String,String>)request.getAttribute("masterTitles");
						 if(titles!=null&&titles.size()>0){
							 for(Map.Entry<String,String> map:titles.entrySet()){
								 String name = map.getKey();
								 String display = map.getValue().split("&")[0];
								 String width = map.getValue().split("&")[1];
								 String othersFunction = "";
								 if(map.getValue().split("&").length>2){
									 othersFunction = map.getValue().split("&")[2];
								 }
								 %>
								 
								 	{ display: '<%=display %>', name: '<%=name %>'
								 	<% if(!"".equals(width)&&!"0".equals(width)){%>, width: '<%=width %>' <% } %>
							 		<% if(!"".equals(othersFunction)){%> <%=othersFunction%><%}%> },
								 <%
							 }
                      	 }
                      %>
                      
                      { display: '操作', isSort: false, width: 120, render: function (rowdata, rowindex, value)
                          {
                    	  
                    	  	
                              var h = "";
                              if (!rowdata._editing)
                              {
                                  h += "<a class='l-button' style='width:40px;float:left; margin-left:10px;' href='javascript:beginEdit(" + rowindex + ")'>修改</a> ";
                                  h += "<a class='l-button' style='width:40px;float:left; margin-left:10px;' href='javascript:deleteRow(" + rowindex + ")'>删除</a> "; 
                              }
                              else
                              {
                                  h += "<a class='l-button' style='width:40px;float:left; margin-left:10px;' href='javascript:endEdit(" + rowindex + ")'>提交</a> ";
                                  h += "<a class='l-button' style='width:40px;float:left; margin-left:10px;' href='javascript:cancelEdit(" + rowindex + ")'>取消</a> "; 
                              }
                              return h;
                          }
                       }
                
                
                ],  
                pagesizeParmName :"page.pageSize",
                pageParmName  :"page.currentPage",
                enabledEdit: true,
                clickToEdit:false,
                statusName :"_status",
                usePager:true,
                url:'<%=actionName+"getGridMastersFromUrl" %>',
                width: '100%',
                height:'100%',
                onSelectRow : function(data,rowid,rowdata){
                	
                }
            });

            
            $("#topmenu").ligerMenuBar({ items: [
                 { text: '文件', menu: menu1 },
                 { text: '导出', menu: menu2 }
             ]
             });
            

            $("#pageloading").hide();
            
            
            
            
            
        });
        
        //开始修改
        function beginEdit(rowid) { 
            manager.beginEdit(rowid);
        }
        //取消修改
        function cancelEdit(rowid) { 
            manager.cancelEdit(rowid);
        }
        //修改完成
        function endEdit(rowid)
        {
            
        	manager.endEdit(rowid);
            var row = manager.getSelectedRow();
            
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
  				   			manager.endEdit(rowid);
  				   		}
  				   		
  				   		
  				   },
  					error : function(XMLHttpRequest, textStatus, errorThrown) {
  						alert("服务器获取数据失败："+errorThrown);
  						
  					}
  				});
            }
            
            
        }
        //删除行
        function deleteRow(rowid)
        {
            if (confirm('确定删除?'))
            {
            	var row = manager.getSelectedRow();
            	
            	$.ajax({
 				   type: "POST",
 				   url: '<%=actionName+"deleteMasterRowByfrmMDIChild_DB?masterVO="+masterVO+"&masterPrimaryKey="+masterPrimaryKey %>',
 				   data: row,
 				   dataType:"json", 
 				   success: function(msg){
 				   		
 				   		manager.deleteRow(rowid);
 				   		alert(msg.title);
 				   },
 					error : function(XMLHttpRequest, textStatus, errorThrown) {
 						alert("服务器获取数据失败："+errorThrown);
 						
 					}
 				});
            }
        }
        //增加一行
        function addByfrmMDIChild_DB(){
        	$.ajax({
        		type : "POST",
        		url : '<%=actionName+"addMasterRowByfrmMDIChild_DB" %>',
        		dataType:"json",
        		success: function(msg){
        			var rowdata = msg;
				   	manager.addEditRow(rowdata) ;
			   },
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("服务器获取数据失败："+errorThrown);
					
				}
        	});
        };
        
     
        
    </script>
    
</head>
<body style="padding:0px; overflow:hidden; "> 

	
 	<div id="topmenu"></div> 
  	<div id="frmMDIChild_DB_toptoolbar"></div>
  	
  	<div id="navtabMain" style="width: 100%; height:100%; overflow:hidden; border:1px solid #A3C0E8; ">
		<div tabid="home" title="数据列表" selected="true"   > <!-- showClose="true" -->
		  	 <div id="grid" style="margin:0; padding:0 ;width: 100%;height: 100% ">
		  	 </div>
	  	 </div>
  	 </div>


</body>
</html>
