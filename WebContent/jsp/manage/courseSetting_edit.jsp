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
	var courseSettingDetailDataGrid;
    //課程詳情
	function bindingCourseSettingDetailDataGrid(){
	
	var courseSettingDetailDataGridColumn = [
								{ display: 'detailID', name: 'detailID', hide:true },
			                    { display: '時間', name: 'time', type:"text",editor: { type: 'text' }},
			                    { display: '課程內容', name: 'content', type:"text",editor: { type: 'text'}},
			                    { display: '上課地點', name: 'place',type:"text", editor: { type: 'text'}},
			                    { display: '上課導師', name: 'leader',type:"text", editor: { type: 'text'}},
			                    { display: '上課助教', name: 'assistant',type:"text", editor: { type: 'text'}},
			                    { display: '備註', name: 'note',type:"text", editor: { type: 'text'}}
			                  ];
			
			
	var courseSettingDetailDataGridToolBar = [
          { text: '新增', click: addCourseSettingDetailData, icon: 'add' , id:"add" },
          { line: true },
          { text: '删除', click: deleteCourseSettingDetailData, icon: 'delete' , id:"delete" }];
	
	var url = "CourseSetting/getCourseSettingDetail.do?courseID="+$("#courseID").val();
	
	courseSettingDetailDataGrid = ligerGrid("courseSettingDetailDataGrid",null,courseSettingDetailDataGridColumn,url,courseSettingDetailDataGridToolBar,false,true);
	
	}
	function addCourseSettingDetailData(){
		courseSettingDetailDataGrid.addRow();
	}
	function deleteCourseSettingDetailData(){
		courseSettingDetailDataGrid.deleteSelectedRow();
	}
	
	
	function itemclick(item){
		switch (item.id){
			case "save":
				save();
			break;
			case "back":
				location.href="jsp/manage/courseSetting_list.jsp";
			break;
		}
		
	}
	
	function save(){
 		$("#courseSettingDetailAdds").val(getAddedRows(courseSettingDetailDataGrid));
 		$("#courseSettingDetailUpdates").val(getEditedRows(courseSettingDetailDataGrid));
 		$("#courseSettingDetailDeletes").val(getDeletedRows(courseSettingDetailDataGrid));
		$("#Button1").click();	
	}
    
	$(function(){
	/* 	if($("#gSID").val() != "" && $("#gSID").val() != 'null' && $("#gSID").val() != 'undefined'){
			setTabTitle(parent.$("#framecenter"),"課程設置編輯")
		}else{
			setTabTitle(parent.$("#framecenter"),"課程設置新增")
		} */
		
		$(".toptoolbar").ligerToolBar({ items: [
            { text: '保存', click: itemclick, icon: 'save' , id:"save" },
            { line: true },
            { text: '取消', click: itemclick, icon: 'back' , id:"back" }
          ]
          });
		
		
		ligerForm("form1");
		bindingCourseSettingDetailDataGrid();
	 $("#tab").ligerTab({onAfterSelectTabItem:function(targettabid){
			switch(targettabid){
				case "courseSettingGrid":
						showGridInTab(courseSettingDetailDataGrid);
					break;
				default:break;
			}
		}}); 
		
    })
        
    </script>
</head>
<body>
	<div class="toptoolbar"></div>
	<form name="form1" class="liger-form" method="post" action="CourseSetting/submit.do" id="form1" style="margin: 20px;">
	<input type="hidden" name="courseID" id="courseID" value="${courseSetting.courseID }">
	<input type="hidden" name="courseSettingDetailAdds" id="courseSettingDetailAdds">
	<input type="hidden" name="courseSettingDetailUpdates" id="courseSettingDetailUpdates">
	<input type="hidden" name="courseSettingDetailDeletes" id="courseSettingDetailDeletes">
	
	
	<div id="tab">
		  	<div tabid="courseSettingGrid" title="課程設置">
		  		<div style="padding:8px 0;">
		  			<div class="inline-group row max-width-group-300 label-width-100">
			  			<div class="col-md-4">
			  				<label>課程編號：</label>
			  				<input width="120px" value="${courseSetting.courseNO }" name="courseNO" type="text" ltype="text" />
			  			</div>
			  			<div class="col-md-4">
			  				<label>課程名稱：</label>
			  				<input width="120px" value="${courseSetting.courseName }" name="courseName" type="text" ltype="text" />
			  			</div>
			  			<div class="col-md-4">
			  				<label>學費：</label>
			  				<input width="120px" value="${courseSetting.pay }" name="pay" type="text" ltype="float" />
			  			</div>
			  		</div>
			  		<div class="inline-group row max-width-group-300 label-width-100">
			  			<div class="col-md-4">
			  				<label>開始日期：</label>
			  				<input width="120px" value="${courseSetting.beginDate_str }" name="beginDate" type="text" ltype="date" />
			  			</div>
			  			<div class="col-md-4">
			  				<label>結束日期：</label>
			  				<input width="120px" value="${courseSetting.endDate_str }" name="endDate" type="text" ltype="date" />
			  			</div>
			  			<div class="col-md-4">
			  				<label>名額限制：</label>
			  				<input width="120px" value="${courseSetting.qty }" name="qty" type="text" ltype="int" />
			  			</div>
			  		</div>
			  		<div class="inline-group row max-width-group-300 label-width-100">
			  			<div class="col-md-4">
			  				<label>课程設定日期：</label>
			  				<input width="120px" value="${courseSetting.settingDate_str }" name="settingDate" type="text" ltype="date" />
			  			</div>
			  			<div class="col-md-4">
			  				<label>課時：</label>
			  				<input width="120px" value="${courseSetting.classHour }" name="classHour" type="text" ltype="text" />
			  			</div>
			  			<div class="col-md-4">
			  				<label>課程簡介：</label>
			  				<input width="120px" value="${courseSetting.classNote }" name="classNote" type="text" ltype="text" />
			  			</div>
			  		</div>
			  		<div class="inline-group row max-width-group-300 label-width-100">
			  			<div class="col-md-4">
			  				<label>備註：</label>
			  				<input width="120px" value="${courseSetting.note }" name="note" type="text" ltype="text" />
			  			</div>
			  		</div>
		  		</div>
		  	
		  		<div class="panel panel-default">
					<div class="panel-heading"></div>
					<div class="panel-body">
						<div id="courseSettingDetailDataGrid"></div>
					</div>
				</div>
		  		
		  	</div>
		  	
	  </div>
       
		<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
          </form>
        
        
        
        
    
    
    
</body>
</html>