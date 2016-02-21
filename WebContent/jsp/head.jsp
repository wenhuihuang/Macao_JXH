<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
<link href="lib/ligerUI/skins/Gray2014/css/all.css" rel="stylesheet" type="text/css" />

<%-- <c:if test="${JSPTYPE == 'form' }">
	<link href="lib/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css" />
</c:if> --%>


<link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" id="mylink"/> 
<link rel="stylesheet" type="text/css"  href="css/common.css"/>  
<script src="lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script> 
<script src="indexdata.js" type="text/javascript"></script>
<script src="lib/jquery.cookie.js"></script>
<script src="lib/json2.js"></script>


<script src="lib/ligerUI/js/core/base.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerAccordion.js"></script>
<script src="lib/ligerUI/js/plugins/ligerTab.js"></script>
<script src="lib/ligerUI/js/plugins/ligerDrag.js"></script>
<script src="lib/ligerUI/js/plugins/ligerEasyTab.js"></script>
<script src="lib/ligerUI/js/plugins/ligerCheckBoxList.js"></script>
<script src="lib/ligerUI/js/plugins/ligerFilter.js"></script>
<script src="lib/ligerUI/js/plugins/ligerGrid.js"></script>
<script src="lib/ligerUI/js/plugins/ligerLayout.js"></script>
<script src="lib/ligerUI/js/plugins/ligerListBox.js"></script>
<script src="lib/ligerUI/js/plugins/ligerMenu.js"></script>
<script src="lib/ligerUI/js/plugins/ligerMenuBar.js"></script>
<script src="lib/ligerUI/js/plugins/ligerMessageBox.js"></script>
<script src="lib/ligerUI/js/plugins/ligerPanel.js"></script>
<script src="lib/ligerUI/js/plugins/ligerPopupEdit.js"></script>
<script src="lib/ligerUI/js/plugins/ligerPortal.js"></script>
<script src="lib/ligerUI/js/plugins/ligerRadioList.js"></script>
<script src="lib/ligerUI/js/plugins/ligerResizable.js"></script>
<script src="lib/ligerUI/js/plugins/ligerResizable.js"></script>
<script src="lib/ligerUI/js/plugins/ligerTree.js"></script>
<script src="lib/ligerUI/js/plugins/ligerWindow.js"></script>
<script src="lib/ligerUI/js/plugins/ligerForm.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerToolBar.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerDateEditor.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerButton.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerRadio.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerSpinner.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script> 
<script src="lib/ligerUI/js/plugins/ligerTip.js" type="text/javascript"></script>
<script src="lib/jquery-validation/jquery.validate.min.js" type="text/javascript"></script> 
<script src="lib/jquery-validation/jquery.metadata.js" type="text/javascript"></script>
<script src="lib/jquery-validation/messages_cn.js" type="text/javascript"></script>
<script src="lib/dateTools.js" type="text/javascript"></script> 

<script src="js/common.js"></script>
<script src="js/ligerUiFn.js"></script>

