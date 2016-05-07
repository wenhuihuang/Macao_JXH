<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/jsp/head.jsp"></jsp:include>
<title>我的主頁</title>
<script type="text/javascript">
    	var changeGrid,payGrid,certificatesGrid,ageGrid,ageGrid2;
    
    	$(function(){
    		$("#navtabTopLeft").ligerTab();
    		$("#navtabTopRight").ligerTab();
    		$("#navtaBottomLeft").ligerTab();
    		$("#navtaBottomRight").ligerTab();
    		
    		loadChangeGrid();
    		loadPayGrid();
    		loadAgeGrid();
    		loadAgeGrid2();
    		loadCertificatesGrid();
    	})
    </script>



<script type="text/javascript">

	function loadChangeGrid(){
		changeGrid = $("#changeGrid").ligerGrid({
           columns: [
				 	{ display: '標識', name: 'isRead', align: 'left'	
				 		, width: '50' 
		 				,editor:{ type: 'select' ,data: [{ id:'1',text:'已讀' },{ id:'0',text:'未讀' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'1',text:'已讀' },{ id:'0',text:'未讀' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.isRead){ return tmpdata[i].text } }  }
				 		},
				 
				 	{ display: '狀態', name: 'status', align: 'left'	
				 		, width: '50' 
		 				,editor:{ type: 'select' ,data: [{ id:'3',text:'刪除' },{ id:'2',text:'修改' },{ id:'1',text:'新增' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'3',text:'刪除' },{ id:'2',text:'修改' },{ id:'1',text:'新增' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.status){ return tmpdata[i].text } }  }
				 		},
				 	{ display: '會員編碼', name: 'custCode', align: 'left'	
				 		, width: '120' 
				 		},
				 	{ display: '會員名稱', name: 'fullName', align: 'left'	
				 		, width: '120' 
				 		},
				 	{ display: '修改時間', name: 'billDate', align: 'left'	
				 		, width: '150' 
				 		},
  					{ display: '操作', isSort: false, width: 120, render: function (rowdata, rowindex, value)
  		                {
  							var h = "";
  							if(rowdata.status=="2"){
  								h += "<a href='javascript:checkLog(" + rowindex + ")'>查看修改記錄</a> ";
  							}
  							return h;
  						
  		                    /*var h = "";
  		                    if (!rowdata._editing)
  		                    {
  		                        h += "<a href='javascript:beginEdit(" + rowindex + ")'>修改</a> ";
  		                        h += "<a href='javascript:deleteRow(" + rowindex + ")'>删除</a> "; 
  		                    }
  		                    else
  		                    {
  		                        h += "<a href='javascript:endEdit(" + rowindex + ")'>提交</a> ";
  		                        h += "<a href='javascript:cancelEdit(" + rowindex + ")'>取消</a> "; 
  		                    }
  		                    return h;*/
  		                }
  		              }
                     ],  
                     checkbox:true,
                     fixedCellHeight:false,
                     pagesizeParmName :"page.pageSize",
                     pageParmName  :"page.currentPage",
                     dataAction: 'server',
                     enabledEdit: true,
                     clickToEdit:false,
                     statusName :"_status",
                     usePager:true,
                     width: '99%',
                     height:'48%',
                     async:false,
                     url:"Welcome/loadChangeCusts.do",
                     onSelectRow : function(data,rowid,rowdata){
                  	   
                  	 
                  	   
                     },
                     onSuccess :function(data){
                     },onDblClickRow : function (data, rowindex, rowobj)
 	                {
                     	
 	                	var currentRow = changeGrid.getRow(rowindex);
 	                	editByfrmMDIChild_DB(changeGrid,currentRow);
 	                	
 	                	
 	                } 
                 });
		
	}

    </script>



<!-- 缴费通知 -->
<script type="text/javascript">

