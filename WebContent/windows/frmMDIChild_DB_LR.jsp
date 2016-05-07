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

<title></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">



<link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"
	type="text/css" />
<script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/core/base.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerLayout.js"
	type="text/javascript"></script>
<link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet"
	type="text/css" />
<script src="lib/ligerUI/js/plugins/ligerMenu.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerMenuBar.js"
	type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerToolBar.js"
	type="text/javascript"></script>
<script type="text/javascript" src="windows/toptoolbar.js"></script>
<script src="lib/ligerUI/js/plugins/ligerTab.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script>
<script src="windows/CustomersData.js" type="text/javascript"></script>

<script type="text/javascript">
	<%
		String actionName = (String)request.getAttribute("actionName");
		actionName = actionName==null?"":actionName;
	%>

	$(function() {
		$("#layout1").ligerLayout({ leftWidth: 300});
        $("#navtabMain").ligerTab();
        
        
        
        $("#gridLeft").ligerGrid({
            columns: [
					<%
					 Map<String,String> masterTitles =  (HashMap<String,String>)request.getAttribute("masterTitles");
					if(masterTitles!=null&&masterTitles.size()>0){
						 for(Map.Entry<String,String> map:masterTitles.entrySet()){
							 String name = map.getKey();
							 String display = map.getValue().split("&")[0];
							 String width = map.getValue().split("&")[1];
							 
							 %>
							 
							 	
							 	{ display: '<%=display %>', name: '<%=name %>', align: 'left', width: <%=width %> },
							 <%
						 }
						 }
					%>
            ],  
            pagesizeParmName :"page.pageSize",
            pageParmName  :"page.currentPage",
            dataAction : "server",
            usePager:true,
            url:'<%=actionName+"getGridMastersFromUrl" %>',
            width: '100%',height:'97%'
        });
        
        
        $("#pageloading").hide();
	});
</script>


</head>



<body>
	<div id="frmMDIChild_DB_toptoolbar"></div>

	<div id="layout1">
		<div position="left" title="主表数据">
			<div id="navtabMain" style="width: 100%;height:98%; overflow:hidden; border:1px solid #A3C0E8; ">
			<div tabid="home" title="数据列表" lselected="true"   > <!-- showClose="true" -->
				<div id="gridLeft" style="margin:0; padding:0"></div>
			</div>
			</div>
		
		</div>
		<div position="center" title="明细表数据">
			
		</div>
	</div>
</body>
</html>
