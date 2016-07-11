package com.thoughtworks.api.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.api.records.ProductRecord;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;



/**
 * Created by syzhang on 7/9/16.
 */
public class Product {
    @JsonProperty("uri")
    private URI uri;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("price")
    private float price;
    @JsonProperty("rating")
    private int rating;

    public Product(ProductRecord record){
        final String baseUri = "/";

        this.uri = URI.create(baseUri + "products/" + record.getProductId());
        this.name = record.getName();
        this.description = record.getDescription();
        this.price = record.getPrice();
        this.rating = record.getRating();
    }

//    //public void setUri(UriInfo uri, ProductRecord record){
//    public void setUri(ProductRecord record){
//        //UriBuilder builder = uri.getRequestUriBuilder();
//        //UriBuilder builder = uri.getAbsolutePathBuilder();
//        //builder.path(record.getProductId());
//        final String baseUri = "/";
//
//        this.uri = URI.create(baseUri + "products/" + record.getProductId());
//
//    }

}
