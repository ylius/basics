package com.example.listview;

import android.util.Log;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

public class VividSeatsApi {
    private static final String URL = "https://webservices.vividseats.com/rest/mobile/v1/home/cards";
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private final OkHttpClient client;

    public VividSeatsApi() {
        this.client = new OkHttpClient();
    }

    public String searchForEvents(String sd, String ed) throws IOException {
        String jsonString = "{\n" +
                "  \"startDate\": \""+ sd + "\",\n" +
                "  \"endDate\": \""+ ed +"\",\n" +
                "  \"includeSuggested\": \"true\"\n" +
                "}";
        RequestBody requestBody = RequestBody.create(JSON, jsonString);
        Request request = new Request.Builder()
                .url(URL)
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        String responseBodyString = response.body().string(); // The response body can be consumed only once
        response.close();
        Log.d("VividSeatsApi", responseBodyString);
        return responseBodyString;
    }
}
