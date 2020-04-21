<%@ page language="java" contentType="text/html; utf-8"
         pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Scoreboard</title>
    <link rel="stylesheet" href="/styles/demo.css">
</head>

<body>
<h1> Leaderboard</h1>
<table>
    <thead>
    <tr>
        <th> Player </th>
        <th> Score </th>
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

</body>
</html>