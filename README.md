# 图片爬虫结果管理后台
本应用可以实现对图片爬虫的管理功能,功能如下
## 1. 主要功能
主要功能设计采用树形结构,即一个来源对应多个相册,一个相册对应多个图片,删除设置为级联删除
1. 爬虫爬取的来源的管理,删改查
2. 图片相册的管理,删改查
3. 图片的管理,删改
## 2. 其他功能
1. 日志记录功能
2. 权限管理功能
3. 消息推送功能(未完成,仅实现登记消息的功能)
4. 表单数据校验
5. 访问权限控制功能
6. 首页数据统计(仅图表,基于总数,分时统计,其他为假数据)
## 3. 采用技术
1. Java 8
2. Spring MVC, Spring, MyBatis
3. 数据校验采用了 hibernate validator
4. 前端界面使用AdminLTE-iframe设计,datatable用于数据展示,echart用于首页图表绘制
5. 数据提交采用了jQuery
6. 数据分页采用了pagehelper(仅集成预留了接口,没有使用)
## 4.配置运行
1. 如果是开发模式需要到spring-mabatis.xml文件,devMode 置为true 可以使得任何用户无视权限执行所有操作
pageSize 用于设置查询出的数据每页有多少条
```
  <!--初始化自定义的应用程序配置-->
    <bean class="cn.fc.context.AlbumContext" id="albumContext">
        <property name="pageSize" value="20"/>
        <property name="devMode" value="false"/>
    </bean>
```
2. 数据库备份文件在sql文件夹中,恢复一下即可
3. 在db.properties 中配置数据库连接信息
4. validationMessage.properties 配置表单校验错误提示信息
## 5.结语
欢迎提出建议意见,发ISSUE/PR给我
演示地址:http://123.206.57.117:8080/ 用户名:test123 密码:111111
