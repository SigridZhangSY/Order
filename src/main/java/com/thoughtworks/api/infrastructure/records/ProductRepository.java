package com.thoughtworks.api.infrastructure.records;

import com.thoughtworks.api.infrastructure.core.Product;
import com.thoughtworks.api.infrastructure.mybatis.mappers.ProductMapper;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by syzhang on 7/12/16.
 */
public class ProductRepository implements com.thoughtworks.api.infrastructure.core.ProductRepository{

    @Inject
    ProductMapper productMapper;

    public List<Product> listProducts(){
        return productMapper.findProducts();
    }
}
