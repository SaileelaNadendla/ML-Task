package com.bhavna.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.bhavna.Entity.Order;
import com.bhavna.Repository.OrderRepository;
import com.bhavna.Repository.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	 private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
		
		
	}
	public List<Order> getOrderByCategory(String Category){
		return orderRepository.getOrderByCategory(Category);
		
	}
	
	
	public Order addOrder(Order order) throws IOException {

		Optional<Order> var = ((CrudRepository<Order, Integer>) order).findById(order.getOrderId());
		if (var.isPresent()) {

			throw new IOException("order exists");
		} else {

			order.setOrderPrice(order.getQuantity() * productRepository.getById(order.getProdId().getProdId()).getPrice());
			return orderRepository.save(order);

		}

	}


	public Order getOrderByOrderId(int orderId) {
		return orderRepository.findById(orderId).orElseThrow(null);

	}

	public String deleteByOrderId(int orderId) {
		orderRepository.deleteById(orderId);
		return "order deleted " + orderId;
	}

	public String updateOrder(Order order) {

		order.setOrderPrice(order.getQuantity() * productRepository.getById(order.getProdId().getProdId()).getPrice());
		orderRepository.save(order);
		System.out.println(order);

		return "updated successfully " + order.getOrderId();

	}

	public void patchOrderById(Integer orderId, Integer prodId, Integer quantity, String address) {
		Order order = orderRepository.findById(orderId).get();
		if (quantity != null)
			order.setQuantity(quantity);
		if (prodId != null)
			order.setProdId(productRepository.findById(prodId).get());
		order.setOrderPrice(order.getQuantity() * productRepository.getById(prodId).getPrice());
		if (address != null)
			order.setAddress(address);
		orderRepository.save(order);
	}
}


