package pethero.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "owner")
public class Owner extends User implements Serializable{
    private static final long serialVersionUID = 1L;
}
