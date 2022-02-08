<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>
<h3> Information for all employees </h3>

<br><br>
<security:authorize access="hasRole('HR')">   <%--  ограничение видимости кнопки в браузере только для тех ролей, которым разрешен к ней доступ --%>

    <input type="button" value="salary"
           onclick="window.location.href = 'hr_info' ">
    Only for HR staff

</security:authorize>

<br><br>

<security:authorize access="hasRole('MANAGER')">   <%--  ограничение видимости кнопки в браузере только для тех ролей, которым разрешен к ней доступ --%>

    <input type="button" value="performance"
       onclick="window.location.href = 'manager_info' ">
Only for HR managers

</security:authorize>
</body>
</html>