<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>院舍管理</title>
<script type="text/javascript">
        
		var flowDataGrid,
			goalDataGrid,
			budgetDataGrid,
			reviewsDataGrid;
        
        function itemclick(item)
        {
            switch(item.id){
            	case "add":addRow();break;
            	case "modify":modifyRow();break;
            	default : break;
            }
        }
        
        function addRow(){
        	location.href = "CustCase/add.do";
        }
        
        function modifyRow(){
        	var custId = getRowCell(maingrid,"custId");
        	if(custId!=""){
	        	location.href = "Customer/edit.do?CUSTID="+custId;        		
        	}
        }
        
        //個別住客整日訓練流程
		function bindingFlowDataGrid(){
		var retardedTypeData = [{ retardedType: 1, text: '大腦發育遲緩' }, { retardedType: 2, text: '自閉症'}, { retardedType: 3, text: '唐氏綜合症'}, { retardedType: 4, text: '腦癱'}, { retardedType: 5, text: '多動症'}, { retardedType: 6, text: '情緒行為障礙'}, { retardedType: 7, text: '語言障礙'}, { retardedType: 8, text: '身體障礙'}, { retardedType: 9, text: '其他障礙'}];
		var retardedDegreeData = [{retardedDegree:1,text:'輕'},{retardedDegree:2,text:'中'},{retardedDegree:3,text:'重'}];
		//有/無
		var hasRetardedReportData = [{hasRetardedReport:0,text:'無'},{hasRetardedReport:1,text:'有'}];
		//山頂醫院 /鏡湖醫院/教青局 /復康服務綜合評估中心 /其他
		var retardedReportSourceData = [{retardedReportSource:1,text:'山頂醫院 '},{retardedReportSource:2,text:'鏡湖醫院'},{retardedReportSource:3,text:'教青局'},{retardedReportSource:4,text:'復康服務綜合評估中心'},{retardedReportSource:5,text:'其他'}];
		
		var flowDataGridColumn = [
									 { display: '時間', name: 'note',width:300, type:"text", editor: { type: 'text'}},
									 { display: '生活日程', name: 'note',width:300, type:"text", editor: { type: 'text'}},
									 { display: '訓練項目', name: 'note',width:300, type:"text", editor: { type: 'text'}},
									 { display: '訓練類別', name: 'note',width:300, type:"text", editor: { type: 'text'}},
									 { display: '訓練內容', name: 'retardedDegree', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '訓練時數', name: 'hasRetardedReport', width: 150 ,type:"text",editor: { type: 'text'}},
				                    { display: '備註', name: 'note',width:300, type:"text", editor: { type: 'text'}}
				                  ];
				
				
		var flowDataGridToolBar = [
	          { text: '新增', click: addFlowData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteFlowData, icon: 'delete' , id:"delete" }];
		
		var url = "Customer/getRetarded.do?CUSTID="+$("#custId").val();
		
		flowDataGrid = ligerGrid("flowDataGrid",null,flowDataGridColumn,url,flowDataGridToolBar,false);
		
	}
	function addFlowData(){
		flowDataGrid.addRow();
	}
	function deleteFlowData(){
		flowDataGrid.deleteSelectedRow();
	}
	
	
	//個別住客整日訓練流程
	function bindingGoalDataGrid(){
	var retardedTypeData = [{ retardedType: 1, text: '大腦發育遲緩' }, { retardedType: 2, text: '自閉症'}, { retardedType: 3, text: '唐氏綜合症'}, { retardedType: 4, text: '腦癱'}, { retardedType: 5, text: '多動症'}, { retardedType: 6, text: '情緒行為障礙'}, { retardedType: 7, text: '語言障礙'}, { retardedType: 8, text: '身體障礙'}, { retardedType: 9, text: '其他障礙'}];
	var retardedDegreeData = [{retardedDegree:1,text:'輕'},{retardedDegree:2,text:'中'},{retardedDegree:3,text:'重'}];
	//有/無
	var hasRetardedReportData = [{hasRetardedReport:0,text:'無'},{hasRetardedReport:1,text:'有'}];
	//山頂醫院 /鏡湖醫院/教青局 /復康服務綜合評估中心 /其他
	var retardedReportSourceData = [{retardedReportSource:1,text:'山頂醫院 '},{retardedReportSource:2,text:'鏡湖醫院'},{retardedReportSource:3,text:'教青局'},{retardedReportSource:4,text:'復康服務綜合評估中心'},{retardedReportSource:5,text:'其他'}];
	
	var goalDataGridColumn = [
								 { display: '序號', name: 'note',width:300, type:"text", editor: { type: 'text'}},
								 { display: '姓名', name: 'note',width:300, type:"text", editor: { type: 'text'}},
								 { display: '個人訓練目標', name: 'note',width:300, type:"text", editor: { type: 'text'}},
								 { display: '評估目標', name: 'note',width:300, type:"text", editor: { type: 'text'}},
								 { display: '備註', name: 'retardedDegree', width: 100,type:"text",editor: { type: 'text' }},
			                  ];
			
			
	var goalDataGridToolBar = [
          { text: '新增', click: addGoalData, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteGoalData, icon: 'delete' , id:"delete" }];
	
	var url = "Customer/getRetarded.do?CUSTID="+$("#custId").val();
	
	goalDataGrid = ligerGrid("goalDataGrid",null,goalDataGridColumn,url,goalDataGridToolBar,false);
	
		}
		function addGoalData(){
			goalDataGrid.addRow();
		}
		function deleteGoalData(){
			goalDataGrid.deleteSelectedRow();
		}
        
		
		//財政預算
		function bindingBudgetDataGrid(){
		var retardedTypeData = [{ retardedType: 1, text: '大腦發育遲緩' }, { retardedType: 2, text: '自閉症'}, { retardedType: 3, text: '唐氏綜合症'}, { retardedType: 4, text: '腦癱'}, { retardedType: 5, text: '多動症'}, { retardedType: 6, text: '情緒行為障礙'}, { retardedType: 7, text: '語言障礙'}, { retardedType: 8, text: '身體障礙'}, { retardedType: 9, text: '其他障礙'}];
		var retardedDegreeData = [{retardedDegree:1,text:'輕'},{retardedDegree:2,text:'中'},{retardedDegree:3,text:'重'}];
		//有/無
		var hasRetardedReportData = [{hasRetardedReport:0,text:'無'},{hasRetardedReport:1,text:'有'}];
		//山頂醫院 /鏡湖醫院/教青局 /復康服務綜合評估中心 /其他
		var retardedReportSourceData = [{retardedReportSource:1,text:'山頂醫院 '},{retardedReportSource:2,text:'鏡湖醫院'},{retardedReportSource:3,text:'教青局'},{retardedReportSource:4,text:'復康服務綜合評估中心'},{retardedReportSource:5,text:'其他'}];
		
		var budgetDataGridColumn = [
									 { display: '序號', name: 'note',width:300, type:"text", editor: { type: 'text'}},
									 { display: '收入項目', name: 'note',width:300, type:"text", editor: { type: 'text'}},
									 { display: '收入金額', name: 'note',width:300, type:"text", editor: { type: 'text'}},
									 { display: '支出項目', name: 'note',width:300, type:"text", editor: { type: 'text'}},
									 { display: '支出金額', name: 'retardedDegree', width: 100,type:"text",editor: { type: 'text' }},
									 { display: '備註', name: 'retardedDegree', width: 100,type:"text",editor: { type: 'text' }},
				                  ];
				
				
		var budgetDataGridToolBar = [
	          { text: '新增', click: addGoalData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteGoalData, icon: 'delete' , id:"delete" }];
		
		var url = "Customer/getRetarded.do?CUSTID="+$("#custId").val();
		
		budgetDataGrid = ligerGrid("budgetDataGrid",null,budgetDataGridColumn,url,budgetDataGridToolBar,false);
		
			}
			function addBudgetData(){
				budgetDataGrid.addRow();
			}
			function deleteBudgetData(){
				budgetDataGrid.deleteSelectedRow();
			}
	        
			
			//財政預算
			function bindingReviewsDataGrid(){
			var retardedTypeData = [{ retardedType: 1, text: '大腦發育遲緩' }, { retardedType: 2, text: '自閉症'}, { retardedType: 3, text: '唐氏綜合症'}, { retardedType: 4, text: '腦癱'}, { retardedType: 5, text: '多動症'}, { retardedType: 6, text: '情緒行為障礙'}, { retardedType: 7, text: '語言障礙'}, { retardedType: 8, text: '身體障礙'}, { retardedType: 9, text: '其他障礙'}];
			var retardedDegreeData = [{retardedDegree:1,text:'輕'},{retardedDegree:2,text:'中'},{retardedDegree:3,text:'重'}];
			//有/無
			var hasRetardedReportData = [{hasRetardedReport:0,text:'無'},{hasRetardedReport:1,text:'有'}];
			//山頂醫院 /鏡湖醫院/教青局 /復康服務綜合評估中心 /其他
			var retardedReportSourceData = [{retardedReportSource:1,text:'山頂醫院 '},{retardedReportSource:2,text:'鏡湖醫院'},{retardedReportSource:3,text:'教青局'},{retardedReportSource:4,text:'復康服務綜合評估中心'},{retardedReportSource:5,text:'其他'}];
			
			var reviewsDataGridColumn = [
										 { display: '姓名', name: 'note',width:300, type:"text", editor: { type: 'text'}},
										 { display: '進度', name: 'note',width:300, type:"text", editor: { type: 'text'}},
										 { display: '簡述表現', name: 'note',width:300, type:"text", editor: { type: 'text'}},
										 { display: '備註', name: 'retardedDegree', width: 100,type:"text",editor: { type: 'text' }},
					                  ];
					
					
			var reviewsDataGridToolBar = [
		          { text: '新增', click: addReviewsData, icon: 'add' , id:"add" },
		          { line: true },
		          { text: '删除', click: deleteReviewsData, icon: 'delete' , id:"delete" }];
			
			var url = "Customer/getRetarded.do?CUSTID="+$("#custId").val();
			
			reviewsDataGrid = ligerGrid("reviewsDataGrid",null,reviewsDataGridColumn,url,reviewsDataGridToolBar,false);
			
				}
				function addReviewsData(){
					reviewsDataGrid.addRow();
				}
				function deleteReviewsData(){
					reviewsDataGrid.deleteSelectedRow();
				}
        
        $(function ()
        {
        	$("#toptoolbar").ligerToolBar({ items: [
               { text: '保存', click: itemclick, icon: 'save' , id:"save" },
               { line: true },
               { text: '返回', click: itemclick, icon: 'back' , id:"back" }
             ]
             });
     		
        	ligerForm("form1");
        	bindingFlowDataGrid()
        	bindingGoalDataGrid()
        	bindingBudgetDataGrid()
        	bindingReviewsDataGrid()
        });


        
        
    </script>
