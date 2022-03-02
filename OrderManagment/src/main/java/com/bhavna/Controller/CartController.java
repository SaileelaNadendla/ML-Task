package com.bhavna.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.Entity.Order;
import com.bhavna.Service.OrderService;

@RestController
public class CartController {

	@Autowired
	OrderService service;

	@GetMapping(path = "/getAllOrders")
	public List<Order> getAllorders() {
		return service.getAllOrders();
	}

	@PostMapping(path = "/addOrder")
	public Order addOrder(@RequestBody Order order) throws IOException {

		return service.addOrder(order);
	}
	
	@GetMapping(path = "/getOrderById/{orderId}")
	public Order getOrderById(@PathVariable("orderId") int orderId) {
		return service.getOrderByOrderId(orderId);
	}
	
	@DeleteMapping(path = "/delete/{orderId}")
	public String deleteOrderById(@PathVariable("orderId") int orderId) {
	return service.deleteByOrderId(orderId);
	}

	@PutMapping(path = "/updateOrder")
	public String updateOrder(  @RequestBody Order order) {
		return service.updateOrder( order);
	}

	@PatchMapping(path = "/patch/{orderId}")
	public void PatchByOrderId(@PathVariable("orderId") Integer orderId,
			@RequestParam(name = "prodId", required = false) Integer prodId,
			@RequestParam(name = "quantity", required = false) Integer quantity,
			@RequestParam(name = "address", required = false) String address) {
		service.patchOrderById(orderId, prodId, quantity, address);
	}

}
