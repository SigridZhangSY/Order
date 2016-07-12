package com.thoughtworks.api.resources;

import com.thoughtworks.api.core.ProductRepository;
import com.thoughtworks.api.core.Product;
import com.thoughtworks.api.jersey.Routes;
import com.thoughtworks.api.records.ProductRecord;


import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by syzhang on 7/9/16.
 */
@Path("products")
public class ProductsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product>  getProductList(@Context ProductRepository productRepository){
        List<Product> res = productRepository.getProducts();

        return productRepository.getProducts();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(Map<String, Object> info,
                                  @Context ProductRepository productRepository){
        Routes routes = new Routes();
        return Response.created(routes.Product(productRepository.create(info))).build();
    }

    @GET
    @Path("{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("productId") String productId,
                                  @Context ProductRepository productRepository){

//        return productRepository.getProductById(productId);
        ProductRecord record = productRepository.getProductById(productId).orElseThrow(() -> new NotFoundException("Product not found"));

        return new Product(record);
    }

}
