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
    <link rel="stylesheet" href="../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="../dist/css/skins/all-skins.min.css">
    <link rel="stylesheet" href="../plugins/datatables/dataTables.bootstrap.css">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content-header">
    <h1>
        日志管理
    </h1>
</section>
<section class="content">
    <div class="row">
        <div class="box box-solid">
            <div class="box-body">
                <table class="table table-hover" id="table">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>权限名称</th>
                        <th>权限URL</th>
                        <th>请求方式</th>
                        <th>请求时间</th>
                        <th>执行用户</th>
                        <th>来源IP</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                        <c:when test="${logs ==  null || fn:length(logs) == 0} ">
                            <tr>
                                <th width="30" colspan="3">暂无数据</th>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="log" items="${logs}">
                                <tr>
                                    <td>${log.id}</td>
                                    <td>${log.authority.name}</td>
                                    <td>${log.authority.url}</td>
                                    <td>${log.method}</td>
                                    <td>${log.reqTime}</td>
                                    <td>${log.user eq null?'匿名者':log.user.username}</td>
                                    <td>${log.sourceIP}</td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>
            </div>
            <div class="box-footer">
                <button type="button" class="btn btn-danger" id="clear">清空日志</button>
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
<script src="../plugins/fastclick/fastclick.js"></script>
<script src="../dist/js/app.min.js"></script>
<script src="../plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="../plugins/chartjs/Chart.min.js"></script>
<script src="../dist/js/online_album.js"></script>
<script src="../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../plugins/datatables/dataTables.bootstrap.min.js"></script>
</body>
<script>
    var tabId = top.getActivePageId();
    $(document).ready(function () {
        $('#table').DataTable(
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
    $("#clear").click(function (e) {
        if (confirm('确认要清空日志吗?此操作会被记录')) {
            $.get('log/clear', {}, function (data, status) {
                    resultHandlerRefreshTab(data, status, tabId);
                }
            );
        }
    });
</script>
</html>
