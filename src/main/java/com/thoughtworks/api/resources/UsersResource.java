package com.thoughtworks.api.resources;

import com.thoughtworks.api.core.Order;
import com.thoughtworks.api.core.OrderItem;
import com.thoughtworks.api.core.UserRepository;
import com.thoughtworks.api.jersey.Routes;
import com.thoughtworks.api.records.OrderRecord;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by syzhang on 7/10/16.
 */

@Path("users")
public class UsersResource {

    @POST
    @Path("{userid}/orders")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrder(Map<String, Object> info,
                                @PathParam("userid") String userId,
                                @Context UserRepository userRepository){
        Routes routes = new Routes();
        return Response.created(routes.Order(userRepository.createOrder(info, userId), userId)).build();
    }

    @GET
    @Path("{userid}/orders")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getOrders(@PathParam("userid") String userId,
                                 @Context UserRepository userRepository){
        return userRepository.getOrders(userId);
    }

    @GET
    @Path("{userid}/orders/{orderid}")
    @Produces(MediaType.APPLICATION_JSON)
    public  Map<String, Object> getOrderDetail(@PathParam("orderid") String orderId,
                                               @PathParam("userid") String userId,
                                               @Context UserRepository userRepository){

        Order order = userRepository.getOrderById(userId, orderId);
        Map orderMap = new HashMap<String, Object>();
        orderMap.put("uri", order.getUri());
        orderMap.put("name", order.getName());
        orderMap.put("address", order.getAddress());
        orderMap.put("phone", order.getPhone());
        orderMap.put("total_price", order.getTotal_price());
        orderMap.put("create_at", order.getTime());
        orderMap.put("orderItem", userRepository.getOrderItemsById(orderId));

        return orderMap;
    }

    @POST
    @Path("{userid}/orders/{orderid}/payment")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPayment(Map<String, Object> info,
                                @PathParam("userid") String userId,
                                  @PathParam("orderid") String orderId,
                                @Context UserRepository userRepository){
        Routes routes = new Routes();
        userRepository.createPayment(info, orderId);
        return Response.created(routes.Payment(userId, orderId)).build();
    }

    @GET
    @Path("{userid}/orders/{orderid}/payment")
    @Produces(MediaType.APPLICATION_JSON)
    public  Map<String, Object> getPayment(@PathParam("orderid") String orderId,
                                               @PathParam("userid") String userId,
                                               @Context UserRepository userRepository){
        final String baseUri = "/";
        URI uri = URI.create(baseUri + "users/" + userId + "/orders/" + orderId);
        Map payMap = new HashMap<String, Object>();
        payMap.put("uri", uri);
        payMap.put("payment", userRepository.getPayment(userId, orderId));
        return payMap;
    }
}
