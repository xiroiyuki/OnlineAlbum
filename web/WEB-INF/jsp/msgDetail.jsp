<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/tags" prefix="date" %>

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
    <link rel="stylesheet" href="../plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="../dist/css/skins/all-skins.min.css">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content-header">
    <h1>
        消息详情
    </h1>
</section>
<section class="content">
    <div class="row">
        <div class="col-md-4">
            <div class="box box-solid">
                <div class="box-header with-border">
                    <h3 class="box-title">基本信息</h3>
                </div>
                <div class="box-body">
                    <div class="row">
                        <table class="table table-condensed table-hover">
                            <thead>
                            <tr>
                                <th>属性</th>
                                <th>值</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>ID</td>
                                <td>${msg.id}</td>
                            </tr>
                            <tr>
                                <td>标题</td>
                                <td>${msg.title}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="box-footer">
                    <a href="javascript:createNewTab('message/edit?id=${msg.id}',43${msg.id},'编辑消息 ${msg.title}')">
                        <button class="btn btn-info">编辑</button>
                    </a>
                    <button class="btn btn-danger" id="delete">删除</button>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="box box-solid">
                <div class="box-header with-border">
                    <h3 class="box-title">消息内容</h3>
                </div>
                <div class="box-body">
                    <p>
                        ${msg.content}
                    </p>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="resModal" data-backdrop="false">
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
<script src="../dist/js/online_album.js"></script>
<script>
    var tabId = top.getActivePageId();
    <c:choose>
    <c:when test="${msg eq null}">
    showNotFoundModal(function () {
        closeTab(tabId, 2000);
    });
    </c:when>
    <c:otherwise>

    $("#delete").click(function (e) {
        if (confirm('确认要删除吗?')) {
            $.get('message/delete', {id:${msg.id}}, function (data, status) {
                    resultHandlerCloseTab(data, status, tabId);
                }
            );
        }
    });


    $(document).ready(function () {
        $('#photoTable').DataTable(
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
    });
    </c:otherwise>
    </c:choose>
</script>
</body>
</html>
