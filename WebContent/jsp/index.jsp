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
<title>主页</title>
<script type="text/javascript">

        var tab = null;
        var accordion = null;
        var tree = null;
        var tabItems = [];
        $(function ()
        {

            //布局
            $("#layout1").ligerLayout({ leftWidth: 190, height: '100%',heightDiff:-32,space:4, onHeightChanged: f_heightChanged });

            var height = $(".l-layout-center").height();

            //Tab
            $("#framecenter").ligerTab({
                height: height,
                showSwitchInTab : true,
                showSwitch: true,
                onAfterAddTabItem: function (tabdata)
                {
                    tabItems.push(tabdata);
                    saveTabStatus();
                },
                onAfterRemoveTabItem: function (tabid)
                { 
                    for (var i = 0; i < tabItems.length; i++)
                    {
                        var o = tabItems[i];
                        if (o.tabid == tabid)
                        {
                            tabItems.splice(i, 1);
                            saveTabStatus();
                            break;
                        }
                    }
                },
                onReload: function (tabdata)
                {
                    var tabid = tabdata.tabid;
                    addFrameSkinLink(tabid);
                }
            });

            //面板
            $("#accordion1").ligerAccordion({
                height: height - 32, speed: null
            });

            $(".l-link").hover(function ()
            {
                $(this).addClass("l-link-over");
            }, function ()
            {
                $(this).removeClass("l-link-over");
            });
            //树
            $("#tree1").ligerTree({
                data : indexdata,
                checkbox: false,
                slide: false,
                nodeWidth: 120,
                attribute: ['nodename', 'url'],
                render : function(a){
                    if (!a.isnew) return a.text;
                    return '<a href="' + a.url + '" target="_blank">' + a.text + '</a>';
                },
                onSelect: function (node)
                {
                    if (!node.data.url) return;
                    if (node.data.isnew)
                    { 
                        return;
                    }
                    var tabid = $(node.target).attr("tabid");
                    if (!tabid)
                    {
                        tabid = new Date().getTime();
                        $(node.target).attr("tabid", tabid)
                    } 
                    f_addTab(tabid, node.data.text, node.data.url);
                }
            });

            function openNew(url)
            { 
                var jform = $('#opennew_form');
                if (jform.length == 0)
                {
                    jform = $('<form method="post" />').attr('id', 'opennew_form').hide().appendTo('body');
                } else
                {
                    jform.empty();
                } 
                jform.attr('action', url);
                jform.attr('target', '_blank'); 
                jform.trigger('submit');
            };


            tab = liger.get("framecenter");
            accordion = liger.get("accordion1");
            tree = liger.get("tree1");
            $("#pageloading").hide();

            css_init();
            pages_init();
        });
        function f_heightChanged(options)
        {  
            if (tab)
                tab.addHeight(options.diff);
            if (accordion && options.middleHeight - 24 > 0)
                accordion.setHeight(options.middleHeight - 24);
        }
        function f_addTab(tabid, text, url)
        {
            tab.addTabItem({
                tabid: tabid,
                text: text,
                url: url,
                callback: function ()
                {
                    //addShowCodeBtn(tabid); 
                    addFrameSkinLink(tabid); 
                }
            });
        }
        function addShowCodeBtn(tabid)
        {
            var viewSourceBtn = $('<a class="viewsourcelink" href="javascript:void(0)">查看源码</a>');
            var jiframe = $("#" + tabid);
            viewSourceBtn.insertBefore(jiframe);
            viewSourceBtn.click(function ()
            {
                showCodeView(jiframe.attr("src"));
            }).hover(function ()
            {
                viewSourceBtn.addClass("viewsourcelink-over");
            }, function ()
            {
                viewSourceBtn.removeClass("viewsourcelink-over");
            });
        }
        function showCodeView(src)
        {
            $.ligerDialog.open({
                title : '源码预览',
                url: 'dotnetdemos/codeView.aspx?src=' + src,
                width: $(window).width() *0.9,
                height: $(window).height() * 0.9
            });

        }
        function addFrameSkinLink(tabid)
        {
            var prevHref = getLinkPrevHref(tabid) || "";
            var skin = getQueryString("skin");
            if (!skin) return;
            skin = skin.toLowerCase();
            attachLinkToFrame(tabid, prevHref + skin_links[skin]);
        }
        var skin_links = {
            "aqua": "lib/ligerUI/skins/Aqua/css/ligerui-all.css",
            "gray": "lib/ligerUI/skins/Gray/css/all.css",
            "silvery": "lib/ligerUI/skins/Silvery/css/style.css",
            "gray2014": "lib/ligerUI/skins/Gray2014/css/all.css"
        };
        function pages_init()
        {
            var tabJson = $.cookie('liger-home-tab'); 
            if (tabJson)
            { 
                var tabitems = JSON2.parse(tabJson);
                for (var i = 0; tabitems && tabitems[i];i++)
                { 
                    f_addTab(tabitems[i].tabid, tabitems[i].text, tabitems[i].url);
                } 
            }
        }
        function saveTabStatus()
        { 
            $.cookie('liger-home-tab', JSON2.stringify(tabItems));
        }
        function css_init()
        {
            var css = $("#mylink").get(0), skin = getQueryString("skin");
            $("#skinSelect").val(skin);
            $("#skinSelect").change(function ()
            { 
                if (this.value)
                {
                    location.href = "jsp/index.jsp?skin=" + this.value;
                } else
                {
                    location.href = "jsp/index.jsp";
                }
            });

           
            if (!css || !skin) return;
            skin = skin.toLowerCase();
            $('body').addClass("body-" + skin); 
            $(css).attr("href", skin_links[skin]); 
        }
        function getQueryString(name)
        {
            var now_url = document.location.search.slice(1), q_array = now_url.split('&');
            for (var i = 0; i < q_array.length; i++)
            {
                var v_array = q_array[i].split('=');
                if (v_array[0] == name)
                {
                    return v_array[1];
                }
            }
            return false;
        }
        function attachLinkToFrame(iframeId, filename)
        { 
            if(!window.frames[iframeId]) return;
            var head = window.frames[iframeId].document.getElementsByTagName('head').item(0);
            var fileref = window.frames[iframeId].document.createElement("link");
            if (!fileref) return;
            fileref.setAttribute("rel", "stylesheet");
            fileref.setAttribute("type", "text/css");
            fileref.setAttribute("href", filename);
            head.appendChild(fileref);
        }
        function getLinkPrevHref(iframeId)
        {
            if (!window.frames[iframeId]) return;
            var head = window.frames[iframeId].document.getElementsByTagName('head').item(0);
            var links = $("link:first", head);
            for (var i = 0; links[i]; i++)
            {
                var href = $(links[i]).attr("href");
                if (href && href.toLowerCase().indexOf("ligerui") > 0)
                {
                    return href.substring(0, href.toLowerCase().indexOf("lib") );
                }
            }
        }
 </script> 
