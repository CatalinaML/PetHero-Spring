package pethero.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import pethero.domain.Image;
import pethero.domain.Pet;
import pethero.service.impl.ImagesService;
import pethero.service.PetService;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/image")
public class ImageDataController {

    @Autowired
    private ImagesService imageDataService;

    @Autowired
    private PetService petService;

//    @GetMapping("/pet/{id}")
//    public void showProductImage(@PathVariable int id,
//                                 HttpServletResponse response) throws IOException {
//        response.setContentType("image/jpeg"); // Or whatever format you wanna use
//
//        Optional<Pet> optPet = petService.findById(id);
//        if (optPet.isPresent()) {
//            InputStream is = new ByteArrayInputStream(optPet.get().getImagePet().getImageData());
//            IOUtils.copy(is, response.getOutputStream());
//        }
//    }

    @PostMapping("/{petId}")
    public String uploadImage(@PathVariable int petId, @RequestParam("image") MultipartFile image, @RequestParam("plan") MultipartFile plan, Pet pet) throws IOException {
        // obtengo el Pet para setearle la imagen correspondiente
        final Optional<Pet> optPet = petService.findById(petId);
        if (optPet.isPresent()) {
            final Pet petImg = optPet.get();
            final Image imagePet = imageDataService.uploadImage(image);
            final Image vaccinationPlan = imageDataService.uploadImage(plan);

            petImg.setImagePet(imagePet);
            petImg.setVaccinationPlan(vaccinationPlan);
            petService.save(petImg);

            return "pet/newPet";
        } else {
            // no existia el Pet que me mandaron
            return "owner/indexOwner";
        }
    }

    /*
    @GetMapping("/info/{name}")
    public ResponseEntity<Image> getImageInfoByName(@PathVariable("name") String name) {
        Image image = imageDataService.getInfoByImageByName(name);

        return ResponseEntity.status(HttpStatus.OK)
                .body(image);
    }*/
//
//
//    @GetMapping("/{name}")
//    public ResponseEntity<?> getImageByName(@PathVariable("name") String name) {
//        byte[] image = imageDataService.getImage(name);
//
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/png"))
//                .body(image);
//    }


}
