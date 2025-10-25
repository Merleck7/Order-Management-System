package com.meli.ordermanagement.service;

import com.meli.ordermanagement.model.Order;
import com.meli.ordermanagement.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    private Order order;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        order = new Order();
        order.setCustomerName("Luis");
        order.setProduct("Laptop");
        order.setQuantity(2);
        order.setPrice(new BigDecimal("500.00"));
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("Pending");
    }

    @Test
    void shouldSaveOrderSuccessfully() {
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order savedOrder = orderService.saveOrder(order);

        assertThat(savedOrder).isNotNull();
        assertThat(savedOrder.getTotalAmount()).isEqualByComparingTo("1000.00");
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void shouldReturnAllOrders() {
        when(orderRepository.findAll()).thenReturn(Arrays.asList(order));

        List<Order> result = orderService.getAllOrders();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getCustomerName()).isEqualTo("Luis");
    }

    @Test
    void shouldReturnOrderById() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        Optional<Order> result = orderService.getOrderById(1L);

        assertThat(result).isPresent();
        assertThat(result.get().getProduct()).isEqualTo("Laptop");
    }
}
