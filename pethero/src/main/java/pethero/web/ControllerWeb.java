package pethero.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pethero.domain.User;
import pethero.service.UserService;

@Controller
public class ControllerWeb {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/newAccount")
    public String newAccount(Model model){
        return "accountType";
    }
}
