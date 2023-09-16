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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
    
    @JsonProperty
    private AuthCodeResponse status;

    @JsonProperty
    private int sessionExpiresInSeconds;
    
    @JsonProperty
    private List<Key> keys;

    @JsonProperty
    private Key key; //Field used only during the creation of a new key

    public Account() {

    }

    /**
     * @return the status
     */
    public AuthCodeResponse getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(AuthCodeResponse status) {
        this.status = status;
    }

    /**
     * @return the sessionExpiresInSeconds
     */
    public int getSessionExpiresInSeconds() {
        return sessionExpiresInSeconds;
    }

    /**
     * @param sessionExpiresInSeconds the sessionExpiresInSeconds to set
     */
    public void setSessionExpiresInSeconds(int sessionExpiresInSeconds) {
        this.sessionExpiresInSeconds = sessionExpiresInSeconds;
    }

    /**
     * @return the keys
     */
    public List<Key> getKeys() {
        return keys;
    }

    /**
     * @param keys the keys to set
     */
    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }

    /**
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(Key key) {
        this.key = key;
    }

}
