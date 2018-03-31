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
        来源详情
    </h1>
</section>
<section class="content">
    <div class="row">
        <div class="box box-solid">
            <div class="box-header with-border">
                <h3 class="box-title">基本信息</h3>
            </div>
            <div class="box-body">
                <table class="table table-condensed">
                    <thead>
                    <tr>
                        <th>属性</th>
                        <th>值</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>ID</td>
                        <td>${source.id}</td>
                    </tr>
                    <tr>
                        <td>名称</td>
                        <td>${source.name}</td>
                    </tr>
                    <tr>
                        <td>URL</td>
                        <td>${source.url}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="box-footer">
                <a href="source/edit?id=${source.id}">
                    <button class="btn btn-info">编辑</button>
                </a>
                <a href="source/delete?id=${source.id}">
                    <button class="btn btn-danger">删除</button>
                </a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="box box-solid">
            <div class="box-header">
                <h3 class="box-title">包含的相册</h3>
            </div>
            <div class="box-body">
                <table id="example1" class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>标题</th>
                        <th>简介</th>
                        <th>封面图</th>
                        <th>图片数量</th>
                        <th>原始URL</th>
                        <th>创建时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                        <c:when test="${albums ==  null || fn:length(albums) == 0} ">
                            <tr>
                                <th width="30" colspan="8">暂无数据</th>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="album" items="${albums}">
                                <tr>
                                    <td>${album.id}</td>
                                    <td>${album.title}</td>
                                    <td>${album.intro}</td>
                                    <td><a href="${album.faceUrl}">查看</a></td>
                                    <td>${album.photoNum}</td>
                                    <td><a href="${album.url}">打开</a></td>
                                    <td>${album.createTime}</td>
                                    <td>
                                        <a href="album/detail?id=${album.id}">详情</a>
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
                                <a href="source/detail?id=${source.id}&page=${page-1}">
                                    上一页
                                </a>
                            </li>
                            <li>
                                <a href="source/detail?id=${source.id}&page=${page+1}">
                                    下一页
                                </a>
                            </li>
                        </ul>
                    </div>
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
