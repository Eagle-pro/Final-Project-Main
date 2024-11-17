package com.example.abyssiniancoffee.service;

import com.example.abyssiniancoffee.model.Coffee;
import com.example.abyssiniancoffee.dto.QuantityOperationType;
import com.example.abyssiniancoffee.repository.CoffeeRepository;
import com.example.abyssiniancoffee.dto.ModifyQuantityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    // Method to create a new coffee entry
    @Transactional
    public Coffee createSeed(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    // Method to find all coffees
    public List<Coffee> findAll() {
        return coffeeRepository.findAll();
    }

    // Method to find a coffee by its ID
    public Coffee findById(Long id) {
        return coffeeRepository.findById(id).orElse(null);  // Handle null safely
    }

    // Method to update an existing coffee by ID
    @Transactional
    public Coffee updateSeed(Coffee coffeeToUpdate, Long id) {
        var coffee = coffeeRepository.findById(id);
        if (coffee.isEmpty()) {
            return null;  // Coffee not found
        }
        coffeeToUpdate.setId(id);
        return coffeeRepository.save(coffeeToUpdate);  // Save updated coffee
    }

    // Method to update the quantity of coffee in stock
    @Transactional
    public Coffee updateQuantity(ModifyQuantityRequest modifyQuantityRequest, Long id) {
        var coffeeOptional = coffeeRepository.findById(id);
        if (coffeeOptional.isEmpty()) {
            return null;  // Coffee not found
        }

        Coffee coffee = coffeeOptional.get();
        long actualQuantityInKG = coffee.getQuantityInKgInStock();  // Get current quantity in KG

        // Check if the requested quantity is valid
        long requestedQuantity = modifyQuantityRequest.quantity();
        if (requestedQuantity < 0) {
            throw new IllegalArgumentException("Quantity to modify cannot be negative.");
        }

        // Check the operation type and modify the quantity accordingly
        if (modifyQuantityRequest.operation() == QuantityOperationType.ADD) {
            coffee.setQuantityInKgInStock(actualQuantityInKG + requestedQuantity);  // Add quantity
        } else if (modifyQuantityRequest.operation() == QuantityOperationType.SUBTRACT) {
            long newQuantity = actualQuantityInKG - requestedQuantity;
            coffee.setQuantityInKgInStock(Math.max(newQuantity, 0));  // Ensure quantity doesn't go negative
        }

        return coffeeRepository.save(coffee);  // Save the updated coffee
    }

    // Method to delete a coffee by ID
    @Transactional
    public void deleteCoffeeById(Long id) {
        coffeeRepository.deleteById(id);
    }
}
