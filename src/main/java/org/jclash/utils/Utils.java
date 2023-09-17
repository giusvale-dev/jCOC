/*
 * Copyright 2023 Giuseppe Valente<valentepeppe@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclash.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jclash.exceptions.JCocException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {

    private static final String FIND_MY_IP_SERVICE = "https://api.ipify.org?format=json";

    /**
     * Get the public IP address where is executed the API
     * 
     * @return the IP address
     * @throws JCocException
     * @throws HttpException
     * @throws IOException
     * @throws ClientProtocolException
     */
    public static String getIpAddress() throws JCocException {

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(FIND_MY_IP_SERVICE);
        httpGet.setHeader("Content-type", "application/json");

        HttpResponse response;
        try {
            response = httpClient.execute(httpGet);
        } catch (ClientProtocolException e) {
            throw new JCocException("An HTTP error occurs: " + e.getMessage());
        } catch (IOException e) {
            throw new JCocException("Connection error: " + e.getMessage());
        }

        ObjectMapper mapper = new ObjectMapper();
        MyIp myIp;
        try {
            myIp = mapper.readValue(response.getEntity().getContent(), MyIp.class);
        } catch (Exception e) {
            throw new JCocException("Problem during deserialization object: " + e.getMessage());
        }
        return myIp.address;

    }

    public static Date convertDate(@NotNull @NotEmpty String date) throws JCocException {

        try {

            //Remove the zone from string
            String targetDate = date.substring(0, date.length() - 5);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
            Date result = sdf.parse(targetDate);    
            return result;

        } catch (Exception e) {
            throw new JCocException(e);
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class MyIp {

        public MyIp() {

        }
        @JsonProperty("ip")
        protected String address;
    }

}
