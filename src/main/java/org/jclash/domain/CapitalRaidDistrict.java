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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CapitalRaidDistrict {
    
    @JsonProperty
    private int id;
    
    @JsonProperty
    private String name;
    
    @JsonProperty
    private int districtHallLevel;
    
    @JsonProperty
    private int destructionPercent;
    
    @JsonProperty
    private int stars;
    
    @JsonProperty
    private int attackCount;
    
    @JsonProperty
    private int totalLooted;
    
    @JsonProperty
    private List<CapitalRaidAttack> attacks;

    public CapitalRaidDistrict() {}


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + districtHallLevel;
        result = prime * result + destructionPercent;
        result = prime * result + stars;
        result = prime * result + attackCount;
        result = prime * result + totalLooted;
        result = prime * result + ((attacks == null) ? 0 : attacks.hashCode());
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
        CapitalRaidDistrict other = (CapitalRaidDistrict) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (districtHallLevel != other.districtHallLevel)
            return false;
        if (destructionPercent != other.destructionPercent)
            return false;
        if (stars != other.stars)
            return false;
        if (attackCount != other.attackCount)
            return false;
        if (totalLooted != other.totalLooted)
            return false;
        if (attacks == null) {
            if (other.attacks != null)
                return false;
        } else if (!attacks.equals(other.attacks))
            return false;
        return true;
    }



    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the districtHallLevel
     */
    public int getDistrictHallLevel() {
        return districtHallLevel;
    }

    /**
     * @return the destructionPercent
     */
    public int getDestructionPercent() {
        return destructionPercent;
    }

    /**
     * @return the stars
     */
    public int getStars() {
        return stars;
    }

    /**
     * @return the attackCount
     */
    public int getAttackCount() {
        return attackCount;
    }

    /**
     * @return the totalLooted
     */
    public int getTotalLooted() {
        return totalLooted;
    }

    /**
     * @return the attacks
     */
    public List<CapitalRaidAttack> getAttacks() {
        return attacks;
    }


}
