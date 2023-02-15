package pethero.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pethero.domain.Image;
import pethero.domain.Owner;
import pethero.domain.Pet;
import pethero.domain.User;
import pethero.service.PetService;
import pethero.service.impl.ImagesService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pet")
public class ControllerPet {
    @Autowired
    private PetService petService;
    @Autowired
    private ImagesService imagesService;

    @GetMapping("/newPet")
    public String newPet(Pet pet){
        return "pet/newPet";
    }

    @PostMapping("/savePet")
    public String savePet(Pet pet, Model model, HttpSession session){
        User user = (User) session.getAttribute("enSesion");
        pet.setIdOwner(user.getIdUser());
        Pet piolita = petService.save(pet);

        model.addAttribute("id", piolita.getIdPet());
        return "pet/addImages";
    }

    @GetMapping("/list")
    public String list(HttpSession session, Model model){
        Owner owner = (Owner) session.getAttribute("enSesion");
        List<Pet> pets = petService.findByIdUser(owner.getIdUser());

        model.addAttribute("pets", pets);

        return "owner/viewPets";
    }
}
