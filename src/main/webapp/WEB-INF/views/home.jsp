<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>

	<table>
		<tr>
			<th>Name</th>
			<th>Length</th>
		</tr>
		<tr>
			<c:forEach items="${ArrayList}" var="item">
				<tr>
					<td>${item}</td>
					<td>${item.length()}</td>
				</tr>
			</c:forEach>
		</tr>

	</table>

</body>
</html>