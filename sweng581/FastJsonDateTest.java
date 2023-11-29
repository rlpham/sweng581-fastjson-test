package com.sweng581;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FastJsonDateTest {

    final public String DATE_FORMAT_1 = "yyyy-MM-dd";
    final public String DATE_FORMAT_2 = "yyyy-MM-dd HH:mm:ss";
    final public String DATE_FORMAT_3 = "yyyy-MM-dd HH:mm:ss.SSS";
    final public String DATE_FORMAT_4 = "yyyy/MM/dd";
    final public String DATE_FORMAT_5 = "yyyy/MM/dd HH:mm:ss";
    final public String DATE_FORMAT_6 = "yyyy/MM/dd HH:mm:ss.SSS";

    @Test
    public void serializeDateString_format1() throws ParseException {
        Date date = new SimpleDateFormat(DATE_FORMAT_1).parse("2023-12-31");
        DefaultJSONParser parser = new DefaultJSONParser("{\"date\":\"2023-12-31\"}");
        parser.setDateFormat(DATE_FORMAT_1);
        JSONObject jsonObject = parser.parseObject();
        Assert.assertEquals(jsonObject.getDate("date").toString(), date.toString());
    }

    @Test
    public void serializeDateString_format2() throws ParseException {
        Date date = new SimpleDateFormat(DATE_FORMAT_2).parse("2023-12-31 01:59:30");
        DefaultJSONParser parser = new DefaultJSONParser("{\"date\":\"2023-12-31 01:59:30\"}");
        parser.setDateFormat(DATE_FORMAT_2);
        JSONObject jsonObject = parser.parseObject();
        Assert.assertEquals(jsonObject.getDate("date").toString(), date.toString());
    }

    @Test
    public void serializeDateString_format3() throws ParseException {
        Date date = new SimpleDateFormat(DATE_FORMAT_3).parse("2023-12-31 01:59:30.123");
        DefaultJSONParser parser = new DefaultJSONParser("{\"date\":\"2023-12-31 01:59:30.123\"}");
        parser.setDateFormat(DATE_FORMAT_3);
        JSONObject jsonObject = parser.parseObject();
        Assert.assertEquals(jsonObject.getDate("date").toString(), date.toString());
    }

    @Test
    public void serializeDateString_format4() throws ParseException {
        Date date = new SimpleDateFormat(DATE_FORMAT_4).parse("2023/12/31");
        DefaultJSONParser parser = new DefaultJSONParser("{\"date\":\"2023/12/31\"}");
        parser.setDateFormat(DATE_FORMAT_4);
        JSONObject jsonObject = parser.parseObject();
        Assert.assertEquals(jsonObject.getDate("date").toString(), date.toString());
    }

    @Test
    public void serializeDateString_format5() throws ParseException {
        Date date = new SimpleDateFormat(DATE_FORMAT_5).parse("2023/12/31 01:59:30");
        DefaultJSONParser parser = new DefaultJSONParser("{\"date\":\"2023/12/31 01:59:30\"}");
        parser.setDateFormat(DATE_FORMAT_5);
        JSONObject jsonObject = parser.parseObject();
        Assert.assertEquals(jsonObject.getDate("date").toString(), date.toString());
    }

    @Test
    public void serializeDateString_format6() throws ParseException {
        Date date = new SimpleDateFormat(DATE_FORMAT_6).parse("2023/12/31 01:59:30.123");
        DefaultJSONParser parser = new DefaultJSONParser("{\"date\":\"2023/12/31 01:59:30.123\"}");
        parser.setDateFormat(DATE_FORMAT_6);
        JSONObject jsonObject = parser.parseObject();
        Assert.assertEquals(jsonObject.getDate("date").toString(), date.toString());
    }

    @Test
    public void serializeInvalidDateString_format1() throws ParseException {
        Date date = new SimpleDateFormat(DATE_FORMAT_1).parse("2023-12-31");
        DefaultJSONParser parser = new DefaultJSONParser("{\"date\":\"2023.12/31\"}");
        parser.setDateFormat(DATE_FORMAT_1);
        JSONObject jsonObject = parser.parseObject();
        Assert.assertThrows(NumberFormatException.class, () -> {
            jsonObject.getDate("date").toString();
        });
    }

    @Test
    public void serializeInvalidDateString_format2() throws ParseException {
        Date date = new SimpleDateFormat(DATE_FORMAT_2).parse("2023-12-31 01:59:30");
        DefaultJSONParser parser = new DefaultJSONParser("{\"date\":\"2023.12/31 01:59:30\"}");
        parser.setDateFormat(DATE_FORMAT_2);
        JSONObject jsonObject = parser.parseObject();
        Assert.assertThrows(NumberFormatException.class, () -> {
            jsonObject.getDate("date").toString();
        });
    }

    @Test
    public void serializeInvalidDateString_format3() throws ParseException {
        Date date = new SimpleDateFormat(DATE_FORMAT_3).parse("2023-12-31 01:59:30.123");
        DefaultJSONParser parser = new DefaultJSONParser("{\"date\":\"2023.12/31 01:59:30.123\"}");
        parser.setDateFormat(DATE_FORMAT_3);
        JSONObject jsonObject = parser.parseObject();
        Assert.assertThrows(NumberFormatException.class, () -> {
            jsonObject.getDate("date").toString();
        });
    }

    @Test
    public void serializeInvalidDateString_format4() throws ParseException {
        Date date = new SimpleDateFormat(DATE_FORMAT_4).parse("2023/12/31");
        DefaultJSONParser parser = new DefaultJSONParser("{\"date\":\"2023.12/31\"}");
        parser.setDateFormat(DATE_FORMAT_4);
        JSONObject jsonObject = parser.parseObject();
        Assert.assertThrows(NumberFormatException.class, () -> {
            jsonObject.getDate("date").toString();
        });
    }

    @Test
    public void serializeInvalidDateString_format5() throws ParseException {
        Date date = new SimpleDateFormat(DATE_FORMAT_5).parse("2023/12/31 01:59:30");
        DefaultJSONParser parser = new DefaultJSONParser("{\"date\":\"2023.12/31 01:59:30\"}");
        parser.setDateFormat(DATE_FORMAT_5);
        JSONObject jsonObject = parser.parseObject();
        Assert.assertThrows(NumberFormatException.class, () -> {
            jsonObject.getDate("date").toString();
        });
    }

    @Test
    public void serializeInvalidDateString_format6() throws ParseException {
        Date date = new SimpleDateFormat(DATE_FORMAT_6).parse("2023/12/31 01:59:30.123");
        DefaultJSONParser parser = new DefaultJSONParser("{\"date\":\"2023.12/31 01:59:30.123\"}");
        parser.setDateFormat(DATE_FORMAT_6);
        JSONObject jsonObject = parser.parseObject();
        Assert.assertThrows(NumberFormatException.class, () -> {
            jsonObject.getDate("date").toString();
        });
    }


}
