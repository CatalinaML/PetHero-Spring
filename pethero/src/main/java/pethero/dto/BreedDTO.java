package pethero.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BreedDTO {
    @JsonProperty("weight")
    private BreedMetricImperialDTO weight;
    @JsonProperty("height")
    private BreedMetricImperialDTO height;
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("bread_for")
    private String breadFor;
    @JsonProperty("breed_group")
    private String breedGroup;
    @JsonProperty("life_span")
    private String lifeSpan;
    @JsonProperty("temperament")
    private String temperament;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("reference_image_id")
    private String referenceImageId;
    @JsonProperty("image")
    private BreedImageDTO image;

    public BreedMetricImperialDTO getWeight() {
        return weight;
    }

    public void setWeight(BreedMetricImperialDTO weight) {
        this.weight = weight;
    }

    public BreedMetricImperialDTO getHeight() {
        return height;
    }

    public void setHeight(BreedMetricImperialDTO height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreadFor() {
        return breadFor;
    }

    public void setBreadFor(String breadFor) {
        this.breadFor = breadFor;
    }

    public String getBreedGroup() {
        return breedGroup;
    }

    public void setBreedGroup(String breedGroup) {
        this.breedGroup = breedGroup;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getReferenceImageId() {
        return referenceImageId;
    }

    public void setReferenceImageId(String referenceImageId) {
        this.referenceImageId = referenceImageId;
    }

    public BreedImageDTO getImage() {
        return image;
    }

    public void setImage(BreedImageDTO image) {
        this.image = image;
    }
}
