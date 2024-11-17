package com.example.abyssiniancoffee.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "coffee")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private QualityLevel qualityLevel;

    @Enumerated(EnumType.STRING)
    private CultivationArea cultivationArea;

    private BigDecimal price;

    private long quantityInKgInStock;


    public Coffee(String name, QualityLevel qualityLevel, CultivationArea cultivationArea, BigDecimal price, long quantityInKgInStock) {
        this.name = name;
        this.qualityLevel = qualityLevel;
        this.cultivationArea = cultivationArea;
        this.price = price;
        this.quantityInKgInStock = quantityInKgInStock;
    }
}
