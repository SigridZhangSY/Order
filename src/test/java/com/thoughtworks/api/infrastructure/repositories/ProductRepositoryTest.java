package com.thoughtworks.api.infrastructure.repositories;

import com.thoughtworks.api.infrastructure.core.ProductRepository;
import com.thoughtworks.api.support.DatabaseTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by syzhang on 7/12/16.
 */

@RunWith(DatabaseTestRunner.class)
public class ProductRepositoryTest {
    @Inject
    ProductRepository productRepository;

    @Test
    public void should_get_all_products(){
        productRepository.listProducts();
    }
}
