package pethero.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pethero.dao.UserDAO;
import pethero.domain.Keeper;
import pethero.domain.Owner;
import pethero.domain.User;
import pethero.service.KeeperService;
import pethero.service.OwnerService;
import pethero.service.UserService;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private UserDAO userDAO;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/newOwner")
    public String newOwner(Owner owner){
        return "owner/newOwner";
    }

    @PostMapping("/saveOwner")
    public String saveOwner(Owner owner, HttpSession session){
        owner.setType("ROLE_OWNER");
        ownerService.save(owner);
        session.setAttribute("user", owner);
        return "index";
    }

    @GetMapping("/newKeeper")
    public String newKeeper(Keeper keeper){
        return "keeper/newKeeper";
    }

    @PostMapping("/saveKeeper")
    public String saveKeeper(Keeper keeper, HttpSession session){
        keeper.setType("ROLE_KEEPER");
        keeperService.save(keeper);
        session.setAttribute("user", keeper);
        return "index";
    }
}
