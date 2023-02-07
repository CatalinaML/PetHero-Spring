package pethero.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pethero.domain.Keeper;
import pethero.service.KeeperService;

import javax.servlet.http.HttpSession;

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

        return "keeper/indexKeeper";
    }
}
