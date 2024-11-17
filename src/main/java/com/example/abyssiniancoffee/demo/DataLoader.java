package com.example.abyssiniancoffee.demo;
import com.example.abyssiniancoffee.model.*;
import com.example.abyssiniancoffee.repository.CoffeeRepository;
import com.example.abyssiniancoffee.service.RoleService;
import com.example.abyssiniancoffee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserService userService;
    private final RoleService roleService;
    private final CoffeeRepository coffeeRepository;

    @Override
    public void run(String... args) throws Exception {

        roleService.save(new Role("ROLE_USER"));
        roleService.save(new Role("ROLE_ADMIN"));


        userService.saveUser(new User("John Doe", "john", "1234"));
        userService.saveUser(new User("James Smith", "james", "1234"));
        userService.saveUser(new User("Jane Carry", "jane", "1234"));
        userService.saveUser(new User("Chris Anderson", "chris", "1234"));


        roleService.addRoleToUser("john", "ROLE_USER");
        roleService.addRoleToUser("james", "ROLE_ADMIN");
        roleService.addRoleToUser("jane", "ROLE_USER");
        roleService.addRoleToUser("chris", "ROLE_ADMIN");
        roleService.addRoleToUser("chris", "ROLE_USER");

        // Adding Sample Coffee Data
        addSampleCoffeeData();
    }

    private void addSampleCoffeeData() {

        Coffee coffee1 = new Coffee("Ethiopian Yirgacheffe", QualityLevel.PREMIUM, CultivationArea.HIGHLAND, new BigDecimal("18.99"), 500);
        Coffee coffee2 = new Coffee("Sidama", QualityLevel.HIGH, CultivationArea.HIGHLAND, new BigDecimal("14.99"), 600);
        Coffee coffee3 = new Coffee("Jima", QualityLevel.PREMIUM, CultivationArea.LOWLAND, new BigDecimal("12.99"), 400);
        Coffee coffee4 = new Coffee("Alala", QualityLevel.PREMIUM, CultivationArea.HIGHLAND, new BigDecimal("16.99"), 300);
        Coffee coffee5 = new Coffee("Haile", QualityLevel.HIGH, CultivationArea.LOWLAND, new BigDecimal("11.99"), 450);


        coffeeRepository.save(coffee1);
        coffeeRepository.save(coffee2);
        coffeeRepository.save(coffee3);
        coffeeRepository.save(coffee4);
        coffeeRepository.save(coffee5);

        System.out.println("Sample Coffee Data Loaded Successfully!");
    }
}
