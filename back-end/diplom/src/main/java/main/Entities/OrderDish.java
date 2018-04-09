package main.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Data
@Entity
@IdClass(OrderDishId.class)
public class OrderDish {
    @Id @ManyToOne Order order;

    @Id @ManyToOne Dish dish;

    private Integer amount;
}
