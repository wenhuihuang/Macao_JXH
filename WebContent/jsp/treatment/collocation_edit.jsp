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
        	servicePlanDataGrid,
        	serviceRecordDataGrid;
        
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
	
	
	//斬托服務計畫
	function bindingServicePlanDataGrid(){
		
		var servicePlanDataGridColumn = [
				                    { display: '日期', name: 'beginDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '時間', name: 'groupName', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '服務內容', name: 'target', width: 100 ,type:"text",editor: { type: 'text'}},
				                    { display: '收費金額', name: 'handler', width: 100 ,type:"text",editor: { type: 'text'}},
				                    { display: '繳費金額', name: 'beginDate', width: 150 , type: 'text', editor: { type: 'text'}},
				                    { display: '備註', name: 'note',width:300, type:"text", editor: { type: 'text'}}
				                  ];
				
				
		var servicePlanDataGridToolBar = [
	          { text: '新增', click: addServicePlanData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteServicePlanData, icon: 'delete' , id:"delete" }];
		
		var url = "Treatment/getTreatmentServicePlan.do?custID="+$("#custID").val();
		
		servicePlanDataGrid = ligerGrid("servicePlanDataGrid",null,servicePlanDataGridColumn,url,servicePlanDataGridToolBar,false,true);
		
	}
	function addServicePlanData(){
		servicePlanDataGrid.addRow();
	}
	function deleteServicePlanData(){
		servicePlanDataGrid.deleteSelectedRow();
	}
	
	//暫托服務記錄
	function bindingServiceRecordDataGrid(){
		
		var serviceRecordDataGridColumn = [
				                     { display: '日期', name: 'beginDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '時間', name: 'beginDate', width: 150 , type: 'text', editor: { type: 'text'}},
				                    { display: '服務內容', name: 'performance',width:300, type:"text", editor: { type: 'text'}},
				                    { display: '負責人', name: 'note',width:300, type:"text", editor: { type: 'text'}},
				                    { display: '學生表現', name: 'note',width:300, type:"text", editor: { type: 'text'}},
				                    { display: '備註', name: 'note',width:300, type:"text", editor: { type: 'text'}}
				                  ];
				
				
		var serviceRecordDataGridToolBar = [
	          { text: '新增', click: addServiceRecordData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteServiceRecordData, icon: 'delete' , id:"delete" }];
		
		var url = "Treatment/getTreatmentServiceRecord.do?custID="+$("#custID").val();
		
		serviceRecordDataGrid = ligerGrid("serviceRecordDataGrid",null,serviceRecordDataGridColumn,url,serviceRecordDataGridToolBar,false,true);
		
	}
	function addServiceRecordData(){
		serviceRecordDataGrid.addRow();
	}
	function deleteServiceRecordData(){
		serviceRecordDataGrid.deleteSelectedRow();
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
 		
  		$("#groupSettingRecordPerformanceAdds").val(getAddedRows(groupRecordDataGrid));//GroupSettingRecordPerformance
 		$("#groupSettingRecordPerformanceUpdates").val(getEditedRows(groupRecordDataGrid));
 		$("#groupSettingRecordPerformanceDeletes").val(getDeletedRows(groupRecordDataGrid));
		$("#Button1").click();	
	}
    
	$(function(){
		if($("#treatmentID").val() != "" && $("#treatmentID").val() != 'null' && $("#treatmentID").val() != 'undefined'){
			setTabTitle(parent.$("#framecenter"),"暫托服務編輯")
		}else{
			setTabTitle(parent.$("#framecenter"),"暫托服務新增")
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
		bindingServicePlanDataGrid();
		bindingServiceRecordDataGrid();
		
	 $("#tab").ligerTab({onAfterSelectTabItem:function(targettabid){
			switch(targettabid){
				case "service":
						showGridInTab(familyDataGrid);
						showGridInTab(schoolDataGrid);
						showGridInTab(cureDataGrid);
					break;
				case "servicePlan":
						showGridInTab(servicePlanDataGrid);
					break;
				case "serviceRecord":
						showGridInTab(serviceRecordDataGrid);
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
	
	<div id="tab">
	<div title="暫托服務" tabid="service">
	<table>
		<tbody>
            <tr>
            
                <td align="right" class="l-table-edit-td">姓名：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.fullName }" name="fullName" type="text"  class="fullName"/></td>
                
                <td align="right" class="l-table-edit-td">會員編號：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.custNO }" name="custNO" type="text" id="custNO" /></td>
                
                <td align="right" class="l-table-edit-td">非會員編號：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.custNewNO }" name="custNewNO" type="text" id="custNewNO" /></td>
             	
             	<td align="right" class="l-table-edit-td">托管服務編號：</td>
                <td align="left" class="l-table-edit-td">
                	<input width="120px" value="${treatmentPojo.treatmentNO }" name="treatmentNO" type="text" id="treatmentNO" ltype="text"">
                </td>
             	
              </tr>
            <tr>
            	  <td align="right" class="l-table-edit-td">申請日期:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${custCasePojo.receiveDate_str }" name="receiveDate" type="text" ltype="date" />
				 </td>
				 
				  <td align="right" class="l-table-edit-td">接受日期:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${custCasePojo.receiveDate_str }" name="receiveDate" type="text" ltype="date" />
				 </td>
				 
				   <td align="right" class="l-table-edit-td">狀態:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${custCasePojo.caseStatus }" name="caseStatus" type="text" id="caseStatus" ltype="text" />
				 </td>
				 
				  <td align="right" class="l-table-edit-td">輪候開始日期:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${treatmentPojo.awaitDate_str }" name="awaitDate" type="text" ltype="date" />
				 </td>
			</tr>
			<tr>
				   <td align="right" class="l-table-edit-td">服務類別:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${custCasePojo.caseSource }" name="caseSource" type="text" id="caseSource" ltype="text" />
				 </td>
				   <td align="right" class="l-table-edit-td">負責人:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${custCasePojo.caseWorker }" name="caseWorker" type="text" id="caseWorker" ltype="text" />
				 </td>
            </tr>
		</tbody>
	</table>
	
			        
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
		            		<div class="panel-heading">曾接受職業治療機構資料</div>
		            		<div class="panel-body">
		            			<div id="cureDataGrid"></div>
		            			
		            		</div>
		            	</div>
		            </div>
	            	
			       
		  	</div>
		  	
		  	<div tabid="servicePlan" title="暫托服務計畫">
				<div id="servicePlanDataGrid"></div>
		  	</div>
		  	
		  	<div tabid="serviceRecord" title="暫托服務記錄">
            	<div id="serviceRecordDataGrid"></div>
		  	</div>
		  	
		  	<div tabid="serviceReport" title="結束服務報告">
		  		<table>
					<tbody>
			            <tr>
			            	<td align="right" class="l-table-edit-td">暫托服務編號：</td>
			                <td align="left" class="l-table-edit-td">
			                	<input width="120px" value="${customer.fullName }" name="fullName" type="text" class="fullName" ltype="text">
			                </td>
			            
			                <td align="right" class="l-table-edit-td">服務開始時間：</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${treatmentTrainingWork.beginDate_str }" name="beginDate" type="text" id="beginDate" ltype="date"/></td>
			                
			                <td align="right" class="l-table-edit-td">服務結束時間：</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${treatmentTrainingWork.endDate_str }" name="endDate" type="text" id="endDate" ltype="date" /></td>
			                
			                <td align="right" class="l-table-edit-td">負責人：</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${treatmentTrainingWork.duty }" name="duty" type="text" id="duty" ltype="text" /></td>
			              </tr>
			              <tr>
			                 <td align="right" class="l-table-edit-td">會員編號:</td>
							 <td align="left" class="l-table-edit-td">
							 	<input width="120px" value="${treatmentTrainingWork.corp }" name="corp" type="text" id="corp" ltype="text" />
							 </td>
							  <td align="right" class="l-table-edit-td">非會員編號:</td>
							 <td align="left" class="l-table-edit-td">
							 	<input width="120px" value="${treatmentTrainingWork.place }" name="place" type="text" id="place" ltype="text" />
							 </td>
							  <td align="right" class="l-table-edit-td">姓名:</td>
							<td align="left" class="l-table-edit-td">
								<input width="120px" value="${treatmentTrainingWork.workTime }" name="workTime" type="text" id="workTime" ltype="text" />
			                </td>
			               	<td align="right" class="l-table-edit-td">性別：</td>
			                <td align="left" class="l-table-edit-td">
			                	<input width="120px" value="${treatmentTrainingWork.content }" name="content" type="text" id="content" ltype="text" />
			                </td>
			            </tr>
			            <tr>
			            	  <td align="right" class="l-table-edit-td">出生日期:</td>
							 <td align="left" class="l-table-edit-td">
							 	<input width="120px" value="${treatmentTrainingWork.workDetail }" name="workDetail" type="text" id="workDetail" ltype="text" />
							 </td>
							  <td align="right" class="l-table-edit-td">聯繫電話:</td>
							 <td align="left" class="l-table-edit-td">
							 	<input width="120px" value="${treatmentTrainingWork.envioment }" name="envioment" type="text" id="envioment" ltype="text" />
							 </td>
							 
			            </tr>
					</tbody>
				</table>
				
            	<div class="inline-group">
            		<label>結束服務原因：</label>
            		<input type="text" ltype="text" name="handler" value="${treatmentTrainingWork.handler }">
            	</div>
            	<div class="inline-group">
            		<label>臨床觀察其表現：</label>
            		<input type="text" ltype="date" name="handleDate" value="${treatmentTrainingWork.handleDate_str }">
            	</div>
            	<div class="inline-block">
            		<label>建議：</label>
            		<textarea rows="2" cols="55" name="handleSuggest" id="handleSuggest">${treatmentTrainingWork.handleSuggest }</textarea>
            	</div>
            	<div class="inline-block">
            		<label>服務小結：</label>
            		<textarea rows="2" cols="55" name="handleSuggest" id="handleSuggest">${treatmentTrainingWork.handleSuggest }</textarea>
            	</div>
            	<div class="inine-block">
            		<label>主管：</label>
            		<input type="text" ltype="text">
            		<label>日期：</label>
            		<input type="text" ltype="text">
            	</div>
            	<div>
            		<label>主管意見及建議：</label>
            		<textarea rows="2" cols="55" name="handleSuggest" id="handleSuggest">${treatmentTrainingWork.handleSuggest }</textarea>
            	</div>
		  	   	
		  	</div>
		  	
	  </div>
       
		<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
          </form>
        
        
        
        
    
    
    
</body>
</html>