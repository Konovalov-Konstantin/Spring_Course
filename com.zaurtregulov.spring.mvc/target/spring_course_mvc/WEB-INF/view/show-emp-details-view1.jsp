<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2> Welcome dear </h2>
<br> <br> <br>

<%--извлекаем данные из переменной employee, которые ввели на странице 'ask-emp-details-view1' --%>
Your name: ${employee.name}
<br>
Your surname: ${employee.surname}
<br>
Your salary: ${employee.salary}
<br>
Yuur department: ${employee.department}
<br>
Your car: ${employee.carBrand}
<br>

<%--вывод на экран списка языков--%>
Languages:
<ul>
    <c:forEach var = "lang" items="${employee.languages}">
        <li>
            ${lang}
        </li>
    </c:forEach>
</ul>

<br>
Phone Number: ${employee.phoneNumber}
<br>
Email: ${employee.email}

</body>
</html>