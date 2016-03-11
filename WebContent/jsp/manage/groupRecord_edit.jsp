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
        var medicalRecordFamilyDataGrid,
        	medicalRecordViewDataGrid;
        
        //家族病史
		function bindingMedicalRecordFamilyDataGrid(){
		
		var medicalRecordFamilyDataGridColumn = [
									{ display: 'familyID', name: 'familyID', hide:true },
				                    { display: '關係', name: 'relationShip', width: 100,type:"text",editor: { type: 'text' }},
				                    { display: '病史', name: 'historyNote', width: 100 ,type:"text",editor: { type: 'text'}},
				                    { display: '備註', name: 'note',width:300, type:"text", editor: { type: 'text'}}
				                  ];
				
				
		var medicalRecordFamilyDataGridToolBar = [
	          { text: '新增', click: addMedicalRecordFamilyData, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteMedicalRecordFamilyData, icon: 'delete' , id:"delete" }];
		
		var url = "Medical/getMedicalRecordFamily.do?recordID="+$("#recordID").val();
		
		medicalRecordFamilyDataGrid = ligerGrid("medicalRecordFamilyDataGrid",null,medicalRecordFamilyDataGridColumn,url,medicalRecordFamilyDataGridToolBar,false,true);
		
	}
	function addMedicalRecordFamilyData(){
		medicalRecordFamilyDataGrid.addRow();
	}
	function deleteMedicalRecordFamilyData(){
		medicalRecordFamilyDataGrid.deleteSelectedRow();
	}
	
    //約束觀察記錄
	function bindingMedicalRecordViewDataGrid(){
	
	var medicalRecordViewDataGridColumn = [
								{ display: 'viewID', name: 'viewID', hide:true },
			                    { display: '日期', name: 'billDate', width: 100,type:"date",format: 'yyyy-MM-dd',editor: { type: 'date' }},
			                    { display: '觀察項目', name: 'project', width: 100 ,type:"text",editor: { type: 'text'}},
			                    { display: '精神狀況', columns:[
			                                                	{ display: '清醒', name: 'mentalitySober', type:"text",editor: { type: 'text'}},
			                                                	{ display: '昏睡', name: 'mentalityLethargy', type:"text",editor: { type: 'text'}},
			                                                	{ display: '煩燥不安', name: 'mentalityUneasy', type:"text",editor: { type: 'text'}}
			                                                ]},
			                    { display: '心肺功能', columns:[
																{ display: '呼吸暢順', name: 'heartLungBreathe', type:"text",editor: { type: 'text'}},
																{ display: '氣促', name: 'heartLungAnhelation', type:"text",editor: { type: 'text'}},
			                                                ]},
			                    { display: '血液循環', columns:[
																{ display: '手腳溫暖', name: 'bloodWarmth', type:"text",editor: { type: 'text'}},
																{ display: '紅潤', name: 'bloodRuddy', type:"text",editor: { type: 'text'}},
																{ display: '冰凍', name: 'bloodFrozen', type:"text",editor: { type: 'text'}},
																{ display: '青白', name: 'bloodPallor', type:"text",editor: { type: 'text'}},
																{ display: '瘀青', name: 'bloodBruise', type:"text",editor: { type: 'text'}},
																{ display: '消腫', name: 'bloodDe', type:"text",editor: { type: 'text'}}
			                                                ]},
			                    { display: '皮膚功能', columns:[
																{ display: '皮膚完整', name: 'skinFull', type:"text",editor: { type: 'text'}},
																{ display: '皮膚破損', name: 'skinDamaged', type:"text",editor: { type: 'text'}}
			                                                ]},
			                    { display: '神經系統', columns:[
																{ display: '感覺無不適', name: 'nerveDiscomfort', type:"text",editor: { type: 'text'}},
																{ display: '麻痺/痛', name: 'nerveParalysis', type:"text",editor: { type: 'text'}}
			                                                ]},
			                    { display: '鬆解時間', name: 'releaseDate',width:120, type:"date", editor: { type: 'date'}},
			                    { display: '觀察者簽名', name: 'handler',width:120, type:"text", editor: { type: 'text'}},
			                  ];
			
			
	var medicalRecordViewDataGridToolBar = [
          { text: '新增', click: addMedicalRecordViewData, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteMedicalRecordViewData, icon: 'delete' , id:"delete" }];
	
	var url = "Medical/getMedicalRecordView.do?recordID="+$("#recordID").val();
	
	medicalRecordViewDataGrid = ligerGrid("medicalRecordViewDataGrid",null,medicalRecordViewDataGridColumn,url,medicalRecordViewDataGridToolBar,false,true);
	
}
function addMedicalRecordViewData(){
	medicalRecordViewDataGrid.addRow();
}
function deleteMedicalRecordViewData(){
	medicalRecordViewDataGrid.deleteSelectedRow();
}
	
	
	
	function itemclick(item){
		switch (item.id){
			case "save":
				save();
			break;
			case "back":
				location.href="jsp/manage/groupRecord_list.jsp";
			break;
		}
		
	}
	
	function save(){
		$("#medicalRecordFamilyAdds").val(getAddedRows(medicalRecordFamilyDataGrid));
 		$("#medicalRecordFamilyUpdates").val(getEditedRows(medicalRecordFamilyDataGrid));
 		$("#medicalRecordFamilyDeletes").val(getDeletedRows(medicalRecordFamilyDataGrid));
 		$("#medicalRecordViewAdds").val(getAddedRows(medicalRecordViewDataGrid));
 		$("#medicalRecordViewUpdates").val(getEditedRows(medicalRecordViewDataGrid));
 		$("#medicalRecordViewDeletes").val(getDeletedRows(medicalRecordViewDataGrid));
 		checkboxValue(["history","hobby"])
 		console.log($("#medicalRecordFamilyAdds").val())
 		console.log($("#medicalRecordViewAdds").val())
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
		//拆分history checkbox
		splitCheckbox("history");
		splitCheckbox("hobby");
		
		
		ligerForm("form1");
		bindingMedicalRecordFamilyDataGrid();
		bindingMedicalRecordViewDataGrid();
		
	 $("#tab").ligerTab({onAfterSelectTabItem:function(targettabid){
			switch(targettabid){
				case "personageData":
						showGridInTab(medicalRecordFamilyDataGrid);
					break;
				case "recordData":showGridInTab(medicalRecordViewDataGrid);break;
				default:break;
			}
		}}); 
		
    })
        
    </script>
