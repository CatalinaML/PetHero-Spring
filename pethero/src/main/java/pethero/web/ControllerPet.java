package pethero.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pethero.domain.Image;
import pethero.domain.Owner;
import pethero.domain.Pet;
import pethero.domain.User;
import pethero.service.BreedsService;
import pethero.service.PetService;
import pethero.service.impl.ImagesService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/pet")
public class ControllerPet {
    @Autowired
    private PetService petService;
    @Autowired
    private ImagesService imagesService;
    @Autowired
    private BreedsService breedsService;

    @GetMapping("/newPet")
    public String newPet(Pet pet, Model model){
        model.addAttribute("dogBreeds", breedsService.getDogBreeds());
        model.addAttribute("catBreeds", breedsService.getCatBreeds());
        return "pet/newPet";
    }

    @PostMapping("/savePet")
    public String savePet(Pet pet, Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        pet.setIdOwner(user.getIdUser());
        Pet piolita = petService.save(pet);

        model.addAttribute("id", piolita.getIdPet());
        return "pet/addImages";
    }

    @GetMapping("/list")
    public String list(HttpSession session, Model model){
        Owner owner = (Owner) session.getAttribute("user");
        List<Pet> pets = petService.findByIdUser(owner.getIdUser());
        model.addAttribute("pets", pets);
        return "owner/viewPets";
    }

    @GetMapping("/profile/{idPet}")
    public String profilePet(@PathVariable int idPet, Model model){
        Optional<Pet> opPet = petService.findById(idPet);
        Pet pet = opPet.get();
        model.addAttribute("pet", pet);
        return "pet/petProfile";
    }
}
