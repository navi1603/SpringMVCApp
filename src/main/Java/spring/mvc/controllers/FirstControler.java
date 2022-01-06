package spring.mvc.controllers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstControler {
    @GetMapping("/hello")
    public String helloOPage (@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname, Model model){

        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";

    }

    @GetMapping ("/goodbye")
    public String goodByePage (){
        return "first/goodbye";

    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a, @RequestParam("b") int b,
                             @RequestParam("action") String action, Model model){
        double result;

        switch (action){
            case("multiplication"):
                result = a * b;
                break;
            case("addition"):
                result = a + b;
                break;
            case("subtruction"):
                result = a - b;
                break;
            case("divition"):
                result = a / (double)b;
                break;
            default:
                result = 0;


        }
        model.addAttribute("result", result);

        return "first/calculator";
    }
}
