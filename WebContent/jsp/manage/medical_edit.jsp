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
				                    { display: '病史', name: 'age', width: 100 ,type:"text",editor: { type: 'text'}},
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
	
	<input type="hidden" name="history" id="history">
	<input type="hidden" name="hobby" id="hobby" >
	
	
	<div id="tab">
		  	<div title="學員個人健康資料" tabid="personageData">
				<table>
					<tbody>
			            <tr>
			                <td align="right" class="l-table-edit-td">姓名：</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.fullName }" name="fullName" type="text" class="fullName"/></td>
			                
			                <td align="right" class="l-table-edit-td">會員編號：</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.custNO }" name="custNO" type="text" id="custNO" /></td>
			                
			                <td align="right" class="l-table-edit-td">非會員編號：</td>
			                <td align="left" class="l-table-edit-td"><input width="120px" value="${customer.custNewNO }" name="custNewNO" type="text" id="custNewNO" /></td>
			              </tr>
					</tbody>
				</table>
				<div id="medicalRecordFamilyDataGrid"></div>
				<div class="inline-group">
					<label>個人病史</label>
					<div class="checkbox-group padding15">
						<p>
						<label><input type="checkbox" class="history" value="0" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('0') != -1 }">checked="checked"</c:if>>糖尿病 </label>
   						<label><input type="checkbox" class="history" value="1" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('1') != -1 }">checked="checked"</c:if>>高血壓</label>
   						<label><input type="checkbox" class="history" value="2" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('2') != -1 }">checked="checked"</c:if>>心臟病</label>
   						<label><input type="checkbox" class="history" value="3" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('3') != -1 }">checked="checked"</c:if>>腎病</label>
   						</p>
   						<p>
   						<label><input type="checkbox" class="history" value="4" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('0') != -1 }">checked="checked"</c:if>>肝炎 </label>
   						<label><input type="checkbox" class="history" value="5" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('1') != -1 }">checked="checked"</c:if>>肝炎帶菌</label>
   						<label><input type="checkbox" class="history" value="6" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('2') != -1 }">checked="checked"</c:if>>結核病</label>
   						<label><input type="checkbox" class="history" value="7" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('3') != -1 }">checked="checked"</c:if>>冠狀動脈病</label>
   						</p>
   						<p>
   						<label><input type="checkbox" class="history" value="8" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('0') != -1 }">checked="checked"</c:if>>精神病 </label>
   						<label><input type="checkbox" class="history" value="9" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('1') != -1 }">checked="checked"</c:if>>癌症內</label>
   						<label><input type="checkbox" class="history" value="10" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('2') != -1 }">checked="checked"</c:if>>分泌性疾病</label>
   						<label><input type="checkbox" class="history" value="11" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('3') != -1 }">checked="checked"</c:if>>沁尿道感染</label>
   						</p>
   						<p>
   						<label><input type="checkbox" class="history" value="12" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('0') != -1 }">checked="checked"</c:if>>過敏性疾病</label>
   						<label><input type="checkbox" class="history" value="13" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('1') != -1 }">checked="checked"</c:if>>癲癇症</label>
   						<label><input type="checkbox" class="history" value="14" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('2') != -1 }">checked="checked"</c:if>>後天免疫能力缺乏症</label>
   						<label><input type="checkbox" class="history" value="15" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('3') != -1 }">checked="checked"</c:if>>哮喘 </label>
   						</p>
   						<p>
   						<label><input type="checkbox" class="history" value="16" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('3') != -1 }">checked="checked"</c:if>>身體上缺陷</label>
   						<label><input type="checkbox" class="history" value="17" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('0') != -1 }">checked="checked"</c:if>>類風濕性關節炎</label>
   						<label><input type="checkbox" class="history" value="18" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('1') != -1 }">checked="checked"</c:if>>系統性紅斑狼瘡</label>
   						<label><input type="checkbox" class="history" value="19" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('2') != -1 }">checked="checked"</c:if>>痛風</label>
   						</p>
   						<p>
   						<label><input type="checkbox" class="history" value="20" <c:if test="${(treatmentAssessPojo.sentenceLen).indexOf('3') != -1 }">checked="checked"</c:if>>自閉症 </label>
						</p>
					</div>
				</div>
				<div class="inline-group">
					<label>遺傳病 ：</label>
					<textarea rows="2" cols="55" name="genetic" >${medicalRecord.genetic }</textarea>
				</div>
				<div class="inline-group">
					<label>其他 ：</label>
					<textarea rows="2" cols="55" name="geneticOther">${medicalRecord.geneticOther }</textarea>
				</div>
				
				<div class="inline-group">
					<label>嗜好：</label>
					<div class="checkbox-group">
						<label><input type="checkbox" class="hobby" value="0" >嗜酒</label>
   						<label><input type="checkbox" class="hobby" value="1" >吸煙</label>
   						<label><input type="checkbox" class="hobby" value="2" >毒品</label>
   						<label><input type="checkbox" class="hobby" value="3" >藥物 </label>
					</div>
				</div>
				<div class="inline-group">
					<label>其他：</label>
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
		  		<p>注：1.每隔兩小時觀察學員生命體征及臨床情況，每次鬆綁15分鐘左右。
					2.正常用「ˇ」異常時用「×」</p>
		  		<div id="medicalRecordViewDataGrid"></div>
		  	</div>
		  	
	  </div>
       
		<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
          </form>
        
        
        
        
    
    
    
</body>
</html>