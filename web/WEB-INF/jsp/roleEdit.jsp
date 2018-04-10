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
    <link rel="stylesheet" href="../plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="../dist/css/skins/all-skins.min.css">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content-header">
    <h1>
        编辑角色:${role.roleName}
    </h1>
</section>
<section class="content">
    <div class="row">
        <div class="col-md-6">
            <div class="box box-solid">
                <form role="form">
                    <div class="box-body">
                        <input name="id" id="id" value="${role.id}" hidden>
                        <div class="form-group">
                            <label for="roleName">角色名称</label>
                            <input type="text" class="form-control" name="roleName" id="roleName" placeholder="请输入角色名称"
                                   value="${role.roleName}">
                        </div>
                        <div class="form-group">
                            <label for="authorityIds">权限</label>
                            <select class="form-control select2" multiple="multiple" id="authorityIds"
                                    name="authorityIds"
                                    data-placeholder="选择权限"
                                    style="width: 100%;">
                                <c:choose>
                                    <c:when test="${(notHas eq null || fn:length(notHas) eq 0) && (has eq null || fn:length(has) eq 0)}">
                                        <option value="-1" disabled>没有获取到权限列表</option>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach var="h" items="${has}">
                                            <option value="${h.id}" selected>${h.name}</option>
                                        </c:forEach>
                                        <c:forEach items="${notHas}" var="nh">
                                            <option value="${nh.id}">${nh.name}</option>
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

        <div class="col-md-6">
            <div class="box box-solid">
                <div class="box-header">
                    <h4>此角色即将拥有的权限</h4>
                </div>
                <div class="box-body">
                    <table id="table" class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>权限名称</th>
                            <th>URL</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
                <div class="box-footer">
                    <h1 class="text-center" id="loading" hidden><span class="fa fa-refresh fa-spin"></span></h1>
                </div>
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
<script src="../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="../plugins/fastclick/fastclick.js"></script>
<script src="../dist/js/app.min.js"></script>
<script src="../plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="../plugins/chartjs/Chart.min.js"></script>
<script src="../plugins/select2/select2.full.min.js"></script>
<script src="../dist/js/online_album.js"></script>

<script>
    var tabId = top.getActivePageId();
    <c:choose>
    <c:when test="${role eq null}">
    showNotFoundModal(function () {
        closeTab(tabId, 2000);
    });
    </c:when>
    <c:otherwise>


    function loadAuth(table) {
        $.ajax({
            type: "post",
            url: "authority/detail.json",
            data: {authorityIds: $("#authorityIds").val()},
            beforeSend: function () {
                table.clear().draw();
                $("#loading").show();
            },
            success: function (data, status) {
                $(data.result).each(function (index, item) {
                    table.row.add([
                        item.id,
                        item.name,
                        item.url
                    ]).draw(false);
                });
                $("#loading").hide();
            },
            error: function () {
                alert("请求失败");
            }
        });
    }

    $("#submit").click(function () {
        $.post("role/update",
            {
                id: $("#id").val(),
                roleName: $("#roleName").val(),
                authorityIds: $("#authorityIds").val()
            },
            function (data, status) {
                resultHandlerCloseTab(data, status, tabId);
            });
    });

    $(function () {
        var table = $('#table').DataTable(
            {
                "paging": true,
                "lengthChange": true,
                "searching": true,
                "ordering": true,
                "info": true,
                "autoWidth": true,
                language: {
                    url: "../plugins/datatables/Chinese.json"
                }
            }
        );
        loadAuth(table);
        $("#authorityIds").select2({
            closeOnSelect: false
        }).on("change", function (e) {
            loadAuth(table);
        });
    });
    </c:otherwise>
    </c:choose>
</script>
</body>
</html>
