package com.redhat.coolstore.cart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Configuration
public class CartServiceConfiguration {

	@Value("${rest.readTimeout}")
    private int readTimeOut;

	@Bean
    public JacksonJsonProvider jsonProvider(ObjectMapper objectMapper) {
        JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        provider.setMapper(objectMapper);
        return provider;
    }
    
	@LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate(getClientHttpRequestFactory());
    }
    
    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        int connectTimeout = 1000;
        int readTimeout = 1000;
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(connectTimeout);
        clientHttpRequestFactory.setReadTimeout(readTimeOut);
        return clientHttpRequestFactory;
    }

}
