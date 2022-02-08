package com.example.springboot_data_rest.entity;

import javax.persistence.*;

@Entity // класс будет иметь отображение в БД
@Table(name = "employees") // указываем с какой таблицей в БД будет связан этот класс
public class Employee {

    @Id //столбец в 'id' таблице 'employees' является 'PrimaryKey'
    @GeneratedValue(strategy = GenerationType.IDENTITY) //стратегия для генерации ключей для поля 'id' (есть несколько стратегий)
    @Column(name = "id") //с каким столбцом из таблицы 'employees' будет связано поле 'id'
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private int salary;

    public Employee() {  }

    public Employee(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
