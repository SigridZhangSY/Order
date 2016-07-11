package com.thoughtworks.api.records;

/**
 * Created by syzhang on 7/10/16.
 */
public class OrderRecord {

    private String order_id;
    private String user_id;
    private String user_name;
    private String user_address;
    private String user_phone;
    private String order_time;
    private float total_price;


    public String getOrderId(){return this.order_id;}
    public String getName(){return this.user_name;}
    public String getAddress(){return this.user_address;}
    public String getPhone(){return this.user_phone;}
    public float getPrice(){return this.total_price;}
    public String getTime(){return this.order_time;}

}


