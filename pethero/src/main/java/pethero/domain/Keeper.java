package pethero.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "keeper")
public class Keeper extends User implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private float remuneration;
    @NotEmpty
    private String startDate;
    @NotEmpty
    private String finishDate;
    @NotEmpty
    private String startTime;
    @NotEmpty
    private String endTime;
    @NotEmpty
    private String petSize;

    public Keeper(int idUser, String username, String password, String name, String lastname, String birthdate, String email, String phone, String city, String type, float remuneration, String startDate, String finishDate, String startTime, String endTime, String petSize) {
        super(idUser, username, password, name, lastname, birthdate, email, phone, city, type);
        this.remuneration = remuneration;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.petSize = petSize;
    }

    public Keeper() {
    }

    public float getRemuneration() {
        return remuneration;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getPetSize() {
        return petSize;
    }

    public void setRemuneration(float remuneration) {
        this.remuneration = remuneration;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setPetSize(String petSize) {
        this.petSize = petSize;
    }
}
