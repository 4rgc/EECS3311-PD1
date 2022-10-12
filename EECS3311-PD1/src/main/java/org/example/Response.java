package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class Response implements IResponse{

    private JsonArray jsonArray;
    public Response(String jsonStringResponse){

        jsonArray = new JsonParser().parse(jsonStringResponse).getAsJsonArray();
    }
    public Response(){}

    public JsonArray getJsonArray(){
        return this.jsonArray;
    }

    public Double getValue(int year){
        int sizeOfResults = getSize();

        for(int i=0; i<sizeOfResults; i++){
            if(this.jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject()
                    .get("date").getAsInt() == year){
                if (this.jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject()
                        .get("value")==null){
                    return -1.0;
                }
                return this.jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject()
                        .get("value").getAsDouble();
            }
        }
        return null;
    }

    private int getSize(){
        return this.getJsonArray().get(1).getAsJsonArray().size();
    }






}
