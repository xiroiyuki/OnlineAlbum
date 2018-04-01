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
        相册详情
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
                                <td>图片数量</td>
                                <td>${album.photoNum}</td>
                            </tr>
                            <tr>
                                <td>URL</td>
                                <td>${album.url}</td>
                            </tr>
                            <tr>
                                <td>创建时间</td>
                                <td>${album.createTime}</td>
                            </tr>
                            <tr>
                                <td>来源</td>
                                <td>${album.sourceId}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="box-footer">
                    <a href="javascript:createNewTab('album/edit?id=${album.id}','编辑相册 ${album.title}')">
                        <button class="btn btn-info">编辑</button>
                    </a>
                    <button class="btn btn-danger" id="delete">删除</button>
                </div>
            </div>
        </div>
        <div class="col-md-8">
            <div class="box box-solid">
                <div class="box-header with-border">
                    <h3 class="box-title">封面</h3>
                </div>
                <div class="box-body">
                    <img src="${album.faceUrl}" class="img-bordered img-responsive">
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="box box-solid">
            <div class="box-header">
                <h3 class="box-title">包含的图片</h3>
            </div>
            <div class="box-body">
                <table id="photoTable" class="table table-bordered table-striped">
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
                                        <a href="javascript:createNewTab('photo/detail?id=${photo.id}','图片 ${photo.id}')">详情</a>
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
<script src="../dist/js/online_album.js"></script>
<script>
    var tabId = top.getActivePageId();
    $("#delete").click(function (e) {
        $.get(
            'album/delete', {id:${album.id}}, function (data, status) {
                console.log("Data: " + data.result + "\nStatus: " + status);
                if (data.result) {
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
            }
        );
    });

    $(document).ready(function () {
        $('#photoTable').DataTable(
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
