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
        	activityRecordDataGrid;
        
        //會員報名
		function bindingMemberDataGrid(){
		
		var memberDataGridColumn = [
									{ display: 'applyID', name: 'applyID', hide:true },
									{ display: '登記日期', name: 'registerDate', minWidth:100, type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '會員編號', name: 'custNO', minWidth:100, type:"text",editor: { type: 'text'}},
				                    { display: '會員家長姓名', name: 'fullName', minWidth:100,type:"text", editor: { type: 'text'}},
				                    { display: '會員家長收費', name: 'parentsExpense', minWidth:100, type:"text", editor: { type: 'text'}},
				                    { display: '智障人士姓名', name: 'fullName', minWidth:100,type:"text", editor: { type: 'text'}},
				                    { display: '智障人士收費', name: 'amentiaExpense', minWidth:100, type:"text", editor: { type: 'text'}},
				                    { display: '家屬', name: 'family', minWidth:100,type:"text", editor: { type: 'text'}},
				                    { display: '家屬收費', name: 'fExpense', minWidth:100, type:"text", editor: { type: 'text'}},
				                    { display: '家屬人數', name: 'fNumber', minWidth:100, type:"text", editor: { type: 'text'}},
				                    { display: '總人數', name: 'note', minWidth:100,type:"text", editor: { type: 'text'}},
				                    { display: '收費總和', name: 'count', minWidth:100, type:"text", editor: { type: 'text'}},
				                    { display: '聯繫電話', name: 'mobileTelNO',  minWidth:100,type:"text", editor: { type: 'text'}},
				                    { display: '備註', name: 'note', type:"text",minWidth:100, editor: { type: 'text'}}
				                  ];
				
				
		var memberDataGridToolBar = [
	          { text: '新增', click: addMemberData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteMemberData, icon: 'delete' , id:"delete" }];
		
		var url = "Activity/getActivityApply.do?actID="+$("#actID").val()+"&type=1";
		
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
								{ display: '登記日期', name: 'registerDate', minWidth:100, type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
			                    { display: '家長姓名', name: 'fullName',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '家長收費', name: 'parentsExpense',minWidth:100,type:"text", editor: { type: 'text'}},
			                    { display: '智障人士姓名', name: 'fullName',minWidth:100, type:"text", editor: { type: 'text'}},
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
	
	var url = "Activity/getActivityApply.do?actID="+$("#actID").val()+"&type=2";
	
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
	
	var volunteerDataGridColumn = [
								{ display: 'applyID', name: 'applyID', hide:true },
			                    { display: '會員編號', name: 'custNO', minWidth:100,type:"text",editor: { type: 'text'}},
			                    { display: '義工姓名', name: 'fullName',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '年齡', name: 'age',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '職位', name: 'work',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '活動工作', name: 'actWork',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '聯繫電話', name: 'mobileTelNO',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '備註', name: 'note',minWidth:100, type:"text", editor: { type: 'text'}}
			                  ];
			
			
	var volunteerDataGridToolBar = [
          { text: '新增', click: addVolunteerData, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteVolunteerData, icon: 'delete' , id:"delete" }];
	
	var url = "Activity/getActivityApply.do?actID="+$("#actID").val()+"&type=3";
	
	volunteerDataGrid = ligerGrid("volunteerDataGrid",null,volunteerDataGridColumn,url,volunteerDataGridToolBar,false,true);
	
	}
	function addVolunteerData(){
		volunteerDataGrid.addRow();
	}
	function deleteVolunteerData(){
		volunteerDataGrid.deleteSelectedRow();
	}

	//參與活動記錄
	function bindingActivityRecordDataGrid(){
	
	var activityRecordDataGridColumn = [
								{ display: 'recordID', name: 'applyID', hide:true },
			                    { display: '會員編號', name: 'custNO',minWidth:100,type:"text",editor: { type: 'text'}},
			                    { display: '會員家長姓名', name: 'fullName',minWidth:100,type:"text", editor: { type: 'text'}},
			                    { display: '智障人士姓名', name: 'fullName',minWidth:100,type:"text", editor: { type: 'text'}},
			                    { display: '家屬', name: 'family',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '總人數', name: 'total',minWidth:100,type:"text", editor: { type: 'text'}},
			                    { display: '報到日期', name: 'RegisterDate',minWidth:100,type:"text", editor: { type: 'text'}},
			                    { display: '報到時間', name: 'RegisterTime',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '是否遲到', name: 'isLate',minWidth:100, type:"text", editor: { type: 'text'}},
			                    { display: '備註', name: 'note',minWidth:100, type:"text", editor: { type: 'text'}}
			                  ];
			
			
	var activityRecordDataGridToolBar = [
          { text: '新增', click: addActivityRecordData, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteActivityRecordData, icon: 'delete' , id:"delete" }];
	
	var url = "Activity/getActivityRecordNew.do?actID="+$("#actID").val();
	
	activityRecordDataGrid = ligerGrid("activityRecordDataGrid",null,activityRecordDataGridColumn,url,activityRecordDataGridToolBar,false,true);
	
	}
	function addActivityRecordData(){
		activityRecordDataGrid.addRow();
	}
	function deleteActivityRecordData(){
		activityRecordDataGrid.deleteSelectedRow();
	}

	
	
	function itemclick(item){
		switch (item.id){
			case "save":
				save();
			break;
			case "back":
				location.href="jsp/manage/medical_list.jsp";
			break;
		}
		
	}
	
	function save(){
 		//activityApplyAdds
 		var memberDataAdds = memberDataGrid.getAdded();	
 		var notMemberDataAdds = notMemberDataGrid.getAdded();	
 		var volunteerDataAdds = volunteerDataGrid.getAdded();	
		var activityApplyAdds=memberDataAdds.concat(notMemberDataAdds,volunteerDataAdds);
		$("#activityApplyAdds").val(getJsonByDataRow(activityApplyAdds));
		//console.log(getJsonByDataRow(activityApplyAdds))
 		//activityApplyUpdates
 		var memberDataUpdates = memberDataGrid.getUpdated();
 		var notMemberDataUpdates = notMemberDataGrid.getUpdated();	
 		var volunteerDataUpdates = volunteerDataGrid.getUpdated();	
		var activityApplyUpdates=memberDataUpdates.concat(notMemberDataUpdates,volunteerDataUpdates);
		$("#activityApplyUpdates").val(getJsonByDataRow(activityApplyUpdates));
		//console.log(getJsonByDataRow(activityApplyUpdates))
		//activityApplyDeletes
 		var memberDataDeletes = memberDataGrid.getDeleted();
 		var notMemberDataDeletes = notMemberDataGrid.getDeleted();	
 		var volunteerDataDeletes = volunteerDataGrid.getDeleted();	
		var activityApplyDeletes=memberDataDeletes.concat(notMemberDataDeletes,volunteerDataDeletes);
		$("#activityApplyDeletes").val(getJsonByDataRow(activityApplyDeletes));
		//console.log(getJsonByDataRow(activityApplyDeletes))
		$("#activityRecordNewAdds").val(getAddedRows(activityRecordDataGrid));
 		$("#activityRecordNewUpdates").val(getEditedRows(activityRecordDataGrid));
 		$("#activityRecordNewDeletes").val(getDeletedRows(activityRecordDataGrid));
		
		$("#Button1").click();	
	}
    
	$(function(){
		if($("#recordID").val() != "" && $("#recordID").val() != 'null' && $("#recordID").val() != 'undefined'){
			setTabTitle(parent.$("#framecenter"),"醫護記錄編輯")
		}else{
			setTabTitle(parent.$("#framecenter"),"醫護記錄新增")
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
		bindingActivityRecordDataGrid();
		
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
					showGridInTab(activityRecordDataGrid);
					break;
				default:break;
			}
		}}); 
		
    })
    </script>
