package com.donek.tablefactoryproject.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class Order {
    private String orderId;
    private final LocalDate created = LocalDate.now();
    private String userId;
    private OrderStatus status;
    private OrderConfig orderConfig;
    private String price;
}
