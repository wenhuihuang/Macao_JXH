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
	       var courseDetailDataGrid;
        
	
	
	
    //課程詳情
	function bindingCourseSettingDetailDataGrid(){
	
	var groupSettingBudgetDataGridColumn = [
								{ display: 'budgetID', name: 'budgetID', hide:true },
			                    { display: '活動編號', name: 'actNO', width: 100,type:"text",editor: { type: 'text' }},
			                    { display: '項目', name: 'actName', width: 100 ,type:"text",editor: { type: 'text'}},
			                    { display: '費用/人', name: 'pay',width:300, type:"text", editor: { type: 'text'}},
			                    { display: '人數', name: 'qty',width:300, type:"text", editor: { type: 'text'}},
			                    { display: '支出', name: 'expenditure',width:300, type:"text", editor: { type: 'text'}}
			                  ];
			
			
	var courseSettingDetailDataGridToolBar = [
          { text: '新增', click: addCourseSettingDetailData, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteCourseSettingDetailData, icon: 'delete' , id:"delete" }];
	
	var url = "CourseSetting/getCourseSettingDetail.do?courseID="+$("#courseID").val();
	
	courseSettingDetailDataGrid = ligerGrid("courseSettingDetailDataGrid",null,courseSettingDetailDataGridColumn,url,courseSettingDetailDataGridToolBar,false,true);
	
	}
	function addCourseSettingDetailData(){
		courseSettingDetailDataGrid.addRow();
	}
	function deleteCourseSettingDetailData(){
		courseSettingDetailDataGrid.deleteSelectedRow();
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
		  	<div tabid="groupSettingGrid" title="課程設置">
		  		<div class="inline-group">
		  			<label>課程編號：</label>
		  			<input width="120px" value="${courseSetting.courseNO }" name="courseNO" type="text" ltype="text" />
		  			<label>課程名稱：</label>
		  			<input width="120px" value="${courseSetting.courseName }" name="courseName" type="text" ltype="text" />
		  			<label>學費：</label>
		  			<input width="120px" value="${courseSetting.pay }" name="pay" type="text" ltype="text" />
		  		</div>
		  		<div class="inline-group">
		  			<label>開始日期：</label>
		  			<input width="120px" value="${courseSetting.beginDate_str }" name="beginDate" type="text" ltype="date" />
		  			<label>結束日期：</label>
		  			<input width="120px" value="${courseSetting.endDate_str }" name="endDate" type="text" ltype="date" />
		  			<label>名額限制：</label>
		  			<input width="120px" value="${courseSetting.qty }" name="qty" type="text" ltype="text" />
		  		</div>
		  		<div class="panel panel-default">
					<div class="panel-heading"></div>
					<div class="panel-body">
						<div id="courseDetailDataGrid"></div>
					</div>
				</div>
		  		
		  	</div>
		  	
	  </div>
       
		<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
          </form>
        
        
        
        
    
    
    
</body>
</html>