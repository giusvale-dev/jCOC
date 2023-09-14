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

public class Authentication {
   
    private String apiToken;
    private String username;
    private String password;
    
    public Authentication() {

    }

    /**
     * @return the apiToken
     */
    public String getApiToken() {
        return apiToken;
    }

    /**
     * @param apiToken the apiToken to set
     */
    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public Authentication(String apiToken) {
        this.apiToken = apiToken;
    }

    public Authentication(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String login() {
        try {
            return AuthenticationService.login(username, password);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Account getAcocuntInfo(String sessionId) {
        try {

            return AuthenticationService.getKeys(sessionId);

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }




}
