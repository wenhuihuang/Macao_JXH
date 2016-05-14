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
<script type="text/javascript" src="gridReport/CreateControl.js"></script>
<script type="text/javascript" src="gridReport/GRInstall.js"></script>
<script type="text/javascript" src="gridReport/GRUtility.js"></script>


<script type="text/javascript" src="js/makeCard.js"></script>

<script type="text/javascript" src="windows/keycode.js"></script>
<script type="text/javascript" src="windows/jsUnitCore.js"></script>
<title>會員資料管理</title>
<script type="text/javascript">
		CreateReport("Report");
		var maingrid = null;
        
        function itemclick(item)
        {
            switch(item.id){
            	case "add":addRow();break;
            	case "modify":modifyRow();break;
            	case "delete":deleteRow();break;
            	case "makeCard":setBarCode();break;
            	default : break;
            }
        }
        
        function addRow(){
        	location.href = "Customer/add.do";
        }
        
        function modifyRow(){
        	var custID = getRowCell(maingrid,"custID");
        	if(custID!=""){
	        	location.href = "Customer/edit.do?CUSTID="+custID;        		
        	}
        }
        
     	function deleteRow(){
     		var custID = getRowCell(maingrid,"custID");
     		if(confirm("是否刪除？")){
     			$.ajax({
         			type:"post",
         			url:"Customer/deleteCustomer.do",
         			data:"custID="+custID,
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
		function setBarCode(){
			
			var reportType = Report+"";
			if(reportType.indexOf("Plugin")<=-1){
				alert("系統檢測到該計算機未安裝報表插件，需要安裝報表插件。\n 安装后，請刷新頁面或重新打開瀏覽器再試！");
				window.open("gridReport/grbsctl5.exe",'self');
				return;
			}
			Report.LoadFromURL("../../gridReport/Barcode.grf");
			
			
			
			
			var rows = maingrid.getSelectedRows();
			
			if(rows==null||rows.length<=0){
				alert("請選擇打印條碼的會員！");
				return;
			}
			
			
			Report.PrepareRecordset();
			for(var i = 0;i<rows.length;i++){
				
				Report.DetailGrid.Recordset.Append();
				Report.FieldByName("fCustCode").AsString = rows[i].custCode;
				Report.DetailGrid.Recordset.Post();
			 
			}
			Report.PrintPreview(true);
		}
        
        $(function ()
        {
        	 
            var sexData = [{sex:1,text:'男'},{sex:2,text:'女'}];
            var custTypeData = [{custType:0,text:'非會員'},{custType:1,text:'永久會員'},{custType:2,text:'臨時會員'}];
            var cardStatusData = [{cardStatus:0,text:'退會'},{cardStatus:1,text:'正常'},{cardStatus:2,text:'欠費'}];
            var cardTypeData = [{cardType:1,text:'永久身份證'},{cardType:2,text:'非永久身份證'},{cardType:3,text:'其他'}];
        	
            var columns = [
       	                { display: '會員編碼', name: 'custCode', align: 'left', minWidth: 60 },
    	                { display: '姓名', name: 'fullName', minWidth: 100 },
    	                { display: '英文名', name: 'fullNameEng', minWidth: 120 },
    	                { display: '性別', name: 'sex',minWidth: 100
    	                	,editor: { data: sexData, valueField: 'sex' },
	                        render: function (item)
	                        {
	                        	return getGridSelectedData(sexData[parseInt(item.sex)-1]);
	                        } },
    	                { display: '會員類別', name: 'custType',minWidth: 100
    	                	,editor: { data: custTypeData, valueField: 'custType' },
	                        render: function (item)
	                        {
	                        	return getGridSelectedData(custTypeData[parseInt(item.custType)]);
	                        }},
    	                { display: '會員證狀態', name: 'cardStatus' ,minWidth: 100
    	                	,editor: { data: cardStatusData, valueField: 'cardStatus' },
	                        render: function (item)
	                        {
	                        	return getGridSelectedData(cardStatusData[parseInt(item.cardStatus)]);
	                        }},
    	                { display: '會員有效期', name: 'validDate_str', minWidth: 140 },
    	                { display: '證件類型', name: 'cardType', minWidth: 100
    	                	,editor: { data: cardTypeData, valueField: 'cardType' },
	                        render: function (item)
	                        {
	                        	return getGridSelectedData(cardTypeData[parseInt(item.cardType)-1]);
	                        }  },
    	                { display: '證件號碼', name: 'cardNo', minWidth: 140 }
                    ] ;
            
            var gridToolBar = [
                               { text: '增加', click: itemclick, icon: 'add' , id:"add" },
                               { line: true },
                               { text: '修改', click: itemclick, icon: 'modify' , id:"modify" },
                               { line: true },
                               { text: '删除', click: itemclick, icon: 'delete' , id:"delete" },
                               { line: true },
                               { text: '條碼', click: itemclick, icon: 'myaccount' , id:"makeCard" }
                             ];
            maingrid = $("#maingrid").ligerGrid({
               		columns:columns ,
	                pagesizeParmName :"page.pageSize",
	                pageParmName  :"page.currentPage",
	                pageSize:30,
	                enabledEdit: true,
                  	clickToEdit:false,
                	fixedCellHeight:false,
	                checkbox: true,
	                dataAction : "server",
	                url : 'Customer/list.do',
	               // parms : {"currentMasterid" :currentMasterID},
	                usePager:true,
	                width: '100%',height:'97%',
	                toolbar:{ items: gridToolBar },
	                onDblClickRow : function (data, rowindex, rowobj)
	                {
	                	var currentRow = gridMain.getRow(rowindex);
	                	
	                	editByfrmMDIChild_DB(currentRow);
	                } 
            })
             

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
