package pethero.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pethero.dao.UserDAO;
import pethero.domain.Keeper;
import pethero.domain.Owner;
import pethero.service.KeeperService;
import pethero.service.OwnerService;
import pethero.service.UserService;

import javax.servlet.http.HttpSession;

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
