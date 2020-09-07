package com.example.tacoloco;

import com.example.tacoloco.models.Order;
import com.example.tacoloco.services.OrderService;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTests {
    @Autowired
    private OrderService orderService;

    @Test
	public void contexLoads() throws Exception {
		assertThat(orderService).isNotNull();
    }

    @Test
    public void orderWithoutDiscount() throws Exception {
        var order = new Order();
        order.veggieTaco = 1;
        order.chickenTaco = 0;
        order.beefTaco = 1;
        order.chorizoTaco = 1;

        assertThat(orderService.Calculate(order)).isEqualTo(9.00);
    }

    @Test
    public void orderWithDiscount() throws Exception {
        var order = new Order();
        order.veggieTaco = 1;
        order.chickenTaco = 2;
        order.beefTaco = 2;
        order.chorizoTaco = 3;

        assertThat(orderService.Calculate(order)).isEqualTo(20);
    }

    @Test
	public void handlesException() throws Exception {
		assertThat(orderService.Calculate(null)).isEqualTo(0);
	}
}
