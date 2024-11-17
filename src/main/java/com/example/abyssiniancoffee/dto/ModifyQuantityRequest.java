package com.example.abyssiniancoffee.dto;

import jakarta.validation.constraints.Min;

public record ModifyQuantityRequest(
        @Min(5) long quantity,
        QuantityOperationType operation
) {
}
