<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
%>
<%
	String back = request.getParameter("back");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/jsp/head.jsp"></jsp:include>
<title>個案資料管理</title>
 <script type="text/javascript">
 	var WorkerWaysGrid,
 		bCustCaseRecordGrid;
 	ligerUiFn.addGridRow=function(){
 		location.href="CustCase/add.do";
 	}
 	ligerUiFn.modifyGridRow=function(){
 		var recordID = getRowCell(bCustCaseRecordGrid,"recordID");
 		if(recordID != null){
			location.href="CustCase/editBCustCaseRecord.do?recordID="+recordID+"&caseID=${custCasePojo.caseID}";
		}
 	}

 	ligerUiFn.save=function(){
 		//console.log("90)"+getAddedRows(WorkerWaysGrid))
 		$("#bCustCaseRecordAdds").val(getAddedRows(bCustCaseRecordGrid));
 		$("#bCustCaseRecordUpdates").val(getEditedRows(bCustCaseRecordGrid));
 		$("#bCustCaseRecordDeletes").val(getDeletedRows(bCustCaseRecordGrid));
 		$("#bCustCaseSummaryHandleAdds").val(getAddedRows(WorkerWaysGrid));
 		$("#bCustCaseSummaryHandleUpdates").val(getEditedRows(WorkerWaysGrid));
 		$("#bCustCaseSummaryHandleDeletes").val(getDeletedRows(WorkerWaysGrid)); 
 		console.log($("#bCustCaseRecordDeletes").val())
 		console.log($("#bCustCaseRecordUpdates").val())
 		//$("#submit").click()
 	}
	ligerUiFn.back=function(){
 		location.href="jsp/custCase/list.jsp";
 	}
	
	function save(){
		
		/* $("#CSSAAdds").val(getAddedRows(CSSAGrid));
		$("#CSSAUpdates").val(getEditedRows(CSSAGrid));
		$("#CSSADeletes").val(getDeletedRows(CSSAGrid));
		
		$("#Button1").click(); */
		
	}
	function back(){
		location.href="jsp/custCase/list.jsp";
	}
	
	
	$(function(){
		
		
		$(".toptoolbar").ligerToolBar({ items: [
             { text: '保存', click: ligerUiFn.itemClick, icon: 'save' , id:"save" },
             { line: true },
             { text: '取消', click: ligerUiFn.itemClick, icon: 'back' , id:"back" }
           ]
           });
		
			//會員編號
		   $("#custNO").ligerPopupEdit({
             /*   condition: {
                   prefixID: 'condtion_',
                   fields: [{ name: 'CompanyName', type: 'text', label: '客户' }]
               }, */
               grid: getcustNOGridOptions(true),
               valueField: 'custNO',
               textField: 'custNO',
               width: 200,
               readonly:false
           });

           function getcustNOGridOptions(checkbox) {
               var options = {
                   columns: [
                   { display: '會員編號', name: 'custNO', align: 'left', width: 100, minWidth: 60 },
                   { display: '案主姓名', name: 'fullName', minWidth: 120, width: 100 }
                   ], switchPageSizeApplyComboBox: false,
                  //data:{"Rows":[{"cardNO":"44071112902313264","cardStatus":1,"cardType":"1","custCode":"001002","custId":"00010000000000000105","custType":"1","fullName":"王祖蓝","fullNameEng":"","mobileTelNO":"13543212653","regDate":{"date":8,"day":5,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":1452182400000,"timezoneOffset":-480,"year":116},"relationship":"","sex":"1","telNo":"","validDate":{"date":8,"day":5,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":1452182400000,"timezoneOffset":-480,"year":116}},{"cardNO":"","cardStatus":0,"cardType":"1","custCode":"022222","custId":"0001000000000000011S","custType":"0","fullName":"gg","fullNameEng":"","mobileTelNO":"","regDate":{"date":15,"day":1,"hours":0,"minutes":0,"month":1,"nanos":0,"seconds":0,"time":1455465600000,"timezoneOffset":-480,"year":116},"relationship":"","sex":"1","telNo":"","validDate":{"date":15,"day":1,"hours":0,"minutes":0,"month":1,"nanos":0,"seconds":0,"time":1455465600000,"timezoneOffset":-480,"year":116}},{"cardNO":"6543012","cardStatus":1,"cardType":"1","custCode":"001001","custId":"1","custType":"1","fullName":"劉燁","fullNameEng":"Ye.Lao","mobileTelNO":"13543215712","regDate":{"date":14,"day":4,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":1452700800000,"timezoneOffset":-480,"year":116},"relationship":"","sex":"1","telNo":"3052135","validDate":{"date":20,"day":3,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":1453219200000,"timezoneOffset":-480,"year":116}}],"Total":3},
                  url:"CustCase/listPojos.do",
                  pageSize: 10
               };
               return options;
           }
           
           //非會員編號
           $("#custNewNO").ligerPopupEdit({
             /*   condition: {
                   prefixID: 'condtion_',
                   fields: [{ name: 'CompanyName', type: 'text', label: '客户' }]
               }, */
               grid: getcustNewNOGridOptions(true),
               valueField: 'custNewNO',
               textField: 'custNewNO',
               width: 200,
               readonly:false
           });

           function getcustNewNOGridOptions(checkbox) {
               var options = {
                   columns: [
                   { display: '非會員編號', name: 'custNewNO', align: 'left', width: 100, minWidth: 60 },
                   { display: '案主姓名', name: 'fullName', minWidth: 120, width: 100 }
                   ], switchPageSizeApplyComboBox: false,
                  //data:{"Rows":[{"cardNO":"44071112902313264","cardStatus":1,"cardType":"1","custCode":"001002","custId":"00010000000000000105","custType":"1","fullName":"王祖蓝","fullNameEng":"","mobileTelNO":"13543212653","regDate":{"date":8,"day":5,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":1452182400000,"timezoneOffset":-480,"year":116},"relationship":"","sex":"1","telNo":"","validDate":{"date":8,"day":5,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":1452182400000,"timezoneOffset":-480,"year":116}},{"cardNO":"","cardStatus":0,"cardType":"1","custCode":"022222","custId":"0001000000000000011S","custType":"0","fullName":"gg","fullNameEng":"","mobileTelNO":"","regDate":{"date":15,"day":1,"hours":0,"minutes":0,"month":1,"nanos":0,"seconds":0,"time":1455465600000,"timezoneOffset":-480,"year":116},"relationship":"","sex":"1","telNo":"","validDate":{"date":15,"day":1,"hours":0,"minutes":0,"month":1,"nanos":0,"seconds":0,"time":1455465600000,"timezoneOffset":-480,"year":116}},{"cardNO":"6543012","cardStatus":1,"cardType":"1","custCode":"001001","custId":"1","custType":"1","fullName":"劉燁","fullNameEng":"Ye.Lao","mobileTelNO":"13543215712","regDate":{"date":14,"day":4,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":1452700800000,"timezoneOffset":-480,"year":116},"relationship":"","sex":"1","telNo":"3052135","validDate":{"date":20,"day":3,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":1453219200000,"timezoneOffset":-480,"year":116}}],"Total":3},
                  url:"CustCase/listPojos.do",
                  pageSize: 10
               };
               return options;
           }
           
           //案生姓名
            var full = $("#fullName").ligerPopupEdit({
               grid: getFullNameGridOptions(true),
               valueField: 'fullName',
               textField: 'fullName',
               width: 200,
               onSelected:fullNameSelected
           });

           function getFullNameGridOptions(checkbox) {
               var options = {
                   columns: [
					{ display: '會員ID', name: 'custId', minWidth: 120, width: 100 },
                   { display: '案主姓名', name: 'fullName', minWidth: 120, width: 100 }
                   ], switchPageSizeApplyComboBox: false,
                   //pageSize: 10
                  /*  checkbox: checkbox, */
                  url:"Customer/list.do"
                 // usePager:false
                  
               };
               return options;
           }
           
           function fullNameSelected(data){
        	   console.log(data.data[0])
        	   var custID = data.data[0].custId;
        	   $.ajax({
        		   type:"post",
        		   url:"CustCase/custData.do",
        		   data:"custID="+custID,
        		   success:function(msg){
        			  // var m = JSON.parse(msg);
        			  if(msg != ""){
        				  console.log(msg)
	           			   var m = msg.replace(/^\[/g,"");
	           					m = m.replace(/\]$/g,"");
	           					m = JSON.parse(m)
	           			   console.log(m)
	           			   $("#custID").val(m.custID);
	           			   $("#mobileTelNO").val(m.mobileTelNO);
	           			   $("#father").val(m.mother);
	           			   $("#mother").val(m.mother);
	           			   $("#custNO").val(m.custNO);
	           			   $("#custNewNO").val(m.custNewNO); 
           			   		$("#linkAdr").val(m.linkAdr);
           			   		$("#cardNO").val(m.cardNO);
           			   		$("#birthday_ChnStr").val(m.birthday_ChnStr);
           			   		$("#receiveDate").val(m.receiveDate_str);
           			   		$("#caseWorker").val(m.caseWorker);
           			   		$("#economics").val(m.economics);
           			   			edulevel.setValue(m.edulevel);
	           			 		isMarry.setValue(m.isMarry);
	           			 		$("#sex").find("input").each(function(){
	           			 			if($(this).val() == m.sex){
	           			 				var sex = $(this).ligerRadio();
	           			 					sex.setValue(true);
	           			 			}else{
	           			 				var sex = $(this).ligerRadio();
	           			 					sex.setValue(false);
	           			 			}
	           			 		})
           			   		 
        			  }
        			   
        		   }
        		   
        	   }) 
           }
           ligerForm("form1");
		
		bindingWorkerWaysGrid();
		bindingBCustCaseRecordGrid();
  		var edulevel = $("#edulevel").ligerComboBox({disabled :true});
	   	var isMarry = $("#isMarry").ligerComboBox({disabled :true});
		
		
 		 $("#tab").ligerTab({onAfterSelectTabItem:function(targettabid){
			switch(targettabid){
				case "bCustCaseSummaryGrid":showGridInTab(WorkerWaysGrid);break;
				case "bCustCaseRecordGrid": showGridInTab(bCustCaseRecordGrid);break;
				default:break;
			}
		}}); 
 		
		 if("${param.back}" == 'true'){
			 var tab = liger.get("tab");
			tab.selectTabItem("bCustCaseRecordGrid"); 
		} 
		 
 		//
 		var initAssess ="${custCasePojo.initAssess}";
 		if(initAssess == "0" || initAssess == "" || initAssess == null ){
 			$(".initAssessDetail_text").show();
 			$("#initAssessDetail_text").attr("name","initAssessDetail");
 			$(".initAssessDetail_select").hide();
 			$("#initAssessDetail_select").attr("name","initAssessDetail_1");
 		}else{
 			$(".initAssessDetail_text").hide();
 			$("#initAssessDetail_text").attr("name","initAssessDetail_1");
 			$(".initAssessDetail_select").show();
 			$("#initAssessDetail_select").attr("name","initAssessDetail");
 		}
 		$("#initAssess")[0].onchange=function(){
 			  if(this.value == "0"){
	   		    	$(".initAssessDetail_text").show();
	   		    	$("#initAssessDetail_text").attr("name","initAssessDetail");
	   		    	$(".initAssessDetail_select").hide();
	   		    	$("#initAssessDetail_select").attr("name","initAssessDetail_1");
	   		    }else{
	   				$(".initAssessDetail_text").hide();
	   				$("#initAssessDetail_text").attr("name","initAssessDetail_1");
	   		    	$(".initAssessDetail_select").show();
	   		    	$("#initAssessDetail_select").attr("name","initAssessDetail");
	   		 } 
 		}
 		$("#caseSource")[0].onchange=function(){
 			if(this.value == "2"){
 				$(".caseSourceDetail").show();
 			}else{
 				$(".caseSourceDetail").hide();
 			}
 		}
 		$("#handleWay")[0].onchange=function(){
 			if(this.value == "2"){
 				$(".handleWayDetail").show();
 			}else{
 				$(".handleWayDetail").hide();
 			}
 		}
	
	})
	
	
	
	
	
	
	//工作員處理方式
	function bindingWorkerWaysGrid(){
		var WorkerWaysGridColumn = [
			                     { display: '次數', name: 'times', align: 'left', width: 250, minWidth: 60,editor:{type:'text'} },
			                     { display: '日期', name: 'disposeDate', align: 'left', width: 130, type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
			                     { display: '形式', name: 'form', align: 'left', width: 120, minWidth: 60 ,editor:{type:'text'}},
			                     { display: '工作人员', name: 'worker', align: 'left', width: 120, minWidth: 60 ,editor:{type:'text'}},
			                     { display: '備註', name: 'note', align: 'left', width: 400 ,editor:{type:'text'} }
			                    ];
		var WorkerWaysGridToolBar = [
		             	          { text: '新增', click: addWorkerWays, icon: 'add' , id:"add" },
		             	          { line: true },
		             	          { text: '删除', click: deleteWorkerWays, icon: 'delete' , id:"delete" }];
		
		var url = "CustCase/bCustCaseSummaryHandlePojoList.do?caseID="+$("#caseID").val();
		
		WorkerWaysGrid = ligerGrid("WorkerWaysGrid",null,WorkerWaysGridColumn,url,WorkerWaysGridToolBar,false,true);
	}
	
	function addWorkerWays(){
		WorkerWaysGrid.addRow();
	}
	function deleteWorkerWays(){
		WorkerWaysGrid.deleteSelectedRow();
	}
	
	//個案撮要記錄
	function bindingBCustCaseRecordGrid(){
        var sexData = [{sex:1,text:'男'},{sex:2,text:'女'}];
        var custTypeData = [{custType:0,text:'非會員'},{custType:1,text:'永久會員'},{custType:2,text:'臨時會員'}];
        var cardStatusData = [{cardStatus:0,text:'退會'},{cardStatus:1,text:'正常'},{cardStatus:2,text:'欠費'}];
        var cardTypeData = [{cardType:1,text:'永久身份證'},{cardType:2,text:'非永久身份證'},{cardType:3,text:'其他'}];
    	
        var bCustCaseRecordGridColumns = [
                    { display: '案主姓名', name: 'fullName',minWidth: 100 },                 
                    { display: '會談主題/目的', name: 'title', minWidth: 100 },
	                { display: '會談日期', name: 'talksDate', minWidth: 100 },
	                { display: '會談次數', name: 'times', minWidth:100 },
	                { display: '記錄者', name: 'recordAdmin', minWidth:100}
                ] ;
        
        var bCustCaseRecordGridToolBar = [
                           { text: '增加', click: addBCustCaseRecord, icon: 'add' , id:"add" },
                           { line: true },
                           { text: '修改', click: editBCustCaseRecord, icon: 'modify' , id:"modify" },
                           { line: true },
                           { text: '删除', click: deleteBCustCaseRecord, icon: 'delete' , id:"delete" }
                         ];
        bCustCaseRecordGrid = ligerGrid("bCustCaseRecordGrid",null,bCustCaseRecordGridColumns,"CustCase/bCustCaseRecordList.do?caseID="+$("#caseID").val(),bCustCaseRecordGridToolBar,false,true);

	}
	 var addBCustCaseRecordDlg = null;
    function addBCustCaseRecord(){
    		var fullName = $("#fullName").val();
    		if(fullName != "" && fullName != null && fullName != 'undefined'){
    			addBCustCaseRecordDlg = openDialog("CustCase/addBCustCaseRecord.do?fullName="+fullName,"添加個案撮要記錄","addBCustCaseRecordByDlg");    			
    		}else{
    			alert("請選擇案主！");
    			return;
    		}
   	}
   	function addBCustCaseRecordByDlg(){
   		var y = addBCustCaseRecordDlg.recordData.talksDate.getFullYear();
   		var m = addBCustCaseRecordDlg.recordData.talksDate.getMonth()+1;
   		var d = addBCustCaseRecordDlg.recordData.talksDate.getDate();
   		var date = y+"-"+m+"-"+d;
   		addBCustCaseRecordDlg.recordData.talksDate=date;
   		if(addBCustCaseRecordDlg.recordData!=null&&addBCustCaseRecordDlg.recordData!=""){
   			bCustCaseRecordGrid.addRow(addBCustCaseRecordDlg.recordData);
  		}
   	}
   	var editBCustCaseRecordDlg = null;
	function editBCustCaseRecord(){
		
		var row = getSelectedRow(bCustCaseRecordGrid);
		
		if(row!=null){
			if(row.caseID==null||""==row.caseID){
				//如果当前行是新增并没有保存的行
				editBCustCaseRecordDlg = openDialog("jsp/custCase/bCustCaseRecord_detail.jsp?jsonData="+JSON.stringify(row),"编辑個案撮要記錄资料","editBCustCaseRecordByDlg");	
			}else{
				editBCustCaseRecordDlg = openDialog("CustCase/editBCustCaseRecord.do?caseID="+row.caseID,"编辑個案撮要記錄资料","editBCustCaseRecordByDlg");
			}
			
		}
	}
	function editBCustCaseRecordByDlg(){
		if(editBCustCaseRecordDlg.recordData!=null&&editBCustCaseRecordDlg.recordData!=""){
			bCustCaseRecordGrid.updateRow(getSelectedRow(bCustCaseRecordGrid), editBCustCaseRecordDlg.recordData);
		}
	}
   	function deleteBCustCaseRecord(){
   	} 
	
	
	
</script>
</head>
<body style="height: auto;overflow: scroll;">
	<div class="toptoolbar"></div>
	  <form name="form1" method="post" action="CustCase/submit.do" id="form1">
	  <input type="hidden" name="custID" id="custID" value="${custCasePojo.custID }" >
	  <input type="hidden" name="caseID" id="caseID" value="${custCasePojo.caseID }" >
	 <input type="hidden" name="bCustCaseRecordAdds" id="bCustCaseRecordAdds">
	  <input type="hidden" name="bCustCaseRecordUpdates" id="bCustCaseRecordUpdates">
	  <input type="hidden" name="bCustCaseRecordDeletes" id="bCustCaseRecordDeletes">
	  <input type="hidden" name="bCustCaseSummaryHandleAdds" id="bCustCaseSummaryHandleAdds">
	  <input type="hidden" name="bCustCaseSummaryHandleUpdates" id="bCustCaseSummaryHandleUpdates">
	  <input type="hidden" name="bCustCaseSummaryHandleDeletes" id="bCustCaseSummaryHandleDeletes">
	   <table>
	   		<tbody>
	   			<tr>
	   				 <td align="right" class="l-table-edit-td">個案編碼：</td><!-- 有name -->
			         <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.caseNO }" name="caseNO" type="text" class="caseNO" ltype="text" /></td>
	   				 <td align="right" class="l-table-edit-td">會員編號：</td>
	                <td align="left" class="l-table-edit-td">
	                <input width="120px" value="${custCasePojo.custNO }" name="custNO" type="text" id="custNO" />
	                </td>
	                
	                <td align="right" class="l-table-edit-td">非會員編號：</td>
	                <td align="left" class="l-table-edit-td">
	                <input width="120px" value="${custCasePojo.custNewNO }" name="custNewNO" type="text" id="custNewNO" ltype="text"/>
	                </td>
	                
	                 <td align="right" class="l-table-edit-td">案主姓名：</td><!-- 有name -->
	                <td align="left" class="l-table-edit-td"><input disabled="disabled" width="120px"  value="${custCasePojo.fullName }" name="fullName" id="fullName" type="text" /></td>
	             </tr>
	             <tr>
	                <td align="right" class="l-table-edit-td">性別：</td>
	                <td align="left" class="l-table-edit-td" id="sex">
	                	<input id="sex1" type="radio" disabled="disabled" name="sex"  value="1" <c:if test="${custCasePojo.sex != 2 }">checked="checked"</c:if> /><label for="sex1">男</label> 
						<input id="sex2" type="radio" disabled="disabled" name="sex" value="2" <c:if test="${custCasePojo.sex == 2 }">checked="checked"</c:if> /><label for="sex2">女</label>
	                </td>
	                <td align="right" class="l-table-edit-td">出生日期：</td>
	                <td align="left" class="l-table-edit-td">
	                <input disabled="disabled" width="120px" value="${custCasePojo.birthday_ChnStr }" name="birthday_ChnStr" type="text" id="birthday_ChnStr" ltype="date" />
	                </td>
	                 <td align="right" class="l-table-edit-td">聯繫電話:</td>
			         <td align="left" class="l-table-edit-td"><input width="120px" disabled="disabled" value="${custCasePojo.mobileTelNO }"  name="mobileTelNO" type="text" id="mobileTelNO" ltype="text" /></td>
                	<td align="right" class="l-table-edit-td">父親姓名:</td>
                	 <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.father }"  name="father" type="text" id="father" ltype="text" /></td>
                </tr>
                <tr>
	               
	                <td align="right" class="l-table-edit-td">母親姓名:</td>
	                <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.mother }"  name="mother" type="text" id="mother" ltype="text" /></td>
			            <td align="right" class="l-table-edit-td">教育程度:</td>
			                <td align="left" class="l-table-edit-td">
			                	<!-- <input type="text" id="edulevel"> -->
			                 	<select disabled="disabled" name="edulevel" id="edulevel" ltype="select" width="120px" >
			                		<option value="1" <c:if test="${custCasePojo.edulevel != '2' and cust.edulevel != '3' and cust.edulevel != '4' and cust.edulevel != '5' }">selected="selected"</c:if> >無</option>
			                		<option value="2" <c:if test="${custCasePojo.edulevel == '2' }">selected="selected"</c:if> >小學</option>
			                		<option value="3" <c:if test="${custCasePojo.edulevel == '3' }">selected="selected"</c:if> >中學</option>
			                		<option value="4" <c:if test="${custCasePojo.edulevel == '4' }">selected="selected"</c:if> >高中</option>
			                		<option value="5" <c:if test="${custCasePojo.edulevel == '5' }">selected="selected"</c:if> >大學</option>
			                	</select> 
			                </td>       
	                <td align="right" class="l-table-edit-td">婚姻狀況:</td>
			               	<td align="left" class="l-table-edit-td">
			               		<select disabled="disabled" name="isMarry" id="isMarry" ltype="select" width="120px" >
			                		<option value="0" <c:if test="${custCasePojo.isMarry != '1'}">selected="selected"</c:if> >未婚</option>
			                		<option value="1" <c:if test="${custCasePojo.isMarry == '1'}">selected="selected"</c:if> >已婚</option>
			                	</select>
			               	</td>
	                 <td align="right" class="l-table-edit-td">身份證號碼:</td>
   					 <td align="left" class="l-table-edit-td">
   					 	<input disabled="disabled" width="120px" value="${custCasePojo.cardNO }" name="cardNO" type="text" id="cardNO" ltype="text" />
   					 </td>
   				  </tr>
		           <tr>
	   				 <td align="right" class="l-table-edit-td">經濟情況:</td>
		             <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.economics }" name="economics" type="text" id="economics" ltype="text" /></td>
		     </tr>
	   			<tr>
	   				 <td align="right" class="l-table-edit-td">住址:</td>
	   				   <td align="left" class="l-table-edit-td" colspan="3">
	                	<textarea disabled="disabled" rows="2" cols="55" name="linkAdr" id="linkAdr">${custCasePojo.linkAdr }</textarea>
	               <%--  <input width="120px" value="${custCasePojo.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" /> --%>
	                </td>
	   			</tr>
	   		</tbody>
	   </table>
	  <div id="tab">
	  
		  	<div tabid="WorkerWaysGrid" title="接案登記" id="bCustCase"><!-- 接案登記 -->
		  		
		  		
		  		<table cellpadding="0" cellspacing="0" class="l-table-edit" >
			        <tbody>
			            <tr>
			                   <td align="right" class="l-table-edit-td">接案日期:</td>
        					 <td align="left" class="l-table-edit-td">
        					 	<input width="120px" value="${custCasePojo.receiveDate_str }" type="text" name="receiveDate" id="receiveDate" ltype="date" />
        					 </td>
		             
			             <td align="right" class="l-table-edit-td">接案社工：</td>
				         <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.caseWorker }" name="caseWorker" type="text" id="caseWorker" ltype="text" /></td>
		   			
			                <td align="right" class="l-table-edit-td">個案狀態：</td>
			                <td align="left" class="l-table-edit-td">
			                	<!-- <input type="text" id="caseStatus" name="caseStatus"> -->
			                	<select name="caseStatus" id="caseStatus" ltype="select" width="120px" >
			                		<option value="0" <c:if test="${custCasePojo.caseStatus != '1'}">selected="selected"</c:if> >跟進</option>
			                		<option value="1" <c:if test="${custCasePojo.caseStatus == '1'}">selected="selected"</c:if> >結案</option>
			                		<option value="2" <c:if test="${custCasePojo.caseStatus == '2'}">selected="selected"</c:if> >轉介</option>
			                	</select>
			                </td>
			              </tr>
			              <tr>
			           		<td align="right" class="l-table-edit-td">接案來源：</td>
			                <td align="left" class="l-table-edit-td">
			                	<select name="caseSource" id="caseSource" ltype="select" width="120px" >
			                		<option value="0" <c:if test="${custCasePojo.caseSource != '1'}">selected="selected"</c:if> >案主求助</option>
			                		<option value="1" <c:if test="${custCasePojo.caseSource == '1'}">selected="selected"</c:if> >職員發現</option>
			                		<option value="2" <c:if test="${custCasePojo.caseSource == '2'}">selected="selected"</c:if> >轉介</option>
			                	</select>
			                 <!-- <input type="text" id="caseSource"/>在上面的js定義 -->
							</td>
									<td align="right" class="l-table-edit-td caseSourceDetail" style='display: <c:if test="${custCasePojo.caseSource != '2'}">none</c:if>'>轉介機構或個人：</td>
									<td align="left" class="l-table-edit-td caseSourceDetail"  style='display: <c:if test="${custCasePojo.caseSource != '2'}">none</c:if>'>
					                	<input width="120px" value="${custCasePojo.caseSourceDetail }" type="text" ltype="text" name="caseSourceDetail" />
					                </td>
					                
					                <td align="right" class="l-table-edit-td">金卡號碼:</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.goldCard }"  name="goldCard" class="goldCard" type="text" ltype="text" /></td>
			            	
			            </tr>  
			            <tr>
			                
			                
			               <%-- <td align="right" class="l-table-edit-td">聯繫電話:</td>
			               <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.mobileTelNO }"  name="cardNO" type="text" id="cardNO" ltype="text" /></td>
			                 --%>
			               <%--  <td align="right" class="l-table-edit-td">父親姓名:</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.father }"  name="cardNO" type="text" id="cardNO" ltype="text" /></td>
			                <td align="right" class="l-table-edit-td">母親姓名:</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.mother }"  name="cardNO" type="text" id="cardNO" ltype="text" /></td>
			                 --%>
			              <%--   <td align="right" class="l-table-edit-td">住址:</td>
			                <td align="left" class="l-table-edit-td" colspan="3">
			                	<textarea rows="2" cols="55" name="linkAdr">${custCasePojo.linkAdr }</textarea>
			                <input width="120px" value="${custCasePojo.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
			                </td> --%>
			                
			                
			            </tr>
			            
			            
			            <tr>
			          	 <%-- 	<td align="right" class="l-table-edit-td">婚姻狀況:</td>
			               	<td align="left" class="l-table-edit-td">
			               		<input type="text" id="isMarry">
			                	<select name="isSendLetter" id="isSendLetter" ltype="select" width="120px" >
			                		<option value="0" <c:if test="${custCasePojo.isMarry != '1'}">selected="selected"</c:if> >未婚</option>
			                		<option value="1" <c:if test="${custCasePojo.isMarry == '1'}">selected="selected"</c:if> >已婚</option>
			                	</select>
			              	  </td> --%>
			         <%--        <td align="right" class="l-table-edit-td">教育程度:</td>
			                <td align="left" class="l-table-edit-td">
			                	<input type="text" id="edulevel">
			                	<select name="edulevel" id="edulevel" ltype="select" width="120px" >
			                		<option value="1" <c:if test="${custCasePojo.edulevel != '2' and cust.edulevel != '3' and cust.edulevel != '4' and cust.edulevel != '5' }">selected="selected"</c:if> >無</option>
			                		<option value="2" <c:if test="${custCasePojo.edulevel == '2' }">selected="selected"</c:if> >小學</option>
			                		<option value="3" <c:if test="${custCasePojo.edulevel == '3' }">selected="selected"</c:if> >中學</option>
			                		<option value="4" <c:if test="${custCasePojo.edulevel == '4' }">selected="selected"</c:if> >高中</option>
			                		<option value="5" <c:if test="${custCasePojo.edulevel == '5' }">selected="selected"</c:if> >大學</option>
			                	</select>
			                </td> --%>
			                
			               <%--  <td align="right" class="l-table-edit-td">經濟情況:</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.economics }" name="telNo" type="text" id="telNo" ltype="text" /></td>
			                 --%>
			              
			                
			            </tr>
			            <tr>
			            	 <td align="right" class="l-table-edit-td">面對/呈現之問題:</td>
			                <td align="left" class="l-table-edit-td" colspan="3">
			                	<textarea rows="2" cols="55" class="ui-textarea" name="caseProblem" >${custCasePojo.caseProblem }</textarea>
			                </td>
			                <td align="right" class="l-table-edit-td">問題生成時間：</td>
							<td align="left" class="l-table-edit-td" >
			                	<input width="120px" value="${custCasePojo.problemDate_str }" name="problemDate" type="text" ltype="date" />
			                </td>
			                 <td align="right" class="l-table-edit-td">問題生成用戶：</td>
							<td align="left" class="l-table-edit-td" >
			                	<input width="120px" value="${custCasePojo.problemAdmin }" name="problemAdmin" type="text" ltype="text" />
			                </td>
		                </tr>
		                <tr>
			                 <td align="right" class="l-table-edit-td">提出之要求:</td>
			                <td align="left" class="l-table-edit-td" colspan="3">
			                	<textarea rows="2" cols="55" class="ui-textarea" name="caseRequest"  >${custCasePojo.caseRequest }</textarea>
			                </td>
			               
			                  <td align="right" class="l-table-edit-td">要求生成時間：</td>
							<td align="left" class="l-table-edit-td" >
			                	<input width="120px" value="${custCasePojo.requestDate_str }" name="requestDate" type="text" ltype="date" />
			                </td>
			                 <td align="right" class="l-table-edit-td">要求生成用戶：</td>
							<td align="left" class="l-table-edit-td" >
			                	<input width="120px" value="${custCasePojo.requestAdmin }" name="requestAdmin" type="text" ltype="text" />
			                </td>
			                
			            </tr>
			            
			             <tr>
			                 <td align="right" class="l-table-edit-td">接案時之處理/行動:</td>
			                <td align="left" class="l-table-edit-td" colspan="3">
			                	<textarea rows="2" cols="55" class="ui-textarea" name="caseAction"  >${custCasePojo.caseAction }</textarea>
			                </td>
			                <td align="right" class="l-table-edit-td">行動生成時間：</td>
							<td align="left" class="l-table-edit-td" >
			                	<input width="120px" value="${custCasePojo.actionDate_str }" name="actionDate" type="text" ltype="date" />
			                </td>
			                 <td align="right" class="l-table-edit-td">行動生成用戶：</td>
							<td align="left" class="l-table-edit-td" >
			                	<input width="120px" value="${custCasePojo.actionAdmin }" name="actionAdmin" type="text" ltype="text" />
			                </td>
			             </tr>
			             <tr>
			                <td align="right" class="l-table-edit-td">社工初步評估:</td>
			                <td align="left" class="l-table-edit-td">
			                	<!-- <input type="text" id="initAssess" > -->
			                 	<select name="initAssess" id="initAssess" ltype="select" width="120px" >
			                		<option value="0" <c:if test="${custCasePojo.initAssess == '0' }">selected="selected"</c:if> >其他</option>
			                		<option value="1" <c:if test="${custCasePojo.initAssess == '1' }">selected="selected"</c:if> >接受報務動機</option>
			                		<option value="2" <c:if test="${custCasePojo.initAssess == '2' }">selected="selected"</c:if> >跟進的迫切性</option>
			                		<option value="3" <c:if test="${custCasePojo.initAssess == '3' }">selected="selected"</c:if> >案主其他支援</option>
			                		<option value="4" <c:if test="${custCasePojo.initAssess == '4' }">selected="selected"</c:if> >人生安全</option>
			                		<option value="5" <c:if test="${custCasePojo.initAssess == '5' }">selected="selected"</c:if> >情緒狀態</option>
			                	</select> 
			                </td>
				                	<td class="initAssessDetail_select">
					                	<select value="${custCasePojo.initAssessDetail }" id="initAssessDetail_select" ltype="select" width="120px" class="initAssessDetail">
					                		<option value="1" >1</option>
					                		<option value="2" >2</option>
					                		<option value="3" >3</option>
					                		<option value="4" >4</option>
					                		<option value="5" >5</option>
					                	</select>
				                	</td>
			                	<td class="initAssessDetail_text">
			                		<input  value="${custCasePojo.initAssessDetail }" id="initAssessDetail_text" width="120px" class="initAssessDetail" type="text" ltype="text" />
			                	</td>
			               
			                <td align="right" class="l-table-edit-td">建議處理方法:</td>
			                <td align="left" class="l-table-edit-td">
			                	<!-- <input type="text" id="suggest"> -->
			               		 <select name="suggest" id="suggest" ltype="select" width="120px" >
			                		<option value="0" <c:if test="${custCasePojo.suggest == '0' }">selected="selected"</c:if> >諮詢處理</option>
			                		<option value="1" <c:if test="${custCasePojo.suggest == '1' }">selected="selected"</c:if> >個案處理</option>
			               		</select> 
			                </td>
			            </tr>
			            <tr>
			                <td align="right" class="l-table-edit-td">備註:</td>
			                <td align="left" class="l-table-edit-td" colspan="3">
			                	<textarea rows="2" cols="55" class="ui-textarea" name="note"  >${custCasePojo.note }</textarea>
			                </td>
			                
			            </tr>
			            
			              <tr>
			              
			              	<td align="right" class="l-table-edit-td">主管姓名:</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.handler }" name="handler" type="text" id="handler" ltype="text" /></td>
			              
			                <td align="right" class="l-table-edit-td">日期:</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.handleDate_str }" name="handleDate" type="text" id="handleDate" ltype="date" /></td>
			                
			                <td align="right" class="l-table-edit-td">處理方法:</td>
			                <td align="left" class="l-table-edit-td">
			                	<!-- <input type="text" id="handleWay"> -->
			                	 <select name="handleWay" id="handleWay" ltype="select" width="120px" >
			                		<option value="0" <c:if test="${custCasePojo.handleWay == '0' }">selected="selected"</c:if> >以諮詢處理</option>
			                		<option value="1" <c:if test="${custCasePojo.handleWay == '1' }">selected="selected"</c:if> >以個案處理</option>
			               			<option value="2" <c:if test="${custCasePojo.handleWay == '2' }">selected="selected"</c:if> >轉介至其他機構</option>
			               		</select> 
			               	<td align="right" class="l-table-edit-td handleWayDetail" style='display:<c:if test="${custCasePojo.handleWay != '2' }">none</c:if>'>機構名稱:</td>
			                <td align="left" class="l-table-edit-td handleWayDetail" style='display:<c:if test="${custCasePojo.handleWay != '2' }">none</c:if>'><input width="120px" value="${custCasePojo.handleWayDetail }" name="handleWayDetail" type="text" id="handleWayDetail" ltype="text" /></td>
			                
			            </tr>
			            <tr>
			            	<td align="right" class="l-table-edit-td">處理社工:</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${custCasePojo.disposeWorker }" name="disposeWorker" type="text" id="disposeWorker" ltype="text" /></td>
			            
			            	<td align="right" class="l-table-edit-td">意見及建議:</td>
			                <td align="left" class="l-table-edit-td" colspan="3">
			                	<textarea rows="2" cols="55" class="ui-textarea" name="handleSuggest"  >${custCasePojo.handleSuggest }</textarea>
			                	<%-- <input width="120px" value="${custCasePojo.handleSuggest }" name="jobPlace" type="text" id="jobPlace" ltype="text" /> --%>
			                </td>
			            </tr>
			            </tbody>
			        </table>
		  	</div>
		  	
		  	<div tabid="bCustCaseRecordGrid" class="bCustCaseRecordGrid" title="個案撮要記錄"><!-- 個案撮要記錄 -->
		  		<div id="bCustCaseRecordGrid"></div>
		  	
		  	</div>
		  	
		  	<div tabid="bCustCaseSummaryGrid" title="結案摘要 "><!-- 結案摘要 -->
               		<%-- <input type="hidden" name="summaryID" id="summaryID" value="${custCasePojo.summaryID }"> --%>
               		<table>
               			<tbody>
               				<tr>
               					 <%-- <td align="right" class="l-table-edit-td">個案編號:</td>
               					 <td align="left" class="l-table-edit-td">
               					 	<input width="120px" value="${custCasePojo.caseNO }" type="text" class="caseNO" ltype="text" />
               					 </td> --%>
               					 <td align="right" class="l-table-edit-td">結案日期:</td>
               					 <td align="left" class="l-table-edit-td">
               					 	<input width="120px" value="${custCasePojo.closeDate_str }" type="text" name="closeDate" ltype="date" />
               					 </td> 
               					 <td align="right" class="l-table-edit-td">結案社工:</td>
               					 <td align="left" class="l-table-edit-td">
               					 	<input width="120px" value="${custCasePojo.closeWorker }" name="closeWorker" type="text" id="closeWorker" ltype="text" />
               					 </td> 
               					  <td align="right" class="l-table-edit-td">結案人員:</td>
               					 <td align="left" class="l-table-edit-td">
               					 	<input width="120px" value="${custCasePojo.closePeople }" name="closePeople" type="text" id="closePeople" ltype="text" />
               					 </td>
               				</tr>
               				<tr>
               					<%--  <td align="right" class="l-table-edit-td">會員編號:</td>
               					 <td align="left" class="l-table-edit-td">
               					 	<input width="120px" value="${custCasePojo.custNO }" name="custNO" type="text" id="custNO" ltype="text" />
               					 </td> --%>
               					<%--  <td align="right" class="l-table-edit-td">非會員編號:</td>
               					 <td align="left" class="l-table-edit-td">
               					 	<input width="120px" value="${custCasePojo.custNewNO }" name="custNewNO" type="text" id="custNewNO" ltype="text" />
               					 </td> --%>
               					 <%-- <td align="right" class="l-table-edit-td">案主姓名:</td>
               					 <td align="left" class="l-table-edit-td">
               					 	<input width="120px" value="${custCasePojo.fullName }" class="fullName" type="text" ltype="text" />
               					 </td> --%>
               					<%--   <td align="right" class="l-table-edit-td">性別:</td>
               					 <td align="left" class="l-table-edit-td">
               					 	<input width="120px" value="${custCasePojo.sex }" name="sex" type="text" id="sex" ltype="text" />
               					 </td> --%>
               				</tr>
               				<tr>
               					 <%-- <td align="right" class="l-table-edit-td">出生日期:</td>
               					 <td align="left" class="l-table-edit-td">
               					 	<input width="120px" value="${custCasePojo.birthday_ChnStr }" name="birthday_ChnStr" type="text" id="birthday_ChnStr" ltype="date" />
               					 </td> --%>
               					  <%-- <td align="right" class="l-table-edit-td">聯繫電話:</td>
               					 <td align="left" class="l-table-edit-td">
               					 	<input width="120px" value="${custCasePojo.mobileTelNO }" name="mobileTelNO" type="text" id="mobileTelNO" ltype="text" />
               					 </td> --%>
               				</tr>
               				<tr>
               					 <td align="right" class="l-table-edit-td">結案描述:</td>
               					 <td align="left" class="l-table-edit-td" colspan="3">
               					 	<textarea rows="2" cols="55" class="ui-textarea"   name="summaryDetail">${custCasePojo.summaryDetail }</textarea>
               					 </td>
               					 <td align="right" class="l-table-edit-td">追蹤需要:</td>
               					 <td align="left" class="l-table-edit-td" colspan="3">
               					 	<textarea rows="2" cols="55" class="ui-textarea"   name="summaryNeed">${custCasePojo.summaryNeed }</textarea>
               					 </td>
               				</tr>
               				<tr>
               					<td align="right" class="l-table-edit-td">工作員處理方式:</td>
               					<td colspan="6">
               						<div id="WorkerWaysGrid"></div>
               						<!-- <table border="1" cellpadding="0" cellspacing="0" class="l-table-edit">
               							<thead>
               								<tr>
               									<th>次數</th>
               									<th>日期</th>
               									<th>形式</th>
               									<th>備註</th>
               								</tr>
               							</thead>
               							<tbody>
               								
               							</tbody>
               						</table> -->
               					</td>
               				</tr>
               				<tr>
               					<td align="right" class="l-table-edit-td">主管:</td>
               					<td align="left" class="l-table-edit-td">
               						<input width="120px" value="${custCasePojo.manager }" name="manager" type="text" id="manager" ltype="text" />
               					</td>
               					 <td align="right" class="l-table-edit-td">日期:</td>
               					 <td align="left" class="l-table-edit-td">
               					 	<input width="120px" value="${custCasePojo.manageDate_str }" name="manageDate" type="text" id="manageDate" ltype="date" />
               					 </td>
               				</tr>
               				<tr>
               					<td align="right" class="l-table-edit-td">主管意見及建議:</td>
               					 <td align="left" class="l-table-edit-td" colspan="3">
               					 	<textarea rows="2" cols="55" class="ui-textarea" name="manageSuggest" >${custCasePojo.manageSuggest }</textarea>
               					 </td>
               				</tr>
               			</tbody>
               		</table>
		  	</div>
		  	
		  	<div tabid="bCustCaseAssessGrid" title="個案轉介評估"><!-- 個案轉介評估 -->
               	<table>
          			<tbody>
          				<tr>
          					 <%-- <td align="right" class="l-table-edit-td">個案編號:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.caseNO }" type="text" class="caseNO" ltype="text" />
          					 </td> --%>
          					 <%--  <td align="right" class="l-table-edit-td">會員編號:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.custNO }" name="custNO" type="text" id="custNO" ltype="text" />
          					 </td> --%>
          					<%--  <td align="right" class="l-table-edit-td">非會員編號:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.custNewNO }" name="custNewNO" type="text" id="custNewNO" ltype="text" />
          					 </td> --%>
          					<%--   <td align="right" class="l-table-edit-td">案主姓名:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.fullName }" class="fullName" type="text" ltype="text" />
          					 </td> --%>
          				</tr>
          				<tr>
          					<%--  <td align="right" class="l-table-edit-td">出生日期:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.birthday_ChnStr }" name="birthday_ChnStr" type="text" id="birthday_ChnStr" ltype="date" />
          					 </td> --%>
          					<%--  <td align="right" class="l-table-edit-td">身份證號碼:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.cardNO }" name="cardNO" type="text" id="cardNO" ltype="text" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">性別:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.sex }" name="sex" type="text" id="sex" ltype="text" />
          					 </td>
          					  <td align="right" class="l-table-edit-td">聯繫電話:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.mobileTelNO }" name="mobileTelNO" type="text" id="mobileTelNO" ltype="text" />
          					 </td> --%>
          				</tr>
          				<tr>
          					<%--  <td align="right" class="l-table-edit-td">父親姓名:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.father }" name="father" type="text" id="father" ltype="text" />
          					 </td>
          					  <td align="right" class="l-table-edit-td">母親姓名:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.mother }" name="mother" type="text" id="mother" ltype="text" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">住址:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">婚姻狀況:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.isMarry }" name="isMarry" type="text" id="isMarry" ltype="text" />
          					 </td> --%>
          				</tr>
          				<tr>
          					<%--  <td align="right" class="l-table-edit-td">教育程度:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.edulevel }" name="edulevel" type="text" id="edulevel" ltype="text" />
          					 </td>
          					 <td align="right" class="l-table-edit-td">經濟情況:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.economics }" name="economics" type="text" id="economics" ltype="text" />
          					 </td> --%>
          				</tr>
          				<tr>
          					 <td align="right" class="l-table-edit-td">評估社工:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.assessWorker }" name="assessWorker" type="text" id="assessWorker" ltype="text" />
          					 </td>
          					  <td align="right" class="l-table-edit-td">評估日期:</td>
          					 <td align="left" class="l-table-edit-td">
          					 	<input width="120px" value="${custCasePojo.assessDate_str }" name="assessDate" type="text" id="assessDate" ltype="date" />
          					 </td>
          				</tr>
          				<tr>
          					 <td align="right" class="l-table-edit-td">背景資料:</td>
          					 <td align="left" class="l-table-edit-td" colspan="3">
          					 	<textarea rows="2" cols="55" class="ui-textarea" name="background"  >${custCasePojo.background }</textarea>
          					 </td>
          					  <td align="right" class="l-table-edit-td">案主現時之問題:</td>
          					 <td align="left" class="l-table-edit-td" colspan="3">
          					 	<textarea rows="2" cols="55" class="ui-textarea" name="problem"  >${custCasePojo.problem }</textarea>
          					 </td>
          				</tr>
          				<tr>
          					 <td align="right" class="l-table-edit-td">轉介目的:</td>
          					 <td align="left" class="l-table-edit-td" colspan="3">
          						 <textarea rows="2" cols="55" class="ui-textarea" name="objective"  >${custCasePojo.objective }</textarea>
          					 </td>
          					  <td align="right" class="l-table-edit-td">轉介描述:</td>
          					 <td align="left" class="l-table-edit-td" colspan="3">
          					 	<textarea rows="2" cols="55" class="ui-textarea"   name="describe">${custCasePojo.describe }</textarea>
          					 </td>
          				</tr>
          			</tbody>
          		</table>
		  	</div>
		  	
	  </div>
       <input type="submit" id="submit" value="提交" style="display:none">
	</form>
		<%-- <input type="hidden" id="custId" name="custId" value="${cust.custId }"> --%>
         
        
        
        
    
    
    
</body>
</html>