package com.thoughtworks.api.records;

/**
 * Created by syzhang on 7/8/16.
 */

import com.thoughtworks.api.mappers.TestMapper;

import javax.inject.Inject;

public class MyRepository implements com.thoughtworks.api.core.MyRepository {

    @Inject
    TestMapper mapper ;

    public String getStr(){
        mapper.save();
        return "do save!";

    }
}
