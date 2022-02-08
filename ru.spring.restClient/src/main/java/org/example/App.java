package org.example;

import org.example.configuration.MyConfig;
import org.example.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

//      список всех Employee
//        List<Employee> allEmployees = communication.getAllEmployees();
//        System.out.println(allEmployees);

        // один Employee по его id
//        Employee employee = communication.getEmployee(2);
//        System.out.println(employee);

        //добавление нового или обновление существующего Employee
        // добавление:
//        Employee employee1 = new Employee("Svetlana", "Sokolova", "HR", 800);
//        communication.saveEmployee(employee1);
        // обновление:
//        Employee employee2 = new Employee("Ludmila", "Orehova", "HR", 900);
//        employee2.setId(8);
//        communication.saveEmployee(employee2);

        //удаление Employee по id
        communication.deleteEmployee(8);
    }
}
