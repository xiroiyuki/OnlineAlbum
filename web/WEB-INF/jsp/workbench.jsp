<%@ page import="cn.fc.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object obj = session.getAttribute("loginUser");
    if (obj == null) {
        response.sendRedirect("/login");
    }
    User user = (User) obj;
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | with iframe</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="dist/css/font-awesome.min.css">
    <link rel="stylesheet" href="dist/css/ionicons.min.css">
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="dist/css/skins/all-skins.min.css">
    <style type="text/css">
        html {
            overflow: hidden;
        }
    </style>
    <script src="plugins/ie9/html5shiv.min.js"></script>
    <script src="plugins/ie9/respond.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini fixed">
<div class="wrapper">
    <header class="main-header">
        <a href="#" class="logo">
            <span class="logo-mini">OnlineAlbum</span>
            <span class="logo-lg">OnlineAlbum</span>
        </a>
        <nav class="navbar navbar-static-top">
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
        </nav>
    </header>
    <aside class="main-sidebar">
        <section class="sidebar">
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>
                        <%=user.getUsername()%>
                    </p>
                </div>
            </div>
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="查找菜单...">
                    <span class="input-group-btn">
                <button type="button" name="search" id="search-btn" class="btn btn-flat" onclick="search_menu()"><i
                        class="fa fa-search"></i>
                </button>
              </span>
                </div>
            </form>
            <ul class="sidebar-menu">
            </ul>
        </section>
    </aside>
    <div class="content-wrapper" id="content-wrapper" style="min-height: 421px;">
        <div class="content-tabs">
            <button class="roll-nav roll-left tabLeft" onclick="scrollTabLeft()">
                <i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs menuTabs tab-ui-menu" id="tab-menu">
                <div class="page-tabs-content" style="margin-left: 0px;">
                </div>
            </nav>
            <button class="roll-nav roll-right tabRight" onclick="scrollTabRight()">
                <i class="fa fa-forward" style="margin-left: 3px;"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown tabClose" data-toggle="dropdown">
                    页签操作<i class="fa fa-caret-down" style="padding-left: 3px;"></i>
                </button>
                <ul class="dropdown-menu dropdown-menu-right" style="min-width: 128px;">
                    <li><a class="tabReload" href="javascript:refreshTab();">刷新当前</a></li>
                    <li><a class="tabCloseCurrent" href="javascript:closeCurrentTab();">关闭当前</a></li>
                    <li><a class="tabCloseAll" href="javascript:closeOtherTabs(true);">全部关闭</a></li>
                    <li><a class="tabCloseOther" href="javascript:closeOtherTabs();">除此之外全部关闭</a></li>
                </ul>
            </div>
            <button class="roll-nav roll-right fullscreen" onclick="App.handleFullScreen()">
                <i class="fa fa-arrows-alt"></i>
            </button>
        </div>
        <div class="content-iframe " style="background-color: #ffffff; ">
            <div class="tab-content " id="tab-content">
            </div>
        </div>
    </div>
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 0.0.1
        </div>
    </footer>
    <div class="control-sidebar-bg"></div>
</div>
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="plugins/fastclick/fastclick.js"></script>
<script src="dist/js/app.js"></script>
<script src="dist/js/app_iframe.js"></script>
<script type="text/javascript">
    /**
     * 本地搜索菜单
     */
    function search_menu() {
        //要搜索的值
        var text = $('input[name=q]').val();
        var $ul = $('.sidebar-menu');
        $ul.find("a.nav-link").each(function () {
            var $a = $(this).css("border", "");
            //判断是否含有要搜索的字符串
            if ($a.children("span.menu-text").text().indexOf(text) >= 0) {
                //如果a标签的父级是隐藏的就展开
                $ul = $a.parents("ul");
                if ($ul.is(":hidden")) {
                    $a.parents("ul").prev().click();
                }
                //点击该菜单
                $a.click().css("border", "1px solid");
            }
        });
    }

    $(function () {
        App.setbasePath("");
        App.setGlobalImgPath("dist/img/");
        addTabs({
            id: '10008',
            title: '欢迎页',
            close: false,
            url: 'welcome',
            urlType: "relative"
        });
        App.fixIframeCotent();
        var menus = [
            {
                id: "9000",
                text: "OnlineAlbum",
                icon: "",
                isHeader: true
            },
            {
                id: "9001",
                text: "来源管理",
                icon: "fa fa-cloud",
                children: [
                    {
                        id: "90011",
                        text: "来源列表",
                        icon: "fa fa-circle-o",
                        url: "source/list",
                        targetType: "iframe-tab"
                    }
                ]
            },
            {
                id: "9002",
                text: "相册管理",
                icon: "fa fa-folder-open",
                children: [
                    {
                        id: "90021",
                        text: "相册列表",
                        icon: "fa fa-circle-o",
                        url: "album/list",
                        targetType: "iframe-tab"
                    },
                    {
                        id: "90022",
                        text: "百度",
                        url: "https://www.baidu.com",
                        targetType: "iframe-tab",
                        icon: "fa fa-circle-o",
                        urlType: 'abosulte'
                    }
                ]
            }
        ];
        $('.sidebar-menu').sidebarMenu({data: menus});
    });
</script>
</body>
</html>