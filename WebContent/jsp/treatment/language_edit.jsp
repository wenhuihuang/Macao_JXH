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
		var eduLevelData = [{eduLevel:1,text:'山頂醫院 '},{retardedReportSource:2,text:'鏡湖醫院'},{retardedReportSource:3,text:'教青局'},{retardedReportSource:4,text:'復康服務綜合評估中心'},{retardedReportSource:5,text:'其他'}];
		
		var familyDataGridColumn = [
									{ display: 'familyID', name: 'familyID', hide:true },
				                    { display: '姓名', name: 'userName', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '關係', name: 'relationShip', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '年齡', name: 'age', width: 150 ,type:"text",editor: { type: 'text'}},
				                    { display: '教育程度', name: 'eduLevel',width:250
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
		
		var url = "LanguageTreatment/getTreatmentFamily.do?treatmentID="+$("#treatmenuID").val();
		
		familyDataGrid = ligerGrid("familyDataGrid",null,familyDataGridColumn,url,familyDataGridToolBar,false);
		
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
				                    { display: '開始日期', name: 'assessDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '結束日期', name: 'assessDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '級別', name: 'grade', width: 150 ,type:"text",editor: { type: 'text'}},
				                    { display: '備註', name: 'schoolNote', width: 150 ,type:"text",editor: { type: 'text'}}
				                  ];
				
				
		var schoolDataGridToolBar = [
	          { text: '新增', click: addSchoolData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteSchoolData, icon: 'delete' , id:"delete" }];
		
		var url = "LanguageTreatment/getBCustomerSchool.do?custID="+$("#custID").val();
		
		schoolDataGrid = ligerGrid("schoolDataGrid",null,schoolDataGridColumn,url,schoolDataGridToolBar,false);
		
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
									{ display: '機構', name: 'retardedDegree', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '治療項目', name: 'treatmentItem', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '治療開始日期', name: 'tStartDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '治療結束日期', name: 'tEndDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '治療內容', name: 'Content', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '備註', name: 'tNote', width: 100,type:"text",editor: { type: 'text' }},
								];
				
				
		var cureDataGridToolBar = [
	          { text: '新增', click: addCureData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteCureData, icon: 'delete' , id:"delete" }];
		
		var url = "LanguageTreatment/getTreatmentHistory.do?custID="+$("#custID").val();
		
		cureDataGrid = ligerGrid("cureDataGrid",null,cureDataGridColumn,url,cureDataGridToolBar,false);
		
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
		
		var url = "LanguageTreatment/getTreatmentPlan.do?treatmentID="+$("#treatmentID").val();
		
		planDataGrid = ligerGrid("planDataGrid",null,planDataGridColumn,url,planDataGridToolBar,false);
		
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
		
		var url = "LanguageTreatment/getTreatmentRecord.do?treatmentID="+$("#treatmentID").val();
		
		recordDataGrid = ligerGrid("recordDataGrid",null,recordDataGridColumn,url,recordDataGridToolBar,false);
		
	}
	function addRecordData(){
		recordDataGrid.addRow();
	}
	function deleteRecordData(){
		recordDataGrid.deleteSelectedRow();
	}
    
	$(function(){
		
		$(".toptoolbar").ligerToolBar({ items: [
            { text: '保存', click: ligerUiFn.itemClick, icon: 'save' , id:"save" },
            { line: true },
            { text: '取消', click: ligerUiFn.itemClick, icon: 'back' , id:"back" }
          ]
          });
		
		
		
		ligerForm("form1");
		bindingFamilyDataGrid();
		bindingSchoolDataGrid();
		bindingCureDataGrid();
		bindingPlanDataGrid();
		bindingRecordDataGrid();
		
	 $("#tab").ligerTab({onAfterSelectTabItem:function(targettabid){
			switch(targettabid){
				case "serviceData":showGridInTab(familyDataGrid);break;
				case "schoolDataGrid": showGridInTab(schoolDataGrid);break;
				case "cureDataGrid":showGridInTab(cureDataGrid);break;
				case "planDataGrid": showGridInTab(planDataGrid);break;
				case "recordDataGrid": showGridInTab(recordDataGrid);break;
				default:break;
			}
		}}); 
	 
	 		
		
    })
        
    </script>
