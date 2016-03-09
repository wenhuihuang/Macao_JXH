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
        var trainingFlowDataGrid,
       		trainingRecordDataGrid1,
       		trainingRecordDataGrid2,
        	goalDataGrid,
        	budgetDataGrid,
        	reviewDataGrid,
        	accountDataGrid;
        	
        
        //個別住客整日訓練流程
		function bindingTrainingFlowDataGrid(){
		
		var trainingFlowDataGridColumn = [
									{ display: 'planID', name: 'planID', hide:true },
				                    { display: '時間', name: 'billDate', width: 100,type:"text",editor: { type: 'date' }},
				                    { display: '生活日程', name: 'living', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '訓練項目', name: 'item', width: 100 ,type:"text",editor: { type: 'text'}},
				                    { display: '訓練類別', name: 'type', width: 100 ,type:"text",editor: { type: 'text'}},
				                    { display: '訓練內容', name: 'content', width: 150 ,type:"text",editor: { type: 'text'}},
				                    { display: '訓練時數', name: 'time',width:300, type:"text", editor: { type: 'text'}},
				                    { display: '備註', name: 'note',width:300, type:"text", editor: { type: 'text'}}
				                  ];
				
				
		var trainingFlowDataGridToolBar = [
	          { text: '新增', click: addTrainingFlowData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteTrainingFlowData, icon: 'delete' , id:"delete" }];
		
		var url = "Dormitory/getDormitoryTrainingADPlanDetail.do?aPlanID="+$("#aPlanID").val();
		
		trainingFlowDataGrid = ligerGrid("trainingFlowDataGrid",null,trainingFlowDataGridColumn,url,trainingFlowDataGridToolBar,false,true);
		
	}
	function addTrainingFlowData(){
		trainingFlowDataGrid.addRow();
	}
	function deleteTrainingFlowData(){
		trainingFlowDataGrid.deleteSelectedRow();
	}
	
	//個別訓練記錄上半月
	function bindingTrainingRecordDataGrid1(){
		var date = new Date();
		var y = date.getFullYear()+1;
		var yData = (function(){
			var arr = [];
			for(var i = 0 ; i<30 ;i++){
					var o = {y:y-i,text:y-i};
					arr.push(o);
			}
			return arr
		})();
		var mData =  (function(){
			var arr = [];
			for(var i = 1 ; i<13 ;i++){
					var o = {m:i,text:i};
					arr.push(o);
			}
			return arr
		})()
		var t = (function(){
			var arr = [
						{ display: 'detailID', name: 'detailID', hide:true },
	                    { display: '年', name: 'y',
                        	editor: { type: 'select', data: yData, valueField: 'y' },
	                        render: function (item)
	                        {
	                        	return getGridSelectedData(yData[y-parseInt(item.y)]);
	                        }},
                        { display: '月', name: 'm',
                        	editor: { type: 'select', data: mData, valueField: 'm' },
	                        render: function (item)
	                        {
	                        	return getGridSelectedData(mData[parseInt(item.m)-1]);
	                        }},
	                  ];
			for(var i = 1; i<16;i++){
				var o  = { display: i, name: "'"+i+"'", type:"text",editor: { type: 'text'}};
				arr.push(o)			
			}
			return arr
		})() 
							
	var trainingRecordDataGrid1Column=t
				
				
		var trainingRecordDataGrid1ToolBar = [
	          { text: '新增', click: addTrainingRecordData1, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteTrainingRecordData1, icon: 'delete' , id:"delete" }];
		
		var url = "Dormitory/getDormitoryTrainingRecordDetail.do?masterRecordID="+$("#tRecordID").val();
		
		trainingRecordDataGrid1 = ligerGrid("trainingRecordDataGrid1",null,trainingRecordDataGrid1Column,url,trainingRecordDataGrid1ToolBar,false,true);
		
	}
	function addTrainingRecordData1(){
		trainingRecordDataGrid1.addRow();
	}
	function deleteTrainingRecordData1(){
		trainingRecordDataGrid1.deleteSelectedRow();
	}
	
	//個別訓練記錄下半月
	function bindingTrainingRecordDataGrid2(){
		var date = new Date();
		var y = date.getFullYear()+1;
		var yData = (function(){
			var arr = [];
			for(var i = 0 ; i<30 ;i++){
					var o = {y:y-i,text:y-i};
					arr.push(o);
			}
			return arr
		})();
		var mData =  (function(){
			var arr = [];
			for(var i = 1 ; i<13 ;i++){
					var o = {m:i,text:i};
					arr.push(o);
			}
			return arr
		})()
		var t = (function(){
			var arr = [
						{ display: 'detailID', name: 'detailID', hide:true },
	                    { display: '年', name: 'y',
                        	editor: { type: 'select', data: yData, valueField: 'y' },
	                        render: function (item)
	                        {
	                        	return getGridSelectedData(yData[y-parseInt(item.y)]);
	                        }},
                        { display: '月', name: 'm',
                        	editor: { type: 'select', data: mData, valueField: 'm' },
	                        render: function (item)
	                        {
	                        	return getGridSelectedData(mData[parseInt(item.m)-1]);
	                        }},
	                  ];
			for(var i = 16; i<32;i++){
				var o  = { display: i, name: "'"+i+"'", type:"text",editor: { type: 'text'}};
				arr.push(o)			
			}
			return arr
		})() 
							
	var trainingRecordDataGrid2Column=t
				
				
		var trainingRecordDataGrid2ToolBar = [
	          { text: '新增', click: addTrainingRecordData2, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteTrainingRecordData2, icon: 'delete' , id:"delete" }];
		
		var url = "Dormitory/getDormitoryTrainingRecordDetail.do?masterRecordID="+$("#tRecordID").val();
		
		trainingRecordDataGrid2 = ligerGrid("trainingRecordDataGrid2",null,trainingRecordDataGrid2Column,url,trainingRecordDataGrid2ToolBar,false,true);
		
	}
	function addTrainingRecordData2(){
		trainingRecordDataGrid2.addRow();
	}
	function deleteTrainingRecordData2(){
		trainingRecordDataGrid2.deleteSelectedRow();
	}
	
    //個人訓練目標
	function bindingGoalDataGrid(){
	
	var goalDataGridColumn = [
								{ display: 'targetID', name: 'targetID', hide:true },
			                    { display: '姓名', name: 'fullName', width: 100,type:"text",editor: { type: 'text' }},
			                    { display: '個人訓練目標', name: 'target', width: 100,type:"text",editor: { type: 'text' }},
			                    { display: '評估目標', name: 'assess', width: 100 ,type:"text",editor: { type: 'text'}},
			                    { display: '備註', name: 'note',width:300, type:"text", editor: { type: 'text'}}
			                  ];
			
			
	var goalDataGridToolBar = [
          { text: '新增', click: addGoalData, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteGoalData, icon: 'delete' , id:"delete" }];
	
	var url = "Dormitory/getDormitoryTrainingReviewTarget.do?reviewID="+$("#reviewID").val();
	
	goalDataGrid = ligerGrid("goalDataGrid",null,goalDataGridColumn,url,goalDataGridToolBar,false,true);
	
	}
	function addGoalData(){
		goalDataGrid.addRow();
	}
	function deleteGoalData(){
		goalDataGrid.deleteSelectedRow();
	}
	
	//財政預算
	function bindingBudgetDataGrid(){
	
	var budgetDataGridColumn =  [
								{ display: 'financeID', name: 'financeID', hide:true },
			                    { display: '收入項目', name: 'inItem', width: 100,type:"text",editor: { type: 'text' }},
			                    { display: '收入金額', name: 'inMoney', width: 100,type:"text",editor: { type: 'text' }},
			                    { display: '支出項目', name: 'outItem', width: 100 ,type:"text",editor: { type: 'text'}},
			                    { display: '支出金額', name: 'outMoney', width: 100 ,type:"text",editor: { type: 'text'}},
			                    { display: '備註', name: 'note',width:300, type:"text", editor: { type: 'text'}}
			                  ];
			
			
	var budgetDataGridToolBar = [
          { text: '新增', click: addBudgetDataGrid, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteBudgetDataGrid, icon: 'delete' , id:"delete" }];
	
	var url = "Dormitory/getDormitoryTrainingReviewFinance.do?reviewID="+$("#reviewID").val();
	
	budgetDataGrid = ligerGrid("budgetDataGrid",null,budgetDataGridColumn,url,budgetDataGridToolBar,false,true);
	
	}
	function addBudgetDataGrid(){
		budgetDataGrid.addRow();
	}
	function deleteBudgetDataGrid(){
		budgetDataGrid.deleteSelectedRow();
	}
	
	//小組訓練檢討
	function bindingReviewDataGrid(){
	
	var reviewDataGridColumn = [
								{ display: 'detailID', name: 'detailID', hide:true },
			                    { display: '姓名', name: 'fullName', width: 100,type:"text",editor: { type: 'text' }},
			                    { display: '進度', name: 'schedule', width: 100,type:"text",editor: { type: 'text' }},
			                    { display: '簡述表現', name: 'performance', width: 100 ,type:"text",editor: { type: 'text'}},
			                    { display: '備註', name: 'note',width:300, type:"text", editor: { type: 'text'}}
			                  ];
			
			
	var reviewDataGridToolBar = [
          { text: '新增', click: addReviewDataGrid, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteReviewDataGrid, icon: 'delete' , id:"delete" }];
	
	var url = "Dormitory/getDormitoryTrainingReviewDetail.do?reviewID="+$("#reviewID").val();
	
	reviewDataGrid = ligerGrid("reviewDataGrid",null,reviewDataGridColumn,url,reviewDataGridToolBar,false,true);
	
	}
	function addReviewDataGrid(){
		reviewDataGrid.addRow();
	}
	function deleteReviewDataGrid(){
		reviewDataGrid.deleteSelectedRow();
	}
	
	//財政結算
	function bindingAccountDataGrid(){
	
	var accountDataGridColumn = [
								{ display: 'settleID', name: 'settleID', hide:true },
			                    { display: '收入項目', name: 'inItem', width: 100,type:"text",editor: { type: 'text' }},
			                    { display: '收入金額', name: 'inMoney', width: 100,type:"text",editor: { type: 'text' }},
			                    { display: '支出項目', name: 'outItem', width: 100 ,type:"text",editor: { type: 'text'}},
			                    { display: '支出金額', name: 'outMoney', width: 100 ,type:"text",editor: { type: 'text'}},
			                    { display: '備註', name: 'note',width:300, type:"text", editor: { type: 'text'}}
			                  ];
			
			
	var accountDataGridToolBar = [
          { text: '新增', click: addAccountDataGrid, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteAccountDataGrid, icon: 'delete' , id:"delete" }];
	
	var url = "Dormitory/getDormitoryTrainingReviewSettle.do?reviewID="+$("#reviewID").val();
	
	accountDataGrid = ligerGrid("accountDataGrid",null,accountDataGridColumn,url,accountDataGridToolBar,false,true);
	
	}
	function addAccountDataGrid(){
		accountDataGrid.addRow();
	}
	function deleteAccountDataGrid(){
		accountDataGrid.deleteSelectedRow();
	}
	
	
	function itemclick(item){
		switch (item.id){
			case "save":
				save();
			break;
			case "back":
				location.href="jsp/manage/dormitory_list.jsp";
			break;
		}
		
	}
	
	function save(){
     	accountDataGrid;
		$("#dormitoryTrainingADPlanDetailAdds").val(getAddedRows(trainingFlowDataGrid));
 		$("#dormitoryTrainingADPlanDetailUpdates").val(getEditedRows(trainingFlowDataGrid));
 		$("#dormitoryTrainingADPlanDetailDeletes").val(getDeletedRows(trainingFlowDataGrid));
 		$("#dormitoryTrainingRecordDetailAdds").val(getAddedRows(trainingRecordDataGrid1));
 		$("#dormitoryTrainingRecordDetailUpdates").val(getEditedRows(trainingRecordDataGrid1));
 		$("#dormitoryTrainingRecordDetailDeletes").val(getDeletedRows(trainingRecordDataGrid1)); 
 		$("#dormitoryTrainingRecordDetailAdds").val(getAddedRows(trainingRecordDataGrid2));
 		$("#dormitoryTrainingRecordDetailUpdates").val(getEditedRows(trainingRecordDataGrid2));
 		$("#dormitoryTrainingRecordDetailDeletes").val(getDeletedRows(trainingRecordDataGrid2)); 
		$("#dormitoryTrainingReviewTargetAdds").val(getAddedRows(goalDataGrid));
 		$("#dormitoryTrainingReviewTargetUpdates").val(getEditedRows(goalDataGrid));
 		$("#dormitoryTrainingReviewTargetDeletes").val(getDeletedRows(goalDataGrid)); 
 		$("#dormitoryTrainingReviewFinanceAdds").val(getAddedRows(budgetDataGrid));
 		$("#dormitoryTrainingReviewFinanceUpdates").val(getEditedRows(budgetDataGrid));
 		$("#dormitoryTrainingReviewFinanceDeletes").val(getDeletedRows(budgetDataGrid)); 
 		$("#dormitoryTrainingReviewDetailAdds").val(getAddedRows(reviewDataGrid));
 		$("#dormitoryTrainingReviewDetailUpdates").val(getEditedRows(reviewDataGrid));
 		$("#dormitoryTrainingReviewDetailDeletes").val(getDeletedRows(reviewDataGrid)); 
 		$("#dormitoryTrainingReviewSettleAdds").val(getAddedRows(accountDataGrid));
 		$("#dormitoryTrainingReviewSettleUpdates").val(getEditedRows(accountDataGrid));
 		$("#dormitoryTrainingReviewSettleDeletes").val(getDeletedRows(accountDataGrid)); 
		$("#Button1").click();	
	}
    
	$(function(){
		if($("#recordID").val() != "" && $("#recordID").val() != 'null' && $("#recordID").val() != 'undefined'){
			setTabTitle(parent.$("#framecenter"),"院舍管理編輯")
		}else{
			setTabTitle(parent.$("#framecenter"),"院舍管理新增")
		}
		
		$(".toptoolbar").ligerToolBar({ items: [
            { text: '保存', click: itemclick, icon: 'save' , id:"save" },
            { line: true },
            { text: '取消', click: itemclick, icon: 'back' , id:"back" }
          ]
          });
		
		
		
		ligerForm("form1");
		bindingTrainingFlowDataGrid();
		bindingTrainingRecordDataGrid1();
		bindingTrainingRecordDataGrid2();
		bindingGoalDataGrid();
		bindingBudgetDataGrid();
		bindingReviewDataGrid();
		bindingAccountDataGrid();
		
	 $("#tab").ligerTab({onAfterSelectTabItem:function(targettabid){
			switch(targettabid){
				case "dormitoryRecord":
					break;
				case "trainingPlan":showGridInTab();break;
				case "trainingFlow":showGridInTab(trainingFlowDataGrid);break;
				case "trainingRecord":showGridInTab(trainingRecordDataGrid1);;showGridInTab(trainingRecordDataGrid2);break;
				case "trainingReport":showGridInTab(goalDataGrid);showGridInTab(budgetDataGrid);showGridInTab(reviewDataGrid);showGridInTab(accountDataGrid);break;
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
	<form name="form1" class="liger-form" method="post" action="Dormitory/submit.do" id="form1" style="margin: 20px;">
	<input type="hidden" name="custID" id="custID" value="${dormitoryRecord.custID }">
	<input type="hidden" name="recordID" id="recordID" value="${dormitoryRecord.recordID }">
	<input type="hidden" name="aPlanID" id="aPlanID" value="${dormitoryTrainingADPlan.aPlanID }" >
	<input type="hidden" name="tRecordID" id="tRecordID" value="${dormitoryTrainingRecord.tRecordID }" >
	<input type="hidden" name="reviewID" id="reviewID" value="${dormitoryTrainingReview.reviewID }" >
	<input type="hidden" name="dormitoryTrainingADPlanDetailAdds" id="dormitoryTrainingADPlanDetailAdds">
	<input type="hidden" name="dormitoryTrainingADPlanDetailUpdates" id="dormitoryTrainingADPlanDetailUpdates">
	<input type="hidden" name="dormitoryTrainingADPlanDetailDeletes" id="dormitoryTrainingADPlanDetailDeletes">
	<input type="hidden" name="dormitoryTrainingRecordDetailAdds" id="dormitoryTrainingRecordDetailAdds">
	<input type="hidden" name="dormitoryTrainingRecordDetailUpdates" id="dormitoryTrainingRecordDetailUpdates">
	<input type="hidden" name="dormitoryTrainingRecordDetailDeletes" id="dormitoryTrainingRecordDetailDeletes">
	<input type="hidden" name="dormitoryTrainingReviewTargetAdds" id="dormitoryTrainingReviewTargetAdds">
	<input type="hidden" name="dormitoryTrainingReviewTargetUpdates" id="dormitoryTrainingReviewTargetUpdates">
	<input type="hidden" name="dormitoryTrainingReviewTargetDeletes" id="dormitoryTrainingReviewTargetDeletes">
	<input type="hidden" name="dormitoryTrainingReviewFinanceAdds" id="dormitoryTrainingReviewFinanceAdds">
	<input type="hidden" name="dormitoryTrainingReviewFinanceUpdates" id="dormitoryTrainingReviewFinanceUpdates">
	<input type="hidden" name="dormitoryTrainingReviewFinanceDeletes" id="dormitoryTrainingReviewFinanceDeletes">
	<input type="hidden" name="dormitoryTrainingReviewDetailAdds" id="dormitoryTrainingReviewDetailAdds">
	<input type="hidden" name="dormitoryTrainingReviewDetailUpdates" id="dormitoryTrainingReviewDetailUpdates">
	<input type="hidden" name="dormitoryTrainingReviewDetailDeletes" id="dormitoryTrainingReviewDetailDeletes">
	<input type="hidden" name="dormitoryTrainingReviewSettleAdds" id="dormitoryTrainingReviewSettleAdds" >
	<input type="hidden" name="dormitoryTrainingReviewSettleUpdates" id="dormitoryTrainingReviewSettleUpdates">
	<input type="hidden" name="dormitoryTrainingReviewSettleDeletes" id="dormitoryTrainingReviewSettleDeletes" >
	
	<div id="tab">
		  	<div title="院舍記錄" tabid="dormitoryRecord">
		  		
		  		<table cellpadding="0" cellspacing="0" class="l-table-edit" >
			        <tbody>
			    <tr>
            	<td align="right" class="l-table-edit-td">住客編號：</td>
                <td align="left" class="l-table-edit-td">
                	<input width="120px" value="${dormitoryRecord.recordNO }" name="recordNO" type="text" ltype="text"">
                </td>
            
                <td align="right" class="l-table-edit-td">姓名：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.fullName }" name="fullName" type="text" class="fullName"/></td>
                
                <td align="right" class="l-table-edit-td">會員編號：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.custNO }" name="custNO" type="text" id="custNO" /></td>
                
                <td align="right" class="l-table-edit-td">非會員編號：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.custNewNO }" name="custNewNO" type="text" id="custNewNO" /></td>
              </tr>
              <tr>
                 <td align="right" class="l-table-edit-td">申請日期:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${dormitoryRecord.applyDate_str }" name="applyDate" type="text" ltype="date" />
				 </td>
				  <td align="right" class="l-table-edit-td">預計入住日期:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${dormitoryRecord.planDate_str }" name="planDate" type="text" ltype="date" />
				 </td>
			     <td align="right" class="l-table-edit-td">入住狀態：</td>
                <td align="left" class="l-table-edit-td">
                   	<select name="revordType" ltype="select" width="120px" >
                		<option value="0" <c:if test="${dormitoryRecord.recordType == '0' }">selected="selected"</c:if> >輪候</option>
                		<option value="1" <c:if test="${dormitoryRecord.recordType == '1' }">selected="selected"</c:if> >開始</option>
                		<option value="2" <c:if test="${dormitoryRecord.recordType == '2' }">selected="selected"</c:if> >結束</option>
                	</select> 
                </td>
               	<td align="right" class="l-table-edit-td">執行員：</td>
                <td align="left" class="l-table-edit-td">
                <input width="120px" value="${dormitoryRecord.worker }" name="worker" type="text" id="worker" ltype="text"/>
                </td>
            </tr>
            <tr>
            	  <td align="right" class="l-table-edit-td">訓練日期:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${dormitoryRecord.trainingBDate_str }" name="trainingBDate" type="text" ltype="date" />
				 	至
				 	<input width="120px" value="${dormitoryRecord.trainingEDate_str }" name="trainingEDate" type="text" ltype="date" />
				 </td>
				  <td align="right" class="l-table-edit-td">訓練時間:</td>
				 <td align="left" class="l-table-edit-td">
				 	<input width="120px" value="${dormitoryRecord.trainingBTime }" name="trainingBTime" type="text" ltype="text" />
				 	至
				 	<input width="120px" value="${dormitoryRecord.trainingETime }" name="trainingETime" type="text" ltype="text" />
				 </td>
            </tr>
			          
			             <tr>
			             	
			                <td align="right" class="l-table-edit-td">離開日期：</td>
			                <td align="left" class="l-table-edit-td">
			                <input width="120px" value="${dormitoryRecord.outDate_str }" name="outDate" type="text" ltype="date"/>
			                </td>
			                
			                
			                <td align="right" class="l-table-edit-td">訓練類別：</td>
			                <td align="left" class="l-table-edit-td">
			                	<input width="120px" value="${dormitoryRecord.trainingType }" name="trainingType" type="text" ltype="text" /> 
			                </td>
			                
			             </tr>
			            <tr>
			            	
			                
			                <td align="right" class="l-table-edit-td">個人事務：</td>
			                <td align="left" class="l-table-edit-td">
			                	<textarea rows="2" cols="55" name="task">${dormitoryRecord.task }</textarea>
			                </td>
			                <td align="right" class="l-table-edit-td">社區互動:</td>
			                <td align="left" class="l-table-edit-td">
			              	  <textarea rows="2" cols="55" name="interactive">${dormitoryRecord.interactive }</textarea>
			                </td>
			                 <td align="right" class="l-table-edit-td">休閒活動:</td>
			                <td align="left" class="l-table-edit-td">
			              	  <textarea rows="2" cols="55" name="ativity">${dormitoryRecord.ativity }</textarea>
			                </td>
			                
			                
			            </tr>  
			                 
			            
			            </tbody>
			        </table>
		  	</div>
		  	
		  	<div tabid="trainingPlan" title="個別訓練策劃">
						<table cellpadding="0" cellspacing="0" class="l-table-edit" >
					        <tbody>
					        		 <tr>
		            	<td align="right" class="l-table-edit-td">住客編號：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${dormitoryRecord.recordNO }" name="recordNO" type="text" ltype="text"">
		                </td>
		            
		                <td align="right" class="l-table-edit-td">姓名：</td>
		                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.fullName }" name="fullName" type="text" class="fullName"/></td>
		                
		                <td align="right" class="l-table-edit-td">會員編號：</td>
		                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.custNO }" name="custNO" type="text" id="custNO" /></td>
		                
		                <td align="right" class="l-table-edit-td">非會員編號：</td>
		                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.custNewNO }" name="custNewNO" type="text" id="custNewNO" /></td>
		              </tr>
		              <tr>
		                 <td align="right" class="l-table-edit-td">活協:</td>
						 <td align="left" class="l-table-edit-td">
						 	<input width="120px" value="${dormitoryTrainingPlan.actProtocol }" name="actProtocol" type="text" ltype="text" />
						 </td>
						  <td align="right" class="l-table-edit-td">日期:</td>
						 <td align="left" class="l-table-edit-td">
						 	<input width="120px" value="${dormitoryTrainingPlan.billDate_str }" name="billDate" type="text" ltype="date" />
						 </td>
					    
		            </tr>
					            </tbody>
					        </table>
					        <div class="inline-group">
					        	<label style="width:180px;text-align:right;">住客訓練需要、興趣及意願：</label>
					        	<textarea rows="2" cols="55" name="note" id="note">${dormitoryTrainingPlan.suggest }</textarea>
					        	<label style="width:120px;text-align:right;">訓練目標：</label>
					        	<textarea rows="2" cols="55" name="note" id="note">${dormitoryTrainingPlan.target }</textarea>
					        </div>
					        <div class="inline-group">
					        	<label style="width:180px;text-align:right;">訓練地點：</label>
					        	<textarea rows="2" cols="55" name="note" id="note">${dormitoryTrainingPlan.place }</textarea>
					        	<label style="width:120px;text-align:right;">輔助工具使用情況：</label>
					        	<textarea rows="2" cols="55" name="note" id="note">${dormitoryTrainingPlan.tools }</textarea>
					        </div>
					        <div class="inline-group">
					        	<label style="width:180px;text-align:right;">獎勵方式：</label>
					        	<textarea rows="2" cols="55" name="note" id="note">${dormitoryTrainingPlan.reward }</textarea>
					        	<label style="width:120px;text-align:right;">評估標準：</label>
					        	<textarea rows="2" cols="55" name="note" id="note">${dormitoryTrainingPlan.standard }</textarea>
					        </div>
					        <div class="inline-group">
					        	<label style="width:180px;text-align:right;">須注意事項：</label>
					        	<textarea rows="2" cols="55" name="note" id="note">${dormitoryTrainingPlan.attention }</textarea>
					        </div>
					        <div class="inline-group">
					        	<label style="width:180px;text-align:right;">社工：</label>
					        		<input width="120px" value="${dormitoryTrainingPlan.handler }" name="handle" type="text" ltype="text" />
					        	<label>日期：</label>
					        		<input width="120px" value="${dormitoryTrainingPlan.handleDate_str }" name="handleDate" type="text" ltype="date" />
					        </div>
					         <div class="inline-group">
					        	<label style="width:180px;text-align:right;">社工意見：</label>
					        	<textarea rows="2" cols="55" name="note" id="note">${dormitoryTrainingPlan.handleSuggest }</textarea>
					        </div>
		  	</div>
		  	
		  	<div tabid="trainingFlow" title="個別住客整日訓練流程">
           			<table>
           				<tbody>
           					<tr>
				            	<td align="right" class="l-table-edit-td">住客編號：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${dormitoryRecord.recordNO }" name="recordNO" type="text" ltype="text"">
				                </td>
				            
				                <td align="right" class="l-table-edit-td">姓名：</td>
				                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.fullName }" name="fullName" type="text" class="fullName"/></td>
				                
				                <td align="right" class="l-table-edit-td">會員編號：</td>
				                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.custNO }" name="custNO" type="text" id="custNO" /></td>
				                
				                <td align="right" class="l-table-edit-td">非會員編號：</td>
				                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.custNewNO }" name="custNewNO" type="text" id="custNewNO" /></td>
				             </tr>
				             <tr>
				            	<td align="right" class="l-table-edit-td">日期：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${dormitoryTrainingADPlan.beginDate_str }" name="beginDate" type="text" ltype="date">
				                	至
				                	<input width="120px" value="${dormitoryTrainingADPlan.endDate_str }" name="endDate" type="text" ltype="date">
				                </td>
				            
				                <td align="right" class="l-table-edit-td">負責人：</td>
				                <td align="left" class="l-table-edit-td"><input width="120px" value="${dormitoryTrainingADPlan.handler }" name="handler" type="text" ltype="text"/></td>
				                
				               
				             </tr>
           				</tbody>
           			</table>
           			<div id="trainingFlowDataGrid">
           				
           			</div>
		  	   
		  	</div>
		  	
		  	<div tabid="trainingRecord" title="個別訓練記錄">
          			<div class="inline-group">
          				<label style="width:120px;text-align:right;">組別：</label>
          				<input width="120px" value="${dormitoryTrainingRecord.groupGrade }" name="groupGrade" type="text" ltype="text"">
          				<label>導師：</label>
          				<input width="120px" value="${dormitoryTrainingRecord.handler }" name="handler" type="text" ltype="text"">
          			</div>
          			<div class="inline-group">
          				<label style="width:120px;text-align:right;">執行職員：</label>
          				<input width="120px" value="${dormitoryTrainingRecord.workder }" name="wordker" type="text" ltype="text"">
          			</div>
          			<div class="inline-group">
          				<label style="width:120px;text-align:right;">訓練目標：</label>
          				<input width="120px" value="${dormitoryTrainingPlan.target }" name="target" type="text" ltype="text"">
          			</div>
          			<div id="trainingRecordDataGrid1"></div>
          			<div id="trainingRecordDataGrid2"></div>
          			
		  	</div>
		  	
		  	<div tabid="trainingReport" title="小組話個別訓練策劃及檢討">
				     
         			<div class="inline-group">
          				<label style="width:120px;text-align:right;">住宿小組編號：</label>
          				<input width="120px" value="${dormitoryTrainingReview.groupNO }" name="groupNO" type="text" ltype="text"">
          			</div>
          			<div class="inline-group">
          				<label style="width:120px;text-align:right;">負責職員：</label>
          				<input width="120px" value="${dormitoryTrainingReview.workder }" name="workder" type="text" ltype="text"">
          			</div>
          			<div class="inline-group">
          				<label style="width:120px;text-align:right;">開組日期：</label>
          				<input width="120px" value="${dormitoryTrainingReview.beginDate_str }" name="beginDate" type="text" ltype="date"">
          				至
          				<input width="120px" value="${dormitoryTrainingReview.endDate_str }" name="endDate" type="text" ltype="date"">
          			</div>
          			<div class="inline-group">
          				<label style="width:120px;text-align:right;">時間：</label>
          				逢星期
          				<select name="beginWeek" id="beginWeek" ltype="select" width="120px" >
                			<option value="0" <c:if test="${dormitoryTrainingReview.beginWeek == '0' }">selected="selected"</c:if> >日</option>
                			<option value="1" <c:if test="${dormitoryTrainingReview.beginWeek == '1' }">selected="selected"</c:if> >一</option>
                			<option value="2" <c:if test="${dormitoryTrainingReview.beginWeek == '2' }">selected="selected"</c:if> >二</option>
                			<option value="3" <c:if test="${dormitoryTrainingReview.beginWeek == '3' }">selected="selected"</c:if> >三</option>
                			<option value="4" <c:if test="${dormitoryTrainingReview.beginWeek == '4' }">selected="selected"</c:if> >四</option>
                			<option value="5" <c:if test="${dormitoryTrainingReview.beginWeek == '5' }">selected="selected"</c:if> >五</option>
                			<option value="6" <c:if test="${dormitoryTrainingReview.beginWeek == '6' }">selected="selected"</c:if> >六</option>
                		</select> 
          				<select name="beginNoon" id="beginNoon" ltype="select" width="120px" >
                			<option value="0" <c:if test="${dormitoryTrainingReview.beginNoon == '0'}">selected="selected"</c:if> >上午</option>
                			<option value="1" <c:if test="${dormitoryTrainingReview.beginNoon == '1' }">selected="selected"</c:if> >下午</option>
                		</select> 
                	至
          				<select name="endWeek" id="endWeek" ltype="select" width="120px" >
                			<option value="0" <c:if test="${dormitoryTrainingReview.endWeek == '0' }">selected="selected"</c:if> >日</option>
                			<option value="1" <c:if test="${dormitoryTrainingReview.endWeek == '1' }">selected="selected"</c:if> >一</option>
                			<option value="2" <c:if test="${dormitoryTrainingReview.endWeek == '2' }">selected="selected"</c:if> >二</option>
                			<option value="3" <c:if test="${dormitoryTrainingReview.endWeek == '3' }">selected="selected"</c:if> >三</option>
                			<option value="4" <c:if test="${dormitoryTrainingReview.endWeek == '4' }">selected="selected"</c:if> >四</option>
                			<option value="5" <c:if test="${dormitoryTrainingReview.endWeek == '5' }">selected="selected"</c:if> >五</option>
                			<option value="6" <c:if test="${dormitoryTrainingReview.endWeek == '6' }">selected="selected"</c:if> >六</option>
                		</select> 
          				<select name="endNoon" id="endNoon" ltype="select" width="120px" >
                			<option value="0" <c:if test="${dormitoryTrainingReview.endNoon == '0'}">selected="selected"</c:if> >上午</option>
                			<option value="1" <c:if test="${dormitoryTrainingReview.endNoon == '1' }">selected="selected"</c:if> >下午</option>
                		</select> 
          				
          			</div>
         		<div class="inline-group">
           			<label style="width:120px;text-align:right;">地點：</label>
               		<textarea rows="2" cols="55" name="place">${dormitoryTrainingPlan.place }</textarea>
           		</div>
           		
           		<div class="inline-group">
           			<label style="width:120px;text-align:right;">訓練類別：</label>
               		<textarea rows="2" cols="55" name="trainingType">${dormitoryRecord.trainingType }</textarea>
           		</div>
           		
           		<div class="inline-group">
           			<label style="width:120px;text-align:right;">個人事務：</label>
               		<textarea rows="2" cols="55" name="task">${dormitoryTrainingReview.task }</textarea>
           		</div>
           		<div class="inline-group">
           			<label style="width:120px;text-align:right;">社區互動：</label>
               		<textarea rows="2" cols="55" name="otherReason" id="otherReason">${dormitoryTrainingReview.interactive }</textarea>
           		</div>
           		<div class="inline-group">
           			<label style="width:120px;text-align:right;">休閒活動：</label>
               		<textarea rows="2" cols="55" name="otherReason" id="otherReason">${dormitoryTrainingReview.activity }</textarea>
           		</div>
         
          	<div class="panel panel-default">
         		<div class="panel-heading">個人訓練目標</div>
         		<div class="panel-body">
         			<div id="goalDataGrid"></div>
         		</div>
         	</div>              
              
            <div class="panel panel-default">
         		<div class="panel-heading">財政預算</div>
         		<div class="panel-body">
         			<div id="budgetDataGrid"></div>
         		<div class="inline-group">
           			<label style="width:140px;text-align:right;">輔助工具運用：</label>
               		<textarea rows="2" cols="55" name="tTools">${dormitoryTrainingReview.tTools }</textarea>
           		</div>
           		
           		<div class="inline-group">
           			<label style="width:140px;text-align:right;">獎勵方法：</label>
               		<textarea rows="2" cols="55" name="tReward" >${dormitoryTrainingReview.tReward }</textarea>
           		</div>
           		
           		<div class="inline-group">
           			<label style="width:140px;text-align:right;">須注意事項：</label>
               		<textarea rows="2" cols="55" name="tAttention">${dormitoryTrainingReview.tAttention }</textarea>
           		</div>
       			<div class="inline-group">
      				<label style="width:140px;text-align:right;">社工：</label>
      				<input width="120px" value="${dormitoryTrainingReview.tWorker }" name="tWorker" type="text" ltype="text">
      				<label>日期：</label>
      				<input width="120px" value="${dormitoryTrainingReview.tWorkDate_str }" name="tWorkDate" type="text" ltype="date"">
      			</div>
           		<div class="inline-group">
           			<label style="width:140px;text-align:right;">社工意見：</label>
               		<textarea rows="2" cols="55" name="tSuggest">${dormitoryTrainingReview.tSuggest }</textarea>
           		</div>
           		<div class="inline-group">
      				<label style="width:140px;text-align:right;">主管：</label>
      				<input width="120px" value="${dormitoryTrainingReview.tHandler }" name="tHandler" type="text" ltype="text"">
      				<label>日期：</label>
      				<input width="120px" value="${dormitoryTrainingReview.tHandleDate_str }" name="tHandleDate" type="text" ltype="date">
      			</div>
           		<div class="inline-group">
           			<label style="width:140px;text-align:right;">主管意見：</label>
               		<textarea rows="2" cols="55" name="tHandleSuggest">${dormitoryTrainingReview.tHandleSuggest }</textarea>
           		</div>
         		</div>
         	</div> 
         	<div class="panel panel-default">
         		<div class="panel-heading">小組訓練檢討</div>
         		<div class="panel-body">
         			<div id="reviewDataGrid"></div>
	         		<div class="inline-group">
	           			<label style="width:260px;text-align:right;">訓練（環境、過程、安排、能力、興趣）簡述：</label>
	               		<textarea rows="2" cols="55" name="trainingNote">${dormitoryTrainingReview.trainingNote }</textarea>
	           		</div>
         		</div>
         	</div>  
         	<div class="panel panel-default">
         		<div class="panel-heading">財政結算</div>
         		<div class="panel-body">
         			<div id="accountDataGrid"></div>
	         		<div class="inline-group">
	           			<label style="width:140px;text-align:right;">輔助工具使用情況：</label>
	               		<textarea rows="2" cols="55" name="rTools">${dormitoryTrainingReview.rTools }</textarea>
	           		</div>
	           		<div class="inline-group">
	           			<label style="width:140px;text-align:right;">整體檢討：</label>
	               		<textarea rows="2" cols="55" name="wholeReview">${dormitoryTrainingReview.wholeReview }</textarea>
	           		</div>
	           		<div class="inline-group">
	           			<label style="width:140px;text-align:right;">建議/跟進/實踐：</label>
	               		<textarea rows="2" cols="55" name="suggest" >${dormitoryTrainingReview.suggest }</textarea>
	           		</div>
	           	<div class="inline-group">
      				<label style="width:140px;text-align:right;">社工：</label>
      				<input width="120px" value="${dormitoryTrainingReview.rWorker }" name="rWorker" type="text" ltype="text"">
      				<label>日期：</label>
      				<input width="120px" value="${dormitoryTrainingReview.rWorkDate_str }" name="rWorkDate" type="text" ltype="date"">
      			</div>
      				<div class="inline-group">
	           			<label style="width:140px;text-align:right;">社工意見：</label>
	               		<textarea rows="2" cols="55" name="rSuggest">${dormitoryTrainingReview.rSuggest }</textarea>
	           		</div>
	           	<div class="inline-group">
      				<label style="width:140px;text-align:right;">主管：</label>
      				<input width="120px" value="${dormitoryTrainingReview.rHandler }" name="rHandler" type="text" ltype="text"">
      				<label>日期：</label>
      				<input width="120px" value="${dormitoryTrainingReview.rHandleDate_str }" name="rhandleDate" type="text" ltype="date">
      			</div>
      				<div class="inline-group">
	           			<label style="width:140px;text-align:right;">主管意見：</label>
	               		<textarea rows="2" cols="55" name="rHandleSuggest">${dormitoryTrainingReview.rHandleSuggest }</textarea>
	           		</div>
         		</div>
         	</div> 
              
		  	</div>
	  </div>
       
		<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
          </form>
        
        
        
        
    
    
    
</body>
</html>