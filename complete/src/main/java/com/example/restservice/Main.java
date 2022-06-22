package com.example.restservice;

import org.apache.catalina.connector.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Main {


    public static void main(String[] args) {
        try {
            readResponse(createGetRequest("aamp")); //will work
            readResponse(createGetRequest("abcd"));   // will not work
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HttpURLConnection createGetRequest(String code) throws Exception {
        String urlString = "http://localhost:8080/betriebsstelle?code=" + code;
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        return con;
    }

    private static void readResponse(HttpURLConnection con) throws IOException {
        int responseCode = con.getResponseCode();
        System.out.println(responseCode);
        if(responseCode <= 200) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            System.out.println(content);
        }
    }
}
