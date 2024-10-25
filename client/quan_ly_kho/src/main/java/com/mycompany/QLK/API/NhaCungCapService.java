/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.QLK.API;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.Entity.NhaCungCap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.UriHttpRequestHandlerMapper;

/**
 *
 * @author Khoahihi79
 */
public class NhaCungCapService {
    
    private static final String BASE_URL = "http://localhost:5106/api/nhacungcap";
    
    public List<NhaCungCap> getAllNhaCungCapByUrl(String url) throws IOException {
        
        List<NhaCungCap> listNhaCungCap = new ArrayList<>();
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + url);
        
        CloseableHttpResponse response = client.execute(httpGet);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        listNhaCungCap = new ObjectMapper().readValue(result.toString(), new TypeReference<List<NhaCungCap>> () {});
        return listNhaCungCap;
    }
      
    public List<NhaCungCap> getAllNhaCungCap() throws IOException{
        return getAllNhaCungCapByUrl("");
    }
    
     public String getMaNccByTenNcc(String tenNcc) throws IOException {
         
         String maNcc = "";

        String encodedName = URLEncoder.encode(tenNcc, StandardCharsets.UTF_8.toString()).replace("+", "%20");
         
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + "/ten/" + encodedName);
        
        CloseableHttpResponse response = client.execute(httpGet);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        
        NhaCungCap nhaCungCap = new ObjectMapper().readValue(result.toString(), NhaCungCap.class);
        maNcc = nhaCungCap.getMaNcc();

         return maNcc;
    }
}
