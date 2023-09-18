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
public abstract class GenericWar<T extends GenericClan> {
    
    @JsonProperty
    private String endTime;
    
    @JsonProperty
    private int teamSize;
    
    @JsonProperty
    private int attacksPerMember;

    @JsonProperty
    private T clan;
    
    @JsonProperty
    private T opponent;

    public GenericWar() {

    }

    /**
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the teamSize
     */
    public int getTeamSize() {
        return teamSize;
    }

    /**
     * @param teamSize the teamSize to set
     */
    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    /**
     * @return the attacksPerMember
     */
    public int getAttacksPerMember() {
        return attacksPerMember;
    }

    /**
     * @param attacksPerMember the attacksPerMember to set
     */
    public void setAttacksPerMember(int attacksPerMember) {
        this.attacksPerMember = attacksPerMember;
    }

    /**
     * @return the clan
     */
    public T getClan() {
        return clan;
    }

    /**
     * @param clan the clan to set
     */
    public void setClan(T clan) {
        this.clan = clan;
    }

    /**
     * @return the opponent
     */
    public T getOpponent() {
        return opponent;
    }

    /**
     * @param opponent the opponent to set
     */
    public void setOpponent(T opponent) {
        this.opponent = opponent;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
        result = prime * result + teamSize;
        result = prime * result + attacksPerMember;
        result = prime * result + ((clan == null) ? 0 : clan.hashCode());
        result = prime * result + ((opponent == null) ? 0 : opponent.hashCode());
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
        GenericWar other = (GenericWar) obj;
        if (endTime == null) {
            if (other.endTime != null)
                return false;
        } else if (!endTime.equals(other.endTime))
            return false;
        if (teamSize != other.teamSize)
            return false;
        if (attacksPerMember != other.attacksPerMember)
            return false;
        if (clan == null) {
            if (other.clan != null)
                return false;
        } else if (!clan.equals(other.clan))
            return false;
        if (opponent == null) {
            if (other.opponent != null)
                return false;
        } else if (!opponent.equals(other.opponent))
            return false;
        return true;
    }
}