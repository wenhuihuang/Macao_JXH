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
        var familyDataGrid,
        	schoolDataGrid,
        	cureDataGrid,
        	groupPlanDataGrid,
        	groupRecordDataGrid,
        	flowPlanDataGrid,
        	manifestationDataGrid;
        
        //家庭背景
		function bindingFamilyDataGrid(){
		var eduLevelData = [{eduLevel:1,text:'無 '},{eduLevel:2,text:'小學'},{eduLevel:3,text:'中學'},{eduLevel:4,text:'大學'}];
		
		var familyDataGridColumn = [
									{ display: 'familyID', name: 'familyID', hide:true },
				                    { display: '姓名', name: 'userName', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '關係', name: 'relationShip', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '年齡', name: 'age', width: 100 ,type:"text",editor: { type: 'text'}},
				                    { display: '教育程度', name: 'eduLevel',width:120
			                        	,editor: { type: 'select', data: eduLevelData, valueField: 'eduLevel' },
				                        render: function (item)
				                        {
				                        	return getGridSelectedData(eduLevelData[parseInt(item.eduLevel)-1]);
				                        }},
				                    { display: '職業', name: 'work', width: 150 ,type:"text",editor: { type: 'text'}},
				                    { display: '所說語言', name: 'language',width:300, type:"text", editor: { type: 'text'}},
				                    { display: '備註', name: 'note',width:300, type:"text", editor: { type: 'text'}}
				                  ];
				
				
		var familyDataGridToolBar = [
	          { text: '新增', click: addFamilyData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteFamilyData, icon: 'delete' , id:"delete" }];
		
		var url = "Treatment/getTreatmentFamily.do?treatmentID="+$("#treatmentID").val();
		
		familyDataGrid = ligerGrid("familyDataGrid",null,familyDataGridColumn,url,familyDataGridToolBar,false,true);
		
	}
	function addFamilyData(){
		familyDataGrid.addRow();
	}
	function deleteFamilyData(){
		familyDataGrid.deleteSelectedRow();
	}
	
	//學校資料
	function bindingSchoolDataGrid(){
		var schoolDataGridColumn = [
									{ display: 'schoolID', name: 'schoolID', hide:true },
				                    { display: '學校', name: 'schoolName', align: 'left',  width: 150 ,type:"text",editor: { type: 'text'}},
				                    { display: '開始日期', name: 'startDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '結束日期', name: 'endDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '級別', name: 'grade', width: 150 ,type:"text",editor: { type: 'text'}},
				                    { display: '備註', name: 'schoolNote', width: 150 ,type:"text",editor: { type: 'text'}}
				                  ];
				
				
		var schoolDataGridToolBar = [
	          { text: '新增', click: addSchoolData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteSchoolData, icon: 'delete' , id:"delete" }];
		
		var url = "Treatment/getBCustomerSchool.do?custID="+$("#custID").val();
		
		schoolDataGrid = ligerGrid("schoolDataGrid",null,schoolDataGridColumn,url,schoolDataGridToolBar,false,true);
		
	}
	function addSchoolData(){
		schoolDataGrid.addRow();
	}
	function deleteSchoolData(){
		schoolDataGrid.deleteSelectedRow();
	}
	
	//過去治療史
	function bindingCureDataGrid(){
		
		var cureDataGridColumn = [
									{ display: 'historyID', name: 'historyID', hide:true },
									{ display: '機構', name: 'org', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '開始日期', name: 'tStartDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '結束日期', name: 'tEndDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '服務內容', name: 'content', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '備註', name: 'tNote', width: 100,type:"text",editor: { type: 'text' }},
								];
				
				
		var cureDataGridToolBar = [
	          { text: '新增', click: addCureData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteCureData, icon: 'delete' , id:"delete" }];
		
		var url = "Treatment/getTreatmentHistory.do?custID="+$("#custID").val();
		
		cureDataGrid = ligerGrid("cureDataGrid",null,cureDataGridColumn,url,cureDataGridToolBar,false,true);
		
	}
	function addCureData(){
		cureDataGrid.addRow();
	}
	function deleteCureData(){
		cureDataGrid.deleteSelectedRow();
	}
	
	
	//小組訓練計畫
	function bindingGroupPlanDataGrid(){
		
		var groupPlanDataGridColumn = [
									{ display: 'GSID', name: 'GSID', hide:true },
				                    { display: '小組編號', name: 'GSNO', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '小組名稱', name: 'groupName', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '小組目標', name: 'target', width: 100 ,type:"text",editor: { type: 'text'}},
				                    { display: '負責人', name: 'handler', width: 100 ,type:"text",editor: { type: 'text'}},
				                    { display: '開始日期', name: 'beginDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '結束日期', name: 'endDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '備註', name: 'note',width:300, type:"text", editor: { type: 'text'}}
				                  ];
				
				
		var groupPlanDataGridToolBar = [
	          { text: '新增', click: addGroupPlanData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteGroupPlanData, icon: 'delete' , id:"delete" }];
		
		var url = "Treatment/getTreatmentGroupPlan.do?custID="+$("#custID").val();
		
		groupPlanDataGrid = ligerGrid("groupPlanDataGrid",null,groupPlanDataGridColumn,url,groupPlanDataGridToolBar,false,true);
		
	}
	function addGroupPlanData(){
		groupPlanDataGrid.addRow();
	}
	function deleteGroupPlanData(){
		groupPlanDataGrid.deleteSelectedRow();
	}
	
	//小組訓練記錄
	function bindingGroupRecordDataGrid(){
		
		var groupRecordDataGridColumn = [
									{ display: 'planID', name: 'planID', hide:true },
				                    { display: '小組編號', name: 'GSNO', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '訓練日期', name: 'beginDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '表現', name: 'performance',width:300, type:"text", editor: { type: 'text'}},
				                    { display: '備註', name: 'note',width:300, type:"text", editor: { type: 'text'}}
				                  ];
				
				
		var groupRecordDataGridToolBar = [
	          { text: '新增', click: addGroupRecordData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteGroupRecordData, icon: 'delete' , id:"delete" }];
		
		var url = "Treatment/getTreatmentGroupRecord.do?custID="+$("#custID").val();
		
		groupRecordDataGrid = ligerGrid("groupRecordDataGrid",null,groupRecordDataGridColumn,url,groupRecordDataGridToolBar,false,true);
		
	}
	function addGroupRecordData(){
		groupRecordDataGrid.addRow();
	}
	function deleteGroupRecordData(){
		groupRecordDataGrid.deleteSelectedRow();
	}
	
	//流程計畫
	function bindingFlowPlanDataGrid(){
		
		var flowPlanDataGridColumn = [
									{ display: 'planID', name: 'planID', hide:true },
				                    { display: '活動編號', name: 'actNO', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '活動名稱', name: 'actName', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '日期', name: 'billDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '時間', name: 'time',width:300, type:"text", editor: { type: 'text'}},
				                    { display: '活動流程', name: 'actDetail',width:300, type:"text", editor: { type: 'text'}},
				                    { display: '備註', name: 'note',width:300, type:"text", editor: { type: 'text'}}
				                  ];
				
				
		var flowPlanDataGridToolBar = [
	          { text: '新增', click: addFlowPlanData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteFlowPlanData, icon: 'delete' , id:"delete" }];
		
		var url = "Treatment/getTreatmentFlowPlan.do?trainingID="+$("#trainingID").val();
		
		flowPlanDataGrid = ligerGrid("flowPlanDataGrid",null,flowPlanDataGridColumn,url,flowPlanDataGridToolBar,false,true);
		
	}
	function addFlowPlanData(){
		flowPlanDataGrid.addRow();
	}
	function deleteFlowPlanData(){
		flowPlanDataGrid.deleteSelectedRow();
	}
	
	//員工試工表現
	function bindingManifestationDataGrid(){
		
		var manifestationDataGridColumn = [
								/* 	{ display: 'GSID', name: 'GSID', hide:true }, */
				                    { display: '日期', name: 'billDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '時間', name: 'time', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '當天安排', name: 'content',width:300, type:"text", editor: { type: 'text'}},
				                    { display: '學員表現', name: 'performance',width:300, type:"text", editor: { type: 'text'}},
				                    { display: '備註', name: 'note',width:300, type:"text", editor: { type: 'text'}}
				                  ];
				
				
		var manifestationDataGridToolBar = [
	          { text: '新增', click: addManifestationData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteManifestationData, icon: 'delete' , id:"delete" }];
		
		var url = "Treatment/getTreatmentManifestation.do?workID="+$("#workID").val();
		
		manifestationDataGrid = ligerGrid("manifestationDataGrid",null,manifestationDataGridColumn,url,manifestationDataGridToolBar,false,true);
		
	}
	function addManifestationData(){
		manifestationDataGrid.addRow();
	}
	function deleteManifestationData(){
		manifestationDataGrid.deleteSelectedRow();
	}
	
	function itemclick(item){
		switch (item.id){
			case "save":
				save();
			break;
			case "back":
				location.href="jsp/treatment/function_list.jsp";
			break;
		}
		
	}
	
	function save(){
		$("#treatmentFamilyAdds").val(getAddedRows(familyDataGrid));
 		$("#treatmentFamilyUpdates").val(getEditedRows(familyDataGrid));
 		$("#treatmentFamilyDeletes").val(getDeletedRows(familyDataGrid));
 		$("#bCustomerSchoolAdds").val(getAddedRows(schoolDataGrid));
 		$("#bCustomerSchoolUpdates").val(getEditedRows(schoolDataGrid));
 		$("#bCustomerSchoolDeletes").val(getDeletedRows(schoolDataGrid)); 
		$("#treatmentHistoryAdds").val(getAddedRows(cureDataGrid));
 		$("#treatmentHistoryUpdates").val(getEditedRows(cureDataGrid));
 		$("#treatmentHistoryDeletes").val(getDeletedRows(cureDataGrid)); 
 	 	$("#groupDetailAdds").val(getAddedRows(groupPlanDataGrid));//GroupDetail
 		$("#groupDetailUpdates").val(getEditedRows(groupPlanDataGrid));
 		$("#groupDetailDeletes").val(getDeletedRows(groupPlanDataGrid));  
  		$("#groupSettingRecordPerformanceAdds").val(getAddedRows(groupRecordDataGrid));//GroupSettingRecordPerformance
 		$("#groupSettingRecordPerformanceUpdates").val(getEditedRows(groupRecordDataGrid));
 		$("#groupSettingRecordPerformanceDeletes").val(getDeletedRows(groupRecordDataGrid));
 		$("#treatmentTrainingPlanAdds").val(getAddedRows(flowPlanDataGrid));//TreatmentTrainingPlan
 		$("#treatmentTrainingPlanUpdates").val(getEditedRows(flowPlanDataGrid));
 		$("#treatmentTrainingPlanDeletes").val(getDeletedRows(flowPlanDataGrid));  
 		$("#treatmentTrainingWorkRecordAdds").val(getAddedRows(manifestationDataGrid));//TreatmentTrainingWorkRecord
 		$("#treatmentTrainingWorkRecordUpdates").val(getEditedRows(manifestationDataGrid));
 		$("#treatmentTrainingWorkRecordDeletes").val(getDeletedRows(manifestationDataGrid));
 		checkboxValue(["disease","attack","temper","behavior"])
		$("#Button1").click();	
	}
    
	$(function(){
		if($("#treatmentID").val() != "" && $("#treatmentID").val() != 'null' && $("#treatmentID").val() != 'undefined'){
			setTabTitle(parent.$("#framecenter"),"職能訓練編輯")
		}else{
			setTabTitle(parent.$("#framecenter"),"職能訓練新增")
		}
		
		$(".toptoolbar").ligerToolBar({ items: [
            { text: '保存', click: itemclick, icon: 'save' , id:"save" },
            { line: true },
            { text: '取消', click: itemclick, icon: 'back' , id:"back" }
          ]
          });
		
		
		
		ligerForm("form1");
		bindingFamilyDataGrid();
		bindingSchoolDataGrid();
		bindingCureDataGrid();
		/* bindingPlanDataGrid(); */
		/* bindingRecordDataGrid(); */
		bindingGroupPlanDataGrid();
		bindingGroupRecordDataGrid();
		bindingFlowPlanDataGrid();
		bindingManifestationDataGrid();
		
	 $("#tab").ligerTab({onAfterSelectTabItem:function(targettabid){
			switch(targettabid){
				case "fn":
						showGridInTab(familyDataGrid);
						showGridInTab(schoolDataGrid);
						showGridInTab(cureDataGrid);
					break;
				case "groupTraining":
						showGridInTab(groupPlanDataGrid);
						showGridInTab(groupRecordDataGrid)
					break;
				case "ndividualTraining":
						showGridInTab(flowPlanDataGrid);
						//showGridInTab(flowPlanDataGrid);
					break;
				case "tryRecord":
						//showGridInTab(stateRecordDataGrid);
						showGridInTab(manifestationDataGrid);
					break;
				default:break;
			}
		}}); 
/* 	 $("#physicalAssess").ligerComboBox({
         width : 240,
         cancelable: false
     }); */
		
    })
        
    </script>
</head>
<body>
	<div class="toptoolbar"></div>
	<form name="form1" class="liger-form" method="post" action="Treatment/submit.do" id="form1" style="margin: 20px;">
	<input type="hidden" name="treatmentType" id="treatmentType" value="5">
	<input type="hidden" name="custID" id="custID" value="${treatmentPojo.custID }">
	<input type="hidden" name="treatmentID" id="treatmentID" value="${treatmentPojo.treatmentID }">
	<input type="hidden" name="trainingID" id="trainingID" value="${treatmentTraining.trainingID }">
	<input type="hidden" name="workID" id="workID" value="${treatmentTrainingWork.workID }">
	<input type="hidden" name="treatmentFamilyAdds" id="treatmentFamilyAdds">
	<input type="hidden" name="treatmentFamilyUpdates" id="treatmentFamilyUpdates">
	<input type="hidden" name="treatmentFamilyDeletes" id="treatmentFamilyDeletes">
	<input type="hidden" name="bCustomerSchoolAdds" id="bCustomerSchoolAdds">
	<input type="hidden" name="bCustomerSchoolUpdates" id="bCustomerSchoolUpdates">
	<input type="hidden" name="bCustomerSchoolDeletes" id="bCustomerSchoolDeletes">
	<input type="hidden" name="treatmentHistoryAdds" id="treatmentHistoryAdds">
	<input type="hidden" name="treatmentHistoryUpdates" id="treatmentHistoryUpdates">
	<input type="hidden" name="treatmentHistoryDeletes" id="treatmentHistoryDeletes">
	
	<input type="hidden" name="groupDetailAdds" id="groupDetailAdds">
	<input type="hidden" name="groupDetailUpdates" id="groupDetailUpdates">
	<input type="hidden" name="groupDetailDeletes" id="groupDetailDeletes">
	<input type="hidden" name="groupSettingRecordPerformanceAdds" id="groupSettingRecordPerformanceAdds">
	<input type="hidden" name="groupSettingRecordPerformanceUpdates" id="groupSettingRecordPerformanceUpdates">
	<input type="hidden" name="groupSettingRecordPerformanceDeletes" id="groupSettingRecordPerformanceDeletes">
	<input type="hidden" name="treatmentTrainingPlanAdds" id="treatmentTrainingPlanAdds">
	<input type="hidden" name="treatmentTrainingPlanUpdates" id="treatmentTrainingPlanUpdates">
	<input type="hidden" name="treatmentTrainingPlanDeletes" id="treatmentTrainingPlanDeletes">
	<input type="hidden" name="treatmentTrainingWorkRecordAdds" id="treatmentTrainingWorkRecordAdds">
	<input type="hidden" name="treatmentTrainingWorkRecordUpdates" id="treatmentTrainingWorkRecordUpdates">
	<input type="hidden" name="treatmentTrainingWorkRecordDeletes" id="treatmentTrainingWorkRecordDeletes">
	
	<input type="hidden" name="disease" id="disease">
	<input type="hidden" name="attack" id="attack">
	<input type="hidden" name="temper" id="temper">
	<input type="hidden" name="behavior" id="behavior">
	
	<div id="tab">
	<div title="職能訓練" tabid="fn">
	<table>
		<tbody>
            <tr>
            	<td align="right" class="l-table-edit-td">檔案編號：</td>
                <td align="left" class="l-table-edit-td">
                	<input width="120px" value="${customer.custCode }" name="custCode" type="text" ltype="text"">
                </td>
            
                <td align="right" class="l-table-edit-td">姓名：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.fullName }" name="fullName" type="text"  class="fullName"/></td>
                
                <td align="right" class="l-table-edit-td">會員編號：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.custNO }" name="custNO" type="text" id="custNO" /></td>
                
                <td align="right" class="l-table-edit-td">非會員編號：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.custNewNO }" name="custNewNO" type="text" id="custNewNO" /></td>
              </tr>
            <tr>
            	  <td align="right" class="l-table-edit-td">接案日期:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${custCasePojo.receiveDate_str }" name="receiveDate" type="text" ltype="date" />
				 </td>
				 
				 <td align="right" class="l-table-edit-td">輪候開始日期:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${treatmentPojo.awaitDate_str }" name="awaitDate" type="text" ltype="date" />
				 </td>
				  <td align="right" class="l-table-edit-td">評估日期:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${treatmentAssessPojo.assessDate_str }" name="assessDate" type="text" ltype="date" />
				 </td>
				   <td align="right" class="l-table-edit-td">個案狀態:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${custCasePojo.caseStatus }" name="caseStatus" type="text" id="caseStatus" ltype="text" />
				 </td>
			</tr>
			<tr>
				   <td align="right" class="l-table-edit-td">接案來源:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${custCasePojo.caseSource }" name="caseSource" type="text" id="caseSource" ltype="text" />
				 </td>
				   <td align="right" class="l-table-edit-td">接案社工:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${custCasePojo.caseWorker }" name="caseWorker" type="text" id="caseWorker" ltype="text" />
				 </td>
				    <td align="right" class="l-table-edit-td">健康狀況:</td>
				 <td align="left" class="l-table-edit-td">
				 	<textarea rows="2" cols="55" name="familySituation" id="familySituation">${treatmentPojo.sensoryNote }</textarea>
				 </td>
            </tr>
		</tbody>
	</table>
	<div>
	<table class="table-border input-style">
		<tbody>
			<tr>
				<td style="text-align:right">疾病：</td>
				<td>
					<p>
	  					<span style="display:inline-block;width:48px;text-align:right"></span>
  						<label><input type="checkbox" value="0" class="disease" <c:if test="${(treatmentPojo.disease).indexOf('0') != -1 }">checked="checked"</c:if>>癲癇</label>
         				<label><input type="checkbox" value="1"  class="disease" <c:if test="${(treatmentPojo.disease).indexOf('1') != -1 }">checked="checked"</c:if>>乙型肝炎 </label>
         			</p>
          			<p>
          				<span style="display:inline-block;width:48px;text-align:right"></span>
          				<label><input type="checkbox" value="2"  class="disease" <c:if test="${(treatmentPojo.disease).indexOf('2') != -1 }">checked="checked"</c:if>> 糖尿病 </label>
          				<label><input type="checkbox" value="3"  class="disease" <c:if test="${(treatmentPojo.disease).indexOf('3') != -1 }">checked="checked"</c:if>>心臟病</label>
          			</p>
          			<p>
          				<span style="display:inline-block;width:48px;text-align:right"></span>
          				<label><input type="checkbox" value="4"  class="disease" <c:if test="${(treatmentPojo.disease).indexOf('4') != -1 }">checked="checked"</c:if>> 高血壓 </label>
         				<label><input type="checkbox" value="5"  class="disease" <c:if test="${(treatmentPojo.disease).indexOf('5') != -1 }">checked="checked"</c:if>>氣喘  </label>
         			</p>
         			<p>
         				<span style="display:inline-block;width:48px;text-align:right">其他</span>
         				<textarea rows="2" cols="55" name="diseaseOther" id="diseaseOther">${treatmentPojo.diseaseOther }</textarea>
         			</p>
         			<p>
         				<span style="display:inline-block;width:48px;text-algin:right">遺傳疾病</span>
         				<textarea rows="2" cols="55" name="diseaseHeredity" id="diseaseHeredity">${treatmentPojo.diseaseHeredity }</textarea>
         			</p>
				</td>
				<td style="text-align:right">過敏反應：</td>
				<td>
					<p>
         				<span style="display:inline-block;width:48px;text-align:right">食物</span>
         				<textarea rows="2" cols="55" name="allergyFood" id="allergyFood">${treatmentPojo.allergyFood }</textarea>
         			</p>
         			<p>
         				<span style="display:inline-block;width:48px;text-align:right">藥物</span>
         				<textarea rows="2" cols="55" name="allergyDrug" id="allergyDrug">${treatmentPojo.allergyDrug }</textarea>
         			</p>
         			<p>
         				<span>其他</span>
         				<textarea rows="2" cols="55" name="allergyOther" id="allergyOther">${treatmentPojo.allergyOther }</textarea>
         			</p>
				</td>
			</tr>
			<tr>
				<td style="text-align:right">藥時間：</td>
				<td>
					<p>
   						<span style="height:16px"></span>
	 					<select name="serviceStatus" id="serviceStatus" ltype="select" width="120px" >
	                		<option value="0" <c:if test="${treatmentPojo.medication == '0' }">selected="selected"</c:if> >沒有</option>
	                		<option value="1" <c:if test="${treatmentPojo.medication == '1' }">selected="selected"</c:if> >間歇性服藥</option>
	                		<option value="2" <c:if test="${treatmentPojo.medication == '2' }">selected="selected"</c:if> >持續性服藥</option>
	                		<option value="3" <c:if test="${treatmentPojo.medication == '3' }">selected="selected"</c:if> >三餐前</option>
	                		<option value="4" <c:if test="${treatmentPojo.medication == '4' }">selected="selected"</c:if> >三餐後</option>
	                		<option value="5" <c:if test="${treatmentPojo.medication == '5' }">selected="selected"</c:if> >早</option>
	                		<option value="6" <c:if test="${treatmentPojo.medication == '6' }">selected="selected"</c:if> >午</option>
	                		<option value="7" <c:if test="${treatmentPojo.medication == '7' }">selected="selected"</c:if> >晚</option>
	                	</select> 
   					</p>
         			<p>
         				<span style="display:inline-block;width:48px;text-align:right">其他</span>
         				<textarea rows="2" cols="55" name="medicationNote" id="medicationNote">${treatmentPojo.medicationNote }</textarea>
         			</p>
				</td>
				<td style="text-align:right">病史：</td>
				<td>
					<p>
         				<span style="display:inline-block;width:48px;text-align:right"></span>
         				<textarea rows="2" cols="55" name="history" id="history">${treatmentPojo.history }</textarea>
         			</p>
				</td>
			</tr>
		</tbody>
	</table>
	</div>
	
				 	<div class="panel panel-default">
							<div class="panel-heading">語言運用</div>
							<div class="panel-body">
									<table class="table-center table-edit" border="1" >
				            		<thead>
				            			<tr>
				            				<th height="28px" width="120px">語言</th>
				            				<th width="25%">講</th>
				            				<th width="25%">讀</th>
				            				<th width="25%">聽</th>
				            				<th>寫</th>
				            			</tr>
				            		</thead>
				            		<tbody>
				            			<tr>
				            				<th>廣東話</th>
				            				<td>
				            					<select name="sCantonese" id="sCantonese" ltype="select" width="120px" >
							                		<option value="0" <c:if test="${treatmentPojo.sCantonese == '0' }">selected="selected"</c:if> >完全不懂（0）</option>
							                		<option value="1" <c:if test="${treatmentPojo.sCantonese == '1' }">selected="selected"</c:if> >以單字表達意思（1）</option>
							                		<option value="2" <c:if test="${treatmentPojo.sCantonese == '2' }">selected="selected"</c:if> >以單句表達意思（2）</option>
							                		<option value="3" <c:if test="${treatmentPojo.sCantonese == '3' }">selected="selected"</c:if> >能表達完整的意思（3）</option>
							                	</select> 
				            				</td>
				            				<td>
				            					<select name="rCantonese" id="rCantonese" ltype="select" width="120px" >
							                		<option value="0" <c:if test="${treatmentPojo.rCantonese == '0' }">selected="selected"</c:if> >完全不懂（0）</option>
							                		<option value="1" <c:if test="${treatmentPojo.rCantonese == '1' }">selected="selected"</c:if> >能閱讀及臨摹單詞（1）</option>
							                		<option value="2" <c:if test="${treatmentPojo.rCantonese == '2' }">selected="selected"</c:if> >能閱讀及臨摹一條學員守則（2）</option>
							                		<option value="3" <c:if test="${treatmentPojo.rCantonese == '3' }">selected="selected"</c:if> >能閱讀及臨摹部分學員守則（3）</option>
							                	</select> 
				            				</td>
				            				<td>
				            					<select name="lCantonese" id="lCantonese" ltype="select" width="120px" >
							                		<option value="0" <c:if test="${treatmentPojo.lCantonese == '0' }">selected="selected"</c:if> >完全不懂（0）</option>
							                		<option value="1" <c:if test="${treatmentPojo.lCantonese == '1' }">selected="selected"</c:if> >以單字表達意思（1）</option>
							                		<option value="2" <c:if test="${treatmentPojo.lCantonese == '2' }">selected="selected"</c:if> >以單句表達意思（2）</option>
							                		<option value="3" <c:if test="${treatmentPojo.lCantonese == '3' }">selected="selected"</c:if> >能表達完整的意思（3）</option>
							                	</select> 
				            				</td>
				            				<td>
				            					<select name="wCantonese" id="wCantonese" ltype="select" width="120px" >
							                		<option value="0" <c:if test="${treatmentPojo.wCantonese == '0' }">selected="selected"</c:if> >完全不懂（0）</option>
							                		<option value="1" <c:if test="${treatmentPojo.wCantonese == '1' }">selected="selected"</c:if> >能閱讀及臨摹單詞（1）</option>
							                		<option value="2" <c:if test="${treatmentPojo.wCantonese == '2' }">selected="selected"</c:if> >能閱讀及臨摹一條學員守則（2）</option>
							                		<option value="3" <c:if test="${treatmentPojo.wCantonese == '3' }">selected="selected"</c:if> >能閱讀及臨摹部分學員守則（3）</option>
							                	</select> 
				            				</td>
				            			</tr>
				            			<tr>
				            				<th>普通話</th>
				            				<td>
				            					<select name="sMandarin" id="sMandarin" ltype="select" width="120px" >
							                		<option value="0" <c:if test="${treatmentPojo.sMandarin == '0' }">selected="selected"</c:if> >完全不懂（0）</option>
							                		<option value="1" <c:if test="${treatmentPojo.sMandarin == '1' }">selected="selected"</c:if> >以單字表達意思（1）</option>
							                		<option value="2" <c:if test="${treatmentPojo.sMandarin == '2' }">selected="selected"</c:if> >以單句表達意思（2）</option>
							                		<option value="3" <c:if test="${treatmentPojo.sMandarin == '3' }">selected="selected"</c:if> >能表達完整的意思（3）</option>
							                	</select> 
				            				</td>
				            				<td>
				            					<select name="rMandarin" id="rMandarin" ltype="select" width="120px" >
              										<option value="0" <c:if test="${treatmentPojo.rMandarin == '0' }">selected="selected"</c:if> >完全不懂（0）</option>
							                		<option value="1" <c:if test="${treatmentPojo.rMandarin == '1' }">selected="selected"</c:if> >能閱讀及臨摹單詞（1）</option>
							                		<option value="2" <c:if test="${treatmentPojo.rMandarin == '2' }">selected="selected"</c:if> >能閱讀及臨摹一條學員守則（2）</option>
							                		<option value="3" <c:if test="${treatmentPojo.rMandarin == '3' }">selected="selected"</c:if> >能閱讀及臨摹部分學員守則（3）</option>
							                	</select> 
				            				</td>
				            				<td>
				            					<select name="lMandarin" id="lMandarin" ltype="select" width="120px" >
							              			<option value="0" <c:if test="${treatmentPojo.lMandarin == '0' }">selected="selected"</c:if> >完全不懂（0）</option>
							                		<option value="1" <c:if test="${treatmentPojo.lMandarin == '1' }">selected="selected"</c:if> >以單字表達意思（1）</option>
							                		<option value="2" <c:if test="${treatmentPojo.lMandarin == '2' }">selected="selected"</c:if> >以單句表達意思（2）</option>
							                		<option value="3" <c:if test="${treatmentPojo.lMandarin == '3' }">selected="selected"</c:if> >能表達完整的意思（3）</option>
							                	</select> 
				            				</td>
				            				<td>
				            					<select name="wMandarin" id="wMandarin" ltype="select" width="120px" >
							             			<option value="0" <c:if test="${treatmentPojo.wMandarin == '0' }">selected="selected"</c:if> >完全不懂（0）</option>
							                		<option value="1" <c:if test="${treatmentPojo.wMandarin == '1' }">selected="selected"</c:if> >能閱讀及臨摹單詞（1）</option>
							                		<option value="2" <c:if test="${treatmentPojo.wMandarin == '2' }">selected="selected"</c:if> >能閱讀及臨摹一條學員守則（2）</option>
							                		<option value="3" <c:if test="${treatmentPojo.wMandarin == '3' }">selected="selected"</c:if> >能閱讀及臨摹部分學員守則（3）</option>
							                	</select> 
				            				</td>
				            			</tr>
				            			<tr>
				            				<th>其他</th>
				            				<td colspan="4"><input value="${treatmentPojo.sRLWOther }" name="sRLWOther" type="text" id="sRLWOther" ltype="text" /></td>
				            			</tr>
				            		</tbody>
				            		</table>
							</div>
						</div> 		
			        
			        <div id="" style="height:auto;overflow:auto;">
			        	<div class="panel panel-default">
							<div class="panel-heading">家庭背景資料</div>
							<div class="panel-body">
							    <div id="familyDataGrid"></div>
							    <div class="inline-group">
							    	<label>家庭狀況：</label>
							    	<textarea rows="2" cols="55" name="familySituation" id="familySituation">${treatmentPojo.familySituation }</textarea>
							   		<%-- <input width="120px" value="${treatmentPojo.familySituation }" name="familySituation" type="text" id="familySituation" ltype="text" /> --%>
							    </div>
							</div>
						</div>
		               
		            </div>
		            
		            	<div class="panel panel-default">
		            		<div class="panel-heading">身體背景資料</div>
		            		<div class="panel-body">
		            			<table class="table-center table-edit" border="1">
				            		<thead>
				            			<tr>
				            				<th height="28px" width="120px">項目</th>
				            				<th width="120px">是否做過評估</th>
				            				<th width="120px">程度</th>
				            				<th width="140px">評估時間</th>
				            				<th>評估地點</th>
				            				<th>評估描述</th>
				            				<th>&nbsp;&nbsp;備註&nbsp;&nbsp;</th>
				            			</tr>
				            		</thead>
				            		<tbody>
				            			<tr>
				            				<th>體能</th>
				            				<td>
				            					<select name="physicalAssess" id="physicalAssess" ltype="select" width="120px" >
							                		<option value="0" <c:if test="${treatmentPojo.physicalAssess != '1' }">selected="selected"</c:if> >是</option>
							                		<option value="1" <c:if test="${treatmentPojo.physicalAssess == '1' }">selected="selected"</c:if> >否</option>
							                	</select> 
				            					<%-- <input value="${treatmentPojo.physicalAssess }" name="physicalAssess" type="text" id="physicalAssess" ltype="text" /> --%>
				            				</td>
				            				<td>
				            					<select name="physicalLevel" id="physicalLevel" ltype="select" width="120px" >
							                		<option value="0" <c:if test="${treatmentPojo.physicalLevel != '1' and treatmentPojo.physicalLevel != '2'}">selected="selected"</c:if> >正常</option>
							                		<option value="1" <c:if test="${treatmentPojo.physicalLevel == '1' }">selected="selected"</c:if> >遲緩</option>
							                		<option value="2" <c:if test="${treatmentPojo.physicalLevel == '2' }">selected="selected"</c:if> >障礙</option>
							                	</select> 
				            					<%-- <input value="${treatmentPojo.physicalLevel }" name="physicalLevel" type="text" id="physicalLevel" ltype="text" /> --%>
				            				</td>
				            				<td><input value="${treatmentPojo.physicalDate_str }" name="physicalDate" type="text" id="physicalDate" ltype="date" /></td>
				            				<td><input value="${treatmentPojo.physicalPlace }" name="physicalPlace" type="text" id="physicalPlace" ltype="text" /></td>
				            				<td><input value="${treatmentPojo.physicalDescribe }" name="physicalDescribe" type="text" id="physicalDescribe" ltype="text" /></td>
				            				<td><input value="${treatmentPojo.physicalNote }" name="physicalNote" type="text" id="physicalNote" ltype="text" /></td>
				            			</tr>
				            			<tr>
				            				<th>視力</th>
				            				<td>
				            					<select name="visionAssess" id="visionAssess" ltype="select" width="120px" >
							                		<option value="0" <c:if test="${treatmentPojo.visionAssess != '1' }">selected="selected"</c:if> >是</option>
							                		<option value="1" <c:if test="${treatmentPojo.visionAssess == '1' }">selected="selected"</c:if> >否</option>
							                	</select> 
				            				</td>
				            				<td>
				            					<select name="visionLevel" id="visionLevel" ltype="select" width="120px" >
							                		<option value="0" <c:if test="${treatmentPojo.visionLevel != '1' and treatmentPojo.visionLevel != '2'}">selected="selected"</c:if> >正常</option>
							                		<option value="1" <c:if test="${treatmentPojo.visionLevel == '1' }">selected="selected"</c:if> >遲緩</option>
							                		<option value="2" <c:if test="${treatmentPojo.visionLevel == '2' }">selected="selected"</c:if> >障礙</option>
							                	</select> 
				            				</td>
				            				<td><input value="${treatmentPojo.visionDate_str }" name="visionDate" type="text" id="physicavisionDatelDate" ltype="date" /></td>
				            				<td><input value="${treatmentPojo.visionPlace }" name="visionPlace" type="text" id="visionPlace" ltype="text" /></td>
				            				<td><input value="${treatmentPojo.visionDescribe }" name="visionDescribe" type="text" id="visionDescribe" ltype="text" /></td>
				            				<td><input value="${treatmentPojo.visionNote }" name="visionNote" type="text" id="visionNote" ltype="text" /></td>
				            			</tr>
				            			<tr>
				            				<th>聽力</th>
				            				<td>
				            					<select name="hearingAssess" id="hearingAssess" ltype="select" width="120px" >
							                		<option value="0" <c:if test="${treatmentPojo.hearingAssess != '1' }">selected="selected"</c:if> >是</option>
							                		<option value="1" <c:if test="${treatmentPojo.hearingAssess == '1' }">selected="selected"</c:if> >否</option>
							                	</select> 
				            				</td>
				            				<td>
				            					<select name="hearingLevel" id="hearingLevel" ltype="select" width="120px" >
							                		<option value="0" <c:if test="${treatmentPojo.hearingLevel != '1' and treatmentPojo.hearingLevel != '2'}">selected="selected"</c:if> >正常</option>
							                		<option value="1" <c:if test="${treatmentPojo.hearingLevel == '1' }">selected="selected"</c:if> >遲緩</option>
							                		<option value="2" <c:if test="${treatmentPojo.hearingLevel == '2' }">selected="selected"</c:if> >障礙</option>
							                	</select> 
				            				</td>
				            				<td><input value="${treatmentPojo.hearingDate_str }" name="hearingDate" type="text" id="hearingDate" ltype="date" /></td>
				            				<td><input value="${treatmentPojo.hearingPlace }" name="hearingPlace" type="text" id="hearingPlace" ltype="text" /></td>
				            				<td><input value="${treatmentPojo.hearingDescribe }" name="hearingDescribe" type="text" id="hearingDescribe" ltype="text" /></td>
				            				<td><input value="${treatmentPojo.hearingNote }" name="hearingNote" type="text" id="hearingNote" ltype="text" /></td>
				            			
				            			</tr>
				            			<tr>
				            				<th>智力</th>
				            				<td>
				            					<select name="iQAssess" id="iQAssess" ltype="select" width="120px" >
							                		<option value="0" <c:if test="${treatmentPojo.iQAssess != '1' }">selected="selected"</c:if> >是</option>
							                		<option value="1" <c:if test="${treatmentPojo.iQAssess == '1' }">selected="selected"</c:if> >否</option>
							                	</select> 
				            				</td>
				            				<td>
				            					<select name="iQLevel" id="iQLevel" ltype="select" width="120px" >
							                		<option value="0" <c:if test="${treatmentPojo.iQLevel != '1' and treatmentPojo.iQLevel != '2'}">selected="selected"</c:if> >正常</option>
							                		<option value="1" <c:if test="${treatmentPojo.iQLevel == '1' }">selected="selected"</c:if> >遲緩</option>
							                		<option value="2" <c:if test="${treatmentPojo.iQLevel == '2' }">selected="selected"</c:if> >障礙</option>
							                	</select> 
				            				</td>
				            				<td><input value="${treatmentPojo.iQDate_str }" name="iQDate" type="text" id="iQDate" ltype="date" /></td>
				            				<td><input value="${treatmentPojo.iQPlace }" name="iQPlace" type="text" id="iQPlace" ltype="text" /></td>
				            				<td><input value="${treatmentPojo.iQDescribe }" name="iQDescribe" type="text" id="iQDescribe" ltype="text" /></td>
				            				<td><input value="${treatmentPojo.iQNote }" name="iQNote" type="text" id="iQNote" ltype="text" /></td>
				            			
				            			</tr>
				            			<tr>
				            				<th>言語</th>
				            				<td>
				            					<select name="speechAssess" id="speechAssess" ltype="select" width="120px" >
							                		<option value="0" <c:if test="${treatmentPojo.speechAssess != '1' }">selected="selected"</c:if> >是</option>
							                		<option value="1" <c:if test="${treatmentPojo.speechAssess == '1' }">selected="selected"</c:if> >否</option>
							                	</select> 
				            				</td>
				            				<td>
				            					<select name="iQLevel" id="iQLevel" ltype="select" width="120px" >
							                		<option value="0" <c:if test="${treatmentPojo.speechLevel != '1' and treatmentPojo.speechLevel != '2'}">selected="selected"</c:if> >正常</option>
							                		<option value="1" <c:if test="${treatmentPojo.speechLevel == '1' }">selected="selected"</c:if> >遲緩</option>
							                		<option value="2" <c:if test="${treatmentPojo.speechLevel == '2' }">selected="selected"</c:if> >障礙</option>
							                	</select> 
				            				</td>
				            				<td><input value="${treatmentPojo.speechDate_str }" name="speechDate" type="text" id="speechDate" ltype="date" /></td>
				            				<td><input value="${treatmentPojo.speechPlace }" name="speechPlace" type="text" id="speechPlace" ltype="text" /></td>
				            				<td><input value="${treatmentPojo.speechDescribe }" name="speechDescribe" type="text" id="speechDescribe" ltype="text" /></td>
				            				<td><input value="${treatmentPojo.speechNote }" name="speechNote" type="text" id="speechNote" ltype="text" /></td>
				            			
				            			</tr>
				            			<tr>
				            				<th>行為情緒</th>
				            				<td>
				            					<select name="behaviorAssess" id="behaviorAssess" ltype="select" width="120px" >
							                		<option value="0" <c:if test="${treatmentPojo.behaviorAssess != '1' }">selected="selected"</c:if> >是</option>
							                		<option value="1" <c:if test="${treatmentPojo.behaviorAssess == '1' }">selected="selected"</c:if> >否</option>
							                	</select> 
				            				</td>
				            				<td>
				            					<select name="iQLevel" id="iQLevel" ltype="select" width="120px" >
							                		<option value="0" <c:if test="${treatmentPojo.behaviorLevel != '1' and treatmentPojo.behaviorLevel != '2'}">selected="selected"</c:if> >正常</option>
							                		<option value="1" <c:if test="${treatmentPojo.behaviorLevel == '1' }">selected="selected"</c:if> >遲緩</option>
							                		<option value="2" <c:if test="${treatmentPojo.behaviorLevel == '2' }">selected="selected"</c:if> >障礙</option>
							                	</select> 
				            				</td>
				            				<td><input value="${treatmentPojo.behaviorDate_str }" name="behaviorDate" type="text" id="behaviorDate" ltype="date" /></td>
				            				<td><input value="${treatmentPojo.behaviorPlace }" name="behaviorPlace" type="text" id="behaviorPlace" ltype="text" /></td>
				            				<td><input value="${treatmentPojo.behaviorDescribe }" name="behaviorDescribe" type="text" id="behaviorDescribe" ltype="text" /></td>
				            				<td><input value="${treatmentPojo.behaviorNote }" name="behaviorNote" type="text" id="behaviorNote" ltype="text" /></td>
				            			</tr>
				            		</tbody>
				            	</table>
				            	<div>
				            		<div class="inline-group">
				            			<label>其他：</label>
				                		<textarea rows="2" cols="55" name="others" id="others">${treatmentPojo.others }</textarea>
				            		</div>
				                </div>
		            		</div>
		            	</div>
			            
		            
		            <div id="school_tab" style="height:auto;overflow:auto;">
		            	<div class="panel panel-default">
		            		<div class="panel-heading">曾讀學校資料</div>
		            		<div class="panel-body">
		            			<div id="schoolDataGrid"></div>
		            		</div>
		            	</div>
		            </div>
		            
		            <div id="cure_tab" style="height:auto;overflow:auto;">
		            	<div class="panel panel-default">
		            		<div class="panel-heading">曾接受機構服務資料</div>
		            		<div class="panel-body">
		            			<div id="cureDataGrid"></div>
		            			
		            		</div>
		            	</div>
		            </div>
		            <div class="panel panel-default">
	            		<div class="panel-heading">適應技能方面：(評估分數為1-5分，1分最低，5分最高)</div>
	            		<div class="panel-body">
	            				<table class="table-edit" border="1">
				            		<thead>
				            			<tr>
				            				<th height="28px" width="120px" style="text-align:center">項目</th>
				            				<th width="70%" style="text-align:center">說明</th>
				            				<th width="" style="text-align:center">能力程度</th>
				            			</tr>
				            		</thead>
				            		<tbody>
				            			<tr>
				            				<th>1.溝通</th>
				            				<td>
				            					透過語言或／與非語言方式表達與交換資訊
				            				</td>
				            				<td>
				            					<select name="communicationLevel" id="communicationLevel" ltype="select" width="120px" >
							                		<option value="1" <c:if test="${treatmentPojo.communicationLevel == '1' }">selected="selected"</c:if> >1分</option>
							                		<option value="2" <c:if test="${treatmentPojo.communicationLevel == '2' }">selected="selected"</c:if> >2分</option>
							                		<option value="3" <c:if test="${treatmentPojo.communicationLevel == '3' }">selected="selected"</c:if> >3分</option>
							                		<option value="4" <c:if test="${treatmentPojo.communicationLevel == '4' }">selected="selected"</c:if> >4分</option>
							                		<option value="5" <c:if test="${treatmentPojo.communicationLevel == '5' }">selected="selected"</c:if> >5分</option>
							                	</select> 
				            				</td>
				            			</tr>
				            			<tr>
				            				<th>2.自我照顧</th>
				            				<td>
				            					指生活自理能力，包括飲食、穿衣、如廁、個人衛生儀容等方面的能力
				            				</td>
				            				<td>
				            					<select name="selfLevel" id="selfLevel" ltype="select" width="120px" >
							                		<option value="1" <c:if test="${treatmentPojo.selfLevel == '1' }">selected="selected"</c:if> >1分</option>
							                		<option value="2" <c:if test="${treatmentPojo.selfLevel == '2' }">selected="selected"</c:if> >2分</option>
							                		<option value="3" <c:if test="${treatmentPojo.selfLevel == '3' }">selected="selected"</c:if> >3分</option>
							                		<option value="4" <c:if test="${treatmentPojo.selfLevel == '4' }">selected="selected"</c:if> >4分</option>
							                		<option value="5" <c:if test="${treatmentPojo.selfLevel == '5' }">selected="selected"</c:if> >5分</option>
							                	</select> 
				            				</td>
				            			</tr>
				            			<tr>
				            				<th>3.居家生活</th>
				            				<td>
				            					在家庭中的日常生活能力，如料理食物、整理家務、規劃家庭預算、採買家庭用品、居家安全等
				            				</td>
				            				<td>
				            					<select name="lifeLevel" id="lifeLevel" ltype="select" width="120px" >
							                		<option value="1" <c:if test="${treatmentPojo.lifeLevel == '1' }">selected="selected"</c:if> >1分</option>
							                		<option value="2" <c:if test="${treatmentPojo.lifeLevel == '2' }">selected="selected"</c:if> >2分</option>
							                		<option value="3" <c:if test="${treatmentPojo.lifeLevel == '3' }">selected="selected"</c:if> >3分</option>
							                		<option value="4" <c:if test="${treatmentPojo.lifeLevel == '4' }">selected="selected"</c:if> >4分</option>
							                		<option value="5" <c:if test="${treatmentPojo.lifeLevel == '5' }">selected="selected"</c:if> >5分</option>
							                	</select> 
				            				</td>
				            			</tr>
				            			<tr>
				            				<th>4.社交技能</th>
				            				<td>
				            					指的是交友情形與人際關係維持，包括微笑、基本社交禮儀、情緒表達、信賴關係、與他人合作關係、關心他人等
				            				</td>
				            				<td>
				            					<select name="socialLevel" id="socialLevel" ltype="select" width="120px" >
							                		<option value="1" <c:if test="${treatmentPojo.socialLevel == '1' }">selected="selected"</c:if> >1分</option>
							                		<option value="2" <c:if test="${treatmentPojo.socialLevel == '2' }">selected="selected"</c:if> >2分</option>
							                		<option value="3" <c:if test="${treatmentPojo.socialLevel == '3' }">selected="selected"</c:if> >3分</option>
							                		<option value="4" <c:if test="${treatmentPojo.socialLevel == '4' }">selected="selected"</c:if> >4分</option>
							                		<option value="5" <c:if test="${treatmentPojo.socialLevel == '5' }">selected="selected"</c:if> >5分</option>
							                	</select> 
				            				</td>
				            			</tr>
				            			<tr>
				            				<th>5.使用社區資源</th>
				            				<td>
				            					能夠適當地使用社區資源，如在社區中的移動能力、銀行或郵政使用、商店購物或取得服務、公共設施的使用
				            				</td>
				            				<td>
				            					<select name="recourceLevel" id="recourceLevel" ltype="select" width="120px" >
							                		<option value="1" <c:if test="${treatmentPojo.recourceLevel == '1' }">selected="selected"</c:if> >1分</option>
							                		<option value="2" <c:if test="${treatmentPojo.recourceLevel == '2' }">selected="selected"</c:if> >2分</option>
							                		<option value="3" <c:if test="${treatmentPojo.recourceLevel == '3' }">selected="selected"</c:if> >3分</option>
							                		<option value="4" <c:if test="${treatmentPojo.recourceLevel == '4' }">selected="selected"</c:if> >4分</option>
							                		<option value="5" <c:if test="${treatmentPojo.recourceLevel == '5' }">selected="selected"</c:if> >5分</option>
							                	</select> 
				            				</td>
				            			</tr>
				            			<tr>
				            				<th>6.自我引導</th>
				            				<td>
				            					指做決定的能力，能促進自我成長的選擇能力
				            				</td>
				            				<td>
				            					<select name="guideLevel" id="guideLevel" ltype="select" width="120px" >
							                		<option value="1" <c:if test="${treatmentPojo.guideLevel == '1' }">selected="selected"</c:if> >1分</option>
							                		<option value="2" <c:if test="${treatmentPojo.guideLevel == '2' }">selected="selected"</c:if> >2分</option>
							                		<option value="3" <c:if test="${treatmentPojo.guideLevel == '3' }">selected="selected"</c:if> >3分</option>
							                		<option value="4" <c:if test="${treatmentPojo.guideLevel == '4' }">selected="selected"</c:if> >4分</option>
							                		<option value="5" <c:if test="${treatmentPojo.guideLevel == '5' }">selected="selected"</c:if> >5分</option>
							                	</select> 
				            				</td>
				            			</tr>
				            			<tr>
				            				<th>7.健康興安全</th>
				            				<td>
				            					能注意自己的身體，維持良好的健康習慣，注意平衡的飲食、身體安全、對疾病的基本認識與預防、就醫等
				            				</td>
				            				<td>
				            					<select name="safetyLevel" id="safetyLevel" ltype="select" width="120px" >
							                		<option value="1" <c:if test="${treatmentPojo.safetyLevel == '1' }">selected="selected"</c:if> >1分</option>
							                		<option value="2" <c:if test="${treatmentPojo.safetyLevel == '2' }">selected="selected"</c:if> >2分</option>
							                		<option value="3" <c:if test="${treatmentPojo.safetyLevel == '3' }">selected="selected"</c:if> >3分</option>
							                		<option value="4" <c:if test="${treatmentPojo.safetyLevel == '4' }">selected="selected"</c:if> >4分</option>
							                		<option value="5" <c:if test="${treatmentPojo.safetyLevel == '5' }">selected="selected"</c:if> >5分</option>
							                	</select> 
				            				</td>
				            			</tr>
				            			<tr>
				            				<th>8.功能性學科能力</th>
				            				<td>
				            					指日常生活與學校所學的知識與相關技能，亦即認知能力，包括基本語文、數學、自然等，能運用基本認知融入生活與工作當中，促進個人獨力生活的能力
				            				</td>
				            				<td>
				            					<select name="fnLevel" id="fnLevel" ltype="select" width="120px" >
							                		<option value="1" <c:if test="${treatmentPojo.fnLevel == '1' }">selected="selected"</c:if> >1分</option>
							                		<option value="2" <c:if test="${treatmentPojo.fnLevel == '2' }">selected="selected"</c:if> >2分</option>
							                		<option value="3" <c:if test="${treatmentPojo.fnLevel == '3' }">selected="selected"</c:if> >3分</option>
							                		<option value="4" <c:if test="${treatmentPojo.fnLevel == '4' }">selected="selected"</c:if> >4分</option>
							                		<option value="5" <c:if test="${treatmentPojo.fnLevel == '5' }">selected="selected"</c:if> >5分</option>
							                	</select> 
				            				</td>
				            			</tr>
				            			<tr>
				            				<th>9.休閒娛樂</th>
				            				<td>
				            					包括社交技巧、移動能力、主動性、運用認知與資源等能力
				            				</td>
				            				<td>
				            					<select name="playLevel" id="playLevel" ltype="select" width="120px" >
							                		<option value="1" <c:if test="${treatmentPojo.playLevel == '1' }">selected="selected"</c:if> >1分</option>
							                		<option value="2" <c:if test="${treatmentPojo.playLevel == '2' }">selected="selected"</c:if> >2分</option>
							                		<option value="3" <c:if test="${treatmentPojo.playLevel == '3' }">selected="selected"</c:if> >3分</option>
							                		<option value="4" <c:if test="${treatmentPojo.playLevel == '4' }">selected="selected"</c:if> >4分</option>
							                		<option value="5" <c:if test="${treatmentPojo.playLevel == '5' }">selected="selected"</c:if> >5分</option>
							                	</select> 
				            				</td>
				            			</tr>
				            			<tr>
				            				<th>10.工作</th>
				            				<td>
				            					個人工作能力
				            				</td>
				            				<td>
				            					<select name="workerLevel" id="workerLevel" ltype="select" width="120px" >
							                		<option value="1" <c:if test="${treatmentPojo.workerLevel == '1' }">selected="selected"</c:if> >1分</option>
							                		<option value="2" <c:if test="${treatmentPojo.workerLevel == '2' }">selected="selected"</c:if> >2分</option>
							                		<option value="3" <c:if test="${treatmentPojo.workerLevel == '3' }">selected="selected"</c:if> >3分</option>
							                		<option value="4" <c:if test="${treatmentPojo.workerLevel == '4' }">selected="selected"</c:if> >4分</option>
							                		<option value="5" <c:if test="${treatmentPojo.workerLevel == '5' }">selected="selected"</c:if> >5分</option>
							                	</select> 
				            				</td>
				            			</tr>
				            		</tbody>
				            	</table>
	            			
	            		</div>
	            	</div>
	            	
	            		<div class="panel panel-default">
		            		<div class="panel-heading">行為和愛好：(由社工觀察、家人/照顧者提供及在其轉介資料中取得)</div>
		            		<div class="panel-body">
								<div>
									<div class="inline-group">
									 	<label>1.社交方面</label>
									 	<div>
									 		<select name=socially id="socially" ltype="select">
									 			<option value="1" <c:if test="${treatmentPojo.socially == '1' }">selected="selected"</c:if> >抗拒</option>
									 			<option value="2" <c:if test="${treatmentPojo.socially == '2' }">selected="selected"</c:if> >羞怯</option>
									 			<option value="3" <c:if test="${treatmentPojo.socially == '3' }">selected="selected"</c:if> >沉默</option>
									 			<option value="4" <c:if test="${treatmentPojo.socially == '4' }">selected="selected"</c:if> >友善</option>
									 			<option value="5" <c:if test="${treatmentPojo.socially == '5' }">selected="selected"</c:if> >善於交際</option>
									 		</select>
									 	</div>
									 </div>  
									 	<div class="inline-group">
									 		<label>2.情緒方面</label>
									 		<label><input type="checkbox" class="emotional" value="1" <c:if test="${(treatmentPojo.emotional).indexOf('1') != -1 }">checked="checked"</c:if>>穩定</label>
		               						<label><input type="checkbox" class="emotional" value="2" <c:if test="${(treatmentPojo.emotional).indexOf('2') != -1 }">checked="checked"</c:if>>普通穩定</label>
		               						<label><input type="checkbox" class="emotional" value="3" <c:if test="${(treatmentPojo.emotional).indexOf('3') != -1 }">checked="checked"</c:if>>不穩定</label>
									 	</div>
									 	<div class="inline-group">
									 		<label style="width:80px;text-align:right">導因：</label>
									 		<textarea rows="2" cols="55" name="inducements" id="inducements">${treatmentPojo.inducements }</textarea>
									 	</div>
									 	<div class="inline-group">
									 		<label style="width:80px;text-align:right">解決方法：</label>
									 		<textarea rows="2" cols="55" name="solve" id="solve">${treatmentPojo.solve }</textarea>
										</div>
								</div>   
								<table class="table-center table-edit td-padding10" border="1">
									<tbody>
										<tr>
											<td rowspan="4">不尋常行為</td>
											<td>攻擊行為</td>
											<td>
												<div>
													<label><input type="checkbox" class="attack" value="1" <c:if test="${(treatmentPojo.attack).indexOf('1') != -1 }">checked="checked"</c:if>>向自己</label>
		               								<label><input type="checkbox" class="attack" value="2" <c:if test="${(treatmentPojo.attack).indexOf('2') != -1 }">checked="checked"</c:if>>向他人</label>
		               								<label><input type="checkbox" class="attack" value="3" <c:if test="${(treatmentPojo.attack).indexOf('3') != -1 }">checked="checked"</c:if>>向物件</label>
		               								<label><input type="checkbox" class="attack" value="4" <c:if test="${(treatmentPojo.attack).indexOf('4') != -1 }">checked="checked"</c:if>>沒有</label>
												</div>
											</td>
										</tr>
										<tr>
											<td>發脾氣</td>
											<td>
												<div>
													<label><input type="checkbox" class="temper" value="1" <c:if test="${(treatmentPojo.temper).indexOf('1') != -1 }">checked="checked"</c:if>>向自己</label>
		               								<label><input type="checkbox" class="temper" value="2" <c:if test="${(treatmentPojo.temper).indexOf('2') != -1 }">checked="checked"</c:if>>向他人</label>
		               								<label><input type="checkbox" class="temper" value="3" <c:if test="${(treatmentPojo.temper).indexOf('3') != -1 }">checked="checked"</c:if>>向物件</label>
		               								<label><input type="checkbox" class="temper" value="4" <c:if test="${(treatmentPojo.temper).indexOf('4') != -1 }">checked="checked"</c:if>>沒有</label>
												</div>
											</td>
										</tr>
										<tr>
											<td>其他</td>
											<td>
												<div>
		               								<label><input type="checkbox" class="behavior" value="1" <c:if test="${(treatmentPojo.behavior).indexOf('1') != -1 }">checked="checked"</c:if>>多動</label>
		               								<label><input type="checkbox" class="behavior" value="2" <c:if test="${(treatmentPojo.behavior).indexOf('2') != -1 }">checked="checked"</c:if>>退縮</label>
												</div>
											</td>
										</tr>
										<tr>
											<td>處理</td>
											<td>
											<input type="text" ltype="text" name="behaviorHandle" value="${treatmentPojo.behaviorHandle }">
											</td>
										</tr>
										<tr>
											<td rowspan="3">興趣</td>
											<td>運動</td>
											<td><input type="text" ltype="text" name="sport" value="${treatmetnPojo.sport }" ></td>
										</tr>
										<tr>
											<td>藝術</td>
											<td><input type="text" ltype="text" name="art" value="${treatmentPojo.art }" ></td>
										</tr>
										<tr>
											<td>愛好</td>
											<td><input type="text" ltype="text" name="hobby" value="${treatmentPojo.hobby }" ></td>
										</tr>
										<tr>
											<td rowspan="3">日常生活時間表</td>
											<td>上午</td>
											<td><input type="text" ltype="text" name="morningLife" value="${treatmentPojo.morningLife }" ></td>
										</tr>
										<tr>
											<td>下午</td>
											<td><input type="text" ltype="text" name="afternoonLife" value="${treatmentPojo.afternoonLife }" ></td>
										</tr>
										<tr>
											<td>晚上</td>
											<td><input type="text" ltype="text" name="nightLife" value="${treatmentPojo.nightLife }" ></td>
										</tr>
										<tr>
											<td>支持系統</td>
											<td colspan="2" style="text-align:left;">
												<div class="input-group">
												<p>
													<label>支持者：</label>
													<input type="text" ltype="text" name="supportPeople" value="${treatmentPojo.supportPeople }">
													<label>冷淡者：</label>
													<input type="text" ltype="text" name="coldnessPeople" value="${treatmentPojo.coldnessPeople }">
												</p>
												<p>
													<label>縱容者：</label>
													<input type="text" ltype="text" name="connivePeople" value="${treatmentPojo.connivePeople }" >
													<label>忽視者：</label>
													<input type="text" ltype="text" name="neglectPeople" value="${treatmentPojo.neglectPeople }" >
												</p>
												<p>
													<label>過分保護者：</label>
													<input type="text" ltype="text" name="protectPeople" value="${treatmentPojo.protectPeople }">
													<label>嚴厲者：</label>
													<input type="text" ltype="text" name="severePeople" value="${treatmentPojo.severePeople }">
												</p>
												</div>
												
											</td>
										</tr>
									</tbody>
								</table>   
								<div class="inline-group">
									<label style="width:78px;text-align:right;">居住環境：</label>
									<textarea rows="2" cols="55" name="lifeEnvironment" id="lifeEnvironment">${treatmentPojo.lifeEnvironment }</textarea>
								</div>   		
								<div class="inline-group">
									<label style="width:78px;text-align:right;">工作員觀察：</label>
									<textarea rows="2" cols="55" name="workerNote" id="workerNote">${treatmentPojo.workerNote }</textarea>
								</div>   
								<div class="inline-group">
									<label style="width:78px;text-align:right;">建議：</label>
									<textarea rows="2" cols="55" name="behaviourNote" id="behaviourNote">${treatmentPojo.behaviourNote }</textarea>
								</div> 	
		            		</div>
		            	</div>
			       
		  	</div>
		  	
		  	<div tabid="groupTraining" title="小組訓練">
               			<div class="panel panel-default">
						  <div class="panel-heading">小組訓練計劃</div>
						  <div class="panel-body">
						  	<div id="groupPlanDataGrid"></div>
						  </div>
						</div>
						
						<div class="panel panel-default">
						  <div class="panel-heading">小組訓練記錄</div>
						  <div class="panel-body">
						  	<div id="groupRecordDataGrid"></div>
						  </div>
						</div>
						
						
		  	</div>
		  	
		  	<div tabid="ndividualTraining" title="個別訓練">
		  	   	<table>
					<tbody>
			            <tr>
			            	<td align="right" class="l-table-edit-td">個別訓練編號：</td>
			                <td align="left" class="l-table-edit-td">
			                	<input width="120px" value="${treatmentTraining.trainingNO }" name="trainingNO" type="text" id="trainingNO" ltype="text"">
			                </td>
			            
			                <td align="right" class="l-table-edit-td">姓名：</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.fullName }" name="fullName" type="text" ltype="text"  class="fullName"/></td>
			                
			                <td align="right" class="l-table-edit-td">會員編號：</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.custNO }" name="custNO" type="text" ltype="text" id="custNO" /></td>
			                
			                <td align="right" class="l-table-edit-td">非會員編號：</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.custNewNO }" name="custNewNO" type="text" ltype="text" id="custNewNO" /></td>
			              </tr>
			              <tr>
			                 <td align="right" class="l-table-edit-td">訓練項目:</td>
							 <td align="left" class="l-table-edit-td">
							 	<input width="120px" value="${treatmentTraining.program }" name="program" type="text" id="program" ltype="text" />
							 </td>
							  <td align="right" class="l-table-edit-td">訓練目標:</td>
							 <td align="left" class="l-table-edit-td">
							 	<input width="120px" value="${treatmentTraining.target }" name="target" type="text" id="target" ltype="text" />
							 </td>
							  <td align="right" class="l-table-edit-td">執行訓練人員:</td>
							<td align="left" class="l-table-edit-td" id="sex">
								<input width="120px" value="${treatmentTraining.workder }" name="workder" type="text" id="workder" ltype="text" />
			                </td>
			               	<td align="right" class="l-table-edit-td">訓練日期：</td>
			                <td align="left" class="l-table-edit-td">
			                	<input width="120px" value="${treatmentTraining.beginDate_str }" name="beginDate" type="text" id="beginDate" ltype="date"/>
			                	至
			                	<input width="120px" value="${treatmentTraining.endDate_str }" name="endDate" type="text" id="endDate" ltype="date"/>
			                </td>
			            </tr>
			            <tr>
			            	  <td align="right" class="l-table-edit-td">訓練地點:</td>
							 <td align="left" class="l-table-edit-td">
							 	<input width="120px" value="${treatmentTraining.place }" name="place" type="text" id="place" ltype="text" />
							 </td>
							 
			            </tr>
					</tbody>
				</table>
				<div class="panel panel-default">
            		<div class="panel-heading">流程計畫</div>
            		<div class="panel-body">
            			<div id="flowPlanDataGrid"></div>
            			
            		</div>
            	</div>
            	<div class="panel panel-default">
            		<div class="panel-heading">學員訓練狀況記錄</div>
            		<div class="panel-body">
						<div class="inline-group">
							<label>注意力：</label>
							<textarea rows="2" cols="55" name="attention" id="attention">${treatmentTraining.attention }</textarea>
						</div>
						<div class="inline-group">
							<label>情緒表現：</label>
							<textarea rows="2" cols="55" name="emotional" id="emotional">${treatmentTraining.emotional }</textarea>
						</div>
						<div class="inline-group">
							<label>工作態度：</label>
							<textarea rows="2" cols="55" name="attitude" id="attitude">${treatmentTraining.attitude }</textarea>
						</div>
						<div class="inline-group">	
							<label>指令理解：</label>
							<textarea rows="2" cols="55" name="instruction" id="instruction">${treatmentTraining.instruction }</textarea>
						</div>
						<div class="inline-group">
							<label>工作耐力：</label>
							<textarea rows="2" cols="55" name="endurance" id="endurance">${treatmentTraining.endurance }</textarea>
						</div>
						<div class="inline-group">
							<label>工作技能：</label>
							<textarea rows="2" cols="55" name="skill" id="skill">${treatmentTraining.skill }</textarea>
						</div>
						<div class="inline-group">
							<label>其他：</label>
							<textarea rows="2" cols="55" name="other" id="other">${treatmentTraining.other }</textarea>
						</div>
						<div class="inline-group">
							<label>目標達成度評估：</label>
							<textarea rows="2" cols="55" name="targetAssess" id="targetAssess">${treatmentTraining.targetAssess }</textarea>
						</div>            			
            		</div>
            	</div>
		  	</div>
		  	
		  	<div tabid="tryRecord" title="試工記錄">
		  		<table>
					<tbody>
			            <tr>
			            	<td align="right" class="l-table-edit-td">學員名稱：</td>
			                <td align="left" class="l-table-edit-td">
			                	<input width="120px" value="${customer.fullName }" name="fullName" type="text" class="fullName" ltype="text">
			                </td>
			            
			                <td align="right" class="l-table-edit-td">試工開始時間：</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${treatmentTrainingWork.beginDate_str }" name="beginDate" type="text" id="beginDate" ltype="date"/></td>
			                
			                <td align="right" class="l-table-edit-td">試工結束時間：</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${treatmentTrainingWork.endDate_str }" name="endDate" type="text" id="endDate" ltype="date" /></td>
			                
			                <td align="right" class="l-table-edit-td">試工職位：</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${treatmentTrainingWork.duty }" name="duty" type="text" id="duty" ltype="text" /></td>
			              </tr>
			              <tr>
			                 <td align="right" class="l-table-edit-td">試工公司/店鋪:</td>
							 <td align="left" class="l-table-edit-td">
							 	<input width="120px" value="${treatmentTrainingWork.corp }" name="corp" type="text" id="corp" ltype="text" />
							 </td>
							  <td align="right" class="l-table-edit-td">試工地址:</td>
							 <td align="left" class="l-table-edit-td">
							 	<input width="120px" value="${treatmentTrainingWork.place }" name="place" type="text" id="place" ltype="text" />
							 </td>
							  <td align="right" class="l-table-edit-td">工作時間:</td>
							<td align="left" class="l-table-edit-td">
								<input width="120px" value="${treatmentTrainingWork.workTime }" name="workTime" type="text" id="workTime" ltype="text" />
			                </td>
			               	<td align="right" class="l-table-edit-td">工作內容：</td>
			                <td align="left" class="l-table-edit-td">
			                	<input width="120px" value="${treatmentTrainingWork.content }" name="content" type="text" id="content" ltype="text" />
			                </td>
			            </tr>
			            <tr>
			            	  <td align="right" class="l-table-edit-td">工作流程:</td>
							 <td align="left" class="l-table-edit-td">
							 	<input width="120px" value="${treatmentTrainingWork.workDetail }" name="workDetail" type="text" id="workDetail" ltype="text" />
							 </td>
							  <td align="right" class="l-table-edit-td">現場環境觀察:</td>
							 <td align="left" class="l-table-edit-td">
							 	<input width="120px" value="${treatmentTrainingWork.envioment }" name="envioment" type="text" id="envioment" ltype="text" />
							 </td>
							 
			            </tr>
					</tbody>
				</table>
				
				<div class="panel panel-default">
            		<div class="panel-heading">員工試工表現</div>
            		<div class="panel-body">
            			<div id="manifestationDataGrid"></div>
            			
            		</div>
            	</div>
            	<div class="inline-group">
            		<label>負責人：</label>
            		<input type="text" ltype="text" name="handler" value="${treatmentTrainingWork.handler }">
            		<label>日期：</label>
            		<input type="text" ltype="date" name="handleDate" value="${treatmentTrainingWork.handleDate_str }">
            	</div>
            	<div class="inline-block">
            		<label>意見／建議:</label>
            		<textarea rows="2" cols="55" name="handleSuggest" id="handleSuggest">${treatmentTrainingWork.handleSuggest }</textarea>
            	</div>
		  	   	
		  	</div>
		  	
	  </div>
       
		<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
          </form>
        
        
        
        
    
    
    
</body>
</html>