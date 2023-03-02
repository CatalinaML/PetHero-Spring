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
import pethero.service.ReservationService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/keeper")
public class ControllerKeeper {
    @Autowired
    private KeeperService keeperService;
    @Autowired
    private ReservationService reservationService;

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

    @GetMapping("/services")
    public String services(HttpSession session, Model model){
        Keeper keeper = (Keeper) session.getAttribute("user");
        List<Reservation> reservations = reservationService.findByIdKeeper(keeper.getIdUser());

        List<Reservation> onHold = new ArrayList<>();
        List<Reservation> accepted = new ArrayList<>();
        List<Reservation> confirmed = new ArrayList<>();
        List<Reservation> finished = new ArrayList<>();

        for(Reservation reservation : reservations){
            if(reservation.getState().equals("Aceptada")){
                accepted.add(reservation);
            }else if(reservation.getState().equals("Confirmada")){
                confirmed.add(reservation);
            }else{
                finished.add(reservation);
            }
        }
        model.addAttribute("onHold" , onHold);
        return null;
    }
    @GetMapping("/index")
    public String index(){
        return "keeper/indexKeeper";
    }
}
