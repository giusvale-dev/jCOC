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
public class CapitalRaidAttack {
    
    @JsonProperty
    private CapitalRaidMember attacker;
    
    @JsonProperty
    private int destructionPercent;
    
    @JsonProperty
    private int stars;

    public CapitalRaidAttack(){}

    /**
     * @return the attacker
     */
    public CapitalRaidMember getAttacker() {
        return attacker;
    }



    /**
     * @param attacker the attacker to set
     */
    public void setAttacker(CapitalRaidMember attacker) {
        this.attacker = attacker;
    }



    /**
     * @return the destructionPercent
     */
    public int getDestructionPercent() {
        return destructionPercent;
    }



    /**
     * @param destructionPercent the destructionPercent to set
     */
    public void setDestructionPercent(int destructionPercent) {
        this.destructionPercent = destructionPercent;
    }



    /**
     * @return the stars
     */
    public int getStars() {
        return stars;
    }



    /**
     * @param stars the stars to set
     */
    public void setStars(int stars) {
        this.stars = stars;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((attacker == null) ? 0 : attacker.hashCode());
        result = prime * result + destructionPercent;
        result = prime * result + stars;
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
        CapitalRaidAttack other = (CapitalRaidAttack) obj;
        if (attacker == null) {
            if (other.attacker != null)
                return false;
        } else if (!attacker.equals(other.attacker))
            return false;
        if (destructionPercent != other.destructionPercent)
            return false;
        if (stars != other.stars)
            return false;
        return true;
    }

    

}
