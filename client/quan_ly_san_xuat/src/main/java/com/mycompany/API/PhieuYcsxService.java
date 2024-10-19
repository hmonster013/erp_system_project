/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.API;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.Entity.PhieuYcsx;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Khoahihi79
 */
public class PhieuYcsxService {
    
    private static final String BASE_URL = "http://localhost:5106/api/phieuycsx";
    
    public PhieuYcsx getPhieuYcsxByMaYc(String maYc) throws IOException {
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + "/" + maYc);
        
        CloseableHttpResponse response = client.execute(httpGet);
        
          int statusCode = response.getStatusLine().getStatusCode();

         if (statusCode == 404) {
              return null;
          }
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }

        return new ObjectMapper().readValue(result.toString(), new TypeReference<PhieuYcsx> () {});
    }
    
     public List<PhieuYcsx> getAllPhieuYcsxByUrl(String url) throws IOException {
        List<PhieuYcsx> listPhieuYcsx = new ArrayList<>();
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + url);
        
        CloseableHttpResponse response = client.execute(httpGet);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        listPhieuYcsx = new ObjectMapper().readValue(result.toString(), new TypeReference<List<PhieuYcsx>> () {});
        return listPhieuYcsx;
    }
      
    public List<PhieuYcsx> getAllPhieuYcsx() throws IOException{
        return getAllPhieuYcsxByUrl("");
    }
    
    public PhieuYcsx createPhieuYcsx(PhieuYcsx phieuYcsx) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(BASE_URL);
        httpPost.setHeader("Content-Type", "application/json");
        
        StringEntity entity = new StringEntity(new ObjectMapper().writeValueAsString(phieuYcsx), StandardCharsets.UTF_8);
        httpPost.setEntity(entity);
        
        CloseableHttpResponse response = client.execute(httpPost);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8")); 
        String line;
        StringBuilder result = new StringBuilder();
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        return new ObjectMapper().readValue(result.toString(), PhieuYcsx.class);
    }
    
    public PhieuYcsx updatePhieuYcsx(String maYc, PhieuYcsx phieuYcsx) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPut httpPut  = new HttpPut(BASE_URL  + "/" + maYc);
        httpPut.setHeader("Content-Type", "application/json");

        StringEntity entity = new StringEntity(new ObjectMapper().writeValueAsString(phieuYcsx), StandardCharsets.UTF_8);
        httpPut.setEntity(entity);
        
        CloseableHttpResponse response = client.execute(httpPut);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }

           return new ObjectMapper().readValue(result.toString(), PhieuYcsx.class);
    }
    
    public boolean deletePhieuYcsx(String maYc) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpDelete httpDelete = new HttpDelete(BASE_URL + "/" + maYc);
        
        CloseableHttpResponse response = client.execute(httpDelete);
        return response.getStatusLine().getStatusCode() == 204;
    }
}
