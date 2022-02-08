package ru.spring.rest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.spring.rest.entity.Employee;

import java.util.List;

@Repository // аннотация для создания бина класса DAO, который обращается к БД
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory; // для доступа EmployeeDAOImpl к БД

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession(); // получение сессии

        // получение всех Employee из БД
        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(employee); // метод saveOrUpdate или добавляет нового Employee в БД (если id=0), или обновляет данные о существующем
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee where id=:employeeId");

        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