</head>
<body>
	<div class="toptoolbar"></div>
	<form name="form1" class="liger-form" method="post" action="Medical/submit.do" id="form1" style="margin: 20px;">
	<input type="hidden" name="recordID" id="recordID" value="${groupSettingRecord.recordID }">
	<input type="hidden" name="medicalRecordFamilyAdds" id="medicalRecordFamilyAdds">
	<input type="hidden" name="medicalRecordFamilyUpdates" id="medicalRecordFamilyUpdates">
	<input type="hidden" name="medicalRecordFamilyDeletes" id="medicalRecordFamilyDeletes">
	<input type="hidden" name="medicalRecordViewAdds" id="medicalRecordViewAdds" >
	<input type="hidden" name="medicalRecordViewUpdates" id="medicalRecordViewUpdates" >
	<input type="hidden" name="medicalRecordViewDeletes" id="medicalRecordViewDeletes" >
	
	<input type="hidden" name="history" id="history" value="${medicalRecord.history }">
	<input type="hidden" name="hobby" id="hobby" value="${medicalRecord.hobby }">
	
	
	<div id="tab">
		  	<div title="小組記錄" tabid="personageData">
		  		<div class="inline-group">
		  			<label>參與小組：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" />
		  			<label>小組目標：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" />
		  		</div>
		  		<div class="inline-group">
		  			<label>開始日期：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" />
		  			<label>結束日期：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" />
		  		</div>
		  		<div class="inline-group">
		  			<label>帶領者：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" />
		  			<label>參與人數：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" />
		  		</div>
		  		<div class="inline-group">
		  			<label>地點：</label>
		  			<textarea rows="2" cols="55" name="foodNote" >${groupSetting.foodNote }</textarea>
		  		</div>
		  		<div class="inline-group">
		  			<label>材料或設備：</label>
		  			<textarea rows="2" cols="55" name="foodNote" >${groupSetting.foodNote }</textarea>
		  		</div>
		  		<div class="inline-group">
		  			<label>預計參與學員：</label>
		  			<textarea rows="2" cols="55" name="foodNote" >${groupSetting.foodNote }</textarea>
		  		</div>
		  		<div id="GroupSettingRecordBudgetDataGrid"></div>
		  		<div class="inline-group">
		  			<label>場地配置：</label>
		  			<textarea rows="2" cols="55" name="" ></textarea>
		  		</div>
		  		<div id="GroupSettingRecordPlanDataGrid"></div>
		  		<div id="GroupSettingRecordPerformanceDataGrid"></div>
		  		<div class="inline-group">
		  			<label>小組總結：</label>
		  			<textarea rows="2" cols="55" name="" ></textarea>
		  		</div>
		  	</div>
		  	<div tabid="recordData" title="小組設置">
		  		<div class="inline-group">
		  			<label>小組編號：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" />
		  			<label>負責人：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" />
		  		</div>
		  		<div class="inline-group">
		  			<label>小組名稱：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" />
		  			<label>小組目標：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" />
		  		</div>
		  		<div class="inline-group">
		  			<label>開始日期：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" />
		  			<label>結束日期：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" />
		  		</div>
		  		<div class="inline-group">
		  			<label>帶領者：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" />
		  			<label>參與人數：</label>
		  			<input width="120px" value="${groupSetting.custNewNO }" name="custNewNO" type="text" />
		  		</div>
		  		<div class="inline-group">
		  			<label>收費：</label>
		  			<textarea rows="2" cols="55" name="foodNote" >${groupSetting.foodNote }</textarea>
		  		</div>
		  		<div class="inline-group">
		  			<label>地點：</label>
		  			<textarea rows="2" cols="55" name="foodNote" >${groupSetting.foodNote }</textarea>
		  		</div>
		  		<div class="inline-group">
		  			<label>材料或設備：</label>
		  			<textarea rows="2" cols="55" name="foodNote" >${groupSetting.foodNote }</textarea>
		  		</div>
		  		<div class="inline-group">
		  			<label>參與學員：</label>
		  			<textarea rows="2" cols="55" name="foodNote" >${groupSetting.foodNote }</textarea>
		  		</div>
		  		<div id="medicalRecordViewDataGrid"></div>
		  		<div class="inline-group">
		  			<label>場地配置：</label>
		  			<textarea rows="2" cols="55" name="foodNote" >${groupSetting.foodNote }</textarea>
		  		</div>
		  	</div>
		  	
	  </div>
       
		<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
          </form>
        
        
        
        
    
    
    
</body>
</html>