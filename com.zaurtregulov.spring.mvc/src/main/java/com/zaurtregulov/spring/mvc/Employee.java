package com.zaurtregulov.spring.mvc;

import com.zaurtregulov.spring.mvc.validation.CheckEmail;

import javax.validation.constraints.*;

public class Employee {
    @Size(min = 2, message = "name must be minimum 2 symbols")
    private String name;

//    @NotEmpty(message = "surname is required field") // проверка не пустое ли поле (пропускает поле из пустых пробелов)
    @NotBlank(message = "surname is required field") // проверка не пустое ли поле (НЕ пропускает поле из пустых пробелов)
    private String surname;

    private String department;

    @Min(value = 500, message = "must be greater than 499") // задание минимального и максимального значений
    @Max(value = 1000, message = "must be less than 1001")
    private int salary;
    private String carBrand;
    private String[] languages;

    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}", message = "please use pattern xxx-xx-xx") // в параметрах рагулярное выражение
    private String phoneNumber;

    @CheckEmail  // эту аннотацию создали сами (см.validation - CheckEmail)
    private String email;

    public Employee() {    }

    @Override
    public String toString() {
        return name + " " + surname + " " + department + " " + salary;
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

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
