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
<jsp:include page="/jsp/head.jsp"></jsp:include>
<title>個案資料管理</title>
<script type="text/javascript">
        var familyDataGrid,
        	schoolDataGrid,
        	cureDataGrid,
        	planDataGrid,
        	recordDataGrid;
        
        //家庭背景
		function bindingFamilyDataGrid(){
		//大腦發育遲緩/自閉症/唐氏綜合症/腦癱/多動症/情緒行為障礙/語言障礙/身體障礙/其他障礙
		var retardedTypeData = [{ retardedType: 1, text: '大腦發育遲緩' }, { retardedType: 2, text: '自閉症'}, { retardedType: 3, text: '唐氏綜合症'}, { retardedType: 4, text: '腦癱'}, { retardedType: 5, text: '多動症'}, { retardedType: 6, text: '情緒行為障礙'}, { retardedType: 7, text: '語言障礙'}, { retardedType: 8, text: '身體障礙'}, { retardedType: 9, text: '其他障礙'}];
		//輕/中/重/機種
		var retardedDegreeData = [{retardedDegree:1,text:'輕'},{retardedDegree:2,text:'中'},{retardedDegree:3,text:'重'}];
		//有/無
		var hasRetardedReportData = [{hasRetardedReport:0,text:'無'},{hasRetardedReport:1,text:'有'}];
		//山頂醫院 /鏡湖醫院/教青局 /復康服務綜合評估中心 /其他
		var retardedReportSourceData = [{retardedReportSource:1,text:'山頂醫院 '},{retardedReportSource:2,text:'鏡湖醫院'},{retardedReportSource:3,text:'教青局'},{retardedReportSource:4,text:'復康服務綜合評估中心'},{retardedReportSource:5,text:'其他'}];
		
		var familyDataGridColumn = [
									{ display: 'retardedID', name: 'retardedID', hide:true },
				                    { display: '姓名', name: 'retardedType', align: 'left',  width: 150 
				                    	,editor: { type: 'select', data: retardedTypeData, valueField: 'retardedType' },
				                        render: function (item)
				                        {
				                            return getGridSelectedData(retardedTypeData[parseInt(item.retardedType)-1]);
				                        }},
				                    { display: '關係', name: 'retardedDegree', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '年齡', name: 'hasRetardedReport', width: 150 ,type:"text",editor: { type: 'text'}},
				                    { display: '教育程度', name: 'retardedReportSource',width:250
			                        	,editor: { type: 'select', data: retardedReportSourceData, valueField: 'retardedReportSource' },
				                        render: function (item)
				                        {
				                        	return getGridSelectedData(retardedReportSourceData[parseInt(item.retardedReportSource)-1]);
				                        }},
				                    { display: '職業', name: 'assessDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '所說語言', name: 'note',width:300, type:"text", editor: { type: 'text'}},
				                    { display: '備註', name: 'note',width:300, type:"text", editor: { type: 'text'}}
				                  ];
				
				
		var familyDataGridToolBar = [
	          { text: '新增', click: addFamilyData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteFamilyData, icon: 'delete' , id:"delete" }];
		
		var url = "Customer/getRetarded.do?CUSTID="+$("#custId").val();
		
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
		var retardedTypeData = [{ retardedType: 1, text: '大腦發育遲緩' }, { retardedType: 2, text: '自閉症'}, { retardedType: 3, text: '唐氏綜合症'}, { retardedType: 4, text: '腦癱'}, { retardedType: 5, text: '多動症'}, { retardedType: 6, text: '情緒行為障礙'}, { retardedType: 7, text: '語言障礙'}, { retardedType: 8, text: '身體障礙'}, { retardedType: 9, text: '其他障礙'}];
		//輕/中/重/機種
		var retardedDegreeData = [{retardedDegree:1,text:'輕'},{retardedDegree:2,text:'中'},{retardedDegree:3,text:'重'}];
		//有/無
		var hasRetardedReportData = [{hasRetardedReport:0,text:'無'},{hasRetardedReport:1,text:'有'}];
		//山頂醫院 /鏡湖醫院/教青局 /復康服務綜合評估中心 /其他
		var retardedReportSourceData = [{retardedReportSource:1,text:'山頂醫院 '},{retardedReportSource:2,text:'鏡湖醫院'},{retardedReportSource:3,text:'教青局'},{retardedReportSource:4,text:'復康服務綜合評估中心'},{retardedReportSource:5,text:'其他'}];
		
		var schoolDataGridColumn = [
									{ display: 'retardedID', name: 'retardedID', hide:true },
				                    { display: '學校', name: 'retardedType', align: 'left',  width: 150 
				                    	,editor: { type: 'select', data: retardedTypeData, valueField: 'retardedType' },
				                        render: function (item)
				                        {
				                            return getGridSelectedData(retardedTypeData[parseInt(item.retardedType)-1]);
				                        }},
				                    { display: '開始日期', name: 'retardedDegree', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '結束日期', name: 'hasRetardedReport', width: 150 ,type:"text",editor: { type: 'text'}},
				                    { display: '級別', name: 'retardedReportSource',width:250
			                        	,editor: { type: 'select', data: retardedReportSourceData, valueField: 'retardedReportSource' },
				                        render: function (item)
				                        {
				                        	return getGridSelectedData(retardedReportSourceData[parseInt(item.retardedReportSource)-1]);
				                        }},
				                    { display: '備註', name: 'assessDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                  ];
				
				
		var schoolDataGridToolBar = [
	          { text: '新增', click: addSchoolData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteSchoolData, icon: 'delete' , id:"delete" }];
		
		var url = "Customer/getRetarded.do?CUSTID="+$("#custId").val();
		
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
		var retardedTypeData = [{ retardedType: 1, text: '大腦發育遲緩' }, { retardedType: 2, text: '自閉症'}, { retardedType: 3, text: '唐氏綜合症'}, { retardedType: 4, text: '腦癱'}, { retardedType: 5, text: '多動症'}, { retardedType: 6, text: '情緒行為障礙'}, { retardedType: 7, text: '語言障礙'}, { retardedType: 8, text: '身體障礙'}, { retardedType: 9, text: '其他障礙'}];
		//輕/中/重/機種
		var retardedDegreeData = [{retardedDegree:1,text:'輕'},{retardedDegree:2,text:'中'},{retardedDegree:3,text:'重'}];
		//有/無
		var hasRetardedReportData = [{hasRetardedReport:0,text:'無'},{hasRetardedReport:1,text:'有'}];
		//山頂醫院 /鏡湖醫院/教青局 /復康服務綜合評估中心 /其他
		var retardedReportSourceData = [{retardedReportSource:1,text:'山頂醫院 '},{retardedReportSource:2,text:'鏡湖醫院'},{retardedReportSource:3,text:'教青局'},{retardedReportSource:4,text:'復康服務綜合評估中心'},{retardedReportSource:5,text:'其他'}];
		
		var cureDataGridColumn = [
									{ display: 'retardedID', name: 'retardedID', hide:true },
				                    { display: '治療項目', name: 'retardedType', align: 'left',  width: 150 
				                    	,editor: { type: 'select', data: retardedTypeData, valueField: 'retardedType' },
				                        render: function (item)
				                        {
				                            return getGridSelectedData(retardedTypeData[parseInt(item.retardedType)-1]);
				                        }},
				                    { display: '機構', name: 'retardedDegree', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '治療開始日期', name: 'hasRetardedReport', width: 150 ,type:"text",editor: { type: 'text'}},
				                    { display: '治療結束日期', name: 'retardedReportSource',width:250
			                        	,editor: { type: 'select', data: retardedReportSourceData, valueField: 'retardedReportSource' },
				                        render: function (item)
				                        {
				                        	return getGridSelectedData(retardedReportSourceData[parseInt(item.retardedReportSource)-1]);
				                        }},
				                    { display: '治療內容', name: 'assessDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                  	{ display: '備註', name: 'assessDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
								];
				
				
		var cureDataGridToolBar = [
	          { text: '新增', click: addCureData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteCureData, icon: 'delete' , id:"delete" }];
		
		var url = "Customer/getRetarded.do?CUSTID="+$("#custId").val();
		
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
									{ display: 'retardedID', name: 'retardedID', hide:true },
				                    { display: '日期', name: 'retardedType', align: 'left',  width: 150 
				                    	,editor: { type: 'date',}},
				                    { display: '時間', name: 'retardedDegree', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '治療內容', name: 'hasRetardedReport', width: 150 ,type:"text",editor: { type: 'text'}},
				                    { display: '治療目標', name: 'retardedReportSource',width:250
			                        	,editor: { type: 'text',}},
				                    { display: '收費金額', name: 'assessDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                  	{ display: '繳費金額', name: 'assessDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                  	{ display: '備註', name: 'assessDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
								];
				
				
		var planDataGridToolBar = [
	          { text: '新增', click: addPlanData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deletePlanData, icon: 'delete' , id:"delete" }];
		
		var url = "Customer/getRetarded.do?CUSTID="+$("#custId").val();
		
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
		var retardedTypeData = [{ retardedType: 1, text: '大腦發育遲緩' }, { retardedType: 2, text: '自閉症'}, { retardedType: 3, text: '唐氏綜合症'}, { retardedType: 4, text: '腦癱'}, { retardedType: 5, text: '多動症'}, { retardedType: 6, text: '情緒行為障礙'}, { retardedType: 7, text: '語言障礙'}, { retardedType: 8, text: '身體障礙'}, { retardedType: 9, text: '其他障礙'}];
		//輕/中/重/機種
		var retardedDegreeData = [{retardedDegree:1,text:'輕'},{retardedDegree:2,text:'中'},{retardedDegree:3,text:'重'}];
		//有/無
		var hasRetardedReportData = [{hasRetardedReport:0,text:'無'},{hasRetardedReport:1,text:'有'}];
		//山頂醫院 /鏡湖醫院/教青局 /復康服務綜合評估中心 /其他
		var retardedReportSourceData = [{retardedReportSource:1,text:'山頂醫院 '},{retardedReportSource:2,text:'鏡湖醫院'},{retardedReportSource:3,text:'教青局'},{retardedReportSource:4,text:'復康服務綜合評估中心'},{retardedReportSource:5,text:'其他'}];
		
		var recordDataGridColumn = [
									{ display: 'retardedID', name: 'retardedID', hide:true },
				                    { display: '治療項目', name: 'retardedType', align: 'left',  width: 150 
				                    	,editor: { type: 'select', data: retardedTypeData, valueField: 'retardedType' },
				                        render: function (item)
				                        {
				                            return getGridSelectedData(retardedTypeData[parseInt(item.retardedType)-1]);
				                        }},
				                    { display: '機構', name: 'retardedDegree', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '治療開始日期', name: 'hasRetardedReport', width: 150 ,type:"text",editor: { type: 'text'}},
				                    { display: '治療結束日期', name: 'retardedReportSource',width:250
			                        	,editor: { type: 'select', data: retardedReportSourceData, valueField: 'retardedReportSource' },
				                        render: function (item)
				                        {
				                        	return getGridSelectedData(retardedReportSourceData[parseInt(item.retardedReportSource)-1]);
				                        }},
				                    { display: '治療內容', name: 'assessDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                  	{ display: '備註', name: 'assessDate', width: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
								];
				
				
		var recordDataGridToolBar = [
	          { text: '新增', click: addRecordData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteRecordData, icon: 'delete' , id:"delete" }];
		
		var url = "Customer/getRetarded.do?CUSTID="+$("#custId").val();
		
		recordDataGrid = ligerGrid("recordDataGrid",null,recordDataGridColumn,url,recordDataGridToolBar,false);
		
	}
	function addRecordData(){
		recordDataGrid.addRow();
	}
	function deleteRecordData(){
		recordDataGrid.deleteSelectedRow();
	}
    
	$(function(){
		//var navtab=null;
		 // $("#tab").ligerTab();
          //navtab = $("#tab").ligerGetTabManager();
		ligerForm("form1");
		ligerForm("form3");
		bindingFamilyDataGrid();
		bindingSchoolDataGrid();
		bindingCureDataGrid();
		bindingPlanDataGrid();
		bindingRecordDataGrid();
		$("#tab").ligerTab({onAfterSelectTabItem:function(targettabid){
			
		}});
    })
        
    </script>
</head>
<body>
	<div id="tab">
		  	<div title="登記服務資料" id="serviceData"><!-- 登記服務資料 -->
		  		<form name="form1" class="liger-form" method="post" action="CustCase/submit.do" id="form1" style="margin: 20px;">
		  		<table cellpadding="0" cellspacing="0" class="l-table-edit" >
			        <tbody>
			            <tr>
			                <td align="right" class="l-table-edit-td">姓名：</td><!-- 有name -->
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.caseNo }" name="caseNo" type="text" class="caseNo" ltype="text" validate="{required:true,notnull:true}"/></td>
			                
			                <td align="right" class="l-table-edit-td">會員編號：</td><!-- 有name -->
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.billDate_str }" name="billDate" type="text" id="billDate" ltype="date" validate="{required:true,notnull:true}"/></td>
			                
			                <td align="right" class="l-table-edit-td">非會員編號：</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.caseWorker }" name="caseWorker" type="text" id="caseWorker" ltype="text" /></td>
			                
			                <td align="right" class="l-table-edit-td">職業治療編號：</td>
			                <td align="left" class="l-table-edit-td">
			                	<input type="text" id="caseStatus">
			                </td>
			
			              
			            </tr>
			           	
			          
			             <tr>
			             	
			             	<td align="right" class="l-table-edit-td">治療師：</td>
			                <td align="left" class="l-table-edit-td">
			                <input width="120px" value="${custCasePojo.custNo }" name="custNo" type="text" id="custNo" ltype="text" validate="{required:true,notnull:true}"/>
			                </td>
			                
			                <td align="right" class="l-table-edit-td">申請服務日期：</td>
			                <td align="left" class="l-table-edit-td">
			                <input width="120px" value="${custCasePojo.custNewNo }" name="caseNewNo" type="text" id="caseNewNo" ltype="text" validate="{required:true,notnull:true}"/>
			                </td>
			                
			                <td align="right" class="l-table-edit-td">服務狀態：</td><!-- 有name -->
			                <td align="left" class="l-table-edit-td"><input width="120px"  value="${custCasePojo.fullName }" name="fullName" type="text" nameText="fullName" ltype="text" validate="{required:true,notnull:true}"/></td>
			                
			                <td align="right" class="l-table-edit-td">輸候開始日期：</td>
			                <td align="left" class="l-table-edit-td">
			                	<input id="sex1" type="radio" name="sex" value="1" <c:if test="${custCasePojo.sex != 2 }">checked="checked"</c:if> /><label for="sex1">男</label> 
								<input id="sex2" type="radio" name="sex" value="2" <c:if test="${custCasePojo.sex == 2 }">checked="checked"</c:if> /><label for="sex2">女</label>
			                </td>
			                
			             </tr>
			            <tr>
			            	
			                
			                <td align="right" class="l-table-edit-td">接受治療原因：</td>
			                <td align="left" class="l-table-edit-td">
			                <input width="120px" value="${custCasePojo.birthday_ChnStr }" name="validDate" type="text" id="validDate" ltype="date" validate="{required:true,notnull:true}"/>
			                </td>
			                <td align="right" class="l-table-edit-td">注意事項:</td>
			                <td align="left" class="l-table-edit-td"><input width="120px"  value="${custCasePojo.cardNo }" name="cardNo" class="cardNo" type="text" ltype="text" validate="{required:true,notnull:true}"/></td>
			                
			                
			                
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
							   		<input ltype="text" /> 	
							    </div>
							</div>
						</div>
		               
		            </div>
		            
		            	<div class="panel panel-default">
		            		<div class="panel-heading">身體背景資料</div>
		            		<div class="panel-body">
		            			<table border="1">
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
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            			</tr>
				            			<tr>
				            				<th>視力</th>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            			</tr>
				            			<tr>
				            				<th>聽力</th>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            			</tr>
				            			<tr>
				            				<th>智力</th>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            			</tr>
				            			<tr>
				            				<th>言語</th>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            			</tr>
				            			<tr>
				            				<th>行為情緒</th>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            				<td></td>
				            			</tr>
				            		</tbody>
				            	</table>
				            	<div class="form-group">
				                	<label class="col-md-2 control-label">其他：</label>
				                	<div class="col-md-10">
				                		<input class="form-control" type="text" />
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
					                <div class="form-group">
					                	<label class="col-md-2 control-label">接受物理評估原因：</label>
					                	<div class="col-md-10">
					                		<input class="form-control" type="text" />
					                	</div>
					                </div>
					                <div class="form-group">
					                	<label class="col-md-2 control-label">何以得知有此服務：</label>
					                	<div class="col-md-10">
					                		<input class="form-control" type="text" />
					                	</div>
					                </div>
					                <div class="form-group">
					                	<label class="col-md-2 control-label">對職業治療服務的期望：</label>
					                	<div class="col-md-10">
					                		<input class="form-control" type="text" />
					                	</div>
					                </div>
					                <div class="form-group">
					                	<label class="col-md-2 control-label">其他：</label>
					                	<div class="col-md-10">
					                		<input class="form-control" type="text" />
					                	</div>
					                </div>
		            		</div>
		            	</div>
			                
		            </div>
		            
			       </form>
		  	</div>
		  	
		  	<div id="presentation" title="職業治療評估簡報"><!-- 語言治療評估簡報 -->
		  		<form action="">
               		<table cellpadding="0" cellspacing="0" class="l-table-edit" >
               			<tbody>
               				<tr>
               					 <td align="right" class="l-table-edit-td" >姓名:</td>
               					 <td align="left" class="l-table-edit-td">
               					 <input width="120px" value="${custCasePojo.fullName }" type="text" class="fullName" ltype="text" />
               					 </td>
               					 
               					  <td align="right" class="l-table-edit-td">會員編號:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.billDate_str }" name="billDate_str" type="text" id="billDate_str" ltype="date" /></td>
               					 <td align="right" class="l-table-edit-td">非會員編號:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.billTime }" name="billTime" type="text" id="billTime" ltype="text" /></td>
               					  <td align="right" class="l-table-edit-td">評估類別:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.form }" name="form" type="text" id="form" ltype="text" /></td>
               				</tr>
               				<tr>
               					 <td align="right" class="l-table-edit-td">言語治療編號:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.place }" name="place" type="text" id="place" ltype="text" /></td>
               					 <td align="right" class="l-table-edit-td">評估日期:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.family }" name="family" type="text" id="family" ltype="text" /></td>
               					 <td align="right" class="l-table-edit-td">評估地點:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.otherMan }" name="otherMan" type="text" id="otherMan" ltype="text" /></td>
               					  <td align="right" class="l-table-edit-td">評估治療師:</td>
               					 <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.times }" name="times" type="text" id="times" ltype="text" /></td>
               				</tr>
               				<tr>
               					 <td align="right" class="l-table-edit-td">引而參與評估職員:</td>
               					 <td align="left" class="l-table-edit-td">
               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
               					 </td>
               				</tr>
               				<tr>
               					 <td align="right" class="l-table-edit-td">陪同家人/:</td>
               					 <td align="left" class="l-table-edit-td" colspan="3">
               					 	<textarea rows="2" cols="55" class="ui-textarea"  validate="{required:true}" name="title">${custCasePojo.title }</textarea>
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
		               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
		               					</td>
		               					 <td align="right" class="l-table-edit-td">目光接觸:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">玩具操作技巧:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">對聲音的反應:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
		               					</td>
		               				</tr>
		               				<tr>
		               					<td align="right" class="l-table-edit-td">模仿能力:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">備通意願:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">物件概念:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">其他:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
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
		               					 	<label><input type="checkbox">手勢</label>
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
		               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
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
		               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
		               					</td>
		               					 <td align="right" class="l-table-edit-td">口頭指令:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">問句:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">故事:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
		               					</td>
		               				</tr>
		               				<tr>
		               					<td align="right" class="l-table-edit-td">邏輯思維:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">物件概念:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">其他:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
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
						    			<td></td>
						    			<td></td>
						    		</tr>
						    		<tr>
						    			<th>前輔音</th>
						    			<td></td>
						    			<td></td>
						    		</tr>
						    		<tr>
						    			<th>後輔音</th>
						    			<td></td>
						    			<td></td>
						    		</tr>
						    		<tr>
						    			<th>聲調</th>
						    			<td></td>
						    			<td></td>
						    		</tr>
						    		<tr>
						    			<th>其他</th>
						    			<td colspan="2"></td>
						    		</tr>
						    	</tbody>
						    </table>
						  </div>
						</div>
						
						<div class="panel panel-default">
						  <div class="panel-heading">其他</div>
						  <div class="panel-body">
						  	<textarea name="" rows="" cols=""></textarea>
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
		               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
		               					</td>
		               					<td align="right" class="l-table-edit-td">其他:</td>
		               					<td align="left" class="l-table-edit-td">
		               					 	<input width="120px" value="${custCasePojo.recordAdmin }" name="recordAmin" type="text" id="recordAmin" ltype="text" />
		               					</td>
		               				</tr>
						    	</tbody>
						    </table>
						  </div>
						</div>
               	</form>
		  	</div>
		  	
		  	<div id="plan" title="職業治療計畫"><!-- 職業治療計畫 -->
		  		<form name="form3" id="form3">
		  			<div id="plan_tab" style="height:auto;overflow:auto;">
			            <div id="planDataGrid"></div>
		            </div>
		  		</form>
		  	   
		  	</div>
		  	
		  	<div id="record" title="職業治療課堂記錄"><!-- 職業治療課堂記錄 -->
		  		<form>
		  			<div id="record_tab" style="height:auto;overflow:auto;">
			            <div id="recordDataGrid"></div>
		            </div>
		  		</form>
		  	   	
		  	</div>
		  	
		  	<div id="report" title="中止/結案報告"><!-- 中止/結案報告 -->
               <form>
               		 <table>
          			<tbody>
          				<tr>
          					 <td align="right" class="l-table-edit-td">言語治療編號:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.caseNo }" type="text" class="caseNo" ltype="text" />
          					 </td>
          					  <td align="right" class="l-table-edit-td">治療開始日期:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.custNo }" name="custNo" type="text" id="custNo" ltype="text" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">治療結束日期:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.custNewNo }" name="custNewNo" type="text" id="custNewNo" ltype="text" />
          					 </td>
          					  <td align="right" class="l-table-edit-td">治療師:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.fullName }" class="fullName" type="text" ltype="text" />
          					 </td>
          				</tr>
          				<tr>
          					 <td align="right" class="l-table-edit-td">會員編號:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.birthday_ChnStr }" name="birthday_ChnStr" type="text" id="birthday_ChnStr" ltype="date" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">非會員編號:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.cardNo }" name="cardNo" type="text" id="cardNo" ltype="text" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">姓名:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.sex }" name="sex" type="text" id="sex" ltype="text" />
          					 </td>
          					  <td align="right" class="l-table-edit-td">性別:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.mobileTelNo }" name="mobileTelNo" type="text" id="mobileTelNo" ltype="text" />
          					 </td>
          				</tr>
          				<tr>
          					 <td align="right" class="l-table-edit-td">出生日期:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.father }" name="father" type="text" id="father" ltype="text" />
          					 </td>
          					  <td align="right" class="l-table-edit-td">聯繫電話:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.mother }" name="mother" type="text" id="mother" ltype="text" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">中止/結案原因:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">臨床觀察其表現:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.isMarry }" name="isMarry" type="text" id="isMarry" ltype="text" />
          					 </td>
          				</tr>
          				<tr>
          					 <td align="right" class="l-table-edit-td">建議:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.edulevel }" name="edulevel" type="text" id="edulevel" ltype="text" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">療程小結:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.economics }" name="economics" type="text" id="economics" ltype="text" />
          					 </td>
          				</tr>
          				<tr>
          					 <td align="right" class="l-table-edit-td">主管:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.assessWorker }" name="assessWorker" type="text" id="assessWorker" ltype="text" />
          					 </td>
          					  <td align="right" class="l-table-edit-td">日期:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.billDate_str }" name="billDate_str" type="text" id="billDate_str" ltype="date" />
          					 </td>
          				</tr>
          				<tr>
          					 <td align="right" class="l-table-edit-td">主管意見及建議:</td>
          					 <td align="left" class="l-table-edit-td" colspan="3">
          					 	<textarea rows="2" cols="55" class="ui-textarea" name="background"  validate="{required:true}">${custCasePojo.background }</textarea>
          					 </td>
          				</tr>
          			</tbody>
          		</table>
               </form>
              
		  	</div>
	  </div>
       
	
         
        
        
        
        <!--<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />-->
    
    
    
</body>
</html>