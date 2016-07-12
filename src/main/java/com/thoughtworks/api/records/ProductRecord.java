package com.thoughtworks.api.records;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by syzhang on 7/9/16.
 */
public class ProductRecord  {

    @JsonProperty("product_id")
    private String product_id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("price")
    private float price;
    @JsonProperty("rating")
    private int rating;

    public String getProductId(){
        return product_id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public float getPrice(){
        return price;
    }

    public int getRating(){
        return rating;
    }

}
