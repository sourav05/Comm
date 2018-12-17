package com.redhat.coolstore.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.redhat.coolstore.cart.model.Product;

@Component
public class CatalogServiceImpl implements CatalogService {

    @Value("${catalog-service.service.name}")
    private String catalogServiceUrl;
    
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Product getProduct(String itemId) {
//        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product> entity;
        try {
        	System.out.println("************* catalogServiceUrl *************" + catalogServiceUrl);
            entity = restTemplate.getForEntity("http://" + catalogServiceUrl + "/product/" + itemId, Product.class);
            return entity.getBody();
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            
            if (e.getRawStatusCode() == 404) {
                return null;
            } else {
                throw e;
            }
        }
    }

}
