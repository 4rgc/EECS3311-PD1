package org.example;

import com.alibaba.fastjson.JSONObject;

public class JsonRecord implements IRecord {
    private String key;
    private JSONObject object;


    @Override
    public String getKey(String id) {
        return key;
    }

    @Override
    public Object getCell(String name) {
        return object.getString(name);
    }
}
