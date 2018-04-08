<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object obj = session.getAttribute("loginUser");
    if (obj == null) {
        response.sendRedirect("/login");
    }
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>OnlineAlbum | Dashboard</title>
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
<body class="hold-transition skin-yellow sidebar-mini fixed">
<div class="wrapper">
    <header class="main-header">
        <a href="#" class="logo">
            <span class="logo-mini">Album</span>
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
                        ${sessionScope.loginUser.username}
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
        <div class="hidden-xs">
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
                url: "source/list",
                targetType: "iframe-tab"
            },
            {
                id: "9002",
                text: "相册管理",
                icon: "fa fa-folder-open",
                url: "album/list",
                targetType: "iframe-tab"
            },
            {
                id: "9101",
                text: "System",
                icon: "",
                isHeader: true
            },
            {
                id: "9102",
                text: "用户管理",
                icon: "fa fa-user",
                url: "user/list",
                targetType: "iframe-tab"
            },
            {
                id: "9103",
                text: "数据维护",
                icon: "fa fa-database",
                targetType: "iframe-tab"
            },
            {
                id: "9104",
                text: "日志统计",
                icon: "fa fa-book",
                targetType: "iframe-tab"
            },
            {
                id: "9105",
                text: "消息推送",
                icon: "fa fa-wifi",
                children: [
                    {
                        id: "910501",
                        text: "创建消息",
                        url: "message/add",
                        targetType: "iframe-tab",
                        icon: "fa fa-circle-o"
                    },
                    {
                        id: "910502",
                        text: "消息库",
                        url: "message/list",
                        targetType: "iframe-tab",
                        icon: "fa fa-circle-o"
                    },
                    {
                        id: "910503",
                        text: "发布控制",
                        targetType: "iframe-tab",
                        icon: "fa fa-circle-o"
                    }
                ]
            },
            {
                id: "9106",
                text: "权限控制",
                icon: "fa fa-lock",
                children: [
                    {
                        id: "910601",
                        text: "角色管理",
                        url: "role/list",
                        targetType: "iframe-tab",
                        icon: "fa fa-circle-o"
                    },
                    {
                        id: "910602",
                        text: "权限管理",
                        url: "authority/list",
                        targetType: "iframe-tab",
                        icon: "fa fa-circle-o"
                    },
                    {
                        id: "910603",
                        text: "创建角色",
                        url: "role/add",
                        targetType: "iframe-tab",
                        icon: "fa fa-circle-o"
                    },
                    {
                        id: "910604",
                        text: "创建权限",
                        url: "authority/add",
                        targetType: "iframe-tab",
                        icon: "fa fa-circle-o"
                    }
                ]
            }
        ];
        $('.sidebar-menu').sidebarMenu({data: menus});
    });
</script>
</body>
</html>