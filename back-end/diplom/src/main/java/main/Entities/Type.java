package main.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Type(String name) {
        this.name = name;
    }

    public Type() {
    }
}
