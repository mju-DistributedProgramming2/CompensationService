package com.omnm.compensation.configuration;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class PatchRestTemplate extends RestTemplate {

    public PatchRestTemplate() {
        super();
        initialize();
    }

    public PatchRestTemplate(ClientHttpRequestFactory requestFactory) {
        super(requestFactory);
        initialize();
    }

    private void initialize() {
        HttpClient httpClient = HttpClients.custom()
                .build();
        setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
    }
}
