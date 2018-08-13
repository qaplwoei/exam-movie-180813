<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.hand.movie.dao.LanguageDao" %>
<%@ page import="com.hand.movie.entity.Language" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: AL
  Date: 2018/8/13
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    List<Language> languageList = LanguageDao.selectAll();
    pageContext.setAttribute("languageList", languageList);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<style>
    table,table tr th, table tr td { border:1px solid #ccc; }
</style>
<div class="center-block text-center">
    <form action="/film" method="post" class="center-block  text-center">
        <table style="position: relative;margin: auto;" class="table">
            <tr>
                <td>title:</td>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <td>
                    description:
                </td>
                <td><textarea style="width: 300px;height: 200px;" name="description"></textarea></td>
            </tr>
            <tr>
                <td>
                    language:
                </td>
                <td><select name="language_id">
                    <c:forEach var="language" items="${languageList}">
                        <option value="${language.language_id}">${language.name}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td colspan="2"> <input type="submit" class="btn btn-default col-lg-12"></td>
            </tr>
        </table>
        <input type="hidden" name="method" value="add">
    </form>
</div>
</body>
</html>
