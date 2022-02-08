<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>

<h2> Please enter your name. </h2>

<br> <%--  переход на новую строку   --%>

    <form:form action ="showDetails" modelAttribute="employee"> <%--  после нажатия на кнопку выполнится переход на 'showDetails'   --%>
                                                                <%--  'employee' - имя атрибута модели из 'askEmployeeDetails'   --%>
        Name <form:input path="name"/>  <%--  поле для ввод текста (однострочный)   --%>
        <form:errors path="name"/> <%--  валидация (проверка длины имени)   --%>
        <br><br>
        Surname <form:input path="surname"/>
        <form:errors path="surname"/> <%--  валидация (проверка, не пустое ли поле)   --%>
        <br>
        <br>
        Salary <form:input path="salary"/>
        <form:errors path="salary"/>
        <br>
        <br>

        <%-- выпадающий список из трех значений  --%>
        Department <form:select path="department">
            <form:option value="Information Technology" label="IT"/>
            <form:option value="Human Resoueses" label="HR"/>
            <form:option value="Sales" label="Sales"/>
        </form:select>
        <br>
        <br>

        <%-- радиокнопки  --%>
        Which car do you want?
        <br>
        BMW <form:radiobutton path="carBrand" value="BMW"/>
        Audi <form:radiobutton path="carBrand" value="Audi"/>
        MB <form:radiobutton path="carBrand" value="Mercedes"/>
        <br>
        <br>

        <%-- флажки  --%>
        Foreigh languages
        <br>
        EN <form:checkbox path="languages" value="English"/>
        DE <form:checkbox path="languages" value="Deutch"/>
        FR <form:checkbox path="languages" value="French"/>

        <br>
        <br>
        Phone Number <form:input path="phoneNumber"/>  <%--  поле для ввод текста (однострочный)   --%>
        <form:errors path="phoneNumber"/> <%--  валидация вода номера по шаблону ххх-хх-хх   --%>
        <br><br>
        Email <form:input path="email"/>  <%--  поле для ввод текста (однострочный)   --%>
        <form:errors path="email"/> <%--  валидация (на ввод email)   --%>
        <br><br>

        <input type="submit" value="OK"> <%--  кнопка типа 'submit' (кнопка отправки данных формы) с надписью 'OK'--%>


    </form:form>

</body>


</html>