function loadPayGrid(){
	payGrid = $("#payGrid").ligerGrid({
        columns: [
			 	{ display: '會員編碼', name: 'custCode', align: 'left'	
			 		, width: '120' 
			 		}
			 	,
			 	{ display: '會員名稱', name: 'fullName', align: 'left'	
			 		, width: '120' 
			 		}
			 	,
			 	{ display: '會員所屬機構', name: 'typeName', align: 'left'	
			 		, width: '120' 
			 		}
			 	,
			 	{ display: '會費', name: 'cost', align: 'left'	
			 		, width: '120' 
			 		}
			 	,
			 	{ display: '繳費週期(月)', name: 'cycle', align: 'left'	
			 		, width: '120' 
			 		}
			 	,
			 	{ display: '到期時間', name: 'validayStr', align: 'left'	
			 		, width: '120' 
			 		}
            ],  
            checkbox:true,
            fixedCellHeight:false,
            pagesizeParmName :"page.pageSize",
            pageParmName  :"page.currentPage",
            dataAction: 'server',
            enabledEdit: true,
            clickToEdit:false,
            statusName :"_status",
            usePager:true,
            width: '99%',
            height:'48%',
            async:true,
            url:"Welcome/loadPayCusts.do",
            onSelectRow : function(data,rowid,rowdata){
         	   
         	 
         	   
            },
            onSuccess :function(data){
            },onDblClickRow : function (data, rowindex, rowobj)
            {
            	
            	var currentRow = payGrid.getRow(rowindex);
            	
            	editByfrmMDIChild_DB(payGrid,currentRow);
            } 
        });
}

    </script>

<!-- 年龄 -->
<script type="text/javascript">

function loadAgeGrid(){
	
	ageGrid = $("#ageGrid").ligerGrid({
        columns: [
				
						 	{ display: '是臨時會員', name: 'isTemp', align: 'left'	
						 		, width: '75' 
						 		 
				 				,editor:{ type: 'select' ,data: [{ id:'1',text:'是' },{ id:'0',text:'否' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'1',text:'是' },{ id:'0',text:'否' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.isTemp){ return tmpdata[i].text } }  }
				 			
						 		}
						 		,
						 
						 	{ display: '會員編碼', name: 'custCode', align: 'left'	
						 		, width: '120' 
						 		
						 		}
						 		,
						 
						 	{ display: '會員名稱', name: 'fullName', align: 'left'	
						 		, width: '120' 
						 		
						 		}
						 		,
						 
						 	{ display: '生日', name: 'birthdayGreStr', align: 'left'	
						 		, width: '120' 
						 		
						 		}
						 		,
						 
						 	{ display: '相距天數', name: 'spaceDays', align: 'left'	
						 		, width: '70' 
						 		
						 		}
						 		,
						 
						 	{ display: '總積分', name: 'totalPoint', align: 'left'	
						 		, width: '120' 
						 		
						 		}
						 		,
						 
						 	{ display: '手提', name: 'mobileTelNo', align: 'left'	
						 		, width: '120' 
						 		
						 		}
						 		,
						 
						 	{ display: '聯繫電話', name: 'telNo', align: 'left'	
						 		, width: '120' 
						 		
						 		}
						 		,
						 
						 	{ display: 'E-mail', name: 'email', align: 'left'	
						 		, width: '120' 
						 		
						 		}
						 		,
						 
						 	{ display: '居住地址', name: 'linkAdr', align: 'left'	
						 		, width: '200' 
						 		
						 		}
						 		,
						 
						 	{ display: '備註', name: 'note', align: 'left'	
						 		, width: '200' 
						 		
						 		}
						 		,
						 
						 	{ display: '停用', name: 'isStop', align: 'left'	
						 		, width: '50' 
						 		 
				 				,editor:{ type: 'select' ,data: [{ id:'1',text:'是' },{ id:'0',text:'否' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'1',text:'是' },{ id:'0',text:'否' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.isStop){ return tmpdata[i].text } }  }
				 			
						 		}
						 		
						 
            ],  
            pagesizeParmName :"page.pageSize",
            pageParmName  :"page.currentPage",
            fixedCellHeight:false,
            dataAction: 'server',
            enabledEdit: true,
            clickToEdit:false,
            statusName :"_status",
            usePager:true,
            width: '99%',
            height:'98%',
            //data : custBDatas,
            async:true,
            url:"Welcome/loadbirthdayCust.do",
            onSelectRow : function(data,rowid,rowdata){
         	   
         	 
         	   
            },
            onSuccess :function(data){
            },onDblClickRow : function (data, rowindex, rowobj)
            {
            	var currentRow = ageGrid.getRow(rowindex);
            	
            	editByfrmMDIChild_DB(ageGrid,currentRow);
            } 
        });
}


