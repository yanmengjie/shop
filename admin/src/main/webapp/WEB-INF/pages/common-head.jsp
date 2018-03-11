
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="<%=basePath%>/static/css/bootstrap.min.css?deVersion=2018020101"/>
    <link rel="stylesheet" href="<%=basePath%>/static/css/bootstrap-responsive.min.css?deVersion=2018020101"/>
    <link rel="stylesheet" href="<%=basePath%>/static/css/bootstrap-switch.min.css?deVersion=2018020101"/>
    <link rel="stylesheet" href="<%=basePath%>/static/css/fullcalendar.css?deVersion=2018020101"/>
    <link rel="stylesheet" href="<%=basePath%>/static/css/matrix-style.css?deVersion=2018020101"/>
    <link rel="stylesheet" href="<%=basePath%>/static/css/matrix-media.css?deVersion=2018020101"/>
    <link rel="stylesheet" href="<%=basePath%>/static/css/font-awesome.min.css?deVersion=2018020101" />
    <link rel="stylesheet" href="<%=basePath%>/static/css/jquery.gritter.css?deVersion=2018020101"/>
    <link rel="stylesheet" href="<%=basePath%>/static/css/animate.min.css?deVersion=2018020101">
    <link rel="stylesheet" href="<%=basePath%>/static/css/flavr.css?deVersion=2018020101">
    <link rel="stylesheet" href="<%=basePath%>/static/css/flatpickr.min.css?deVersion=2018020101">
    <link rel="stylesheet" href="<%=basePath%>/static/css/bootstrap-table.css?deVersion=2018020101"/>
    <link rel="stylesheet" href="<%=basePath%>/static/css/message.css?deVersion=2018020101"/>
    <link rel="stylesheet" href="<%=basePath%>/static/css/select2.css?deVersion=2018020101"/>
</head>


