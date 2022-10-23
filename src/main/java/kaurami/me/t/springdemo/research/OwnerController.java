package kaurami.me.t.springdemo.research;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping
@Controller
public class OwnerController {

    @GetMapping("/owners")
    String showForm(){
        return "owners";
    }

    @ModelAttribute("owners")
    public List<MarketOwner> getOwner(){
        List<MarketOwner> owners = new ArrayList<>(Arrays.asList(
                new MarketOwner("owner1", 5),
                new MarketOwner("owner2", 7),
                new MarketOwner("owner3", 34),
                new MarketOwner("owner4", 234),
                new MarketOwner("owner5", 1),
                new MarketOwner("owner6", 54),
                new MarketOwner("owner7", 12),
                new MarketOwner("owner8", 7),
                new MarketOwner("owner9", 45),
                new MarketOwner("owner10", 34),
                new MarketOwner("owner11", 9)
        ));
        return owners;
    }
}
