package com.example.springboot_jparepository.service;

import com.example.springboot_jparepository.dao.EmployeeRepository;
import com.example.springboot_jparepository.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// создание посредника между контроллером и DAO. Сервис обращается к DAO, а DAO к БД.
@Service // аннотация для создания бина класса EmployeeServiceImpl
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll(); // метод findall предоставляет springboot

    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = null;
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()) {   // если в объекте Optional есть Employee
            employee = optional.get();
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        List<Employee> employees = employeeRepository.findAllByName(name);
        return employees;
    }
}
