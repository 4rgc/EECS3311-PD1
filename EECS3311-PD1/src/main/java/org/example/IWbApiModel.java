package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public interface IWbApiModel {

    public Response getData(Request request) throws WbApiModel.WbApiModelException;

    public String callAPI() throws WbApiModel.WbApiModelException;
}
