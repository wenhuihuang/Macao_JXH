<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
<jsp:include page="/jsp/head.jsp"></jsp:include>
<script type="text/javascript" src="windows/toptoolbar.js"></script>
<script type="text/javascript" src="windows/keycode.js"></script>
<script type="text/javascript" src="windows/jsUnitCore.js"></script>

	<script type="text/javascript">
		var smsForm,treeMain,gridSelectCust,gridSelectedCust,gridSelectActivity;
		$(function(){
			
			
			renewData();
			
		});
		
		function renewData(){
			var width = document.body.clientWidth*30/100;
			$("#layout1").ligerLayout({height:350, leftWidth: 550, rightWidth:350});
			$("#layoutLeft").ligerLayout({leftWidth:163});
			
			$("#conditionName").ligerTextBox({ label:'請輸入會員編碼或名稱模糊查找', labelWidth:180,width:200, labelAlign:'left'});
			
			$("#addOtherPhone").ligerTextBox({ labelWidth:180,width:200, labelAlign:'left'});
			
			//1、设置 frmBaseEditActionName 用于保存数据时调用方法 (可以在toptoolbar.js中查到)
	    	frmBaseEditActionName = "";
			//2、 设置要保存的表的主键名 frmBaseEditIdName(可以在toptoolbar.js中查到)
	    	frmBaseEditIdName = "billMasterId";
			
	    	
	    	loadSMSForm();
	    	loadSelectActivityGrid();
	    	loadTree();
	    	loadSelectedGrid();
		}
		
		
	</script>
	
	<script type="text/javascript">

	var actCondition = "";
	function loadSelectActivityGrid(){
        var condition = { fields: [{ name: 'actName', label: '請輸入活動編碼或名稱模糊查詢',labelWidth:180, width:90,type:'text' }] };
		
		$("#actCondition").ligerComboBox({
            width: 250,
            slide: false,
            selectBoxWidth: 500,
            selectBoxHeight: 240, valueField: 'actId', textField: 'actName'
            , grid: getGridOptions(false),onSelected:function(value){
            	if(value!=""){
            		actCondition = value;
            		
            		gridSelectCust.set("url","SmsSendServlet/getCustomers.do?custActID="+value);
            	}
            },condition:condition
        });
		
	}
	
	function getGridOptions(checkbox){
		var options = {
            columns: [
            	
								 	{ display: '活動編碼', name: 'actNO', align: 'left'	
								 		, width: '100' 
								 		
								 		}
								 		,
	 							 
								 	{ display: '活動名稱', name: 'actName', align: 'left'	
								 		, width: '100' 
								 		
								 		}
								 		,
	 							 
								 	{ display: '報名開始時間', name: 'applyBDate_str', align: 'left'	
								 		, width: '150' 
								 		
								 		}
								 		,
	 							 
								 	{ display: '活動開始時間', name: 'actBDate_str', align: 'left'	
								 		, width: '150' 
								 		
								 		}
								 		
	 							 
                ], 
                width:'100%',
				height:'50%', 
				pagesizeParmName :"page.pageSize",
                pageParmName  :"page.currentPage",
                pageSize:30,
                dataAction : "server",
                url:"SmsSendServlet/loadActivitys.do",
                usePager:true
        };
        return options;
		
	}
	

		
	</script>
	
	
	
	<script type="text/javascript">

	function loadSMSForm(){
		
		var masterUserIdsDatas = <%=request.getAttribute("masterUserIds")%>;
		var formData ;
		
		$.ajax({
			type:"POST",
			url:"SmsSendServlet/getSingleMasterById.do",
			dataType:"json",
			async:true,
			data:{"editPrimaryKey":editPrimaryKey},
			success:function(msg){
				 formData = msg;
				$("#sms").val(formData.sms);
				smsForm.setData(formData);
				var smsValue = $("#sms").val();
				var fontTitle = $("#fontTitle").html();
				$("#fontTitle").html("字數統計：一共"+smsValue.length+"個字。"); 
			}
		});
		
		smsForm = $("#smsForm").ligerForm({
            inputWidth: 120, labelWidth: 80, space: 20,
            fields: [
				{ name: "billMasterID",  type: "hidden" },
				{ name: "state",  type: "hidden" },
				{ name: "corpID",  type: "hidden" },
				{ name: "billDate_str",  type: "hidden" },
				{ display: "發送人",  name: "makeUserID", newline: true, type: "combobox",width:130,textField: "userName", group: "短信資料編輯 ", groupicon: groupicon,editor:{
					readonly:true,
					selectBoxWidth: 330,
                    selectBoxHeight: 200,
                    textField: 'userName',
                    valueField : 'userId',
                    grid:{
                    	columns: [
            	                { display: '操作員編號', name: 'userCode', width: 150 },
            	                { display: '操作員名稱', name: 'userName', width: 150 }
            	            ],
                    	data : masterUserIdsDatas,
                    	isScroll: false,
                    	sortName: 'userCode',
                    	usePager:false
                    },render:function(data){
                    	for(var i = 0;i<masterUserIdsDatas.Rows.length;i++){
                    		if(masterUserIdsDatas.Rows[i].userId == data){
                    			return masterUserIdsDatas.Rows[i].userName;
                    		}
                    	}
                    }
				}}
				
			],
       	 	onAfterSetFields :function(){
           		
            }
            
	   	 });
		
	}

	</script>
  
  
  
  	<!-- 獲取樹形結構 -->
  	<script type="text/javascript">

		function loadTree(){
			
			treeMain= $("#treeMain").ligerTree({ 
        	nodeWidth: 200,
            url:"SmsSendServlet/getCustTypeCodesTree.do",
            checkbox: false,
            isExpand: 2, 
            slide: false ,
            idFieldName: 'id',
            parentIDFieldName :'pid',
            height:'90%',
            statusName :"_status",
            onSelect :function(note){
            	
            	var custActID = "";
    			if($("#actCondition").val()!=""){
    				custActID= actCondition;
    			}
            	
            	loadDetail(note.data.id,custActID);
            },
        	onSuccess : function(data){
        		//初始化  设置状态为未改变
        		for(var i = 0;i<data.length;i++){
        			data[i]._status = "unchange";
        		}
        		
        		if(data.length>0){
          		  var currentMasterID = data[0].id;
          		  
          		  
          		var custActID = "";
    			if($("#actCondition").val()!=""){
    				custActID= actCondition;
    			}
          		  
          		  loadDetail(currentMasterID,custActID);
          	  }
            }
        });
			
		}
		
		
		
		
			//读取从表
		function loadDetail(currentMasterID,custActID){
  	  
			gridSelectCust = $("#gridSelectCust").ligerGrid({
				checkbox: true,
                columns: [
						
								 	{ display: '會員編碼', name: 'custCode', align: 'left'	
								 		, width: '120' 
								 		
								 		}
								 		,
	 							 
								 	{ display: '會員名称', name: 'fullName', align: 'left'	
								 		, width: '120' 
								 		
								 		}
								 		,
	 							 
								 	{ display: '手提電話', name: 'mobileTelNO', align: 'left'	
								 		, width: '120' 
								 		
								 		}
								 		
	 							 
                ],  
                pagesizeParmName :"page.pageSize",
                pageParmName  :"page.currentPage",
                pageSize:30,
                dataAction : "server",
                url:"SmsSendServlet/getCustomers.do?custActID="+custActID,
                parms : {"custTypeCode":currentMasterID},
                usePager:true,
                width: '100%',height:'93%'
            });
	  
	}
	
  	</script>
  	
  	
  	
  	<script type="text/javascript">

  	function loadSelectedGrid(){
  		
  		
  		
  		gridSelectedCust = 	$("#gridSelectedCust").ligerGrid({
			checkbox: true,
            columns: [
					
							 	{ display: '會員編碼', name: 'custCode', align: 'left'	
							 		, width: '120' 
							 		,type:"text",editor:{type:"text"}
							 		},
							 
							 	{ display: '會員名称', name: 'fullName', align: 'left'	
							 		, width: '120' 
							 		,type:"text",editor:{type:"text"}
							 		},
							 
							 	{ display: '手提電話', name: 'mobileTelNO', align: 'left'	
							 		, width: '120' 
							 		,type:"text",editor:{type:"text"}
							 		},
							 
            ],  
            pagesizeParmName :"page.pageSize",
            pageParmName  :"page.currentPage",
            pageSize:30,
            dataAction : "server",
            usePager:false,
            enabledEdit: true,
            clickToEdit :true,
            width: '100%',height:'93%'
        });
  		
  	}
	
  	</script>
  	
  	
  	
  	
  	<script type="text/javascript">

		function f_add(){
			var rows = gridSelectCust.getSelectedRows();
			if(rows==null||rows.length<=0){
				 $.ligerDialog.error("請選擇需要添加的會員！");
				return;
			}
			
			var selectedRows = gridSelectedCust.getData();
			
			for(var i = 0;i<rows.length;i++){
				
				if(rows[i].mobileTelNO==""){
					continue;
				}
				
				var isExists = false;
				
				if(selectedRows!=null&&selectedRows.length>0){
					for(var j = 0;j<selectedRows.length;j++){
						
						if(rows[i].mobileTelNO==selectedRows[j].mobileTelNO){
							isExists = true;
							break;
						}
					}
				}
				
				if(isExists==false){
					var rowData = {"custId":rows[i].custId,"custCode":rows[i].custCode,"fullName":rows[i].fullName,"mobileTelNO":rows[i].mobileTelNO}
					gridSelectedCust.addRow(rowData);
				}
			}
			

		}
		
		function f_del(){
			var selectedRows = gridSelectedCust.getSelectedRows();
			if(selectedRows==null||selectedRows.length<=0){
				 $.ligerDialog.error("請選擇序號刪除的會員！");
				return;
			}
			
			for(var i = 0;i<selectedRows.length;i++){
				gridSelectedCust.remove(selectedRows[i]);
			}
			
			
		}
	
  	</script>
  	
	
	<!-- 保存操作 -->
  	<script type="text/javascript">

		function savefrmBaseEditBefore(){
			frmBaseEditSaveUrl="SmsSendServlet/addOrEditMasterRow.do"
			 var formData = smsForm.getData();
			 formData.billDate = tranStrToDate(formData.billDate_str);
			 formData.sms = $("#sms").val();
			 //alert(formData.billDate);
			 if(formData.makeUserID==null||formData.makeUserID==""){
				 $.ligerDialog.error("請選擇發送人！");
				 return false;
			 }
			 if(formData.sms==null||formData.sms==""){
				 $.ligerDialog.error("請填寫短信內容！");
				 return false;
			 }
			 
			frmBaseEditFormData = formData;
			return true;
		}
	function savefrmBaseEditAfter(){
		
		
			
		var selectedData = gridSelectedCust.getData();
		
		if(selectedData!=null&&selectedData.length>0){
			 $.ligerDialog.success("請勿關閉瀏覽器\n正在記錄需要發送短信的會員，會員過多可能需要一段時間才能完成，操作成功后系統會提示完成。");
		
			var saveData = [];
			for(var i = 0;i<selectedData.length;i++){
				saveData.push(selectedData[i]);
				if((i+1)%50==0||i+1>=selectedData.length){
					addCustomerToSMS(saveData);
					saveData = [];
				}
			}
			
			$.ligerDialog.success("記錄完畢！");
		}
		
		
		}
	
	function addCustomerToSMS(saveData){
		$.ajax({
			type:"POST",
			url:"SmsSendServlet/addCustomerToSMS.do",
			dataType:"json",
			data:{"editPrimaryKey":editPrimaryKey,"custArrays":JSON.stringify(saveData)},
			async:false,
			success:function(data){
			
				if(data == true || data == 'true'){
					$.ligerDialog.success('添加成功！');
				}else{
					$.ligerDialog.error("添加失敗！")
				}
				
			}, error : function(XMLHttpRequest, textStatus, errorThrown) {
				  
				$.ligerDialog.error("服务器获取数据失败："+errorThrown);
				//return false;		
			}
		});
	}
	
	
		
  	</script>
  
  <!-- String 转为日期 -->
	<script>
		function tranStrToDate(str){
			return str.replace(/-/g,'-')+ " 00:00:00:";/* yyyy-MM-dd HH:mm:ss */
			//return new  Date(Date.parse(str.replace(/-/g,   "/"))); 
		}
	</script>
	
	<script type="text/javascript">
		function searchCust(){
			var condition = $("#conditionName").val();
			var custActID = "";
			if($("#actCondition").val()!=""){
				custActID= actCondition;
			}
			
			gridSelectCust.set("url","SmsSendServlet/getCustomers.do?custCondition="+condition+"&custActID="+custActID);
			
		}
	</script>
	<script type="text/javascript">
		function addCustomerPhone(){
			gridSelectedCust.addEditRow();
		}
	</script>
	
	<script type="text/javascript">
		
		function smsChanging(){
			
			var smsValue = $("#sms").val();
			var fontTitle = $("#fontTitle").html();
			$("#fontTitle").html("字數統計：一共"+smsValue.length+"個字。");
		}
		
		function smsChanged(){
			var smsValue = $("#sms").val();
			var fontTitle = $("#fontTitle").html();
			$("#fontTitle").html("字數統計：一共"+smsValue.length+"個字。");
		}
	</script>
	
  </head>
  
  <body>
    <div id="SmsSend_toptoolbar"></div> 
    
	
	
    <div id="smsForm" style="padding:10px" >
	</div>
	<div style="margin-top:-10px; margin-bottom:10px;margin-left:9px;">
		
		<div  class="l-panel-search" style="border: 0px;">
			<div class="l-panel-search-item" >
	    		個案描述：
	    	</div>
	    	<div class="l-panel-search-item" style="margin-left: 20px;">
				<textarea cols="100" rows="2" class="l-textarea" id="sms" onkeydown="smsChanging()" onkeyup="smsChanged()" style="width:400px"  ></textarea>
			</div>
			<div class="l-panel-search-item" style="margin-left: 20px;">
				<font id="fontTitle">字數統計：一共0個字。</font>
			</div>
		</div>
		
		<div  class="l-panel-search" style="border: 0px;margin-top: 15px;">
			<input type="text" id="conditionName" value=""/>	
		</div>
		
		<div style="margin-top:-30px;margin-bottom: 35px;margin-left:400px;"><a class="l-button" style="width:80px;float:left; margin-left:6px;" onclick="searchCust()" data-inline="true">查找</a></div>
		
		<div  class="l-panel-search" style="border: 0px;">
			<div class="l-panel-search-item" >
	    		選擇一個活動：
	    	</div>
	    	<div class="l-panel-search-item" >
				<input type="text" id="actCondition" />
	    	</div>
	    </div>
	</div>
	
	<div style="margin-top: -40px;margin-bottom: 45px; margin-left: 650px;">
		<a class="l-button" style="width:80px;float:left; margin-left:6px;" data-inline="true" onclick="addCustomerPhone();">手動添加號碼</a>
	</div>
	
	

	
	<div style="height:200px;width: 99%;margin-left: auto;margin-right: auto; ">
		
		<div id="layout1" >
	         <div position="left" title="待選擇的會員">
	         	<div style="height: 100%;width: 100%">
		         	<div id="layoutLeft" >
		         		
		         		<div position="left" title="待選擇的會員">
			         		<div style="width:100%; height:95%; margin:0px; float:left; border:0px solid #ccc;  ">
							    <ul id="treeMain">
							    </ul>
						    </div> 
						    <!-- <div id="gridSelectActivity" style="margin:0; padding:0"></div> -->
		         		</div>
		         		
		         		<div position="center" title="待選擇的會員">
		         			<div style="width: 100%;height: 100%;overflow: auto;">
		         				<div id="gridSelectCust" style="margin:0; padding:0"></div>
		         			</div>
		         		</div>
		         		
		         	</div>
	         	</div>
	         </div>
	         
	         
	         <div position="center" title="操作">
	         	  <br><br><br><br><br><br>
	         	  <div class="liger-button l-button" style="margin:0 auto;" onclick="f_add()" data-width="90">添加</div>
	         	  <br>
	         	  <br>
	         	  <br>
	         	  <br>
	         	  <div class="liger-button l-button" style="margin:0 auto;" onclick="f_del()" data-width="90">删除</div> 
	         	  
	         </div>
	         
	         
	         
	         <div position="right" title="已選擇的會員">
	         	<div style="width: 100%;height: 100%;overflow: auto;">
					<div id="gridSelectedCust" style="margin:0; padding:0"></div>
				</div>
	         </div>
		</div>
		
		
	</div>
	
	
	
	
  </body>
</html>
