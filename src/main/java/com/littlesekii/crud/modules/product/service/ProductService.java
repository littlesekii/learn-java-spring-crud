package com.littlesekii.crud.modules.product.service;

import com.littlesekii.crud.modules.product.entity.Product;
import com.littlesekii.crud.modules.product.entity.dto.ProductDTO;
import com.littlesekii.crud.modules.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAllByActiveTrue();
    }

    public Product register(ProductDTO dto) {
        return repository.save(dto.toEntity());
    }

    @Transactional
    public Product update(UUID id, ProductDTO dto) {
        Product product = repository.findById(id).orElseThrow();
        product.setName(dto.name());
        product.setPrice(dto.price());
        return product;
    }

    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Transactional
    public void deactivate(UUID id) {
        Product product = repository.findById(id).orElseThrow();
        product.setActive(false);
    }
}
