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
            this.apiToken = retreiveCocAPIToken();
            if (this.apiToken != null) {
                this.isValidToken = true;
            }
        } catch (JCocException e) {
            throw new JCocException(e);
        }
    }

    /**
     * This method allows to retrive the mainly clan informations
     * 
     * @param clanTag the tag related to the intrested clan 
     * @return Clan
     * @throws JCocException in case of errors
     */
    public Clan getClanInfo(@NotNull String clanTag) throws JCocException {
        try {
            ClanService cs = new ClanService(this.apiToken);
            Clan clan = cs.getClanInfos(clanTag);
            return clan;

        } catch (Exception e) {
           throw new JCocException(e);
        }
    }

    /**
     * Search the clan members releated to the clanTag
     * 
     * @param clanTag the tag of the clan
     * @param limit if you want limit the search (paging search)
     * @param before if this field appears in the previous search, you can go back in paging search setting this value as parameter query (Prev)
     * @param after if this field appears in the previous search, you can go next in paging search setting this value as parameter query (Next)
     * @return The Search object with the list of items found and the curors for the next results or previous results
     * @throws JCocException if an error occurs
     */
    public Search<Member> listClanMembers(@NotNull String clanTag, int limit, String before, String after) throws JCocException {
        try {
            ClanService cs = new ClanService(this.apiToken);
            Search<Member> clanMembers = cs.listClanMember(clanTag, limit, after, before);
            return clanMembers;

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
    private String retreiveCocAPIToken() throws JCocException {

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
