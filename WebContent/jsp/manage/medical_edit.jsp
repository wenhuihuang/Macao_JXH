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
    	
	var mentalitySoberData = [{mentalitySober:0,text:'正常'},{mentalitySober:1,text:'異常'}];
	var mentalityLethargyData = [{mentalityLethargy:0,text:'正常'},{mentalityLethargy:1,text:'異常'}];
	var mentalityUneasyData = [{mentalityUneasy:0,text:'正常'},{mentalityUneasy:1,text:'異常'}];
	var heartLungBreatheData = [{heartLungBreathe:0,text:'正常'},{heartLungBreathe:1,text:'異常'}];
	var heartLungAnhelationData = [{heartLungAnhelation:0,text:'正常'},{heartLungAnhelation:1,text:'異常'}];
	var bloodWarmthData = [{bloodWarmth:0,text:'正常'},{bloodWarmth:1,text:'異常'}];
	var bloodRuddyData = [{bloodRuddy:0,text:'正常'},{bloodRuddy:1,text:'異常'}];
	var bloodFrozenData = [{bloodFrozen:0,text:'正常'},{bloodFrozen:1,text:'異常'}];
	var bloodPallorData = [{bloodPallor:0,text:'正常'},{bloodPallor:1,text:'異常'}];
	var bloodBruiseData = [{bloodBruise:0,text:'正常'},{bloodBruise:1,text:'異常'}];
	var bloodDeData = [{bloodDe:0,text:'正常'},{bloodDe:1,text:'異常'}];
	var skinFullData = [{skinFull:0,text:'正常'},{skinFull:1,text:'異常'}];
	var skinDamagedData = [{skinDamaged:0,text:'正常'},{skinDamaged:1,text:'異常'}];
	var nerveDiscomfortData = [{nerveDiscomfort:0,text:'正常'},{nerveDiscomfort:1,text:'異常'}];
	var nerveParalysisData = [{nerveParalysis:0,text:'正常'},{nerveParalysis:1,text:'異常'}];
	
	var medicalRecordViewDataGridColumn = [
								{ display: 'viewID', name: 'viewID', hide:true },
			                    { display: '日期', name: 'billDate', width: 100,type:"date",format: 'yyyy-MM-dd',editor: { type: 'date' }},
			                    { display: '觀察時間', name: 'project', id:'time', width: 100 ,type:"text",editor: { type: 'text'}},
			                    { display: '精神狀況', columns:[
			                                                	{ display: '清醒', name: 'mentalitySober', type:"text",editor: {type: 'select', data: mentalitySoberData, valueField: 'mentalitySober'},
			                                                		render: function (item)
			                				                        {
			                				                        	return getGridSelectedData(mentalitySoberData[parseInt(item.mentalitySober)]);
			                				                        }},
			                                                	{ display: '昏睡', name: 'mentalityLethargy', type:"text",editor: {type: 'select', data: mentalityLethargyData, valueField: 'mentalityLethargy'},
		                				                        	render: function (item)
			                				                        {
			                				                        	return getGridSelectedData(mentalityLethargyData[parseInt(item.mentalityLethargy)]);
			                				                        }    	
			                                                	},
			                                                	{ display: '煩燥不安', name: 'mentalityUneasy', type:"text",editor: {type: 'select', data: mentalityUneasyData, valueField: 'mentalityUneasy'},
			                                                		render: function (item)
			                				                        {
			                				                        	return getGridSelectedData(mentalityUneasyData[parseInt(item.mentalityUneasy)]);
			                				                        }   
			                                                	}
			                                                ]},
			                    { display: '心肺功能', columns:[
																{ display: '呼吸暢順', name: 'heartLungBreathe', type:"text",editor: {type: 'select', data: heartLungBreatheData, valueField: 'heartLungBreathe'},
																	render: function (item)
			                				                        {
			                				                        	return getGridSelectedData(heartLungBreatheData[parseInt(item.heartLungBreathe)]);
			                				                        }
																},
																{ display: '氣促', name: 'heartLungAnhelation', type:"text",editor: {type: 'select', data: heartLungAnhelationData, valueField: 'heartLungAnhelation'},
																	render: function (item)
			                				                        {
			                				                        	return getGridSelectedData(heartLungAnhelationData[parseInt(item.heartLungAnhelation)]);
			                				                        }	
																},
			                                                ]},
			                    { display: '血液循環', columns:[
																{ display: '手腳溫暖', name: 'bloodWarmth', type:"text",editor: {type: 'select', data: bloodWarmthData, valueField: 'bloodWarmth'},
																	render: function (item)
			                				                        {
			                				                        	return getGridSelectedData(bloodWarmthData[parseInt(item.bloodWarmth)]);
			                				                        }
																},
																{ display: '紅潤', name: 'bloodRuddy', type:"text",editor: {type: 'select', data: bloodRuddyData, valueField: 'bloodRuddy'},
																	render: function (item)
			                				                        {
			                				                        	return getGridSelectedData(bloodRuddyData[parseInt(item.bloodRuddy)]);
			                				                        }	
																},
																{ display: '冰凍', name: 'bloodFrozen', type:"text",editor: {type: 'select', data: bloodFrozenData, valueField: 'bloodFrozen'},
																	render: function (item)
			                				                        {
			                				                        	return getGridSelectedData(bloodFrozenData[parseInt(item.bloodFrozen)]);
			                				                        }	
																},
																{ display: '青白', name: 'bloodPallor', type:"text",editor: {type: 'select', data: bloodPallorData, valueField: 'bloodPallor'},
																	render: function (item)
			                				                        {
			                				                        	return getGridSelectedData(bloodPallorData[parseInt(item.bloodPallor)]);
			                				                        }	
																},
																{ display: '瘀青', name: 'bloodBruise', type:"text",editor: {type: 'select', data: bloodBruiseData, valueField: 'bloodBruise'},
																	render: function (item)
			                				                        {
			                				                        	return getGridSelectedData(bloodBruiseData[parseInt(item.bloodBruise)]);
			                				                        }	
																},
																{ display: '消腫', name: 'bloodDe', type:"text",editor: {type: 'select', data: bloodDeData, valueField: 'bloodDe'},
																	render: function (item)
			                				                        {
			                				                        	return getGridSelectedData(bloodDeData[parseInt(item.bloodDe)]);
			                				                        }	
																}
			                                                ]},
			                    { display: '皮膚功能', columns:[
																{ display: '皮膚完整', name: 'skinFull', type:"text",editor: {type: 'select', data: skinFullData, valueField: 'skinFull'},
																	render: function (item)
			                				                        {
			                				                        	return getGridSelectedData(skinFullData[parseInt(item.skinFull)]);
			                				                        }	
																},
																{ display: '皮膚破損', name: 'skinDamaged', type:"text",editor: {type: 'select', data: skinDamagedData, valueField: 'skinDamaged'},
																	render: function (item)
			                				                        {
			                				                        	return getGridSelectedData(skinDamagedData[parseInt(item.skinDamaged)]);
			                				                        }	
																}
			                                                ]},
			                    { display: '神經系統', columns:[
																{ display: '感覺無不適', name: 'nerveDiscomfort', type:"text",editor: {type: 'select', data: nerveDiscomfortData, valueField: 'nerveDiscomfort'},
																	render: function (item)
			                				                        {
			                				                        	return getGridSelectedData(nerveDiscomfortData[parseInt(item.nerveDiscomfort)]);
			                				                        }	
																},
																{ display: '麻痺/痛', name: 'nerveParalysis', type:"text",editor: {type: 'select', data: nerveParalysisData, valueField: 'nerveParalysis'},
																	render: function (item)
			                				                        {
			                				                        	return getGridSelectedData(nerveParalysisData[parseInt(item.nerveParalysis)]);
			                				                        }	
																}
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
				location.href="jsp/manage/medical_list.jsp";
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
	<input type="hidden" name="custID" id="custID" value="${customer.custID }">
	<input type="hidden" name="recordID" id="recordID" value="${medicalRecord.recordID }">
	<input type="hidden" name="medicalRecordFamilyAdds" id="medicalRecordFamilyAdds">
	<input type="hidden" name="medicalRecordFamilyUpdates" id="medicalRecordFamilyUpdates">
	<input type="hidden" name="medicalRecordFamilyDeletes" id="medicalRecordFamilyDeletes">
	<input type="hidden" name="medicalRecordViewAdds" id="medicalRecordViewAdds" >
	<input type="hidden" name="medicalRecordViewUpdates" id="medicalRecordViewUpdates" >
	<input type="hidden" name="medicalRecordViewDeletes" id="medicalRecordViewDeletes" >
	
	<input type="hidden" name="history" id="history" value="${medicalRecord.history }">
	<input type="hidden" name="hobby" id="hobby" value="${medicalRecord.hobby }">
	
	
	<div id="tab">
		  	<div title="學員個人健康資料" tabid="personageData">
				<table>
					<tbody>
			            <tr>
			                <td align="right" class="l-table-edit-td">姓名：</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.fullName }" name="fullName" type="text" class="fullName"/></td>
			                
			                <td align="right" class="l-table-edit-td">會員編號：</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.custNO }" name="custNO" type="text" class="custNO" /></td>
			                
			                <td align="right" class="l-table-edit-td">非會員編號：</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.custNewNO }" name="custNewNO" type="text" class="custNewNO" /></td>
			              </tr>
					</tbody>
				</table>
				<div id="medicalRecordFamilyDataGrid"></div>
				<div class="inline-group">
					<label>個人病史</label>
					<div class="checkbox-group padding15">
						<p>
						<label><input type="checkbox" class="history" value="0">糖尿病 </label>
   						<label><input type="checkbox" class="history" value="1">高血壓</label>
   						<label><input type="checkbox" class="history" value="2">心臟病</label>
   						<label><input type="checkbox" class="history" value="3">腎病</label>
   						</p>
   						<p>
   						<label><input type="checkbox" class="history" value="4">肝炎 </label>
   						<label><input type="checkbox" class="history" value="5">肝炎帶菌</label>
   						<label><input type="checkbox" class="history" value="6">結核病</label>
   						<label><input type="checkbox" class="history" value="7">冠狀動脈病</label>
   						</p>
   						<p>
   						<label><input type="checkbox" class="history" value="8">精神病 </label>
   						<label><input type="checkbox" class="history" value="9">癌症內</label>
   						<label><input type="checkbox" class="history" value="10">分泌性疾病</label>
   						<label><input type="checkbox" class="history" value="11">沁尿道感染</label>
   						</p>
   						<p>
   						<label><input type="checkbox" class="history" value="12">過敏性疾病</label>
   						<label><input type="checkbox" class="history" value="13">癲癇症</label>
   						<label><input type="checkbox" class="history" value="14">後天免疫能力缺乏症</label>
   						<label><input type="checkbox" class="history" value="15">哮喘 </label>
   						</p>
   						<p>
   						<label><input type="checkbox" class="history" value="16">身體上缺陷</label>
   						<label><input type="checkbox" class="history" value="17">類風濕性關節炎</label>
   						<label><input type="checkbox" class="history" value="18">系統性紅斑狼瘡</label>
   						<label><input type="checkbox" class="history" value="19">痛風</label>
   						</p>
   						<p>
   						<label><input type="checkbox" class="history" value="20">自閉症 </label>
						</p>
					</div>
				</div>
				<div class="inline-group">
					<label style="width:75px;text-align:right;">遺傳病 ：</label>
					<textarea rows="2" cols="55" name="genetic" >${medicalRecord.genetic }</textarea>
				</div>
				<div class="inline-group">
					<label style="width:75px;text-align:right;">其他 ：</label>
					<textarea rows="2" cols="55" name="geneticOther">${medicalRecord.geneticOther }</textarea>
				</div>
				
				<div class="inline-group">
					<label style="width:75px;text-align:right;">嗜好：</label>
					<div class="checkbox-group">
						<label><input type="checkbox" class="hobby" value="0" >嗜酒</label>
   						<label><input type="checkbox" class="hobby" value="1" >吸煙</label>
   						<label><input type="checkbox" class="hobby" value="2" >毒品</label>
   						<label><input type="checkbox" class="hobby" value="3" >藥物 </label>
					</div>
				</div>
				<div class="inline-group">
					<label style="width:75px;text-align:right;">其他：</label>
					<textarea rows="2" cols="55" name="hobbyNote" >${medicalRecord.hobbyNote }</textarea>
				</div>
		  	<div class="inline-group">
		  		<label>過敏病史：</label>
		  		<div>
		  			<div class="inline-group">
		  				<label>藥物過敏史注明：</label>
		  				<textarea rows="2" cols="55" name="medicineNote" >${medicalRecord.medicineNote }</textarea>
		  			</div>
		  			<div class="inline-group">
		  				<label>食物過敏史注明：</label>
		  				<textarea rows="2" cols="55" name="foodNote" >${medicalRecord.foodNote }</textarea>
		  			</div>
		  		</div>
		  	</div>
		  	</div>
		  	<div tabid="recordData" title="約束觀察記錄">
		  		<div style="padding:10px 0;">
		  			<p>注：1.每隔兩小時觀察學員生命體征及臨床情況，每次鬆綁15分鐘左右。</p>
		  			<p style="margin-top:8px;">&nbsp;&nbsp;&nbsp;&nbsp;2.正常用「ˇ」異常時用「×」</p>
		  		</div>
		  		<div id="medicalRecordViewDataGrid"></div>
		  	</div>
		  	
	  </div>
       
		<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
          </form>
        
        
        
        
    
    
    
</body>
</html>