<%--
  Created by IntelliJ IDEA.
  User: 唐全成
  Date: 2018/2/1
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <style>
        .mask{
            width: 100%;
            height: 100%;
            background-color: #E0E0E0;
            z-index: 1000;
            position: absolute;
            top: 0;
        }
    </style>
</head>

<script src="<%=basePath%>/static/js/excanvas.min.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/jquery.min.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/jquery.loadBar.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/jquery.ui.custom.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/bootstrap.min.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/fullcalendar.min.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/matrix.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/jquery.uniform.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/select2.min.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/contabs.min.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/conttab_child.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/jquery.nicescroll.min.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/css/pace.min.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/flavr.min.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/flatpickr.min.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/bootstrap-table/bootstrap-table.min.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/bootstrap-table/locale/bootstrap-table-zh-CN.min.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/jquery.gritter.min.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/jquery.easyui.min.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/jquery.validate.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/message.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/app/currency.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/app/util.js?deVersion=2018020101"></script>
<script src="<%=basePath%>/static/js/bankJson.js?deVersion=2018020101"></script>

<script>
    var ctxPath='<%=basePath%>'
    // loadBar.trigger('show');
    // window.onload=function (ev) {
    //     loadBar.trigger('hide')
    // }
</script>

</html>
