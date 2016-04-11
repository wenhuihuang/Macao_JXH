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
        
        
	//會員父
      function p_onSelected(e) { 
            if (!e.data || !e.data.length) return;

            var grid = liger.get("memberDataGrid");

            var selected = e.data[0]; 
            //console.log(grid.lastEditRow)
			//console.log(selected)
            grid.updateRow(grid.lastEditRow, {
            	parentName: selected.parentName,
               // custID: selected.custID,
               // custNO: selected.custNO
            });
           // console.log(memberDataGridColumn)
        }
		//非會員父
	    function pN_onSelected(e) { 
	            if (!e.data || !e.data.length) return;

	            var grid = liger.get("notMemberDataGrid");

	            var selected = e.data[0]; 
	            //console.log(grid.lastEditRow)
				//console.log(selected)
	            grid.updateRow(grid.getSelectedRow(), {
	            	parentName: selected.parentName,
	               // custID: selected.custID,
	               // custNO: selected.custNO
	            });
	           // console.log(memberDataGridColumn)
	        } 
      

		function getFullName(type) {
		    var options = {
		        columns: [
				{ display: '會員ID', name: 'custID', minWidth: 120, width: 100 },
				{ display: '會員NO', name: 'custNO', minWidth: 120, width: 100 },
		        { display: '義工姓名', name: 'fullName', minWidth: 120, width: 100 }
		        ], switchPageSizeApplyComboBox: false,
		        //pageSize: 10
		       /*  checkbox: checkbox, */
		       url:"Customer/list.do?type="+type
		      // usePager:false
		       
		    };
		    return options;
		}
		var memberDataGridColumn,
		notMemberDataGridColumn,
		activityRecordDataGridColumn;
	//會員
    function f_onSelected(e) { 
          if (!e.data || !e.data.length) return;

          var grid = liger.get("memberDataGrid");

          var selected = e.data[0]; 
         
     $.ajax({
        	  url:"Customer/getCustomerByCondition.do",
        	  data:"guardianCustID="+selected.custID,
        	  success:function(d){
        		 d = d.replace(/fullName/g,"parentName");
        	 	  memberDataGridColumn[6].editor.grid= {
                          data: JSON.parse(d), columns: [
                                             { name: 'custID', width: 200, display: 'custID' }, { name: 'parentName', width: 200, display: '名字' }
                                             ]
                                         } 
        	  }
          }) 
          grid.updateRow(grid.getSelectedRow(), {
        	  amentiaName: selected.amentiaName,
              custID: selected.custID,
              custCode: selected.custCode,
          });
      }
	//非會員
    function fN_onSelected(e) { 
        if (!e.data || !e.data.length) return;

        var grid = liger.get("notMemberDataGrid");

        var selected = e.data[0]; 
       console.log(notMemberDataGridColumn)
   $.ajax({
      	  url:"Customer/getCustomerByCondition.do",
      	  data:"guardianCustID="+selected.custID,
      	  success:function(d){
      		 d = d.replace(/fullName/g,"parentName");
      		notMemberDataGridColumn[6].editor.grid= {
                        data: JSON.parse(d), columns: [
                                           { name: 'custID', width: 200, display: 'custID' }, { name: 'parentName', width: 200, display: '名字' }
                                           ]
                                       } 
      	  }
        }) 
        grid.updateRow(grid.getSelectedRow(), {
        	 amentiaName: selected.amentiaName,
            custID: selected.custID,
            custCode: selected.custCode,
        });
    }

	
        //會員報名
		function bindingMemberDataGrid(){
			
        	
		 memberDataGridColumn = [
									{ display: 'applyID', name: 'applyID', hide:true },
									{ display: 'custID', name: 'custID', hide:true },
									{ display: 'type', name: 'type', hide:true},
									{ display: '登記日期', name: 'registerDate', minWidth:100, type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '會員編號', name: 'custCode', minWidth:100, type:"text",editor: { type: 'text'}},
				                    //{ display: '會員家長姓名', name: 'parentName', minWidth:100,type:"text", editor: { type: 'text'}},
				                    //{ display: '智障人士姓名', name: 'fullName', minWidth:100,type:"text", editor: { type: 'text'}},
				                    {
				                        name: 'amentiaName',align:'center', width:100, display: '智障人士姓名', textField: 'amentiaName'
				                        , editor:
				                            {
				                            	type: 'popup', valueField: 'amentiaName', textField: 'amentiaName', grid: getFullName("1"), onSelected:f_onSelected
				                        	}
				                    },
				                    {
				                        name: 'parentName',align:'center', width:100, display: '會員家長姓名', textField: 'parentName'
				                        , editor:
				                            {
				                            	type: 'popup', valueField: 'parentName', textField: 'parentName',grid:{}, onSelected: p_onSelected 
				                        	}
				                    }, 
				                    { display: '會員家長收費', name: 'parentsExpense', minWidth:100, type:"text", editor: { type: 'float'}},
				                    { display: '智障人士收費', name: 'amentiaExpense', minWidth:100, type:"text", editor: { type: 'float'}},
				                    { display: '家屬', name: 'family', minWidth:100,type:"text", editor: { type: 'text'}},
				                    { display: '家屬收費', name: 'fExpense', minWidth:100, type:"text", editor: { type: 'float'}},
				                    { display: '家屬人數', name: 'fNumber', minWidth:100, type:"text", editor: { type: 'int'}},
				                    { display: '總人數', name: 'total', minWidth:100,type:"text", render: function(item)
				                        {
				                    	var parent = 0;
				                    	if(item.parentName != null && item.parentName != 'undefined' && item.undefined != ""){
				                    		parent=1;
				                    	}
				                    	item.total=item.fNumber+1+parent;
				                        return item.fNumber+1+parent;
				                    } },
				                    { display: '收費總和', name: 'count', minWidth:100, type:"float",render: function(item)
				                        {
				                        return item.fExpense*item.fNumber+item.parentsExpense+item.amentiaExpense;
				                    } },
				                    { display: '聯繫電話', name: 'tel',  minWidth:100,type:"text", editor: { type: 'text'}},
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
		 
	
	notMemberDataGridColumn = [
								{ display: 'applyID', name: 'applyID', hide:true },
								{ display: 'custID', name: 'custID', hide:true },
								{ display: 'type', name: 'type', hide:true},
								{ display: 'custCode', name: 'custCode', hide:true},
								{ display: '登記日期', name: 'registerDate', minWidth:100, type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
							      //{ display: '會員家長姓名', name: 'parentName', minWidth:100,type:"text", editor: { type: 'text'}},
			                    //{ display: '智障人士姓名', name: 'fullName', minWidth:100,type:"text", editor: { type: 'text'}},
			                    {
			                        name: 'amentiaName',align:'center', width:100, display: '智障人士姓名', textField: 'amentiaName'
			                        , editor:
			                            {
			                            	type: 'popup', valueField: 'amentiaName', textField: 'amentiaName', grid: getFullName("0"), onSelected:fN_onSelected
			                        	}
			                    },
			                    {
			                        name: 'parentName',align:'center', width:100, display: '會員家長姓名', textField: 'parentName'
			                        , editor:
			                            {
			                            	type: 'popup', valueField: 'parentName', textField: 'parentName',grid:{}, onSelected: pN_onSelected 
			                        	}
			                    }, 
			                    { display: '會員家長收費', name: 'parentsExpense', minWidth:100, type:"text", editor: { type: 'float'}},
			                    { display: '智障人士收費', name: 'amentiaExpense',wminWidth:100, type:"text", editor: { type: 'float'}},
			                    { display: '家屬', name: 'family',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '家屬收費', name: 'fExpense',minWidth:100, type:"text", editor: { type: 'float'}},
			                    { display: '家屬人數', name: 'fNumber',minWidth:100, type:"text", editor: { type: 'int'}},
			                    { display: '總人數', name: 'total', minWidth:100,type:"text", render: function(item)
			                        {
			                    	var parent = 0;
			                    	if(item.parentName != null && item.parentName != 'undefined' && item.undefined != ""){
			                    		parent=1;
			                    	}
			                    	item.total= item.fNumber+1+parent;
			                        return item.fNumber+1+parent;
			                    } },
			                    { display: '收費總和', name: 'count', minWidth:100, type:"float",render: function(item)
			                        {
			                        return item.fExpense*item.fNumber+item.parentsExpense+item.amentiaExpense;
			                    } },
			                    { display: '聯繫電話', name: 'tel',minWidth:100, type:"text", editor: { type: 'text'}},
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
		 
		 
		function getWorkName(checkbox) {
        	$(".l-text-popup").find("input").attr("r","dd");
		    var options = {
		        columns: [
				{ display: '會員ID', name: 'workID', minWidth: 120, width: 100 },
		        { display: '義工姓名', name: 'fullName', minWidth: 120, width: 100 }
		        ], switchPageSizeApplyComboBox: false,
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
            grid.updateRow(grid.lastEditRow, {
            	amentiaName: selected.amentiaName,
                custID: selected.workID,
                custCode: selected.custCode,
                age:selected.age,
                work:selected.work,
                job:selected.job,
                tel:selected.tel
            });
        }
	
	var volunteerDataGridColumn = [
								{ display: 'applyID', name: 'applyID', hide:true },
								{ display: 'custID', name: 'custID', hide:true },
								{ display: 'type', name: 'type', hide:true},
			                    { display: '會員編號', name: 'custCode', minWidth:100,type:"text"},
	/* 		                    {
			                        name: 'workName',align:'center', width:100, display: '會員編號', textField: 'custNO'
			                        , editor:
			                            {
			                            	type: 'popup', valueField: 'custNO', textField: 'custNO', grid:  getCustNO(true), onSelected:c_onSelected
			                        	}
			                    }, */
			                    {
			                        name: 'amentiaName',align:'center',enabledEdit :true,type:"text", width:100, display: '義工姓名', textField: 'amentiaName'
			                        , editor:
			                            {
			                            	type: 'popup',enabledEdit :true, valueField: 'amentiaName', textField: 'amentiaName', grid:  getWorkName(true), onSelected:w_onSelected
			                        	}
			                    },
			                    { display: '年齡', name: 'age',minWidth:100, type:"int"},
			                    { display: '職位', name: 'job',minWidth:100, type:"text"},
			                    { display: '活動工作', name: 'work',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '聯繫電話', name: 'tel',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '備註', name: 'note',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '總人數', name: 'total', minWidth:100,type:"text", render: function(item)
			                        {
			                    	item.total= 1;
			                        return 1;
			                    } },
			                  		
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
		//活動記錄
		function getAmentiaName(type) {
			    var options = {
			        columns: [
					//{ display: '會員ID', name: 'custID', minWidth: 120, width: 100 },
					{ display: '會員編號', name: 'custCode', minWidth: 120, width: 100 },
			        { display: '姓名', name: 'amentiaName', minWidth: 120, width: 100 }
			        ], switchPageSizeApplyComboBox: false,
			        //pageSize: 10
			       /*  checkbox: checkbox, */
			       url:"Activity/getActivityApply.do"
			      // usePager:false
			       
			    };
			    return options;
			    
			}
	    function fA_onSelected(e) { 
	        if (!e.data || !e.data.length) return;

	        var grid = liger.get("familySupportRecordDataGrid");

	        var selected = e.data[0]; 
 	   $.ajax({
	      	  url:"Customer/getCustomerByCondition.do",
	      	  data:"guardianCustID="+selected.custID,
	      	  success:function(d){
	      		 d = d.replace(/fullName/g,"parentName");
	      		familySupportRecordDataGridColumn[4].editor.grid= {
	                        data: JSON.parse(d), columns: [
	                                           { name: 'custID', width: 200, display: 'custID' }, { name: 'parentName', width: 200, display: '名字' }
	                                           ]
	                                       } 
	      	  }
	        })  
	        grid.updateRow(grid.getSelectedRow(), {
	            fulName: selected.fullName,
	            custID: selected.custID,
	            custCode: selected.custCode,
	        });
	    }
	    function pA_onSelected(e) { 
            if (!e.data || !e.data.length) return;

            var grid = liger.get("familySupportRecordDataGrid");

            var selected = e.data[0]; 
            grid.updateRow(grid.getSelectedRow(), {
            	parentName: selected.parentName,
                custID: selected.custID,
                custCode: selected.custCode
            });
        } 
	
	//是/否
	var isLateData = [{isLate:0,text:'否'},{isLate:1,text:'是'}];
	familySupportRecordDataGridColumn = [
								{ display: 'recordID', name: 'recordID', hide:true },
								{ display: 'custID', name: 'custID', hide:true },
			                    { display: '會員編號', name: 'custCode',minWidth:100,type:"text",editor: { type: 'text'}},
			                     {
			                        name: 'amentiaName',align:'center',enabledEdit :true,type:"text", width:100, display: '智障人士姓名', textField: 'amentiaName'
			                        , editor:
			                            {
			                            	type: 'popup',enabledEdit :true, valueField: 'amentiaName', textField: 'amentiaName', grid:  getAmentiaName(true), onSelected:fA_onSelected
			                        	}
			                    },
			                    {
			                        name: 'parentName',align:'center', width:100, display: '會員家長姓名', textField: 'parentName'
			                        , editor:
			                            {
			                            	type: 'popup', valueField: 'parentName', textField: 'parentName',grid:{}, onSelected: pA_onSelected 
			                        	}
			                    },  
			                    { display: '家屬', name: 'family',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '總人數', name: 'sum',minWidth:100,type:"text", editor: { type: 'text'}},
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
		$("#memberDataAdds").val(getAddedRows(memberDataGrid));
 		$("#memberDataUpdates").val(getEditedRows(memberDataGrid));
 		$("#memberDataDeletes").val(getDeletedRows(memberDataGrid));
 		
		$("#notMemberDataAdds").val(getAddedRows(notMemberDataGrid));
 		$("#notMemberDataUpdates").val(getEditedRows(notMemberDataGrid));
 		$("#notMemberDataDeletes").val(getDeletedRows(notMemberDataGrid));
 		
		$("#volunteerDataAdds").val(getAddedRows(volunteerDataGrid));
 		$("#volunteerDataUpdates").val(getEditedRows(volunteerDataGrid));
 		$("#volunteerDataDeletes").val(getDeletedRows(volunteerDataGrid));
		
		$("#familySupportRecordAdds").val(getAddedRows(familySupportRecordDataGrid));
 		$("#familySupportRecordUpdates").val(getEditedRows(familySupportRecordDataGrid));
 		$("#familySupportRecordDeletes").val(getDeletedRows(familySupportRecordDataGrid));
		$("#Button1").click();
	}
    
	$(function(){
		/* if($("#recordID").val() != "" && $("#recordID").val() != 'null' && $("#recordID").val() != 'undefined'){
			setTabTitle(parent.$("#framecenter"),"活動編輯")
		}else{
			setTabTitle(parent.$("#framecenter"),"活動新增")
		} */
		
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
	<input type="hidden" name="familySupportRecordAdds" id="familySupportRecordAdds" >
	<input type="hidden" name="familySupportRecordUpdates" id="familySupportRecordUpdates" >
	<input type="hidden" name="familySupportRecordDeletes" id="familySupportRecordDeletes" >
	
	<input type="hidden" name="memberDataAdds" id="memberDataAdds" >
	<input type="hidden" name="memberDataUpdates" id="memberDataUpdates" >
	<input type="hidden" name="memberDataDeletes" id="memberDataDeletes" >
	<input type="hidden" name="notMemberDataAdds" id="notMemberDataAdds" >
	<input type="hidden" name="notMemberDataUpdates" id="notMemberDataUpdates" >
	<input type="hidden" name="notMemberDataDeletes" id="notMemberDataDeletes" >
	<input type="hidden" name="volunteerDataAdds" id="volunteerDataAdds" >
	<input type="hidden" name="volunteerDataUpdates" id="volunteerDataUpdates" >
	<input type="hidden" name="volunteerDataDeletes" id="volunteerDataDeletes" >
	
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
				<div class="col-md-3">
					<label>備註：</label>
					<input type="text" ltype="text" width="120px" name="note" value="${familySupport.note }">
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