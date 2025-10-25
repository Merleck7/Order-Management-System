package com.meli.ordermanagement.service;

import com.meli.ordermanagement.model.Order;
import com.meli.ordermanagement.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Alias para mantener compatibilidad con el test
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    // Nuevo método más semántico
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setCustomerName(orderDetails.getCustomerName());
                    order.setTotalAmount(orderDetails.getTotalAmount());
                    order.setStatus(orderDetails.getStatus());
                    return orderRepository.save(order);
                })
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}