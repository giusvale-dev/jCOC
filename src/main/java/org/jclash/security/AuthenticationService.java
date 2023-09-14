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

package org.jclash.security;

import java.io.InputStream;
import javax.validation.constraints.NotNull;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthenticationService {

    private final static String COC_LOGIN_STRING = "https://developer.clashofclans.com/api/login";
    private final static String COC_KEYS_LIST = "https://developer.clashofclans.com/api/apikey/list";

    /**
     * Method to login to the Clash Of Clan server.
     * This method return the session after the authentication is done.
     * If the authentication process has success return the sessionID, otherwise return an exception. 
     * 
     * This method needs a valid and confirmed account, for others details:
     * @see https://developer.clashofclans.com/
     * 
     * @param username the Clash of Clan username
     * @param password the Clash of Clan password
     * @return the sessionID if the Authentication process has success
     */
    public static String login(@NotNull String username, @NotNull String password) {

        try {

            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(COC_LOGIN_STRING);
            ObjectMapper mapper = new ObjectMapper();

            LoginObj lo = new LoginObj();
            lo.setEmail(username);
            lo.setPassword(password);

            StringEntity se = new StringEntity(mapper.writeValueAsString(lo));
            httpPost.setEntity(se);
            httpPost.setHeader("Content-type", "application/json");

            HttpResponse response = httpClient.execute(httpPost);

            // Retrive cookie
            String sessionId = "";
            Header[] cookies = response.getHeaders("Set-Cookie");
            if(cookies != null && cookies.length > 0) {
                for (Header h : cookies) {
                    sessionId = h.getValue();
                }
            } else {
                throw new HttpException("Cannot read the sessionId in the HTTP response! Try again");
            }
            
            return sessionId;

        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * Return the Acocunt informations stored in the the Clash of Clans account (keys incluses)
     *
     * @param sessionId the sessionId obtained with the login
     * @return the Account informations
     */
    public static Account getKeys(@NotNull String sessionId) {

        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            
            HttpPost httpPost = new HttpPost(COC_KEYS_LIST);
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setHeader("Cookie", sessionId);
            
            HttpResponse response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();

            ObjectMapper mapper = new ObjectMapper();
            Account result = mapper.readValue(is, Account.class);
            return result;


        } catch(Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
