package ru.spring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.rest.dao.EmployeeDAO;
import ru.spring.rest.entity.Employee;

import java.util.List;

// создание посредника между контроллером и DAO. Сервис обращается к DAO, а DAO к БД.
@Service // аннотация для создания бина класса EmployeeServiceImpl
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional  // открытие и закрытие транзакций Spring выполнит сам
    public List<Employee> getAllEmployees() {

        return employeeDAO.getAllEmployees();

    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
