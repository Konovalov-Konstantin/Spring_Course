package ru.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.spring.rest.entity.Employee;
import ru.spring.rest.exception_handling.NoSuchEmployeeException;
import ru.spring.rest.service.EmployeeService;

import java.util.List;

@RestController // контроллер управляющий REST запросами и ответами
@RequestMapping("/api") // URL для всего класса
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    // получение всех Employee из БД в виде JSON get-запросом
    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    // получение данных об одном Employee по его id
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) { // аннотация @PathVariable исп-ся для получения переменной из адреса запроса
        Employee employee = employeeService.getEmployee(id);

        // если в БД нет Employee с переданным id - выбрасываем исключение
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in database");
        }
        return employee;
    }

    // добавление нового Employee в БД (добавление выполняется через Postman с JSON теле запроса,
    // т.к. в браузере нельзя добавить тело в Post запрос)
    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    // изменение существующего Employee в БД (выполняется через Postman с JSON теле запроса и типом запроса Put,
    // т.к. в браузере нельзя добавить тело в Put запрос
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    // удаление существующего Employee из БД (выполняется через Postman с указанием id работника и типом запроса Delete)
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no Employee with id = " + id + " in database");
        }
        employeeService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted";
    }

}
