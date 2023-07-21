package dsigmat.spring_course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;


@Controller
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello " + name + " " + surname);

        return "hello";
    }

    @GetMapping("/nehello")
    public String nesayHello(@RequestParam("name") String name, @RequestParam("surname") String surname, Model model) {
        //System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message", "Hello " + name + " " + surname);

        return "nehello";
    }
//21 урок
    @GetMapping("/calculator")
    public String calculator(@RequestParam("num") int num,
                             @RequestParam("num2") int num2,
                             @RequestParam("action") String action,
                             Model model){
        if (action.equals("multiplication")) {
            int result = num * num2;
            model.addAttribute("message", result);
        } else if (action.equals("addition")) {
            int result = num + num2;
            model.addAttribute("message", result);
        } else if (action.equals("subtraction")) {
            int result = num - num2;
            model.addAttribute("message", result);
        } else {
            model.addAttribute("message", "Invalid action");
        }


        return "calculator";
    }
}
