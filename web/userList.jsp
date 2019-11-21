<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图书管理系统-用户管理</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js"></script>
</head>
<body>

	<div class="main">
		<div class="content">
			<table class="list">
				<thead>
				<tr>
					<td width="70" height="29"><div class="STYLE1" align="center">编号</div>
					</td>
					<td width="80"><div class="STYLE1" align="center">用户名</div>
					</td>
					<td width="80"><div class="STYLE1" align="center">用户账号</div>
					</td>
					<td width="100"><div class="STYLE1" align="center">性别</div>
					</td>
					<td width="100"><div class="STYLE1" align="center">生日</div>
					</td>
					<td width="150"><div class="STYLE1" align="center">电话</div>
					</td>
					<td width="150"><div class="STYLE1" align="center">权限</div>
					</td>
					<td width="150"><div class="STYLE1" align="center">头像</div>
					</td>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="user" items="${list}">
					<tr>
						<td><c:out value="${user.id}"></c:out></td>
						<td><c:out value="${user.name}"></c:out></td>
						<td><c:out value="${user.loginName}"></c:out></td>
						<td>
							<c:if test="${user.gender=='1'}">
								男
							</c:if>
							<c:if test="${user.gender=='2'}">
								女
							</c:if>
						</td>
						<%--<td><c:out value="${user.gender}"></c:out></td>--%>
						<td><c:out value="${user.birthDate}"></c:out></td>
						<td><c:out value="${user.phone}"></c:out></td>
					<td>
						<c:if test="${user.userType=='1'}">管理员</c:if>
						<c:if test="${user.userType=='2'}">普通用户</c:if>
					</td>
					<td>
					</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>

		</div>
	</div>

</body>
</html>