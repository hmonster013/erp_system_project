/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.API;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.Entity.CtPhieuYcsx;
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
public class CtPhieuYcsxService {
    
    private static final String BASE_URL = "http://localhost:5106/api/ctphieuycsx";
    
    public List<CtPhieuYcsx> getAllCtPhieuYcsxByUrl(String url) throws IOException {
        List<CtPhieuYcsx> listCtPhieuYcsx = new ArrayList<>();
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + url);
        
        CloseableHttpResponse response = client.execute(httpGet);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        

        listCtPhieuYcsx = new ObjectMapper().readValue(result.toString(), new TypeReference<List<CtPhieuYcsx>> () {});
        return listCtPhieuYcsx;
    }
      
    public List<CtPhieuYcsx> getCtPhieuYcsxByMaYc(String maYc) throws IOException{
        return getAllCtPhieuYcsxByUrl("/search/" + maYc);
    }
    
    public CtPhieuYcsx createCtPhieuYcsx(CtPhieuYcsx ctPhieuYcsx) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(BASE_URL);
        httpPost.setHeader("Content-Type", "application/json");
        
        StringEntity entity = new StringEntity(new ObjectMapper().writeValueAsString(ctPhieuYcsx), StandardCharsets.UTF_8);
        httpPost.setEntity(entity);
        
        CloseableHttpResponse response = client.execute(httpPost);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8")); 
        String line;
        StringBuilder result = new StringBuilder();
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        return new ObjectMapper().readValue(result.toString(), CtPhieuYcsx.class);
    }
    
    public CtPhieuYcsx updateCtPhieuYcsx(String maYc, CtPhieuYcsx ctPhieuYcsx) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPut httpPut  = new HttpPut(BASE_URL  + "/" + maYc);
        httpPut.setHeader("Content-Type", "application/json");

        StringEntity entity = new StringEntity(new ObjectMapper().writeValueAsString(ctPhieuYcsx), StandardCharsets.UTF_8);
        httpPut.setEntity(entity);
        
        CloseableHttpResponse response = client.execute(httpPut);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }

           return new ObjectMapper().readValue(result.toString(), CtPhieuYcsx.class);
    }
    
    public boolean deleteCtPhieuYcsx(String maYc) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpDelete httpDelete = new HttpDelete(BASE_URL + "/" + maYc);
        
        CloseableHttpResponse response = client.execute(httpDelete);
        return response.getStatusLine().getStatusCode() == 204;
    }
}
