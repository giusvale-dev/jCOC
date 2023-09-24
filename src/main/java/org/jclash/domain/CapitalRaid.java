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
public class CapitalRaid {
    
    @JsonProperty
    private String state;
    
    @JsonProperty
    private String startTime;
    
    @JsonProperty
    private String endTime;
    
    @JsonProperty
    private int capitalTotalLoot;
    
    @JsonProperty
    private int raidsCompleted;
    
    @JsonProperty
    private int totalAttacks;
    
    @JsonProperty
    private int enemyDistrictsDestroyed;
    
    @JsonProperty
    private int offensiveReward;
    
    @JsonProperty
    private int defensiveReward;
    
    @JsonProperty
    private List<CapitalRaidMember> members;
    
    @JsonProperty
    private List<CapitalRaidAttackLog> attackLog;
    
    @JsonProperty
    private List<CapitalRaidAttackLog> defenseLog;
    
    public CapitalRaid(){}
    
    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
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
     * @return the capitalTotalLoot
     */
    public int getCapitalTotalLoot() {
        return capitalTotalLoot;
    }

    /**
     * @param capitalTotalLoot the capitalTotalLoot to set
     */
    public void setCapitalTotalLoot(int capitalTotalLoot) {
        this.capitalTotalLoot = capitalTotalLoot;
    }

    /**
     * @return the raidsCompleted
     */
    public int getRaidsCompleted() {
        return raidsCompleted;
    }

    /**
     * @param raidsCompleted the raidsCompleted to set
     */
    public void setRaidsCompleted(int raidsCompleted) {
        this.raidsCompleted = raidsCompleted;
    }

    /**
     * @return the totalAttacks
     */
    public int getTotalAttacks() {
        return totalAttacks;
    }

    /**
     * @param totalAttacks the totalAttacks to set
     */
    public void setTotalAttacks(int totalAttacks) {
        this.totalAttacks = totalAttacks;
    }

    /**
     * @return the enemyDistrictsDestroyed
     */
    public int getEnemyDistrictsDestroyed() {
        return enemyDistrictsDestroyed;
    }

    /**
     * @param enemyDistrictsDestroyed the enemyDistrictsDestroyed to set
     */
    public void setEnemyDistrictsDestroyed(int enemyDistrictsDestroyed) {
        this.enemyDistrictsDestroyed = enemyDistrictsDestroyed;
    }

    /**
     * @return the offensiveReward
     */
    public int getOffensiveReward() {
        return offensiveReward;
    }

    /**
     * @param offensiveReward the offensiveReward to set
     */
    public void setOffensiveReward(int offensiveReward) {
        this.offensiveReward = offensiveReward;
    }

    /**
     * @return the defensiveReward
     */
    public int getDefensiveReward() {
        return defensiveReward;
    }

    /**
     * @param defensiveReward the defensiveReward to set
     */
    public void setDefensiveReward(int defensiveReward) {
        this.defensiveReward = defensiveReward;
    }

    /**
     * @return the members
     */
    public List<CapitalRaidMember> getMembers() {
        return members;
    }

    /**
     * @param members the members to set
     */
    public void setMembers(List<CapitalRaidMember> members) {
        this.members = members;
    }

    /**
     * @return the attackLog
     */
    public List<CapitalRaidAttackLog> getAttackLog() {
        return attackLog;
    }

    /**
     * @param attackLog the attackLog to set
     */
    public void setAttackLog(List<CapitalRaidAttackLog> attackLog) {
        this.attackLog = attackLog;
    }

    /**
     * @return the defenseLog
     */
    public List<CapitalRaidAttackLog> getDefenseLog() {
        return defenseLog;
    }

    /**
     * @param defenseLog the defenseLog to set
     */
    public void setDefenseLog(List<CapitalRaidAttackLog> defenseLog) {
        this.defenseLog = defenseLog;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
        result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
        result = prime * result + capitalTotalLoot;
        result = prime * result + raidsCompleted;
        result = prime * result + totalAttacks;
        result = prime * result + enemyDistrictsDestroyed;
        result = prime * result + offensiveReward;
        result = prime * result + defensiveReward;
        result = prime * result + ((members == null) ? 0 : members.hashCode());
        result = prime * result + ((attackLog == null) ? 0 : attackLog.hashCode());
        result = prime * result + ((defenseLog == null) ? 0 : defenseLog.hashCode());
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
        CapitalRaid other = (CapitalRaid) obj;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        if (startTime == null) {
            if (other.startTime != null)
                return false;
        } else if (!startTime.equals(other.startTime))
            return false;
        if (endTime == null) {
            if (other.endTime != null)
                return false;
        } else if (!endTime.equals(other.endTime))
            return false;
        if (capitalTotalLoot != other.capitalTotalLoot)
            return false;
        if (raidsCompleted != other.raidsCompleted)
            return false;
        if (totalAttacks != other.totalAttacks)
            return false;
        if (enemyDistrictsDestroyed != other.enemyDistrictsDestroyed)
            return false;
        if (offensiveReward != other.offensiveReward)
            return false;
        if (defensiveReward != other.defensiveReward)
            return false;
        if (members == null) {
            if (other.members != null)
                return false;
        } else if (!members.equals(other.members))
            return false;
        if (attackLog == null) {
            if (other.attackLog != null)
                return false;
        } else if (!attackLog.equals(other.attackLog))
            return false;
        if (defenseLog == null) {
            if (other.defenseLog != null)
                return false;
        } else if (!defenseLog.equals(other.defenseLog))
            return false;
        return true;
    }


}