</head>
<body>
	<div class="toptoolbar"></div>
	<form name="form1" class="liger-form" method="post" action="Medical/submit.do" id="form1" style="margin: 20px;">
	<input type="hidden" name="actID" id="actID" value="${activitySetting.actID }">
	<input type="hidden" name="medicalRecordFamilyAdds" id="medicalRecordFamilyAdds">
	<input type="hidden" name="medicalRecordFamilyUpdates" id="medicalRecordFamilyUpdates">
	<input type="hidden" name="medicalRecordFamilyDeletes" id="medicalRecordFamilyDeletes">
	<input type="hidden" name="medicalRecordViewAdds" id="medicalRecordViewAdds" >
	<input type="hidden" name="medicalRecordViewUpdates" id="medicalRecordViewUpdates" >
	<input type="hidden" name="medicalRecordViewDeletes" id="medicalRecordViewDeletes" >
	
	
	<div class="inline-group row max-width-group-300 label-width-100">
		<div class="col-md-3">
			<label>活動編號：</label>
			<input type="text" ltype="text" width="120px" name="actNO" value="${activitySetting.actNO }">
		</div>
		<div class="col-md-3">
			<label>活動名稱：</label>
			<input type="text" ltype="text" width="120px" name="actName" value="${activitySetting.actName }">
		</div>
		<div class="col-md-3">
			<label>參加費用1：</label>
			<input type="text" ltype="text" width="120px" name="expense1" value="${activitySetting.expense1 }">
		</div>
		<div class="col-md-3">
			<label>參加費用2：</label>
			<input type="text" ltype="text" width="120px" name="expense2" value="${activitySetting.expense2 }">
		</div>
	</div>
	<div class="inline-group row max-width-group-300 label-width-100">
		<div class="col-md-3">
			<label>參加費用3：</label>
			<input type="text" ltype="text" width="120px" name="expense3" value="${activitySetting.expense3 }">
		</div>
		<div class="col-md-3">
			<label>參加費用4：</label>
			<input type="text" ltype="text" width="120px" name="expense4" value="${activitySetting.expense4 }">
		</div>
		<div class="col-md-3">
			<label>允許簽到次數：</label>
			<input type="text" ltype="text" width="120px" name="time" value="${activitySetting.time }">
		</div>
		<div class="col-md-3">
			<label>人數控制方式：</label>
			<input type="text" ltype="text" width="120px" name="way" value="${activitySetting.way }">
		</div>
	</div>
	<div class="inline-group row max-width-group-300 label-width-100">
		<div class="col-md-3">
			<label>線上可報名名額：</label>
			<input type="text" ltype="text" width="120px" name="actName" value="${activitySetting.actName }">
		</div>
		<div class="col-md-3">
			<label>線下可報名名額：</label>
			<input type="text" ltype="text" width="120px" name="actName" value="${activitySetting.actName }">
		</div>
		<div class="col-md-3">
			<label>線上已報名名額：</label>
			<input type="text" ltype="text" width="120px" name="actName" value="${activitySetting.actName }">
		</div>
		<div class="col-md-3">
			<label>線下已報名名額：</label>
			<input type="text" ltype="text" width="120px" name="actName" value="${activitySetting.actName }">
		</div>
	</div>
	<div class="inline-group row max-width-group-300 label-width-100">
		<div class="col-md-3">
			<label>參加可獲取積分：</label>
			<input type="text" ltype="text" width="120px" name="actName" value="${activitySetting.actName }">
		</div>
		<div class="col-md-3">
			<label>僅會員可報名：</label>
			
		</div>
		<div class="col-md-3">
			<label>報名開始日期：</label>
			<input type="text" ltype="text" width="120px" name="actName" value="${activitySetting.actName }">
		</div>
		<div class="col-md-3">
			<label>報名結束日期：</label>
			<input type="text" ltype="text" width="120px" name="actName" value="${activitySetting.actName }">
		</div>
	</div>
	<div class="inline-group row max-width-group-300 label-width-100">
		<div class="col-md-3">
			<label>活動開始日期：</label>
			<input type="text" ltype="text" width="120px" name="actName" value="${activitySetting.actName }">
		</div>
		<div class="col-md-3">
			<label>活動結束日期：</label>
			<input type="text" ltype="text" width="120px" name="actName" value="${activitySetting.actName }">
		</div>
		<div class="col-md-3">
			<label>活動地址：</label>
			<input type="text" ltype="text" width="120px" name="actName" value="${activitySetting.actName }">
		</div>
		<div class="col-md-3">
			<label>活動負責人：</label>
			<input type="text" ltype="text" width="120px" name="actName" value="${activitySetting.actName }">
		</div>
	</div>
	<div class="inline-group row max-width-group-300 label-width-100">
		<div class="col-md-3">
			<label>登記資料人：</label>
			<input type="text" ltype="text" width="120px" name="actName" value="${activitySetting.actName }">
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
		  		<div id="activityRecordDataGrid"></div>
		  	</div>
		  	<div title="相關文件" tabid=correlationData>
		  		
		  	</div>
		  	
	  </div>
       
		<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
          </form>
        
        
        
        
    
    
    
</body>
</html>