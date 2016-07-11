package com.thoughtworks.api.jersey;

/**
 * Created by syzhang on 7/9/16.
 */

import com.thoughtworks.api.core.*;
import com.thoughtworks.api.records.ProductRecord;
import com.thoughtworks.api.records.OrderRecord;

import javax.ws.rs.core.UriInfo;
import java.net.URI;
public class Routes {

    private final String baseUri;

//    public Routes(UriInfo uriInfo) {
//        baseUri = "/";
//    }
    public Routes() {
        baseUri = "/";
    }

    public URI Product(ProductRecord product){
        return URI.create(baseUri + "products/" + product.getProductId());
    }

    public URI Order(OrderRecord order, String userId){
        return URI.create(baseUri + "users/" + userId + "/" + order.getOrderId());
    }

    public URI Payment(String userId, String orderId){
        return URI.create(baseUri + "users/" + userId + "/" + orderId + "/payment");
    }
}
