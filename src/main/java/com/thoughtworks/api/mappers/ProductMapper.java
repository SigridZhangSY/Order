package com.thoughtworks.api.mappers;

import com.thoughtworks.api.records.ProductRecord;

import java.util.List;
import java.util.Map;

/**
 * Created by syzhang on 7/9/16.
 */
public interface ProductMapper {
    List<ProductRecord> getAllProduct();
    void save(Map<String, Object> info);
    ProductRecord findById(String productId);
    int getProductCount();
}
