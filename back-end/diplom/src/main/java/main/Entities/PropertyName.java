package main.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PropertyName {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Type type;

    public PropertyName(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public PropertyName() {
    }
}
