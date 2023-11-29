package com.sweng581;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.junit.Assert;
import org.junit.Test;

public class FastJSONStringNumberBooleanTest {

    public class Person {

        @JSONField(name = "name")
        public String name;

        @JSONField(name = "age")
        public int age;

        @JSONField(name = "isHungry")
        public boolean isHungry;

        public Person(String name) {
            this.name = name;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Person(String name, int age, boolean isHungry) {
            this.name = name;
            this.age = age;
            this.isHungry = isHungry;
        }
    }

    @Test
    public void serializeEmptyString() {
        String json = "{\"name\":\"\"}";
        Person person = JSON.parseObject(json, Person.class);
        Assert.assertEquals(person.name, "");
    }

    @Test
    public void deserializeValues() {
        Person person = new Person("Ryan Pham", 100, false);
        String json = JSON.toJSONString(person);
        Assert.assertEquals(json, "{\"age\":100,\"isHungry\":false,\"name\":\"Ryan Pham\"}");
    }

    @Test
    public void serializeBasicString() {
        String json = "{\"name\":\"Ryan Pham\"}";
        Person person = JSON.parseObject(json, Person.class);
        Assert.assertEquals(person.name, "Ryan Pham");
    }

    @Test
    public void serializeBasicStringWithNumbers() {
        String json = "{\"name\":\"Ryan123Pham\"}";
        Person person = JSON.parseObject(json, Person.class);
        Assert.assertEquals(person.name, "Ryan123Pham");
    }

    @Test
    public void serializeIntegerNoQuotes() {
        String json = "{\"name\":\"Ryan Pham\",\"age\": 100}";
        Person person = JSON.parseObject(json, Person.class);
        Assert.assertEquals(person.name, "Ryan Pham");
        Assert.assertEquals(person.age, 100);
    }

    @Test
    public void serializeIntegerWithQuotes() {
        String json = "{\"name\":\"Ryan Pham\",\"age\": \"100\"}";
        Person person = JSON.parseObject(json, Person.class);
        Assert.assertEquals(person.name, "Ryan Pham");
        Assert.assertEquals(person.age, 100);
    }

    @Test
    public void serializeBooleanTrue() {
        String json = "{\"name\":\"Ryan Pham\",\"age\": 100,\"isHungry\": true}";
        Person person = JSON.parseObject(json, Person.class);
        Assert.assertEquals(person.name, "Ryan Pham");
        Assert.assertEquals(person.age, 100);
        Assert.assertTrue(person.isHungry);
    }

    @Test
    public void serializeInvalidBooleanValue() {
        String json = "{\"name\":\"Ryan Pham\",\"age\": 100,\"isHungry\": yes}";
        Assert.assertThrows(JSONException.class, () -> {
            Person person = JSON.parseObject(json, Person.class);
        });
    }

}
