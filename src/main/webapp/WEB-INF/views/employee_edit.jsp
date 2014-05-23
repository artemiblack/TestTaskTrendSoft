<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring Hibernate TestTask</title>
</head>
<body>
	<jsp:include flush="false" page="menu.jsp" />

	<h2>Edit '${employee.lastName}'</h2>

	<form:form method="post"
		action="${pageContext.request.contextPath}/employee/save"
		commandName="employee">
		<form:hidden path="id" />
		<jsp:include flush="true" page="employee_form.jsp" />
	</form:form>

	<a href="${pageContext.request.contextPath}/employee/index"
		title="Employee List">Employee List</a>
</body>
</html>