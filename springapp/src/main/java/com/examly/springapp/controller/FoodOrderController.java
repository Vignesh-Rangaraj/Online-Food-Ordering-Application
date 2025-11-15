package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.FoodOrder;
import com.examly.springapp.service.FoodOrderService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*") // allow requests from frontend (or set "http://localhost:8081")
public class FoodOrderController {

    private final FoodOrderService service;

    public FoodOrderController(FoodOrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<FoodOrder> getAll() {
        return service.getAllOrders();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody(required = false) FoodOrder order) {
        if (order == null) {
            return ResponseEntity.badRequest().build();
        }
        FoodOrder saved = service.saveOrder(order);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteOrder(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody FoodOrder updated) {
        FoodOrder saved = service.updateOrder(id, updated);
        return ResponseEntity.ok(saved);
    }
}
