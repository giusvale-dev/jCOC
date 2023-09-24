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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CapitalRaidAttackLog {
 
    @JsonAlias({"attacker", "defender"})
    private CapitalRaidClan clan;

    @JsonProperty
    private int attackCount;
    
    @JsonProperty
    private int districtCount;
    
    @JsonProperty
    private int districtsDestroyed;
    
    @JsonProperty
    private List<CapitalRaidDistrict> districts;
    
    public CapitalRaidAttackLog() {

    }

    
    /**
     * @return the attackCount
     */
    public int getAttackCount() {
        return attackCount;
    }

    /**
     * @param attackCount the attackCount to set
     */
    public void setAttackCount(int attackCount) {
        this.attackCount = attackCount;
    }

    /**
     * @return the districtCount
     */
    public int getDistrictCount() {
        return districtCount;
    }

    /**
     * @param districtCount the districtCount to set
     */
    public void setDistrictCount(int districtCount) {
        this.districtCount = districtCount;
    }

    /**
     * @return the districtsDestroyed
     */
    public int getDistrictsDestroyed() {
        return districtsDestroyed;
    }

    /**
     * @param districtsDestroyed the districtsDestroyed to set
     */
    public void setDistrictsDestroyed(int districtsDestroyed) {
        this.districtsDestroyed = districtsDestroyed;
    }

    /**
     * @return the districts
     */
    public List<CapitalRaidDistrict> getDistricts() {
        return districts;
    }

    /**
     * @param districts the districts to set
     */
    public void setDistricts(List<CapitalRaidDistrict> districts) {
        this.districts = districts;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clan == null) ? 0 : clan.hashCode());
        result = prime * result + attackCount;
        result = prime * result + districtCount;
        result = prime * result + districtsDestroyed;
        result = prime * result + ((districts == null) ? 0 : districts.hashCode());
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
        CapitalRaidAttackLog other = (CapitalRaidAttackLog) obj;
        if (clan == null) {
            if (other.clan != null)
                return false;
        } else if (!clan.equals(other.clan))
            return false;
        if (attackCount != other.attackCount)
            return false;
        if (districtCount != other.districtCount)
            return false;
        if (districtsDestroyed != other.districtsDestroyed)
            return false;
        if (districts == null) {
            if (other.districts != null)
                return false;
        } else if (!districts.equals(other.districts))
            return false;
        return true;
    }


    /**
     * @return the clan
     */
    public CapitalRaidClan getClan() {
        return clan;
    }


    /**
     * @param clan the clan to set
     */
    public void setClan(CapitalRaidClan clan) {
        this.clan = clan;
    }


    



}
