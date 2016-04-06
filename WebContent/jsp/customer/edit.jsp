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
<jsp:include page="/jsp/head.jsp"></jsp:include>
<title>會員資料管理</title>
 <script type="text/javascript">
	
 	var retardedGrid,CSSAGrid,SpecialAllowanceGrid,ActivityGrid,VolunteerGrid,familyGrid;
 
	function itemclick(item)
	{
	    switch(item.id){
	    	case "save":save();break;
	    	case "back":back();break;
	    	default : break;
	    }
	}
	
	function save(){
		
		$("#retardedAdds").val(getAddedRows(retardedGrid));
		$("#retardedUpdates").val(getEditedRows(retardedGrid));
		$("#retardedDeletes").val(getDeletedRows(retardedGrid));
		$("#familyAdds").val(getAddedRows(familyGrid));
		$("#familyUpdates").val(getEditedRows(familyGrid));
		$("#familyDeletes").val(getDeletedRows(familyGrid));
		$("#CSSAAdds").val(getAddedRows(CSSAGrid));
		$("#CSSAUpdates").val(getEditedRows(CSSAGrid));
		$("#CSSADeletes").val(getDeletedRows(CSSAGrid));
		$("#SpecialAllowanceAdds").val(getAddedRows(SpecialAllowanceGrid));
		$("#SpecialAllowanceUpdates").val(getEditedRows(SpecialAllowanceGrid));
		$("#SpecialAllowanceDeletes").val(getDeletedRows(SpecialAllowanceGrid));
		$("#SocialWorkAdds").val(getAddedRows(VolunteerGrid));
		$("#SocialWorkUpdates").val(getEditedRows(VolunteerGrid));
		$("#SocialWorkDeletes").val(getDeletedRows(VolunteerGrid));
		$("#ActivityRecordNewAdds").val(getAddedRows(ActivityGrid));
		$("#ActivityRecordNewUpdates").val(getEditedRows(ActivityGrid));
		$("#ActivityRecordNewDeletes").val(getDeletedRows(ActivityGrid))
		$("#Button1").click();
		
	}
	function back(){
		location.href="jsp/customer/list.jsp";
	}
	
	$(function(){
		
		
		
		
		$("#toptoolbar").ligerToolBar({ items: [
          { text: '保存', click: itemclick, icon: 'save' , id:"save" },
          { line: true },
          { text: '返回', click: itemclick, icon: 'back' , id:"back" }
        ]
        });
		
		
		
		ligerForm("form1");
		
		
		
		
		
		bindingRetardedGrid();
		bindingFamilyGrid();
		
		bindingCSSAGrid();
		
		bindingSpecialAllowanceGrid();
		
		bindingActivityGrid();
		
		bindingVolunteerGrid();
		
		$("#tab").ligerTab({onAfterSelectTabItem:function(targettabid){
			switch(targettabid){
				case "familyGrid":showGridInTab(familyGrid);break;
				default:break;
			}
			
		}});
		$("#tab1").ligerTab({onAfterSelectTabItem:function(targettabid){
			switch(targettabid){
			case "SpecialAllowanceGrid":showGridInTab(SpecialAllowanceGrid);break;
			case "ActivityGrid":showGridInTab(ActivityGrid);break;
			case "VolunteerGrid":showGridInTab(VolunteerGrid);break;			
			default:break;
		}
		
	}}); 
		
	})
	
	function bindingRetardedGrid(){
		//大腦發育遲緩/自閉症/唐氏綜合症/腦癱/多動症/情緒行為障礙/語言障礙/身體障礙/其他障礙
		var retardedTypeData = [{ retardedType: 1, text: '大腦發育遲緩' }, { retardedType: 2, text: '自閉症'}, { retardedType: 3, text: '唐氏綜合症'}, { retardedType: 4, text: '腦癱'}, { retardedType: 5, text: '多動症'}, { retardedType: 6, text: '情緒行為障礙'}, { retardedType: 7, text: '語言障礙'}, { retardedType: 8, text: '身體障礙'}, { retardedType: 9, text: '其他障礙'}];
		//輕/中/重/機種
		var retardedDegreeData = [{retardedDegree:1,text:'輕'},{retardedDegree:2,text:'中'},{retardedDegree:3,text:'重'}];
		//有/無
		var hasRetardedReportData = [{hasRetardedReport:0,text:'無'},{hasRetardedReport:1,text:'有'}];
		//山頂醫院 /鏡湖醫院/教青局 /復康服務綜合評估中心 /其他
		var retardedReportSourceData = [{retardedReportSource:1,text:'山頂醫院 '},{retardedReportSource:2,text:'鏡湖醫院'},{retardedReportSource:3,text:'教青局'},{retardedReportSource:4,text:'復康服務綜合評估中心'},{retardedReportSource:5,text:'其他'}];
		
		var retardedGridColumn = [
									{ display: 'retardedID', name: 'retardedID', hide:true },
				                    { display: '智障類別', name: 'retardedType', align: 'left',  minWidth: 150 
				                    	,editor: { type: 'select', data: retardedTypeData, valueField: 'retardedType' },
				                        render: function (item)
				                        {
				                            return getGridSelectedData(retardedTypeData[parseInt(item.retardedType)-1]);
				                        }},
				                    { display: '程度', name: 'retardedDegree', minWidth: 100
				                        ,editor: { type: 'select', data: retardedDegreeData, valueField: 'retardedDegree' },
				                        render: function (item)
				                        {
				                        	return getGridSelectedData(retardedDegreeData[parseInt(item.retardedDegree)-1]);
				                        }},
				                    { display: '有否評估報告', name: 'hasRetardedReport', minWidth: 150 
				                        ,editor: { type: 'select', data: hasRetardedReportData, valueField: 'hasRetardedReport' },
				                        render: function (item)
				                        {
				                        	return getGridSelectedData(hasRetardedReportData[parseInt(item.hasRetardedReport)]);
				                        }},
				                    { display: '評估報告來源', name: 'retardedReportSource',minWidth:250
			                        	,editor: { type: 'select', data: retardedReportSourceData, valueField: 'retardedReportSource' },
				                        render: function (item)
				                        {
				                        	return getGridSelectedData(retardedReportSourceData[parseInt(item.retardedReportSource)-1]);
				                        }},
				                    { display: '評估日期', name: 'assessDate', minWidth: 150 , type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
				                    { display: '備註', name: 'note',minWidth:300, type:"text", editor: { type: 'text'}}
				                  ];
				
				
		var retardedGridToolBar = [
	          { text: '新增', click: addRetarded, icon: 'add' , id:"add" },
	          { line: true },
	          { text: '删除', click: deleteRetarded, icon: 'delete' , id:"delete" }];
		
		var url = "Customer/getRetarded.do?CUSTID="+$("#custID").val();
		
		retardedGrid = ligerGrid("retardedGrid",null,retardedGridColumn,url,retardedGridToolBar,false);
		
	}
	
	function addRetarded(){
		retardedGrid.addRow();
	}
	function deleteRetarded(){
		retardedGrid.deleteSelectedRow();
	}
	
	
	function bindingFamilyGrid(){
		
		var sexData = [{sex:1,text:'男'},{sex:2,text:'女'}];
		
		var familyGridColumn = [
			                     { display: '姓名', name: 'fullName', align: 'left', width: 100, minWidth: 60 },
			                     { display: '性别', name: 'sex', align: 'left', width: 100, minWidth: 60
			                    	 ,editor: { data: sexData, valueField: 'sex' },
				                        render: function (item)
				                        {
				                        	return getGridSelectedData(sexData[parseInt(item.sex)-1]);
				                        } },
			                     { display: '關係', name: 'relationship', align: 'left', width: 100, minWidth: 60 },
			                     { display: '手提', name: 'mobileTelNo', align: 'left', width: 100, minWidth: 60 },
			                     { display: '家庭電話', name: 'telNo', align: 'left', width: 100, minWidth: 120 }
			                     
			                    ];
		var familyGridToolBar = [
		             	          { text: '新增', click: addFamily, icon: 'add' , id:"add" },
		             	          { line: true },
		             	          { text: '修改', click: editFamily, icon: 'modify' , id:"edit" },
		             	          { line: true },
		             	          { text: '删除', click: deleteFamily, icon: 'delete' , id:"delete" }];
		var url = "Customer/getFamily.do?CUSTID="+$("#custID").val();
		familyGrid = ligerGrid("familyGrid",null,familyGridColumn,url,familyGridToolBar,false,true);
	}
	
	var addFamilyDlg = null;
	function addFamily(){
		addFamilyDlg = openDialog("Customer/addFamily.do","添加家庭成員资料","addFamilyByDlg");
	}
	function addFamilyByDlg(){
		if(addFamilyDlg.familyData!=null&&addFamilyDlg.familyData!=""){
			familyGrid.addRow(addFamilyDlg.familyData);
		}
	}
	
	
	var editFamilyDlg = null;
	function editFamily(){
		
		var row = getSelectedRow(familyGrid);
		
		if(row!=null){
			if(row.custID==null||""==row.custID){
				//如果当前行是新增并没有保存的行
				editFamilyDlg = openDialog("jsp/customer/edit_family.jsp?jsonData="+JSON.stringify(row),"编辑家庭成員资料","editFamilyByDlg");	
			}else{
				editFamilyDlg = openDialog("Customer/editFamily.do?CUSTID="+row.custID,"编辑家庭成員资料","editFamilyByDlg");
			}
			
		}
	}
	function editFamilyByDlg(){
		if(editFamilyDlg.familyData!=null&&editFamilyDlg.familyData!=""){
			familyGrid.updateRow(getSelectedRow(familyGrid), editFamilyDlg.familyData);
		}
	}
	function deleteFamily(){
		familyGrid.deleteSelectedRow();
	}
	
	
	
	
	function bindingCSSAGrid(){
		var CSSAGridColumn = [
			                     { display: '綜援編號', name: 'CSSANO', align: 'left', width: 250, minWidth: 60,editor:{type:'text'} },
			                     { display: '申請人姓名', name: 'userName', align: 'left', width: 120, minWidth: 60 ,editor:{type:'text'}},
			                     { display: '申請日期', name: 'billDate', align: 'left', width: 130, type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'}},
			                     { display: '備註', name: 'note', align: 'left', width: 400 ,editor:{type:'text'} }
			                    ];
		var CSSAGridToolBar = [
		             	          { text: '新增', click: addCSSA, icon: 'add' , id:"add" },
		             	          { line: true },
		             	          { text: '删除', click: deleteCSSA, icon: 'delete' , id:"delete" }];
		
		var url = "Customer/getCSSA.do?CUSTID="+$("#custID").val();
		
		CSSAGrid = ligerGrid("CSSAGrid",null,CSSAGridColumn,url,CSSAGridToolBar);
	}
	
	function addCSSA(){
		CSSAGrid.addRow();
	}
	function deleteCSSA(){
		CSSAGrid.deleteSelectedRow();
	}
	
	
	function bindingSpecialAllowanceGrid(){
		
		var SpecialAllowanceGridColumn = [
			                     { display: '特津編號', name: 'specialAllowanceNO', align: 'left', width: 250, minWidth: 60,editor:{type:'text'} },
			                     { display: '申請人姓名', name: 'userName', align: 'left', width: 120 ,editor:{type:'text'}},
			                     { display: '申請日期', name: 'billDate', align: 'left', width: 130, type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'} },
			                     { display: '備註', name: 'note', align: 'left', width: 400 ,editor:{type:'text'} }
			                    ];
		var SpecialAllowanceGridToolBar = [
		             	          { text: '新增', click: addSpecialAllowance, icon: 'add' , id:"add" },
		             	          { line: true },
		             	          { text: '删除', click: deleteSpecialAllowance, icon: 'delete' , id:"delete" }];
		
		var url = "Customer/getSpecialAllowance.do?CUSTID="+$("#custID").val();
		
		SpecialAllowanceGrid = ligerGrid("SpecialAllowanceGrid",null,SpecialAllowanceGridColumn,url,SpecialAllowanceGridToolBar,false,true);
	}
	function addSpecialAllowance(){
		SpecialAllowanceGrid.addRow();
	}
	function deleteSpecialAllowance(){
		SpecialAllowanceGrid.deleteSelectedRow();
	}
	
	
	//參與活動
	function bindingActivityGrid(){
		function getActName(checkbox) {
		    var options = {
		        columns: [
				{ display: '活動編號', name: 'actNO', minWidth: 120, width: 100 },
		        { display: '活動名稱', name: 'actName', minWidth: 120, width: 100 }
		        ], switchPageSizeApplyComboBox: false,
		        //pageSize: 10
		       /*  checkbox: checkbox, */
		       url:"Activity/list.do"
		      // usePager:false
		       
		    };
		    return options;
		}
      function actName_onSelected(e) { 
            if (!e.data || !e.data.length) return;

            var grid = liger.get("ActivityGrid");

            var selected = e.data[0]; 
            grid.updateRow(grid.lastEditRow, {
                actNO: selected.actNO,
                actID: selected.actID,
                actName: selected.actName
            });
        }
		
		//是/否
		var isLateData = [{isLate:0,text:'否'},{isLate:1,text:'是'}];
		
		var ActivityGridColumn = [
					{ display: 'actID', name: 'actID', hide:true },
                   {
                       name: 'actNO',align:'center', width:100, display: '活動編號', textField: 'actNO'
                       , editor:
                           {
                           	type: 'popup', valueField: 'actNO', textField: 'actNO', grid:  getActName(true), onSelected:actName_onSelected
                       	}
                   },
                   {
                       name: 'actName',align:'center', width:100, display: '活動名稱', textField: 'actName'
                       , editor:
                           {
                           	type: 'popup', valueField: 'actName', textField: 'actName', grid:  getActName(true), onSelected:actName_onSelected
                       	}
                   },
                   { display: '活動日期', name: 'actBDate', align: 'center', width: 100, minWidth: 60, type: 'date', format: 'yyyy-MM-dd', editor: { type: 'date'} },
                   { display: '是否遲到', name: 'isLate', align: 'center', width: 100, minWidth: 60
                  	 ,editor: {type: 'select', data: isLateData, valueField: 'isLate' },
	                        render: function (item)
	                        {
	                        	return getGridSelectedData(isLateData[parseInt(item.isLate)]);
	                        } },
                   { display: '參與人數', name: '', align: 'center', width: 100, minWidth: 120, editor:{type:'text'} },
                   { display: '備註', name: 'note', align: 'center', width: 100, minWidth: 120, editor:{type:'text'} }
                  ];
 		var ActivityGridToolBar = [
       	          { text: '新增', click: addActivity, icon: 'add' , id:"add" },
       	          { line: true },
       	          { text: '删除', click: deleteActivity, icon: 'delete' , id:"delete" }];
 			
 		var url = "Customer/getActivityRecordPojo.do?CUSTID="+$("#custID").val();
 		ActivityGrid = ligerGrid("ActivityGrid",null,ActivityGridColumn,url,ActivityGridToolBar,false,true);
	}
	function addActivity(){
		ActivityGrid.addRow();
	}
	function deleteActivity(){
		ActivityGrid.deleteSelectedRow();
	}
	
	//參與義工
	function bindingVolunteerGrid(){
		function getActName(checkbox) {
		    var options = {
		        columns: [
				{ display: '活動編號', name: 'actNO', minWidth: 120, width: 100 },
		        { display: '活動名稱', name: 'actName', minWidth: 120, width: 100 }
		        ], switchPageSizeApplyComboBox: false,
		        //pageSize: 10
		       /*  checkbox: checkbox, */
		       url:"Activity/list.do"
		      // usePager:false
		       
		    };
		    return options;
		}
      function actName_onSelected(e) { 
            if (!e.data || !e.data.length) return;

            var grid = liger.get("VolunteerGrid");

            var selected = e.data[0]; 
            console.log(selected)
            grid.updateRow(grid.lastEditRow, {
                actNO: selected.actNO,
                actID: selected.actID,
                actName: selected.actName
            });
        }
		
		var VolunteerGridColumn = [
					{ display: 'actID', name: 'actID', hide:true },
                    {
                        name: 'actNO',align:'center', width:100, display: '活動編號', textField: 'actNO'
                        , editor:
                            {
                            	type: 'popup', valueField: 'actNO', textField: 'actNO', grid:  getActName(true), onSelected:actName_onSelected
                        	}
                    },
                    {
                        name: 'actName',align:'center', width:100, display: '活動名稱', textField: 'actName'
                        , editor:
                            {
                            	type: 'popup', valueField: 'actName', textField: 'actName', grid:  getActName(true), onSelected:actName_onSelected
                        	}
                    },
                    { display: '備註', name: 'note', align: 'left', width: 100, minWidth: 120 , editor:{type:'text'}}
                   ];
  		var VolunteerGridToolBar = [
        	          { text: '新增', click: addVolunteer, icon: 'add' , id:"add" },
        	          { line: true },
        	          { text: '删除', click: deleteVolunteer, icon: 'delete' , id:"delete" }];
  		var url ="Customer/getVoluntary.do?custID="+$("#custID").val();
  		VolunteerGrid = ligerGrid("VolunteerGrid",null,VolunteerGridColumn,url,VolunteerGridToolBar);
	}
	function addVolunteer(){
		VolunteerGrid.addRow();
	}
	function deleteVolunteer(){
		VolunteerGrid.deleteSelectedRow();
	}
	
</script>
</head>
<body style="height: auto;overflow: scroll;">
	<div id="toptoolbar"></div> 
	
	
	 <form name="form1" method="post" action="Customer/submit.do" id="form1" style="margin: 20px;">
		<input type="hidden" id="custID" name="custID" value="${cust.custID }">
		<input type="hidden" id="custType2" name="custType2" value="${cust.custType2 }">
		<input type="hidden" id="retardedAdds" name="retardedAdds">
		<input type="hidden" id="retardedUpdates" name="retardedUpdates">
		<input type="hidden" id="retardedDeletes" name="retardedDeletes">
		<input type="hidden" id="familyAdds" name="familyAdds">
		<input type="hidden" id="familyUpdates" name="familyUpdates">
		<input type="hidden" id="familyDeletes" name="familyDeletes">
		<input type="hidden" id="CSSAAdds" name="CSSAAdds">
		<input type="hidden" id="CSSAUpdates" name="CSSAUpdates">
		<input type="hidden" id="CSSADeletes" name="CSSADeletes">
		<input type="hidden" id="SpecialAllowanceAdds" name="SpecialAllowanceAdds">
		<input type="hidden" id="SpecialAllowanceUpdates" name="SpecialAllowanceUpdates">
		<input type="hidden" id="SpecialAllowanceDeletes" name="SpecialAllowanceDeletes">
		<input type="hidden" id="SocialWorkAdds" name="SocialWorkAdds">
		<input type="hidden" id="SocialWorkUpdates" name="SocialWorkUpdates">
		<input type="hidden" id="SocialWorkDeletes" name="SocialWorkDeletes">
		<input type="hidden" id="ActivityRecordNewAdds" name="ActivityRecordNewAdds">
		<input type="hidden" id="ActivityRecordNewUpdates" name="ActivityRecordNewUpdates">
		<input type="hidden" id="ActivityRecordNewDeletes" name="ActivityRecordNewDeletes">
		
		
        <table cellpadding="0" cellspacing="0" class="l-table-edit" >
            <tr>
                <td align="right" class="l-table-edit-td">會員編碼：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${cust.custCode }" name="custCode" type="text" id="custCode" ltype="text" validate="{required:true,notnull:true}"/></td>
                
                <td align="right" class="l-table-edit-td">姓名：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${cust.fullName }" name="fullName" type="text" id="fullName" ltype="text" validate="{required:true,notnull:true}"/></td>
                
                <td align="right" class="l-table-edit-td">英文名：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${cust.fullNameEng }" name="fullNameEng" type="text" id="fullNameEng" ltype="text" /></td>
                
                <td align="right" class="l-table-edit-td">出生日期：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${cust.birthday_ChnStr }" name="birthday_Chn" type="text" id="birthday_Chn" ltype="date" validate="{required:true,notnull:true}"/></td>

                <td align="right" class="l-table-edit-td">性别：</td>
                <td align="left" class="l-table-edit-td">
					<input id="sex1" type="radio" name="sex" value="1" <c:if test="${cust.sex != 2 }">checked="checked"</c:if> /><label for="sex1">男</label> 
					<input id="sex2" type="radio" name="sex" value="2" <c:if test="${cust.sex == 2 }">checked="checked"</c:if> /><label for="sex2">女</label>
				</td>
            </tr>
           
          
             <tr>
             	<td align="right" class="l-table-edit-td">會員類別：</td>
                <td align="left" class="l-table-edit-td">
                	<select name="custType" id="custType" ltype="select" width="120px">
                		<option value="1" <c:if test="${cust.custType == '1' }">selected="selected"</c:if> >永久會員</option>
                		<option value="2" <c:if test="${cust.custType == '2' }">selected="selected"</c:if> >臨時會員</option>
                		<option value="0" <c:if test="${cust.custType != '1' and cust.custType != '2'  }">selected="selected"</c:if> >非會員</option>
                	</select>
                </td>
                
                <td align="right" class="l-table-edit-td">會員證狀態：</td>
                <td align="left" class="l-table-edit-td">
                	<select name="cardStatus" id="cardStatus" ltype="select" width="120px" >
                		<option value="1" <c:if test="${cust.cardStatus != '2' and cust.cardStatus != '0' }">selected="selected"</c:if> >正常</option>
                		<option value="2" <c:if test="${cust.cardStatus == '2' }">selected="selected"</c:if> >欠費</option>
                		<option value="0" <c:if test="${cust.cardStatus == '0' }">selected="selected"</c:if> >退會</option>
                	</select>
                </td>
                
                <td align="right" class="l-table-edit-td">入會日期：</td>
                <td align="left" class="l-table-edit-td"><input width="120px"  value="${cust.regDateStr }" name="regDate" type="text" id="regDate" ltype="date" validate="{required:true,notnull:true}"/></td>
                
                <td align="right" class="l-table-edit-td">會員有效期：</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${cust.validDateStr }" name="validDate" type="text" id="validDate" ltype="date" validate="{required:true,notnull:true}"/></td>
                
                <td align="right" class="l-table-edit-td">入會來源：</td>
                <td align="left" class="l-table-edit-td">
                	<select name="initiationSource" id="initiationSource" ltype="select" width="120px" >
                		<option value="1" <c:if test="${cust.initiationSource != '2' and cust.initiationSource != '3' }">selected="selected"</c:if> >個人報名</option>
                		<option value="2" <c:if test="${cust.initiationSource == '2' }">selected="selected"</c:if> >他人介紹</option>
                		<option value="3" <c:if test="${cust.initiationSource == '3' }">selected="selected"</c:if> >機構轉介</option>
                	</select>	
                </td>
                
                
             </tr>
            <tr>
                <td align="right" class="l-table-edit-td">證件類型:</td>
                <td align="left" class="l-table-edit-td">
                	<select name="cardType" id="cardType" ltype="select" width="120px" >
                		<option value="1" <c:if test="${cust.cardType != '2' and cust.cardType != '3' }">selected="selected"</c:if> >永久身份證 </option>
                		<option value="2" <c:if test="${cust.cardType == '2' }">selected="selected"</c:if> >非永久身份證 </option>
                		<option value="3" <c:if test="${cust.cardType == '3' }">selected="selected"</c:if> >其他</option>
                	</select>
                </td>
                
                <td align="right" class="l-table-edit-td">證件號碼:</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${cust.cardNo }"  name="cardNo" type="text" id="cardNo" ltype="text" /></td>
                
                <td align="right" class="l-table-edit-td">婚姻狀況:</td>
                <td align="left" class="l-table-edit-td">
                	<select name="isMarry" id="isMarry" ltype="select" width="120px" >
                		<option value="1" <c:if test="${cust.isMarry != '2' and cust.isMarry != '3' }">selected="selected"</c:if> >已婚</option>
                		<option value="2" <c:if test="${cust.isMarry == '2' }">selected="selected"</c:if> >未婚</option>
                		<option value="3" <c:if test="${cust.isMarry == '3' }">selected="selected"</c:if> >離異</option>
                	</select>
                </td>
                
                <td align="right" class="l-table-edit-td">出生地:</td>
                <td align="left" class="l-table-edit-td">
                	<select name="nativePlace" id="nativePlace" ltype="select" width="120px" >
                		<option value="1" <c:if test="${cust.nativePlace != '2' and cust.nativePlace != '3' }">selected="selected"</c:if> >澳門</option>
                		<option value="2" <c:if test="${cust.nativePlace == '2' }">selected="selected"</c:if> >內地</option>
                		<option value="3" <c:if test="${cust.nativePlace == '3' }">selected="selected"</c:if> >其他(指定)</option>
                	</select>
                </td>
                
            </tr>  
                 
            <tr>
                <td align="right" class="l-table-edit-td">學歷:</td>
                <td align="left" class="l-table-edit-td">
					<select name="edulevel" id="edulevel" ltype="select" width="120px" >
                		<option value="1" <c:if test="${cust.edulevel != '2' and cust.edulevel != '3' and cust.edulevel != '4' and cust.edulevel != '5' }">selected="selected"</c:if> >無</option>
                		<option value="2" <c:if test="${cust.edulevel == '2' }">selected="selected"</c:if> >小學</option>
                		<option value="3" <c:if test="${cust.edulevel == '3' }">selected="selected"</c:if> >中學</option>
                		<option value="4" <c:if test="${cust.edulevel == '4' }">selected="selected"</c:if> >高中</option>
                		<option value="5" <c:if test="${cust.edulevel == '5' }">selected="selected"</c:if> >大學</option>
                	</select>
                </td>
                
                <td align="right" class="l-table-edit-td">居住地址:</td>
                <td align="left" class="l-table-edit-td" colspan="3"><input width="120px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" /></td>
                
                <td align="right" class="l-table-edit-td">寄信:</td>
                <td align="left" class="l-table-edit-td">
                	<select name="isSendLetter" id="isSendLetter" ltype="select" width="120px" >
                		<option value="0" <c:if test="${cust.isSendLetter != '1'}">selected="selected"</c:if> >否</option>
                		<option value="1" <c:if test="${cust.isSendLetter == '1'}">selected="selected"</c:if> >是</option>
                	</select>
                </td>
            </tr>
            
            
            <tr>
                <td align="right" class="l-table-edit-td">手提電話:</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${cust.mobileTelNO }" name="mobileTelNO" type="text" id="mobileTelNO" ltype="text" /></td>
                
                <td align="right" class="l-table-edit-td">家庭電話:</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${cust.telNo }" name="telNo" type="text" id="telNo" ltype="text" /></td>
                
                <td align="right" class="l-table-edit-td">電郵地址:</td>
                <td align="left" class="l-table-edit-td">
                	<%-- <input width="120px"  value="${cust.email }" name="email" type="text" id="email" ltype="text" validate="{required:true,email:true}"/> --%>
                	<input width="120px"  value="${cust.email }" name="email" type="text" id="email" ltype="text" />
                </td>
                
            </tr>
            
            
             <tr>
                <td align="right" class="l-table-edit-td">就業情況:</td>
                <td align="left" class="l-table-edit-td">
                	<select name="isJob" id="isJob" ltype="select" width="120px" >
                		<option value="0" <c:if test="${cust.isJob != '1' and cust.isJob != '2' and cust.isJob != '3' and cust.isJob != '4'}">selected="selected"</c:if> >待業</option>
                		<option value="1" <c:if test="${cust.isJob == '1'}">selected="selected"</c:if> >中心訓練</option>
                		<option value="2" <c:if test="${cust.isJob == '2'}">selected="selected"</c:if> >公開就業</option>
                		<option value="3" <c:if test="${cust.isJob == '3'}">selected="selected"</c:if> >在校學生</option>
                		<option value="4" <c:if test="${cust.isJob == '4'}">selected="selected"</c:if> >其他</option>
                	</select>
                </td>
                
                <td align="right" class="l-table-edit-td">就業單位:</td>
                <td align="left" class="l-table-edit-td" colspan="3"><input width="120px" value="${cust.jobPlace }" name="jobPlace" type="text" id="jobPlace" ltype="text" /></td>
                
                
            </tr>
            
            <tr>
                <td align="right" class="l-table-edit-td">其他智障人士:</td>
                <td align="left" class="l-table-edit-td" colspan="5" ></td>
                
                <td align="right" class="l-table-edit-td">照顧人:</td>
                <td align="left" class="l-table-edit-td"></td>
            </tr>
            
            <tr>
                <td align="right" class="l-table-edit-td">普通轉永久:</td>
                <td align="left" class="l-table-edit-td">
                	<select name="isSendLetter" id="isNormalToForever" ltype="select" width="120px" >
                		<option value="0" <c:if test="${cust.isNormalToForever != '1'}">selected="selected"</c:if> >否</option>
                		<option value="1" <c:if test="${cust.isNormalToForever == '1'}">selected="selected"</c:if> >是</option>
                	</select>
                </td>
                
                <td align="right" class="l-table-edit-td">轉換日期:</td>
                <td align="left" class="l-table-edit-td">
                	<input width="120px" value="${cust.changeDateStr }" name="changeDate" type="text" id="changeDate" ltype="date" />
                </td>
                
                <td align="right" class="l-table-edit-td">證件製作日期:</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${cust.makeCardDateStr }"  name="makeCardDate" type="text" id="makeCardDate" ltype="date" /></td>
                
                <td align="right" class="l-table-edit-td">證件領取日期:</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${cust.reciveCardDateStr }"  name="reciveCardDate" type="text" id="reciveCardDate" ltype="date" /></td>
            </tr>
            
             <tr>
                <td align="right" class="l-table-edit-td">殘評證號碼:</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${cust.disabilityCardNo }" name="disabilityCardNo" type="text" id="disabilityCardNo" ltype="text"  /></td>
                
                <td align="right" class="l-table-edit-td">殘評證有效期:</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${cust.disabilityEndDateStr }" name="disabilityEndDate" type="text" id="disabilityEndDate" ltype="date"  /></td>
                
                <td align="right" class="l-table-edit-td">自理能力:</td>
                <td align="left" class="l-table-edit-td">
                	<select name="selfCareAbility" id="selfCareAbility" ltype="select" width="120px" >
                		<option value="1" <c:if test="${cust.selfCareAbility != '2' and cust.selfCareAbility != '3'}">selected="selected"</c:if> >自理</option>
                		<option value="2" <c:if test="${cust.selfCareAbility == '2'}">selected="selected"</c:if> >協助</option>
                		<option value="3" <c:if test="${cust.selfCareAbility == '3'}">selected="selected"</c:if> >無自理能力</option>
                	</select>
                </td>
                
                <td align="right" class="l-table-edit-td">居住狀況:</td>
                <td align="left" class="l-table-edit-td">
                	<select name="houseSitution" id="houseSitution" ltype="select" width="120px" >
                		<option value="1" <c:if test="${cust.houseSitution != '2'}">selected="selected"</c:if> >院舍</option>
                		<option value="2" <c:if test="${cust.houseSitution == '2'}">selected="selected"</c:if> >經屋</option>
                	</select>
                </td>
             </tr>
            
            
            <tr>
            	<td align="right" class="l-table-edit-td">家庭總收入:</td>
                <td align="left" class="l-table-edit-td">
                	<select name="totalIncome" id="totalIncome" ltype="select" width="120px" >
                		<option value="1" <c:if test="${cust.totalIncome != '2' and cust.selfCareAbility != '3' and cust.selfCareAbility != '4' and cust.selfCareAbility != '5' and cust.selfCareAbility != '6' and cust.selfCareAbility != '7' and cust.selfCareAbility != '8' and cust.selfCareAbility != '9' }">selected="selected"</c:if> >$0~$4,800</option>
                		<option value="2" <c:if test="${cust.totalIncome == '2'}">selected="selected"</c:if> >$4,801~$8,580</option>
                		<option value="3" <c:if test="${cust.totalIncome == '3'}">selected="selected"</c:if> >$8,581~$11,420</option>
                		<option value="4" <c:if test="${cust.totalIncome == '4'}">selected="selected"</c:if> >$11,421~$13,390</option>
                		<option value="5" <c:if test="${cust.totalIncome == '5'}">selected="selected"</c:if> >$13,391~$14,560</option>
                		<option value="6" <c:if test="${cust.totalIncome == '6'}">selected="selected"</c:if> >$14,561~$15,600</option>
                		<option value="7" <c:if test="${cust.totalIncome == '7'}">selected="selected"</c:if> >$15,601~$16,510</option>
                		<option value="8" <c:if test="${cust.totalIncome == '8'}">selected="selected"</c:if> >$16,511~$17,300</option>
                		<option value="9" <c:if test="${cust.totalIncome == '9'}">selected="selected"</c:if> >$17,301或以上</option>
                	</select>
                </td>
                
                <td align="right" class="l-table-edit-td">背景資料:</td>
                <td align="left" class="l-table-edit-td"><input width="120px" value="${cust.backgroundInfo }"  name="backgroundInfo" type="text" id="backgroundInfo" ltype="text"/></td>
                
                
                <td align="right" class="l-table-edit-td">政府援助:</td>
                <td align="left" class="l-table-edit-td">
                	<select name="governmentalHelp" id="governmentalHelp" ltype="select" width="120px" >
                		<option value="1" <c:if test="${cust.governmentalHelp != '2' and cust.selfCareAbility != '3' and cust.selfCareAbility != '4'}">selected="selected"</c:if> >個人援助金</option>
                		<option value="2" <c:if test="${cust.governmentalHelp == '2'}">selected="selected"</c:if> >家庭援助金</option>
                		<option value="3" <c:if test="${cust.governmentalHelp == '3'}">selected="selected"</c:if> >三類弱勢援助金</option>
                		<option value="4" <c:if test="${cust.governmentalHelp == '4'}">selected="selected"</c:if> >其他政府援助金</option>
                	</select>
                </td>
                
            </tr>
            
            <tr>
                <td align="right" class="l-table-edit-td">綜援家庭:</td>
                <td align="left" class="l-table-edit-td">
                	<select name="disabilityCardNo" id="disabilityCardNo" ltype="select" width="120px" >
                		<option value="0" <c:if test="${cust.disabilityCardNo != '1'}">selected="selected"</c:if> >否</option>
                		<option value="1" <c:if test="${cust.disabilityCardNo == '1'}">selected="selected"</c:if> >是</option>
                	</select>
                </td>
                
                <td align="right" class="l-table-edit-td">特別生活津貼:</td>
                <td align="left" class="l-table-edit-td">
                	<select name="specialAllowance" id="specialAllowance" ltype="select" width="120px" >
                		<option value="0" <c:if test="${cust.specialAllowance != '1'}">selected="selected"</c:if> >否</option>
                		<option value="1" <c:if test="${cust.specialAllowance == '1'}">selected="selected"</c:if> >是</option>
                	</select>
                </td>
                
                <td align="right" class="l-table-edit-td">總積分:</td>
                <td align="left" class="l-table-edit-td"><input width="120px"  name="totalPoint" type="text" id="totalPoint" ltype="spinner"/></td>
          	</tr>
        </table>
        <br>
        
        
        <div id="tab" style="width: 99%; border:1px solid #A3C0E8; "> 
            <div title="智障登记" style="height:auto;overflow:auto;">
                <div id="retardedGrid"></div>
            </div>
            <div tabid="familyGrid" title="家庭成員" style="height:auto;overflow:auto;">
                <div id="familyGrid"></div>
            </div>
        </div>
        <br>
        
        <div id="tab1" style="width: 99%; border:1px solid #A3C0E8; "> 
            <div title="綜援家庭" style="height:auto;overflow:auto;">
               <div id="CSSAGrid"></div>
            </div>
            <div tabid="SpecialAllowanceGrid" title="特津記錄" style="height:auto;overflow:auto;">
               <div id="SpecialAllowanceGrid"></div>
            </div>
            <div  tabid="ActivityGrid" title="參加活動記錄" style="height:auto;overflow:auto;">
               <div id="ActivityGrid"></div>
            </div>
            <div tabid="VolunteerGrid" title="參加義工記錄" style="height:auto;overflow:auto;">
               <div id="VolunteerGrid"></div>
            </div>
        </div>
        
        
        <input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
    </form>
    
    
    
</body>
</html>