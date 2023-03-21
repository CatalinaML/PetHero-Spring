package pethero.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
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
}
