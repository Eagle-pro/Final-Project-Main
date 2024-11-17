package com.example.abyssiniancoffee.repository;


import com.example.abyssiniancoffee.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
