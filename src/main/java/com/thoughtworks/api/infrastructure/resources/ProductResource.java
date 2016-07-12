package com.thoughtworks.api.infrastructure.resources;

import com.thoughtworks.api.infrastructure.core.Product;
import com.thoughtworks.api.infrastructure.core.ProductRepository;
import com.thoughtworks.api.web.jersey.Routes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by syzhang on 7/12/16.
 */

@Path("products")
public class ProductResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> listProducts(@Context ProductRepository product,
                                      @Context Routes route){
        return product.listProducts();
    }

}
