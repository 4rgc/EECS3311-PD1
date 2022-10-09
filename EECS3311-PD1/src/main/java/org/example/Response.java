package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class Response {

    private JsonArray jsonArray;
    public Response(String jsonStringResponse){

        jsonArray = new JsonParser().parse(jsonStringResponse).getAsJsonArray();
    }
    public Response(){}

    public JsonArray getJsonArray(){
        return this.jsonArray;
    }

    public int getValue(int year){
        int sizeOfResults = this.jsonArray.get(1).getAsJsonArray().size();

        for(int i=0; i<sizeOfResults; i++){
            if(this.jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject()
                    .get("date").getAsInt() == year){
                return this.jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject()
                        .get("value").getAsInt();
            }
        }
        return -1;
    }







}
