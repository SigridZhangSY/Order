package com.thoughtworks.api.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.api.records.PaymentRecord;

import java.net.URI;

/**
 * Created by syzhang on 7/10/16.
 */
public class Payment {
    @JsonProperty("uri")
    private URI uri;
    @JsonProperty("pay_type")
    private String pay_type;
    @JsonProperty("amount")
    private float amount;
    @JsonProperty("time")
    private String time;

    public Payment(String user_id, String order_id, PaymentRecord paymentRecord){
        final String baseUri = "/";

        this.uri = URI.create(baseUri + "users/" + user_id + "/orders/" + order_id + "/payment");
        this.pay_type = paymentRecord.getPay_type();
        this.amount = paymentRecord.getAmount();
        this.time = paymentRecord.getTime();
    }

}
