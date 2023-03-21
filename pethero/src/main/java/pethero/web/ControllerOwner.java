package pethero.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pethero.domain.*;
import pethero.service.KeeperService;
import pethero.service.OwnerService;
import pethero.service.PetService;
import pethero.service.ReservationService;

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
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/viewKeepers")
    public String viewKeepers(Model model){
        List<Keeper> keepers = keeperService.findAll();

        model.addAttribute("keepers", keepers);
        return "keeper/viewKeepers";
    }

    @GetMapping("/keeperProfile/{idUser}")
    public String keeperProfile(@PathVariable int idUser, Model model, Reservation reservation){
        Optional<Keeper> opKeeper = keeperService.findById(idUser);
        Keeper keeper = opKeeper.get();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Owner owner = this.ownerService.findByUsername(userDetails.getUsername());

        List<Pet> pets = petService.findBySize(owner.getIdUser(), keeper.getPetSize());

        model.addAttribute("keeper", keeper);
        model.addAttribute("owner", owner);
        model.addAttribute("pets", pets);
        return "keeper/viewProfile";
    }

    @PostMapping("/newReservation/{idUser}")
    public String saveReservation(@PathVariable int idUser, Reservation reservation, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Owner owner = this.ownerService.findByUsername(userDetails.getUsername());

        reservation.setIdOwner(owner.getIdUser());
        reservation.setIdKeeper(idUser);
        reservation.setState("Espera");
        reservationService.save(reservation);
        List<Keeper> keepers = keeperService.findAll();

        model.addAttribute("keepers", keepers);
        return "keeper/viewKeepers";
    }
}
