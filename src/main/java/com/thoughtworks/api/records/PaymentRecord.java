package com.thoughtworks.api.records;

/**
 * Created by syzhang on 7/10/16.
 */
public class PaymentRecord {
    private String pay_type;
    private float amount;
    private String pay_time;

    public String getPay_type(){return this.pay_type;}
    public float getAmount(){return this.amount;}
    public String getTime(){return this.pay_time;}
}