<style>
body{ font-size:12px;}
.l-table-edit {}
.l-table-edit-td{ padding:4px;}
.l-button-submit,.l-button-test{width:80px; float:left; margin-left:10px; padding-bottom:2px;}
.l-verify-tip{ left:230px; top:120px;}
table{width: 100%}
td {width: auto;}
</style>
<script type="text/javascript">
	
	
	
	/*
	* 根据ID绑定form
	*
	*/
	function ligerForm(formId,submitfunc){
		
		var formResult = validateForm(formId,submitfunc);
		
		var inputObj =  $(".l-text").find("input");
		for(var i = 0; i<inputObj.length;i++){
			var inputWidth=parseInt($(inputObj[i]).attr("width"));
			$(inputObj[i]).parents(".l-text").css("width",inputWidth+10+"px");
			$(inputObj[i]).css("width",inputWidth+"px");
		}
		
		
		var selectObj =  $("#"+formId).find("select");
		for(var j = 0; j<selectObj.length;j++){
			var inputWidth=parseInt($(selectObj[j]).attr("width"));
			var selectId = $(selectObj[j]).attr("id");
			
			$("#"+selectId+"_txt").parents(".l-text").css("width",inputWidth+10+"px");
			$("#"+selectId+"_txt").css("width",inputWidth+"px");
			$("#"+selectId+"_txt").attr("name",selectId+"_txt");
		}
		
		
		return formResult;
	}
	
	
	function validateForm(formId,submitfunc){
		
		$.validator.addMethod(
                "notnull",
                function (value, element, regexp)
                {
                    if (!value) return true;
                    return !$(element).hasClass("l-text-field-null");
                },
                "不能为空"
        );

        $.metadata.setType("attr", "validate");
        var v = $("#"+formId).validate({
            //调试状态，不会提交数据的
            debug: false,
            errorPlacement: function (lable, element)
            {

                if (element.hasClass("l-textarea"))
                {
                    element.addClass("l-textarea-invalid");
                }
                else if (element.hasClass("l-text-field"))
                {
                    element.parent().addClass("l-text-invalid");
                }
                $(element).removeAttr("title").ligerHideTip();
                $(element).attr("title", lable.html()).ligerTip();
            },
            success: function (lable)
            {
                var element = $("#" + lable.attr("for"));
                if (element.hasClass("l-textarea"))
                {
                    element.removeClass("l-textarea-invalid");
                }
                else if (element.hasClass("l-text-field"))
                {
                    element.parent().removeClass("l-text-invalid");
                }
                $(element).removeAttr("title").ligerHideTip();
            },
            submitHandler: function ()
            {
            	var inputObj =  $(".l-text").find("input");
        		for(var i = 0; i<inputObj.length;i++){
        			if($(inputObj[i]).attr("ltype")=="date"){
        				if($(inputObj[i]).val()!=null&&$(inputObj[i]).val()!=""){        					
        					$(inputObj[i]).val($(inputObj[i]).val()+" 00:00:00");
        				}
        			}
        		}
        	 	if(submitfunc==null||submitfunc==""||submitfunc==undefined){
        			for(var i = 0;i < $("form").length;i++){
                 		 if($("form").eq(i).attr("id")==formId){
                 			$("form")[i].attr("onsubmit","return true");
                 			break;
                 		} 
                 	}	
        		}else{
        			eval(submitfunc+"()");
        			return false;	
        		}  
            	debugger
            }
        });
        return $("#"+formId).ligerForm();
	}
	
	
</script>






