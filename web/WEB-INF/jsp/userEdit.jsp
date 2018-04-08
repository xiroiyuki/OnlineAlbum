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
    <link rel="stylesheet" href="../plugins/select2/select2.min.css">
    <link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="../dist/css/skins/all-skins.min.css">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content-header">
    <h1>
        编辑用户:${ user.username}
    </h1>
</section>
<section class="content">
    <div class="row">
        <div class="col-md-4">
            <div class="box box-solid">
                <form role="form">
                    <div class="box-body">
                        <input name="id" id="id" value="${user.id}" hidden>
                        <div class="form-group">
                            <label for="username">用户名</label>
                            <input type="text" class="form-control" name="username" id="username" placeholder="请输入新用户名"
                                   value="${ user.username}">
                        </div>
                        <div class="form-group">
                            <label for="password">密码</label>
                            <input type="text" class="form-control" name="password" id="password"
                                   value="${user.password}"
                                   placeholder="请输入新密码">
                        </div>
                        <div class="form-group">
                            <label for="roleId">角色</label>
                            <select class="form-control select2" id="roleId" style="width: 100%;">
                                <c:forEach items="${roles}" var="role">
                                    <option value="${role.id}" ${user.role.id eq role.id ?"selected":"" }>${role.roleName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="state">状态</label>
                            <select class="form-control select2" id="state" style="width: 100%;">
                                <option selected="selected" value="1">正常</option>
                                <option value="0">锁定</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="remark">备注</label>
                            <input type="text" class="form-control" name="remark" id="remark" placeholder="请输入备注"
                                   value="${user.remark}">
                        </div>
                    </div>
                    <div class="box-footer">
                        <button type="button" id="submit" class="btn btn-primary">提交</button>
                    </div>
                </form>
            </div>
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
<script src="../plugins/select2/select2.full.min.js"></script>
<script src="../dist/js/online_album.js"></script>

</body>

<script>
    var tabId = top.getActivePageId();
    <c:choose>
    <c:when test="${user eq null}">
    showNotFoundModal(function () {
        closeTab(tabId, 2000);
    });
    </c:when>
    <c:otherwise>

    $("#submit").click(function () {
        $.post("user/update",
            {
                id: $("#id").val(),
                username: $("#username").val(),
                password: $("#password").val(),
                roleId: $("#roleId").val(),
                state: $("#state").val(),
                remark: $("#remark").val()
            },
            function (data, status) {
                resultHandlerCloseTab(data, status, tabId);
            });
    });
    $(function () {
        $(".select2").select2();
    });
    </c:otherwise>
    </c:choose>
</script>

</html>
