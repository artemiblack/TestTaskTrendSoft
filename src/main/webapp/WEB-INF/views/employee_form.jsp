 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <table>
        <tr>
            <td><form:label path="firstName"><spring:message code="label.first_name"/></form:label></td>
        <td><form:input path="firstName" /></td>
        </tr>
        <tr>
            <td><form:label path="lastName"><spring:message code="label.last_name"/></form:label></td>
        <td><form:input path="lastName" /></td>
        </tr>
        <tr>
        <td><form:label path="secondName"><spring:message code="label.second_name"/></form:label></td>
        <td><form:input path="secondName" /></td>
        </tr>
        <tr>
        <td><form:label path="age"><spring:message code="label.age"/></form:label></td>
        <td><form:input path="age" /></td>
        </tr>
        <tr>
        <td><form:label path="experience"><spring:message code="label.experience"/></form:label></td>
        <td><form:input path="experience" /></td>
        </tr>
        <tr>
        <td><form:label path="description"><spring:message code="label.description"/></form:label></td>
        <td><form:input path="description" /></td>
        </tr>
       
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message code="label.addempl"/>"/>
            </td>
        </tr>
    </table>
 