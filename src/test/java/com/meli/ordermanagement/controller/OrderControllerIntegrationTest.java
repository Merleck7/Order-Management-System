package com.meli.ordermanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.ordermanagement.model.Order;
import com.meli.ordermanagement.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class OrderControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OrderRepository orderRepository;

    private Order order;

    @BeforeEach
    void setUp() {
        orderRepository.deleteAll();
        order = new Order();
        order.setCustomerName("Luis");
        order.setProduct("Headphones");
        order.setQuantity(3);
        order.setPrice(new BigDecimal("150.00"));
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("Pending");
    }

    @Test
    void shouldCreateOrderSuccessfully() throws Exception {
        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.customerName").value("Luis"))
                .andExpect(jsonPath("$.totalAmount").value(450.00));

        assertThat(orderRepository.count()).isEqualTo(1);
    }

    @Test
    void shouldGetAllOrders() throws Exception {
        orderRepository.save(order);

        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].product").value("Headphones"));
    }
}
