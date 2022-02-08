package com.zaurtregulov.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
//@RequestMapping("/anything") // аннотация @RequestMapping над классом добавляет к URL адресу всех его методов то,
                               // что указано в параметрах. Т.е. для метода showFirstView URL будет ' /anything/start '
public class MyController1 {

    @RequestMapping("/start")
    public String showFirstView(){
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {
        model.addAttribute("employee", new Employee()); // данные в модель будут попадать со страницы '/askDetails'
        return "ask-emp-details-view1";
    }

    // получение в контроллере данных из формы, ПРИ ПОМОЩИ '@RequestParam' и вывод значения в модель
    // получение данных из модели при помощи @ModelAttribute для отображения на странице 'show-emp-details-view1'
    @RequestMapping("/showDetails")
public String showEmpDetails (@Valid @ModelAttribute("employee") Employee emp, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {     // проверка валидации
            return "ask-emp-details-view1";
        } else {
            return "show-emp-details-view1";
        }
    }
}
