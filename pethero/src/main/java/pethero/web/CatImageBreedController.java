package pethero.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pethero.service.BreedsService;

@RestController
public class CatImageBreedController {
    @Autowired
    private BreedsService breedsService;

    @GetMapping("/image/{idImage}")
    public String imagesBreeds(@PathVariable String idImage) {
        return breedsService.getCatBreedImage(idImage);
    }
}
