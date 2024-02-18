package com.littlesekii.crud.modules.product.entity.dto;

import com.littlesekii.crud.modules.product.entity.Product;
import jakarta.validation.constraints.NotBlank;

public record ProductDTO(@NotBlank String name, Double price) {

    public Product toEntity() {
        return new Product(null, name, price, true);
    }
}
