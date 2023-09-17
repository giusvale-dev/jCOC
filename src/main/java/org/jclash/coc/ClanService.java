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
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jclash.domain.Clan;
import org.jclash.domain.Member;
import org.jclash.domain.Search;
import org.jclash.exceptions.JCocException;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClanService {

    private static final String BASE_CLAN_URI    =  "https://api.clashofclans.com/v1/clans/";
    
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
            
            HttpGet httpGet = new HttpGet(BASE_CLAN_URI + URLEncoder.encode(clanTag, StandardCharsets.UTF_8.toString()));        
            httpGet.setHeader("Authorization", "Bearer " + API_TOKEN);
        
            HttpResponse response = httpClient.execute(httpGet);
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

 /**
  * Retrieve the members of a clan.
  * It is possible to use this method with the paging, limiting the request with the limit param, 
  * and change page with the after and before parameters.
  * 
  * @param clanTag The target clan tag
  * @param limit If you want to limit your search you can set this value
  * @param after If is present the Page object in the response, you can refer to the cursor after to go in next page
  * @param before If is present the Page object in the response, you can refer to the cursor before to go in previous page
  * @return The list of the clan members (with the page cursors to make the pagination)
  * @throws JCocException if an error occurs
  */
    public Search<Member> listClanMember(@NotNull String clanTag,  @Min(0) @Max(50) int limit, String after, String before) throws JCocException {

        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            
            HttpGet httpGet = new HttpGet(BASE_CLAN_URI + 
                                          URLEncoder.encode(clanTag, StandardCharsets.UTF_8.toString())
                                          + "/members");
                          
            URIBuilder uriBuilder = new URIBuilder(httpGet.getURI()); 
            uriBuilder.addParameter("limit", limit + "");
            if(after != null && !after.isEmpty()) {
                uriBuilder.addParameter("after", after);
            }
            
            if(before != null && !before.isEmpty()) {
                uriBuilder.addParameter("before", before);
            }                                                    
            
            URI uri = uriBuilder.build();
            httpGet.setURI(uri);

            httpGet.setHeader("Authorization", "Bearer " + API_TOKEN);
        
            HttpResponse response = httpClient.execute(httpGet);
            int httpResponseCode = response.getStatusLine().getStatusCode();
            if(httpResponseCode != HttpStatus.SC_OK) {
               throw new JCocException("Error during getClanInfos method, COC responds with HTTP code " + response.getStatusLine().getStatusCode());
            }

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();

            ObjectMapper mapper = new ObjectMapper();
            JavaType type = mapper.getTypeFactory().constructParametricType(Search.class, Member.class);
            Search<Member> resultSearch = mapper.readValue(is, type);
            return resultSearch;

        } catch(Exception e) {
            throw new JCocException(e);
        }
    }
}
