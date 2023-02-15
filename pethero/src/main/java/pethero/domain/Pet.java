package pethero.domain;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "pet")
public class Pet  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPet;
    @NotEmpty
    private String name;
    @NotEmpty
    private String birthdate;
    @NotEmpty
    private String race;
    @NotEmpty
    private String type; //cat dog
    @NotEmpty
    private String petSize;
    @OneToOne
    @JoinColumn(name = "image_pet")
    private Image imagePet;

    private int idOwner;
    @OneToOne
    @JoinColumn(name = "plan")
    private Image vaccinationPlan;

    public Pet(int idPet, String name, String birthdate, String race, String type, String petSize) {
        this.idPet = idPet;
        this.name = name;
        this.birthdate = birthdate;
        this.race = race;
        this.type = type;
        this.petSize = petSize;
    }

    public Pet(String name, String birthdate, String race, String type, String petSize) {
        this.name = name;
        this.birthdate = birthdate;
        this.race = race;
        this.type = type;
        this.petSize = petSize;
    }

    public Pet() {
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    public int getIdOwner() {
        return idOwner;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPetSize() {
        return petSize;
    }

    public void setPetSize(String petSize) {
        this.petSize = petSize;
    }

    public Image getImagePet() {
        return imagePet;
    }

    public Image getVaccinationPlan() {
        return vaccinationPlan;
    }

    public void setImagePet(Image imagePet) {
        this.imagePet = imagePet;
    }

    public void setVaccinationPlan(Image vaccinationPlan) {
        this.vaccinationPlan = vaccinationPlan;
    }


    //metodos
    public String base64Encoder(byte[] image){
        return Base64.encodeBase64String(image);
    }
}
