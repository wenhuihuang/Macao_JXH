var logo = "images/jxh/afedmm-logo2.jpg";
//var DataSource = "192.168.1.111\\SQLEXPRESS,1433";
//var reportConnection = "Provider=SQLOLEDB.1;Password=1surewin,;Persist Security Info=True;User ID=sa;Initial Catalog=Macao_JXH;Data Source="+DataSource+";Use Procedure for Prepare=1;Auto Translate=True;Packet Size=4096;Use Encryption for Data=False;Tag with column collation when possible=False";


function makeCards(rows,url){
	
	
	var detailSql = "select *,(case sex when 2 then '女' else '男' end) Sex,YEAR(isNull(StartDate,getDate())) CurrentYear,'"+url+"'+imgUrl as imgPath from bCustomer where MasterCardCustID = :CustID  and custType = 'b'";
	
	
	var normalMembers = [];
	
	var foreverMembers = [];
	
	for(var i = 0;i<rows.length;i++){
		var row = rows[i];
		
		 if(row.custType != 'a'){
			 continue;
		 }
		
		if(row.custType2=='1'){
			normalMembers.push(row);
		}else if(row.custType2=='2'){
			foreverMembers.push(row);
		}
	}
	
	
	
	if(normalMembers.length>0){
		Report.LoadFromURL("gridReport/MemberCardNormal.grf");
		
		//Report.DetailGrid.Recordset.ConnectionString = reportConnection;
		
		
		var custIds = "";
		for(var i = 0;i<normalMembers.length;i++){
			custIds += "'"+normalMembers[i].custId+"',";
		}
		
		if(custIds.length>0){
			custIds = custIds.substring(0,custIds.length-1);
		}
		
		
		var detailControl = Report.FindFirstControl();
		while(detailControl!=null){
			if(detailControl.ControlType==9){
				//detailControl.AsSubReport.Report.ConnectionString = reportConnection;
				//detailControl.AsSubReport.Report.QuerySQL = detailSql;
				detailControl.AsSubReport.Report.DetailGrid.Recordset.QuerySQL = detailSql;
				break;
			}
			detailControl = Report.FindNextControl();
		}
		
		
		
		Report.LoadDataFromURL("gridReport/data/jsonMakeCard.jsp?custIds="+custIds);
		
		
		
		
		
  	    Report.Print(true);
	}
	
	
	
	if(foreverMembers.length>0){
		Report.LoadFromURL("gridReport/MemberCardForever.grf");
		
		var custIds = "";
		for(var i = 0;i<foreverMembers.length;i++){
			custIds += "'"+foreverMembers[i].custId+"',";
		}
		
		if(custIds.length>0){
			custIds = custIds.substring(0,custIds.length-1);
		}
		
		
		var detailControl = Report.FindFirstControl();
		while(detailControl!=null){
			if(detailControl.ControlType==9){
				//detailControl.AsSubReport.Report.ConnectionString = reportConnection;
				detailControl.AsSubReport.Report.DetailGrid.Recordset.QuerySQL = detailSql;
				break;
			}
			detailControl = Report.FindNextControl();
		}
		
		
		
		Report.LoadDataFromURL("gridReport/data/jsonMakeCard.jsp?custIds="+custIds);
  	    Report.Print(true);
	}
	
	
	
	
	alert("會員卡正面已經打印完畢，請準備打印背面！");
	
	
	
	
	
	if(normalMembers.length>0){
		Report.LoadFromURL("gridReport/MemberCardNormalBack.grf");
		
		var custIds = "";
		for(var i = 0;i<normalMembers.length;i++){
			custIds += "'"+normalMembers[i].custId+"',";
		}
		
		if(custIds.length>0){
			custIds = custIds.substring(0,custIds.length-1);
		}
		
		
		Report.LoadDataFromURL("gridReport/data/jsonMakeCard.jsp?custIds="+custIds);
  	    Report.Print(true);
	}
	
	
	
	if(foreverMembers.length>0){
		Report.LoadFromURL("gridReport/MemberCardForeverBack.grf");
		
		var custIds = "";
		for(var i = 0;i<foreverMembers.length;i++){
			custIds += "'"+foreverMembers[i].custId+"',";
		}
		
		if(custIds.length>0){
			custIds = custIds.substring(0,custIds.length-1);
		}
		
		
		Report.LoadDataFromURL("gridReport/data/jsonMakeCard.jsp?custIds="+custIds);
  	    Report.Print(true);
	}
	
	
	
}

