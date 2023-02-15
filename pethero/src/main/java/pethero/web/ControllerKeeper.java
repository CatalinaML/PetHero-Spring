package pethero.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pethero.domain.Keeper;
import pethero.domain.Owner;
import pethero.service.KeeperService;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/keeper")
public class ControllerKeeper {
    @Autowired
    private KeeperService keeperService;

    @GetMapping("/newKeeper")
    public String newKeeper(Keeper keeper){
        return "keeper/newKeeper";
    }

    @PostMapping("/saveKeeper")
    public String saveKeeper(Keeper keeper, HttpSession session){
        keeper.setType("keeper");
        keeperService.save(keeper);
        session.setAttribute("user", keeper);
        return "keeper/indexKeeper";
    }

    @GetMapping("/profile/{idUser}")
    public String viewProfile(@PathVariable int idUser, Model model, HttpSession session){
        Optional<Keeper> opKeeper = keeperService.findById(idUser);
        Keeper keeper = opKeeper.get();
        Owner owner = (Owner) session.getAttribute("user");
        model.addAttribute("keeper", keeper);
        model.addAttribute("owner", owner);
        return "keeper/viewProfile";
    }
}
