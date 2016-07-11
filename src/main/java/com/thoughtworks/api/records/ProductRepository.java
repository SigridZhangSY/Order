package com.thoughtworks.api.records;

import com.thoughtworks.api.mappers.ProductMapper;
import com.thoughtworks.api.core.Product;


import javax.inject.Inject;
import javax.ws.rs.core.UriInfo;
import java.util.*;

/**
 * Created by syzhang on 7/9/16.
 */

public class ProductRepository implements com.thoughtworks.api.core.ProductRepository {


    @Inject
    ProductMapper productMapper;

    public List<Product> getProducts(){
        List<Product> res = new ArrayList<Product>();
        List<ProductRecord> productRecords = productMapper.getAllProduct();
        for(int i = 0; i < productRecords.size(); i++){
            Product tem = new Product(productRecords.get(i));
//            tem.setUri(productRecords.get(i));
            res.add(tem);
        }
        return res;
    }


    public ProductRecord create(Map<String, Object> info) {
//        info.put("productId", String.valueOf(productMapper.getProductCount()+1));
        info.put("productId", nextIdentity());
        productMapper.save(info);

        return productMapper.findById(info.get("productId").toString());
    }

    public Optional<ProductRecord> getProductById(String productId){
        Optional<ProductRecord> record = Optional.ofNullable(productMapper.findById(productId));
//        Optional<Product> res = Optional.ofNullable(new Product(record.get()));
//        res.get().setUri(record);
//        return res;
        return record;
    }

    private String nextIdentity() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}

