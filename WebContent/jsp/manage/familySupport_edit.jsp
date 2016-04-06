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
        var memberDataGrid,
        	notMemberDataGrid,
        	volunteerDataGrid,
        	familySupportRecordDataGrid;
        
        //會員報名
		function bindingMemberDataGrid(){
			function getParentName(checkbox) {
				if(memberDataGrid != "" && memberDataGrid != null){
					var custID = getRowCell(memberDataGrid,"custID");
				}
			    var options = {
			        columns: [
					{ display: '會員ID', name: 'custID', minWidth: 120, width: 100 },
					{ display: '會員NO', name: 'custNO', minWidth: 120, width: 100 },
			        { display: '義工姓名', name: 'fullName', minWidth: 120, width: 100 }
			        ], switchPageSizeApplyComboBox: false,
			        //pageSize: 10
			       /*  checkbox: checkbox, */
			       url:"Customer/list.do"
			      // usePager:false
			       
			    };
			    return options;
			}
	      function p_onSelected(e) { 
	            if (!e.data || !e.data.length) return;

	            var grid = liger.get("memberDataGrid");

	            var selected = e.data[0]; 
	            grid.updateRow(grid.lastEditRow, {
	                fullName: selected.fullName,
	                custID: selected.custID,
	                custNO: selected.custNO
	            });
	        }
        	
			function getFullName(checkbox) {
			    var options = {
			        columns: [
					{ display: '會員ID', name: 'custID', minWidth: 120, width: 100 },
					{ display: '會員NO', name: 'custNO', minWidth: 120, width: 100 },
			        { display: '義工姓名', name: 'fullName', minWidth: 120, width: 100 }
			        ], switchPageSizeApplyComboBox: false,
			        //pageSize: 10
			       /*  checkbox: checkbox, */
			       url:"Customer/list.do"
			      // usePager:false
			       
			    };
			    return options;
			}
	      function f_onSelected(e) { 
	            if (!e.data || !e.data.length) return;

	            var grid = liger.get("memberDataGrid");
	            var row = grid.getSelectedRow();
	            console.log(row.custID)
	            var selected = e.data[0]; 
	            grid.updateRow(grid.lastEditRow, {
	                fullName: selected.fullName,
	                custID: selected.custID,
	                custNO: selected.custNO
	            });
	        }
		
		var memberDataGridColumn = [
									{ display: 'applyID', name: 'applyID', hide:true },
									{ display: 'custID', name: 'custID', hide:true },
									{ display: 'type', name: 'type', hide:true},
									{ display: '登記日期', name: 'registerDate', minWidth:100, type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '會員編號', name: 'custNO', minWidth:100, type:"text",editor: { type: 'text'}},
				                    //{ display: '會員家長姓名', name: 'parentName', minWidth:100,type:"text", editor: { type: 'text'}},
				                    {
				                        name: 'parentName',align:'center', width:100, display: '會員家長姓名', textField: 'parentName'
				                        , editor:
				                            {
				                            	type: 'popup', valueField: 'parentName', textField: 'parentName', grid:  getParentName(true), onSelected:p_onSelected
				                        	}
				                    },
				                    { display: '會員家長收費', name: 'parentsExpense', minWidth:100, type:"text", editor: { type: 'text'}},
				                    //{ display: '智障人士姓名', name: 'fullName', minWidth:100,type:"text", editor: { type: 'text'}},
				                    {
				                        name: 'fullName',align:'center', width:100, display: '智障人士姓名', textField: 'fullName'
				                        , editor:
				                            {
				                            	type: 'popup', valueField: 'fullName', textField: 'fullName', grid:  getFullName(true), onSelected:f_onSelected
				                        	}
				                    },
				                    { display: '智障人士收費', name: 'amentiaExpense', minWidth:100, type:"text", editor: { type: 'text'}},
				                    { display: '家屬', name: 'family', minWidth:100,type:"text", editor: { type: 'text'}},
				                    { display: '家屬收費', name: 'fExpense', minWidth:100, type:"text", editor: { type: 'text'}},
				                    { display: '家屬人數', name: 'fNumber', minWidth:100, type:"text", editor: { type: 'text'}},
				                    { display: '總人數', name: 't', minWidth:100,type:"text", editor: { type: 'text'}},
				                    { display: '收費總和', name: 'count', minWidth:100, type:"text", editor: { type: 'text'}},
				                    { display: '聯繫電話', name: 'mobileTelNO',  minWidth:100,type:"text", editor: { type: 'text'}},
				                    { display: '備註', name: 'note', type:"text",minWidth:100, editor: { type: 'text'}}
				                  ];
				
				
		var memberDataGridToolBar = [
	          { text: '新增', click: addMemberData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteMemberData, icon: 'delete' , id:"delete" }];
		
		var url = "FamilySupport/getFamilySupportApply.do?supportID="+$("#supportID").val()+"&type=1";
		
		memberDataGrid = ligerGrid("memberDataGrid",null,memberDataGridColumn,url,memberDataGridToolBar,false,true);
    }
	function addMemberData(){
		memberDataGrid.addRow();
	}
	function deleteMemberData(){
		memberDataGrid.deleteSelectedRow();
	}
	
	 //非會員報名
	function bindingNotMemberDataGrid(){
		 
	
	var notMemberDataGridColumn = [
								{ display: 'applyID', name: 'applyID', hide:true },
								{ display: 'type', name: 'type', hide:true},
								{ display: '登記日期', name: 'registerDate', minWidth:100, type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
			                    { display: '家長姓名', name: 'parentsName',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '家長收費', name: 'parentsExpense',minWidth:100,type:"text", editor: { type: 'text'}},
			                    { display: '智障人士姓名', name: 'amentiaName',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '智障人士收費', name: 'amentiaExpense',wminWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '家屬', name: 'family',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '家屬收費', name: 'fExpense',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '家屬人數', name: 'fNumber',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '總人數', name: 'note',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '收費總和', name: 'count',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '聯繫電話', name: 'mobileTelNO',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '備註', name: 'note',minWidth:100, type:"text", editor: { type: 'text'}}
			                  ];
			
			
	var notMemberDataGridToolBar = [
          { text: '新增', click: addNotMemberData, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteNotMemberData, icon: 'delete' , id:"delete" }];
	
	var url = "FamilySupport/getFamilySupportApply.do?supportID="+$("#supportID").val()+"&type=2";
	
	notMemberDataGrid = ligerGrid("notMemberDataGrid",null,notMemberDataGridColumn,url,notMemberDataGridToolBar,false,true);
	
	}
	function addNotMemberData(){
		notMemberDataGrid.addRow();
	}
	function deleteNotMemberData(){
		notMemberDataGrid.deleteSelectedRow();
	}
	
	 //義工報名
	function bindingVolunteerDataGrid(){
		 
/* 		function getCustNO(checkbox) {
		    var options = {
		        columns: [
				{ display: '會員編號', name: 'workID', minWidth: 120, width: 100 },
		        { display: '義工姓名', name: 'workName', minWidth: 120, width: 100 }
		        ], switchPageSizeApplyComboBox: false,
		        //pageSize: 10
		       url:"SocialWork/list.do"
		      // usePager:false
		       
		    };
		    return options;
		}
      function c_onSelected(e) { 
            if (!e.data || !e.data.length) return;

            var grid = liger.get("volunteerDataGrid");

            var selected = e.data[0]; 
            grid.updateRow(grid.lastEditRow, {
                workName: selected.workName,
                custID: selected.workID,
            });
        } */
		 
		function getWorkName(checkbox) {
		    var options = {
		        columns: [
				{ display: '會員ID', name: 'workID', minWidth: 120, width: 100 },
		        { display: '義工姓名', name: 'fullName', minWidth: 120, width: 100 }
		        ], switchPageSizeApplyComboBox: false,checkbox:false,
		        //pageSize: 10
		       /*  checkbox: checkbox, */
		       url:"SocialWork/list.do"
		      // usePager:false
		       
		    };
		    return options;
		}
      function w_onSelected(e) { 
            if (!e.data || !e.data.length) return;

            var grid = liger.get("volunteerDataGrid");

            var selected = e.data[0]; 
            
            grid.updateRow(grid.getSelected(), {
                fullName: selected.fullName,
                custID: selected.workID,
                custNO: selected.custNO,
                age:selected.age,
                work:selected.work,
                mobileTelNO:selected.mobileTelNO
            });
            debugger
            console.log(selected)
/* 
            var out = JSON.stringify(selected);
            $("#message").html('最后选择:'+out); */
        }
	
	var volunteerDataGridColumn = [
								{ display: 'applyID', name: 'applyID', hide:true },
								{ display: 'custID', name: 'custID', hide:true },
								{ display: 'type', name: 'type', hide:true},
			                    { display: '會員編號', name: 'custNO', minWidth:100,type:"text"},
	/* 		                    {
			                        name: 'workName',align:'center', width:100, display: '會員編號', textField: 'custNO'
			                        , editor:
			                            {
			                            	type: 'popup', valueField: 'custNO', textField: 'custNO', grid:  getCustNO(true), onSelected:c_onSelected
			                        	}
			                    }, */
			                    {
			                        name: 'fullName',align:'center', width:100, display: '義工姓名', textField: 'fullName'
			                        , editor:
			                            {
			                            	type: 'popup', valueField: 'fullName', textField: 'fullName', grid:  getWorkName(true), onSelected:w_onSelected
			                        	}
			                    },
			                    { display: '年齡', name: 'age',minWidth:100, type:"text"},
			                    { display: '職位', name: 'job',minWidth:100, type:"text"},
			                    { display: '活動工作', name: 'Work',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '聯繫電話', name: 'mobileTelNO',minWidth:100, type:"text"},
			                    { display: '備註', name: 'note',minWidth:100, type:"text", editor: { type: 'text'}}
			                  ];
			
			
	var volunteerDataGridToolBar = [
          { text: '新增', click: addVolunteerData, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteVolunteerData, icon: 'delete' , id:"delete" }];
	
	var url = "FamilySupport/getFamilySupportApply.do?supportID="+$("#supportID").val()+"&type=3";
	
	volunteerDataGrid = ligerGrid("volunteerDataGrid",null,volunteerDataGridColumn,url,volunteerDataGridToolBar,false,true);
	
	}
	function addVolunteerData(){
		volunteerDataGrid.addRow();
	}
	function deleteVolunteerData(){
		volunteerDataGrid.deleteSelectedRow();
	}

	//參與活動記錄
	function bindingFamilySupportRecordDataGrid(){
	
	var familySupportRecordDataGridColumn = [
								{ display: 'recordID', name: 'applyID', hide:true },
			                    { display: '會員編號', name: 'custNO',minWidth:100,type:"text",editor: { type: 'text'}},
			                    { display: '會員家長姓名', name: 'fullName',minWidth:100,type:"text", editor: { type: 'text'}},
			                    { display: '智障人士姓名', name: 'fullName',minWidth:100,type:"text", editor: { type: 'text'}},
			                    { display: '家屬', name: 'family',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '家屬人數', name: 'family',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '總人數', name: 'total',minWidth:100,type:"text", editor: { type: 'text'}},
			                    { display: '接受援助日期', name: 'acceptDate', minWidth:100, type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
			                    { display: '備註', name: 'note',minWidth:100, type:"text", editor: { type: 'text'}}
			                  ];
			
			
	var familySupportRecordDataGridToolBar = [
          { text: '新增', click: addFamilySupportRecordData, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteFamilySupportRecordData, icon: 'delete' , id:"delete" }];
	
	var url = "FamilySupport/getFamilySupportRecord.do?supportID="+$("#supportID").val();
	
	familySupportRecordDataGrid = ligerGrid("familySupportRecordDataGrid",null,familySupportRecordDataGridColumn,url,familySupportRecordDataGridToolBar,false,true);
	
	}
	function addFamilySupportRecordData(){
		familySupportRecordDataGrid.addRow();
	}
	function deleteFamilySupportRecordData(){
		familySupportRecordDataGrid.deleteSelectedRow();
	}

	
	
	function itemclick(item){
		switch (item.id){
			case "save":
				save();
			break;
			case "back":
				location.href="jsp/manage/familySupport_list.jsp";
			break;
		}
		
	}
	
	function save(){
 		//familySupportApplyAdds
 		var memberDataAdds = memberDataGrid.getAdded();	
 		for(var i = 0; i<memberDataAdds.length;i++){
 			memberDataAdds[i].type=1;
 		}
 		var notMemberDataAdds = notMemberDataGrid.getAdded();	
 		for(var i = 0; i<notMemberDataAdds.length;i++){
 			notMemberDataAdds[i].type=2;
 		}
 		var volunteerDataAdds = volunteerDataGrid.getAdded();
 		for(var i = 0; i<volunteerDataAdds.length;i++){
 			volunteerDataAdds[i].type=3;
 		}
 		if(memberDataAdds != null && memberDataAdds != ""){
 			var familySupportApplyAdds=memberDataAdds.concat(notMemberDataAdds,volunteerDataAdds);
 		}else{
 			var familySupportApplyAdds=[].concat(notMemberDataAdds,volunteerDataAdds);
 		}
		
		$("#familySupportApplyAdds").val(getJsonByDataRow(familySupportApplyAdds));
		console.log(memberDataAdds)
		//console.log(getJsonByDataRow(familySupportApplyAdds))
 		//familySupportApplyUpdates
 		var memberDataUpdates = memberDataGrid.getUpdated();
		
 		var notMemberDataUpdates = notMemberDataGrid.getUpdated();	
 		var volunteerDataUpdates = volunteerDataGrid.getUpdated();	
 		if(memberDataUpdates != null && memberDataUpdates != ""){
 			var familySupportApplyUpdates=memberDataUpdates.concat(notMemberDataUpdates,volunteerDataUpdates);
 		}else{
 			var familySupportApplyUpdates=[].concat(notMemberDataUpdates,volunteerDataUpdates);
 		}
		
		$("#familySupportApplyUpdates").val(getJsonByDataRow(familySupportApplyUpdates));
		//console.log(getJsonByDataRow(familySupportApplyUpdates))
		//familySupportApplyDeletes
 		var memberDataDeletes = memberDataGrid.getDeleted();
 		var notMemberDataDeletes = (notMemberDataGrid.getDeleted() == undefined) ? [] : notMemberDataGrid.getDeleted();	
 		var volunteerDataDeletes = (volunteerDataGrid.getDeleted() == undefined) ? [] : volunteerDataGrid.getDeleted();	
 		if(memberDataDeletes != null && memberDataDeletes !=""){
 			var familySupportApplyDeletes=memberDataDeletes.concat(notMemberDataDeletes,volunteerDataDeletes);
 		}else{
 			var familySupportApplyDeletes=[].concat(notMemberDataDeletes,volunteerDataDeletes);
 		}
		$("#familySupportApplyDeletes").val(getJsonByDataRow(familySupportApplyDeletes));
		//console.log(getJsonByDataRow(familySupportApplyDeletes))
		$("#familySupportRecordAdds").val(getAddedRows(familySupportRecordDataGrid));
 		$("#familySupportRecordUpdates").val(getEditedRows(familySupportRecordDataGrid));
 		$("#familySupportRecordDeletes").val(getDeletedRows(familySupportRecordDataGrid));
		
		$("#Button1").click();	
	}
    
	$(function(){
		if($("#recordID").val() != "" && $("#recordID").val() != 'null' && $("#recordID").val() != 'undefined'){
			setTabTitle(parent.$("#framecenter"),"家庭支援編輯")
		}else{
			setTabTitle(parent.$("#framecenter"),"家庭支援新增")
		}
		
		$(".toptoolbar").ligerToolBar({ items: [
            { text: '保存', click: itemclick, icon: 'save' , id:"save" },
            { line: true },
            { text: '取消', click: itemclick, icon: 'back' , id:"back" }
          ]
          });
		
		ligerForm("form1");
		bindingMemberDataGrid();
		bindingNotMemberDataGrid();
		bindingVolunteerDataGrid();
		bindingFamilySupportRecordDataGrid();
		
	 $("#tab").ligerTab({onAfterSelectTabItem:function(targettabid){
			switch(targettabid){
				case "memberData":
						showGridInTab(memberDataGrid);
					break;
				case "notMemberData":showGridInTab(notMemberDataGrid);break;
				case "volunteerData":
					showGridInTab(volunteerDataGrid);
					break;
				case "recordData":
					showGridInTab(familySupportRecordDataGrid);
					break;
				default:break;
			}
		}}); 
		
    })
    </script>
</head>
<body>
	<div class="toptoolbar"></div>
	<form name="form1" class="liger-form" method="post" action="FamilySupport/submit.do" id="form1" style="margin: 20px;">
	<input type="hidden" name="supportID" id="supportID" value="${familySupport.supportID }">
	<input type="hidden" name="familySupportApplyAdds" id="familySupportApplyAdds">
	<input type="hidden" name="familySupportApplyUpdates" id="familySupportApplyUpdates">
	<input type="hidden" name="familySupportApplyDeletes" id="familySupportApplyDeletes">
	<input type="hidden" name="familySupportRecordAdds" id="familySupportRecordAdds" >
	<input type="hidden" name="familySupportRecordUpdates" id="familySupportRecordUpdates" >
	<input type="hidden" name="familySupportRecordDeletes" id="familySupportRecordDeletes" >
	
	<div style="padding:8px 0;">
		<div class="inline-group row max-width-group-300 label-width-100">
			<div class="col-md-3">
				<label>家庭支援編號：</label>
				<input type="text" ltype="text" width="120px" name="supportNO" value="${familySupport.supportNO }"  validate="{required:true,notnull:true}">
			</div>
			<div class="col-md-3">
				<label>家庭支援名稱：</label>
				<input type="text" ltype="text" width="120px" name="supportName" value="${familySupport.supportName }" validate="{required:true,notnull:true}">
			</div>
			<div class="col-md-3">
				<label>參加費用1：</label>
				<input type="text" style="text-align:left;" ltype="float" width="120px" name="expense1" value='${familySupport.expense1 ==null ? "0.00" :  familySupport.expense1}'>
			</div>
			<div class="col-md-3">
				<label>參加費用2：</label>
				<input type="text" style="text-align:left;" ltype="float" width="120px" name="expense2" value='${familySupport.expense2 == null ? "0.00" : familySupport.expense2}'>
			</div>
		</div>
		<div class="inline-group row max-width-group-300 label-width-100">
			<div class="col-md-3">
				<label>參加費用3：</label>
				<input type="text" style="text-align:left;" ltype="float" width="120px" name="expense3" value='${familySupport.expense3 == null ? "0.00" : familySupport.expense3}'>
			</div>
			<div class="col-md-3">
				<label>參加費用4：</label>
				<input type="text" style="text-align:left;" ltype="float" width="120px" name="expense4" value='${familySupport.expense4 == null ? "0.00" : familySupport.expense4}'>
			</div>
			<div class="col-md-3">
				<label>允許簽到次數：</label>
				<input type="text" style="text-align:left;" ltype="int" width="120px" name="time" value="${familySupport.time }">
			</div>
			<div class="col-md-3">
				<label>人數控制方式：</label>
				<input type="text" ltype="text" width="120px" name="way" value="${familySupport.way }">
			</div>
		</div>
		<div class="inline-group row max-width-group-300 label-width-100">
			<div class="col-md-3">
				<label>線上可報名名額：</label>
				<input type="text" style="text-align:left;" ltype="int" width="120px" name="onlineCan" value="${familySupport.onlineCan }">
			</div>
			<div class="col-md-3">
				<label>線下可報名名額：</label>
				<input type="text" style="text-align:left;" ltype="int" width="120px" name="offlineCan" value="${familySupport.offlineCan }">
			</div>
			<div class="col-md-3">
				<label>線上已報名名額：</label>
				<input type="text" style="text-align:left;" ltype="int" width="120px" name=onlineThen value="${familySupport.onlineThen }">
			</div>
			<div class="col-md-3">
				<label>線下已報名名額：</label>
				<input type="text" style="text-align:left;" ltype="int" width="120px" name="offlineThen" value="${familySupport.offlineThen }">
			</div>
		</div>
		<div class="inline-group row max-width-group-300 label-width-100">
			<div class="col-md-3">
				<label>參加可獲取積分：</label>
				<input type="text" style="text-align:left;" ltype="int" width="120px" name="integral" value="${familySupport.integral }">
			</div>
			<div class="col-md-3">
				<label>僅會員可報名：</label>
				<select name="isOnly" id="isOnly" ltype="select" width="120px" >
	          		<option value="0" <c:if test="${familySupport.isOnly == '0' }">selected="selected"</c:if> >是</option>
	          		<option value="1" <c:if test="${familySupport.isOnly == '1' }">selected="selected"</c:if> >否</option>
	          	</select> 
			</div>
			<div class="col-md-3">
				<label>報名開始日期：</label>
				<input type="text" ltype="date" width="120px" name="applyBDate" value="${familySupport.applyBDate_str }">
			</div>
			<div class="col-md-3">
				<label>報名結束日期：</label>
				<input type="text" ltype="date" width="120px" name="applyEDate" value="${familySupport.applyEDate_str }">
			</div>
		</div>
		<div class="inline-group row max-width-group-300 label-width-100">
			<div class="col-md-3">
				<label>支援開始日期：</label>
				<input type="text" ltype="date" width="120px" name="supportBDate" value="${familySupport.supportBDate_str }">
			</div>
			<div class="col-md-3">
				<label>支援結束日期：</label>
				<input type="text" ltype="date" width="120px" name="supportEDate" value="${familySupport.supportEDate_str }">
			</div>
			<div class="col-md-3">
				<label>支援地址：</label>
				<input type="text" ltype="text" width="120px" name="address" value="${familySupport.address }">
			</div>
			<div class="col-md-3">
				<label>支援負責人：</label>
				<input type="text" ltype="text" width="120px" name="principal" value="${familySupport.principal }">
			</div>
		</div>
		<div class="inline-group row max-width-group-300 label-width-100">
			<div class="col-md-3">
				<label>登記資料人：</label>
				<input type="text" ltype="text" width="120px" name="registrant" value="${familySupport.registrant }">
			</div>
		</div>
	</div>
	
	
	<div id="tab">
		  	<div title="會員報名" tabid="memberData">
		  		<div id="memberDataGrid"></div>
		  	</div>
		  	<div title="非會員報名" tabid="notMemberData">
		  		<div id="notMemberDataGrid"></div>
		  	</div>
		  	<div title="義工報名" tabid="volunteerData">
		  		<div id="volunteerDataGrid"></div>
		  	</div>
		  	<div title="參興活動記錄" tabid="recordData">
		  		<div id="familySupportRecordDataGrid"></div>
		  	</div>
		  	<div title="相關文件" tabid=correlationData>
		  		
		  	</div>
		  	
	  </div>
       
		<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
          </form>
        
        
        
        
    
    
    
</body>
</html>