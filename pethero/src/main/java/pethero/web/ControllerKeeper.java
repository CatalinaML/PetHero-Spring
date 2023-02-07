package pethero.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pethero.domain.Keeper;
import pethero.service.KeeperService;

@Controller
public class ControllerKeeper {
    @Autowired
    private KeeperService keeperService;

    @GetMapping("/newKeeper")
    public String newKeeper(Keeper keeper){
        return "keeper/newKeeper";
    }

    @PostMapping("/saveKeeper")
    public String saveKeeper(Keeper keeper){
        keeperService.save(keeper);
        return "index";
    }
}
