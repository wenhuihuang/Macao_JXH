<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>個案資料管理</title>
<jsp:include page="/jsp/head.jsp"></jsp:include>
<jsp:include page="/jsp/menberData.jsp"></jsp:include>
<script type="text/javascript">
	       var carRecordDataGrid,
	      		carAbsentDataGrid;
        
	
	
	
    //校車記錄
	function bindingCarRecordDataGrid(){
	
	var carRecordDataGridColumn = [
								{ display: 'recordID', name: 'recordID', hide:true },
			                    { display: '校車編號', name: 'carNO', type:"text",editor: { type: 'text' }},
			                    { display: '校車車牌號', name: 'carNumber', type:"text",editor: { type: 'text'}},
			                    { display: '報名學員', name: 'fullName',type:"text", editor: { type: 'text'}},
			                    { display: '開始日期', name: 'beginDate',type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
			                    { display: '結束日期', name: 'endDate',type:"text", format: 'yyyy-MM-dd', editor: { type: 'date'}},
			                    { display: '搭車時間', name: 'takeDate',type:"time", editor: { type: 'text'}},
			                    { display: '應繳費用', name: 'toll',type:"text", editor: { type: 'text'}},
			                    { display: '實繳費用', name: 'actToll',type:"text", editor: { type: 'text'}},
			                    { display: '備註', name: 'note',type:"text", editor: { type: 'text'}}
			                  ];
			
			
	var carRecordDataGridToolBar = [
          { text: '新增', click: addCarRecordData, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteCarRecordData, icon: 'delete' , id:"delete" }];
	
	var url = "CarSetting/getCarRecord.do?carID="+$("#carID").val();
	
	carRecordDataGrid = ligerGrid("carRecordDataGrid",null,carRecordDataGridColumn,url,carRecordDataGridToolBar,false,true);
	
	}
	function addCarRecordData(){
		carRecordDataGrid.addRow();
	}
	function deleteCarRecordData(){
		carRecordDataGrid.deleteSelectedRow();
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
    	  console.log(e.data[0])
            if (!e.data || !e.data.length) return;

            var grid = liger.get("carAbsentDataGrid");

            var selected = e.data[0]; 
            grid.updateRow(grid.lastEditRow, {
                fullName: selected.fullName,
                custID: selected.custID,
            });
/* 
            var out = JSON.stringify(selected);
            $("#message").html('最后选择:'+out); */
        }
	/* 	function getCarNO(checkbox) {
		    var options = {
		        columns: [
				{ display: '會員ID', name: 'custID', minWidth: 120, width: 100 },
		        { display: '案主姓名', name: 'fullName', minWidth: 120, width: 100 }
		        ], switchPageSizeApplyComboBox: false,
		        //pageSize: 10
		       //  checkbox: checkbox, 
		       url:"Customer/list.do"
		      // usePager:false
		       
		    };
		    return options;
		}
	     function c_onSelected(e) { 
	    	  console.log(e.data[0])
	            if (!e.data || !e.data.length) return;

	            var grid = liger.get("carAbsentDataGrid");

	            var selected = e.data[0]; 
	            grid.updateRow(grid.lastEditRow, {
	                carNO: selected.carNO,
	                carID: selected.carID,
	            });

	            var out = JSON.stringify(selected);
	            $("#message").html('最后选择:'+out);
	        } */
	var carAbsentDataGridColumn = [
								{ display: 'absentID', name: 'absentID', hide:true },
								{ display: 'custID', name: 'custID', hide:true },
			                    {
			                        name: 'fullName',align:'center',  display: '學員', textField: 'fullName'
			                        , editor:
			                            {
			                            	type: 'popup', valueField: 'fullName', textField: 'fullName', grid:  getFullName(true), onSelected:f_onSelected
			                        	}
			                    },
			                    { display: '校車編號', name: 'carNO',type:"text", editor: { type: 'text'}},
			               /*      {
			                        name: 'carNO',align:'center',  display: '校車編號', textField: 'carNO'
			                        , editor:
			                            {
			                            	type: 'popup', valueField: 'carNO', textField: 'carNO', grid:  getCarNO(true), onSelected:c_onSelected
			                        	}
			                    }, */
			                    { display: '開始日期', name: 'billDate',type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
			                    { display: '時間', name: 'time',type:"text", editor: { type: 'text'}},
			                    { display: '上車站點', name: 'upSite',type:"text", editor: { type: 'text'}},
			                    { display: '下車站點', name: 'dowSite',type:"text", editor: { type: 'text'}},
			                    { display: '缺席原因', name: 'reason',type:"text", editor: { type: 'text'}},
			                    { display: '備註', name: 'note',type:"text", editor: { type: 'text'}}
			                  ];
			
			
	var carAbsentDataGridToolBar = [
          { text: '新增', click: addCarAbsentData, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteCarAbsentData, icon: 'delete' , id:"delete" }];
	
	var url = "CarSetting/getCarAbsentPojo.do?carID="+$("#carID").val();
	
	carAbsentDataGrid = ligerGrid("carAbsentDataGrid",null,carAbsentDataGridColumn,url,carAbsentDataGridToolBar,false,true);
	
	}
	function addCarAbsentData(){
		carAbsentDataGrid.addRow();
	}
	function deleteCarAbsentData(){
		carAbsentDataGrid.deleteSelectedRow();
	}
	
	
	function itemclick(item){
		switch (item.id){
			case "save":
				save();
			break;
			case "back":
				location.href="jsp/manage/carSetting_list.jsp";
			break;
		}
		
	}
	
	function save(){
 		$("#carRecordAdds").val(getAddedRows(carRecordDataGrid));
 		$("#carRecordUpdates").val(getEditedRows(carRecordDataGrid));
 		$("#carRecordDeletes").val(getDeletedRows(carRecordDataGrid));
 		$("#carAbsentAdds").val(getAddedRows(carAbsentDataGrid));
 		$("#carAbsentUpdates").val(getEditedRows(carAbsentDataGrid));
 		$("#carAbsentDeletes").val(getDeletedRows(carAbsentDataGrid));
		$("#Button1").click();	
	}
    
	$(function(){
		if($("#gSID").val() != "" && $("#gSID").val() != 'null' && $("#gSID").val() != 'undefined'){
			setTabTitle(parent.$("#framecenter"),"課程設置編輯")
		}else{
			setTabTitle(parent.$("#framecenter"),"課程設置新增")
		}
		
		$(".toptoolbar").ligerToolBar({ items: [
            { text: '保存', click: itemclick, icon: 'save' , id:"save" },
            { line: true },
            { text: '取消', click: itemclick, icon: 'back' , id:"back" }
          ]
          });
		
		
		ligerForm("form1");
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
	 var siteArray;
	 function site(arr){
		 var site = $("#site").val();
		 	siteArray=site.split(",");
		 	function init(siteArray){
		 	
			 	var html="";
			 	for(var i = 0;i < siteArray.length;i++){
			 		if(i == siteArray.length-1){
			 			html+="<div class='site-"+i+"'><i class='i-no'>"+(i+1)+"</i><input class='site-input' type='text' value='"+siteArray[i]+"'><a href='javascript:;' class='btn site-del'>刪除</a></div>";
			 		}else{
			 			html+="<div class='site-"+i+"'><i class='i-no'>"+(i+1)+"</i><input class='site-input' type='text' value='"+siteArray[i]+"'><a href='javascript:;' class='btn site-del'>刪除</a><i class='arrows'></i></div>";
			 		}
			 	}
			 	$("#site-wrap").html(html);
				var s="";
		 		for(var i = 0;i < siteArray.length;i++){
		 			if(i != siteArray.length-1)
		 			s += siteArray[i]+",";
		 			else
		 			s += siteArray[i];
		 		}
		 		$("#site").val(s);
		 		del()
		 		changeFn()
		 	}
		 	init(siteArray)
		 	function del(){
			 	$(".site-del").click(function(){
			 		var div = $(this).parents("div").attr("class").toString();
			 		var i = parseInt(div.replace(/^\w+\-/,""));
			 		//$("."+div).remove()
			 		siteArray.splice(i,1);
			 		console.log(siteArray)
			 		init(siteArray)
			 		
			 	})
		 	}
		 	function changeFn(){
			 	$("#site-wrap input").change(function(){
			 		var self=$(this)
			 		var div = $(this).parents("div").attr("class").toString();
			 		var i = parseInt(div.replace(/^\w+\-/,""));
			 		//$("."+div).remove()
			 		var v = $(this).val();
			 		var re = /\,+/g;
			 		if(re.test(v)){
			 			v = self.val().replace(/\,+/g," ")
			 		}
			 		siteArray.splice(i,1,v);
			 		init(siteArray)
			 		
			 	})
		 	}
	
		$(".site-add").click(function(){
	 		siteArray.push("0");
	 		init(siteArray)
	 		console.log(siteArray)
	 	})
	 }
	 site()

	 
    })
        
    </script>
</head>
<body>
	<div class="toptoolbar"></div>
	<form name="form1" class="liger-form" method="post" action="CarSetting/submit.do" id="form1" style="margin: 20px;">
	<input type="hidden" name="carID" id="carID" value="${carSetting.carID }">
	<input type="hidden" name="carRecordAdds" id="carRecordAdds">
	<input type="hidden" name="carRecordUpdates" id="carRecordUpdates">
	<input type="hidden" name="carRecordDeletes" id="carRecordDeletes">
	<input type="hidden" name="carAbsentAdds" id="carAbsentAdds">
	<input type="hidden" name="carAbsentUpdates" id="carAbsentUpdates">
	<input type="hidden" name="carAbsentDeletes" id="carAbsentDeletes">
	
	<input type="hidden" name="site" id="site"  value="${carSetting.site }">
	
	
	<div id="tab">
		  	<div tabid="carSetting" title="校車設置">
		  		<div class="inline-group">
		  			<label>校車編號：</label>
		  			<input width="120px" value="${carSetting.carNO }" name="carNO" type="text" ltype="text" />
		  			<label>校車車牌號：</label>
		  			<input width="120px" value="${carSetting.carNumber }" name="carNumber" type="text" ltype="text" />
		  			<label>司機：</label>
		  			<input width="120px" value="${carSetting.worker }" name="worker" type="text" ltype="text" />
		  		</div>
		  		<div class="inline-group">
		  			<label>隨車人員：</label>
		  			<input width="120px" value="${carSetting.assistant }" name="assistant" type="text" ltype="text" />
		  			<label>發車時間：</label>
		  			<input width="120px" value="${carSetting.beginDate_str }" name="beginDate" type="text" ltype="date" />
		  			<label>終點站時間：</label>
		  			<input width="120px" value="${carSetting.endDate_str }" name="endDate" type="text" ltype="date" />
		  		</div>
		  		<div class="panel panel-default">
					<div class="panel-heading">站點設置</div>
					<div class="panel-body">
						<div id="site-wrap">
						</div>
						<a href='javascript:;' class='btn site-add'>增加</a>
					</div>
				</div>
		  		
		  	</div>
		  	<div tabid="carRecord" title="校車記錄">
		  		<div id="carRecordDataGrid"></div>
		  	</div>
		  	<div tabid="carAbsent" title="缺席搭車記錄">
		  		<div id="carAbsentDataGrid"></div>
		  	</div>
		  	
	  </div>
       
		<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
          </form>
        
        
        
        
    
    
    
</body>
</html>