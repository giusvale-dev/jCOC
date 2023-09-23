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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClanSearch extends GenericClan{

    @JsonProperty
    private String type;

    @JsonProperty
    private Location location;

    @JsonProperty
    private boolean isFamilyFriendly;

    @JsonProperty
    private int clanPoints;

    @JsonProperty
    private int clanBuilderBasePoints;

    @JsonProperty
    private int clanVersusPoints;

    @JsonProperty
    private int clanCapitalPoints;

    @JsonProperty
    private League capitalLeague;

    @JsonProperty
    private int requiredTrophies;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private WarFrequency warFrequency;

    @JsonProperty
    private int warWinStreak;

    @JsonProperty
    private int warWins;

    @JsonProperty
    private int warTies;

    @JsonProperty
    private int warLosses;

    @JsonProperty
    private boolean isWarLogPublic;

    @JsonProperty
    private League warLeague;

    @JsonProperty
    private int members;

    @JsonProperty
    private List<Label> labels;

    @JsonProperty
    private int requiredBuilderBaseTrophies;
    
    @JsonProperty
    private int requiredVersusTrophies;
    
    @JsonProperty
    private int requiredTownhallLevel;


    public ClanSearch() {

    }


    /**
     * @return the type
     */
    public String getType() {
        return type;
    }


    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }


    /**
     * @return the location
     */
    public Location getLocation() {
        return location;
    }


    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }


    /**
     * @return the isFamilyFriendly
     */
    public boolean isFamilyFriendly() {
        return isFamilyFriendly;
    }


    /**
     * @param isFamilyFriendly the isFamilyFriendly to set
     */
    public void setFamilyFriendly(boolean isFamilyFriendly) {
        this.isFamilyFriendly = isFamilyFriendly;
    }


    /**
     * @return the clanPoints
     */
    public int getClanPoints() {
        return clanPoints;
    }


    /**
     * @param clanPoints the clanPoints to set
     */
    public void setClanPoints(int clanPoints) {
        this.clanPoints = clanPoints;
    }


    /**
     * @return the clanBuilderBasePoints
     */
    public int getClanBuilderBasePoints() {
        return clanBuilderBasePoints;
    }


    /**
     * @param clanBuilderBasePoints the clanBuilderBasePoints to set
     */
    public void setClanBuilderBasePoints(int clanBuilderBasePoints) {
        this.clanBuilderBasePoints = clanBuilderBasePoints;
    }


    /**
     * @return the clanVersusPoints
     */
    public int getClanVersusPoints() {
        return clanVersusPoints;
    }


    /**
     * @param clanVersusPoints the clanVersusPoints to set
     */
    public void setClanVersusPoints(int clanVersusPoints) {
        this.clanVersusPoints = clanVersusPoints;
    }


    /**
     * @return the clanCapitalPoints
     */
    public int getClanCapitalPoints() {
        return clanCapitalPoints;
    }


    /**
     * @param clanCapitalPoints the clanCapitalPoints to set
     */
    public void setClanCapitalPoints(int clanCapitalPoints) {
        this.clanCapitalPoints = clanCapitalPoints;
    }


    /**
     * @return the capitalLeague
     */
    public League getCapitalLeague() {
        return capitalLeague;
    }


    /**
     * @param capitalLeague the capitalLeague to set
     */
    public void setCapitalLeague(League capitalLeague) {
        this.capitalLeague = capitalLeague;
    }


    /**
     * @return the requiredTrophies
     */
    public int getRequiredTrophies() {
        return requiredTrophies;
    }


    /**
     * @param requiredTrophies the requiredTrophies to set
     */
    public void setRequiredTrophies(int requiredTrophies) {
        this.requiredTrophies = requiredTrophies;
    }


    /**
     * @return the warFrequency
     */
    public WarFrequency getWarFrequency() {
        return warFrequency;
    }


    /**
     * @param warFrequency the warFrequency to set
     */
    public void setWarFrequency(WarFrequency warFrequency) {
        this.warFrequency = warFrequency;
    }


    /**
     * @return the warWinStreak
     */
    public int getWarWinStreak() {
        return warWinStreak;
    }


    /**
     * @param warWinStreak the warWinStreak to set
     */
    public void setWarWinStreak(int warWinStreak) {
        this.warWinStreak = warWinStreak;
    }


    /**
     * @return the warWins
     */
    public int getWarWins() {
        return warWins;
    }


    /**
     * @param warWins the warWins to set
     */
    public void setWarWins(int warWins) {
        this.warWins = warWins;
    }


    /**
     * @return the warTies
     */
    public int getWarTies() {
        return warTies;
    }


    /**
     * @param warTies the warTies to set
     */
    public void setWarTies(int warTies) {
        this.warTies = warTies;
    }


    /**
     * @return the warLosses
     */
    public int getWarLosses() {
        return warLosses;
    }


    /**
     * @param warLosses the warLosses to set
     */
    public void setWarLosses(int warLosses) {
        this.warLosses = warLosses;
    }


    /**
     * @return the isWarLogPublic
     */
    public boolean isWarLogPublic() {
        return isWarLogPublic;
    }


    /**
     * @param isWarLogPublic the isWarLogPublic to set
     */
    public void setWarLogPublic(boolean isWarLogPublic) {
        this.isWarLogPublic = isWarLogPublic;
    }


    /**
     * @return the warLeague
     */
    public League getWarLeague() {
        return warLeague;
    }


    /**
     * @param warLeague the warLeague to set
     */
    public void setWarLeague(League warLeague) {
        this.warLeague = warLeague;
    }


    /**
     * @return the members
     */
    public int getMembers() {
        return members;
    }


    /**
     * @param members the members to set
     */
    public void setMembers(int members) {
        this.members = members;
    }


    /**
     * @return the labels
     */
    public List<Label> getLabels() {
        return labels;
    }


    /**
     * @param labels the labels to set
     */
    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }


    /**
     * @return the requiredBuilderBaseTrophies
     */
    public int getRequiredBuilderBaseTrophies() {
        return requiredBuilderBaseTrophies;
    }


    /**
     * @param requiredBuilderBaseTrophies the requiredBuilderBaseTrophies to set
     */
    public void setRequiredBuilderBaseTrophies(int requiredBuilderBaseTrophies) {
        this.requiredBuilderBaseTrophies = requiredBuilderBaseTrophies;
    }


    /**
     * @return the requiredVersusTrophies
     */
    public int getRequiredVersusTrophies() {
        return requiredVersusTrophies;
    }


    /**
     * @param requiredVersusTrophies the requiredVersusTrophies to set
     */
    public void setRequiredVersusTrophies(int requiredVersusTrophies) {
        this.requiredVersusTrophies = requiredVersusTrophies;
    }


    /**
     * @return the requiredTownhallLevel
     */
    public int getRequiredTownhallLevel() {
        return requiredTownhallLevel;
    }


    /**
     * @param requiredTownhallLevel the requiredTownhallLevel to set
     */
    public void setRequiredTownhallLevel(int requiredTownhallLevel) {
        this.requiredTownhallLevel = requiredTownhallLevel;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + (isFamilyFriendly ? 1231 : 1237);
        result = prime * result + clanPoints;
        result = prime * result + clanBuilderBasePoints;
        result = prime * result + clanVersusPoints;
        result = prime * result + clanCapitalPoints;
        result = prime * result + ((capitalLeague == null) ? 0 : capitalLeague.hashCode());
        result = prime * result + requiredTrophies;
        result = prime * result + ((warFrequency == null) ? 0 : warFrequency.hashCode());
        result = prime * result + warWinStreak;
        result = prime * result + warWins;
        result = prime * result + warTies;
        result = prime * result + warLosses;
        result = prime * result + (isWarLogPublic ? 1231 : 1237);
        result = prime * result + ((warLeague == null) ? 0 : warLeague.hashCode());
        result = prime * result + members;
        result = prime * result + ((labels == null) ? 0 : labels.hashCode());
        result = prime * result + requiredBuilderBaseTrophies;
        result = prime * result + requiredVersusTrophies;
        result = prime * result + requiredTownhallLevel;
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
        ClanSearch other = (ClanSearch) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (location == null) {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        if (isFamilyFriendly != other.isFamilyFriendly)
            return false;
        if (clanPoints != other.clanPoints)
            return false;
        if (clanBuilderBasePoints != other.clanBuilderBasePoints)
            return false;
        if (clanVersusPoints != other.clanVersusPoints)
            return false;
        if (clanCapitalPoints != other.clanCapitalPoints)
            return false;
        if (capitalLeague == null) {
            if (other.capitalLeague != null)
                return false;
        } else if (!capitalLeague.equals(other.capitalLeague))
            return false;
        if (requiredTrophies != other.requiredTrophies)
            return false;
        if (warFrequency != other.warFrequency)
            return false;
        if (warWinStreak != other.warWinStreak)
            return false;
        if (warWins != other.warWins)
            return false;
        if (warTies != other.warTies)
            return false;
        if (warLosses != other.warLosses)
            return false;
        if (isWarLogPublic != other.isWarLogPublic)
            return false;
        if (warLeague == null) {
            if (other.warLeague != null)
                return false;
        } else if (!warLeague.equals(other.warLeague))
            return false;
        if (members != other.members)
            return false;
        if (labels == null) {
            if (other.labels != null)
                return false;
        } else if (!labels.equals(other.labels))
            return false;
        if (requiredBuilderBaseTrophies != other.requiredBuilderBaseTrophies)
            return false;
        if (requiredVersusTrophies != other.requiredVersusTrophies)
            return false;
        if (requiredTownhallLevel != other.requiredTownhallLevel)
            return false;
        return true;
    }


    

    
}
