package com.example.spring_course_springboot.dao;

import com.example.spring_course_springboot.entity.Employee;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository // аннотация для создания бина класса DAO, который обращается к БД
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager; // замена Hibernate-сессии в JPA

    @Override
    public List<Employee> getAllEmployees() {
//        Session session = entityManager.unwrap(Session.class); // получение Hibernate-сессии
//
//        // получение всех Employee из БД
//        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();

        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee); // метод saveOrUpdate или добавляет нового Employee в БД (если id=0), или обновляет данные о существующем

            Employee newEmployee = entityManager.merge(employee);
            employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);

        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee where id=:employeeId");
//
//        query.setParameter("employeeId", id);
//        query.executeUpdate();

        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");

        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
