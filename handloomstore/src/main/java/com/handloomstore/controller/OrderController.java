package com.handloomstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.handloomstore.entity.Order;
import com.handloomstore.entity.TransactionDetails;
import com.handloomstore.service.OrderServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")

@RestController // is controller which provides different end points to access the services
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
	private OrderServiceImpl orderService;

	// adding order details
	@PostMapping("/addOrderItem/{userId}")
	public ResponseEntity<Order> addOrder(@PathVariable int userId, @RequestBody Order order) {

		return new ResponseEntity<Order>(orderService.addOrderItem(order, userId), HttpStatus.CREATED);
	}

	// updating order details
	@PutMapping("{orderId}")
	public ResponseEntity<Order> updateOrder(@PathVariable("orderId") int orderId, @RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.updateOrder(order, orderId), HttpStatus.OK);
	}

	// get all order details
	@GetMapping()
	public List<Order> getAllOrders() {

		return orderService.getAllOrders();
	}

	// get order details by customer id
	@GetMapping("{userId}")
	public List<Order> getOrderByUserId(@PathVariable int userId) {
		return orderService.getOrderByUserId(userId);
	}

	// to delete or cancel Order
	@DeleteMapping("{orderId}")
	public ResponseEntity<Boolean> deleteBooking(@PathVariable("orderId") int orderId) {
		orderService.deleteOrder(orderId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}

	// adding order details
	@PostMapping("/addOrder/{userId}")
	public ResponseEntity<Order> addOrderItems(@PathVariable int userId, @RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.addOrderItem(order, userId), HttpStatus.CREATED);
	}

	@GetMapping({ "/createTransaction/{amount}" })
	public TransactionDetails createTransaction(@PathVariable(name = "amount") double amount) {
		return orderService.createTransaction(amount); // orderDetailService.createTransaction(amount);
	}

}
