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
        	planDataGrid,
        	recordDataGrid;
        
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
				                    { display: '治療項目', name: 'treatmentItem', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '治療開始日期', name: 'tStartDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '治療結束日期', name: 'tEndDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '治療內容', name: 'content', width: 100,type:"text",editor: { type: 'text' }},
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
	
	//治療計畫
	function bindingPlanDataGrid(){
		
		var planDataGridColumn = [
									{ display: 'planID', name: 'planID', hide:true },
									{ display: '日期', name: 'billDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '時間', name: 'time', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '治療內容', name: 'content', width: 150 ,type:"text",editor: { type: 'text'}},
				                    { display: '治療目標', name: 'target', width: 150 ,type:"text",editor: { type: 'text'}},
				                    { display: '收費金額', name: 'charge', width: 150 ,type:"text",editor: { type: 'text'}},
				                    { display: '繳費金額', name: 'payment', width: 150 ,type:"text",editor: { type: 'text'}},
				                    { display: '備註', name: 'note', width: 150 ,type:"text",editor: { type: 'text'}},
								];
				
				
		var planDataGridToolBar = [
	          { text: '新增', click: addPlanData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deletePlanData, icon: 'delete' , id:"delete" }];
		
		var url = "Treatment/getTreatmentPlan.do?treatmentID="+$("#treatmentID").val();
		
		planDataGrid = ligerGrid("planDataGrid",null,planDataGridColumn,url,planDataGridToolBar,false,true);
		
	}
	function addPlanData(){
		planDataGrid.addRow();
	}
	function deletePlanData(){
		planDataGrid.deleteSelectedRow();
	}
	
	//言語治療課堂記錄
	function bindingRecordDataGrid(){
		
		var recordDataGridColumn = [
									{ display: 'planID', name: 'planID', hide:true },
									{ display: '日期', name: 'billDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
									{ display: '時間', name: 'time', width: 100,type:"text",editor: { type: 'text' }},
									{ display: '治療內容', name: 'content', width: 150 ,type:"text",editor: { type: 'text'}},
									{ display: '治療目標', name: 'target', width: 150 ,type:"text",editor: { type: 'text'}},
									{ display: '活動', name: 'activity', width: 150 ,type:"text",editor: { type: 'text'}},
									{ display: '學生表現', name: 'performance', width: 150 ,type:"text",editor: { type: 'text'}},
									{ display: '備註', name: 'note', width: 150 ,type:"text",editor: { type: 'text'}},
								];
				
				
		var recordDataGridToolBar = [
	          { text: '新增', click: addRecordData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteRecordData, icon: 'delete' , id:"delete" }];
		
		var url = "Treatment/getTreatmentRecord.do?treatmentID="+$("#treatmentID").val();
		
		recordDataGrid = ligerGrid("recordDataGrid",null,recordDataGridColumn,url,recordDataGridToolBar,false,true);
		
	}
	function addRecordData(){
		recordDataGrid.addRow();
	}
	function deleteRecordData(){
		recordDataGrid.deleteSelectedRow();
	}
	
	function itemclick(item){
		switch (item.id){
			case "save":
				save();
			break;
			case "back":
				location.href="jsp/treatment/language_list.jsp";
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
 		$("#treatmentPlanAdds").val(getAddedRows(planDataGrid));
 		$("#treatmentPlanUpdates").val(getEditedRows(planDataGrid));
 		$("#treatmentPlanDeletes").val(getDeletedRows(planDataGrid)); 
 		$("#treatmentRecordAdds").val(getAddedRows(recordDataGrid));
 		$("#treatmentRecordUpdates").val(getEditedRows(recordDataGrid));
 		$("#treatmentRecordDeletes").val(getDeletedRows(recordDataGrid)); 
 		checkboxValue(["vocabulary","sentenceLen","sentenceOrg","question","narrative","storyTell","interview","servicePoint"])
		$("#Button1").click();	
	}
    
	$(function(){
		if($("#treatmentID").val() != "" && $("#treatmentID").val() != 'null' && $("#treatmentID").val() != 'undefined'){
			setTabTitle(parent.$("#framecenter"),"語言治療編輯")
		}else{
			setTabTitle(parent.$("#framecenter"),"語言治療新增")
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
		bindingPlanDataGrid();
		bindingRecordDataGrid();
		
	 $("#tab").ligerTab({onAfterSelectTabItem:function(targettabid){
		 console.log(recordDataGrid.get("isTabCover"));
			switch(targettabid){
				case "serviceData":
						showGridInTab(familyDataGrid);
						showGridInTab(schoolDataGrid);
						showGridInTab(cureDataGrid);
					break;
				case "plan":showGridInTab(planDataGrid);break;
				case "record":showGridInTab(recordDataGrid);break;
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
	<input type="hidden" name="treatmentType" id="treatmentType" value="1">
	<input type="hidden" name="custID" id="custID" value="${treatmentPojo.custID }">
	<input type="hidden" name="treatmentID" id="treatmentID" value="${treatmentPojo.treatmentID }">
	<input type="hidden" name="treatmentFamilyAdds" id="treatmentFamilyAdds">
	<input type="hidden" name="treatmentFamilyUpdates" id="treatmentFamilyUpdates">
	<input type="hidden" name="treatmentFamilyDeletes" id="treatmentFamilyDeletes">
	<input type="hidden" name="bCustomerSchoolAdds" id="bCustomerSchoolAdds">
	<input type="hidden" name="bCustomerSchoolUpdates" id="bCustomerSchoolUpdates">
	<input type="hidden" name="bCustomerSchoolDeletes" id="bCustomerSchoolDeletes">
	<input type="hidden" name="treatmentHistoryAdds" id="treatmentHistoryAdds">
	<input type="hidden" name="treatmentHistoryUpdates" id="treatmentHistoryUpdates">
	<input type="hidden" name="treatmentHistoryDeletes" id="treatmentHistoryDeletes">
	<input type="hidden" name="treatmentPlanAdds" id="treatmentPlanAdds">
	<input type="hidden" name="treatmentPlanUpdates" id="treatmentPlanUpdates">
	<input type="hidden" name="treatmentPlanDeletes" id="treatmentPlanDeletes">
	<input type="hidden" name="treatmentRecordAdds" id="treatmentRecordAdds">
	<input type="hidden" name="treatmentRecordUpdates" id="treatmentRecordUpdates">
	<input type="hidden" name="treatmentRecordDeletes" id="treatmentRecordDeletes">
	
	<input type="hidden" name="vocabulary" id="vocabulary">
	<input type="hidden" name="sentenceLen" id="sentenceLen">
	<input type="hidden" name="sentenceOrg" id="sentenceOrg">
	<input type="hidden" name="question" id="question">
	<input type="hidden" name="narrative" id="narrative">
	<input type="hidden" name="storyTell" id="storyTell">
	<input type="hidden" name="interview" id="interview">
	
	<input type="hidden" name="servicePoint" id="servicePoint">
	<table>
		<tbody>
            <tr>
            	<td align="right" class="l-table-edit-td">語言治療編號：</td>
                <td align="left" class="l-table-edit-td">
                	<input width="120px" value="${treatmentPojo.treatmentNO }" name="treatmentNO" type="text" id="treatmentNO" ltype="text"">
                </td>
            
                <td align="right" class="l-table-edit-td">姓名：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.fullName }" name="fullName" type="text" id="fullName"/></td>
                
                <td align="right" class="l-table-edit-td">會員編號：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.custNO }" name="custNO" type="text" id="custNO" /></td>
                
                <td align="right" class="l-table-edit-td">非會員編號：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.custNewNO }" name="custNewNO" type="text" id="custNewNO" /></td>
              </tr>
              <tr>
                 <td align="right" class="l-table-edit-td">出生日期:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${customer.birthday_ChnStr }" name="father" type="text" id="birthday_ChnStr" ltype="date" />
				 </td>
				  <td align="right" class="l-table-edit-td">聯繫電話:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${customer.mobileTelNO }" name="mother" type="text" id="mobileTelNO" ltype="text" />
				 </td>
				  <td align="right" class="l-table-edit-td">性別:</td>
				<td align="left" class="l-table-edit-td" id="sex">
                	<input id="sex1" type="radio" disabled="disabled" name="sex"  value="1" <c:if test="${customer.sex != 2 }">checked="checked"</c:if> /><label for="sex1">男</label> 
					<input id="sex2" type="radio" disabled="disabled" name="sex" value="2" <c:if test="${customer.sex == 2 }">checked="checked"</c:if> /><label for="sex2">女</label>
                </td>
               	<td align="right" class="l-table-edit-td">治療師：</td>
                <td align="left" class="l-table-edit-td">
                <input width="120px" value="${treatmentPojo.worker }" name="worker" type="text" id="worker" ltype="text"/>
                </td>
            </tr>
            <tr>
            	  <td align="right" class="l-table-edit-td">治療開始日期:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${treatmentPojo.startDate_str }" name="startDate" type="text" id="startDate" ltype="date" />
				 </td>
            </tr>
		</tbody>
	</table>
	<div id="tab">
		  	<div title="登記服務資料" tabid="serviceData"><!-- 登記服務資料 -->
		  		
		  		<table cellpadding="0" cellspacing="0" class="l-table-edit" >
			        <tbody>
			       <%--      <tr>
			                <td align="right" class="l-table-edit-td">姓名：</td><!-- 有name -->
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${treatmentPojo.caseNo }" name="caseNo" type="text" class="caseNo" ltype="text" validate="{required:true,notnull:true}"/></td>
			                
			                <td align="right" class="l-table-edit-td">會員編號：</td><!-- 有name -->
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${treatmentPojo.billDate_str }" name="billDate" type="text" id="billDate" ltype="date" validate="{required:true,notnull:true}"/></td>
			                
			                <td align="right" class="l-table-edit-td">非會員編號：</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${treatmentPojo.caseWorker }" name="caseWorker" type="text" id="caseWorker" ltype="text" /></td>
			                
			                <td align="right" class="l-table-edit-td">語言治療編號：</td>
			                <td align="left" class="l-table-edit-td">
			                	<input type="text" id="caseStatus">
			                </td>
			
			              
			            </tr> --%>
			           	
			          
			             <tr>
			             	
			             <%-- 	<td align="right" class="l-table-edit-td">治療師：</td>
			                <td align="left" class="l-table-edit-td">
			                <input width="120px" value="${treatmentPojo.worker }" name="worker" type="text" id="worker" ltype="text"/>
			                </td> --%>
			                
			                <td align="right" class="l-table-edit-td">申請服務日期：</td>
			                <td align="left" class="l-table-edit-td">
			                <input width="120px" value="${treatmentPojo.applyDate_str }" name="applyDate" type="text" id="applyDate" ltype="date"/>
			                </td>
			                
			                <td align="right" class="l-table-edit-td">服務狀態：</td><!-- 有name -->
			                <td align="left" class="l-table-edit-td">
			                   	<select name="serviceStatus" id="serviceStatus" ltype="select" width="120px" >
			                		<option value="0" <c:if test="${treatmentPojo.serviceStatus != '1' and treatmentPojo.serviceStatus != '2'}">selected="selected"</c:if> >輪候</option>
			                		<option value="1" <c:if test="${treatmentPojo.serviceStatus == '1' }">selected="selected"</c:if> >開始</option>
			                		<option value="2" <c:if test="${treatmentPojo.serviceStatus == '2' }">selected="selected"</c:if> >結束</option>
			                	</select> 
			                </td>
			                
			                <td align="right" class="l-table-edit-td">輸候開始日期：</td>
			                <td align="left" class="l-table-edit-td">
			                	<input width="120px" value="${treatmentPojo.awaitDate_str }" name="awaitDate" type="text" id="awaitDate" ltype="date" /> 
			                </td>
			                
			             </tr>
			            <tr>
			            	
			                
			                <td align="right" class="l-table-edit-td">接受治療原因：</td>
			                <td align="left" class="l-table-edit-td">
			                	<textarea rows="2" cols="55" name="reason" id="reason">${treatmentPojo.reason }</textarea>
			                </td>
			                <td align="right" class="l-table-edit-td">注意事項:</td>
			                <td align="left" class="l-table-edit-td">
			              	  <textarea rows="2" cols="55" name="note" id="note">${treatmentPojo.note }</textarea>
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
				                		<textarea rows="2" cols="55" name="familySituation" id="familySituation">${treatmentPojo.familySituation }</textarea>
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
		            		<div class="panel-heading">過去治療史</div>
		            		<div class="panel-body">
		            			<div id="cureDataGrid"></div>
		            			
		            				<div class="inline-group">
				            			<label style="width:140px;text-align:right;">接受物理評估原因：</label>
				                		<textarea rows="2" cols="55" name="physicalReason" id="physicalReason">${treatmentPojo.physicalReason }</textarea>
				            		</div>
				            		
				            		<div class="inline-group">
				            			<label style="width:140px;text-align:right;">何以得知有此服務：</label>
				                		<textarea rows="2" cols="55" name="knowReason" id="knowReason">${treatmentPojo.knowReason }</textarea>
				            		</div>
				            		
				            		<div class="inline-group">
				            			<label style="width:140px;text-align:right;">職業治療服務的期望：</label>
				                		<textarea rows="2" cols="55" name="wish" id="wish">${treatmentPojo.wish }</textarea>
				            		</div>
				            		<div class="inline-group">
				            			<label style="width:140px;text-align:right;">其他：</label>
				                		<textarea rows="2" cols="55" name="otherReason" id="otherReason">${treatmentPojo.otherReason }</textarea>
				            		</div>
		            		</div>
		            	</div>
			                
		            </div>
		            
			       
		  	</div>
		  	
		  	<div tabid="presentation" title="語言治療評估簡報"><!-- 語言治療評估簡報 -->
               		<table cellpadding="0" cellspacing="0" class="l-table-edit" >
               			<tbody>
               				<tr>
               					<%--  <td align="right" class="l-table-edit-td" >姓名:</td>
               					 <td align="left" class="l-table-edit-td">
               					 <input width="120px" value="${treatmentPojo.fullName }" type="text" class="fullName" ltype="text" />
               					 </td>
               					 
               					  <td align="right" class="l-table-edit-td">會員編號:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${treatmentPojo.billDate_str }" name="billDate_str" type="text" id="billDate_str" ltype="date" /></td>
               					 <td align="right" class="l-table-edit-td">非會員編號:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${treatmentPojo.billTime }" name="billTime" type="text" id="billTime" ltype="text" /></td>
               					   --%>
               					  <td align="right" class="l-table-edit-td">評估類別:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${treatmentAssessPojo.assessCategory }" name="assessCategory" type="text" id="assessCategory" ltype="text" /></td>
            <%-- 				 <td align="right" class="l-table-edit-td">言語治療編號:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${treatmentPojo.treatmentNO }" name="place" type="text" id="place" ltype="text" /></td> --%>
               					 <td align="right" class="l-table-edit-td">評估日期:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${treatmentAssessPojo.assessDate_str }" name="assessDate" type="text" id="assessDate" ltype="date" /></td>
               					 <td align="right" class="l-table-edit-td">評估地點:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${treatmentAssessPojo.place }" name="place" type="text" id="place" ltype="text" /></td>
               					  <td align="right" class="l-table-edit-td">評估治療師:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${treatmentAssessPojo.worker }" name="worker" type="text" id="worker" ltype="text" /></td>
               				</tr>
               				<tr>
               					 <td align="right" class="l-table-edit-td">參與評估職員:</td>
               					 <td align="left" class="l-table-edit-td">
               					 	<input width="120px" value="${treatmentAssessPojo.otherWorkers }" name="otherWorkers" type="text" id="otherWorkers" ltype="text" />
               					 </td>
               					 <td align="right" class="l-table-edit-td">陪同家人:</td>
               					 <td align="left" class="l-table-edit-td">
               					 	<input width="120px" value="${treatmentAssessPojo.otherFamily }" name="otherFamily" type="text" id="otherFamily" ltype="text" />
               					 </td>
               				</tr>
               			</tbody>
               		</table> 
               			<div class="panel panel-default">
						  <div class="panel-heading">語言前技能</div>
						  <div class="panel-body">
						    <table>
						    	<tbody>
						    		<tr>
						    			<td align="right" class="l-table-edit-td">專注能力:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${treatmentAssessPojo.focus }" name="focus" type="text" id="focus" ltype="text" />
		               					</td>
		               					 <td align="right" class="l-table-edit-td">目光接觸:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${treatmentAssessPojo.eyeContact }" name="eyeContact" type="text" id="eyeContact" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">玩具操作技巧:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${treatmentAssessPojo.toySkill }" name="toySkill" type="text" id="toySkill" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">對聲音的反應:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${treatmentAssessPojo.soundsReply }" name="soundsReply" type="text" id="soundsReply" ltype="text" />
		               					</td>
		               				</tr>
		               				<tr>
		               					<td align="right" class="l-table-edit-td">模仿能力:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${treatmentAssessPojo.imitation }" name="imitation" type="text" id="imitation" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">備通意願:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${treatmentAssessPojo.communicate }" name="communicate" type="text" id="communicate" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">物件概念:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${treatmentAssessPojo.conceptual }" name="conceptual" type="text" id="conceptual" ltype="text" />
		               					</td>
		               				</tr><tr>
		               					<td align="right" class="l-table-edit-td">其他:</td>
		               					<td align="left" class="l-table-edit-td">
				                			<textarea rows="2" cols="55" name="ability" id="ability">${treatmentAssessPojo.ability }</textarea>
		               					 	<%-- <input width="120px" value="${treatmentAssessPojo.ability }" name="ability" type="text" id="ability" ltype="text" /> --%>
		               					</td>
						    		</tr>
						    	</tbody>
						    </table>
						  </div>
						</div>
						
						<div class="panel panel-default">
						  <div class="panel-heading">語言表達</div>
						  <div class="panel-body">
						    <table>
						    	<tbody>
						    		<tr>
						    			<td align="right" class="l-table-edit-td">詞彙運用:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<label for="wordsGesture"><input class="vocabulary" type="checkbox" value="0" id="wordsGesture" <c:if test="${(treatmentAssessPojo.vocabulary).indexOf('0') != -1 }">checked="checked"</c:if>>手勢</label>
		               						<label for="wordsSound"><input class="vocabulary" type="checkbox" value="1" id="wordsSound" <c:if test="${(treatmentAssessPojo.vocabulary).indexOf('1') != -1 }">checked="checked"</c:if>>聲音</label>
		               						<label for="wordsPicture"><input class="vocabulary" type="checkbox" value="2" id="wordsPicture" <c:if test="${(treatmentAssessPojo.vocabulary).indexOf('2') != -1 }">checked="checked"</c:if>>圖片</label>
		               						<label for="wordsLanguage"><input class="vocabulary" type="checkbox" value="3" id="wordsLanguage" <c:if test="${(treatmentAssessPojo.vocabulary).indexOf('3') != -1 }">checked="checked"</c:if>>言語</label>
		               					</td>
		               					 <td align="right" class="l-table-edit-td">句子長度:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<label><input type="checkbox" class="sentenceLen" value="0" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('0') != -1 }">checked="checked"</c:if>>手勢</label>
		               						<label><input type="checkbox" class="sentenceLen" value="1" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('1') != -1 }">checked="checked"</c:if>>聲音</label>
		               						<label><input type="checkbox" class="sentenceLen" value="2" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('2') != -1 }">checked="checked"</c:if>>圖片</label>
		               						<label><input type="checkbox" class="sentenceLen" value="3" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('3') != -1 }">checked="checked"</c:if>>言語</label>
		               					</td>
		               					<td align="right" class="l-table-edit-td">句子組成:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<label><input type="checkbox" class="sentenceOrg" value="0" <c:if test="${(treatmentAssessPojo.sentenceOrg).indexOf('0') != -1 }">checked="checked"</c:if>>手勢</label>
		               						<label><input type="checkbox" class="sentenceOrg" value="1" <c:if test="${(treatmentAssessPojo.sentenceOrg).indexOf('1') != -1 }">checked="checked"</c:if>>聲音</label>
		               						<label><input type="checkbox" class="sentenceOrg" value="2" <c:if test="${(treatmentAssessPojo.sentenceOrg).indexOf('2') != -1 }">checked="checked"</c:if>>圖片</label>
		               						<label><input type="checkbox" class="sentenceOrg" value="3" <c:if test="${(treatmentAssessPojo.sentenceOrg).indexOf('3') != -1 }">checked="checked"</c:if>>言語</label>
		               					</td>
		               					<td align="right" class="l-table-edit-td">問句運用:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<label><input type="checkbox" class="question" value="0" <c:if test="${(treatmentAssessPojo.question).indexOf('0') != -1 }">checked="checked"</c:if>>手勢</label>
		               						<label><input type="checkbox" class="question" value="1" <c:if test="${(treatmentAssessPojo.question).indexOf('1') != -1 }">checked="checked"</c:if>>聲音</label>
		               						<label><input type="checkbox" class="question" value="2" <c:if test="${(treatmentAssessPojo.question).indexOf('2') != -1 }">checked="checked"</c:if>>圖片</label>
		               						<label><input type="checkbox" class="question" value="3" <c:if test="${(treatmentAssessPojo.question).indexOf('3') != -1 }">checked="checked"</c:if>>言語</label>
		               					</td>
		               				</tr>
		               				<tr>
		               					<td align="right" class="l-table-edit-td">敘事能力:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<label><input type="checkbox" class="narrative" value="0" <c:if test="${(treatmentAssessPojo.narrative).indexOf('0') != -1 }">checked="checked"</c:if>>手勢</label>
		               						<label><input type="checkbox" class="narrative" value="1" <c:if test="${(treatmentAssessPojo.narrative).indexOf('1') != -1 }">checked="checked"</c:if>>聲音</label>
		               						<label><input type="checkbox" class="narrative" value="2" <c:if test="${(treatmentAssessPojo.narrative).indexOf('2') != -1 }">checked="checked"</c:if>>圖片</label>
		               						<label><input type="checkbox" class="narrative" value="3" <c:if test="${(treatmentAssessPojo.narrative).indexOf('3') != -1 }">checked="checked"</c:if>>言語</label>
		               					</td>
		               					<td align="right" class="l-table-edit-td">說故事技巧:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<label><input type="checkbox" class="storyTell" value="0" <c:if test="${(treatmentAssessPojo.storyTell).indexOf('0') != -1 }">checked="checked"</c:if>>手勢</label>
		               						<label><input type="checkbox" class="storyTell" value="1" <c:if test="${(treatmentAssessPojo.storyTell).indexOf('1') != -1 }">checked="checked"</c:if>>聲音</label>
		               						<label><input type="checkbox" class="storyTell" value="2" <c:if test="${(treatmentAssessPojo.storyTell).indexOf('2') != -1 }">checked="checked"</c:if>>圖片</label>
		               						<label><input type="checkbox" class="storyTell" value="3" <c:if test="${(treatmentAssessPojo.storyTell).indexOf('3') != -1 }">checked="checked"</c:if>>言語</label>
		               					</td>
		               					<td align="right" class="l-table-edit-td">對答技巧:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<label><input type="checkbox" class="interview" value="0" <c:if test="${(treatmentAssessPojo.interview).indexOf('0') != -1 }">checked="checked"</c:if>>手勢</label>
		               						<label><input type="checkbox" class="interview" value="1" <c:if test="${(treatmentAssessPojo.interview).indexOf('1') != -1 }">checked="checked"</c:if>>聲音</label>
		               						<label><input type="checkbox" class="interview" value="2" <c:if test="${(treatmentAssessPojo.interview).indexOf('2') != -1 }">checked="checked"</c:if>>圖片</label>
		               						<label><input type="checkbox" class="interview" value="3" <c:if test="${(treatmentAssessPojo.interview).indexOf('3') != -1 }">checked="checked"</c:if>>言語</label>
		               					</td>
		               				</tr><tr>
		               					<td align="right" class="l-table-edit-td">其他:</td>
		               					<td align="left" class="l-table-edit-td">
		               						<textarea rows="2" cols="55" name="expressionOther" id="expressionOther">${treatmentAssessPojo.expressionOther }</textarea>
		               					 	<%-- <input width="120px" value="${treatmentAssessPojo.expressionOther }" name="expressionOther" type="text" id="expressionOther" ltype="text" /> --%>
		               					</td>
						    		</tr>
						    	</tbody>
						    </table>
						  </div>
						</div>
						
						<div class="panel panel-default">
						  <div class="panel-heading">語言理解</div>
						  <div class="panel-body">
						    <table>
						    	<tbody>
						    		<tr>
						    			<td align="right" class="l-table-edit-td">詞彙:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${treatmentAssessPojo.words }" name="words" type="text" id="words" ltype="text" />
		               					</td>
		               					 <td align="right" class="l-table-edit-td">口頭指令:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${treatmentAssessPojo.oralOrder }" name="oralOrder" type="text" id="oralOrder" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">問句:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${treatmentAssessPojo.questions }" name="questions" type="text" id="questions" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">故事:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${treatmentAssessPojo.story }" name="story" type="text" id="story" ltype="text" />
		               					</td>
		               				</tr>
		               				<tr>
		               					<td align="right" class="l-table-edit-td">邏輯思維:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${treatmentAssessPojo.logical }" name="logical" type="text" id="logical" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">物件概念:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${treatmentAssessPojo.underStandConceptual }" name="underStandConceptual" type="text" id="underStandConceptual" ltype="text" />
		               					</td>
		               				</tr>
		               				<tr>
		               					<td align="right" class="l-table-edit-td">其他:</td>
		               					<td align="left" class="l-table-edit-td">
		               						<textarea rows="2" cols="55" name="underStandOther" id="underStandOther">${treatmentAssessPojo.underStandOther }</textarea>
		               					 	<%-- <input width="120px" value="${treatmentAssessPojo.underStandOther }" name="underStandOther" type="text" id="underStandOther" ltype="text" /> --%>
		               					</td>
						    		</tr>
						    	</tbody>
						    </table>
						  </div>
						</div>
						
						<div class="panel panel-default">
						  <div class="panel-heading">兒童在發音方面有以下困難</div>
						  <div class="panel-body">
						    <table  class="table-center table-edit" border="1">
						    	<thead>
						    		<tr>
						    			<th height="28px" width="120px">項目</th>
						    			<th width="120px">有/無</th>
						    			<th>描述</th>
						    		</tr>
						    	</thead>
						    	<tbody>
						    		<tr>
						    			<th>元音/複元音</th>
						    			<td>
						    				<select name="vowel" id="vowel" ltype="select" width="120px" >
						                		<option value="0" <c:if test="${treatmentAssessPojo.vowel != '1' }">selected="selected"</c:if> >無</option>
						                		<option value="1" <c:if test="${treatmentAssessPojo.vowel == '1' }">selected="selected"</c:if> >有</option>
						                	</select> 
						    			</td>
						    			<td>
						    				<input width="120px" value="${treatmentAssessPojo.vowelNote }" name="vowelNote" type="text" id="vowelNote" ltype="text" />
						    			</td>
						    		</tr>
						    		<tr>
						    			<th>前輔音</th>
						    			<td>
						    				<select name="beforeConsonant" id="beforeConsonant" ltype="select" width="120px" >
						                		<option value="0" <c:if test="${treatmentAssessPojo.beforeConsonant != '1' }">selected="selected"</c:if> >無</option>
						                		<option value="1" <c:if test="${treatmentAssessPojo.beforeConsonant == '1' }">selected="selected"</c:if> >有</option>
						                	</select> 
						    			</td>
						    			<td>
						    				<input width="120px" value="${treatmentAssessPojo.beforeConsonantNote }" name="beforeConsonantNote" type="text" id="beforeConsonantNote" ltype="text" />
						    			</td>
						    		</tr>
						    		<tr>
						    			<th>後輔音</th>
						    			<td>
						    				<select name="afterConsonant" id="afterConsonant" ltype="select" width="120px" >
						                		<option value="0" <c:if test="${treatmentAssessPojo.afterConsonant != '1' }">selected="selected"</c:if> >無</option>
						                		<option value="1" <c:if test="${treatmentAssessPojo.afterConsonant == '1' }">selected="selected"</c:if> >有</option>
						                	</select> 
						    			</td>
						    			<td>
						    				<input width="120px" value="${treatmentAssessPojo.afterConsonantNote }" name="afterConsonantNote" type="text" id="afterConsonantNote" ltype="text" />
						    			</td>
						    		
						    		</tr>
						    		<tr>
						    			<th>聲調</th>
						    			<td>
						    				<select name="tone" id="tone" ltype="select" width="120px" >
						                		<option value="0" <c:if test="${treatmentAssessPojo.tone != '1' }">selected="selected"</c:if> >無</option>
						                		<option value="1" <c:if test="${treatmentAssessPojo.tone == '1' }">selected="selected"</c:if> >有</option>
						                	</select> 
						    			</td>
						    			<td>
						    				<input width="120px" value="${treatmentAssessPojo.toneNote }" name="toneNote" type="text" id="toneNote" ltype="text" />
						    			</td>
						    		</tr>
						    	</tbody>
						    </table>
						    <div class="inline-group">
		            			<label style="text-align:right;">其他：</label>
		                		<textarea rows="2" cols="55" name="pronunciationOther" id="pronunciationOther">${treatmentAssessPojo.pronunciationOther }</textarea>
		            		</div>
						  </div>
						</div>
						
						<div class="panel panel-default">
						  <div class="panel-heading">其他</div>
						  <div class="panel-body">
						  	<textarea name="other" rows="2" cols="55">${treatmentAssessPojo.other }</textarea>
						  </div>
						</div>
						
						<div class="panel panel-default">
						  <div class="panel-heading">建議</div>
						  <div class="panel-body">
						  		<div class="inline-group">
						  			<label style="width:180px;text-align:right">接受言語治療服務：</label>
						  			<select name="acceptService" ltype="select" width="120px">
               					 		<option value="0" <c:if test="${treatmentAssessPojo.acceptService != '1' }">selected="selected"</c:if>>是</option>
               					 		<option value="1" <c:if test="${treatmentAssessPojo.acceptService == '1' }">selected="selected"</c:if>>否</option>
               					 	</select>
						  		</div>
						  		<div class="inline-group">
						  			<label style="width:180px;text-align:right">接受言語治療服務，訓練重點為：</label>
						  			<div class="checkbox-group">
						  				<p>
						  					<label><input type="checkbox" value="0" class="servicePoint" <c:if test="${(treatmentAssessPojo.servicePoint).indexOf('0') != -1 }">checked="checked"</c:if>>提高溝通意識 </label>
			               					<label><input type="checkbox" value="1"  class="servicePoint" <c:if test="${(treatmentAssessPojo.servicePoint).indexOf('1') != -1 }">checked="checked"</c:if>>擴闊詞彙的理解和表達 </label>
			               				</p>
			               				<p>
			               				<label><input type="checkbox" value="2"  class="servicePoint" <c:if test="${(treatmentAssessPojo.servicePoint).indexOf('2') != -1 }">checked="checked"</c:if>> 增長句子的長度及複雜度 </label>
			               				<label><input type="checkbox" value="3"  class="servicePoint" <c:if test="${(treatmentAssessPojo.servicePoint).indexOf('3') != -1 }">checked="checked"</c:if>>增強說話的組織能力 </label>
			               				</p>
			               				<p>
			               				<label><input type="checkbox" value="4"  class="servicePoint" <c:if test="${(treatmentAssessPojo.servicePoint).indexOf('4') != -1 }">checked="checked"</c:if>> 增強邏輯性思維 </label>
		               					<label><input type="checkbox" value="5"  class="servicePoint" <c:if test="${(treatmentAssessPojo.servicePoint).indexOf('5') != -1 }">checked="checked"</c:if>>增強口肌能力  </label>
		               					</p>
		               					<p>
		               					<label><input type="checkbox" value="6"  class="servicePoint" <c:if test="${(treatmentAssessPojo.servicePoint).indexOf('6') != -1 }">checked="checked"</c:if>>改善發音，以提升說話的清晰度</label>
		               					</p>
						  			</div>
						  			
						  		</div>
						  		<div class="inline-group">
						  			<label style="width:180px;text-align:right">理解口頭指令部位：</label>
						  			<input width="120px" value="${treatmentAssessPojo.sites }" name="sites" type="text" id="sites" ltype="text" />
						  		</div>
						  		<div class="inline-group">
						  			<label style="width:180px;text-align:right">其他：</label>
						  			<textarea rows="2" cols="55" name="suggestOther" id="suggestOther">${treatmentAssessPojo.suggestOther }</textarea>
						  		</div>
						  </div>
						</div>
		  	</div>
		  	
		  	<div tabid="plan" title="言語治療計畫"><!-- 言語治療計畫 -->
		  			<div id="plan_tab" style="height:auto;overflow:auto;">
			            <div id="planDataGrid"></div>
		            </div>
		  	   
		  	</div>
		  	
		  	<div tabid="record" title="言語治療課堂記錄"><!-- 言語治療課堂記錄 -->
		  			<div id="record_tab" style="height:auto;overflow:auto;">
			            <div id="recordDataGrid"></div>
		            </div>
		  	   	
		  	</div>
		  	
		  	<div tabid="report" title="中止/結案報告"><!-- 中止/結案報告 -->
               		 <table>
          			<tbody>
          				<tr>
          					<%--  <td align="right" class="l-table-edit-td">言語治療編號:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${treatmentPojo.caseNo }" type="text" class="caseNo" ltype="text" />
          					 </td> --%>
          					 <td align="right" class="l-table-edit-td">治療結束日期:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${treatmentReportPojo.closeDate_str }" name="closeDate" type="text" id="closeDate" ltype="date" />
          					 </td>
          					 <%--  <td align="right" class="l-table-edit-td">治療師:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${treatmentPojo.fullName }" class="fullName" type="text" ltype="text" />
          					 </td> --%>
          				</tr>
          				<tr>
          					<%--  <td align="right" class="l-table-edit-td">會員編號:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${treatmentPojo.birthday_ChnStr }" name="birthday_ChnStr" type="text" id="birthday_ChnStr" ltype="date" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">非會員編號:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${treatmentPojo.cardNo }" name="cardNo" type="text" id="cardNo" ltype="text" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">姓名:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${treatmentPojo.sex }" name="sex" type="text" id="sex" ltype="text" />
          					 </td> --%>
          					<%--   <td align="right" class="l-table-edit-td">性別:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${treatmentPojo.mobileTelNo }" name="mobileTelNo" type="text" id="mobileTelNo" ltype="text" />
          					 </td> --%>
          				</tr>
          				<tr>
          					<%--  <td align="right" class="l-table-edit-td">出生日期:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${treatmentPojo.father }" name="father" type="text" id="father" ltype="text" />
          					 </td>
          					  <td align="right" class="l-table-edit-td">聯繫電話:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${treatmentPojo.mother }" name="mother" type="text" id="mother" ltype="text" />
          					 </td> --%>
          					 <td align="right" class="l-table-edit-td">中止/結案原因:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${treatmentReportPojo.reason }" name="reason" type="text" id="reason" ltype="text" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">臨床觀察其表現:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${treatmentReportPojo.performance }" name="performance" type="text" id="performance" ltype="text" />
          					 </td>
          				</tr>
          				<tr>
          					 <td align="right" class="l-table-edit-td">建議:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${treatmentReportPojo.suggest }" name="suggest" type="text" id="suggest" ltype="text" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">療程小結:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${treatmentReportPojo.summary }" name="summary" type="text" id="summary" ltype="text" />
          					 </td>
          				</tr>
          				<tr>
          					 <td align="right" class="l-table-edit-td">主管:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${treatmentReportPojo.handler }" name="handler" type="text" id="handler" ltype="text" />
          					 </td>
          					  <td align="right" class="l-table-edit-td">日期:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${treatmentReportPojo.handleDate_str }" name="handleDate" type="text" id="handleDate" ltype="date" />
          					 </td>
          				</tr>
          				<tr>
          					 <td align="right" class="l-table-edit-td">主管意見及建議:</td>
          					 <td align="left" class="l-table-edit-td" colspan="3">
          					 	<textarea rows="2" cols="55" class="ui-textarea" name="handleSuggest" >${treatmentReportPojo.handleSuggest }</textarea>
          					 </td>
          				</tr>
          			</tbody>
          		</table>
              
              
		  	</div>
	  </div>
       
		<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
          </form>
        
        
        
        
    
    
    
</body>
</html>