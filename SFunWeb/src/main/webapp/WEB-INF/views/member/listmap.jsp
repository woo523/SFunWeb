<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>listmap</h2>

<table border="1">


<c:forEach var="dto" items="${memberListmap }">

<tr><td>${dto.memberId }</td><td>${dto.memberPass }</td>
<td>${dto.memberName }</td><td>${dto.memberDate }</td></tr>



</c:forEach>

</table>



</body>
</html>