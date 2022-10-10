package org.example;

import Fetchers.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

//        Request request = new Request("CAN", "SP.POP.TOTL"
//                , "2000", "2002");
//        WbApiModel model = new WbApiModel();
//
//        Response response = model.getData(request);

        // how a fetcher would be used
        populationFetcher pf = new populationFetcher("2002", "2000", "CAN");
        Map<String, Double> data = new HashMap<String, Double>();
        data = pf.getData();

        System.out.println(data.get("2000"));



    }
}
