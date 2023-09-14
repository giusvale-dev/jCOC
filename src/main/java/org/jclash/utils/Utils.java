package org.jclash.utils;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {

    private static final String FIND_MY_IP_SERVICE = "https://api.ipify.org?format=json";

    /**
     * Get the public IP address where is executed the API
     * 
     * @return the IP address
     * @throws IOException
     * @throws ClientProtocolException
     */
    public static String getIpAddress() throws ClientProtocolException, IOException {
        
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(FIND_MY_IP_SERVICE);
        httpGet.setHeader("Content-type", "application/json");

        HttpResponse response = httpClient.execute(httpGet);
        
        ObjectMapper mapper = new ObjectMapper();
        MyIp myIp = mapper.readValue(response.getEntity().getContent(), MyIp.class);
        return myIp.address;

    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    static class MyIp {

        public MyIp() {

        }
        @JsonProperty("ip")
        protected String address;
    }

    
}
