package com.thoughtworks.api.core;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by syzhang on 7/10/16.
 */
public class OrderItem {
    @JsonProperty("product_id")
    private String product_id;
    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("amount")
    private float amount;
}
