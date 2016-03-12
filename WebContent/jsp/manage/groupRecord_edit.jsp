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
        var groupSettingRecordBudgetDataGrid,
        groupSettingRecordPlanDataGrid,
        groupSettingRecordPerformanceDataGrid;
        
        //記錄預計
		function bindingGroupSettingRecordBudgetDataGrid(){
		
		var groupSettingRecordBudgetDataGridColumn = [
									{ display: 'budgetID', name: 'budgetID', hide:true },
				                    { display: '活動編號', name: 'actNO', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '項目', name: 'actName', width: 100 ,type:"text",editor: { type: 'text'}},
				                    { display: '費用/人', name: 'pay',width:300, type:"text", editor: { type: 'text'}},
				                    { display: '人數', name: 'qty',width:300, type:"text", editor: { type: 'text'}},
				                    { display: '支出', name: 'expenditure',width:300, type:"text", editor: { type: 'text'}}
				                  ];
				
				
		var groupSettingRecordBudgetDataGridToolBar = [
	          { text: '新增', click: addGroupSettingRecordBudgetData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteGroupSettingRecordBudgetData, icon: 'delete' , id:"delete" }];
		
		var url = "GroupRecord/getGroupSettingRecordBudget.do?recordID="+$("#recordID").val();
		
		groupSettingRecordBudgetDataGrid = ligerGrid("groupSettingRecordBudgetDataGrid",null,groupSettingRecordBudgetDataGridColumn,url,groupSettingRecordBudgetDataGridToolBar,false,true);
		
	}
	function addGroupSettingRecordBudgetData(){
		groupSettingRecordBudgetDataGrid.addRow();
	}
	function deleteGroupSettingRecordBudgetData(){
		groupSettingRecordBudgetDataGrid.deleteSelectedRow();
	}
	
    //記錄計畫
	function bindingGroupSettingRecordPlanDataGrid(){
	
	var groupSettingRecordPlanDataGridColumn = [
								{ display: 'planID', name: 'planID', hide:true },
			                    { display: '活動編號', name: 'actNO',type:"text",editor: { type: 'text' }},
			                    { display: '活動名稱', name: 'actName',type:"text",editor: { type: 'text'}},
			                    { display: '日期', name: 'billDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
			                    { display: '時間', name: 'time', type:"text", editor: { type: 'text'}},
			                    { display: '活動流程', name: 'process', type:"text", editor: { type: 'text'}},
			                    { display: '備註', name: 'note', type:"text", editor: { type: 'text'}}
			                  ];
			
			
	var groupSettingRecordPlanDataGridToolBar = [
          { text: '新增', click: addGroupSettingRecordPlanData, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteGroupSettingRecordPlanData, icon: 'delete' , id:"delete" }];
	
	var url = "GroupRecord/getGroupSettingRecordPlan.do?recordID="+$("#recordID").val();
	
	groupSettingRecordPlanDataGrid = ligerGrid("groupSettingRecordPlanDataGrid",null,groupSettingRecordPlanDataGridColumn,url,groupSettingRecordPlanDataGridToolBar,false,true);
	
	}
	function addGroupSettingRecordPlanData(){
		groupSettingRecordPlanDataGrid.addRow();
	}
	function deleteGroupSettingRecordPlanData(){
		groupSettingRecordPlanDataGrid.deleteSelectedRow();
	}
	
	//記錄學員表現
	function bindingGroupSettingRecordPerformanceDataGrid(){
	
	var groupSettingRecordPerformanceDataGridColumn = [
								{ display: 'formanceID', name: 'formanceID', hide:true },
			                    { display: '學員名稱', name: 'fullName',type:"text",editor: { type: 'text' }},
			                    { display: '日期', name: 'billDate', type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
			                    { display: '時間', name: 'time', type:"text", editor: { type: 'text'}},
			                    { display: '活動編號', name: 'actNO',type:"text", editor: { type: 'text'}},
			                    { display: '活動名稱', name: 'actName',type:"text", editor: { type: 'text'}},
			                    { display: '學員表現', name: 'performance', type:"text", editor: { type: 'text'}},
			                    { display: '缺席原因', name: 'reason', type:"text", editor: { type: 'text'}},
			                    { display: '備註', name: 'note', type:"text", editor: { type: 'text'}}
			                  ];
			
			
	var groupSettingRecordPerformanceDataGridToolBar = [
          { text: '新增', click: addGroupSettingRecordPerformanceData, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteGroupSettingRecordPerformanceData, icon: 'delete' , id:"delete" }];
	
	var url = "GroupRecord/getGroupSettingRecordPerformance.do?recordID="+$("#recordID").val();
	
	groupSettingRecordPerformanceDataGrid = ligerGrid("groupSettingRecordPerformanceDataGrid",null,groupSettingRecordPerformanceDataGridColumn,url,groupSettingRecordPerformanceDataGridToolBar,false,true);
	
	}
	function addGroupSettingRecordPerformanceData(){
		groupSettingRecordPerformanceDataGrid.addRow();
	}
	function deleteGroupSettingRecordPerformanceData(){
		groupSettingRecordPerformanceDataGrid.deleteSelectedRow();
	}
	
	
	function itemclick(item){
		switch (item.id){
			case "save":
				save();
			break;
			case "back":
				location.href="jsp/manage/groupRecord_list.jsp";
			break;
		}
		
	}
	
	function save(){
		$("#groupSettingRecordBudgetAdds").val(getAddedRows(groupSettingRecordBudgetDataGrid));
 		$("#groupSettingRecordBudgetUpdates").val(getEditedRows(groupSettingRecordBudgetDataGrid));
 		$("#groupSettingRecordBudgetDeletes").val(getDeletedRows(groupSettingRecordBudgetDataGrid));
 		$("#groupSettingRecordPlanAdds").val(getAddedRows(groupSettingRecordPlanDataGrid));
 		$("#groupSettingRecordPlanUpdates").val(getEditedRows(groupSettingRecordPlanDataGrid));
 		$("#groupSettingRecordPlanDeletes").val(getDeletedRows(groupSettingRecordPlanDataGrid));
 		$("#groupSettingRecordPerformanceAdds").val(getAddedRows(groupSettingRecordPerformanceDataGrid));
 		$("#groupSettingRecordPerformanceUpdates").val(getEditedRows(groupSettingRecordPerformanceDataGrid));
 		$("#groupSettingRecordPerformanceDeletes").val(getDeletedRows(groupSettingRecordPerformanceDataGrid));
		$("#Button1").click();	
	}
    
	$(function(){
		if($("#recordID").val() != "" && $("#recordID").val() != 'null' && $("#recordID").val() != 'undefined'){
			setTabTitle(parent.$("#framecenter"),"小組記錄編輯")
		}else{
			setTabTitle(parent.$("#framecenter"),"小組記錄新增")
		}
		
		$(".toptoolbar").ligerToolBar({ items: [
            { text: '保存', click: itemclick, icon: 'save' , id:"save" },
            { line: true },
            { text: '取消', click: itemclick, icon: 'back' , id:"back" }
          ]
          });
		
		
		ligerForm("form1");
		bindingGroupSettingRecordBudgetDataGrid();
		bindingGroupSettingRecordPlanDataGrid();
		bindingGroupSettingRecordPerformanceDataGrid();
	 $("#tab").ligerTab({onAfterSelectTabItem:function(targettabid){
			switch(targettabid){
				case "groupRecordGrid":
						showGridInTab(groupSettingRecordBudgetDataGrid);
						showGridInTab(groupSettingRecordPlanDataGrid);
						showGridInTab(groupSettingRecordPerformanceDataGrid);
					break;
				default:break;
			}
		}}); 
	 
	 
	//小組
	 var full = $("#groupName").ligerPopupEdit({
	    grid: getFullNameGridOptions(true),
	    valueField: 'groupName',
	    textField: 'groupName',
	    width: 200,
	    onSelected:fullNameSelected
	});

	function getFullNameGridOptions(checkbox) {
	    var options = {
	        columns: [
				{ display: '小組NO', name: 'gSNO', minWidth: 120, width: 100 },
	        	{ display: '小組', name: 'groupName', minWidth: 120, width: 100 }
	        ], switchPageSizeApplyComboBox: false,
	        //pageSize: 10
	       /*  checkbox: checkbox, */
	       url:"GroupSetting/list.do"
	      // usePager:false
	       
	    };
	    return options;
	}

	function fullNameSelected(data){
		   console.log(data.data[0])
		   var gSID = data.data[0].gSID;
		   $.ajax({
			   type:"post",
			   url:"GroupSetting/getGroupSettingByGSID.do",
			   data:"gSID="+gSID,
			   success:function(msg){
				  // var m = JSON.parse(msg);
				  if(msg != ""){
					  console.log(msg)
	    			   var m = msg.replace(/^\[/g,"");
	    					m = m.replace(/\]$/g,"");
	    					m = JSON.parse(m)
	    			   console.log(m)
	    			   $("#target").val(m.target);
	    			   $("#gSID").val(m.gSID);
				  }
				   
			   }
			   
		   }) 
	}
		
    })
        
    </script>
</head>
<body>
	<div class="toptoolbar"></div>
	<form name="form1" class="liger-form" method="post" action="GroupRecord/submit.do" id="form1" style="margin: 20px;">
	<input type="hidden" name="recordID" id="recordID" value="${groupSettingRecord.recordID }">
	<input type="hidden" name="gSID" id="gSID" value="${groupSettingRecord.gSID }" >
	<input type="hidden" name="groupSettingRecordBudgetAdds" id="groupSettingRecordBudgetAdds">
	<input type="hidden" name="groupSettingRecordBudgetUpdates" id="groupSettingRecordBudgetUpdates">
	<input type="hidden" name="groupSettingRecordBudgetDeletes" id="groupSettingRecordBudgetDeletes">
	<input type="hidden" name="groupSettingRecordPlanAdds" id="groupSettingRecordPlanAdds">
	<input type="hidden" name="groupSettingRecordPlanUpdates" id="groupSettingRecordPlanUpdates">
	<input type="hidden" name="groupSettingRecordPlanDeletes" id="groupSettingRecordPlanDeletes">
	<input type="hidden" name="groupSettingRecordPerformanceAdds" id="groupSettingRecordPerformanceAdds" >
	<input type="hidden" name="groupSettingRecordPerformanceUpdates" id="groupSettingRecordPerformanceUpdates" >
	<input type="hidden" name="groupSettingRecordPerformanceDeletes" id="groupSettingRecordPerformanceDeletes" >
	
	
	
	<div id="tab">
		  	<div title="小組記錄" tabid="groupRecordGrid">
		  		<div class="inline-group">
		  			<label>參與小組：</label>
		  			<input width="120px" value="${groupSetting.groupName }" name="groupName" id="groupName" type="text" />
		  			<label>小組目標：</label>
		  			<input width="120px" value="${groupSetting.target }" name="target" id="target" type="text" ltype="text" />
		  		</div>
		  		<div class="inline-group">
		  			<label>開始日期：</label>
		  			<input width="120px" value="${groupSettingRecord.beginDate_str }" name="beginDate" type="text" ltype="date" />
		  			<label>結束日期：</label>
		  			<input width="120px" value="${groupSettingRecord.endDate_str }" name="endDate" type="text" ltype="date" />
		  		</div>
		  		<div class="inline-group">
		  			<label>帶領者：</label>
		  			<input width="120px" value="${groupSettingRecord.leader }" name="leader" type="text" ltype="text" />
		  			<label>參與人數：</label>
		  			<input width="120px" value="${groupSettingRecord.qty }" name="qty" type="text" ltype="text" />
		  		</div>
		  		<div class="inline-group">
		  			<label>地點：</label>
		  			<textarea rows="2" cols="55" name="place" >${groupSettingRecord.place }</textarea>
		  		</div>
		  		<div class="inline-group">
		  			<label>材料或設備：</label>
		  			<textarea rows="2" cols="55" name="device" >${groupSettingRecord.device }</textarea>
		  		</div>
		  		<div class="inline-group">
		  			<label>預計參與學員：</label>
		  			<textarea rows="2" cols="55" name="custs" >${groupSettingRecord.custs }</textarea>
		  		</div>
		  				<div class="panel panel-default">
							<div class="panel-heading">預計支出</div>
							<div class="panel-body">
								<div id="groupSettingRecordBudgetDataGrid"></div>
							</div>
						</div>
		  			
		  		<div class="inline-group">
		  			<label>場地配置：</label>
		  			<textarea rows="2" cols="55" name="" >${groupSettingRecord.custs }</textarea>
		  		</div>
		  		<div class="panel panel-default">
					<div class="panel-heading">實際流程</div>
					<div class="panel-body">
						<div id="groupSettingRecordPlanDataGrid"></div>
					</div>
				</div>
		  		<div class="panel panel-default">
					<div class="panel-heading">學員表現</div>
					<div class="panel-body">
						<div id="groupSettingRecordPerformanceDataGrid"></div>
					</div>
				</div>
		  		
		  		<div class="inline-group">
		  			<label>小組總結：</label>
		  			<textarea rows="2" cols="55" name="" ></textarea>
		  		</div>
		  	</div>
		 <%--  	<div tabid="groupSettingGrid" title="小組設置">
		  		<div class="inline-group">
		  			<label>小組編號：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" ltype="text" />
		  			<label>負責人：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" ltype="text" />
		  		</div>
		  		<div class="inline-group">
		  			<label>小組名稱：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" ltype="text" />
		  			<label>小組目標：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" ltype="text" />
		  		</div>
		  		<div class="inline-group">
		  			<label>開始日期：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" ltype="text" />
		  			<label>結束日期：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" ltype="text" />
		  		</div>
		  		<div class="inline-group">
		  			<label>帶領者：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" ltype="text" />
		  			<label>參與人數：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" ltype="text" />
		  		</div>
		  		<div class="inline-group">
		  			<label>收費：</label>
		  			<textarea rows="2" cols="55" name="foodNote" >${groupSetting.foodNote }</textarea>
		  		</div>
		  		<div class="inline-group">
		  			<label>地點：</label>
		  			<textarea rows="2" cols="55" name="foodNote" >${groupSetting.foodNote }</textarea>
		  		</div>
		  		<div class="inline-group">
		  			<label>材料或設備：</label>
		  			<textarea rows="2" cols="55" name="foodNote" >${groupSetting.foodNote }</textarea>
		  		</div>
		  		<div class="inline-group">
		  			<label>參與學員：</label>
		  			<textarea rows="2" cols="55" name="foodNote" >${groupSetting.foodNote }</textarea>
		  		</div>
		  		<div class="panel panel-default">
					<div class="panel-heading">預算</div>
					<div class="panel-body">
						<div id="groupSettingBudgetDataGrid"></div>
					</div>
				</div>
		  		
		  		<div class="inline-group">
		  			<label>場地配置：</label>
		  			<textarea rows="2" cols="55" name="foodNote" >${groupSetting.foodNote }</textarea>
		  		</div>
		  		<div class="panel panel-default">
					<div class="panel-heading">流程計畫</div>
					<div class="panel-body">
						<div id="groupSettingPlanDataGrid"></div>
					</div>
				</div>
		  		
		  	</div> --%>
		  	
	  </div>
       
		<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
          </form>
        
        
        
        
    
    
    
</body>
</html>