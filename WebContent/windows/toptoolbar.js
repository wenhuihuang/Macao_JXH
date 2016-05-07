var frmBaseEditActionName,frmBaseEditFormData ; //弹出窗口用到 必须在弹出窗口赋值 1、跳转的Action名称，  2需要保存的vo form 在 savefrmBaseEditBefore设置

var frmBaseEditSaveUrl = "addOrEditMasterRowByfrmBaseEdit"; //需要保存的函数名 默认为：addOrEditMasterRowByfrmBaseEdit
var editPrimaryKey,editForeignKey ;//需要修改的vo的主键  和 外键 
var frmBaseEditIdName;//弹出窗口的主键名称
var isCoverSave=false;//覆盖保存方法
var groupicon = "lib/ligerUI/skins/icons/communication.gif";//弹出框用到的图标

$(function ()
        {
	 	
	 	$("#frmMDIChild_DB_toptoolbar").ligerToolBar({ items: [
                /*{ text: '上移', click: itemclick,icon:"prev"},
                { text: '下移', click: itemclick,icon:"next"},*/
                { line:true },
                { text: '增加分類', click: function(item){
                		addNodeByfrmMDIChild_TreeView();
                },icon:"addClass"  },
                { text: '編輯分類', click: function(item){
                		editNodeByfrmMDIChild_TreeView();
                } },
                { text: '刪除分類', click: function(item){
                		deleteNodeByfrmMDIChild_TreeView();
                } },
                { line:true },
                { text: '增加', click: function (item)
                    {
                		addByfrmMDIChild_DB();
                    }, icon:'add'},
                { line:true },
                { text: '刪除', click: itemclick ,icon:"delete"},
                { line:true },
                { text: '增行', click: function(item){
                		addByfrmMDIChild_DB_Detail();
                	} ,icon:"add"},
                { text: '减行', click: itemclick ,icon:"delete"},
                { line:true },
                { text: '修改', click: function(){
            		editByfrmMDIChild_DB();
                } ,icon:"modify"},
                { text: '保存', click: itemclick ,icon:"save"}
                /*{ line:true },
                { text: '审核', click: itemclick ,icon:"lock"},
                { text: '取消', click: itemclick ,icon:"back"},
                { line:true },
                { text: '预览', click: itemclick ,icon:"comment"},
                { text: '打印', click: itemclick ,icon:"print"},
                { text: '导出', click: itemclick ,icon:"outbox"},
                { line:true },
                { text: '查找', click: itemclick ,icon:"search"},
                { text: '刷新', click: itemclick ,icon:"refresh"},
                { line:true },
                { text: '扩展', click: itemclick ,icon:"settings"}*/
            ]
            });
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	$("#frmMDIChild_DB_TreeView_toptoolbar").ligerToolBar({ items: [
			 /* { text: '上移', click: itemclick,icon:"prev"},
			  { text: '下移', click: itemclick,icon:"next"},
			  { line:true },*/
			  { text: '增加分類', click: function(item){
			  		addNodeByfrmMDIChild_TreeView();
			  },icon:"addClass" },
			  { text: '編輯分類', click: function(item){
			  		editNodeByfrmMDIChild_TreeView();
			  },icon:"editClass" },
			  { text: '刪除分類', click: function(item){
			  		deleteNodeByfrmMDIChild_TreeView();
			  } ,icon:"deleteClass"},
			  { line:true },
			  { text: '增加', click: function (item)
			  {
				addByfrmMDIChild_DB();
			  }, icon:'add'},
			  { line:true },
			  { text: '刪除', click: function(item){
				  deleteRowByfrmMDIChild_DB_TreeView();
			  } ,icon:"delete"},
			  { line:true },
			  { text: '修改', click: function(){
				editByfrmMDIChild_DB();
			  } ,icon:"modify"},
			  { text: '保存', click: itemclick ,icon:"save"}
			  /*{ line:true },
			  { text: '审核', click: itemclick ,icon:"lock"},
			  { text: '取消', click: itemclick ,icon:"back"},
			  { line:true },
			  { text: '预览', click: itemclick ,icon:"comment"},
			  { text: '打印', click: itemclick ,icon:"print"},
			  { text: '导出', click: itemclick ,icon:"outbox"},
			  { line:true },
			  { text: '查找', click: function(){
				  search();
			  } ,icon:"search"},
			  { text: '刷新', click: itemclick ,icon:"refresh"},
			  { line:true },
			  { text: '扩展', click: itemclick ,icon:"settings"}*/
			  ]
			  });
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	/////////// 该段值在frmBaseEdit（弹出框中起作用）
	 	var dialog = frameElement.dialog; //调用页面的dialog对象(ligerui对象)
    	
    	if(dialog!=null&&dialog.get("data")!=null){
    		editPrimaryKey=dialog.get("data").editPrimaryKey;
    		editForeignKey=dialog.get("data").editForeignKey;
    		
    	}
    	//////// 该段值在frmBaseEdit（弹出框中起作用）
    	
    	
	 	$("#frmBaseEdit_toptoolbar").ligerToolBar({ items: [
		  /*{ text: '上移', click: itemclick,icon:"prev"},
		  { text: '下移', click: itemclick,icon:"next"},*/
		  { text: '新增', click: function(){
			  editPrimaryKey = "";
			  renewData();
		  },icon:"add"},
		  { text: '保存', click: function(){
			  frmBaseEditSaveSingle();
		  },icon:"save"}
		  /*{ text: '扩展', click: itemclick,icon:"settings"},
		  { text: '审核', click: itemclick,icon:"lock"},
		  { text: '打印', click: itemclick,icon:"print"},*/
		  ]
		  });
	 	
	 	
	 	
	 	
	 	
	 	///////////////////////////////////////////
	 	///////////////////////////////////////////
	 	///////////////////////////////////////////
	 	/////////    从这里开始是自定义的             /////////////
	 	///////////////////////////////////////////
	 	///////////////////////////////////////////
	 	///////////////////////////////////////////
	 	
	 	$("#customer_TreeView_toptoolbar").ligerToolBar({ items: [
			  { text: '增加(F2)', click: function (item)
			  {
				addByfrmMDIChild_DB();
			  }, icon:'add'},
			  { text: '刪除(F4)', click: function (item)
				  {
				  deleteRowByfrmMDIChild_DB_TreeView();
				  }, icon:'delete'},
			  { line:true },
			  { text: '繳費(F6)', click: function (item)
				  {
					payCost();
				  }, icon:'attibutes'},
			  { line:true },
			  { text: '篩選(F7)', click: function (item)
				  {
					if($("#searchBar").css("display")=="none"){
						//$("#layout1").css("width","50%");
						$("#searchBar").show();
					}else{
						//$("#layout1").css("width","100%");
						$("#searchBar").hide();
					}
					
				  }, icon:'search'},
			  { text: '輸出(F8)', click: function (item)
				  {
					
			   }, icon:'communication'},
			   { text: '欄位(F9)', click: function (item)
				{
					setLocate();
			   }, icon:'bookpen'},
			   { text: '分析(Ctrl+F1)', click: function (item)
					  {
				   analysis();
			   }, icon:'config'},
			   { text: '製證(Ctrl+F2)', click: function (item)
			   {
				   makeCard();
						
			   }, icon:'memeber'},
			   { text: '條碼(Ctrl+F3)', click: function (item)
				{
				   makeBarcode();  
						
			   }, icon:'myaccount'},
			   { text: '導出Excel(Ctrl+F4)', click: function (item)
					{
						exportExcel();	
				   }, icon:'bookpen'},
			   { text: '寄信(Ctrl+F5)', click: function (item)
					 {
				   		sendLetter();	
				  }, icon:'outbox'}
			  ]
	 	});
	 	
	 	$("#customer_ShowSingle_toptoolbar").ligerToolBar({ items: [
				  { text: '新增(Shift+F2)', click: function(){
					  editPrimaryKey = "";
					  renewData();
				  },icon:"add"}, { text: '修改(Shift+F3)', click: function(){
					  editData(false);
				  },icon:"modify"},
				  { text: '保存(Shift+F4)', click: function(){
					  saveSingle();
				  },icon:"save"}
				  ]
		  });
	 	
	 	
	 	$("#customer_locate_toptoolbar").ligerToolBar({ items: [
				  { text: '上移（Shift+F2）', click: function(){
					  prev();
				  },icon:"prev"},
				  { text: '下移(Shift+F3)', click: function(){
					  next();
				  },icon:"next"},
				  { text: '保存(Shift+F4)', click: function(){
					  saveData();
				  },icon:"save"}]
	 	});
	 	
	 	
	 	
	 	
	 	
		 	$("#customer_PayCost_toptoolbar").ligerToolBar({ items: [
				  { text: '繳費(Shift+F2)', click: function (item)
				  {
					payCost();
				  }, icon:'attibutes'}
				  ]
		 	});
	 	
	 	
		 	$("#Activity_ShowList_toptoolbar").ligerToolBar({ items: [
		           { text: '增加(F2)', click: function (item)
		               {
		           		addByfrmMDIChild_DB();
		               }, icon:'add'},
		           { line:true },
		           { text: '修改(F3)', click: function(){
		       			editByfrmMDIChild_DB();
		           } ,icon:"modify"},
		           { text: '刪除(F4)', click: function(item){
		        	   deleteRow();
		           } ,icon:"delete"},
		           { line:true },
		           { text: '保存(F6)', click: function(){
		        	   saveDeletedCust();
		           } ,icon:"save"},
		           { text: '報名(F7)', click: function(){
		        	   signUp();
		           } ,icon:"archives"},
		           { text: '導出Excel(F8)', click: function (item)
						{
							exportExcel();	
					}, icon:'bookpen'},
					{ text: '下載活動名單(Ctrl+F2)', click: function (item)
						{
							downLoadActRegs();
					}, icon:'down'},
					{ text: '上傳活動名單(Ctrl+F3)', click: function (item)
						{
							upLoadActRegs();
					}, icon:'up'}
		       ]
	       });
	 	
	 	
	 	
		 	
		 	
		 	$("#Users_ShowList_toptoolbar").ligerToolBar({ items: [
  	           { text: '增加用戶', click: function (item)
  	               {
  	           		addByfrmMDIChild_DB();
  	               }, icon:'add'},
  	           { line:true },
  	           { text: '刪除用戶', click: function(item){
  	        	   deleteRow();
  	           } ,icon:"delete"},
  	           { line:true },
  	           { text: '查看屬性', click: function(){
  	       			editByfrmMDIChild_DB();
  	           } ,icon:"config"},
  	           { line:true },
  	           { text: '編輯權限', click: function(){
  	        	   editUserRights();
  	           } ,icon:"modify"},
  	           { text: '保存', click: function(){
  	        	   saveUserRights();
  	           } ,icon:"save"}
  	       ]
  	       });
		 	
		 	
		 	
		 	
		 	
		 	
		 	$("#SmsSend_ShowList_toptoolbar").ligerToolBar({ items: [
  	           { text: '增加(F2)', click: function (item)
  	               {
  	           		addByfrmMDIChild_DB();
  	               }, icon:'add'},
  	           { line:true },
  	           { text: '刪除選中的短信(F3)', click: function(item){
  	        	   deleteMasterRow();
  	           } ,icon:"delete"},
  	           { text: '刪除不需要發送的會員(F4)', click: function(item){
  	        	   deleteDetailRow();
  	           } ,icon:"delete"},
  	           { line:true },
  	           { text: '修改(F6)', click: function(){
  	       			editByfrmMDIChild_DB();
  	           } ,icon:"modify"},
  	           { line:true },
  	           { text: '確定發送(F7)', click: function(){
  	        	   sendSelectMessage();
  	           } ,icon:"lock"},
  	         { text: '統計(F8)', click: function(){
	        	   count();
	           } ,icon:"attibutes"}
  	       ]
  	       });
		 	
		 	
		 	
	 	
		 	$("#SmsSend_toptoolbar").ligerToolBar({ items: [
     		  { text: '再添加一條短信(Shift+F2)', click: function(){
     			  editPrimaryKey = "";
     			 renewData();
     		  },icon:"add"},
     		  { text: '保存当前編輯的短信(Shift+F3)', click: function(){
     			  
     			  frmBaseEditSaveSingle();
     			  
     			  
     			  
     		  },icon:"save"}
     		  ]
     		  });
	 	
	 	
	 	
	 	
	 	
	 	
		 	$("#fileList_ShowList_toptoolbar").ligerToolBar({ items: [
				  { text: '增加(F2)', click: function (item)
				  {
					  addByfrmMDIChild_DB();
				  }, icon:'add'},
				  { line:true },
				  { text: '刪除(F4)', click: function(item){
					  deleteRow();
				  } ,icon:"delete"},
				  { line:true },
				  { text: '修改(F3)', click: function(item){
					  editByfrmMDIChild_DB();
				  } ,icon:"modify"},
				  { text: '下載(F6)', click: function(item){
					  downLoadfile();
				  } ,icon:"down"},
				  /*{ line:true },
				  { text: '预览', click: itemclick ,icon:"comment"},
				  { text: '打印', click: itemclick ,icon:"print"},
				  { text: '导出', click: itemclick ,icon:"outbox"},
				  { line:true },
				  { text: '查找', click: itemclick ,icon:"search"},
				  { text: '刷新', click: itemclick ,icon:"refresh"},
				  { line:true },
				  { text: '扩展', click: itemclick ,icon:"settings"}*/
				  ]
			  });
	 	
	 	
		 	
		 	
		 	
		 	
		 	
		 	$("#Organization_toptoolbar").ligerToolBar({ items: [
     		  { text: '保存', click: function(){
     			  
     			  if(isCoverSave==false){
     				  
     				  if(savefrmBaseEditBefore()==false){
     					  
     					  return;
     				  }
     				  
     				  
     				  var _status = "update";
     				  if(editPrimaryKey==null||editPrimaryKey==""){
     					  _status = "add";
     				  }
     				  
     				 var url = frmBaseEditActionName+frmBaseEditSaveUrl+"?editPrimaryKey="+editPrimaryKey+"&&editForeignKey="+editForeignKey+"&&_status="+_status+"&&idName="+frmBaseEditIdName;
     				 
     				 
     				 
     				  $.ajax({
     					  type:"POST",
     					  url:url,
     					  dataType:"json",
     					  data:frmBaseEditFormData,
     					  async : false,
     					  success : function(msg){
     						  alert(msg.title);
     						  editPrimaryKey=msg.id ;
     						   
     					  },
     					  error : function(XMLHttpRequest, textStatus, errorThrown) {
     						  
     						  alert("服务器获取数据失败："+errorThrown);
     	 						
     	 					}
     				  });
     				  
     				  
     				  savefrmBaseEditAfter();
     				  
     				  
     			  }else{
     				  
     				  frmBaseEditSave();
     			  }
     			  
     			  
     			  
     		  },icon:"save"}
     		  ]
     		  });
		 	
		 	
		 	
		 	$("#Case_ShowList_toptoolbar").ligerToolBar({ items: [
		           { text: '增加(F2)', click: function (item)
		               {
		           		addByfrmMDIChild_DB();
		               }, icon:'add'},
		           { line:true },
		           { text: '刪除(F4)', click: function(item){
		        	   deleteRow();
		           } ,icon:"delete"},
		           { line:true },
		           { text: '修改(F3)', click: function(){
		       			editByfrmMDIChild_DB();
		           } ,icon:"modify"},
		           { text: '記錄(F6)', click: function(){
		        	   setRecord();
		           } ,icon:"comment"}
		       ]
	       });
		 	
		 	
		 	
		 	
		 	
		 	$("#custCase_Record_toptoolbar").ligerToolBar({ items: [
				{ text: '保存(Shift+F2)', click: function(){
					 saveData();
				},icon:"save"}
		 	 ]
 		  });
		 	
		 	
		 	
		 	
		 	$("#Organization_TreeView_toptoolbar").ligerToolBar({ items: [
			 /* { text: '上移', click: itemclick,icon:"prev"},
			  { text: '下移', click: itemclick,icon:"next"},
			  { line:true },*/
			  { text: '增加機構(F2)', click: function(item){
			  		addNodeByfrmMDIChild_TreeView();
			  },icon:"addClass" },
			  { text: '編輯機構(F3)', click: function(item){
			  		editNodeByfrmMDIChild_TreeView();
			  },icon:"editClass" },
			  { text: '刪除機構(F4)', click: function(item){
			  		deleteNodeByfrmMDIChild_TreeView();
			  } ,icon:"deleteClass"}/*,
			  { line:true },
			  { text: '增加', click: function (item)
			  {
				addByfrmMDIChild_DB();
			  }, icon:'add'},
			  { line:true },
			  { text: '刪除', click: function(item){
				  deleteRowByfrmMDIChild_DB_TreeView();
			  } ,icon:"delete"},
			  { line:true },
			  { text: '修改', click: function(){
				editByfrmMDIChild_DB();
			  } ,icon:"modify"},
			  { text: '保存', click: itemclick ,icon:"save"}*/
			  ]
			  });
		 	
		 	
	 	
	 	
	 	
	 	
        }

  );
 
 function itemclick(item)
 {
     alert(item.text);
 }
 
 
 
 
 
 
 
 
 document.onkeydown = function(e) {
	 
	    e = e || window.event;
	    
	    var k = KeyCode;
			
	    KeyCode.key_down(e);
	    /*if(e.preventDefault) {
	        e.preventDefault();
	    }*/
	    
	    var key = k.hot_key(k.translate_event(e));
	    var link =  location.href;
	    //alert(link);
	    //alert(key);
	    if(link.indexOf('CustomerActionshowList')>-1){
	    	if(key=="F2"){
	    		addByfrmMDIChild_DB();
	    	}else if(key=="F3"){
	    		
	    	}else if(key=="F4"){
	    		deleteRowByfrmMDIChild_DB_TreeView();
	    	}else if(key=="F5"){
	    		
	    	}else if(key=="F6"){
				payCost();
	    	}else if(key=="F7"){
	    		if($("#searchBar").css("display")=="none"){
					//$("#layout1").css("width","50%");
					$("#searchBar").show();
				}else{
					//$("#layout1").css("width","100%");
					$("#searchBar").hide();
				}
	    	}else if(key=="F8"){
	    		
	    	}else if(key=="F9"){
	    		setLocate();
	    	}else if(key=="Ctrl+F1"){
	    		analysis();
	    	}else if(key=="Ctrl+F2"){
	    		makeCard();
	    	}else if(key=="Ctrl+F3"){
	    		makeBarcode();
	    	}else if(key=="Ctrl+F4"){
	    		exportExcel();
	    	}else if(key=="Ctrl+F5"){
	    		sendLetter();
	    	}
	    }else if(link.indexOf("ActivityActionshowList")>-1){
	    	if(key=="F2"){
	    		addByfrmMDIChild_DB();
	    	}else if(key=="F3"){
       			editByfrmMDIChild_DB();
	    	}else if(key=="F4"){
	        	deleteRow();	
	    	}else if(key=="F6"){
	    		saveDeletedCust();
	    	}else if(key=="F7"){
	    		signUp();
	    	}else if(key=="F8"){
				exportExcel();
	    	}else if(key=="Ctrl+F2"){
				downLoadActRegs();
	    	}else if(key=="Ctrl+F3"){
				upLoadActRegs();
	    	}
	    }else if(link.indexOf("CustCaseActionshowList")>-1){
	    	if(key=="F2"){
           		addByfrmMDIChild_DB();	    		
	    	}else if(key=="F3"){
       			editByfrmMDIChild_DB();
	    	}else if(key=="F4"){
	    		deleteRow();
	    	}else if(key=="F6"){
	    		setRecord();
	    	}
	    }else if(link.indexOf("FileListActionshowList")>-1){
	    	if(key=="F2"){
	    		addByfrmMDIChild_DB();
	    	}else if(key=="F4"){
	    		deleteRow();
	    	}else if(key=="F3"){
	    		editByfrmMDIChild_DB();
	    	}else if(key=="F6"){
	    		downLoadfile();
	    	}
	    }else if(link.indexOf("SmsSendActionshowList")>-1){
	    	if(key=="F2"){
	    		addByfrmMDIChild_DB();
	    	}else if(key=="F3"){
	    		deleteMasterRow();
	    	}else if(key=="F4"){
	    		deleteDetailRow();
	    	}else if(key=="F6"){
	    		editByfrmMDIChild_DB();
	    	}else if(key=="F7"){
	    		sendSelectMessage();
	    	}else if(key=="F8"){
	    		count();
	    	}
	    }else if(link.indexOf("UsersActionshowList")>-1){
	    	if(key=="F2"){
	    		addByfrmMDIChild_DB();
	    	}else if(key=="F3"){
	    		editByfrmMDIChild_DB();
	    	}else if(key=="F4"){
	    		deleteRow();
	    	}else if(key=="F6"){
	    		editUserRights();
	    	}else if(key=="F7"){
	    		saveUserRights();
	    	}
	    }else if(link.indexOf("OrganizationActionshowList")>-1){
	    	if(key=="F2"){
		  		addNodeByfrmMDIChild_TreeView();
	    	}else if(key=="F3"){
		  		editNodeByfrmMDIChild_TreeView();
	    	}else if(key=="F4"){
		  		deleteNodeByfrmMDIChild_TreeView();
	    	}
	    }else if(link.indexOf("DictionaryActionshowList")>-1){
	    	if(key=="F2"){
				addRow();
	    	}else if(key=="F3"){
				deleteRow();
	    	}else if(key=="F4"){
	    		saveAllRow();
	    	}
	    }else if(link.indexOf("CustomerActionshowSingle")>-1){
	    	if(key=="Shift+F2"){
				  editPrimaryKey = "";
				  renewData();
	    	}else if(key=="Shift+F3"){
				  editData(false);
	    	}else if(key=="Shift+F4"){
	    		saveSingle();
	    	}
	    }else if(link.indexOf("CustomerActionpayCostByCusts")>-1){
	    	if(key=="Shift+F2"){
	    		payCost();
	    	}
	    }else if(link.indexOf("CustomerActionsetLocate")>-1){
	    	if(key=="Shift+F2"){
	    		prev();
	    	}else if(key=="Shift+F3"){
	    		next();
	    	}else if(key=="Shift+F4"){
	    		saveData();
	    	}
	    }else if(link.indexOf("ActivityActionshowSingle")>-1){
	    	if(key=="Shift+F2"){
	    		editPrimaryKey = "";
	    		renewData();
	    	}else if(key=="Shift+F3"){
	    		frmBaseEditSaveSingle();
	    	}
	    }else if(link.indexOf("SmsSendActionshowSingle")>-1){
	    	if(key=="Shift+F2"){
	    		editPrimaryKey = "";
	    		renewData();
	    	}else if(key=="Shift+F3"){
   			  frmBaseEditSaveSingle();
	    	}
	    }else if(link.indexOf("CustCaseActionshowRecord")>-1){
	    	if(key=="Shift+F2"){
	    		saveData();
	    	}
	    }else if(link.indexOf("CustCaseActionshowSingle")>-1){
	    	if(key=="Shift+F2"){
	    		editPrimaryKey = "";
	    		renewData();
	    	}else if(key=="Shift+F3"){
   			  frmBaseEditSaveSingle();
	    	}
	    }else if(link.indexOf("FileListActionshowSingle")>-1){
	    	if(key=="Shift+F2"){
	    		editPrimaryKey = "";
	    		renewData();
	    	}else if(key=="Shift+F3"){
   			  frmBaseEditSaveSingle();
	    	}
	    }else if(link.indexOf("UsersActionshowSingle")>-1){
	    	if(key=="Shift+F2"){
	    		editPrimaryKey = "";
	    		renewData();
	    	}else if(key=="Shift+F3"){
   			  frmBaseEditSaveSingle();
	    	}
	    }
	    
	    
	    return true;
	};

	
	
	/**
	 * 保存一条信息
	 */
	function frmBaseEditSaveSingle(){
		  if(isCoverSave==false){
			  
			  if(savefrmBaseEditBefore()==false){
				  
				  return;
			  }
			  
			  
			  var _status = "update";
			  if(editPrimaryKey==null||editPrimaryKey==""){
				  _status = "add";
			  }
			  
			 var url = frmBaseEditActionName+frmBaseEditSaveUrl;
			 frmBaseEditFormData._status=_status;
			  $.ajax({
				  type:"POST",
				  url:url,
				  /*dataType:"json",*/
				  data:frmBaseEditFormData,
				  async : false,
				  success : function(msg){
					  alert(msg);
					   
				  },
				  error : function(XMLHttpRequest, textStatus, errorThrown) {
					  
					  alert("服务器获取数据失败："+errorThrown);
 						
 					}
			  });
			  
			  
			  savefrmBaseEditAfter();
			  
			  
		  }else{
			  
			  frmBaseEditSave();
		  }
	}
	
	
	
	
	function saveSingle(){
		if(isCoverSave==false){
			  
			  if(savefrmBaseEditBefore()==false){
				  
				  return;
			  }
			  
			  
			  var _status = "update";
		  if(editPrimaryKey==null||editPrimaryKey==""){
		  _status = "add";
		  }
		  
		 var url = frmBaseEditActionName+frmBaseEditSaveUrl+"?editPrimaryKey="+editPrimaryKey+"&&editForeignKey="+editForeignKey+"&&_status="+_status+"&&idName="+frmBaseEditIdName;
		 
		 
		 
		  $.ajax({
			  type:"POST",
		  url:url,
		  dataType:"json",
		  data:frmBaseEditFormData,
		  async : false,
		  success : function(msg){
			  alert(msg.title);
			  editPrimaryKey=msg.id ;
			   
		  },
		  error : function(XMLHttpRequest, textStatus, errorThrown) {
			  
			  alert("服务器获取数据失败："+errorThrown);
							
						}
				  });
				  
				  
				  savefrmBaseEditAfter();
				  
				  
			  }else{
				  
				  frmBaseEditSave();
			  }	  
		
	}
 