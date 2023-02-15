package pethero.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private int idKeeper;
    @NotNull
    private int idOwner;
    @NotNull
    private int idPet;
    @NotEmpty
    private String startDate;
    @NotEmpty
    private String endDate;
    @NotEmpty
    private String startTime;
    @NotEmpty
    private String endTime;
    private String state;

    public Reservation(long id, int idKeeper, int idOwner, int idPet, String stratDate, String endDate, String startTime, String endTime, String state) {
        this.id = id;
        this.idKeeper = idKeeper;
        this.idOwner = idOwner;
        this.idPet = idPet;
        this.startDate = stratDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.state = state;
    }

    public Reservation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIdKeeper() {
        return idKeeper;
    }

    public void setIdKeeper(int idKeeper) {
        this.idKeeper = idKeeper;
    }

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String stratDate) {
        this.startDate = stratDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