<style type="text/css"> 
    body,html{height:100%;}
    body{ padding:0px; margin:0;   overflow:hidden;}  
    .l-link{ display:block; height:26px; line-height:26px; padding-left:10px; text-decoration:underline; color:#333;}
    .l-link2{text-decoration:underline; color:white; margin-left:2px;margin-right:2px;}
    .l-layout-top{background:#102A49; color:White;}
    .l-layout-bottom{ background:#E5EDEF; text-align:center;}
    #pageloading{position:absolute; left:0px; top:0px; background:white url('loading.gif') no-repeat center; width:100%; height:100%;z-index:99999;}
    .l-link{ display:block; line-height:22px; height:22px; padding-left:16px;border:1px solid white; margin:4px;}
    .l-link-over{ background:#FFEEAC; border:1px solid #DB9F00;} 
    .l-winbar{ background:#2B5A76; height:30px; position:absolute; left:0px; bottom:0px; width:100%; z-index:99999;}
    .space{ color:#E7E7E7;}
    /* 顶部 */ 
    .l-topmenu{ margin:0; padding:0; height:31px; line-height:31px; background:url('lib/images/top.jpg') repeat-x bottom;  position:relative; border-top:1px solid #1D438B;  }
    .l-topmenu-logo{ color:#E7E7E7; padding-left:35px; line-height:26px;background:url('lib/images/topicon.gif') no-repeat 10px 5px;}
    .l-topmenu-welcome{  position:absolute; height:24px; line-height:24px;  right:30px; top:2px;color:#070A0C;}
    .l-topmenu-welcome a{ color:#E7E7E7; text-decoration:underline} 
     .body-gray2014 #framecenter{
        margin-top:3px;
    }
      .viewsourcelink {
         background:#B3D9F7;  display:block; position:absolute; right:10px; top:3px; padding:6px 4px; color:#333; text-decoration:underline;
    }
    .viewsourcelink-over {
        background:#81C0F2;
    }
    .l-topmenu-welcome label {color:white;
    }
    #skinSelect {
        margin-right: 6px;
    }
 </style>
</head>
<body style="padding:0px;background:#EAEEF5;">  
<div id="pageloading"></div>  
<div id="topmenu" class="l-topmenu">
    <div class="l-topmenu-logo">會員管理系統</div>
    <div class="l-topmenu-welcome">
        <label> 皮肤切换：</label>
        <select id="skinSelect">
            <option value="aqua">默认</option> 
            <option value="silvery">Silvery</option>
            <option value="gray">Gray</option>
            <option value="gray2014">Gray2014</option>
        </select>
    </div> 
</div>
  <div id="layout1" style="width:99.2%; margin:0 auto; margin-top:4px; "> 
        <div position="left"  title="菜单" id="accordion1"> 
                     <div title="基礎" class="l-scroll">
                          <!-- <ul id="tree1" style="margin-top:3px;">  -->
                         <a class="l-link" href="javascript:f_addTab('customer','會員資料列表','jsp/customer/list.jsp')">會員資料</a>
                         <a class="l-link" href="javascript:f_addTab('papers','證件管理','jsp/customer/papers_list.jsp')">證件管理</a>
                         <a class="l-link" href="javascript:f_addTab('Users','用戶及權限管理','jsp/customer/Users_ShowList.jsp')">用戶及權限管理</a>
                    </div>
                    <div title="社工個案">
                    <div style=" height:7px;"></div>
                         <a class="l-link" href="javascript:f_addTab('custCase','個案列表','jsp/custCase/list.jsp')">個案</a> 
                        <a class="l-link" href="javascript:f_addTab('socialWork','社工資料列表','jsp/manage/socialWork_list.jsp')">社工資料</a>  
                    </div>    
                     <div title="治療">
                    <div style=" height:7px;"></div>
                          <a class="l-link" href="javascript:f_addTab('language','語言治療列表','jsp/treatment/language_list.jsp')">語言治療</a>
                          <a class="l-link" href="javascript:f_addTab('job','職業治療列表','jsp/treatment/job_list.jsp')">職業治療</a>
                          <a class="l-link" href="javascript:f_addTab('physics','物理治療列表','jsp/treatment/physics_list.jsp')">物理治療</a>
                          <a class="l-link" href="javascript:f_addTab('special','特殊教育治療及IEP列表','jsp/treatment/special_list.jsp')">特殊教育及IEP</a> 
                          <a class="l-link" href="javascript:f_addTab('function','職能訓練列表','jsp/treatment/function_list.jsp')">職能訓練</a>
                          <a class="l-link" href="javascript:f_addTab('collocation','暫托服務列表','jsp/treatment/collocation_list.jsp')">暫托服務</a> 
                    </div> 
                     <div title="院舍管理">
                    <div style=" height:7px;"></div>
                          <a class="l-link" href="javascript:f_addTab('dormitory','院舍管理列表','jsp/manage/dormitory_list.jsp')">院舍管理</a>
                          <a class="l-link" href="javascript:f_addTab('medical','醫護記錄列表','jsp/manage/medical_list.jsp')">醫護記錄</a>
                          <a class="l-link" href="javascript:f_addTab('groupSetting','小組設定列表','jsp/manage/groupSetting_list.jsp')">小組設定</a>
                          <a class="l-link" href="javascript:f_addTab('groupRecord','小組記錄列表','jsp/manage/groupRecord_list.jsp')">小組記錄</a> 
                          <a class="l-link" href="javascript:f_addTab('courseSetting','課程設定列表','jsp/manage/courseSetting_list.jsp')">課程設定</a>
                          <a class="l-link" href="javascript:f_addTab('carSetting','校車支援列表','jsp/manage/carSetting_list.jsp')">校車支援</a>
                          <a class="l-link" href="javascript:f_addTab('activity','活動設定列表','jsp/manage/activity_list.jsp')">活動設定</a>
                          <a class="l-link" href="javascript:f_addTab('familySupport','家庭支援列表','jsp/manage/familySupport_list.jsp')">家庭支援</a>
                          <a class="l-link" href="javascript:f_addTab('message','信息平臺列表','jsp/manage/SmsSend_ShowList.jsp')">信息平臺</a>
                          <a class="l-link" href="javascript:f_addTab('chargeRecord','收費記錄列表','jsp/manage/chargeRecord_list.jsp')">收費記錄</a> 
                          <a class="l-link" href="javascript:f_addTab('statistics','統計報表','jsp/manage/statistics_list.jsp')">統計報表</a>
                    </div> 
        </div>
        <div position="center" id="framecenter"> 
            <div tabid="home" title="我的主页" style="height:300px" >
                <iframe frameborder="0" name="home" id="home" src="jsp/home/home.jsp"></iframe>
            </div> 
        </div> 
        
    </div>
    <div  style="height:32px; line-height:32px; text-align:center;">
            <!-- Copyright ©  -->
    </div>
    <div style="display:none"></div>
</body>
</html>
