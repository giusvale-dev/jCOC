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
package org.jclash.coc;

import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jclash.domain.Clan;
import org.jclash.exceptions.JCocException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ClanService {

    private static final String GET_CLAN_INFOS = "https://api.clashofclans.com/v1/clans/";
    private final String API_TOKEN;

    public ClanService(String API_TOKEN) {
        this.API_TOKEN = API_TOKEN;
    }


    /**
     * Get clan informations
     * @clanTag the clan tag
     * @return the clan informations
     */
    public Clan getClanInfos(String clanTag) throws JCocException {
        
        try {

            HttpClient httpClient = HttpClientBuilder.create().build();
            
            HttpGet httpPost = new HttpGet(GET_CLAN_INFOS + URLEncoder.encode(clanTag, StandardCharsets.UTF_8.toString()));        
            httpPost.setHeader("Authorization", "Bearer " + API_TOKEN);
        
            HttpResponse response = httpClient.execute(httpPost);
            int httpResponseCode = response.getStatusLine().getStatusCode();
            if(httpResponseCode != HttpStatus.SC_OK) {
               throw new JCocException("Error during getClanInfos method, COC responds with HTTP code " + response.getStatusLine().getStatusCode());
            }

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();

            ObjectMapper mapper = new ObjectMapper();
            Clan result = mapper.readValue(is, Clan.class);
            return result;
        } catch(Exception e) {
            throw new JCocException(e);
        }

        
    }
   

    
}
