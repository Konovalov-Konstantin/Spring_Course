package spring.mvc.entity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.mvc.entity.Employee;
import spring.mvc.entity.service.EmployeeService;

import java.util.List;

@Controller // для создания бина класса MyController
public class MyConroller {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String shoeAllEmployees(Model model) {

        // получение всех Employee из БД через сервис и запись в List
        List<Employee> allEmployees = employeeService.getAllEmployees();

        // запись полученных Emloyees в модель
        model.addAttribute("allEmps", allEmployees);

        // ссылка на вьюшку "all-employees"
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {

        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.saveEmployee(employee); // сохранение Employee с помощью 'Servis'

        return "redirect:/";    // переадресация на первую страницу с добавленным "Employee"
    }

    // при создании кнопки на изменение данных о работнике id работника будет 'зашит' в эту кнопку
    @RequestMapping ("/updateInfo")
    public String updateEmploee (@RequestParam("empId") int id, Model model)  {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee); // передаем в форму значения работника, котрыми будут заполнены поля на странице "/updateInfo"
        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee (@RequestParam("empId") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
