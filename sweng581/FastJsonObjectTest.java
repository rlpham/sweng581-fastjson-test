package com.sweng581;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.junit.Assert;
import org.junit.Test;

public class FastJsonObjectTest {

    public class Data {
        @JSONField(name = "field1")
        public String field1;
        @JSONField(name = "field2")
        public String field2;

        public Field field;

        public Data() {

        }

        public Data(String val1, String val2) {
            this.field1 = val1;
            this.field2 = val2;
        }

        public Data(String val1, String val2, String val3) {
            this.field1 = val1;
            this.field2 = val2;
            this.field = new Field(val3);
        }
    }

    public class Field {
        @JSONField(name = "field3")
        public String field3;

        public Field(String val3) {
            this.field3 = val3;
        }

    }

    @Test
    public void deserializeEmptyObject() {
        Data data = new Data();
        String str = JSON.toJSONString(data);
        Assert.assertEquals(str, "{}");
    }

    @Test
    public void deserializeObjectWithDepthOf1() {
        Data data = new Data("foo", "bar");
        String str = JSON.toJSONString(data);
        Assert.assertEquals(str, "{\"field1\":\"foo\",\"field2\":\"bar\"}");
    }

    @Test
    public void deserializeObjectWithVariableDepth() {
        Data data = new Data("foo", "bar", "baz");
        String str = JSON.toJSONString(data);
        Assert.assertEquals(str, "{\"field\":{\"field3\":\"baz\"},\"field1\":\"foo\",\"field2\":\"bar\"}");
    }

    @Test
    public void serializeEmptyObject() {
        JSONObject jsonObject = JSON.parseObject("{}");
        Assert.assertEquals(jsonObject.toJSONString(), "{}");
    }

    @Test
    public void serializeObjectWithDepthOf1() {
        String data = "{\"field1\":\"foo\",\"field2\":\"bar\"}";
        JSONObject jsonObject = JSON.parseObject(data);
        Assert.assertEquals(jsonObject.toJSONString(), data);
        Assert.assertEquals(jsonObject.getString("field1").toString(), "foo");
        Assert.assertEquals(jsonObject.getString("field2").toString(), "bar");
    }

    @Test
    public void serializeObjectWithVariableDepth() {
        String data = "{\"field\":{\"field3\":\"baz\"},\"field1\":\"foo\",\"field2\":\"bar\"}";
        JSONObject jsonObject = JSON.parseObject(data);
        Assert.assertEquals(jsonObject.toJSONString(), "{\"field1\":\"foo\",\"field\":{\"field3\":\"baz\"},\"field2\":\"bar\"}");
        Assert.assertEquals(jsonObject.getString("field1").toString(), "foo");
        Assert.assertEquals(jsonObject.getString("field2").toString(), "bar");
        Assert.assertEquals(jsonObject.getJSONObject("field").getString("field3"), "baz");
    }

}
