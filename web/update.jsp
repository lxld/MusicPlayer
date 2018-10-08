<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
    <link href="css/layui.css" rel="stylesheet">
</head>
<body>
<div style="width: 700px;margin: 0 auto;padding-top: 10px">
    <form class="layui-form" id="myfrom">
        <c:if test="${not empty mobile}">
            <c:forEach var="mo" items="${mobile}">
                <div class="layui-form-item">
                    <label class="layui-form-label">序号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="mobileId" autocomplete="off" class="layui-input" value="${mo.mobileId}"
                               readonly="readonly">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">品牌</label>
                    <div class="layui-input-block">
                        <select name="brand">
                            <c:forEach var="brand" items="${brands}">
                                <c:choose>
                                    <c:when test="${brand.brandName eq mo.brand.brandName}">
                                        <option value="${mo.brand.brandId}" selected>${mo.brand.brandName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${brand.brandId}">${brand.brandName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">名称</label>
                    <div class="layui-input-block">
                        <input type="text" name="type" autocomplete="off" class="layui-input" value="${mo.type}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">操作系统</label>
                    <div class="layui-input-block">
                        <input type="text" name="os" autocomplete="off" class="layui-input" value="${mo.os}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">处理器</label>
                    <div class="layui-input-block">
                        <input type="text" name="cpu" autocomplete="off" class="layui-input" value="${mo.cpu}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">ROM</label>
                    <div class="layui-input-block">
                        <input type="text" name="ramSize" autocomplete="off" class="layui-input"
                               value="${mo.ramSize}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">RAM</label>
                    <div class="layui-input-block">
                        <input type="text" name="diskSize" autocomplete="off" class="layui-input"
                               value="${mo.diskSize}">
                    </div>
                </div>
                <div class="layui-form-item" style="float: right">
                    <button class="layui-btn layui-btn-sm layui-btn-normal" onclick="formsubmit()">修改</button>
                </div>
            </c:forEach>
        </c:if>
    </form>
</div>
<script src="js/jquery-2.1.1.min.js" charset="UTF-8"></script>
<script src="js/layui.all.js" charset="UTF-8"></script>
<script>
    function formsubmit() {
        $.ajax({
            cache: true,
            url: 'modify.php',
            data: $('#myfrom').serialize(),
            async: false,
            success: function (result) {
                if (result == "ok") {
                    layer.msg('修改成功', {icon: 1, time: 1000}, function () {
                        window.location.href = "queryAllMb.php";
                    });
                }
            }
        });
    }
</script>
</body>
</html>
