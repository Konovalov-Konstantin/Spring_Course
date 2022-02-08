package com.example.springboot_data_rest.dao;


import com.example.springboot_data_rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// использование JPARepository - в параметрах первый дженерик - entity,с которым работает данный репозиторий,
// второй дженерик - какой тип данных у поля Primary Key класса Employee
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
