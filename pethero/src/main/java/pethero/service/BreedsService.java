package pethero.service;

import pethero.dto.BreedDTO;
import pethero.dto.CatBreedDTO;

import java.util.List;

public interface BreedsService {

    List<BreedDTO> getDogBreeds();

    List<CatBreedDTO> getCatBreeds();

    String getCatBreedImage(String idImage);
}
