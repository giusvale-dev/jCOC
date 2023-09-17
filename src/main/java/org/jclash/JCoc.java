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

package org.jclash;

import javax.validation.constraints.NotNull;

import org.jclash.coc.ClanService;
import org.jclash.domain.Clan;
import org.jclash.domain.Member;
import org.jclash.domain.Search;
import org.jclash.domain.War;
import org.jclash.exceptions.JCocException;
import org.jclash.security.Account;
import org.jclash.security.AuthenticationService;
import org.jclash.security.Key;
import org.jclash.utils.Utils;

public class JCoc {
    
    private String apiToken;
    private String username;
    private String password;
    private boolean isValidToken;
    private static final int MAX_NUMBER_KEYS_ALLOWED = 10;

    /**
     * Initialize the JCoc for usage the API
     * 
     * @param apiToken API_TOKEN created on https://developer.clashofclans.com/
     */
    public JCoc(String apiToken) {
        this.apiToken = apiToken;
        isValidToken = true;
        this.password = null;
        this.username = null;

    }

    /**
     * Initialize the JCoc for usage the API with username and password
     * 
     * @param apiToken API_TOKEN created on https://developer.clashofclans.com/
     * @throws JCocException
     */
    public JCoc(@NotNull String username, @NotNull String password) throws JCocException {
        this.isValidToken = false;
        this.username = username;
        this.password = password;
        try {
            this.apiToken = retrieveCocAPIToken();
            if (this.apiToken != null) {
                this.isValidToken = true;
            }
        } catch (JCocException e) {
            throw new JCocException(e);
        }
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
    public Clan clanInfo(@NotNull String clanTag) throws JCocException {
        try {
            ClanService cs = new ClanService(this.apiToken);
            Clan clan = cs.clanInfo(clanTag);
            return clan;

        } catch (Exception e) {
           throw new JCocException(e);
        }
    }

    /**
     * List clan members.
     * 
     * @param clanTag Tag of the clan
     * @param limit Limit the number of items returned in the response.
     * @param before Return only items that occur before this marker. 
     *               Before marker can be found from the response, inside the 'paging' property. 
     *               Note that only after or before can be specified for a request, not both.
     * @param after Return only items that occur after this marker. 
     *              Before marker can be found from the response, inside the 'paging' property. 
     *              Note that only after or before can be specified for a request, not both.
     * @return The clan members
     * @throws JCocException if an error occurs
     */
    public Search<Member> clanMembers(@NotNull String clanTag, int limit, String before, String after) throws JCocException {
        try {
            ClanService cs = new ClanService(this.apiToken);
            Search<Member> clanMembers = cs.clanMembers(clanTag, limit, after, before);
            return clanMembers;

        } catch (Exception e) {
           throw new JCocException(e);
        }
    }

   /**
     * Retrieve clan's clan war log
     * 
     * @param clanTag Tag of the clan
     * @param limit Limit the number of items returned in the response.
     * @param after Return only items that occur after this marker. 
     *              Before marker can be found from the response, inside the 'paging' property. 
     *              Note that only after or before can be specified for a request, not both.
     * @param before Return only items that occur before this marker. 
     *               Before marker can be found from the response, inside the 'paging' property. 
     *               Note that only after or before can be specified for a request, not both.
     * @return the war log of the clan related to the clanTag
     * @throws JCocException if an error occurs
     */
    public Search<War> warLog(@NotNull String clanTag, int limit, String before, String after) throws JCocException {
        try {
            ClanService cs = new ClanService(this.apiToken);
            Search<War> warLog = cs.warLog(clanTag, limit, after, before);
            return warLog;
        } catch (Exception e) {
           throw new JCocException(e);
        }
    }


    /**
     * Private method to get an API Token from COC Server.
     * If is not possible to retrive a valid API_TOKEN for the current IP address
     * this method tries to create a new key in the COC server
     * 
     * @return the COC API TOKEN
     * @throws JCocException
     */
    private String retrieveCocAPIToken() throws JCocException {

        try {
            if (!isValidToken) {
                String sessionID = AuthenticationService.login(username, password);
                Account cocAccount = AuthenticationService.getKeys(sessionID);
                if (cocAccount != null) {
                    String myIP = Utils.getIpAddress();
                    if (myIP != null) {
                        if (cocAccount.getKeys().size() < MAX_NUMBER_KEYS_ALLOWED) {
                            // Find a key with the IP address retrived to reuse it
                            for (Key k : cocAccount.getKeys()) {
                                if (k != null) {
                                    for (String ip : k.getCidrRanges()) {
                                        if (ip.equals(myIP)) {
                                            return k.getKey();
                                        }
                                    }
                                }
                            }
                            // Key not found we try to create a new key
                            return AuthenticationService.createKey(sessionID, myIP);
                        }
                        throw new JCocException(
                                "You can create only 10 keys, please delete someone on your developer account");
                    }
                    throw new JCocException(
                            "I can't find your public IP, please register an API_TOKEN on https://developer.clashofclans.com/ and use it");
                }
                throw new JCocException("Username or password are not valid");
            }
            throw new JCocException("API Token already setted");
        } catch (Exception e) {
            throw new JCocException(e.getMessage());
        }
    }
}
