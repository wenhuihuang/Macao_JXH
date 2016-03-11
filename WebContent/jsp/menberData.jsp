<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
$(function(){
	var edulevel = $("#edulevel").ligerComboBox({disabled :true});
   	var isMarry = $("#isMarry").ligerComboBox({disabled :true});
	//會員編號
	$("#custNO").ligerPopupEdit({
	  /*   condition: {
	        prefixID: 'condtion_',
	        fields: [{ name: 'CompanyName', type: 'text', label: '客户' }]
	    }, */
	    grid: getcustNOGridOptions(true),
	    valueField: 'custNO',
	    textField: 'custNO',
	    width: 200,
	    readonly:false
	});

	function getcustNOGridOptions(checkbox) {
	    var options = {
	        columns: [
	        { display: '會員編號', name: 'custNO', align: 'left', width: 100, minWidth: 60 },
	        { display: '案主姓名', name: 'fullName', minWidth: 120, width: 100 }
	        ], switchPageSizeApplyComboBox: false,
	       //data:{"Rows":[{"cardNO":"44071112902313264","cardStatus":1,"cardType":"1","custCode":"001002","custId":"00010000000000000105","custType":"1","fullName":"王祖蓝","fullNameEng":"","mobileTelNO":"13543212653","regDate":{"date":8,"day":5,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":1452182400000,"timezoneOffset":-480,"year":116},"relationship":"","sex":"1","telNo":"","validDate":{"date":8,"day":5,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":1452182400000,"timezoneOffset":-480,"year":116}},{"cardNO":"","cardStatus":0,"cardType":"1","custCode":"022222","custId":"0001000000000000011S","custType":"0","fullName":"gg","fullNameEng":"","mobileTelNO":"","regDate":{"date":15,"day":1,"hours":0,"minutes":0,"month":1,"nanos":0,"seconds":0,"time":1455465600000,"timezoneOffset":-480,"year":116},"relationship":"","sex":"1","telNo":"","validDate":{"date":15,"day":1,"hours":0,"minutes":0,"month":1,"nanos":0,"seconds":0,"time":1455465600000,"timezoneOffset":-480,"year":116}},{"cardNO":"6543012","cardStatus":1,"cardType":"1","custCode":"001001","custId":"1","custType":"1","fullName":"劉燁","fullNameEng":"Ye.Lao","mobileTelNO":"13543215712","regDate":{"date":14,"day":4,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":1452700800000,"timezoneOffset":-480,"year":116},"relationship":"","sex":"1","telNo":"3052135","validDate":{"date":20,"day":3,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":1453219200000,"timezoneOffset":-480,"year":116}}],"Total":3},
	       url:"CustCase/listPojos.do",
	       pageSize: 10
	    };
	    return options;
	}

	//非會員編號
	$("#custNewNO").ligerPopupEdit({
	  /*   condition: {
	        prefixID: 'condtion_',
	        fields: [{ name: 'CompanyName', type: 'text', label: '客户' }]
	    }, */
	    grid: getcustNewNOGridOptions(true),
	    valueField: 'custNewNO',
	    textField: 'custNewNO',
	    width: 200,
	    readonly:false
	});

	function getcustNewNOGridOptions(checkbox) {
	    var options = {
	        columns: [
	        { display: '非會員編號', name: 'custNewNO', align: 'left', width: 100, minWidth: 60 },
	        { display: '案主姓名', name: 'fullName', minWidth: 120, width: 100 }
	        ], switchPageSizeApplyComboBox: false,
	       //data:{"Rows":[{"cardNO":"44071112902313264","cardStatus":1,"cardType":"1","custCode":"001002","custId":"00010000000000000105","custType":"1","fullName":"王祖蓝","fullNameEng":"","mobileTelNO":"13543212653","regDate":{"date":8,"day":5,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":1452182400000,"timezoneOffset":-480,"year":116},"relationship":"","sex":"1","telNo":"","validDate":{"date":8,"day":5,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":1452182400000,"timezoneOffset":-480,"year":116}},{"cardNO":"","cardStatus":0,"cardType":"1","custCode":"022222","custId":"0001000000000000011S","custType":"0","fullName":"gg","fullNameEng":"","mobileTelNO":"","regDate":{"date":15,"day":1,"hours":0,"minutes":0,"month":1,"nanos":0,"seconds":0,"time":1455465600000,"timezoneOffset":-480,"year":116},"relationship":"","sex":"1","telNo":"","validDate":{"date":15,"day":1,"hours":0,"minutes":0,"month":1,"nanos":0,"seconds":0,"time":1455465600000,"timezoneOffset":-480,"year":116}},{"cardNO":"6543012","cardStatus":1,"cardType":"1","custCode":"001001","custId":"1","custType":"1","fullName":"劉燁","fullNameEng":"Ye.Lao","mobileTelNO":"13543215712","regDate":{"date":14,"day":4,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":1452700800000,"timezoneOffset":-480,"year":116},"relationship":"","sex":"1","telNo":"3052135","validDate":{"date":20,"day":3,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":1453219200000,"timezoneOffset":-480,"year":116}}],"Total":3},
	       url:"CustCase/listPojos.do",
	       pageSize: 10
	    };
	    return options;
	}

	//案生姓名
	 var full = $(".fullName").ligerPopupEdit({
	    grid: getFullNameGridOptions(true),
	    valueField: 'fullName',
	    textField: 'fullName',
	    width: 200,
	    onSelected:fullNameSelected
	});

	function getFullNameGridOptions(checkbox) {
	    var options = {
	        columns: [
				{ display: '會員ID', name: 'custID', minWidth: 120, width: 100 },
	        { display: '案主姓名', name: 'fullName', minWidth: 120, width: 100 }
	        ], switchPageSizeApplyComboBox: false,
	        //pageSize: 10
	       /*  checkbox: checkbox, */
	       url:"Customer/list.do"
	      // usePager:false
	       
	    };
	    return options;
	}

	function fullNameSelected(data){
		   console.log(data.data[0])
		   var custID = data.data[0].custID;
		   $.ajax({
			   type:"post",
			   url:"Customer/custData.do",
			   data:"custID="+custID,
			   success:function(msg){
				  // var m = JSON.parse(msg);
				  if(msg != ""){
					  console.log(msg)
	    			   var m = msg.replace(/^\[/g,"");
	    					m = m.replace(/\]$/g,"");
	    					m = JSON.parse(m)
	    			   console.log(m)
	    			   $("#custID").val(m.custID);
	    			   $("#mobileTelNO").val(m.mobileTelNO);
	    			   $("#father").val(m.mother);
	    			   $("#mother").val(m.mother);
	    			   $("#custNO").val(m.custNO);
	    			   $("#custNewNO").val(m.custNewNO); 
				   		$("#linkAdr").val(m.linkAdr);
				   		$("#cardNO").val(m.cardNO);
				   		$("#birthday_ChnStr").val(m.birthday_ChnStr);
				   		$("#receiveDate").val(m.receiveDate_str);
				   		$("#caseWorker").val(m.caseWorker);
				   		$("#economics").val(m.economics);
				   		$(".fullName").val(m.fullName);
			   			if(edulevel != "" && edulevel != null && edulevel != 'undefined'){
			   				edulevel.setValue(m.edulevel);
			   			}
				   		if(isMarry != "" && isMarry != null && isMarry!= 'nudefined'){
				   			isMarry.setValue(m.isMarry);
				   		}
    			 		$("#sex").find("input").each(function(){
    			 			if($(this).val() == m.sex){
    			 				var sex = $(this).ligerRadio();
    			 					sex.setValue(true);
    			 			}else{
    			 				var sex = $(this).ligerRadio();
    			 					sex.setValue(false);
    			 			}
    			 		})
				   		 
				  }
				   
			   }
			   
		   }) 
	}
})
</script>