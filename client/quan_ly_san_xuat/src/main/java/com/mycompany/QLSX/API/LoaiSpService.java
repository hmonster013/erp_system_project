/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.QLSX.API;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.QLSX.Entity.LoaiSanPham;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Khoahihi79
 */
public class LoaiSpService {
    private static final String BASE_URL = "http://localhost:5106/api/loaisp";
    
    public List<LoaiSanPham> getAllLoaiSanPham() throws IOException {
        List<LoaiSanPham> listLoaiSanPham = new ArrayList<>();
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL);
        
        CloseableHttpResponse response = client.execute(httpGet);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        listLoaiSanPham = new ObjectMapper().readValue(result.toString(), new TypeReference<List<LoaiSanPham>> () {});
        return listLoaiSanPham;
    }
}
