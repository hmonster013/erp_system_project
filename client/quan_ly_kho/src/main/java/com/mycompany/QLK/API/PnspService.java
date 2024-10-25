/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.QLK.API;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.Entity.PhieuNhapSp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Khoahihi79
 */
public class PnspService {
    
   private static final String BASE_URL = "http://localhost:5106/api/phieunhapsp";
    
    public PhieuNhapSp createPhieuNhapSanPham(PhieuNhapSp phieuNhapSp) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(BASE_URL);
        httpPost.setHeader("Content-Type", "application/json");
        
        StringEntity entity = new StringEntity(new ObjectMapper().writeValueAsString(phieuNhapSp), StandardCharsets.UTF_8);
        httpPost.setEntity(entity);
        
        CloseableHttpResponse response = client.execute(httpPost);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8")); 
        String line;
        StringBuilder result = new StringBuilder();
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        return new ObjectMapper().readValue(result.toString(), PhieuNhapSp.class);
    }
    
    public PhieuNhapSp getPhieuNhapByMaPhieu(String maPhieu) throws IOException {
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + "/" + maPhieu);
        
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

        return new ObjectMapper().readValue(result.toString(), new TypeReference<PhieuNhapSp> () {});
    }

}
