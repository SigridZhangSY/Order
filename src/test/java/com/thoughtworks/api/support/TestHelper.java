package com.thoughtworks.api.support;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by syzhang on 7/11/16.
 */
public class TestHelper {

    public static Map<String, Object> anyProduct(String productId) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "book");
        map.put("description", "fiction");
        map.put("price", 12.5);
        map.put("rating", 4);
        return map;
    }

//    public static Map<String, Object> anyProduct() {
//        return TestHelper.user(Calendar.getInstance().getTimeInMillis() + "@thoughtworks.com");
//    }
}
