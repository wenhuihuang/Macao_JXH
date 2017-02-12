<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
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
	
	
	
	<script type="text/javascript">
	 	var dialog = frameElement.dialog; //调用页面的dialog对象(ligerui对象)
	
		$(function(){
			$("#navtabMain").ligerTab();
			
			
			if(dialog.get("data")!=null){
				
				$("#home").attr("src",'<%=request.getParameter("url") %>?editPrimaryKey='+dialog.get("data").editPrimaryKey+'&editForeignKey='+dialog.get("data").editForeignKey);
				
				
			}else{
				$("#home").attr("src",'<%=request.getParameter("url") %>');
			}
			
			
			
		
			
			
		});
	</script>
	
	
  </head>
  
  <body>
    <div id="frmBaseEdit_toptoolbar"></div>
	<iframe   frameborder="0" width="100%" height="100%" name="home" id="home" src="">
					
	</iframe>
  </body>
</html>
