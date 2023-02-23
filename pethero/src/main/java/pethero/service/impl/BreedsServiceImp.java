package pethero.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import pethero.dto.BreedDTO;
import pethero.dto.BreedListDTO;
import pethero.dto.CatBreedDTO;
import pethero.dto.CatBreedImageDTO;
import pethero.service.BreedsService;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BreedsServiceImp implements BreedsService {

    @Value("${breeds.api.dogs.base.url}")
    private String dogsAPIBaseURL;

    @Value("${breeds.api.cats.base.url}")
    private String catsAPIBaseURL;

    @Value("${breeds.api.breeds.url}")
    private String breedsURL;
    @Value("${breeds.api.breeds.image.url}")
    private String breedsImageURL;

    private WebClient dogsWebClient;
    private WebClient catWebClient;

    @PostConstruct
    public void daleforro() {
        dogsWebClient = WebClient.create(dogsAPIBaseURL);
        catWebClient = WebClient.create(catsAPIBaseURL);
    }

    @Override
    public List<BreedDTO> getDogBreeds() {
        Mono<BreedDTO[]> breeds = dogsWebClient.get()
                .uri(breedsURL)
                .retrieve().bodyToMono(BreedDTO[].class);
        BreedDTO[] listBreeds = breeds.block();
        if (listBreeds != null) {
            return List.of(listBreeds);
        }

        return new ArrayList<>();

    }

    @Override
    public List<CatBreedDTO> getCatBreeds() {
        Mono<CatBreedDTO[]> breeds = catWebClient.get()
                .uri(breedsURL)
                .retrieve().bodyToMono(CatBreedDTO[].class);
        CatBreedDTO[] listBreeds = breeds.block();
        if (listBreeds != null) {
            return List.of(listBreeds);
        }

        return new ArrayList<>();
    }

    @Override
    public String getCatBreedImage(String idImage){
        Mono<CatBreedImageDTO> breedImage = catWebClient.get()
                .uri(String.format(breedsImageURL, idImage))
                .retrieve()
                .bodyToMono(CatBreedImageDTO.class);
        return breedImage.block().getUrl();
    }
}
