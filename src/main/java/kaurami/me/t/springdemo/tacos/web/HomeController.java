package kaurami.me.t.springdemo.tacos.web;

import kaurami.me.t.springdemo.tacos.Taco;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@RequestMapping
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("text", "ttt55tt");
        model.addAttribute("map", new HashMap<String, String>(){{
            put("value1", "1");
            put("value2", "2");
            put("value3", "3");
        }});
        model.addAttribute("list",new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)));
        return "home";
    }

    @ModelAttribute("text")
    public String getText(){
        return "Test return";
    }

    @ModelAttribute("taco")
    public Taco createTaco(){
        Taco taco = new Taco();
        taco.setName("testName");
        return taco;
    }

    @PostMapping("")
    public String post(){
        System.out.println("button is clicked");
        return "redirect:/design";
    }
}
