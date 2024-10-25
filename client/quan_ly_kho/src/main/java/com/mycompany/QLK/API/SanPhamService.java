/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.QLK.API;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.Entity.SanPham;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.methods.CloseableHttpResponse;
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
public class SanPhamService {
    private static final String BASE_URL = "http://localhost:5106/api/sanpham";
    
    public SanPham getSanPhamByMaSp(String maSp) throws IOException {
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + "/" + maSp);
        
        CloseableHttpResponse response = client.execute(httpGet);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }

        return new ObjectMapper().readValue(result.toString(), new TypeReference<SanPham> () {});
    }
    
    public List<SanPham> getAllSanPhamByUrl(String url) throws IOException {
        List<SanPham> listSanPham = new ArrayList<>();
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + url);
        
        CloseableHttpResponse response = client.execute(httpGet);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        listSanPham = new ObjectMapper().readValue(result.toString(), new TypeReference<List<SanPham>> () {});
        return listSanPham;
    }
      
    public List<SanPham> getAllSanPham() throws IOException{
        return getAllSanPhamByUrl("");
    }
    
    public String getTenSpByMaSp(String maSp) throws IOException {
       String tenSp = "";
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + "/ten/" + maSp);
        
        CloseableHttpResponse response = client.execute(httpGet);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        SanPham sanPham = new ObjectMapper().readValue(result.toString(), SanPham.class);
        tenSp = sanPham.getTenSp();

         return tenSp;
    }
    
    public SanPham updateSanPham(String maSp, SanPham sanPham) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPut httpPut  = new HttpPut(BASE_URL  + "/" + maSp);
        httpPut.setHeader("Content-Type", "application/json");

        StringEntity entity = new StringEntity(new ObjectMapper().writeValueAsString(sanPham), StandardCharsets.UTF_8);
        httpPut.setEntity(entity);
        
        CloseableHttpResponse response = client.execute(httpPut);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }

           return new ObjectMapper().readValue(result.toString(), SanPham.class);
    }
}
