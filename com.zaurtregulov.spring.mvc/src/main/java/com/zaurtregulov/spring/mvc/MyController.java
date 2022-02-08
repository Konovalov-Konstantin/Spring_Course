//package com.zaurtregulov.spring.mvc;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
////@RequestMapping("/anything") // аннотация @RequestMapping над классом добавляет к URL адресу всех его методов то,
//                               // что указано в параметрах. Т.е. для метода showFirstView URL будет ' /anything/start '
//public class MyController {
//
//    @RequestMapping("/start")
////    @GetMapping("/start")
//    public String showFirstView(){
//        return "first-view";
//    }
//
//    @RequestMapping("/askDetails")
//    public String askEmployeeDetails() {
//        return "ask-emp-details-view";
//    }
//
////    @RequestMapping("/showDetails")
////    public String showEmpDetails () {
////        return "show-emp-details-view";
////    }
//
////    // получение в контроллере данных из формы, при помощи 'HttpServletRequest', изменение этих данных и вывод измененного значения в модель
////    @RequestMapping("/showDetails")
////    public String showEmpDetails (HttpServletRequest request, Model model) {  // указываем параметры HttpServletRequest, Model
////
////        String empName = request.getParameter("employeeName"); // вытаскиваем данные из поля 'employeeName' формы 'ask-emp-details-view'
////        empName = "MR " + empName;
////        model.addAttribute("nameAttribute", empName); //передаем в модель измененный 'empName' для дальнейшего
////                                                                  // использования во второй форме 'show-emp-details-vies'
////        return "show-emp-details-view";
////    }
//
//    // получение в контроллере данных из формы, ПРИ ПОМОЩИ '@RequestParam', изменение этих данных и вывод измененного значения в модель
//    @RequestMapping("/showDetails")
//public String showEmpDetails (@RequestParam("employeeName") String empName, Model model) {  // указываем параметры HttpServletRequest, Mode    public String showEmpDetails (@RequestParam("employeeName") String empName, Model model) {  // указываем параметры HttpServletRequest, Mod
//
//        empName = "MR " + empName; // меняем значение 'empName'
//        model.addAttribute("nameAttribute", empName); //передаем в модель измененный 'empName' для дальнейшего
//        // использования во второй форме 'show-emp-details-vies'
//        return "show-emp-details-view";
//    }
//}
