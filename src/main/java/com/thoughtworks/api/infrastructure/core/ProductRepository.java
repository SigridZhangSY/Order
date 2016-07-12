package com.thoughtworks.api.infrastructure.core;

import java.util.List;

/**
 * Created by syzhang on 7/12/16.
 */
public interface ProductRepository {
    List<Product> listProducts();
}
