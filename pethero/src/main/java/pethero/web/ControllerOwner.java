package pethero.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pethero.domain.Keeper;
import pethero.domain.Owner;
import pethero.domain.Pet;
import pethero.domain.Reservation;
import pethero.service.KeeperService;
import pethero.service.OwnerService;
import pethero.service.PetService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/owner")
public class ControllerOwner {

    @Autowired
    private OwnerService ownerService;
    @Autowired
    private KeeperService keeperService;
    @Autowired
    private PetService petService;

    @GetMapping("/newOwner")
    public String newOwner(Owner owner){
        return "owner/newOwner";
    }

    @PostMapping("/saveOwner")
    public String saveOwner(Owner owner, HttpSession session){
        owner.setType("owner");
        ownerService.save(owner);
        session.setAttribute("user", owner);
        return "owner/indexOwner";
    }

    @GetMapping("/viewKeepers")
    public String viewKeepers(Model model){
        List<Keeper> keepers = keeperService.findAll();

        model.addAttribute("keepers", keepers);
        return "keeper/viewKeepers";
    }

    @GetMapping("/keeperProfile/{idUser}")
    public String keeperProfile(@PathVariable int idUser, Model model, HttpSession session, Reservation reservation){
        Optional<Keeper> opKeeper = keeperService.findById(idUser);
        Keeper keeper = opKeeper.get();
        Owner owner = (Owner) session.getAttribute("user");

        List<Pet> pets = petService.findBySize(owner.getIdUser(), keeper.getPetSize());

        model.addAttribute("keeper", keeper);
        model.addAttribute("owner", owner);
        model.addAttribute("pets", pets);
        return "keeper/viewProfile";
    }
}
