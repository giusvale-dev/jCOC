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
public class OldWarClan extends GenericClan{

    @JsonProperty
    private int attacks;

    @JsonProperty
    private int stars;

    @JsonProperty
    private double destructionPercentage;

    @JsonProperty
    private int expEarned;


    public OldWarClan() {

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
     * @return the expEarned
     */
    public int getExpEarned() {
        return expEarned;
    }

    /**
     * @param expEarned the expEarned to set
     */
    public void setExpEarned(int expEarned) {
        this.expEarned = expEarned;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + attacks;
        result = prime * result + stars;
        long temp;
        temp = Double.doubleToLongBits(destructionPercentage);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + expEarned;
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
        OldWarClan other = (OldWarClan) obj;
        if (attacks != other.attacks)
            return false;
        if (stars != other.stars)
            return false;
        if (Double.doubleToLongBits(destructionPercentage) != Double.doubleToLongBits(other.destructionPercentage))
            return false;
        if (expEarned != other.expEarned)
            return false;
        return true;
    }


    

    
    
}
