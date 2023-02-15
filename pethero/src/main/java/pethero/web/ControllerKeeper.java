package pethero.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pethero.dao.OwnerDAO;
import pethero.domain.Keeper;
import pethero.domain.Owner;
import pethero.domain.Reservation;
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
}
