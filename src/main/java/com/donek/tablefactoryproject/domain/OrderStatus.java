package com.donek.tablefactoryproject.domain;

import com.sun.jdi.event.StepEvent;

import java.util.Arrays;

public enum OrderStatus {
    ORDER_CREATED("Заказ создан"),
    ORDER_IN_PROGRESS("Заказ в обработке"),
    ORDER_PAID("Заказ оплачен"),
    ORDER_UNPAID("Заказ не оплачен"),
    ORDER_IN_DELIVERY("Заказ передан в доставку"),
    ORDER_DELIVERED("Заказ доставлен"),
    ORDER_COMPLETED("Заказ выполнен"),
    ORDER_CANCELLED("Заказ отменён"),
    UNKNOWN("Статус не определён");
    public final String description;
    OrderStatus(String description) {
        this.description = description;
    }

    public static OrderStatus currentStatus(String description) {
        return Arrays.stream(OrderStatus.values())
                .filter(orderStatus -> orderStatus.description.equals(description))
                .findFirst().orElse(OrderStatus.UNKNOWN);
    }
}
