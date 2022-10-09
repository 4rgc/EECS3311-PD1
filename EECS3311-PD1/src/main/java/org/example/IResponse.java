package org.example;

import com.google.gson.JsonArray;

public interface IResponse {

    public JsonArray getJsonArray();

    public Double getValue(int year);
}
