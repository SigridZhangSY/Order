package com.thoughtworks.api.infrastructure.mybatis.mappers;

import com.thoughtworks.api.infrastructure.core.Product;

import java.util.List;

/**
 * Created by syzhang on 7/12/16.
 */
public interface ProductMapper {

    List<Product> findProducts();
}
