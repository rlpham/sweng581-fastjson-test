package com.sweng581;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FastJsonArrayTest {

    public class Item {

        @JSONField(name = "name")
        public String name;

        @JSONField(name= "price")
        public double price;

        @JSONField(name = "isDiscounted")
        public boolean isDiscounted;

        public Item(String name, double price, boolean isDiscounted) {
            this.name = name;
            this.price = price;
            this.isDiscounted = isDiscounted;
        }
    }

    @Test
    public void deserializeEmptyJsonArray() {
        List<Item> items = new ArrayList<Item>();
        String json = JSON.toJSONString(items);
        Assert.assertEquals(json, "[]");
    }

    @Test
    public void deserializePopulatedJsonArray() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Carrots", 2.89, false));
        items.add(new Item("Bananas", 1.09, false));
        items.add(new Item("Milk", 4.69, false));
        String json = JSON.toJSONString(items);
        Assert.assertEquals(items.size(), 3);
        Assert.assertEquals(json, "[{\"isDiscounted\":false,\"name\":\"Carrots\",\"price\":2.89},{\"isDiscounted\":false,\"name\":\"Bananas\",\"price\":1.09},{\"isDiscounted\":false,\"name\":\"Milk\",\"price\":4.69}]");
    }

    @Test
    public void serializeEmptyJsonArray() {
        JSONObject jsonObject = JSON.parseObject("{\"array\":[]}");
        Assert.assertEquals(jsonObject.getJSONArray("array").size(), 0);
    }

    @Test
    public void serializePopulatedJsonArray() {
        String jsonString = "{\"array\":[{\"isDiscounted\":false,\"name\":\"Carrots\",\"price\":2.89},{\"isDiscounted\":false,\"name\":\"Bananas\",\"price\":1.09},{\"isDiscounted\":false,\"name\":\"Milk\",\"price\":4.69}]}";
        JSONObject json = JSON.parseObject(jsonString);
        Assert.assertEquals(json.getJSONArray("array").size(), 3);
    }
}
