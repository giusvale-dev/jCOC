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

@JsonIgnoreProperties(ignoreUnknown = true)
public class Key {
    
    private String id;
    private String developerId;
    private String tier;
    private String name;
    private String description;
    private List<String> origins;
    private List<String> scopes;
    private List<String> cidrRanges;
    private String validUntil;
    private String key;


    public Key() {

    }


    /**
     * @return the id
     */
    public String getId() {
        return id;
    }


    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }


    /**
     * @return the developerId
     */
    public String getDeveloperId() {
        return developerId;
    }


    /**
     * @param developerId the developerId to set
     */
    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }


    /**
     * @return the tier
     */
    public String getTier() {
        return tier;
    }


    /**
     * @param tier the tier to set
     */
    public void setTier(String tier) {
        this.tier = tier;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }


    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * @return the origins
     */
    public List<String> getOrigins() {
        return origins;
    }


    /**
     * @param origins the origins to set
     */
    public void setOrigins(List<String> origins) {
        this.origins = origins;
    }


    /**
     * @return the scopes
     */
    public List<String> getScopes() {
        return scopes;
    }


    /**
     * @param scopes the scopes to set
     */
    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }


    /**
     * @return the cidrRanges
     */
    public List<String> getCidrRanges() {
        return cidrRanges;
    }


    /**
     * @param cidrRanges the cidrRanges to set
     */
    public void setCidrRanges(List<String> cidrRanges) {
        this.cidrRanges = cidrRanges;
    }


    /**
     * @return the validUntil
     */
    public String getValidUntil() {
        return validUntil;
    }


    /**
     * @param validUntil the validUntil to set
     */
    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }


    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }


    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }




}
