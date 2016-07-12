package com.thoughtworks.api.infrastructure.resources;

import com.thoughtworks.api.infrastructure.core.ProductRepository;
import com.thoughtworks.api.support.ApiSupport;
import com.thoughtworks.api.support.ApiTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by syzhang on 7/12/16.
 */

@RunWith(ApiTestRunner.class)
public class ProductResourceTest extends ApiSupport{

    @Inject
    ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void should_able_to_get_all_products() {

//        Map productMap = new HashMap<String, Object>();
//        productMap.put("name", "apple");
//        productMap.put("description", "red apple");
//        productMap.put("price", 1);
//        productMap.put("rating", 5);
//        ProductRecord expect = product.create(productMap);
//        String productId = expect.getProductId();


        WebTarget target = target("/products");
        Response response = target.request().get();

        assertEquals(response.getStatus(), 200);
        final List<Map> product = response.readEntity(List.class);
        assertThat(product.get(0).get("uri"), is("/products/1"));
        assertThat(product.get(0).get("name"), is("apple"));
        assertThat(product.get(0).get("description"), is("red apple"));
        assertEquals(1, (Double) product.get(0).get("price"), 0.01);
        assertEquals(5, (int)product.get(0).get("rating"));

        response.close();
    }
}