</head>
<body>
	<div class="toptoolbar"></div>
	<form name="form1" class="liger-form" method="post" action="LanguageTreatment/submit.do" id="form1" style="margin: 20px;">
	<input type="hidden" name="custID" id="custID" value="${languageTreatmentPojo.custID }">
	<input type="hidden" name="treatmentID" id="treatmentID" value="${languageTreatmentPojo.treatmentID }">
	<table>
		<tbody>
            <tr>
            	<td align="right" class="l-table-edit-td">語言治療編號：</td>
                <td align="left" class="l-table-edit-td">
                	<input width="120px" value="${languageTreatmentPojo.treatmentNO }" name="treatmentNO" type="text" id="treatmentNO" ltype="text"">
                </td>
            
                <td align="right" class="l-table-edit-td">姓名：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${languageTreatmentPojo.fullName }" name="fullName" type="text" id="fullName"/></td>
                
                <td align="right" class="l-table-edit-td">會員編號：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${languageTreatmentPojo.custNO }" name="custNO" type="text" id="custNO" /></td>
                
                <td align="right" class="l-table-edit-td">非會員編號：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${languageTreatmentPojo.custNewNO }" name="custNewNO" type="text" id="custNewNO" /></td>
              </tr>
              <tr>
                 <td align="right" class="l-table-edit-td">出生日期:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${languageTreatmentPojo.birthday_ChnStr }" name="father" type="text" id="birthday_ChnStr" ltype="date" />
				 </td>
				  <td align="right" class="l-table-edit-td">聯繫電話:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${languageTreatmentPojo.mobileTelNO }" name="mother" type="text" id="mobileTelNO" ltype="text" />
				 </td>
				  <td align="right" class="l-table-edit-td">性別:</td>
				<td align="left" class="l-table-edit-td" id="sex">
                	<input id="sex1" type="radio" disabled="disabled" name="sex"  value="1" <c:if test="${custCasePojo.sex != 2 }">checked="checked"</c:if> /><label for="sex1">男</label> 
					<input id="sex2" type="radio" disabled="disabled" name="sex" value="2" <c:if test="${custCasePojo.sex == 2 }">checked="checked"</c:if> /><label for="sex2">女</label>
                </td>
               	<td align="right" class="l-table-edit-td">治療師：</td>
                <td align="left" class="l-table-edit-td">
                <input width="120px" value="${languageTreatmentPojo.worker }" name="worker" type="text" id="worker" ltype="text"/>
                </td>
            </tr>
		</tbody>
	</table>
	<div id="tab">
		  	<div title="登記服務資料" id="serviceData"><!-- 登記服務資料 -->
		  		
		  		<table cellpadding="0" cellspacing="0" class="l-table-edit" >
			        <tbody>
			       <%--      <tr>
			                <td align="right" class="l-table-edit-td">姓名：</td><!-- 有name -->
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${languageTreatmentPojo.caseNo }" name="caseNo" type="text" class="caseNo" ltype="text" validate="{required:true,notnull:true}"/></td>
			                
			                <td align="right" class="l-table-edit-td">會員編號：</td><!-- 有name -->
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${languageTreatmentPojo.billDate_str }" name="billDate" type="text" id="billDate" ltype="date" validate="{required:true,notnull:true}"/></td>
			                
			                <td align="right" class="l-table-edit-td">非會員編號：</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${languageTreatmentPojo.caseWorker }" name="caseWorker" type="text" id="caseWorker" ltype="text" /></td>
			                
			                <td align="right" class="l-table-edit-td">語言治療編號：</td>
			                <td align="left" class="l-table-edit-td">
			                	<input type="text" id="caseStatus">
			                </td>
			
			              
			            </tr> --%>
			           	
			          
			             <tr>
			             	
			             <%-- 	<td align="right" class="l-table-edit-td">治療師：</td>
			                <td align="left" class="l-table-edit-td">
			                <input width="120px" value="${languageTreatmentPojo.worker }" name="worker" type="text" id="worker" ltype="text"/>
			                </td> --%>
			                
			                <td align="right" class="l-table-edit-td">申請服務日期：</td>
			                <td align="left" class="l-table-edit-td">
			                <input width="120px" value="${languageTreatmentPojo.applyDate_str }" name="applyDate" type="text" id="applyDate" ltype="text"/>
			                </td>
			                
			                <td align="right" class="l-table-edit-td">服務狀態：</td><!-- 有name -->
			                <td align="left" class="l-table-edit-td"><input width="120px"  value="${languageTreatmentPojo.serviceStatus }" name="serviceStatus" type="text" ltype="text""/></td>
			                
			                <td align="right" class="l-table-edit-td">輸候開始日期：</td>
			                <td align="left" class="l-table-edit-td">
			                	<input width="120px" value="${languageTreatmentPojo.mobileTelNo }" name="mobileTelNo" type="text" id="mobileTelNo" ltype="date" /> 
			                </td>
			                
			             </tr>
			            <tr>
			            	
			                
			                <td align="right" class="l-table-edit-td">接受治療原因：</td>
			                <td align="left" class="l-table-edit-td">
			                <input width="120px" value="${languageTreatmentPojo.reason }" name="reason" type="text" id="reason" ltype="text" />
			                </td>
			                <td align="right" class="l-table-edit-td">注意事項:</td>
			                <td align="left" class="l-table-edit-td"><input width="120px"  value="${languageTreatmentPojo.note }" name="note" type="text" ltype="text" /></td>
			                
			                
			                
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
							    	<textarea rows="2" cols="55" name="familySituation" id="familySituation">${languageTreatmentPojo.familySituation }</textarea>
							   		<%-- <input width="120px" value="${languageTreatmentPojo.familySituation }" name="familySituation" type="text" id="familySituation" ltype="text" /> --%>
							    </div>
							</div>
						</div>
		               
		            </div>
		            
		            	<div class="panel panel-default">
		            		<div class="panel-heading">身體背景資料</div>
		            		<div class="panel-body">
		            			<table class="table table-bordered">
				            		<thead>
				            			<tr>
				            				<th>項目</th>
				            				<th>是否做過評估</th>
				            				<th>程度</th>
				            				<th>評估時間</th>
				            				<th>評估地點</th>
				            				<th>評估描述</th>
				            				<th>備註</th>
				            			</tr>
				            		</thead>
				            		<tbody>
				            			<tr>
				            				<th>體能</th>
				            				<td>${languageTreatmentPojo.physicalAssess }</td>
				            				<td>${languageTreatmentPojo.physicalLevel }</td>
				            				<td>${languageTreatmentPojo.physicalDate }</td>
				            				<td>${languageTreatmentPojo.physicalPlace }</td>
				            				<td>${languageTreatmentPojo.physicalDescribe }</td>
				            				<td>${languageTreatmentPojo.physicalNote }</td>
				            			</tr>
				            			<tr>
				            				<th>視力</th>
				            				<td>${languageTreatmentPojo.visionAssess }</td>
				            				<td>${languageTreatmentPojo.visionLevel }</td>
				            				<td>${languageTreatmentPojo.visionDate }</td>
				            				<td>${languageTreatmentPojo.visionPlace }</td>
				            				<td>${languageTreatmentPojo.visionDescribe }</td>
				            				<td>${languageTreatmentPojo.visionNote }</td>
				            			</tr>
				            			<tr>
				            				<th>聽力</th>
				            				<td>${languageTreatmentPojo.hearingAssess }</td>
				            				<td>${languageTreatmentPojo.hearingLevel }</td>
				            				<td>${languageTreatmentPojo.hearingDate }</td>
				            				<td>${languageTreatmentPojo.hearingPlace }</td>
				            				<td>${languageTreatmentPojo.hearingDescribe }</td>
				            				<td>${languageTreatmentPojo.hearingNote }</td>
				            			</tr>
				            			<tr>
				            				<th>智力</th>
				            				<td>${languageTreatmentPojo.iQAssess }</td>
				            				<td>${languageTreatmentPojo.iQLevel }</td>
				            				<td>${languageTreatmentPojo.iQDate }</td>
				            				<td>${languageTreatmentPojo.iQPlace }</td>
				            				<td>${languageTreatmentPojo.iQDescribe }</td>
				            				<td>${languageTreatmentPojo.iQNote }</td>
				            			</tr>
				            			<tr>
				            				<th>言語</th>
				            				<td>${languageTreatmentPojo.speechAssess }</td>
				            				<td>${languageTreatmentPojo.speechLevel }</td>
				            				<td>${languageTreatmentPojo.speechDate }</td>
				            				<td>${languageTreatmentPojo.speechPlace }</td>
				            				<td>${languageTreatmentPojo.speechDescribe }</td>
				            				<td>${languageTreatmentPojo.speechNote }</td>
				            			</tr>
				            			<tr>
				            				<th>行為情緒</th>
				            				<td>${languageTreatmentPojo.behaviorAssess }</td>
				            				<td>${languageTreatmentPojo.behaviorLevel }</td>
				            				<td>${languageTreatmentPojo.behaviorDate }</td>
				            				<td>${languageTreatmentPojo.behaviorPlace }</td>
				            				<td>${languageTreatmentPojo.behaviorDescribe }</td>
				            				<td>${languageTreatmentPojo.behaviorNote }</td>
				            			</tr>
				            		</tbody>
				            	</table>
				            	<div>
				                	<label>其他：</label>
				                	<textarea rows="2" cols="55" name="familySituation" id="familySituation">${languageTreatmentPojo.familySituation }</textarea>
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
					                <div class="form-group">
					                	<label class="col-md-2 control-label">接受物理評估原因：</label>
					                	<div class="col-md-10">
					                		<input width="120px" value="${languageTreatmentPojo.physicalReason }" name="physicalReason" type="text" id="physicalReason" ltype="text"/>
					                	</div>
					                </div>
					                <div class="form-group">
					                	<label class="col-md-2 control-label">何以得知有此服務：</label>
					                	<div class="col-md-10">
					                		<input width="120px" value="${languageTreatmentPojo.knowReason }" name="knowReason" type="text" id="knowReason" ltype="text"/>
					                	</div>
					                </div>
					                <div class="form-group">
					                	<label class="col-md-2 control-label">對職業治療服務的期望：</label>
					                	<div class="col-md-10">
					                		<input width="120px" value="${languageTreatmentPojo.wish }" name="wish" type="text" id="wish" ltype="text"/>
					                	</div>
					                </div>
					                <div class="form-group">
					                	<label class="col-md-2 control-label">其他：</label>
					                	<div class="col-md-10">
					                		<input width="120px" value="${languageTreatmentPojo.otherReason }" name="otherReason" type="text" id="otherReason" ltype="text"/>
					                	</div>
					                </div>
		            		</div>
		            	</div>
			                
		            </div>
		            
			       
		  	</div>
		  	
		  	<div id="presentation" title="語言治療評估簡報"><!-- 語言治療評估簡報 -->
               		<table cellpadding="0" cellspacing="0" class="l-table-edit" >
               			<tbody>
               				<tr>
               					<%--  <td align="right" class="l-table-edit-td" >姓名:</td>
               					 <td align="left" class="l-table-edit-td">
               					 <input width="120px" value="${languageTreatmentPojo.fullName }" type="text" class="fullName" ltype="text" />
               					 </td>
               					 
               					  <td align="right" class="l-table-edit-td">會員編號:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${languageTreatmentPojo.billDate_str }" name="billDate_str" type="text" id="billDate_str" ltype="date" /></td>
               					 <td align="right" class="l-table-edit-td">非會員編號:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${languageTreatmentPojo.billTime }" name="billTime" type="text" id="billTime" ltype="text" /></td>
               					   --%>
               					  <td align="right" class="l-table-edit-td">評估類別:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${languageTreatmentPojo.assessCategory }" name="assessCategory" type="text" id="assessCategory" ltype="text" /></td>
               				</tr>
               				<tr>
            <%-- 				 <td align="right" class="l-table-edit-td">言語治療編號:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${languageTreatmentPojo.treatmentNO }" name="place" type="text" id="place" ltype="text" /></td> --%>
               					 <td align="right" class="l-table-edit-td">評估日期:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${languageTreatmentPojo.billDate_str }" name="billDate" type="text" id="billDate" ltype="text" /></td>
               					 <td align="right" class="l-table-edit-td">評估地點:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${languageTreatmentPojo.place }" name="place" type="text" id="place" ltype="text" /></td>
               					  <td align="right" class="l-table-edit-td">評估治療師:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${languageTreatmentPojo.worker }" name="worker" type="text" id="worker" ltype="text" /></td>
               				</tr>
               				<tr>
               					 <td align="right" class="l-table-edit-td">參與評估職員:</td>
               					 <td align="left" class="l-table-edit-td">
               					 	<input width="120px" value="${languageTreatmentPojo.otherWokers }" name="otherWokers" type="text" id="otherWokers" ltype="text" />
               					 </td>
               				</tr>
               				<tr>
               					 <td align="right" class="l-table-edit-td">陪同家人/:</td>
               					 <td align="left" class="l-table-edit-td">
               					 	<input width="120px" value="${languageTreatmentPojo.otherFamily }" name="otherFamily" type="text" id="otherFamily" ltype="text" />
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
		               					 	<input width="120px" value="${languageTreatmentPojo.focus }" name="focus" type="text" id="focus" ltype="text" />
		               					</td>
		               					 <td align="right" class="l-table-edit-td">目光接觸:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${languageTreatmentPojo.eyeContact }" name="eyeContact" type="text" id="eyeContact" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">玩具操作技巧:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${languageTreatmentPojo.toySkill }" name="toySkill" type="text" id="toySkill" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">對聲音的反應:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${languageTreatmentPojo.soundsReply }" name="soundsReply" type="text" id="soundsReply" ltype="text" />
		               					</td>
		               				</tr>
		               				<tr>
		               					<td align="right" class="l-table-edit-td">模仿能力:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${languageTreatmentPojo.imitation }" name="imitation" type="text" id="imitation" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">備通意願:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${languageTreatmentPojo.communicate }" name="communicate" type="text" id="communicate" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">物件概念:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${languageTreatmentPojo.conceptual }" name="conceptual" type="text" id="conceptual" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">其他:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${languageTreatmentPojo.ability }" name="ability" type="text" id="ability" ltype="text" />
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
		               					 	<label><input type="checkbox"<c:if test="${languageTreatmentPojo.ability }"></c:if>>手勢</label>
		               						<label><input type="checkbox">聲音</label>
		               						<label><input type="checkbox">圖片</label>
		               						<label><input type="checkbox">言語</label>
		               					</td>
		               					 <td align="right" class="l-table-edit-td">句子長度:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<label><input type="checkbox">手勢</label>
		               						<label><input type="checkbox">聲音</label>
		               						<label><input type="checkbox">圖片</label>
		               						<label><input type="checkbox">言語</label>
		               					</td>
		               					<td align="right" class="l-table-edit-td">句子組成:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<label><input type="checkbox">手勢</label>
		               						<label><input type="checkbox">聲音</label>
		               						<label><input type="checkbox">圖片</label>
		               						<label><input type="checkbox">言語</label>
		               					</td>
		               					<td align="right" class="l-table-edit-td">問句運用:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<label><input type="checkbox">手勢</label>
		               						<label><input type="checkbox">聲音</label>
		               						<label><input type="checkbox">圖片</label>
		               						<label><input type="checkbox">言語</label>
		               					</td>
		               				</tr>
		               				<tr>
		               					<td align="right" class="l-table-edit-td">敘事能力:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<label><input type="checkbox">手勢</label>
		               						<label><input type="checkbox">聲音</label>
		               						<label><input type="checkbox">圖片</label>
		               						<label><input type="checkbox">言語</label>
		               					</td>
		               					<td align="right" class="l-table-edit-td">說故事技巧:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<label><input type="checkbox">手勢</label>
		               						<label><input type="checkbox">聲音</label>
		               						<label><input type="checkbox">圖片</label>
		               						<label><input type="checkbox">言語</label>
		               					</td>
		               					<td align="right" class="l-table-edit-td">對答技巧:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<label><input type="checkbox">手勢</label>
		               						<label><input type="checkbox">聲音</label>
		               						<label><input type="checkbox">圖片</label>
		               						<label><input type="checkbox">言語</label>
		               					</td>
		               					<td align="right" class="l-table-edit-td">其他:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${languageTreatmentPojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
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
		               					 	<input width="120px" value="${languageTreatmentPojo.words }" name="words" type="text" id="words" ltype="text" />
		               					</td>
		               					 <td align="right" class="l-table-edit-td">口頭指令:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${languageTreatmentPojo.oralOrder }" name="oralOrder" type="text" id="oralOrder" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">問句:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${languageTreatmentPojo.questions }" name="questions" type="text" id="questions" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">故事:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${languageTreatmentPojo.story }" name="story" type="text" id="story" ltype="text" />
		               					</td>
		               				</tr>
		               				<tr>
		               					<td align="right" class="l-table-edit-td">邏輯思維:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${languageTreatmentPojo.logical }" name="logical" type="text" id="logical" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">物件概念:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${languageTreatmentPojo.underStandConceptual }" name="underStandConceptual" type="text" id="underStandConceptual" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">其他:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${languageTreatmentPojo.underStandOther }" name="underStandOther" type="text" id="underStandOther" ltype="text" />
		               					</td>
						    		</tr>
						    	</tbody>
						    </table>
						  </div>
						</div>
						
						<div class="panel panel-default">
						  <div class="panel-heading">兒童在發音方面有以下困難</div>
						  <div class="panel-body">
						    <table class="table table-bordered">
						    	<thead>
						    		<tr>
						    			<th>項目</th>
						    			<th>有/無</th>
						    			<th>描述</th>
						    		</tr>
						    	</thead>
						    	<tbody>
						    		<tr>
						    			<th>元音/複元音</th>
						    			<td>${languageTreatmentPojo.vowel }</td>
						    			<td>${languageTreatmentPojo.vowelNote }</td>
						    		</tr>
						    		<tr>
						    			<th>前輔音</th>
						    			<td>${languageTreatmentPojo.beforeConsonant }</td>
						    			<td>${languageTreatmentPojo.beforeConsonantNote }</td>
						    		</tr>
						    		<tr>
						    			<th>後輔音</th>
						    			<td>${languageTreatmentPojo.afterConsonant }</td>
						    			<td>${languageTreatmentPojo.afterConsonantNote }</td>
						    		</tr>
						    		<tr>
						    			<th>聲調</th>
						    			<td>${languageTreatmentPojo.tone }</td>
						    			<td>${languageTreatmentPojo.toneNote }</td>
						    		</tr>
						    		<tr>
						    			<th>其他</th>
						    			<td colspan="2">
						    				<textarea rows="2" cols="55" name="pronunciationOther" id="pronunciationOther">${languageTreatmentPojo.pronunciationOther }</textarea>
						    			</td>
						    		</tr>
						    	</tbody>
						    </table>
						  </div>
						</div>
						
						<div class="panel panel-default">
						  <div class="panel-heading">其他</div>
						  <div class="panel-body">
						  	<textarea name="other" rows="2" cols="55">${languageTreatmentPojo.other }</textarea>
						  </div>
						</div>
						
						<div class="panel panel-default">
						  <div class="panel-heading">建議</div>
						  <div class="panel-body">
						    	    <table>
						    	<tbody>
						    		<tr>
						    			<td align="right" class="l-table-edit-td">接受言語治療服務:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	
		               					</td>
		               					 <td align="right" class="l-table-edit-td">接受言語治療服務，訓練重點為:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<label><input type="checkbox">提高溝通意識 </label>
		               					 	<label><input type="checkbox">擴闊詞彙的理解和表達 </label>
		               					 	<label><input type="checkbox"> 增長句子的長度及複雜度 </label>
		               					 	<label><input type="checkbox">增強說話的組織能力 </label>
		               						<label><input type="checkbox"> 增強邏輯性思維 </label>
		               						<label><input type="checkbox">增強口肌能力  </label>
		               						<label><input type="checkbox">改善發音，以提升說話的清晰度</label>
		               					</td>
		               					<td align="right" class="l-table-edit-td">理解口頭指令部位:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${languageTreatmentPojo.sites }" name="sites" type="text" id="sites" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">其他:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${languageTreatmentPojo.suggestOther }" name="suggestOther" type="text" id="suggestOther" ltype="text" />
		               					</td>
		               				</tr>
						    	</tbody>
						    </table>
						  </div>
						</div>
		  	</div>
		  	
		  	<div id="plan" title="言語治療計畫"><!-- 言語治療計畫 -->
		  			<div id="plan_tab" style="height:auto;overflow:auto;">
			            <div id="planDataGrid"></div>
		            </div>
		  	   
		  	</div>
		  	
		  	<div id="record" title="言語治療課堂記錄"><!-- 言語治療課堂記錄 -->
		  			<div id="record_tab" style="height:auto;overflow:auto;">
			            <div id="recordDataGrid"></div>
		            </div>
		  	   	
		  	</div>
		  	
		  	<div id="report" title="中止/結案報告"><!-- 中止/結案報告 -->
               		 <table>
          			<tbody>
          				<tr>
          					<%--  <td align="right" class="l-table-edit-td">言語治療編號:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${languageTreatmentPojo.caseNo }" type="text" class="caseNo" ltype="text" />
          					 </td> --%>
          					  <td align="right" class="l-table-edit-td">治療開始日期:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${languageTreatmentPojo.custNo }" name="custNo" type="text" id="custNo" ltype="text" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">治療結束日期:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${languageTreatmentPojo.custNewNo }" name="custNewNo" type="text" id="custNewNo" ltype="text" />
          					 </td>
          					 <%--  <td align="right" class="l-table-edit-td">治療師:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${languageTreatmentPojo.fullName }" class="fullName" type="text" ltype="text" />
          					 </td> --%>
          				</tr>
          				<tr>
          					<%--  <td align="right" class="l-table-edit-td">會員編號:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${languageTreatmentPojo.birthday_ChnStr }" name="birthday_ChnStr" type="text" id="birthday_ChnStr" ltype="date" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">非會員編號:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${languageTreatmentPojo.cardNo }" name="cardNo" type="text" id="cardNo" ltype="text" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">姓名:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${languageTreatmentPojo.sex }" name="sex" type="text" id="sex" ltype="text" />
          					 </td> --%>
          					<%--   <td align="right" class="l-table-edit-td">性別:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${languageTreatmentPojo.mobileTelNo }" name="mobileTelNo" type="text" id="mobileTelNo" ltype="text" />
          					 </td> --%>
          				</tr>
          				<tr>
          					<%--  <td align="right" class="l-table-edit-td">出生日期:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${languageTreatmentPojo.father }" name="father" type="text" id="father" ltype="text" />
          					 </td>
          					  <td align="right" class="l-table-edit-td">聯繫電話:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${languageTreatmentPojo.mother }" name="mother" type="text" id="mother" ltype="text" />
          					 </td> --%>
          					 <td align="right" class="l-table-edit-td">中止/結案原因:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${languageTreatmentPojo.reason }" name="reason" type="text" id="reason" ltype="text" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">臨床觀察其表現:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${languageTreatmentPojo.performance }" name="performance" type="text" id="performance" ltype="text" />
          					 </td>
          				</tr>
          				<tr>
          					 <td align="right" class="l-table-edit-td">建議:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${languageTreatmentPojo.suggest }" name="suggest" type="text" id="suggest" ltype="text" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">療程小結:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${languageTreatmentPojo.summary }" name="summary" type="text" id="summary" ltype="text" />
          					 </td>
          				</tr>
          				<tr>
          					 <td align="right" class="l-table-edit-td">主管:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${languageTreatmentPojo.handler }" name="handler" type="text" id="handler" ltype="text" />
          					 </td>
          					  <td align="right" class="l-table-edit-td">日期:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${languageTreatmentPojo.handleDate_str }" name="handleDate" type="text" id="handleDate" ltype="date" />
          					 </td>
          				</tr>
          				<tr>
          					 <td align="right" class="l-table-edit-td">主管意見及建議:</td>
          					 <td align="left" class="l-table-edit-td" colspan="3">
          					 	<textarea rows="2" cols="55" class="ui-textarea" name="handleSuggest" >${languageTreatmentPojo.handleSuggest }</textarea>
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