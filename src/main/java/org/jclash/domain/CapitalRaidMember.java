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
public class CapitalRaidMember extends GenericMember{
    
    @JsonProperty
    private int attacks;
    
    @JsonProperty
    private int attackLimit;
    
    @JsonProperty
    private int bonusAttackLimit;
    
    @JsonProperty
    private int capitalResourcesLooted;
    
    public CapitalRaidMember() {
    }

    /**
     * @return the attacks
     */
    public int getAttacks() {
        return attacks;
    }

    /**
     * @param attacks the attacks to set
     */
    public void setAttacks(int attacks) {
        this.attacks = attacks;
    }

    /**
     * @return the attackLimit
     */
    public int getAttackLimit() {
        return attackLimit;
    }

    /**
     * @param attackLimit the attackLimit to set
     */
    public void setAttackLimit(int attackLimit) {
        this.attackLimit = attackLimit;
    }

    /**
     * @return the bonusAttackLimit
     */
    public int getBonusAttackLimit() {
        return bonusAttackLimit;
    }

    /**
     * @param bonusAttackLimit the bonusAttackLimit to set
     */
    public void setBonusAttackLimit(int bonusAttackLimit) {
        this.bonusAttackLimit = bonusAttackLimit;
    }

    /**
     * @return the capitalResourcesLooted
     */
    public int getCapitalResourcesLooted() {
        return capitalResourcesLooted;
    }

    /**
     * @param capitalResourcesLooted the capitalResourcesLooted to set
     */
    public void setCapitalResourcesLooted(int capitalResourcesLooted) {
        this.capitalResourcesLooted = capitalResourcesLooted;
    }




    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + attacks;
        result = prime * result + attackLimit;
        result = prime * result + bonusAttackLimit;
        result = prime * result + capitalResourcesLooted;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        CapitalRaidMember other = (CapitalRaidMember) obj;
        if (attacks != other.attacks)
            return false;
        if (attackLimit != other.attackLimit)
            return false;
        if (bonusAttackLimit != other.bonusAttackLimit)
            return false;
        if (capitalResourcesLooted != other.capitalResourcesLooted)
            return false;
        return true;
    }



    
}
