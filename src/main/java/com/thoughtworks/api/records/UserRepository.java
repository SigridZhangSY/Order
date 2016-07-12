package com.thoughtworks.api.records;

import com.thoughtworks.api.core.Order;
import com.thoughtworks.api.core.OrderItem;
import com.thoughtworks.api.core.Payment;
import com.thoughtworks.api.mappers.UserMapper;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by syzhang on 7/10/16.
 */

public class UserRepository implements com.thoughtworks.api.core.UserRepository{

    @Inject
    UserMapper userMapper;

    public OrderRecord createOrder(Map<String, Object> info, String userId){
//        String OrderId = String.valueOf(userMapper.getOrderCount()+1);
        String OrderId = nextIdentity();
        float total_price = 0;

        List<Map<String, Object>> orderItemList = new ArrayList<Map<String, Object>>();
        orderItemList = (List<Map<String, Object>>)(info.get("orderItem"));
        for(int i = 0; i < orderItemList.size(); i++){
            float amount = userMapper.getProductPrice((String)orderItemList.get(i).get("product_id")) * (int)orderItemList.get(i).get("quantity");
            orderItemList.get(i).put("amount", amount);
            total_price += amount;
        }
        Map Order = new HashMap<String, Object>();
        Order.put("order_id", OrderId);
        Order.put("user_id", userId);
        Order.put("name", info.get("name"));
        Order.put("address", info.get("address"));
        Order.put("phone", info.get("phone"));
        Order.put("payment", info.get("no"));
        Order.put("total_price", total_price);
        userMapper.saveOrder(Order);

        for(int i = 0; i < orderItemList.size(); i++){
            orderItemList.get(i).put("order_id", OrderId);
            userMapper.saveOrderItem(orderItemList.get(i));
        }


        return userMapper.findById(OrderId);
    }

    public List<Order> getOrders(String user_id){
        List<Order> res = new ArrayList<Order>();
        List<OrderRecord> orderRecords = userMapper.getOrders(user_id);
        for(int i = 0; i < orderRecords.size(); i++){
            Order tem = new Order(orderRecords.get(i), user_id);
            res.add(tem);
        }
        return res;
    }

    public Order getOrderById(String userId, String orderId){

//        Order res = new Order(userMapper.findById(orderId), userId);
        OrderRecord tem = userMapper.findById(orderId);
        Order res = new Order(tem, userId);
        return res;
    }

    public List<OrderItem> getOrderItemsById(String orderId){
        return userMapper.findOrderItemsById(orderId);
    }

    public void createPayment(Map<String, Object> info, String orderId){
        info.put("order_id", orderId);
        userMapper.savePayment(info);
    }

    public Payment getPayment(String userId, String orderId){
        Payment res = new Payment(userId, orderId, userMapper.findPayment(orderId));
        return res;
    }

    private String nextIdentity() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
