package com.sweng581;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class FastJsonSemanticsTest {

    @Test
    public void correctJSONString() {
        JSONObject jsonObject = JSON.parseObject("{ \"array\": [ 1, 2, 3 ], \"boolean\": true, \"color\": \"gold\", \"number\": 123, \"object\": { \"a\": \"b\", \"c\": \"d\" }, \"string\": \"Hello World\" }");
        Assert.assertEquals(jsonObject.getJSONArray("array").get(0), 1);
        Assert.assertEquals(jsonObject.getJSONArray("array").get(1), 2);
        Assert.assertEquals(jsonObject.getJSONArray("array").get(2), 3);
        Assert.assertTrue(jsonObject.getBoolean("boolean"));
        Assert.assertEquals(jsonObject.getString("color"), "gold");
        Assert.assertEquals(jsonObject.getIntValue("number"), 123);
        Assert.assertEquals(jsonObject.getJSONObject("object").getString("a"), "b");
        Assert.assertEquals(jsonObject.getJSONObject("object").getString("c"), "d");
        Assert.assertEquals(jsonObject.getString("string"), "Hello World");
    }

    @Test
    public void missingColon() {
        String str = "{\"missingColon\"}";
        Assert.assertThrows(JSONException.class, () -> {
            JSON.parseObject(str);
        });
    }

    @Test
    public void numberError() {
        String str = "{\"myNumber\":$A}";
        Assert.assertThrows(JSONException.class, () -> {
            JSON.parseObject(str);
        });
    }

    @Test
    public void numberError2() {
        String str = "{\"myNumber\":9ab}";
        Assert.assertThrows(JSONException.class, () -> {
            JSON.parseObject(str);
        });
    }

    @Test
    public void missingQuotationMarks() {
        String str = "{noQuotationMarksError}";
        Assert.assertThrows(JSONException.class, () -> {
            JSON.parseObject(str);
        });
    }
}

