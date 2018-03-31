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
    <title>AdminLTE 2 | Dashboard</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <!-- Pace -->
    <link rel="stylesheet" href="../plugins/pace-master/themes/blue/pace-theme-flash.css">
    <script type="text/javascript" src="../plugins/pace-master/pace.min.js"></script>
    <!-- Bootstrap 3.3.6 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../dist/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../dist/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="../plugins/datatables/dataTables.bootstrap.css">
    <!-- jvectormap -->
    <link rel="stylesheet" href="../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="../dist/css/skins/all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        相册详情
    </h1>
</section>
<!-- Main content -->
<section class="content">
    <div class="row">
        <div class="box box-solid">
            <div class="box-header with-border">
                <h3 class="box-title">基本信息</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
                <div class="row">
                    <div class="col-md-6">
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
                                <td>${album.id}</td>
                            </tr>
                            <tr>
                                <td>标题</td>
                                <td>${album.title}</td>
                            </tr>
                            <tr>
                                <td>简介</td>
                                <td>${album.intro}</td>
                            </tr>
                            <tr>
                                <td>封面</td>
                                <td>${album.faceUrl}</td>
                            </tr>
                            <tr>
                                <td>相片数量</td>
                                <td>${album.photoNum}</td>
                            </tr>
                            <tr>
                                <td>URL</td>
                                <td>${album.url}</td>
                            </tr>
                            <tr>
                                <td>创建时间</td>
                                <td>${album.url}</td>
                            </tr>
                            <tr>
                                <td>来源</td>
                                <td>${album.sourceId}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!-- /.box-body -->
            <div class="box-footer">
                <a href="album/edit?id=${album.id}">
                    <button class="btn btn-info">编辑</button>
                </a>
                <a href="album/delete?id=${album.id}">
                    <button class="btn btn-danger">删除</button>
                </a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="box box-solid">
            <div class="box-header">
                <h3 class="box-title">包含的相片</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
                <table id="example1" class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>URL</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                        <c:when test="${photos ==  null || fn:length(photos) == 0} ">
                            <tr>
                                <th width="30" colspan="8">暂无数据</th>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="photo" items="${photos}">
                                <tr>
                                    <td>${photo.id}</td>
                                    <td><a href="${photo.url}">查看</a></td>
                                    <td>
                                        <a href="photo/detail?id=${photo.id}">详情</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>
            </div>
            <div class="box-footer">
                <div class="row">
                    <div class="col-md-4 pull-right">
                        <ul class="pagination">
                            <li>
                                <a href="album/detail?id=${album.id}&page=${page-1}">
                                    上一页
                                </a>
                            </li>
                            <li>
                                <a href="album/detail?id=${album.id}&page=${page+1}">
                                    下一页
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /.box-body -->

</section>
<!-- /.content -->

<!-- jQuery 2.2.3 -->
<script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- FastClick -->
<script src="../plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../dist/js/app.min.js"></script>
<!-- Sparkline -->
<script src="../plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- SlimScroll 1.3.0 -->
<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- ChartJS 1.0.1 -->
<script src="../plugins/chartjs/Chart.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<%--<script src="../dist/js/pages/dashboard2.js"></script>--%>
<!-- AdminLTE for demo purposes -->
<%--<script src="../dist/js/demo.js"></script>--%>
<script>
    $(document).ready(function () {
        $('#example1').DataTable(
            {
                "paging": false,
                "lengthChange": false,
                "searching": true,
                "ordering": true,
                "info": false,
                "autoWidth": true
            }
        );
    });
</script>
</body>
</html>
