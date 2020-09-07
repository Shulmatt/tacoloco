package com.example.tacoloco.controllers;

import com.example.tacoloco.models.Order;
import com.example.tacoloco.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("tacos")
public class TacosController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value="calculate", method = RequestMethod.POST)
    @ResponseBody
    public double Calculate(@RequestBody Order order) {
        return orderService.Calculate(order);
    }
}
