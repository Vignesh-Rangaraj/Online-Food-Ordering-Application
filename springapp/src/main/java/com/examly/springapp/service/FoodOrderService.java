package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.FoodOrder;

@Service
public class FoodOrderService {

    private final List<FoodOrder> orderList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<FoodOrder> getAllOrders() {
        return orderList;
    }

    public FoodOrder saveOrder(FoodOrder order) {
        order.setId(idCounter.getAndIncrement());
        orderList.add(order);
        return order;
    }

    public FoodOrder updateOrder(Long id, FoodOrder updated) {
        for (int i = 0; i < orderList.size(); i++) {
            FoodOrder existing = orderList.get(i);
            if (existing.getId().equals(id)) {
                updated.setId(id);
                orderList.set(i, updated);
                return updated;
            }
        }
        throw new RuntimeException("Order not found: " + id);
    }

    public void deleteOrder(Long id) {
        orderList.removeIf(order -> order.getId().equals(id));
    }
}
