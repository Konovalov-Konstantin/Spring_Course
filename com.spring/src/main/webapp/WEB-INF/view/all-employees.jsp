<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2> All Employees </h2>
<br>

<br>

<input type="button" value="add"
       onclick="window.location.href = 'addNewEmployee' "/>

<%--кнопка для добавления новой записи--%>
<table>
    <%--    шапка таблицы--%>
    <tr>
        <th> Name</th>
        <th> Surname</th>
        <th> Department</th>
        <th> Salary</th>
        <th> Operations</th>
    </tr>

    <%--    строки для каждого объекта из таблицы БД--%>

    <c:forEach var="emp" items="${allEmps}">  <%-- цикл foreach для перебора всех Employee из массива allEmps  --%>

        <%--  создание кнопок для обновления данных о каждом Employee --%>
        <c:url var="updateButton" value="/updateInfo">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

        <%--  создание кнопок для удаления Employee --%>
        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

        <tr>
            <td> ${emp.name} </td>
                <%-- данные из модели allEmps контроллера --%>
            <td> ${emp.surname} </td>
            <td> ${emp.department} </td>
            <td> ${emp.salary} </td>

                <%--  создание кнопок для удаления Employee --%>
            <td><input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}' "/>

                <%--  создание кнопок для удаления Employee --%>
            <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}' "/>
            </td>

        </tr>
    </c:forEach>

</table>
<br><br>

<%--    создание кнопки для добавления нового Employee --%>
<input type="button" value="Add"
       onclick="window.location.href = 'addNewEmployee' "/>

</body>
</html>