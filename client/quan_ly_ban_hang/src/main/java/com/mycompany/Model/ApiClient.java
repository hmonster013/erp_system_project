package com.mycompany.Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class ApiClient {
    private final Gson gson;
    private final String baseUrl;

    public ApiClient(String baseUrl) {
        this.gson = new Gson();
        this.baseUrl = baseUrl;
    }

    // Phương thức GET với Type
    public <T> T get(String endpoint, Type responseType) throws Exception {
        String urlString = baseUrl + endpoint;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");

        int responseCode = conn.getResponseCode();
        StringBuilder content = new StringBuilder();
        String inputLine;

        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Đọc phản hồi từ API
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
            }
            return gson.fromJson(content.toString(), responseType);
        } else if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
            return null;
        } else {
            throw new Exception("HTTP Error: " + responseCode + " - " + conn.getResponseMessage());
        }
    }

    // Phương thức GET trả về danh sách đối tượng
    public <T> T get(String endpoint, TypeToken<T> typeToken) throws Exception {
        String urlString = baseUrl + endpoint;
        HttpURLConnection conn = (HttpURLConnection) new URL(urlString).openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");

        // Đọc phản hồi từ API
        return handleResponse(conn, typeToken.getType());
    }

    // Phương thức POST
    public boolean post(String endpoint, Object requestDto) throws Exception {
        String urlString = baseUrl + endpoint;
        HttpURLConnection conn = (HttpURLConnection) new URL(urlString).openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        writeRequest(conn, requestDto);

        int responseCode = conn.getResponseCode();
        conn.disconnect();

        return responseCode == HttpURLConnection.HTTP_CREATED;
    }

    // Phương thức PUT
    public boolean put(String endpoint, Object requestDto) throws Exception {
        String urlString = baseUrl + endpoint;
        HttpURLConnection conn = (HttpURLConnection) new URL(urlString).openConnection();
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        writeRequest(conn, requestDto);

        int responseCode = conn.getResponseCode();
        conn.disconnect();

        return responseCode == HttpURLConnection.HTTP_OK;
    }

    // Phương thức DELETE
    public boolean delete(String endpoint) throws Exception {
        String urlString = baseUrl + endpoint;
        HttpURLConnection conn = (HttpURLConnection) new URL(urlString).openConnection();
        conn.setRequestMethod("DELETE");
        conn.setRequestProperty("Content-Type", "application/json");
        
        int responseCode = conn.getResponseCode();
        conn.disconnect();

        return responseCode == HttpURLConnection.HTTP_NO_CONTENT;
    }

    // Phương thức xử lý phản hồi từ API
    private <T> T handleResponse(HttpURLConnection conn, Class<T> responseType) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder content = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        conn.disconnect();

        return gson.fromJson(content.toString(), responseType);
    }

    // Phương thức xử lý phản hồi từ API cho TypeToken
    private <T> T handleResponse(HttpURLConnection conn, java.lang.reflect.Type type) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder content = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        conn.disconnect();

        return gson.fromJson(content.toString(), type);
    }

    // Phương thức viết request
    private void writeRequest(HttpURLConnection conn, Object requestDto) throws Exception {
        String jsonInputString = gson.toJson(requestDto);
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
    }
}
