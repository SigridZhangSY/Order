package com.thoughtworks.api.resources;

import com.thoughtworks.api.core.ProductRepository;
import com.thoughtworks.api.core.UserRepository;
import com.thoughtworks.api.records.OrderRecord;
import com.thoughtworks.api.records.ProductRecord;
import com.thoughtworks.api.support.ApiSupport;
import com.thoughtworks.api.support.ApiTestRunner;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by syzhang on 7/10/16.
 */

@RunWith(ApiTestRunner.class)
public class UsersResourceTest extends ApiSupport {

//    @Override
//    protected Application configure() {
//        return new ResourceConfig(UsersResource.class);
////        return new ResourceConfig(Resource.class);
//    }

    @Inject
    ProductRepository product;
    @Inject
    UserRepository user;
    @Before
    public void setUp() throws Exception {
        super.setUp();
//        admin = users.create(TestHelper.admin("test@tw.com"));
//        token = users.auth(admin);
    }

    @Test
    public void should_create_a_order() {
        Map productMap = new HashMap<String, Object>();
        productMap.put("name", "apple");
        productMap.put("description", "red apple");
        productMap.put("price", 1);
        productMap.put("rating", 5);
        ProductRecord expect = product.create(productMap);
        String productId = expect.getProductId();

        Map orderMap = new HashMap<String, Object>();
        orderMap.put("name", "kayla");
        orderMap.put("address", "beijing");
        orderMap.put("phone", "12300000000");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map orderIterm1 = new HashMap<String, Object>();
        orderIterm1.put("product_id", productId);
        orderIterm1.put("quantity", 2);
        list.add(orderIterm1);
        orderMap.put("orderItem", list);


//        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target("http://0.0.0.0:8083/users/1/orders");
        WebTarget target = target("/users/1/orders");
        Response created = target.request().post(Entity.json(orderMap));
        assertThat(created.getStatus(), is(HttpStatus.CREATED_201.getStatusCode()));

    }

    @Test
    public void should_able_to_get_all_orders() {
        Map productMap = new HashMap<String, Object>();
        productMap.put("name", "apple");
        productMap.put("description", "red apple");
        productMap.put("price", 1);
        productMap.put("rating", 5);
        ProductRecord expect = product.create(productMap);
        String productId = expect.getProductId();

        Map orderMap = new HashMap<String, Object>();
        orderMap.put("name", "kayla");
        orderMap.put("address", "beijing");
        orderMap.put("phone", "12300000000");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map orderIterm1 = new HashMap<String, Object>();
        orderIterm1.put("product_id", productId);
        orderIterm1.put("quantity", 2);
        list.add(orderIterm1);
        orderMap.put("orderItem", list);


//        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target("http://0.0.0.0:8083/users/1/orders");
        WebTarget target = target("/users/1/orders");

        Response response = target.request().get();
        response.close();
        assertEquals(response.getStatus(), 200);
    }

    @Test
    public void should_able_to_get_a_order_detail(){
        Map productMap = new HashMap<String, Object>();
        productMap.put("name", "apple");
        productMap.put("description", "red apple");
        productMap.put("price", 1);
        productMap.put("rating", 5);
        ProductRecord expect = product.create(productMap);
        String productId = expect.getProductId();
        Map orderMap = new HashMap<String, Object>();
        orderMap.put("name", "kayla");
        orderMap.put("address", "beijing");
        orderMap.put("phone", "12300000000");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map orderIterm1 = new HashMap<String, Object>();
        orderIterm1.put("product_id", productId);
        orderIterm1.put("quantity", 2);
        list.add(orderIterm1);
        orderMap.put("orderItem", list);
        OrderRecord expect_oreder = user.createOrder(orderMap, "1");
        String orderId = expect_oreder.getOrderId();

//        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target("http://0.0.0.0:8083/users/1/orders/" + orderId);
        WebTarget target = target("/users/1/orders/" + orderId);

        Response response = target.request().get();
        response.close();
        assertEquals(response.getStatus(), 200);
    }

    @Test
    public void should_able_to_create_a_payment(){

        Map productMap = new HashMap<String, Object>();
        productMap.put("name", "apple");
        productMap.put("description", "red apple");
        productMap.put("price", 1);
        productMap.put("rating", 5);
        ProductRecord expect = product.create(productMap);
        String productId = expect.getProductId();
        Map orderMap = new HashMap<String, Object>();
        orderMap.put("name", "kayla");
        orderMap.put("address", "beijing");
        orderMap.put("phone", "12300000000");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map orderIterm1 = new HashMap<String, Object>();
        orderIterm1.put("product_id", productId);
        orderIterm1.put("quantity", 2);
        list.add(orderIterm1);
        orderMap.put("orderItem", list);
        OrderRecord expect_oreder = user.createOrder(orderMap, "1");
        String orderId = expect_oreder.getOrderId();
        Map payMap = new HashMap<String, Object>();
        payMap.put("pay_type", "CASH");
        payMap.put("amount", "100");

//        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target("http://0.0.0.0:8083/users/1/orders/" + orderId + "/payment");
        WebTarget target = target("/users/1/orders/" + orderId + "/payment");

        Response created = target.request().post(Entity.json(payMap));
        assertThat(created.getStatus(), is(HttpStatus.CREATED_201.getStatusCode()));
    }

    @Test
    public void should_able_to_get_a_payment(){
        Map productMap = new HashMap<String, Object>();
        productMap.put("name", "apple");
        productMap.put("description", "red apple");
        productMap.put("price", 1);
        productMap.put("rating", 5);
        ProductRecord expect = product.create(productMap);
        String productId = expect.getProductId();
        Map orderMap = new HashMap<String, Object>();
        orderMap.put("name", "kayla");
        orderMap.put("address", "beijing");
        orderMap.put("phone", "12300000000");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map orderIterm1 = new HashMap<String, Object>();
        orderIterm1.put("product_id", productId);
        orderIterm1.put("quantity", 2);
        list.add(orderIterm1);
        orderMap.put("orderItem", list);
        OrderRecord expect_oreder = user.createOrder(orderMap, "1");
        String orderId = expect_oreder.getOrderId();
        Map payMap = new HashMap<String, Object>();
        payMap.put("pay_type", "CASH");
        payMap.put("amount", "100");
        user.createPayment(payMap, orderId);

//        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target("http://0.0.0.0:8083/users/1/orders/" + orderId + "/payment");
        WebTarget target = target("/users/1/orders/" + orderId + "/payment");

        Response response = target.request().get();
        assertEquals(response.getStatus(), 200);
//        final Map payment = response.readEntity(Map.class);
        response.close();
    }
}
