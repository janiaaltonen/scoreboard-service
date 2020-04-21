<%@ page language="java" contentType="text/html; utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Scoreboard</title>
    <link rel="stylesheet" href="/styles/app.css" type="text/css">
</head>

<body>
    <h1> Leaderboard</h1>
    <table>
        <thead>
        <tr>
            <th> Player </th>
            <th><a href="${pageContext.request.contextPath}/?sort=asc" id="sort" onclick="sort()"> Score </a></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${players}" var="player">
            <tr id="player-${player.id}">
                <td><c:out value="${player.username}"/></td>
                <td><c:out value="${player.score}"/> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form class="form" action="/" id="add_new_form" method="post">
        <input id="new-item-name" name="name" required type="text" placeholder=" type username here..." autofocus />
        <input id="new-item-score" name="score" required type="number" min="0" placeholder=" type score here..." autofocus />
        <input type="submit" id="add-new-item" value="Add new score" />
    </form>

    <script> function sort() {
        let link = document.getElementById("sort");
        if (window.location.href.indexOf("asc") !== -1){
        link.setAttribute("href","${pageContext.request.contextPath}/?sort=desc")
        }
    } </script>
</body>
</html>