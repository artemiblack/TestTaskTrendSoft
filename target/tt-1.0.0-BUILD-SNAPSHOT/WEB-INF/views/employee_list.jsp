<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring Hibernate Task</title>
</head>
<body>
	<jsp:include flush="false" page="menu.jsp" />

	<h2>Employee List</h2>


	<form:form method="post"
		action="${pageContext.request.contextPath}/employee/add"
		commandName="employee">
		<jsp:include flush="true" page="employee_form.jsp">
			<jsp:param name="addemployee" value="true" />
		</jsp:include>
	</form:form>

	<h3>Find employee: </h3>
	<form:form method="post"
		action="${pageContext.request.contextPath}/employee/find"
		commandName="findEmployee">
        <form:label path="lastName"><spring:message code="label.last_name"/></form:label>
        <form:input path="lastName" />
        <input type="submit" value="<spring:message code="label.go"/>"/>
	</form:form>

	<h3>
		<spring:message code="label.employees" />
	</h3>
	<c:if test="${!empty employeeList}">
		<table class="data">
			<tr>
				<th><spring:message code="label.first_name" /></th>
				<th><spring:message code="label.last_name" /></th>
				<th><spring:message code="label.second_name" /></th>
				<th><spring:message code="label.age" /></th>
				<th><spring:message code="label.experience" /></th>
				<th><spring:message code="label.description" /></th>
				
				<th> </th>
			</tr>
			<c:forEach items="${employeeList}" var="employee">
				<tr>
					<td>${employee.firstName}</td>
					<td>${employee.lastName}</td>
					<td>${employee.secondName}</td>
					<td>${employee.age}</td>
					<td>${employee.experience}</td>
					<td>${employee.description}</td>
					
					<td><a
						href="${pageContext.request.contextPath}/employee/edit/${employee.id}"><spring:message
								code="label.edit" /></a></td>
					<td><a
						href="${pageContext.request.contextPath}/user/delete/${employee.id}"><spring:message
								code="label.delete" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>