package com.thoughtworks.api.resources;

import com.thoughtworks.api.core.ProductRepository;
import com.thoughtworks.api.records.ProductRecord;
import com.thoughtworks.api.support.ApiTestRunner;
import com.thoughtworks.api.support.TestHelper;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.thoughtworks.api.core.*;
import com.thoughtworks.api.support.ApiSupport;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;



/**
 * Created by syzhang on 7/9/16.
 */



@RunWith(ApiTestRunner.class)
public class ProductsTest extends  ApiSupport {
    //public class ProductsTest extends JerseyTestNg.ContainerPerClassTest {

    @Inject
    ProductRepository product;

//    @Override
//    protected Application configure() {
//        return new ResourceConfig(ProductsResource.class);
//    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
//        admin = users.create(TestHelper.admin("test@tw.com"));
//        token = users.auth(admin);
    }


    @Test
    public void should_able_to_get_all_products() {

        Map productMap = new HashMap<String, Object>();
        productMap.put("name", "apple");
        productMap.put("description", "red apple");
        productMap.put("price", 1);
        productMap.put("rating", 5);
        ProductRecord expect = product.create(productMap);
        String productId = expect.getProductId();


        WebTarget target = target("/products");
        Response response = target.request().get();

        assertEquals(response.getStatus(), 200);
        final List<Map> product = response.readEntity(List.class);
        assertThat(product.get(0).get("uri"), is("/products/" + productId));
        assertThat(product.get(0).get("name"), is("apple"));
        assertThat(product.get(0).get("description"), is("red apple"));
        assertEquals(1, (Double) product.get(0).get("price"), 0.01);
        assertEquals(5, (int)product.get(0).get("rating"));

        response.close();
    }

    @Test
    public void should_able_to_create_product() throws Exception {
        Map productMap = new HashMap<String, Object>();
        productMap.put("name", "book");
        productMap.put("description", "dictionary");
        productMap.put("price", 12.5);
        productMap.put("rating", 4);

//        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target("http://0.0.0.0:8083/products");
        WebTarget target = target("/products");
        Response created = target.request().post(Entity.json(productMap));
        assertThat(created.getStatus(), is(HttpStatus.CREATED_201.getStatusCode()));
    }

    @Test
    public void should_able_to_get_a_product_by_id() {
        Map productMap = new HashMap<String, Object>();
        productMap.put("name", "book");
        productMap.put("description", "fiction");
        productMap.put("price", 9.5);
        productMap.put("rating", 4);
        ProductRecord expect = product.create(productMap);
        String productId = expect.getProductId();

//        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target("http://0.0.0.0:8083/products/" + productId);
        WebTarget target = target("/products/" + productId);
        Response response = target.request().get();

        assertEquals(response.getStatus(), 200);
        final Map product = response.readEntity(Map.class);
        assertThat(product.get("uri"), is("/products/" + productId));
        assertThat(product.get("name"), is("book"));
        assertThat(product.get("description"), is("fiction"));
        assertEquals(9.5, (Double) product.get("price"), 0.01);
        assertEquals(4, (int)product.get("rating"));

        response.close();
    }


}
