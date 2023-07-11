package com.donek.tablefactoryproject.rest;

import com.donek.tablefactoryproject.dto.OrderRequest;
import com.donek.tablefactoryproject.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderController {
    final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok().body(orderService.createOrder(orderRequest));
    }
    @GetMapping(path="/")
    public ResponseEntity<?> getOrders() {
        return ResponseEntity.ok().body(orderService.getAllOrders());
    }
    @GetMapping
    public ResponseEntity<?> findById(@RequestParam(name = "orderId") String orderId) {
        return ResponseEntity.ok().body(orderService.findById(orderId));
    }
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{orderId}")
    public ResponseEntity<?> updateOrder(@PathVariable String orderId, @RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok().body(orderService.updateOrder(orderId, orderRequest));
    }


}
