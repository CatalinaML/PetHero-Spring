package pethero.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pethero.domain.Keeper;
import pethero.domain.Owner;
import pethero.domain.User;
import pethero.service.KeeperService;
import pethero.service.OwnerService;
import pethero.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class ControllerWeb {

    @Autowired
    private UserService userService;
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private KeeperService keeperService;

    @GetMapping("/login")
    public String login(){
        return "index";
    }

    @GetMapping("/logout")
    public String logout(){
        return "index";
    }
    @PostMapping("/signin")
    public String signIn(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        User user = userService.findByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(user != null) {
            if (encoder.matches(password, user.getPassword())) {
                if (user.getType().equals("keeper")) {
                    Optional<Keeper> optKeeper =  keeperService.findById(user.getIdUser());
                    session.setAttribute("user", optKeeper.get());
                    return "keeper/indexKeeper";
                } else {
                    Optional<Owner> optOwner = ownerService.findById(user.getIdUser());
                    session.setAttribute("user", optOwner.get());
                    return "owner/indexOwner";
                }
            }
        }
        return "index";
    }
}
