package com.thoughtworks;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by syzhang on 7/7/16.
 */


public class Test1 {
    @Test
    public void testss(){
        assertThat(1, is(1));
    }
}
