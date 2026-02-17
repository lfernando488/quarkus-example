package com.lfernando488.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import com.lfernando488.models.Product;
import com.lfernando488.services.ProductService;

import java.util.List;

@Path("/products")
@Produces
@Consumes
public class ProductController {

    @Inject
    ProductService productService;

    @GET
    public List<Product>list(){
        return productService.findAll();
    }

    @GET
    @Path("/{id}")
    public Product get(@PathParam("id") Long id){
        return productService.findById(id);
    }

    @POST
    public Product create(Product product){
        return productService.create(product);
    }

    @PUT
    @Path("/{id}")
    public Product update(@PathParam("id")Long id, Product product){
        return productService.update(id, product);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id){
        productService.delete(id);
    }

    @PATCH
    @Path("/{id}")
    public Product partialUpdate(@PathParam("id") Long id, Product product){
        Product existing = productService.findById(id);

        if(product.name != null) existing.name = product.name;
        if(product.price != null) existing.price = product.price;
        return existing;
    }
}
