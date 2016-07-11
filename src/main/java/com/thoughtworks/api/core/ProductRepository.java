package com.thoughtworks.api.core;

import com.thoughtworks.api.records.ProductRecord;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by syzhang on 7/9/16.
 */
public interface ProductRepository {
    List<Product> getProducts();
    ProductRecord create(Map<String, Object> info);
    Optional<ProductRecord> getProductById(String productId);
//    String nextIdentity();

}
