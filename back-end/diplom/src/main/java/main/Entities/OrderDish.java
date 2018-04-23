package main.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Data
@Entity
@IdClass(OrderDishId.class)
@EqualsAndHashCode(exclude = {"order", "dish"})
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class OrderDish {
    @Id @ManyToOne Order order;

    @Id @ManyToOne Dish dish;

    private Integer amount;

    public OrderDish(Order order, Dish dish, Integer amount){
        setOrder(order);
        setDish(dish);
        this.amount = amount;
    }

    public void setOrder(Order order){
        this.order = order;
        order.getOrderDishes().add(this);
    }

    public void setDish(Dish dish){
        this.dish = dish;
        dish.getOrderDishes().add(this);
    }
}
