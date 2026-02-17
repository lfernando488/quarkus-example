package com.lfernando488.services;

import com.lfernando488.models.Product;
import com.lfernando488.repositories.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    //@Inject
    //@Channel("product-out")
    //Emiter<Product> emitter;

    public Product create(Product product){
        productRepository.persist(product);
        //emitter.send(product);
        return product;
    }

    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.listAll();
    }

    @Transactional
    public Product update(Long id, Product updated) {
        Product product = productRepository.findById(id);
        product.name = updated.name;
        product.price = updated.price;
        return product;
    }

    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public Product partialUpdate(Long id, Product updated) {

        Product existing = productRepository.findById(id);

        if (existing == null) throw new RuntimeException("Not found!");

        if (updated.name != null) existing.name = updated.name;

        if (updated.price != null) existing.price = updated.price;

        return existing; // Hibernate salva automaticamente
    }
}
