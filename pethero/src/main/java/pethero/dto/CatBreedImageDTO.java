package pethero.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CatBreedImageDTO {

    @JsonProperty("id")
    private String id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("breeds")
    private List<CatBreedDTO> breeds;
    @JsonProperty("width")
    private int width;
    @JsonProperty("height")
    private int height;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<CatBreedDTO> getBreeds() {
        return breeds;
    }

    public void setBreeds(List<CatBreedDTO> breeds) {
        this.breeds = breeds;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
