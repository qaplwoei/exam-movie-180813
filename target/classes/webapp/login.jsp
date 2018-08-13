<%--
  Created by IntelliJ IDEA.
  User: AL
  Date: 2018/8/13
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" type="text/css">
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
</head>
<body>
<div style="width: 300px;height: 120px;
border-radius: 10px;border: 1px solid #777;
padding: 20px;top:100px;position:relative;"
class="text-center center-block">
<form action="/login" method="post">
    first name:<input type="text" name="firstName">
    <br/>
    <br/>
    <input type="submit" class="btn btn-default col-lg-12" value="登录">
</form>
</div>
</body>
</html>
