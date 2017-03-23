package com.springBootPetProject.service;

import com.springBootPetProject.model.SiteDTO;
import com.springBootPetProject.model.SitesDTO;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Client for loading List of StackOverflowSites through StackExchange API using RestTemplate.
 *
 * Created by nolik on 22.03.17.
 */

@Component
public class StackExchangeClient {
    HttpClient httpClient = HttpClientBuilder.create().build();
    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private RestTemplate restTemplate = new RestTemplate(requestFactory);

    public List<SiteDTO> getSites() {
        String url = "https://api.stackexchange.com/2.2/sites?page=1&pagesize=9999&filter=!Fn4IB7S7T4v-QOAVmFyqlc%28HdV";

        try {
            SitesDTO response = restTemplate.getForObject(new URI(url), SitesDTO.class);
            return response.getItems();

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
