<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.sds.icto.guestbook.dao.GuestbookDao"
	import="com.sds.icto.guestbook.vo.Guestbook" import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook3/insert" method="post">
		<table border=1 width=500>
			<input type="hidden" name="gb" value="add" />
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE="확인"></td>
			</tr>
		</table>
	</form>
	<br>


	<c:forEach var="g" items="${list}">
		<table width=510 border=1>
			<tr>
				<td>${g.no}</td>
				<td>${g.name}</td>
				<td>${g.reg_date}</td>
				<td><a href="/guestbook3/deleteform?id=${g.no}">삭제</a></td>
			</tr>
			<tr>
				<td colspan=4>${g.message}</td>
			</tr>
		</table>
	</c:forEach>


	<c:if test="${empty list}">

		<table width=510 border=1>
			<tr>
				<td colspan=4>등록된 방명록이 없습니다.</td>
			</tr>
		</table>

	</c:if>
</body>
</html>