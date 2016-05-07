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
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	
	
	<link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
	<link href="lib/ligerUI/skins/Tab/css/form.css" rel="stylesheet" type="text/css" />
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
	<script src="lib/ligerUI/js/plugins/ligerTree.js" type="text/javascript"></script>
	<script src="lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	
	
	
	
	

	<script type="text/javascript">
		var treeMain,gridMain;
		<%
		 	String actionName = (String)request.getAttribute("actionName");
			actionName = actionName==null?"":actionName; //action名
			String masterPrimaryKey = (String)request.getAttribute("masterPrimaryKey");
			masterPrimaryKey = masterPrimaryKey==null?"":masterPrimaryKey; //主表主键
			Class masterVOClass = (Class)request.getAttribute("masterVO");
			String masterVO = masterVOClass==null?"":masterVOClass.getName(); //主表VO
			List<String> detailPrimaryKeys = (List<String>)request.getAttribute("detailPrimaryKeys"); //从表主键
			List<Class> detailVOs =(List<Class>)request.getAttribute("detailVOs");
			String dataType = (String)request.getAttribute("dataType");
			String openDialogWidthAndHeight = (String)request.getAttribute("openDialogWidthAndHeight");
			openDialogWidthAndHeight = openDialogWidthAndHeight==null?"0&0":openDialogWidthAndHeight;
			String dialogWidth = openDialogWidthAndHeight.split("&")[0];
			String dialogHeight = openDialogWidthAndHeight.split("&")[1];
			
		 %>
	
		$(function(){
			
			
			$("#layout1").ligerLayout({
				leftWidth : 200
			});
			
			$("#navtabDetail").ligerTab();
			
			
			
			
			treeMain= $("#treeMain").ligerTree({ 
            	nodeWidth: 200,
                url:'<%=actionName+"getTreeMastersFromUrl?dataType="+dataType %>',
                checkbox: false,
                isExpand: 2, 
                slide: false ,
                idFieldName: 'id',
                parentIDFieldName :'pid',
                height:'90%',
                statusName :"_status",
                onSelect :function(note){
                	//alert(note.data.id);
                	loadDetail(note.data.id);
                },
            	onSuccess : function(data){
            		//初始化  设置状态为未改变
            		for(var i = 0;i<data.length;i++){
            			data[i]._status = "unchange";
            		}
            		
            		if(data.length>0){
              		  var currentMasterID = data[0].id;
              		  
              		  loadDetail(currentMasterID);
              	  }
	            }
            });
			
            
            
            
            $("#pageloading").hide();
            
		});
		
		
			//读取从表
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
									 String othersFunction = "";
									 if(map.getValue().split("&").length>2){
										 othersFunction = map.getValue().split("&")[2];
									 }
									 
									 %>
									 	{ display: '<%=display %>', name: '<%=name %>', align: 'left'	
									 		<% if(!"".equals(width)&&!"0".equals(width)){%>, width: '<%=width %>' <% } %>
									 		<% if(!"".equals(othersFunction)){%> 
									 			<%=othersFunction%>
									 		<%}%>
									 		},
									 <%
								 }
								 }
							%>
	                ],  
	                pagesizeParmName :"page.pageSize",
	                pageParmName  :"page.currentPage",
	                pageSize:30,
	                dataAction : "server",
	                url : '<%=actionName+"getGridDetailsFromUrl" %>',
	                parms : {"currentMasterid" :currentMasterID},
	                usePager:true,
	                width: '100%',height:'100%'
	            });
      	  
        	}
			
			
			
			
			
			//增加一节点 （树形）
			function addNodeByfrmMDIChild_TreeView(){
				var node = treeMain.getSelected();
				
				$.ligerDialog.prompt('请输入类别名称', function (yes, value)
	            {
                        if (yes){
                        	
							var nodes =[];
                       	 	$.ajax({
                       	 		type : "POST",
                       	 		url : '<%=actionName+"addorEditNodeByfrmMDIChild_DB_TreeView?masterVO="+masterVO %>',
                       	 		data : { "text" : value ,"pid":node.data.id,"_status":"add","textName":"typeName","idName":'<%=masterPrimaryKey%>'},
                       	 		dataType : "json",
                       	 		success: function(msg){
                       	 			
                       	 			if(msg.id!=null){
                       	 				
										nodes.push({ text:value,pid:node.data.id,id:msg.id });
	                       	 			
		                       	 		if (node){
		    	                       		 treeMain.append(node.target, nodes);
		    	                       	 }
		    	                         else{
		    	                        	 treeMain.append(null, nodes);
		    	                         }
                       	 				
                       	 			}
                       	 			
                       	 			
                       	 		}
                       	 	});
                        }
				}); 
			}
			
			
			//修改一节点（树形）
			function editNodeByfrmMDIChild_TreeView(){
				var node = treeMain.getSelected();
				
				
				
				if(node==null){
					alert("请选择节点！");
					return;
				}
				
				$.ligerDialog.prompt('请输入类别名称',node.data.text, function (yes, value)
	            {
					 if (yes){
                   	 	
						 $.ajax({
                   	 		type : "POST",
                   	 		url : '<%=actionName+"addorEditNodeByfrmMDIChild_DB_TreeView?masterVO="+masterVO+"&&masterPrimaryKey="+masterPrimaryKey+"&&dataType="+dataType  %>',
                   	 		data : { "text" : value ,"pid":node.data.pid,"id":node.data.id,"_status":"update","textName":"typeName","idName":'<%=masterPrimaryKey%>' },
                   	 		dataType : "json",
                   	 		success: function(msg){
                   	 			alert(msg.title);
								treeMain.update(node.target, { text:value });
	    	                    
                   	 		}
                   	 	});
					 }
					
	            });
			}
			
			
			// 删除一节点 （树形）
			function deleteNodeByfrmMDIChild_TreeView(){
				var node = treeMain.getSelected();
				if(node==null){
					alert("请选择一节点！");
					return;
				}
				
				if(node.data.pid=="0"){
					alert("根节点不能删除");
					return;
				}
				
				if (node){
					$.ajax({
						type:"POST",
						url : '<%=actionName+"deleteNodeByfrmMDIChild_DB_TreeView?masterVO="+masterVO %>',
						data : node.data,
						dataType: "json",
						success : function(msg){
							
							treeMain.remove(node.target);
							alert(msg.title);
						}
					});
				}
	            else{
	                alert('请先选择节点');
	            }
				
			}
			

			
			function deleteRowByfrmMDIChild_DB_TreeView(){
				
				var row = gridMain.getSelectedRow();
				if(row==null){
					alert("请选择需要删除的行！");
					return;
				}
				
				
				 if (confirm('确定删除?'))
		         {
				
					$.ajax({
		 				   type: "POST",
		 				   url: '<%=actionName+"deleteMasterRowByfrmMDIChild_DB_Tree?masterVO="+detailVOs.get(0).getName()+"&&masterPrimaryKey="+detailPrimaryKeys.get(0) %>',
		 				   dataType:"json", 
		 				   data : { '<%=detailPrimaryKeys.get(0)%>': row.<%=detailPrimaryKeys.get(0)%>},
		 				   success: function(msg){
		 				   		
		 					  	gridMain.deleteSelectedRow();
		 				   		alert(msg.title);
		 				   },
		 					error : function(XMLHttpRequest, textStatus, errorThrown) {
		 						alert("服务器获取数据失败："+errorThrown);
		 						
		 					}
		 				});
		           }
			}
			
	</script>
	
	
	<script type="text/javascript">
		
		function addByfrmMDIChild_DB(){
			var node = treeMain.getSelected();
			if(node==null){
				alert("请选中一个分类以创建对象！");
				return;
			}
			
			var editForeignKey = node.data.id;
			
			
			$.ligerDialog.open({ url: '<%=actionName+"showSingle?editForeignKey=" %>'+editForeignKey, 
				data : { editPrimaryKey : "" , editForeignKey : editForeignKey},
				height: '<%=dialogHeight%>', width: '<%=dialogWidth%>', buttons: [
		    { text: '返回', onclick: function (item, dialog) {dialog.close();gridMain.reload(); },cls:'l-dialog-btn-highlight' }
		 ], isResize: true
		});
			
		}
		
		
		
		function editByfrmMDIChild_DB(){
			var row = gridMain.getSelectedRow();
			if(row==null){
				alert("请选择一行记录");
				return;
			}
			
			var editPrimaryKey = row.<%=detailPrimaryKeys.get(0)%>;
			var editForeignKey = row.<%=masterPrimaryKey %>;
			
			
			
			$.ligerDialog.open({ url: '<%=actionName+"showSingle?editPrimaryKey=" %>'+editPrimaryKey, 
					data : { editPrimaryKey : editPrimaryKey , editForeignKey : editForeignKey},
					height: '<%=dialogHeight%>', width: '<%=dialogWidth%>', buttons: [
			    { text: '返回', onclick: function (item, dialog) {dialog.close();gridMain.reload(); },cls:'l-dialog-btn-highlight' }
			 ], isResize: true
			});
		}
		
	</script>
	

<style type="text/css"> 

body{ padding:5px; margin:0; padding-bottom:15px;}



    </style>
  </head>
  
  <body>
    <div id="frmMDIChild_DB_TreeView_toptoolbar"></div>
    <div style="height:auto;">
		
	</div>
    
    <div id="layout1" style="width: 100%">
		<div position="left" title="主表数据">
			<!--带复选框和Icon  -->
			<!-- border:1px solid #ccc; overflow: auto; -->
		    <div style="width:100%; height:95%; margin:0px; float:left; border:0px solid #ccc;  ">
			    <ul id="treeMain">
			    </ul>
		    </div> 
		</div>
		<div position="center" title="明细表数据" >
       	 	<div id="navtabDetail" style="width: 100%;overflow:hidden; border:1px solid #A3C0E8; ">
				<div tabid="home" title="数据列表" lselected="true"   > <!-- showClose="true" -->
					<div id="gridMain" style="margin:0; padding:0"></div>
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
