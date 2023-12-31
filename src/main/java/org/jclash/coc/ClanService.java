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
import org.jclash.domain.CapitalRaid;
import org.jclash.domain.ClanInfo;
import org.jclash.domain.ClanInfoMember;
import org.jclash.domain.ClanSearch;
import org.jclash.domain.CurrentWar;
import org.jclash.domain.Search;
import org.jclash.domain.OldWar;
import org.jclash.exceptions.JCocException;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClanService {

    private static final String BASE_CLAN_URI = "https://api.clashofclans.com/v1/clans/";

    private final String API_TOKEN;

    public ClanService(String API_TOKEN) {
        this.API_TOKEN = API_TOKEN;
    }

    /**
     * Get information about a single clan by clan tag.
     * Clan tags can be found using clan search operation.
     * Note that clan tags start with hash character '#' and that needs
     * to be URL-encoded properly to work in URL,
     * so for example clan tag '#2ABC' would become '%232ABC' in the URL.
     * 
     * @clanTag Tag of the clan.
     * @return The clan informations
     * @throws JCocException if an error occurs
     */
    public ClanInfo clanInfo(String clanTag) throws JCocException {

        try {

            HttpClient httpClient = HttpClientBuilder.create().build();

            HttpGet httpGet = new HttpGet(
                    BASE_CLAN_URI + URLEncoder.encode(clanTag, StandardCharsets.UTF_8.toString()));
            httpGet.setHeader("Authorization", "Bearer " + API_TOKEN);

            HttpResponse response = httpClient.execute(httpGet);
            int httpResponseCode = response.getStatusLine().getStatusCode();
            if (httpResponseCode != HttpStatus.SC_OK) {
                throw new JCocException("Error during getClanInfos method, COC responds with HTTP code "
                        + response.getStatusLine().getStatusCode());
            }

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();

            ObjectMapper mapper = new ObjectMapper();
            ClanInfo result = mapper.readValue(is, ClanInfo.class);
            return result;
        } catch (Exception e) {
            throw new JCocException(e);
        }
    }

    /**
     * List clan members.
     * 
     * @param clanTag Tag of the clan
     * @param limit   Limit the number of items returned in the response.
     * @param before  Return only items that occur before this marker.
     *                Before marker can be found from the response, inside the
     *                'paging' property.
     *                Note that only after or before can be specified for a request,
     *                not both.
     * @param after   Return only items that occur after this marker.
     *                Before marker can be found from the response, inside the
     *                'paging' property.
     *                Note that only after or before can be specified for a request,
     *                not both.
     * @return The clan members
     * @throws JCocException if an error occurs
     */
    public Search<ClanInfoMember> clanMembers(@NotNull String clanTag, @Min(0) @Max(50) int limit, String after,
            String before) throws JCocException {

        try {
            HttpClient httpClient = HttpClientBuilder.create().build();

            HttpGet httpGet = new HttpGet(BASE_CLAN_URI +
                    URLEncoder.encode(clanTag, StandardCharsets.UTF_8.toString())
                    + "/members");

            URIBuilder uriBuilder = new URIBuilder(httpGet.getURI());
            uriBuilder.addParameter("limit", limit + "");
            if (after != null && !after.isEmpty()) {
                uriBuilder.addParameter("after", after);
            }

            if (before != null && !before.isEmpty()) {
                uriBuilder.addParameter("before", before);
            }

            URI uri = uriBuilder.build();
            httpGet.setURI(uri);

            httpGet.setHeader("Authorization", "Bearer " + API_TOKEN);

            HttpResponse response = httpClient.execute(httpGet);
            int httpResponseCode = response.getStatusLine().getStatusCode();
            if (httpResponseCode != HttpStatus.SC_OK) {
                throw new JCocException("Error during getClanInfos method, COC responds with HTTP code "
                        + response.getStatusLine().getStatusCode());
            }

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();

            ObjectMapper mapper = new ObjectMapper();
            JavaType type = mapper.getTypeFactory().constructParametricType(Search.class, ClanInfoMember.class);
            Search<ClanInfoMember> resultSearch = mapper.readValue(is, type);
            return resultSearch;

        } catch (Exception e) {
            throw new JCocException(e);
        }
    }

    /**
     * Retrieve clan's clan war log
     * 
     * @param clanTag Tag of the clan
     * @param limit   Limit the number of items returned in the response.
     * @param after   Return only items that occur after this marker.
     *                Before marker can be found from the response, inside the
     *                'paging' property.
     *                Note that only after or before can be specified for a request,
     *                not both.
     * @param before  Return only items that occur before this marker.
     *                Before marker can be found from the response, inside the
     *                'paging' property.
     *                Note that only after or before can be specified for a request,
     *                not both.
     * @return the war log of the clan related to the clanTag
     * @throws JCocException if an error occurs
     */
    public Search<OldWar> warLog(@NotNull String clanTag, @Min(0) @Max(50) int limit, String after, String before)
            throws JCocException {

        try {
            HttpClient httpClient = HttpClientBuilder.create().build();

            HttpGet httpGet = new HttpGet(BASE_CLAN_URI +
                    URLEncoder.encode(clanTag, StandardCharsets.UTF_8.toString())
                    + "/warlog");

            URIBuilder uriBuilder = new URIBuilder(httpGet.getURI());
            uriBuilder.addParameter("limit", limit + "");
            if (after != null && !after.isEmpty()) {
                uriBuilder.addParameter("after", after);
            }

            if (before != null && !before.isEmpty()) {
                uriBuilder.addParameter("before", before);
            }

            URI uri = uriBuilder.build();
            httpGet.setURI(uri);

            httpGet.setHeader("Authorization", "Bearer " + API_TOKEN);

            HttpResponse response = httpClient.execute(httpGet);
            int httpResponseCode = response.getStatusLine().getStatusCode();
            if (httpResponseCode != HttpStatus.SC_OK) {
                throw new JCocException("Error during warLog method, COC responds with HTTP code "
                        + response.getStatusLine().getStatusCode());
            }

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();

            ObjectMapper mapper = new ObjectMapper();
            JavaType type = mapper.getTypeFactory().constructParametricType(Search.class, OldWar.class);
            Search<OldWar> resultSearch = mapper.readValue(is, type);
            return resultSearch;

        } catch (Exception e) {
            throw new JCocException(e);
        }
    }

    /**
     * Retrieve information about clan's current clan war
     * 
     * @param clanTag Tag of the clan.
     * @return the current war
     * @throws JCocException if an error occurs
     */
    public CurrentWar currentWar(@NotNull String clanTag) throws JCocException {

        try {
            HttpClient httpClient = HttpClientBuilder.create().build();

            HttpGet httpGet = new HttpGet(BASE_CLAN_URI +
                    URLEncoder.encode(clanTag, StandardCharsets.UTF_8.toString())
                    + "/currentwar");

            httpGet.setHeader("Authorization", "Bearer " + API_TOKEN);

            HttpResponse response = httpClient.execute(httpGet);
            int httpResponseCode = response.getStatusLine().getStatusCode();
            if (httpResponseCode != HttpStatus.SC_OK) {
                throw new JCocException("Error during warLog method, COC responds with HTTP code "
                        + response.getStatusLine().getStatusCode());
            }

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();

            ObjectMapper mapper = new ObjectMapper();
            CurrentWar resultSearch = mapper.readValue(is, CurrentWar.class);
            return resultSearch;

        } catch (Exception e) {
            throw new JCocException(e);
        }
    }

    /**
     * Search all clans by name and/or filtering the results using various criteria.
     * At least one filtering criteria must be defined and if name is used as part
     * of search,
     * it is required to be at least three characters long. It is not possible to
     * specify
     * ordering for results so clients should not rely on any specific ordering as
     * that may
     * change in the future releases of the API.
     * 
     * @param name          Search clans by name.
     *                      If name is used as part of search query, it needs to be
     *                      at least three characters long.
     *                      Name search parameter is interpreted as wild card
     *                      search, so it may appear anywhere in the clan name.
     * @param warFrequency  Filter by clan war frequency
     * @param locationId    Filter by clan location identifier. For list of
     *                      available locations, refer to getLocations operation.
     * @param minMembers    Filter by minimum number of clan members
     * @param maxMembers    Filter by maximum number of clan members
     * @param minClanPoints Filter by minimum amount of clan points.
     * @param minClanLevel  Filter by minimum clan level.
     * @param limit         Limit the number of items returned in the response.
     * @param after         Return only items that occur after this marker. Before
     *                      marker can be found from the response,
     *                      inside the 'paging' property. Note that only after or
     *                      before can be specified for a request, not both.
     * @param before        Return only items that occur before this marker. Before
     *                      marker can be found from the response,
     *                      inside the 'paging' property. Note that only after or
     *                      before can be specified for a request, not both.
     * @param labelIds      Comma separatered list of label IDs to use for filtering
     *                      results.
     * @return
     * @throws JCocException
     */
    public Search<ClanSearch> searchClans(String name, String warFrequency, Integer locationId,
            Integer minMembers, Integer maxMembers, Integer minClanPoints,
            Integer minClanLevel, Integer limit, String after, String before,
            String labelIds) throws JCocException {
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(BASE_CLAN_URI);
            URIBuilder uriBuilder = new URIBuilder(httpGet.getURI());

            // Add name param
            if (name != null && !name.isEmpty() && name.length() > 3) {
                uriBuilder.addParameter("name", name);
            }

            // Add warFrequency param
            if (warFrequency != null && !warFrequency.isEmpty()) {
                uriBuilder.addParameter("warFrequency", warFrequency);
            }

            // Add locationId param
            if (locationId != null) {
                uriBuilder.addParameter("locationId", locationId.toString());
            }

            // Add minMembers param
            if (minMembers != null) {
                uriBuilder.addParameter("minMembers", minMembers.toString());
            }

            // Add maxMembers param
            if (maxMembers != null) {
                uriBuilder.addParameter("maxMembers", maxMembers.toString());
            }

            // Add minClanPoints param
            if (minClanPoints != null) {
                uriBuilder.addParameter("minClanPoints", minClanPoints.toString());
            }

            // Add minClanPoints param
            if (minClanLevel != null) {
                uriBuilder.addParameter("minClanLevel", minClanLevel.toString());
            }

            // Add limit param
            if (limit != null) {
                uriBuilder.addParameter("limit", limit.toString());
            }

            // Add after param
            if (after != null && !after.isEmpty()) {
                uriBuilder.addParameter("after", after);
            }

            // Add beofre param
            if (before != null && !before.isEmpty()) {
                uriBuilder.addParameter("before", before);
            }

            // Add labelIds param
            if (labelIds != null && !labelIds.isEmpty()) {
                uriBuilder.addParameter("labelIds", labelIds);
            }

            httpGet.setURI(uriBuilder.build());

            httpGet.setHeader("Authorization", "Bearer " + API_TOKEN);

            HttpResponse response = httpClient.execute(httpGet);
            int httpResponseCode = response.getStatusLine().getStatusCode();
            if (httpResponseCode != HttpStatus.SC_OK) {
                throw new JCocException("Error during searchClans method, COC responds with HTTP code "
                        + response.getStatusLine().getStatusCode());
            }

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();

            ObjectMapper mapper = new ObjectMapper();
            JavaType type = mapper.getTypeFactory().constructParametricType(Search.class, ClanSearch.class);
            Search<ClanSearch> resultSearch = mapper.readValue(is, type);
            return resultSearch;

        } catch (Exception e) {
            throw new JCocException(e);
        }
    }

    /**
     * Retrieve clan's capital raid seasons
     * @param clanTag Tag of the clan.
     * @param limit Limit the number of items returned in the response.
     * @param after Return only items that occur after this marker. Before marker can 
     *              be found from the response, inside the 'paging' property. Note that 
     *              only after or before can be specified for a request, not both.
     * @param before Return only items that occur before this marker. Before marker can 
     *               be found from the response, inside the 'paging' property. 
     *               Note that only after or before can be specified for a request, not both.
     * @return Retrieve clan's capital raid seasons
     * @throws JCocException if an error occurs
     */
    public Search<CapitalRaid> capitalRaidSeason(@NotNull String clanTag, Integer limit, String after, String before) throws JCocException {

        try {
            HttpClient httpClient = HttpClientBuilder.create().build();

            HttpGet httpGet = new HttpGet(BASE_CLAN_URI +
                    URLEncoder.encode(clanTag, StandardCharsets.UTF_8.toString())
                    + "/capitalraidseasons");
    
            URIBuilder uriBuilder = new URIBuilder(httpGet.getURI());

            // Add limit param
            if (limit != null) {
                uriBuilder.addParameter("limit", limit.toString());
            }

            // Add after param
            if (after != null && !after.isEmpty()) {
                uriBuilder.addParameter("after", after);
            }

            // Add beofre param
            if (before != null && !before.isEmpty()) {
                uriBuilder.addParameter("before", before);
            }
            
            httpGet.setURI(uriBuilder.build());
            httpGet.setHeader("Authorization", "Bearer " + API_TOKEN);

            HttpResponse response = httpClient.execute(httpGet);
            int httpResponseCode = response.getStatusLine().getStatusCode();
            if (httpResponseCode != HttpStatus.SC_OK) {
                throw new JCocException("Error during capitalRaidSeason method, COC responds with HTTP code "
                        + response.getStatusLine().getStatusCode());
            }

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();

            ObjectMapper mapper = new ObjectMapper();
            JavaType type = mapper.getTypeFactory().constructParametricType(Search.class, CapitalRaid.class);
            Search<CapitalRaid> resultSearch = mapper.readValue(is, type);
            return resultSearch;

        } catch(Exception e) {
            throw new JCocException(e);
        }
       

    }

}