</head>
<body>
	 <div id="toptoolbar"></div> 
	 <div>
	 	<form action="" id="form1" name="form1" class="inline-form">
	 		<table>
	 			<tbody>
	 				<tr>
		                <td align="right" class="l-table-edit-td">住客編號：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
		                </td>
		                
		                <td align="right" class="l-table-edit-td">姓名：</td>
		                <td align="left" class="l-table-edit-td" colspan="3">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
		                </td>
		                
		                <td align="right" class="l-table-edit-td">會員編號：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
		                </td>
		                <td align="right" class="l-table-edit-td">非會員編號：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
		                </td>
		             </tr>
		             <tr>
		                <td align="right" class="l-table-edit-td">申請日期：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
		                </td>
		                <td align="right" class="l-table-edit-td">預計入住日期：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
		                </td>
		                <td align="right" class="l-table-edit-td">入住狀態：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
		                </td>
		                <td align="right" class="l-table-edit-td">房號：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
		                </td>
	                </tr>
	                <tr>
		                <td align="right" class="l-table-edit-td">組別：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
		                </td>
		                <td align="right" class="l-table-edit-td">入住日期：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
		                </td>
		                <td align="right" class="l-table-edit-td">活協：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
		                </td>
		                <td align="right" class="l-table-edit-td">執行職員：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
		                </td>
	                </tr>
	                <tr>
		                <td align="right" class="l-table-edit-td">訓練日期：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="date" />
		                	至
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="date" />
		                </td>
		                <td align="right" class="l-table-edit-td">訓練時間：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="date" />
		                	至
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="date" />
		                </td>
		                <td align="right" class="l-table-edit-td">離開日期：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
		                </td>
		                <td align="right" class="l-table-edit-td">訓練類別：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
		                </td>
		              </tr>
		              <tr>
		                <td align="right" class="l-table-edit-td">個人事務：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
		                </td>
		                <td align="right" class="l-table-edit-td">社區互動：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
		                </td>
		                <td align="right" class="l-table-edit-td">休閒活動：</td>
		                <td align="left" class="l-table-edit-td">
		                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
		                </td>
		            </tr>
	 			</tbody>
	 		</table>
	 		<div class="panel panel-default">
       		<div class="panel-heading">個別訓練策劃</div>
       		<div class="panel-body">
       			<table>
			 			<tbody>
			 				<tr>
				                <td align="right" class="l-table-edit-td">住客編號：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                
				                <td align="right" class="l-table-edit-td">姓名：</td>
				                <td align="left" class="l-table-edit-td" colspan="3">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                
				                <td align="right" class="l-table-edit-td">會員編號：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                <td align="right" class="l-table-edit-td">非會員編號：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				             </tr>
				             <tr>
				                <td align="right" class="l-table-edit-td">活協：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                <td align="right" class="l-table-edit-td">日期：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                <td align="right" class="l-table-edit-td">住客訓練需要、興趣及意願：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                <td align="right" class="l-table-edit-td">訓練目標：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
			                </tr>
			                <tr>
				                <td align="right" class="l-table-edit-td">訓練地點：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                <td align="right" class="l-table-edit-td">輔助工具：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                <td align="right" class="l-table-edit-td">獎勵方式：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                <td align="right" class="l-table-edit-td">評估標準：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
			                </tr>
			                <tr>
				                <td align="right" class="l-table-edit-td">須注意事項：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="date" />
				                </td>
				                <td align="right" class="l-table-edit-td">社工：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="date" />
				                </td>
				                <td align="right" class="l-table-edit-td">日期：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                <td align="right" class="l-table-edit-td">社工意見：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				              </tr>
			 			</tbody>
			 		</table>
        		</div>
        	</div>
        	<div class="panel panel-default">
       		<div class="panel-heading">個別住客整日訓練流程</div>
       		<div class="panel-body">
       			<table>
			 			<tbody>
			 				<tr>
				                <td align="right" class="l-table-edit-td">住客編號：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                
				                <td align="right" class="l-table-edit-td">姓名：</td>
				                <td align="left" class="l-table-edit-td" colspan="3">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                
				                <td align="right" class="l-table-edit-td">會員編號：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                <td align="right" class="l-table-edit-td">非會員編號：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				             </tr>
				             <tr>
				                <td align="right" class="l-table-edit-td">日期：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                	至
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                <td align="right" class="l-table-edit-td">負責人：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
			                </tr>
			 			</tbody>
			 		</table>
			 		<div id="flowDataGrid"></div>
        		</div>
        	</div>
        	<div class="panel panel-default">
       		<div class="panel-heading">個別訓練記錄</div>
       		<div class="panel-body">
       			<table>
			 			<tbody>
			 				<tr>
				                <td align="right" class="l-table-edit-td">組別：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                
				                <td align="right" class="l-table-edit-td">導師：</td>
				                <td align="left" class="l-table-edit-td" colspan="3">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                
				                <td align="right" class="l-table-edit-td">執行職員：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                <td align="right" class="l-table-edit-td">訓練目標：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				             </tr>
				             <tr>
				                <td align="right" class="l-table-edit-td">評估基準：</td>
				                <td align="left" class="l-table-edit-td">
				                	4、獨立完成 3、口頭提示 2、姿勢提示 1、執手協助 0、不能完成
				                </td>
			                </tr>
			 			</tbody>
			 		</table>
			 		<div>
			 			<table border="1">
			 				<thead>
			 					<tr>
			 						<th rowspan="2">序號</th>
			 						<th rowspan="2">內容</th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th>月份</th>
			 						<th><input type="text" ltype="text"></th>
			 					</tr>
			 					<tr>
			 						<th>1</th>
			 						<th>2</th>
			 						<th>3</th>
			 						<th>4</th>
			 						<th>5</th>
			 						<th>6</th>
			 						<th>7</th>
			 						<th>8</th>
			 						<th>9</th>
			 						<th>10</th>
			 						<th>11</th>
			 						<th>12</th>
			 						<th>13</th>
			 						<th>14</th>
			 						<th>15</th>
			 					</tr>
			 				</thead>
			 				<tbody>
			 					<tr>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 					</tr>
			 				</tbody>
			 			</table>
			 			<table border="1">
			 				<thead>
			 					<tr>
			 						<th rowspan="2">序號</th>
			 						<th rowspan="2">內容</th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th></th>
			 						<th>月份</th>
			 						<th><input type="text" ltype="text"></th>
			 					</tr>
			 					<tr>
			 						<th>16</th>
			 						<th>17</th>
			 						<th>18</th>
			 						<th>19</th>
			 						<th>20</th>
			 						<th>21</th>
			 						<th>22</th>
			 						<th>23</th>
			 						<th>24</th>
			 						<th>25</th>
			 						<th>26</th>
			 						<th>27</th>
			 						<th>28</th>
			 						<th>29</th>
			 						<th>30</th>
			 						<th>31</th>
			 					</tr>
			 				</thead>
			 				<tbody>
			 					<tr>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 						<td></td>
			 					</tr>
			 				</tbody>
			 			</table>
			 		</div>
        		</div>
        	</div>
        	<div class="panel panel-default">
       		<div class="panel-heading">小組話個別訓練策劃及檢討</div>
       		<div class="panel-body">
       			<table>
			 			<tbody>
			 				<tr>
				                <td align="right" class="l-table-edit-td">住宿小組編號：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                
				                <td align="right" class="l-table-edit-td">負責職員：</td>
				                <td align="left" class="l-table-edit-td" colspan="3">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                
				                <td align="right" class="l-table-edit-td">開組時間：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="date" />
				                </td>
				                <td align="right" class="l-table-edit-td">至：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="date" />
				                </td>
				             </tr>
				             <tr>
				                <td align="right" class="l-table-edit-td">時間：逢星期</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                <td align="right" class="l-table-edit-td">上午/下午</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                 <td align="right" class="l-table-edit-td">地點：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                 <td align="right" class="l-table-edit-td">訓練類別：</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                 <td align="right" class="l-table-edit-td">個人事務</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                 <td align="right" class="l-table-edit-td">社區互動</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
				                 <td align="right" class="l-table-edit-td">休閒活動</td>
				                <td align="left" class="l-table-edit-td">
				                	<input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
				                </td>
			                </tr>
			 			</tbody>
			 		</table>
        		</div>
        	</div>
        	
        	<p>個人訓練目標</p>
        	<div id="goalDataGrid"></div>
        	
        	<p>財政預算</p>
        	<div id="budgetDataGrid"></div>
        	<div>
        		<ul>
        			<li><label>輔助工具運用:</label></li>
        			<li><input type="text" ltype="text"></li>
        		</ul>
        		<ul>
        			<li><label>獎勵方法:</label></li>
        			<li><input type="text" ltype="text"></li>
        		</ul>
        		<ul>
        			<li><label>須注意事項:</label></li>
        			<li><input type="text" ltype="text"></li>
        		</ul>
        		<ul>
        			<li><label>社工:</label></li>
        			<li><input type="text" ltype="text"></li>
        			<li><label>日期:</label></li>
        			<li><input type="text" ltype="text"></li>
        		</ul>
        		<ul>
        			<li><label>社工意見:</label></li>
        			<li><input type="text" ltype="text"></li>
        		</ul>
        		<ul>
        			<li><label>主管:</label></li>
        			<li><input type="text" ltype="text"></li>
        			<li><label>日期:</label></li>
        			<li><input type="text" ltype="text"></li>
        		</ul>
        		<ul>
        			<li><label>主管意見:</label></li>
        			<li><input type="text" ltype="text"></li>
        		</ul>
        	</div>
        	
        	<p>小組訓練檢討</p>
        	<div id="reviewsDataGrid"></div>
        	<ul>
        		<li>訓練（環境、過程、安排、能力、興趣）簡述:</li>
        		<li><input type="text" ltype="text"></li>
        	</ul>
        	
        	<p>財政結算</p>
        	<div id="reviewsDataGrid"></div>
	 	</form>
	 </div>
</body>
</html>
