<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.hand.movie.service.FilmService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hand.movie.entity.Film" %>
<%@ page import="com.hand.movie.utils.PageBean" %>
<%@ page import="com.hand.movie.entity.Language" %>
<%@ page import="com.hand.movie.dao.LanguageDao" %><%--
  Created by IntelliJ IDEA.
  User: AL
  Date: 2018/8/13
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(pageContext.getAttribute("filmList")==null) {
        PageBean<Film> pageBean=new PageBean<Film>();
        String s=request.getParameter("currentPage");
        pageBean.setCurrentPage(s!=null?Integer.parseInt(s):0);
        pageBean.setPageCount(10);
        FilmService filmService = new FilmService();
        pageBean = filmService.getFilmByPage(pageBean);
        pageContext.setAttribute("filmList", pageBean.getPageData());
    }
%>
<html>
<head>
    <title>Title</title>

</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<style>
    table,table tr th, table tr td { border:1px solid #333; }
    table {border-collapse: collapse;cellspacing:"0";}
    *{
        margin: 0px;
        padding: 0px;
    }
    td{height: 50px;}
    th{padding: 10px;text-align: center}
</style>
<c:if test="${not empty message}">
    <script>
        alert("${message}");
    </script>
</c:if>
<table style="margin: auto" align="center">
    <tr>
        <th>film_id</th>
        <th>title</th>
        <th>description</th>
        <th>language</th>
        <th>delete</th>
    </tr>
    <c:forEach var="film" items="${filmList}">
        <tr>
            <td align="center"><a href="updateFilm.jsp?filmId=${film.film_id}"> ${pageScope.film.film_id}</a></td>
            <td align="center" width="150px">${pageScope.film.title}</td>
            <td width="300px">${pageScope.film.description}</td>
            <td align="center">${pageScope.film.language.name}</td>
            <td align="center">
                <form action="film" method="post">
                    <input type="hidden" name="method" value="delete">
                    <input type="hidden" name="film_id" value="${film.film_id}">
                    <input class="btn btn-default" style="margin:10px" type="submit" value="delete">
                </form>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td style="padding: 10px" align="center" colspan="5">
            <a href="addFilm.jsp" class="btn btn-default col-lg-12">添加</a>
        </td>
    </tr>
    <tr>
        <td style="padding: 10px" align="right" colspan="5">
            <form action="filmList.jsp">
                <input type="text" name="currentPage">
                <input type="submit" value="跳转" class="btn btn-default">
            </form>
        </td>
    </tr>
</table>
</body>
</html>
