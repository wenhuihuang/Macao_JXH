<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<style>
	.papers-block{
		width:420px;
		border:1px solid #ccc;
		text-align:center;
		padding:10px 0;
	}
	.papers-block #preview{
		width:400px;
		height:250px;
		margin:8px auto;
		border:1px solid #ccc;
	}
	.papers-block #preview img{
		width:100%;
		height:100%;
	}
</style>
<script type="text/javascript">
	function upFile(id){
		$("#"+id).click()
	}
    //图片上传预览    IE是用了滤镜。
    function previewImage(file)
    {
      var MAXWIDTH  = 260; 
      var MAXHEIGHT = 180;
      var div = document.getElementById('preview');
      if (file.files && file.files[0])
      {
          div.innerHTML ='<img id=imghead>';
          var img = document.getElementById('imghead');
          img.onload = function(){
          	
          }
          var reader = new FileReader();
          reader.onload = function(evt){img.src = evt.target.result;}
          reader.readAsDataURL(file.files[0]);
      }
      else //兼容IE
      {
        var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
        file.select();
        var src = document.selection.createRange().text;
        div.innerHTML = '<img id=imghead>';
        var img = document.getElementById('imghead');
        img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
        var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
        status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
        div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
      }
    }
    function clacImgZoomParam( maxWidth, maxHeight, width, height ){
        var param = {top:0, left:0, width:width, height:height};
        if( width>maxWidth || height>maxHeight )
        {
            rateWidth = width / maxWidth;
            rateHeight = height / maxHeight;
             
            if( rateWidth > rateHeight )
            {
                param.width =  maxWidth;
                param.height = Math.round(height / rateWidth);
            }else
            {
                param.width = Math.round(width / rateHeight);
                param.height = maxHeight;
            }
        }
         
        param.left = Math.round((maxWidth - param.width) / 2);
        param.top = Math.round((maxHeight - param.height) / 2);
        return param;
    }
	$(function(){
		ligerForm("form1");
	})        
</script>
</head>
<body style="overflow-x:hidden; padding:2px;">
	<form name="form1" id="form1"  method='post' enctype='multipart/form-data'>
		 <div class="papers-block">
		 	<div class="inline-group">
		 		<label>證件名稱：</label>
		 		<input width="120px" type="text" ltype="text">
		 		<label>證件有效期：</label>
		 		<input width="120px" type="text" ltype="date">
		 		<input type="file" id="file1" value="上傳" style="display:none;" onchange="previewImage(this)">
		 	</div>
		 <div id="preview">
		    <%-- <img id="imghead" width=100 height=100 border=0 src='<%=request.getContextPath()%>/images/defaul.jpg'> --%>
		</div>
		 	<div>
		 		<a class="btn" onclick="upFile('file1')">上傳</a>
		 		<a class="btn">刪除</a>
		 		<a class="btn">移動</a>
		 	</div>
		 </div>
	</form>
</body>
</html>
