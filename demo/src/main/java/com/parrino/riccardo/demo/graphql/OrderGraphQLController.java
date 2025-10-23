package com.parrino.riccardo.demo.graphql;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.parrino.riccardo.demo.model.Order;

@Controller
public class OrderGraphQLController {
    
    private final List<Order> orders = List.of(
        new Order(1L, 1L, 10),
        new Order(2L, 1L, 15),
        new Order(3L, 2L, 3)
    );

    @QueryMapping
    public Order orderByOrderId(Long orderId) {
        return orders
            .stream()
            .filter(order -> order.getOrderId() == orderId)
            .findFirst()
            .orElse(null);
    }

    @QueryMapping
    public List<Order> orderByProductId(Long productId) {
        return orders
            .stream()
            .filter(order -> order.getProductId() == productId)
            .toList();
    }
    
    @QueryMapping
    public List<Order> orderGreaterQuantity(Integer quantity) {
        return orders
            .stream()
            .filter(order -> order.getQuantity() >= quantity)
            .toList();
    }

    @QueryMapping
    public List<Order> allOrder() {
        return orders;
    }

}
