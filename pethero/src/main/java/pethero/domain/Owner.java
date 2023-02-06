package pethero.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "owner")
public class Owner extends User implements Serializable{
    private static final long serialVersionUID = 1L;


}
