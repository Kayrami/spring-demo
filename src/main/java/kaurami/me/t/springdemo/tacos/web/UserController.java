package kaurami.me.t.springdemo.tacos.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/user")
@Controller
public class UserController {

    @GetMapping("")
    String showMe(Model model, @RequestParam(required = false) String name){
        if (name!=null){
            model.addAttribute("name", name);
        }else {
            model.addAttribute("name", "unknown");
        }
        return "user";
    }
}
