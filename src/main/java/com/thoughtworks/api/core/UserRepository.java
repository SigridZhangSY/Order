package com.thoughtworks.api.core;

import com.thoughtworks.api.records.OrderRecord;

import java.util.List;
import java.util.Map;

/**
 * Created by syzhang on 7/10/16.
 */
public interface UserRepository {
     OrderRecord createOrder(Map<String, Object> info, String userId);
     List<Order> getOrders(String userID);
     Order getOrderById(String userId, String orderId);
     List<OrderItem> getOrderItemsById(String orderId);
     void createPayment(Map<String, Object> info, String orderId);
     Payment getPayment(String userId, String orderId);
}