function loadAgeGrid2(){
	ageGrid2 = $("#ageGrid2").ligerGrid({
        columns: [
			 	{ display: '是臨時會員', name: 'isTemp', align: 'left'	
			 		, width: '75' 
	 				,editor:{ type: 'select' ,data: [{ id:'1',text:'是' },{ id:'0',text:'否' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'1',text:'是' },{ id:'0',text:'否' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.isTemp){ return tmpdata[i].text } }  }
			 		}
			 		,
			 	{ display: '會員編碼', name: 'custCode', align: 'left'	
			 		, width: '120' 
			 		}
			 		,
			 	{ display: '會員名稱', name: 'fullName', align: 'left'	
			 		, width: '120' 
			 		}
			 		,
			 	{ display: '生日', name: 'birthdayGreStr', align: 'left'	
			 		, width: '120' 
			 		}
			 		,
			 	{ display: '年齡', name: 'spaceDays', align: 'left'	
			 		, width: '70' 
			 		}
			 		,
			 	{ display: '總積分', name: 'totalPoint', align: 'left'	
			 		, width: '120' 
			 		}
			 		,
			 	{ display: '手提', name: 'mobileTelNo', align: 'left'	
			 		, width: '120' 
			 		}
			 		,
			 	{ display: '聯繫電話', name: 'telNo', align: 'left'	
			 		, width: '120' 
			 		}
			 		,
			 	{ display: 'E-mail', name: 'email', align: 'left'	
			 		, width: '120' 
			 		}
			 		,
			 	{ display: '居住地址', name: 'linkAdr', align: 'left'	
			 		, width: '200' 
			 		}
			 		,
			 	{ display: '備註', name: 'note', align: 'left'	
			 		, width: '200' 
			 		}
			 		,
			 	{ display: '停用', name: 'isStop', align: 'left'	
			 		, width: '50' 
	 				,editor:{ type: 'select' ,data: [{ id:'1',text:'是' },{ id:'0',text:'否' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'1',text:'是' },{ id:'0',text:'否' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.isStop){ return tmpdata[i].text } }  }
			 		}
            ],  
            pagesizeParmName :"page.pageSize",
            pageParmName  :"page.currentPage",
            fixedCellHeight:false,
            dataAction: 'server',
            enabledEdit: true,
            clickToEdit:false,
            statusName :"_status",
            usePager:true,
            width: '99%',
            height:'41%',
            //data : custBDatas,
            async:true,
            url:"Welcome/loadOldAageCusts.do",
            onSelectRow : function(data,rowid,rowdata){
         	   
         	 
         	   
            },
            onSuccess :function(data){
            },onDblClickRow : function (data, rowindex, rowobj)
            {
            	var currentRow = ageGrid2.getRow(rowindex);
            	
            	editByfrmMDIChild_DB(ageGrid2,currentRow);
            } 
        });
}

    </script>

<!-- 证件有效期 -->
<script type="text/javascript">

