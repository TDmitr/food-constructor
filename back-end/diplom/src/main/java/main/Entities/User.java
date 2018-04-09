package main.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private UserRoles userRole;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;

    public User(String name, String email, UserRoles userRole) {
        this.name = name;
        this.email = email;
        this.userRole = userRole;
    }

    public User() {
    }
}
