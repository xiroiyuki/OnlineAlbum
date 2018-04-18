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
        概况
    </h1>
</section>
<section class="content">
    <div class="row">
        <div class="col-md-4">
            <div class="box box-solid">
                <div class="box-header">
                    <h3 class="box-title">数据量</h3>
                </div>
                <div class="box-body">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>项目</th>
                            <th>值</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>来源数</td>
                            <td>23</td>
                        </tr>
                        <tr>
                            <td>相册数</td>
                            <td>12</td>
                        </tr>
                        <tr>
                            <td>图片数</td>
                            <td>535</td>
                        </tr>
                        <tr>
                            <td>用户数</td>
                            <td>123</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="small-box bg-green">
                <div class="inner">
                    <h3>53</h3>
                    <p>今日访问次数</p>
                </div>
                <div class="icon">
                    <i class="ion ion-stats-bars"></i>
                </div>
            </div>
            <div class="small-box bg-aqua">
                <div class="inner">
                    <h3>150</h3>
                    <p>新用户</p>
                </div>
                <div class="icon">
                    <i class="ion ion-person-add"></i>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="box box-solid">
                <div class="box-header">
                    <h3 class="box-title">日趋势</h3>
                </div>
                <div class="box-body">
                    <div class="box-body">
                        <div id="daily" class="col-md-12" style="height:400px;">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="box box-solid">
                <div class="box-header with-border">
                    <h3 class="box-title">周趋势</h3>
                </div>
                <div class="box-body">
                    <div class="box-body">
                        <div id="weekly" style="width: 600px;height:400px;">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="box box-solid">
                <div class="box-header">
                    <h3 class="box-title">月趋势</h3>
                </div>
                <div class="box-body">
                    <div class="box-body">
                        <div id="monthly" style="width: 600px;height:400px;">
                        </div>
                    </div>
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
<script src="https://cdn.bootcss.com/echarts/4.0.4/echarts.min.js"></script>
</body>
<script>
    // 基于准备好的dom，初始化echarts实例
    var dailyChart = echarts.init($("#daily").get(0));
    var weeklyChart = echarts.init($("#weekly").get(0));
    var monthlyChart = echarts.init($("#monthly").get(0));
    // 指定图表的配置项和数据
    var weeklyOption = {
        xAxis: {
            type: 'category',
            data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [
                <c:forEach items="${weeklyKey}" var="item">
                ${weekly[item]},
                </c:forEach>
            ],
            type: 'line'
        }]
    };
    var dailyOption = {
        xAxis: {
            type: 'category',
            data: [
                '0:00', '1:00', '2:00', '3:00', '4:00', '5:00',
                '6:00', '7:00', '8:00', '9:00', '10:00', '11:00',
                '12:00', '13:00', '14:00', '15:00', '16:00', '17:00',
                '18:00', '19:00', '20:00', '21:00', '22:00', '23:00'
            ]
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [0],
            type: 'line'
        }]
    };
    var monthlyOption = {
        xAxis: {
            type: 'category',
            data: [
                '1', '2', '3', '4', '5', '6',
                '7', '8', '9', '10', '11', '12',
                '13', '14', '15', '16', '17', '18',
                '19', '20', '21', '22', '23', '24',
                '25', '26', '27', '28', '29', '30', '31'
            ]
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [0],
            type: 'line'
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    dailyChart.setOption(dailyOption);
    weeklyChart.setOption(weeklyOption);
    monthlyChart.setOption(monthlyOption);

</script>

</html>