<script type="text/javascript">
	/*
	*加载Grid
	*
	*gridId需要绑定的Grid 的ID
	*gridHeight grid null 默认高度 不设置默认为自动高度
	* columns 列名
	* url 
	* toolbar工具条
	* usePager是否使用分页
	* isTabCover 因为ligerui有bug 放在第二个tab页的grid不能显示出来， 用isTabCover判断做相应处理
	*/
	
	function ligerGrid(gridId,gridHeight,columns,url,toolbar,usePager,isTabCover){
		usePager = usePager==null||""==usePager?false:usePager;
		isTabCover = isTabCover==null||""==isTabCover?false:isTabCover;
		
		
		if(gridHeight==null||""==gridHeight){
			return $("#"+gridId).ligerGrid({
	            columns: columns , url:url , usePager:usePager,dataAction:"server",  pageSize:30 ,rownumbers:true, isTabCover:isTabCover
	            ,enabledEdit :true,isScroll: false
	            ,toolbar:{ items: toolbar }, 
	            onSuccess:function(data,grid){
	            	
                	for(var i = 0;i<data.Rows.length;i++){
                		var currentRow = data.Rows[i];
                		for(var item in currentRow){
                			
                			if(typeof(currentRow[item])=="object"){	
                				currentRow[item] = json2TimeStamp(currentRow[item]);
                			}
                			
                		}
                	}
                }
	        });
		}else{
			return $("#"+gridId).ligerGrid({
	            height:gridHeight,
	            columns: columns , url:url , usePager:usePager,dataAction:"server",  pageSize:30 ,rownumbers:true, isTabCover:isTabCover
	            ,enabledEdit :true
	            ,toolbar:{ items: toolbar }, 
                onSuccess:function(data,grid){
                	
                	for(var i = 0;i<data.Rows.length;i++){
                		var currentRow = data.Rows[i];
                		for(var item in currentRow){
                			if(typeof(currentRow[item])=="object"){
                				currentRow[item] = json2TimeStamp(currentRow[item]);
                			}
                			
                		}
                	}
                }
	        });
		}
	
	}
	
	/*
	*获取一行数据
	*/
	function getSelectedRow(grid){
		var rows = grid.getSelectedRows();
    	if(rows==null||rows==""){
    		alert("请选择一条记录！");
    		return null;
    	}
    	
    	if(rows.length>1){
    		alert("只能选择一条记录！");
    		return null;
    	}
    	
    	return rows[0];
	}
	
	
	/*
	*获取一行单元格的值
	*/
	function getRowCell(grid,rowId){
		var rows = grid.getSelectedRows();
    	if(rows==null||rows==""){
    		alert("请选择一条记录！");
    		return "";
    	}
    	
    	if(rows.length>1){
    		alert("只能选择一条记录！");
    		return "";
    	}
    	
    	alert(rows[0][rowId])
    	return rows[0][rowId];
	}
	
	
	/*
	*获取表格下拉选择的数据
	*
	*/
	function getGridSelectedData(selectData){
        if(selectData!=null&&selectData != undefined){
        	return selectData.text;
        }else{
        	return "";
        }
	}
	
	/*
	*获取增加的列的json串
	*
	*/
	function getAddedRows(grid){
		grid.endEdit();
		
		var addDatas = grid.getAdded();
		return getJsonByDataRow(addDatas);
	}
	
	/*
	*获取更新的Json字符串
	*/
	function getEditedRows(grid){
		grid.endEdit();
		
		var updateDatas = grid.getUpdated();
		return getJsonByDataRow(updateDatas);
	}
	
	/*
	* 获取删除的字符串
	*
	*/
	function getDeletedRows(grid){
		grid.endEdit();
		
		var deleteDatas = grid.getDeleted();
		return getJsonByDataRow(deleteDatas);
	}
	
	function getJsonByDataRow(datas){
		if(datas==null||""==datas||datas== undefined||datas== 'undefined' ){
			return "";
		}else{
			
			for(var i = 0;i<datas.length;i++){
				var data = datas[i];
				for(var item in data){
					if(typeof(data[item])=="object"){
		 				data[item] = tranDateToStr(data[item]);
					}
				}		
			}
			
			
			return JSON.stringify(datas);
		}
	}
	//設置性別
	function setSex(v){//v =1 , 2
			var i =0;
	    	$("#sex input:radio").each(function(){
	    		i++
	   		if($(this).attr("value") == v){
	   		 	var sex = $("#sex"+v).ligerRadio();
	   		sex.setValue(true);
	   		}else{
		   		var sex = $("#sex"+i).ligerRadio();
	   		sex.setValue(false);
	   		}
	   	}) 
	}
	
</script>


<script>
	function getDialog(){
		return frameElement.dialog; 
	}
</script>



<script type="text/javascript">
	function getDialogFullHeight(){
		return document.body.scrollHeight - 50;
	}
	
	function getDialogFullWidth(){
		return document.body.scrollWidth - 100;
	}
	
	
	/*
	* url 跳转的路径
	* title 标题
	* closeFunction 关闭时需要调用的函数名
	* width 窗口宽度
	* height 窗口高度
	*/
	function openDialog(url,title,closeFunction,width,height){
		
		width = width==null||""==width?getDialogFullWidth():width;
		height = height==null||""==height?getDialogFullHeight():height;
		
		return $.ligerDialog.open({ url: url,
			title:title,
			height:height, width: width, buttons: [
		{ text: '返回', onclick: function (item, dialog) {dialog.close();},cls:'l-dialog-btn-highlight' }
		 ], isResize: true,onClosed:function(){
			 eval(closeFunction+"()");
		 }
		});
	}
	
</script>


<script>
	/*
	*	Tab相关
	* 由于自身bug，放在tab中的grid 不显示行的。。。
	* 因为只是第一次遮挡，所以只需删除第一次就得了
	*/
	
	function showGridInTab(grid){
		if(grid.get("isTabCover")){
			var rows = grid.getSelectedRows();
			if(rows!=null&&rows.length>0){
				//清除选择的行
				for(var i = 0;i<rows.length;i++){
					grid.unselect(rows[i]);
				}
				
				grid.deleteSelectedRow();
			}
			
		
			grid.deleteSelectedRow();
			grid.set("isTabCover",false);
		}
		
	}
	/**设置tab标题
	*tabWrapID tab外id
	*title 标题
	*/
	function setTabTitle(tabWrapID,title){
		var frameNavTab = tabWrapID.ligerGetTabManager();
		var tabID = frameNavTab.getSelectedTabItemID();
		    frameNavTab.setHeader(tabID, title);
	}
</script>
