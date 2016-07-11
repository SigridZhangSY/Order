package com.thoughtworks.api.resources;

/**
 * Created by syzhang on 7/8/16.
 */
import com.thoughtworks.api.core.MyRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("test")
public class TestMyresource {
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    public String getIt(@Context MyRepository myRepository){
        return myRepository.getStr();
    }
}
