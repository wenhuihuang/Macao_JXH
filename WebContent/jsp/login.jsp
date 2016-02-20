<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>澳門弱智人士家長協進會後臺管理系統</title>
<meta charset="utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="澳門弱智人士家長協進會後臺管理系統">
<meta http-equiv="description" content="This is my page">


<script>
	


	function check(){
		document.getElementById("form").submit();
	}
</script>

<style>
body{margin:0px; margin:0px; font-size:14px; color:#666; font-family:"",Microsoft YaHei,"Arial Black", Gadget, sans-serif; font-family:Arial, Helvetica, sans-serif;  text-align:justify;  text-justify:inter-ideograph; word-break:break-all; line-height:1.8em; text-align:center; background:url(images/index_02.jpg) repeat-x; background-color:#ffffff;}

input,form, ul, li,dt,dd,dl, h1, h2, h3, h4, h5, h6{padding:0; margin:0px;border:0px;}
ul{list-style:none;}
h1 {font-family:Microsoft YaHei,Arial, Helvetica, sans-serif;;  font-size:20px; color:#666; font-weight:normal; padding-left:5px;}
h2{font-family:Microsoft YaHei; font-size:30px; color:#fff; font-weight:normal;}
p,dt,dd,dl{ margin:0px; padding:0px;}
img{border:none; padding:0px; margin:0px;}

.login-button{ background:url(images/jxh/login-button.jpg) no-repeat; width:393px; height:58px; clear:both;cursor:pointer;}
.login-button:hover{background:url(images/jxh/login-button2.jpg) no-repeat;}
.login{width:393px; height:auto; margin-left:auto; margin-right:auto; text-align:left; padding-top:150px;}
.login-center{width:393px; background:url(images/jxh/login_bg.jpg) repeat-y; padding-left:20px;}
.login-center ul li{clear:both; padding-bottom:10px;}
.remember-me{margin:0; padding:0; float:left;}
.remember-me2{line-height:1.2em;}
.input-text1{height:30px; line-height:37px; width:337px; border:1px solid #cccccc; border-radius:5px; -moz-box-shadow:2px 2px 2px #ededed inset; /* For Firefox3.6+ */-webkit-box-shadow:2px 2px 3px #ededed inset;/* For Chrome5+, Safari5+ */box-shadow:2px 2px 3px #ededed inset; /* For Latest Opera */ color:#333; font-size:14px;}
.input-text1:hover{border:1px solid #c2dde5;}


body {
	background-color:#f6f8f9;
	background-image:none;
}
.login h1 img{ vertical-align:bottom;}
</style>


</head>
<!--   -->
<body onload="">


	
<div class="login">
	<div>
		<div style="float: left;"><img src="images/jxh/logo.png" style="width: 100px;height:100px; margin-left: -30px;"></img></div><div style="float: left; margin-left:80px; margin-top: -60px;"><h1>澳門弱智人士家長協進會管理系統</h1></div>
	</div>
		<form action="User/login.do" method="post" id="form">
		
        <div><img src="images/jxh/login-top.jpg" /></div>
        <div class="login-center">
                <ul>
                        <li> 用戶名:<br />
                                <input name="userCode" type="text" class="input-text1" value="" style="width:320px;padding:0px 8px;"/>
                        </li>
                        <li> 密碼:<br />
                                <input name="password" type="password" class="input-text1" style="width:320px;padding:0px 8px;"/>
                        </li>
                        <li>
                        	<span>${error}</span>
                        </li>                      
                        <li>
                               <%--<input name="remember" type="checkbox" value="1" class="remember-me"/>
                                <span class="fz12 fc999 remember-me2">&nbsp;记住我的登录信息</span>
                        		--%>
                        </li> 
                </ul>
        </div>
        <div><img src="images/jxh/login_bottom.jpg" /></div>
        <input type="submit" value="  " name="do" class="login-button" style="cursor:pointer;" />
     </form>
</div>
	
</body>
</html>
