package com.thoughtworks.api.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.api.records.OrderRecord;

import java.net.URI;
import java.util.Map;
import java.util.Objects;

/**
 * Created by syzhang on 7/10/16.
 */
public class Order {
    @JsonProperty("uri")
    private URI uri;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("total_price")
    private float total_price;
    @JsonProperty("time")
    private String time;

    public Order(OrderRecord record, String user_id){
        final String baseUri = "/";

        this.uri = URI.create(baseUri + "users/" + user_id + "/orders/" + record.getOrderId());
        this.name = record.getName();
        this.address = record.getAddress();
        this.phone = record.getPhone();
        this.total_price = record.getPrice();
        this.time = record.getTime();
    }

    public URI getUri(){return this.uri;}
    public String getName(){return this.name;}
    public String getAddress(){return this.address;}
    public String getPhone(){return this.phone;}
    public float getTotal_price(){return this.total_price;}
    public String getTime(){return this.time;}


}
