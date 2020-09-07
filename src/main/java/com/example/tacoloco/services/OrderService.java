package com.example.tacoloco.services;

import com.example.tacoloco.models.Order;

import org.springframework.stereotype.Component;

@Component("orderService")
public class OrderService {
    public double Calculate(Order order) {
        try {
            var count = order.veggieTaco + order.beefTaco + order.chickenTaco + order.chorizoTaco;
            var discount = count > 3 ? 0.8 : 1;
            var amount = (2.5 * order.veggieTaco) + (3 * order.chickenTaco) + (3 * order.beefTaco) + (3.5 * order.chorizoTaco);
            return amount * discount;
        } catch (Exception e) {
            // handle exception

            // could also catch the exception in the controller and return a message to the client
            return 0;
        }
    }
}
