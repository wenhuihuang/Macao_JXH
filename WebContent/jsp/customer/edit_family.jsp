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
<title>家庭成員資料</title>
<script type="text/javascript">
	var formFamily = null;

	$(function(){
		
		
		$("#toptoolbar").ligerToolBar({ items: [
           { text: '保存', click: itemclick, icon: 'save' , id:"save" },
           { line: true },
           { text: '返回', click: itemclick, icon: 'back' , id:"back" }
         ]
         });
		
		
		
		formFamily = ligerForm("formFamily","submitForm");
		
		
		var jsonData = <%=request.getParameter("jsonData") %>
		
		if(jsonData!=null){
			formFamily.setData(jsonData);
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
		dialog.familyData = formFamily.getData();
		dialog.familyData.custId = $("#custId").val();
		dialog.familyData.regDate = $("#regDate").val();
		dialog.familyData.validDate = $("#validDate").val();
		dialog.familyData.custType2 = $("#custType2").val();
		dialog.close(); 
	}
	
	function back(){
		getDialog().close(); 
	}
	
</script>
</head>
<body  style="height: auto;overflow: scroll;">
	<div id="toptoolbar"></div>

	<form name="formFamily" method="post" action="" id="formFamily" style="margin: 20px;" >
		<input type="hidden" value="${cust.custID }" name="custID" id="custID">
		<input type="hidden" value="${cust.regDateStr }" name="regDate" id="regDate">
		<input type="hidden" value="${cust.validDateStr }" name="validDate" id="validDate">
		<input type="hidden" value="${cust.custType2 }" name="custType2" id="custType2">
		<table cellpadding="0" cellspacing="0" class="l-table-edit" >
            <tr>
                <td align="right" class="l-table-edit-td">是否會員：</td>
                <td align="left" class="l-table-edit-td">
                	<select name="isMember" id="isMember" ltype="select" width="130px">
                		<option value="0" <c:if test="${cust.isMember != '1'}">selected="selected"</c:if> >否</option>
                		<option value="1" <c:if test="${cust.isMember == '1'}">selected="selected"</c:if> >是</option>
                	</select>
                </td>
                
                <td align="right" class="l-table-edit-td">關係：</td>
                <td align="left" class="l-table-edit-td">
                	<input width="130px" value="${cust.relationship }" name="relationship" type="text" id="relationship" ltype="text" validate="{required:true,notnull:true}"/>
                </td>
                
                <td align="right" class="l-table-edit-td">是否監護人：</td>
                <td align="left" class="l-table-edit-td">
                	<select name="isGuardian" id="isGuardian" ltype="select" width="130px">
                		<option value="0" <c:if test="${cust.isGuardian != '1'}">selected="selected"</c:if> >否</option>
                		<option value="1" <c:if test="${cust.isGuardian == '1'}">selected="selected"</c:if> >是</option>
                	</select>
                </td>
                
                <td align="right" class="l-table-edit-td">與智障人士同住：</td>
                <td align="left" class="l-table-edit-td">
                	<select name="isLiveTogether" id="isLiveTogether" ltype="select" width="130px">
                		<option value="0" <c:if test="${cust.isLiveTogether != '1'}">selected="selected"</c:if> >否</option>
                		<option value="1" <c:if test="${cust.isLiveTogether == '1'}">selected="selected"</c:if> >是</option>
                	</select>	
                </td>
            </tr>
            
            <tr>
                <td align="right" class="l-table-edit-td">姓名:</td>
                <td align="left" class="l-table-edit-td">
                	<input width="130px" value="${cust.fullName }" name="fullName" type="text" id="fullName" ltype="text" validate="{required:true,notnull:true}"/>
                </td>
                
                <td align="right" class="l-table-edit-td">英文名:</td>
                <td align="left" class="l-table-edit-td">
                	<input width="130px" value="${cust.fullNameEng }" name="fullNameEng" type="text" id="fullNameEng" ltype="text" />
                </td>
                
                <td align="right" class="l-table-edit-td">證件類型:</td>
                <td align="left" class="l-table-edit-td">
                	<select name="cardType" id="cardType" ltype="select" width="120px" >
                		<option value="1" <c:if test="${cust.cardType != '2' and cust.cardType != '3' }">selected="selected"</c:if> >永久身份證 </option>
                		<option value="2" <c:if test="${cust.cardType == '2' }">selected="selected"</c:if> >非永久身份證 </option>
                		<option value="3" <c:if test="${cust.cardType == '3' }">selected="selected"</c:if> >其他</option>
                	</select>	
                </td>
                
                <td align="right" class="l-table-edit-td">證件號嗎:</td>
                <td align="left" class="l-table-edit-td">
                	<input width="130px" value="${cust.cardNo }" name="cardNo" type="text" id="cardNo" ltype="text" />
                </td>
            </tr>
            
            
            
             <tr>
                <td align="right" class="l-table-edit-td">學歷:</td>
                <td align="left" class="l-table-edit-td">
                	<select name="edulevel" id="edulevel" ltype="select" width="130px">
                		<option value="0" <c:if test="${cust.edulevel != '1' and cust.edulevel != '2' and cust.edulevel != '3' and cust.edulevel != '4'}">selected="selected"</c:if> >無</option>
                		<option value="1" <c:if test="${cust.edulevel == '1'}">selected="selected"</c:if> >小學</option>
                		<option value="2" <c:if test="${cust.edulevel == '2'}">selected="selected"</c:if> >中學</option>
                		<option value="3" <c:if test="${cust.edulevel == '3'}">selected="selected"</c:if> >高中</option>
                		<option value="4" <c:if test="${cust.edulevel == '4'}">selected="selected"</c:if> >大學</option>
                	</select>
                </td>
                
                 <td align="right" class="l-table-edit-td">居住地址:</td>
                <td align="left" class="l-table-edit-td"><input width="130px" value="${cust.linkAdr }" name="linkAdr" type="text" id="linkAdr" ltype="text" /></td>
                
            
              	<td align="right" class="l-table-edit-td">性别：</td>
                <td align="left" class="l-table-edit-td">
					<select name="sex" id="sex" ltype="select" width="130px">
                		<option value="1" <c:if test="${cust.sex != '2'}">selected="selected"</c:if> >男</option>
                		<option value="2" <c:if test="${cust.sex == '2'}">selected="selected"</c:if> >女</option>
                	</select>
				</td>
                
                <td align="right" class="l-table-edit-td">出生日期:</td>
                <td align="left" class="l-table-edit-td">
                	<input width="130px" value="${cust.birthday_ChnStr }" name="birthday_Chn" type="text" id="birthday_Chn" ltype="date" />
                </td>
                
            </tr>
            
            
            
              <tr>
                <td align="right" class="l-table-edit-td">手提電話:</td>
                <td align="left" class="l-table-edit-td"><input width="130px" value="${cust.mobileTelNo }" name="mobileTelNo" type="text" id="mobileTelNo" ltype="text" /></td>
                
                <td align="right" class="l-table-edit-td">家庭電話:</td>
                <td align="left" class="l-table-edit-td"><input width="130px" value="${cust.telNo }" name="telNo" type="text" id="telNo" ltype="text" /></td>
                
                <td align="right" class="l-table-edit-td">公司電話:</td>
                <td align="left" class="l-table-edit-td"><input width="130px" value="${cust.telNO_Work }" name="telNO_Work" type="text" id="telNO_Work" ltype="text" /></td>
                
                <td align="right" class="l-table-edit-td">電郵地址:</td>
                <td align="left" class="l-table-edit-td">
                	<input width="130px"  value="${cust.email }" name="email" type="text" id="email" ltype="text" />
                </td>
                
            </tr>
            
            
            <tr>
                <td align="right" class="l-table-edit-td">婚姻狀況:</td>
                <td align="left" class="l-table-edit-td">
                	<select name="isMarry" id="isMarry" ltype="select" width="130px" >
                		<option value="1" <c:if test="${cust.isMarry != '2' and cust.isMarry != '3' }">selected="selected"</c:if> >已婚</option>
                		<option value="2" <c:if test="${cust.isMarry == '2' }">selected="selected"</c:if> >未婚</option>
                		<option value="3" <c:if test="${cust.isMarry == '3' }">selected="selected"</c:if> >離異</option>
                	</select>
                </td>
                
                <td align="right" class="l-table-edit-td">就業情況:</td>
                <td align="left" class="l-table-edit-td"><input width="130px" value="${cust.jobSitution }" name="jobSitution" type="text" id="jobSitution" ltype="text" /></td>
                
                <td align="right" class="l-table-edit-td">職業類別:</td>
                <td align="left" class="l-table-edit-td"><input width="130px" value="${cust.jobType }" name="jobType" type="text" id="jobType" ltype="text" /></td>
                
                <td align="right" class="l-table-edit-td">收入:</td>
                <td align="left" class="l-table-edit-td">
                	<select name="totalIncome" id="totalIncome" ltype="select" width="130px" >
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
                
            </tr>
            
          </table>
          
          
          <input type="submit" value="提交" id="Button1" class="l-button l-button-submit" style="display: none;" />
	</form>
</body>
</html>