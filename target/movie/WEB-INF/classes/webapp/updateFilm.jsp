<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.hand.movie.dao.FilmDao" %>
<%@ page import="com.hand.movie.entity.Film" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hand.movie.entity.Language" %>
<%@ page import="com.hand.movie.dao.LanguageDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String s = request.getParameter("filmId");
    int id = Integer.parseInt(s);
    Film film = FilmDao.selectById(id);
    pageContext.setAttribute("film", film);
    List<Language> languageList = LanguageDao.selectAll();
    pageContext.setAttribute("languageList", languageList);
%>
<html>
<head>
    <title>Title</title>
    <script src="/resources/js/jquery-3.3.1.min.js"></script>
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
                <td><input type="text" name="title" value="${film.title}"></td>
            </tr>
            <tr>
                <td>
                    description:
                </td>
                <td><textarea style="width: 300px;height: 200px;" name="description">${film.description}</textarea></td>
            </tr>
            <tr>
                <td>
                    language:
                </td>
                <td><select name="language_id" id="select">
                    <c:forEach var="language" items="${languageList}">
                        <option value="${language.language_id}">${language.name}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td colspan="2"> <input type="submit" class="btn btn-default col-lg-12"></td>
            </tr>
        </table>
        <input type="hidden" name="method" value="update">
        <input type="hidden" value="${film.language.language_id}" id="language">
        <input type="hidden" name="film_id" value="${film.film_id}">
    </form>
</div>
<script>
    $(document).ready(function () {
        var select = $("#select");
        var options = select.children();
        var language = $("#language").attr("value");
        options.each(function (index, element) {
            if (language == element.value)
                element.selected = true;
            else element.selected = false;
        })
    })
</script>
</body>
</html>