<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>手机品牌列表</title>
    <link href="css/layui.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div style="width: 1000px;margin: 0 auto">
    <table class="layui-table">
        <thead>
        <tr>
            <th>序号</th>
            <th>品牌</th>
            <th>名称</th>
            <th>操作系统</th>
            <th>处理器</th>
            <th>ROM</th>
            <th>RAM</th>
            <th>品牌介绍</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="brand" items="${mobileList}">
            <tr>
                <td>${brand.mobileId}</td>
                <td>${brand.brand.brandName}</td>
                <td>${brand.type}</td>
                <td>${brand.os}</td>
                <td>${brand.cpu}</td>
                <td>${brand.ramSize}G</td>
                <td>${brand.diskSize}G</td>
                <td>${brand.brand.desc}</td>
                <td align="center">
                    <button class="layui-btn layui-btn-xs" onclick="queryOne(${brand.mobileId})">修改</button>
                    <button class="layui-btn layui-btn-xs layui-btn-danger" onclick="isDel(${brand.mobileId})">删除
                    </button>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td align="center" colspan="2">
                <span>总共${dataCount}条数据-当前第${pageNo}/${pageCount}页</span>
            </td>
            <td colspan="6" align="center">
                <ul class="pagination">
                    <li><a href="#">&laquo;</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&raquo;</a></li>
                </ul>
            </td>
            <td align="center">
                <button class="layui-btn layui-btn-xs layui-btn-normal">添加</button>
                <a href="queryAllMb.php">
                    <button class="layui-btn layui-btn-xs layui-btn-primary">刷新</button>
                </a>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<script src="js/jquery-2.1.1.min.js" charset="UTF-8"></script>
<script>
    function isDel(mobileId) {
        if (confirm("确定要删除？请谨慎操作") === true) {
            $.ajax({
                url: "/delete.php?mobileId=" + mobileId,
                success: function (result) {
                    if (null != result) {
                        window.location.href = "queryAllMb.php";
                    }
                }
            });
        }
    };

    function queryOne(mobileId) {
        window.location.href = "queryOne.php?mobileId=" + mobileId;
    }
</script>
</body>
</html>