function loadCertificatesGrid(){
	certificatesGrid = $("#certificatesGrid").ligerGrid({
        columns: [
			 	{ display: '是臨時會員', name: 'isTemp', align: 'left'	
			 		, width: '75' 
	 				,editor:{ type: 'select' ,data: [{ id:'1',text:'是' },{ id:'0',text:'否' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'1',text:'是' },{ id:'0',text:'否' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.isTemp){ return tmpdata[i].text } }  }
			 		}
			 		,
			 	{ display: '會員編碼', name: 'custCode', align: 'left'	
			 		, width: '120' 
			 		}
			 		,
			 	{ display: '會員名稱', name: 'fullName', align: 'left'	
			 		, width: '120' 
			 		}
			 		,
			 	{ display: '證件有效期', name: 'assessCardTime', align: 'left'	
			 		, width: '120' 
			 		}
			 		,
			 	{ display: '手提', name: 'mobileTelNo', align: 'left'	
			 		, width: '120' 
			 		}
			 		,
			 	{ display: '聯繫電話', name: 'telNo', align: 'left'	
			 		, width: '120' 
			 		}
			 		,
			 	{ display: 'E-mail', name: 'email', align: 'left'	
			 		, width: '120' 
			 		}
			 		,
			 	{ display: '居住地址', name: 'linkAdr', align: 'left'	
			 		, width: '200' 
			 		}
			 		,
			 	{ display: '備註', name: 'note', align: 'left'	
			 		, width: '200' 
			 		}
			 		,
			 	{ display: '停用', name: 'isStop', align: 'left'	
			 		, width: '50' 
	 				,editor:{ type: 'select' ,data: [{ id:'1',text:'是' },{ id:'0',text:'否' }], valueColumnName: 'id' },render: function (item){  var tmpdata = [{ id:'1',text:'是' },{ id:'0',text:'否' }] ;  for(var i = 0;i<tmpdata.length;i++){ if(tmpdata[i].id==item.isStop){ return tmpdata[i].text } }  }
			 		}
            ],  
            pagesizeParmName :"page.pageSize",
            pageParmName  :"page.currentPage",
            dataAction: 'server',
            enabledEdit: true,
            clickToEdit:false,
            statusName :"_status",
            usePager:true,
            width: '99%',
            height:'98%',
            async:true,
            url:"Welcome/loadCertificates.do",
            onSelectRow : function(data,rowid,rowdata){
         	   
         	 
         	   
            },
            onSuccess :function(data){
            },onDblClickRow : function (data, rowindex, rowobj)
            {
            	var currentRow = certificatesGrid.getRow(rowindex);
            	
            	editByfrmMDIChild_DB(certificatesGrid,currentRow);
            } 
        });
}

    </script>



<script type="text/javascript">
    	function payCost(){
    		var rows = payGrid.getSelectedRows();
    		
    		if(rows==null||rows.length<=0){
    			alert("請選擇需要繳費的會員！");
    			return;
    		}
    		
    		for(var i = 0;i<rows.length;i++){
    			rows[i].validay = null; 
    		}
    		
    		
    		$.ajax({
    			type:"POST",
    			url :"WelcomeActionpayCost",
    			data:{"payCostRows":JSON.stringify(rows)},
    			dataType:"json",
    			success :function(data){
    				alert(data.title);
    				payGrid.reload();
    			}
    		});
    	}
    </script>


<script type="text/javascript">
		function searchPayCust(){
			var conditionName = $("#conditionName").val();
			payGrid.set("url","WelcomeActionloadPayCusts?condition="+conditionName) ;
			//WelcomeActionloadPayCusts
		}    
    </script>

<script type="text/javascript">
    	function searchChanged(){
    		var conditionName = $("#conditionNameChanged").val();
    		changeGrid.set("url","WelcomeActionloadChangeCusts?condition="+conditionName) ;
    	}
    </script>



<!-- 双击修改资料 -->
<script type="text/javascript">
	    function editByfrmMDIChild_DB(grid, row){
			
			if(row==null){
				alert("请选择一行记录");
				return;
			}
			
			var editPrimaryKey = row.custId;
			var editForeignKey = row.typeCode;
			
			if(grid==changeGrid&&row.status=="3"){
				alert("該會員資料已經被刪除！");
				return;
			}
			
			
			
			
			
			
			$.ligerDialog.open({ url: '<%="CustomerActionshowSingle?editPrimaryKey="%>'+editPrimaryKey, 
					data : { editPrimaryKey : editPrimaryKey , editForeignKey : editForeignKey},
					height: '850', width: '1024', buttons: [
			    { text: '返回', onclick: function (item, dialog) {dialog.close();grid.reload(); },cls:'l-dialog-btn-highlight' }
			 ], isResize: true
			});
		}
    </script>


