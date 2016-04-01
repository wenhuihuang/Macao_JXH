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
		var carRecordDataGrid,
  		carAbsentDataGrid;
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
        	location.href = "CarSetting/add.do";
        }
        
        function modifyRow(){
        	var carID = getRowCell(maingrid,"carID");
        	if(carID!="" && carID!=null){
	        	location.href = "CarSetting/edit.do?carID="+carID;        		
        	}
        }
        function deleteRow(){
        	var carID = getRowCell(maingrid,"carID");
      		if(confirm("是否刪除？")){
     			$.ajax({
         			type:"post",
         			url:"CarSetting/deleteCarSetting.do",
         			data:"carID="+carID,
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
        
        
        //校車記錄
    	function bindingCarRecordDataGrid(){
    		function getFullName(checkbox) {
    		    var options = {
    		        columns: [
    				{ display: '會員ID', name: 'custID', minWidth: 120, width: 100 },
    		        { display: '案主姓名', name: 'fullName', minWidth: 120, width: 100 }
    		        ], switchPageSizeApplyComboBox: false,
    		        //pageSize: 10
    		       /*  checkbox: checkbox, */
    		       url:"Customer/list.do"
    		      // usePager:false
    		       
    		    };
    		    return options;
    		}
          function f_onSelected(e) { 
                if (!e.data || !e.data.length) return;

                var grid = liger.get("carRecordDataGrid");

                var selected = e.data[0]; 
                grid.updateRow(grid.lastEditRow, {
                    fullName1: selected.fullName,
                    custID: selected.custID,
                });
    /* 
                var out = JSON.stringify(selected);
                $("#message").html('最后选择:'+out); */
            }
  	 	function getCarNO(checkbox) {
		    var options = {
		        columns: [
				{ display: '校車ID', name: 'carID', minWidth: 120, width: 100 },
		        { display: '校車編號', name: 'carNO', minWidth: 120, width: 100 },
		        { display: '校車車牌號', name: 'carNumber', minWidth: 120, width: 100 }
		        ], switchPageSizeApplyComboBox: false,
		        //pageSize: 10
		       //  checkbox: checkbox, 
		       url:"CarSetting/list.do"
		      // usePager:false
		       
		    };
		    return options;
		}
	     function c_onSelected(e) { 
	            if (!e.data || !e.data.length) return;

	            var grid = liger.get("carRecordDataGrid");

	            var selected = e.data[0]; 
	            alert(selected.carNO)
	            debugger
	            grid.updateRow(grid.lastEditRow, {
	                carID: selected.carID,
	                carNumber1: selected.carNumber,
	                carNO1: selected.carNO
	            });

	          /*   var out = JSON.stringify(selected);
	            $("#message").html('最后选择:'+out); */
	        } 
    	
    	var carRecordDataGridColumn = [
    								{ display: 'recordID', name: 'recordID', hide:true },
    								{ display: 'custID', name: 'custID', hide:true },
    								{ display: 'carID', name: 'carID', hide:true },
    								{
    			                        name: 'carNO',align:'center',  display: '校車編號', textField: 'carNO1'
    			                        , editor:
    			                            {
    			                            	type: 'popup', valueField: 'carNO1', textField: 'carNO1', grid:  getCarNO(true), onSelected:c_onSelected
    			                        	}
    			                    }, 
    								{
    			                        name: 'carNumber',align:'center',  display: '校車車牌號', textField: 'carNumber1'
    			                        , editor:
    			                            {
    			                            	type: 'popup', valueField: 'carNumber1', textField: 'carNumber1', grid:  getCarNO(true), onSelected:c_onSelected
    			                        	}
    			                    },
    								{
    			                        name: 'fullName',align:'center',  display: '學員', textField: 'fullName1'
    			                        , editor:
    			                            {
    			                            	type: 'popup', valueField: 'fullName1', textField: 'fullName1', grid:  getFullName(true), onSelected:f_onSelected
    			                        	}
    			                    },
    			                    { display: '開始日期', name: 'beginDate',type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
    			                    { display: '結束日期', name: 'endDate',type:"date", format: 'yyyy-MM-dd', editor: { type: 'date'}},
    			                    { display: '搭車時間', name: 'takeDate',type:"date",  format: 'yyyy-MM-dd', editor: { type: 'date'}},
    			                    { display: '應繳費用', name: 'toll',type:"float", editor: { type: 'float'}},
    			                    { display: '實繳費用', name: 'actToll',type:"float", editor: { type: 'float'}},
    			                    { display: '備註', name: 'note',type:"text", editor: { type: 'text'}}
    			                  ];
    			
    			
    	var carRecordDataGridToolBar = [
              { text: '新增', click: addCarRecordData, icon: 'add' , id:"add" },
              { line: true },
              { text: '删除', click: deleteCarRecordData, icon: 'delete' , id:"delete" },
              { line: true },
              { text: '保存', click: saveCarRecordDate, icon: 'save' , id:"save" }];
    	
    	var url = "CarRecord/getCarRecord.do";
    	
    	carRecordDataGrid = ligerGrid("carRecordDataGrid",null,carRecordDataGridColumn,url,carRecordDataGridToolBar,false,true);
    	
    	}
    	function addCarRecordData(){
    		carRecordDataGrid.addRow();
    	}
    	function deleteCarRecordData(){
    		carRecordDataGrid.deleteSelectedRow();
    	}
    	function saveCarRecordDate(){
     		var carRecordAdds= getAddedRows(carRecordDataGrid),
     		carRecordUpdates=getEditedRows(carRecordDataGrid),
     		carRecordDeletes=getDeletedRows(carRecordDataGrid);
  		 $.ajax({
		    		type:"post",
		 			url:"CarRecord/addCarRecord.do",
		 			data:"carRecordAdds="+carRecordAdds+"&carRecordUpdates="+carRecordUpdates+"&carRecordDeletes="+carRecordDeletes,
		 			success:function(msg){
		 				if(msg == "true" || msg == true){
		 					//maingrid.deleteSelectedRow();
		 					alert("保存成功！")
		 				}else{
		 					alert("保存失敗！");
		 				}
		 				 
		 			},
		 			error:function(){
		 				alert("保存失敗！");
		 			}
    		}) 
    	}
    	
        //缺席記錄
    	function bindingCarAbsentDataGrid(){
    		function getFullName(checkbox) {
    		    var options = {
    		        columns: [
    				{ display: '會員ID', name: 'custID', minWidth: 120, width: 100 },
    		        { display: '案主姓名', name: 'fullName', minWidth: 120, width: 100 }
    		        ], switchPageSizeApplyComboBox: false,
    		        //pageSize: 10
    		       /*  checkbox: checkbox, */
    		       url:"Customer/list.do"
    		      // usePager:false
    		       
    		    };
    		    return options;
    		}
          function f_onSelected(e) { 
                if (!e.data || !e.data.length) return;

                var grid = liger.get("carAbsentDataGrid");

                var selected = e.data[0]; 
                grid.updateRow(grid.lastEditRow, {
                    fullName2: selected.fullName,
                    custID: selected.custID
                });
    /* 
                var out = JSON.stringify(selected);
                $("#message").html('最后选择:'+out); */
            }
    	 	function getCarNO(checkbox) {
    		    var options = {
    		        columns: [
    		        { display: '校車編號', name: 'carNO', minWidth: 120, width: 100 },
    		        { display: '校車車牌號', name: 'carNumber', minWidth: 120, width: 100 },
    		        ], switchPageSizeApplyComboBox: false,
    		        //pageSize: 10
    		       //  checkbox: checkbox, 
    		       url:"CarSetting/list.do"
    		      // usePager:false
    		       
    		    };
    		    return options;
    		}
    	     function c_onSelected(e) { 
    	            if (!e.data || !e.data.length) return;

    	            var grid = liger.get("carAbsentDataGrid");

    	            var selected = e.data[0]; 
    	            grid.updateRow(grid.lastEditRow, {
    	                carNO2: selected.carNO,
    	                carID: selected.carID,
    	               // carNumber: selected.carNumber
    	            });

    	          /*   var out = JSON.stringify(selected);
    	            $("#message").html('最后选择:'+out); */
    	        } 
    	var carAbsentDataGridColumn = [
    								{ display: 'absentID', name: 'absentID', hide:true },
    								{ display: 'custID', name: 'custID', hide:true },
    								{ display: 'carID', name: 'carID', hide:true },
    			                    {
    			                        name: 'fullName',align:'center',minWidth:100,  display: '學員', textField: 'fullName2'
    			                        , editor:
    			                            {
    			                            	type: 'popup', valueField: 'fullName2',minWidth:100, textField: 'fullName2', grid:  getFullName(true), onSelected:f_onSelected
    			                        	}
    			                    },
    			                   // { display: '校車編號', name: 'carNO',type:"text", editor: { type: 'text'}},
    			                     {
    			                        name: 'carNO',align:'center',minWidth:100,  display: '校車編號', textField: 'carNO2'
    			                        , editor:
    			                            {
    			                            	type: 'popup', valueField: 'carNO2',minWidth:100, textField: 'carNO2', grid:  getCarNO(true), onSelected:c_onSelected
    			                        	}
    			                    }, 
    			                    { display: '開始日期', name: 'billDate',minWidth:100,type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
    			                    { display: '時間', name: 'time',minWidth:100,type:"text", editor: { type: 'text'}},
    			                    { display: '上車站點', name: 'upSite',minWidth:100,type:"text", editor: { type: 'text'}},
    			                    { display: '下車站點', name: 'dowSite',minWidth:100,type:"text", editor: { type: 'text'}},
    			                    { display: '缺席原因', name: 'reason',minWidth: 100,type:"text", editor: { type: 'text'}},
    			                    { display: '備註', name: 'note',minWidth: 100,type:"text", editor: { type: 'text'}}
    			                  ];
    			
    			
    	var carAbsentDataGridToolBar = [
              { text: '新增', click: addCarAbsentData, icon: 'add' , id:"add" },
              { line: true },
              { text: '删除', click: deleteCarAbsentData, icon: 'delete' , id:"delete" },
              { line: true },
              { text: '保存', click: saveCarAbsentDate, icon: 'save' , id:"save" }];
    	
    	var url = "CarSetting/getCarAbsentPojo.do";
    	
    	carAbsentDataGrid = ligerGrid("carAbsentDataGrid","99%",carAbsentDataGridColumn,url,carAbsentDataGridToolBar,false,true);
    	
    	}
    	function addCarAbsentData(){
    		carAbsentDataGrid.addRow();
    	}
    	function deleteCarAbsentData(){
    		carAbsentDataGrid.deleteSelectedRow();
    	}
    	function saveCarAbsentDate(){
    		var carAbsentAdds= getAddedRows(carAbsentDataGrid),
     		carAbsentUpdates=getEditedRows(carAbsentDataGrid),
     		carAbsentDeletes=getDeletedRows(carAbsentDataGrid);
	  		$.ajax({
		    		type:"post",
		 			url:"CarAbsent/addCarAbsent.do",
		 			data:"carAbsentAdds="+carAbsentAdds+"&carAbsentUpdates="+carAbsentUpdates+"&carAbsentDeletes="+carAbsentDeletes,
		 			success:function(msg){
		 				if(msg == "true" || msg == true){
		 					//maingrid.deleteSelectedRow();
		 					alert("保存成功！")
		 				}else{
		 					alert("保存失敗！");
		 				}
		 				 
		 			},
		 			error:function(){
		 				alert("保存失敗！");
		 			}
	    		}) 
    	}
        
        $(function ()
        {
        	setTabTitle(parent.$("#framecenter"),"校車列表") 
        	
        	
            var columns = [
    	                { display: '校車編號', name: 'carNO', minWidth: 100 },
    	                { display: '校車車牌號', name: 'carNumber', minWidth: 140 },
    	                { display: '司機', name: 'worker', minWidth: 140 },
    	                { display: '發車時間', name: 'beginDate', minWidth: 140 },
    	                { display: '終點站時間', name: 'endDate', minWidth: 140 },
    	                { display: '備註', name: 'note', minWidth: 140 }
                    ] ;
            
            var gridToolBar = [
                               { text: '增加', click: itemclick, icon: 'add' , id:"add" },
                               { line: true },
                               { text: '修改', click: itemclick, icon: 'modify' , id:"modify" },
                               { line: true },
                               { text: '删除', click: itemclick, icon: 'delete' , id:"delete" }
                             ];
            maingrid = ligerGrid("maingrid",'99%',columns,"CarSetting/list.do?",gridToolBar,false,true);
            $("#pageloading").hide();
    		bindingCarRecordDataGrid();
    		bindingCarAbsentDataGrid();
       	 $("#tab").ligerTab({onAfterSelectTabItem:function(targettabid){
	       		switch(targettabid){
					case "carRecord":
							showGridInTab(carRecordDataGrid);
						break;
					case "carAbsent":
							showGridInTab(carAbsentDataGrid);
						break;
					default:break;
    			} 
    		}}); 
        });


        
        
    </script>
</head>
<body style="overflow-x:hidden; padding:2px;">
<div class="l-loading" style="display:block" id="pageloading"></div>
	<!-- <div id="toptoolbar"></div> --> 
	
	
	<!-- <div class="l-clear"></div> -->
	<div id="tab">
		<div tabid="carSetting" title="校車設置">
			 <div id="maingrid"></div>
		</div>
		<div tabid="carRecord" title="搭車登記">
		  	<div id="carRecordDataGrid"></div>
	  	</div>
	  	<div tabid="carAbsent" title="缺席搭車記錄">
	  		<div id="carAbsentDataGrid"></div>
	  	</div>
	</div>

   
 
</body>
</html>