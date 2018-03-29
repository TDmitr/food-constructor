package main.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by igor on 3/2/18.
 */
@Entity
@Data
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Basic(optional = false)
    private Integer id;
    private String username;
    private String authority;
    @OneToMany(mappedBy = "authority")
    @JsonIgnore
    private Set<User> users;
}
