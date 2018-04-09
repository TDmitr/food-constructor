package main.Repositories;


import main.Entities.OrderDish;
import main.Entities.OrderDishId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDishRepository extends JpaRepository<OrderDish, OrderDishId> {
}
