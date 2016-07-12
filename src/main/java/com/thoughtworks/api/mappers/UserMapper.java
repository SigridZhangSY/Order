package com.thoughtworks.api.mappers;

import com.thoughtworks.api.core.Order;
import com.thoughtworks.api.core.OrderItem;
import com.thoughtworks.api.core.Payment;
import com.thoughtworks.api.records.OrderRecord;
import com.thoughtworks.api.records.PaymentRecord;

import java.util.List;
import java.util.Map;

/**
 * Created by syzhang on 7/10/16.
 */
public interface UserMapper {
    public void saveOrder(Map<String, Object> Order);
    public OrderRecord findById(String order_id);
    public void saveOrderItem(Map<String, Object> OrderItem);
    public int getOrderCount();
    public float getProductPrice(String product_id);
    public List<OrderRecord> getOrders(String user_id);
    public List<OrderItem> findOrderItemsById(String order_id);
    public void savePayment(Map<String, Object> info);
    public PaymentRecord findPayment(String order_id);
}
