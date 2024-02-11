package com.rahul.orderservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.basedomain.dto.Order;
import com.rahul.basedomain.dto.OrderEvent;
import com.rahul.orderservice.config.OrderProducer;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@Autowired
	private OrderProducer orderProducer;
	
	@PostMapping("/orders")
	public String placeHolder(@RequestBody Order order) {
		order.setOrderId(UUID.randomUUID().toString());
		
		OrderEvent event =new OrderEvent();
		event.setStatus("Pending");
		event.setMessage("order status in pending state");
		event.setOrder(order);
		
		
		orderProducer.sendMessage(event);
		
		return "Order Placeed Successfully";
	}
}
