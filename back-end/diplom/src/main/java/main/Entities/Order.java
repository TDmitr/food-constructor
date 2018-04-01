package main.Entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Dish> dishes;

    @ManyToOne
    private User user;

    private String address;

    private Date time;

    public Order(List<Dish> dishes, User user, String address, Date time) {
        this.dishes = dishes;
        this.user = user;
        this.address = address;
        this.time = time;
    }

    public Order() {
    }

    private BigDecimal getPrice() {
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
    }


}
