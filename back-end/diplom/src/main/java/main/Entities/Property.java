package main.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private PropertyName propertyName;


    public Property(String name, PropertyName propertyName) {
        this.name = name;
        this.propertyName = propertyName;
    }

    public Property() {
    }
}
