package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public interface IWbApiModel {

    public Response getData(Request request);

    public String callAPI();
}
