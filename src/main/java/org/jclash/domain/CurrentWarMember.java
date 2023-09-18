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
public class CurrentWarMember extends GenericMember{
    
    @JsonProperty
    private int townhallLevel;

    @JsonProperty
    private int mapPosition;

    @JsonProperty
    private int opponentAttacks;

    @JsonProperty
    private List<Attack> attacks;

    @JsonProperty
    private Attack bestOpponentAttack;

    /**
     * @return the townhallLevel
     */
    public int getTownhallLevel() {
        return townhallLevel;
    }

    /**
     * @param townhallLevel the townhallLevel to set
     */
    public void setTownhallLevel(int townhallLevel) {
        this.townhallLevel = townhallLevel;
    }

    /**
     * @return the mapPosition
     */
    public int getMapPosition() {
        return mapPosition;
    }

    /**
     * @param mapPosition the mapPosition to set
     */
    public void setMapPosition(int mapPosition) {
        this.mapPosition = mapPosition;
    }

    /**
     * @return the opponentAttacks
     */
    public int getOpponentAttacks() {
        return opponentAttacks;
    }

    /**
     * @param opponentAttacks the opponentAttacks to set
     */
    public void setOpponentAttacks(int opponentAttacks) {
        this.opponentAttacks = opponentAttacks;
    }

    /**
     * @return the attacks
     */
    public List<Attack> getAttacks() {
        return attacks;
    }

    /**
     * @param attacks the attacks to set
     */
    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }

    /**
     * @return the bestOpponentAttack
     */
    public Attack getBestOpponentAttack() {
        return bestOpponentAttack;
    }

    /**
     * @param bestOpponentAttack the bestOpponentAttack to set
     */
    public void setBestOpponentAttack(Attack bestOpponentAttack) {
        this.bestOpponentAttack = bestOpponentAttack;
    }

    public CurrentWarMember() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + townhallLevel;
        result = prime * result + mapPosition;
        result = prime * result + opponentAttacks;
        result = prime * result + ((attacks == null) ? 0 : attacks.hashCode());
        result = prime * result + ((bestOpponentAttack == null) ? 0 : bestOpponentAttack.hashCode());
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
        CurrentWarMember other = (CurrentWarMember) obj;
        if (townhallLevel != other.townhallLevel)
            return false;
        if (mapPosition != other.mapPosition)
            return false;
        if (opponentAttacks != other.opponentAttacks)
            return false;
        if (attacks == null) {
            if (other.attacks != null)
                return false;
        } else if (!attacks.equals(other.attacks))
            return false;
        if (bestOpponentAttack == null) {
            if (other.bestOpponentAttack != null)
                return false;
        } else if (!bestOpponentAttack.equals(other.bestOpponentAttack))
            return false;
        return true;
    }
}
