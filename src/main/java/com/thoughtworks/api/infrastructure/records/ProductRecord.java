package com.thoughtworks.api.infrastructure.records;

import com.thoughtworks.api.infrastructure.core.Product;
import com.thoughtworks.api.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by syzhang on 7/12/16.
 */

//*************** add implemrnts Record
public class ProductRecord implements Product, Record{
    String id;
    String name;
    String description;
    float price;
    float rating;




    public String getId(){return id;}
    public String getName(){return name;}
    public String getDescription(){return description;}
    public float getPrice(){return price;}
    public float getRating(){return rating;}

    @Override
    public Map<String, Object> toJson(Routes routes) {
        Map<String, Object> map = new HashMap<>();
        map.put("uri", routes.product(ProductRecord.this));
        map.put("name", name);
        map.put("description", description);
        map.put("price", price);
        map.put("rating", rating);
//        map.put("links", links(routes));
        return map;
    }
    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return toJson(routes);
    }
}
