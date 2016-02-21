<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
%>
<%
	String caseID = request.getParameter("caseID");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/jsp/head.jsp"></jsp:include>
<title>個案撮要記錄</title>
<script type="text/javascript">
		ligerUiFn.back=function(){
			var custId = "${bCustCaseRecordPojo.custID}";
			location.href="CustCase/edit.do?caseID=${param.caseID}&back=true";
		}
		ligerUiFn.save=function(){
			
		}
		var formRecord=null;
        $(function(){
        	$("#toptoolbar").ligerToolBar({ items: [
               { text: '保存', click: itemclick, icon: 'save' , id:"save" },
               { line: true },
               { text: '返回', click: itemclick, icon: 'back' , id:"back" },
               { line: true },
               { text: '刷新', click: itemclick, icon: 'refresh' , id:"refresh" }
             ]
             });
        	 
        		
     		formRecord = ligerForm("form2","submitForm");
     		
     		<%-- var jsonData = <%=request.getParameter("jsonData") %> --%>
     		var fullName = <%="\""+request.getParameter("fullName")+"\""%>;
     		if(fullName != "" && fullName != 'null' && fullName != "undefined"){
     			$("#fullName").val(fullName);
     		} 
     		
        });
     	
     	function itemclick(item)
     	{
     	    switch(item.id){
     	    	case "save":save();break;
     	    	case "back":back();break;
     	    	default : break;
     	    }
     	}
     	
     	function save(){
     		$("#Button1").click();
     	}
     	
     	
     	function submitForm(){
     		var dialog = getDialog();
     		dialog.recordData = formRecord.getData();
     		var time = $("#talksTime").val()+":00";
     		dialog.recordData.talksTime=time
     		dialog.recordData.caseID=$("#caseID").val()
     		console.log(dialog.recordData.talksTime )
     		dialog.close(); 
     	}
     	
     	function back(){
     		getDialog().close(); 
     	}
       
</script>
</head>
<body>
 	<div>
 		<div id="toptoolbar"></div>
		<form action="" name="form2" id="form2">
			<input type="hidden" name="caseID" id="caseID" value="${bCustCaseRecordPojo.caseID }">
             		<table cellpadding="0" cellspacing="0" class="l-table-edit" >
             			<tbody>
             				<tr>
             					 <td align="right" class="l-table-edit-td" >案主姓名:</td>
             					 <td align="left" class="l-table-edit-td">
             					 <input width="120px" disabled="disabled" value="${bCustCaseRecordPojo.fullName }" type="text" name="fullName" id="fullName" ltype="text" />
             					 </td>
             					 
             					  <td align="right" class="l-table-edit-td">會談日期:</td>
             					 <td align="left" class="l-table-edit-td"><input width="120px" value="${bCustCaseRecordPojo.talksDate_str }" name="talksDate" type="text" id="talksDate" ltype="date" /></td>
             					 <td align="right" class="l-table-edit-td">會談時間:</td>
             					 <td align="left" class="l-table-edit-td"><input width="120px" value="${bCustCaseRecordPojo.talksTime }" name="talksTime" type="time" id="talksTime" ltype="text" /></td>
             					  <td align="right" class="l-table-edit-td">會談形式:</td>
             					 <td align="left" class="l-table-edit-td"><input width="120px" value="${bCustCaseRecordPojo.form }" name="form" type="text" id="form" ltype="text" /></td>
             				</tr>
             				<tr>
             					 <td align="right" class="l-table-edit-td">地點:</td>
             					 <td align="left" class="l-table-edit-td"><input width="120px" value="${bCustCaseRecordPojo.place }" name="place" type="text" id="place" ltype="text" /></td>
             					 <td align="right" class="l-table-edit-td">在場的家庭成員:</td>
             					 <td align="left" class="l-table-edit-td"><input width="120px" value="${bCustCaseRecordPojo.family }" name="family" type="text" id="family" ltype="text" /></td>
             					 <td align="right" class="l-table-edit-td">其他人士:</td>
             					 <td align="left" class="l-table-edit-td"><input width="120px" value="${bCustCaseRecordPojo.otherMan }" name="otherMan" type="text" id="otherMan" ltype="text" /></td>
             					  <td align="right" class="l-table-edit-td">會談次數:</td>
             					 <td align="left" class="l-table-edit-td"><input width="120px" value="${bCustCaseRecordPojo.times }" name="times" type="text" id="times" ltype="text" /></td>
             				</tr>
             				<tr>
             					 <td align="right" class="l-table-edit-td">記錄者:</td>
             					 <td align="left" class="l-table-edit-td">
             					 	<input width="120px" value="${bCustCaseRecordPojo.recordAdmin }" name="recordAdmin" type="text" id="recordAdmin" ltype="text" />
             					 </td>
             				</tr>
             				<tr>
             					 <td align="right" class="l-table-edit-td">會談主題/:</td>
             					 <td align="left" class="l-table-edit-td" colspan="3">
             					 	<textarea rows="2" cols="55" class="ui-textarea" name="title">${bCustCaseRecordPojo.title }</textarea>
             					 </td>
             					 <td align="right" class="l-table-edit-td">內容撮要:</td>
             					 <td align="left" class="l-table-edit-td" colspan="3">
             					 	<textarea rows="2" cols="55" class="ui-textarea" name="content">${bCustCaseRecordPojo.content }</textarea>
             					 </td>
             				</tr>
             				<tr>
             					 <td align="right" class="l-table-edit-td">工作員對問題的分析:</td>
             					 <td align="left" class="l-table-edit-td" colspan="3">
             					 	<textarea rows="2" cols="55" class="ui-textarea" name="analysis">${bCustCaseRecordPojo.analysis }</textarea>
             					 </td>
             					 <td align="right" class="l-table-edit-td">跟進/處理方法:</td>
             					 <td align="left" class="l-table-edit-td" colspan="3">
             					 	<textarea rows="2" cols="55" class="ui-textarea" name="ways">${bCustCaseRecordPojo.ways }</textarea>
             					 </td>
             				</tr>
             				<tr>
             					  <td align="right" class="l-table-edit-td">主管:</td>
             					 <td align="left" class="l-table-edit-td">
             					 	<input width="120px" value="${bCustCaseRecordPojo.handler }" name="handler" type="text" id="handler" ltype="text" />
             					 </td>
             					  <td align="right" class="l-table-edit-td">日期:</td>
             					 <td align="left" class="l-table-edit-td">
             					 	<input width="120px" value="${bCustCaseRecordPojo.handlDate_str }" name="handlDate" type="text" id="handlDate" ltype="date" />
             					 </td>
             				</tr>
             				<tr>
             					 <td align="right" class="l-table-edit-td">主管意見及建議:</td>
             					 <td align="left" class="l-table-edit-td" colspan="3">
             					 	<textarea rows="2" cols="55" class="ui-textarea" name="handlSuggest">${bCustCaseRecordPojo.handlSuggest }</textarea>
             					 </td>
             				</tr>
             			</tbody>
             		</table> 
             		<input type="submit" id="Button1" value="提交" style="display:none" >
             	</form> 
 	</div>
</body>
</html>
