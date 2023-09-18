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
public class Attack {

    @JsonProperty
    private String attackerTag; 
    
    @JsonProperty
    private String defenderTag; 
    
    @JsonProperty
    private int stars; 
    
    @JsonProperty
    private double destructionPercentage; 
    
    @JsonProperty
    private int order; 
    
    /**
     * 
     */
    public Attack() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((attackerTag == null) ? 0 : attackerTag.hashCode());
        result = prime * result + ((defenderTag == null) ? 0 : defenderTag.hashCode());
        result = prime * result + stars;
        long temp;
        temp = Double.doubleToLongBits(destructionPercentage);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + order;
        result = prime * result + duration;
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
        Attack other = (Attack) obj;
        if (attackerTag == null) {
            if (other.attackerTag != null)
                return false;
        } else if (!attackerTag.equals(other.attackerTag))
            return false;
        if (defenderTag == null) {
            if (other.defenderTag != null)
                return false;
        } else if (!defenderTag.equals(other.defenderTag))
            return false;
        if (stars != other.stars)
            return false;
        if (Double.doubleToLongBits(destructionPercentage) != Double.doubleToLongBits(other.destructionPercentage))
            return false;
        if (order != other.order)
            return false;
        if (duration != other.duration)
            return false;
        return true;
    }

    /**
     * @return the attackerTag
     */
    public String getAttackerTag() {
        return attackerTag;
    }

    /**
     * @param attackerTag the attackerTag to set
     */
    public void setAttackerTag(String attackerTag) {
        this.attackerTag = attackerTag;
    }

    /**
     * @return the defenderTag
     */
    public String getDefenderTag() {
        return defenderTag;
    }

    /**
     * @param defenderTag the defenderTag to set
     */
    public void setDefenderTag(String defenderTag) {
        this.defenderTag = defenderTag;
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

    /**
     * @return the destructionPercentage
     */
    public double getDestructionPercentage() {
        return destructionPercentage;
    }

    /**
     * @param destructionPercentage the destructionPercentage to set
     */
    public void setDestructionPercentage(double destructionPercentage) {
        this.destructionPercentage = destructionPercentage;
    }

    /**
     * @return the order
     */
    public int getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @JsonProperty
    private int duration; 


    


    
}
