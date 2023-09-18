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
package org.jclash.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class GenericClan {

    @JsonProperty
    private String tag;

    @JsonProperty
    private String name;

    @JsonProperty
    private BadgeUrl badgeUrls;

    @JsonProperty
    private int clanLevel;

    public GenericClan() {

    }

    /**
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
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
     * @return the badgeUrls
     */
    public BadgeUrl getBadgeUrls() {
        return badgeUrls;
    }

    /**
     * @param badgeUrls the badgeUrls to set
     */
    public void setBadgeUrls(BadgeUrl badgeUrls) {
        this.badgeUrls = badgeUrls;
    }

    /**
     * @return the clanLevel
     */
    public int getClanLevel() {
        return clanLevel;
    }

    /**
     * @param clanLevel the clanLevel to set
     */
    public void setClanLevel(int clanLevel) {
        this.clanLevel = clanLevel;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tag == null) ? 0 : tag.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((badgeUrls == null) ? 0 : badgeUrls.hashCode());
        result = prime * result + clanLevel;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GenericClan other = (GenericClan) obj;
        if (tag == null) {
            if (other.tag != null)
                return false;
        } else if (!tag.equals(other.tag))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (badgeUrls == null) {
            if (other.badgeUrls != null)
                return false;
        } else if (!badgeUrls.equals(other.badgeUrls))
            return false;
        if (clanLevel != other.clanLevel)
            return false;
        return true;
    }

    


    
}