<script type="text/javascript">
    	function setLogRead(){
    		var rows = changeGrid.getSelectedRows();
    		if(rows==null||rows.length<=0){
    			alert("請選擇需要標記的會員！");
    			return;
    		}
    		
    		
    		$.ajax({
    			type:"POST",
    			url:"WelcomeActionreadRows",
    			dataType:"json",
    			data:{"readRows":JSON.stringify(rows)},
    			success:function(data){
    				alert(data.title);
    				changeGrid.reload();
    			}
    		});
    		
    		
    		
    	}
    </script>

<script type="text/javascript">
    	function checkLog(rowid){
    		var row = changeGrid.getRow(rowid);
    		
			$.ligerDialog.open({ title: '修改記錄', name:'winselector',width: 700, height: 300, url: 'welcome_CustLogs.jsp',
				data : { custId : row.custId , billDate : row.billDate},
				buttons: [
				{ text: '确定', onclick: f_selectContactOK }
				]
			});
    		
    	}
    	
    	function f_selectContactOK(item, dialog){
    		dialog.close();
    	}
    </script>
</head>
<body>
	<div style="height: 50%">
		<div style="float: left; height: 95%; width: 48%; margin: 10px;">
			<div id="navtabTopLeft" style="border: 0px solid #A3C0E8;">

				<div tabid="changehint" title="資料變更提醒" selected="true">

					<div id="searchBar" class="l-panel-search"
						style="border: 0px; overflow: auto;">
						<div class="l-panel-search-item">請輸入會員編碼或名稱模糊查找：</div>
						<div class="l-panel-search-item">
							<input type="text" id="conditionNameChanged" value="" />
						</div>
						<div class="l-panel-search-item">
							<a class="l-button"
								style="width: 60px; float: left; margin-left: 6px;"
								onclick="searchChanged()">查詢</a>
						</div>
						<div class="l-panel-search-item">
							<a class="l-button"
								style="width: 60px; float: left; margin-left: 6px;"
								onclick="setLogRead()">標記已讀</a>
						</div>
					</div>

					<div id="changeGrid" style="margin: 0; padding: 0;"></div>
				</div>

			</div>
		</div>
		<div style="float: left; height: 95%; width: 48%; margin: 10px;">
			<div id="navtabTopRight" style="border: 0px solid #A3C0E8;">



				<div tabid="payhint" title="繳費通知" selected="true">
					<div id="searchBar" class="l-panel-search"
						style="border: 0px; overflow: auto;">
						<div class="l-panel-search-item">請輸入會員編碼或名稱模糊查找：</div>
						<div class="l-panel-search-item">
							<input type="text" id="conditionName" value="" />
						</div>
						<div class="l-panel-search-item">
							<a class="l-button"
								style="width: 60px; float: left; margin-left: 6px;"
								onclick="searchPayCust()">查詢</a>
						</div>
						<div class="l-panel-search-item">
							<a class="l-button"
								style="width: 60px; float: left; margin-left: 6px;"
								onclick="payCost()">繳費</a>
						</div>
					</div>

					<div id="payGrid" style="margin: 0; padding: 0;"></div>
				</div>
			</div>
		</div>
	</div>
	<div style="height: 50%">
		<div style="float: left; height: 95%; width: 48%; margin: 10px;">
			<div id="navtaBottomLeft" style="border: 0px solid #A3C0E8;">
				<div tabid="agehint" title="未來7天生日的會員" selected="true">
					<div id="ageGrid" style="margin: 0; padding: 0;"></div>
				</div>
				<div tabid="agehint2" title="年齡超過60歲的會員">
					<div id="ageGrid2"></div>
				</div>
			</div>
		</div>
		<div style="float: left; height: 95%; width: 48%; margin: 10px;">
			<div id="navtaBottomRight" style="border: 0px solid #A3C0E8;">
				<div tabid="certificateshint" title="證照期限提醒(近7天到期)" selected="true">
					<div id="certificatesGrid" style="margin: 0; padding: 0;"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
