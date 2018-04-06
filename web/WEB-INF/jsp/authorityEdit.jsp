<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <link rel="stylesheet" href="../plugins/select2/select2.min.css">
    <link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="../dist/css/skins/all-skins.min.css">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content-header">
    <h1>
        编辑权限:${authority.name}
    </h1>
</section>
<section class="content">
    <div class="row">
        <div class="box box-solid">
            <form role="form">
                <div class="box-body">
                    <input name="id" id="id" value="${authority.id}" hidden>
                    <div class="form-group">
                        <label for="name">权限名称</label>
                        <input type="text" class="form-control" name="name" id="name" placeholder="请输入新名称"
                               value="${authority.name}">
                    </div>
                    <div class="form-group">
                        <label for="url">URL</label>
                        <input type="text" class="form-control" name="url" id="url" placeholder="请输入新URL"
                               value="${authority.url}">
                    </div>
                    <div class="form-group">
                        <label for="roleIds">分配给用户</label>
                        <select class="form-control select2" multiple="multiple" id="roleIds" name="roleIds"
                                data-placeholder="选择用户"
                                style="width: 100%;">
                            <c:choose>
                                <c:when test="${(notHas eq null || fn:length(notHas) eq 0) && (has eq null || fn:length(has) eq 0)}">
                                    <option value="-1" disabled>没有获取到权限列表</option>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach var="h" items="${has}">
                                        <option value="${h.id}" selected>${h.roleName}</option>
                                    </c:forEach>
                                    <c:forEach items="${notHas}" var="nh">
                                        <option value="${nh.id}">${nh.roleName}</option>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </select>
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
<script src="../plugins/select2/select2.full.min.js"></script>

<script>
    var tabId = top.getActivePageId();
    $("#submit").click(function () {
        $.post("authority/update",
            {
                id: $("#id").val(),
                name: $("#name").val(),
                url: $("#url").val(),
                roleIds: $("#roleIds").val()
            },
            function (data, status) {
                console.log("Data: " + data.result + "\nStatus: " + status);
                if (data.result) {
                    $("#submit").attr('disabled', "true");
                    $('#resModal').addClass('modal-success');
                    $('#resModal').removeClass('modal-danger');
                    $("#modalMsg").text(data.msg);
                    $('#resModal').modal('show');
                    setTimeout(function () {
                        top.closeTabByPageId(tabId);
                    }, 2000);
                } else {
                    $('#resModal').removeClass('modal-success');
                    $('#resModal').addClass('modal-danger');
                    $("#modalMsg").text(data.msg);
                    $('#resModal').modal('show');
                }
            });
    });
    $(function () {
        $(".select2").select2({
            closeOnSelect: false
        });
    });
</script>
</body>
</html>
