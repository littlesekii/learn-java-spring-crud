package com.littlesekii.crud.modules.product.controller;

import com.littlesekii.crud.modules.product.entity.Product;
import com.littlesekii.crud.modules.product.entity.dto.ProductDTO;
import com.littlesekii.crud.modules.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        var res = service.findAll();
        return ResponseEntity.ok().body(res);
    }

    @PostMapping
    public ResponseEntity<Product> register(@RequestBody @Valid ProductDTO req) {
        var res = service.register(req);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(res.getId())
                .toUri();

        return ResponseEntity.created(uri).body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable @Valid UUID id, @RequestBody @Valid ProductDTO req) {
        var res = service.update(id, req);

        return ResponseEntity.ok().body(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable @Valid UUID id) {
        service.deactivate(id);
        return ResponseEntity.noContent().build();
    }
}
