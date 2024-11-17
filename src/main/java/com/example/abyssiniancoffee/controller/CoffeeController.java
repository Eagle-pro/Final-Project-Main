package com.example.abyssiniancoffee.controller;

import com.example.abyssiniancoffee.dto.ModifyQuantityRequest;
import com.example.abyssiniancoffee.model.Coffee;
import com.example.abyssiniancoffee.service.CoffeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coffees")
@RequiredArgsConstructor
public class CoffeeController {

    private final CoffeeService coffeeService;


    @GetMapping
    public List<Coffee> findAll() {
        return coffeeService.findAll();
    }


    @GetMapping("/{id}")
    public Coffee findById(@PathVariable Long id) {
        return coffeeService.findById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Coffee create(@RequestBody Coffee coffee) {
        return coffeeService.createSeed(coffee);
    }


    @PutMapping("/{id}")
    public Coffee update(@RequestBody Coffee coffee, @PathVariable Long id) {
        return coffeeService.updateSeed(coffee, id);
    }


    @PatchMapping("/{id}")
    public Coffee updateQuantity(@RequestBody @Valid ModifyQuantityRequest modifyQuantityRequest, @PathVariable Long id) {
        return coffeeService.updateQuantity(modifyQuantityRequest, id);  // Call instance method on coffeeService
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        coffeeService.deleteCoffeeById(id);
    }
}
