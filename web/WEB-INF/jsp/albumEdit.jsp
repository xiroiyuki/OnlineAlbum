<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>OnlineAlbum | Dashboard</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <link rel="stylesheet" href="../plugins/pace-master/themes/blue/pace-theme-flash.css">
    <script type="text/javascript" src="../plugins/pace-master/pace.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../dist/css/font-awesome.min.css">
    <link rel="stylesheet" href="../dist/css/ionicons.min.css">
    <link rel="stylesheet" href="../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="../dist/css/skins/all-skins.min.css">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content-header">
    <h1>
        编辑相册:${album.title}
    </h1>
</section>
<section class="content">
    <div class="row">
        <div class="box box-solid">
            <form role="form">
                <div class="box-body">
                    <input name="id" id="id" value="${album.id}" hidden>
                    <div class="form-group">
                        <label for="title">标题</label>
                        <input type="text" class="form-control" name="title" id="title" placeholder="请输入新标题"
                               value="${album.title}">
                    </div>
                    <div class="form-group">
                        <label for="intro">简介</label>
                        <input type="text" class="form-control" name="intro" id="intro" placeholder="请输入新简介"
                               value="${album.intro}">
                    </div>
                    <div class="form-group">
                        <label for="faceUrl">封面图片</label>
                        <input type="url" class="form-control" name="faceUrl" id="faceUrl"
                               value="${album.faceUrl}"
                               placeholder="请输入新封面图片URL">
                    </div>
                    <div class="form-group">
                        <label for="url">原始URL</label>
                        <input type="url" class="form-control" name="url" id="url" value="${album.url}"
                               placeholder="请输入新原始URL">
                    </div>
                </div>
                <div class="box-footer">
                    <button type="button" id="submit" class="btn btn-primary">提交</button>
                </div>
            </form>
        </div>
    </div>

    <div class="modal fade" id="resModal">
        <div class="modal-dialog  modal-sm">
            <div class="modal-content">
                <div class="modal-body">
                    <p id="modalMsg" class="text-center">One fine body…</p>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="../plugins/fastclick/fastclick.js"></script>
<script src="../dist/js/app.min.js"></script>
<script src="../plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="../plugins/chartjs/Chart.min.js"></script>
<script src="../dist/js/online_album.js"></script>
<script>
    var tabId = top.getActivePageId();
    <c:choose>
    <c:when test="${album eq null}">
    showNotFoundModal(function () {
        closeTab(tabId, 2000);
    });
    </c:when>
    <c:otherwise>
    $("#submit").click(function () {
        $.post("album/update",
            {
                id: $("#id").val(),
                title: $("#title").val(),
                intro: $("#intro").val(),
                faceUrl: $("#faceUrl").val(),
                url: $("#url").val()
            },
            function (data, status) {
                resultHandlerCloseTab(data, status, tabId);
            });
    });

    </c:otherwise>
    </c:choose>
</script>
</body>
</html>
