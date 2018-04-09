package main.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    private String address;

    @OneToMany(mappedBy = "order")
    private Set<OrderDish> orderDishes;

    public Order(User user, String address, Set<OrderDish> orderDishes) {
        this.user = user;
        this.address = address;
        this.orderDishes = orderDishes;
    }

    public Order(User user, String address)
    {
        this(user,address,new HashSet<>());
    }

    public Order() {
    }

    /*private BigDecimal getPrice() {
        BigDecimal result = BigDecimal.valueOf(0);
        for (Dish dish : dishes)
        {
            result = result.add(dish.getPrice());
        }
        return result;
    }

    private double getWeight()
    {
        return dishes.stream().mapToDouble(Dish::getWeight).sum();
    }*/


}
