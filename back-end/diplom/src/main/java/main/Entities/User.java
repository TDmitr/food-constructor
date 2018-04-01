package main.Entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by igor on 3/2/18.
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private UserRoles userRole;

    public User(String name, String email, UserRoles userRole) {
        this.name = name;
        this.email = email;
        this.userRole = userRole;
    }

    public User() {
    }
}
