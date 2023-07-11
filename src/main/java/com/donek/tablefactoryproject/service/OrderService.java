package com.donek.tablefactoryproject.service;

import com.donek.tablefactoryproject.domain.Order;
import com.donek.tablefactoryproject.domain.OrderStatus;
import com.donek.tablefactoryproject.dto.OrderRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
    // TODO генерация userId
    private List<Order> orders = new ArrayList<>(); // TODO Поменять это дело на нормальную бд
    public Order createOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .orderId(UUID.randomUUID().toString())
                .userId("d9e39283-5b9e-4b3d-aad7-150b7a1b581f")
                .status(OrderStatus.ORDER_CREATED)
                .orderConfig(orderRequest.getOrderConfig())
                .price(orderRequest.getPrice())
                .build();

        orders.add(order);

        return order;
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public void deleteOrder(String orderId) {
        orders = orders.stream()
                .filter(order -> !order.getOrderId().equals(orderId))
                .collect(Collectors.toList());
    }

    public Order updateOrder(String orderId, OrderRequest orderRequest) {
        Order currentOrder = orders.stream().filter(order -> order.getOrderId().equals(orderId)).findFirst().get();
        currentOrder.setOrderConfig(orderRequest.getOrderConfig());
        currentOrder.setPrice(orderRequest.getPrice());

        return currentOrder;
    }

    public Order findById(String orderId) {
        return orders.stream().filter(order -> order.getOrderId().equals(orderId)).findFirst().get();
    }
}
