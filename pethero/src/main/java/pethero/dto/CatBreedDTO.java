package pethero.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CatBreedDTO {

    @JsonProperty("weight")
    private BreedMetricImperialDTO weight;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cfa_url")
    private String cfaUrl;
    @JsonProperty("vetstreet_url")
    private String vetstreetUrl;
    @JsonProperty("vcahospitals_url")
    private String vcahospitalsUrl;
    @JsonProperty("temperament")
    private String temperament;
    @JsonProperty("origin")
    private String origun;
    @JsonProperty("country_codes")
    private String countryCodes;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("description")
    private String description;
    @JsonProperty("life_span")
    private String lifeSpan;
    @JsonProperty("indoor")
    private int indoor;
    @JsonProperty("lap")
    private int lap;
    @JsonProperty("alt_names")
    private String altNames;
    @JsonProperty("adaptability")
    private int adaptability;
    @JsonProperty("affection_level")
    private int affectionLevel;
    @JsonProperty("child_friendly")
    private int childFriendly;
    @JsonProperty("dog_friendly")
    private int dogFriendly;
    @JsonProperty("energy_level")
    private int energyLevel;
    @JsonProperty("grooming")
    private int grooming;
    @JsonProperty("health_issues")
    private int healthIssues;
    @JsonProperty("intelligence")
    private int intelligence;
    @JsonProperty("shedding_level")
    private int sheddingLevel;
    @JsonProperty("social_needs")
    private int socialNeeds;
    @JsonProperty("stranger_friendly")
    private int strangerFriendly;
    @JsonProperty("vocalisation")
    private int vocalisation;
    @JsonProperty("experimental")
    private int experimental;
    @JsonProperty("hairless")
    private int hairless;
    @JsonProperty("natural")
    private int natural;
    @JsonProperty("rare")
    private int rare;
    @JsonProperty("rex")
    private int rex;
    @JsonProperty("suppressed_tail")
    private int suppressedTail;
    @JsonProperty("short_legs")
    private int shortLegs;
    @JsonProperty("wikipedia_url")
    private String wikipediaUrl;
    @JsonProperty("hypoallergenic")
    private int hypoallergenic;
    @JsonProperty("reference_image_id")
    private String referenceImageId;

    @JsonIgnore
    private String imageUrl;

    public BreedMetricImperialDTO getWeight() {
        return weight;
    }

    public void setWeight(BreedMetricImperialDTO weight) {
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCfaUrl() {
        return cfaUrl;
    }

    public void setCfaUrl(String cfaUrl) {
        this.cfaUrl = cfaUrl;
    }

    public String getVetstreetUrl() {
        return vetstreetUrl;
    }

    public void setVetstreetUrl(String vetstreetUrl) {
        this.vetstreetUrl = vetstreetUrl;
    }

    public String getVcahospitalsUrl() {
        return vcahospitalsUrl;
    }

    public void setVcahospitalsUrl(String vcahospitalsUrl) {
        this.vcahospitalsUrl = vcahospitalsUrl;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getOrigun() {
        return origun;
    }

    public void setOrigun(String origun) {
        this.origun = origun;
    }

    public String getCountryCodes() {
        return countryCodes;
    }

    public void setCountryCodes(String countryCodes) {
        this.countryCodes = countryCodes;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public int getIndoor() {
        return indoor;
    }

    public void setIndoor(int indoor) {
        this.indoor = indoor;
    }

    public int getLap() {
        return lap;
    }

    public void setLap(int lap) {
        this.lap = lap;
    }

    public String getAltNames() {
        return altNames;
    }

    public void setAltNames(String altNames) {
        this.altNames = altNames;
    }

    public int getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(int adaptability) {
        this.adaptability = adaptability;
    }

    public int getAffectionLevel() {
        return affectionLevel;
    }

    public void setAffectionLevel(int affectionLevel) {
        this.affectionLevel = affectionLevel;
    }

    public int getChildFriendly() {
        return childFriendly;
    }

    public void setChildFriendly(int childFriendly) {
        this.childFriendly = childFriendly;
    }

    public int getDogFriendly() {
        return dogFriendly;
    }

    public void setDogFriendly(int dogFriendly) {
        this.dogFriendly = dogFriendly;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public int getGrooming() {
        return grooming;
    }

    public void setGrooming(int grooming) {
        this.grooming = grooming;
    }

    public int getHealthIssues() {
        return healthIssues;
    }

    public void setHealthIssues(int healthIssues) {
        this.healthIssues = healthIssues;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getSheddingLevel() {
        return sheddingLevel;
    }

    public void setSheddingLevel(int sheddingLevel) {
        this.sheddingLevel = sheddingLevel;
    }

    public int getSocialNeeds() {
        return socialNeeds;
    }

    public void setSocialNeeds(int socialNeeds) {
        this.socialNeeds = socialNeeds;
    }

    public int getStrangerFriendly() {
        return strangerFriendly;
    }

    public void setStrangerFriendly(int strangerFriendly) {
        this.strangerFriendly = strangerFriendly;
    }

    public int getVocalisation() {
        return vocalisation;
    }

    public void setVocalisation(int vocalisation) {
        this.vocalisation = vocalisation;
    }

    public int getExperimental() {
        return experimental;
    }

    public void setExperimental(int experimental) {
        this.experimental = experimental;
    }

    public int getHairless() {
        return hairless;
    }

    public void setHairless(int hairless) {
        this.hairless = hairless;
    }

    public int getNatural() {
        return natural;
    }

    public void setNatural(int natural) {
        this.natural = natural;
    }

    public int getRare() {
        return rare;
    }

    public void setRare(int rare) {
        this.rare = rare;
    }

    public int getRex() {
        return rex;
    }

    public void setRex(int rex) {
        this.rex = rex;
    }

    public int getSuppressedTail() {
        return suppressedTail;
    }

    public void setSuppressedTail(int suppressedTail) {
        this.suppressedTail = suppressedTail;
    }

    public int getShortLegs() {
        return shortLegs;
    }

    public void setShortLegs(int shortLegs) {
        this.shortLegs = shortLegs;
    }

    public String getWikipediaUrl() {
        return wikipediaUrl;
    }

    public void setWikipediaUrl(String wikipediaUrl) {
        this.wikipediaUrl = wikipediaUrl;
    }

    public int getHypoallergenic() {
        return hypoallergenic;
    }

    public void setHypoallergenic(int hypoallergenic) {
        this.hypoallergenic = hypoallergenic;
    }

    public String getReferenceImageId() {
        return referenceImageId;
    }

    public void setReferenceImageId(String referenceImageId) {
        this.referenceImageId = referenceImageId;
    }
}
