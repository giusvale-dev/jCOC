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
public class Clan {
    
    public Clan() {
    }

    /** Fields used in clan war **/
    @JsonProperty
    private int attacks;

    @JsonProperty
    private int starts;

    @JsonProperty
    private double destructionPercentage;

    @JsonProperty
    private int expEarned;

    /** End fields used in clan war **/

    @JsonProperty
    private String tag;

    @JsonProperty
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private ClanType type;

    @JsonProperty
    private String description;

    @JsonProperty
    private Location location;

    @JsonProperty
    private boolean isFamilyFriendly;

    @JsonProperty
    private BadgeUrl badgeUrls;

    @JsonProperty
    private int clanLevel;

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
    private League warLeague;
   
    @JsonProperty
    private boolean isWarLogPublic;
    
    @JsonProperty
    private int requiredTownhallLevel;

    @JsonProperty
    private int members;

    @JsonProperty
    private List<Member> memberList;

    /**
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @return the memberList
     */
    public List<Member> getMemberList() {
        return memberList;
    }

    /**
     * @param memberList the memberList to set
     */
    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public ClanType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(ClanType type) {
        this.type = type;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @return the badgeUrls
     */
    public BadgeUrl getBadgeUrls() {
        return badgeUrls;
    }

    /**
     * @param badgeUrls the badgeUrls to set
     */
    public void setBadgeUrls(BadgeUrl badgeUrls) {
        this.badgeUrls = badgeUrls;
    }

    /**
     * @return the clanLevel
     */
    public int getClanLevel() {
        return clanLevel;
    }

    /**
     * @param clanLevel the clanLevel to set
     */
    public void setClanLevel(int clanLevel) {
        this.clanLevel = clanLevel;
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
     * @return the starts
     */
    public int getStarts() {
        return starts;
    }

    /**
     * @param starts the starts to set
     */
    public void setStarts(int starts) {
        this.starts = starts;
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
        int result = 1;
        result = prime * result + attacks;
        result = prime * result + starts;
        long temp;
        temp = Double.doubleToLongBits(destructionPercentage);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + expEarned;
        result = prime * result + ((tag == null) ? 0 : tag.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + (isFamilyFriendly ? 1231 : 1237);
        result = prime * result + ((badgeUrls == null) ? 0 : badgeUrls.hashCode());
        result = prime * result + clanLevel;
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
        result = prime * result + ((warLeague == null) ? 0 : warLeague.hashCode());
        result = prime * result + (isWarLogPublic ? 1231 : 1237);
        result = prime * result + requiredTownhallLevel;
        result = prime * result + members;
        result = prime * result + ((memberList == null) ? 0 : memberList.hashCode());
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
        Clan other = (Clan) obj;
        if (attacks != other.attacks)
            return false;
        if (starts != other.starts)
            return false;
        if (Double.doubleToLongBits(destructionPercentage) != Double.doubleToLongBits(other.destructionPercentage))
            return false;
        if (expEarned != other.expEarned)
            return false;
        if (tag == null) {
            if (other.tag != null)
                return false;
        } else if (!tag.equals(other.tag))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (type != other.type)
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (location == null) {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        if (isFamilyFriendly != other.isFamilyFriendly)
            return false;
        if (badgeUrls == null) {
            if (other.badgeUrls != null)
                return false;
        } else if (!badgeUrls.equals(other.badgeUrls))
            return false;
        if (clanLevel != other.clanLevel)
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
        if (warLeague == null) {
            if (other.warLeague != null)
                return false;
        } else if (!warLeague.equals(other.warLeague))
            return false;
        if (isWarLogPublic != other.isWarLogPublic)
            return false;
        if (requiredTownhallLevel != other.requiredTownhallLevel)
            return false;
        if (members != other.members)
            return false;
        if (memberList == null) {
            if (other.memberList != null)
                return false;
        } else if (!memberList.equals(other.memberList))
            return false;
        return true;
    }
}
