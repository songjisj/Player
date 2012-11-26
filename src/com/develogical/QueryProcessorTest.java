package com.develogical;

import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.StringContains.containsString;

public class QueryProcessorTest {

    @Test
    public void alwaysReturnsHello() throws Exception {
        assertThat(new QueryProcessor().process(""), containsString("Hello"));
    }
}
