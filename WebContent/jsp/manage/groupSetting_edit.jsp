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
	       var groupSettingBudgetDataGrid,
	        	groupSettingPlanDataGrid;
        
	
	
	
    //設置預計
	function bindingGroupSettingBudgetDataGrid(){
	
	var groupSettingBudgetDataGridColumn = [
								{ display: 'budgetID', name: 'budgetID', hide:true },
			                    { display: '活動編號', name: 'actNO', minWidth: 120,type:"text",editor: { type: 'text' }},
			                    { display: '項目', name: 'actName', minWidth: 120 ,type:"text",editor: { type: 'text'}},
			                    { display: '費用/人', name: 'pay',minWidth:120, type:"text", editor: { type: 'float'}},
			                    { display: '人數', name: 'qty',minWidth:120, type:"text", editor: { type: 'int'}},
			                    { display: '支出', name: 'expenditure',minWidth:120, type:"text", editor: { type: 'float'}}
			                  ];
			
			
	var groupSettingBudgetDataGridToolBar = [
          { text: '新增', click: addGroupSettingBudgetData, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteGroupSettingBudgetData, icon: 'delete' , id:"delete" }];
	
	var url = "GroupSetting/getGroupSettingBudget.do?gSID="+$("#gSID").val();
	
	groupSettingBudgetDataGrid = ligerGrid("groupSettingBudgetDataGrid",null,groupSettingBudgetDataGridColumn,url,groupSettingBudgetDataGridToolBar,false,true);
	
	}
	function addGroupSettingBudgetData(){
		groupSettingBudgetDataGrid.addRow();
	}
	function deleteGroupSettingBudgetData(){
		groupSettingBudgetDataGrid.deleteSelectedRow();
	}
	
	//設置計畫
	function bindingGroupSettingPlanDataGrid(){
	
	var groupSettingPlanDataGridColumn = [
								{ display: 'planID', name: 'planID', hide:true },
			                    { display: '活動編號', name: 'actNO', type:"text",minWidth:120,editor: { type: 'text' }},
			                    { display: '活動名稱', name: 'actName', type:"text",minWidth:120,editor: { type: 'text'}},
			                    { display: '日期', name: 'billDate', minWidth: 120 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
			                    { display: '時間', name: 'time',type:"text",minWidth:120, editor: { type: 'text'}},
			                    { display: '活動流程', name: 'process',type:"text",minWidth:120, editor: { type: 'text'}},
			                    { display: '備註', name: 'note',type:"text",minWidth:120, editor: { type: 'text'}}
			                  ];
			
			
	var groupSettingPlanDataGridToolBar = [
          { text: '新增', click: addGroupSettingPlanData, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteGroupSettingPlanData, icon: 'delete' , id:"delete" }];
	
	var url = "GroupSetting/getGroupSettingPlan.do?gSID="+$("#gSID").val();
	
	groupSettingPlanDataGrid = ligerGrid("groupSettingPlanDataGrid",null,groupSettingPlanDataGridColumn,url,groupSettingPlanDataGridToolBar,false,true);
	
	}
	function addGroupSettingPlanData(){
		groupSettingPlanDataGrid.addRow();
	}
	function deleteGroupSettingPlanData(){
		groupSettingPlanDataGrid.deleteSelectedRow();
	}
	
	function itemclick(item){
		switch (item.id){
			case "save":
				save();
			break;
			case "back":
				location.href="jsp/manage/groupSetting_list.jsp";
			break;
		}
		
	}
	
	function save(){
 		$("#groupSettingBudgetAdds").val(getAddedRows(groupSettingBudgetDataGrid));
 		$("#groupSettingBudgetUpdates").val(getEditedRows(groupSettingBudgetDataGrid));
 		$("#groupSettingBudgetDeletes").val(getDeletedRows(groupSettingBudgetDataGrid));
 		$("#groupSettingPlanAdds").val(getAddedRows(groupSettingPlanDataGrid));
 		$("#groupSettingPlanUpdates").val(getEditedRows(groupSettingPlanDataGrid));
 		$("#groupSettingPlanDeletes").val(getDeletedRows(groupSettingPlanDataGrid));
		$("#Button1").click();	
	}
    
	$(function(){
		if($("#gSID").val() != "" && $("#gSID").val() != 'null' && $("#gSID").val() != 'undefined'){
			setTabTitle(parent.$("#framecenter"),"小組設置編輯")
		}else{
			setTabTitle(parent.$("#framecenter"),"小組設置新增")
		}
		
		$(".toptoolbar").ligerToolBar({ items: [
            { text: '保存', click: itemclick, icon: 'save' , id:"save" },
            { line: true },
            { text: '取消', click: itemclick, icon: 'back' , id:"back" }
          ]
          });
		
		
		ligerForm("form1");
		bindingGroupSettingBudgetDataGrid();
		bindingGroupSettingPlanDataGrid();
	 $("#tab").ligerTab({onAfterSelectTabItem:function(targettabid){
			switch(targettabid){
				case "groupSettingGrid":
						showGridInTab(groupSettingBudgetDataGrid);
						showGridInTab(groupSettingPlanDataGrid);
					break;
				default:break;
			}
		}}); 
		
    })
        
    </script>
</head>
<body>
	<div class="toptoolbar"></div>
	<form name="form1" class="liger-form" method="post" action="GroupSetting/submit.do" id="form1" style="margin: 20px;">
	<input type="hidden" name="gSID" id="gSID" value="${groupSetting.gSID }">
	<input type="hidden" name="groupSettingBudgetAdds" id="groupSettingBudgetAdds">
	<input type="hidden" name="groupSettingBudgetUpdates" id="groupSettingBudgetUpdates">
	<input type="hidden" name="groupSettingBudgetDeletes" id="groupSettingBudgetDeletes">
	<input type="hidden" name="groupSettingPlanAdds" id="groupSettingPlanAdds">
	<input type="hidden" name="groupSettingPlanUpdates" id="groupSettingPlanUpdates">
	<input type="hidden" name="groupSettingPlanDeletes" id="groupSettingPlanDeletes">
	
	
	
	<div id="tab">
		  	<div tabid="groupSettingGrid" title="小組設置" class="label-width-90">
		  		<div style="padding:8px 0;">
		  				<div class="inline-group">
				  			<label>小組編號：</label>
				  			<input width="120px" value="${groupSetting.gSNO }" name="gSNO" type="text" ltype="text" />
				  			<label>負責人：</label>
				  			<input width="120px" value="${groupSetting.handler }" name="handler" type="text" ltype="text" />
				  			<label>小組名稱：</label>
				  			<input width="120px" value="${groupSetting.groupName }" name="groupName" type="text" ltype="text" />
				  			<label>小組目標：</label>
				  			<input width="120px" value="${groupSetting.target }" name="target" type="text" ltype="text" />
				  		</div>
				  		<div class="inline-group">
				  			<label>開始日期：</label>
				  			<input width="120px" value="${groupSetting.beginDate_str }" name="beginDate" type="text" ltype="date" />
				  			<label>結束日期：</label>
				  			<input width="120px" value="${groupSetting.endDate_str }" name="endDate" type="text" ltype="date" />
				  			<label>帶領者：</label>
				  			<input width="120px" value="${groupSetting.leader }" name="leader" type="text" ltype="text" />
				  			<label>參與人數：</label>
				  			<input width="120px" style="text-align:left;" value="${groupSetting.qty }" name="qty" type="text" ltype="int" />
				  		</div>
				  		<div class="inline-group">
				  			<label>收費：</label>
				  			<input width="120px" style="text-align:left;" value="${groupSetting.toll }" name="toll" type="text" ltype="float" />
				  		</div>
				  		<div class="inline-group">
				  			<label>地點：</label>
				  			<textarea rows="2" cols="55" name="place" >${groupSetting.place }</textarea>
				  		</div>
				  		<div class="inline-group">
				  			<label>材料或設備：</label>
				  			<textarea rows="2" cols="55" name="device" >${groupSetting.device }</textarea>
				  		</div>
				  		<div class="inline-group">
				  			<label>參與學員：</label>
				  			<textarea rows="2" cols="55" name="custs" >${groupSetting.custs }</textarea>
				  		</div>
		  		</div>
		  			<div class="panel panel-default">
							<div class="panel-heading">預算</div>
							<div class="panel-body">
								<div id="groupSettingBudgetDataGrid"></div>
							</div>
						</div>
				  		
				  		<div class="inline-group">
				  			<label>場地配置：</label>
				  			<textarea rows="2" cols="55" name="configuration" >${groupSetting.configuration }</textarea>
				  		</div>
		  		<div class="panel panel-default">
					<div class="panel-heading">流程計畫</div>
					<div class="panel-body">
						<div id="groupSettingPlanDataGrid"></div>
					</div>
				</div>
		  		
		  	</div>
		  	
	  </div>
       
		<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
          </form>
        
        
        
        
    
    
    
</body>
</html>