package com.littlesekii.crud.modules.product.repository;

import com.littlesekii.crud.modules.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
