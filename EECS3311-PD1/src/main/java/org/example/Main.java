package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws Exception {

        Request request = new Request("CAN", "SP.POP.TOTL"
                , "2000", "2002");
        WbApiModel model = new WbApiModel();

        Response response = model.getData(request);

        int value = response.getValue(2000);

        System.out.println(value);


    }
}
