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

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClanInfoMember extends GenericMember{

    private String role;
    private int expLevel;
    private League league;
    private int trophies;
    private int builderBaseTrophies;
    private int versusTrophies;
    private int clanRank;
    private int previousClanRank;
    private int donations;
    private int donationsReceived;
    private PlayerHouse playerHouse;
    private League builderBaseLeague;

    public ClanInfoMember() {
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the expLevel
     */
    public int getExpLevel() {
        return expLevel;
    }

    /**
     * @param expLevel the expLevel to set
     */
    public void setExpLevel(int expLevel) {
        this.expLevel = expLevel;
    }

    /**
     * @return the league
     */
    public League getLeague() {
        return league;
    }

    /**
     * @param league the league to set
     */
    public void setLeague(League league) {
        this.league = league;
    }

    /**
     * @return the trophies
     */
    public int getTrophies() {
        return trophies;
    }

    /**
     * @param trophies the trophies to set
     */
    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }

    /**
     * @return the builderBaseTrophies
     */
    public int getBuilderBaseTrophies() {
        return builderBaseTrophies;
    }

    /**
     * @param builderBaseTrophies the builderBaseTrophies to set
     */
    public void setBuilderBaseTrophies(int builderBaseTrophies) {
        this.builderBaseTrophies = builderBaseTrophies;
    }

    /**
     * @return the versusTrophies
     */
    public int getVersusTrophies() {
        return versusTrophies;
    }

    /**
     * @param versusTrophies the versusTrophies to set
     */
    public void setVersusTrophies(int versusTrophies) {
        this.versusTrophies = versusTrophies;
    }

    /**
     * @return the clanRank
     */
    public int getClanRank() {
        return clanRank;
    }

    /**
     * @param clanRank the clanRank to set
     */
    public void setClanRank(int clanRank) {
        this.clanRank = clanRank;
    }

    /**
     * @return the previousClanRank
     */
    public int getPreviousClanRank() {
        return previousClanRank;
    }

    /**
     * @param previousClanRank the previousClanRank to set
     */
    public void setPreviousClanRank(int previousClanRank) {
        this.previousClanRank = previousClanRank;
    }

    /**
     * @return the donations
     */
    public int getDonations() {
        return donations;
    }

    /**
     * @param donations the donations to set
     */
    public void setDonations(int donations) {
        this.donations = donations;
    }

    /**
     * @return the donationsReceived
     */
    public int getDonationsReceived() {
        return donationsReceived;
    }

    /**
     * @param donationsReceived the donationsReceived to set
     */
    public void setDonationsReceived(int donationsReceived) {
        this.donationsReceived = donationsReceived;
    }

    /**
     * @return the playerHouse
     */
    public PlayerHouse getPlayerHouse() {
        return playerHouse;
    }

    /**
     * @param playerHouse the playerHouse to set
     */
    public void setPlayerHouse(PlayerHouse playerHouse) {
        this.playerHouse = playerHouse;
    }

    /**
     * @return the builderBaseLeague
     */
    public League getBuilderBaseLeague() {
        return builderBaseLeague;
    }

    /**
     * @param builderBaseLeague the builderBaseLeague to set
     */
    public void setBuilderBaseLeague(League builderBaseLeague) {
        this.builderBaseLeague = builderBaseLeague;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result + expLevel;
        result = prime * result + ((league == null) ? 0 : league.hashCode());
        result = prime * result + trophies;
        result = prime * result + builderBaseTrophies;
        result = prime * result + versusTrophies;
        result = prime * result + clanRank;
        result = prime * result + previousClanRank;
        result = prime * result + donations;
        result = prime * result + donationsReceived;
        result = prime * result + ((playerHouse == null) ? 0 : playerHouse.hashCode());
        result = prime * result + ((builderBaseLeague == null) ? 0 : builderBaseLeague.hashCode());
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
        ClanInfoMember other = (ClanInfoMember) obj;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        if (expLevel != other.expLevel)
            return false;
        if (league == null) {
            if (other.league != null)
                return false;
        } else if (!league.equals(other.league))
            return false;
        if (trophies != other.trophies)
            return false;
        if (builderBaseTrophies != other.builderBaseTrophies)
            return false;
        if (versusTrophies != other.versusTrophies)
            return false;
        if (clanRank != other.clanRank)
            return false;
        if (previousClanRank != other.previousClanRank)
            return false;
        if (donations != other.donations)
            return false;
        if (donationsReceived != other.donationsReceived)
            return false;
        if (playerHouse == null) {
            if (other.playerHouse != null)
                return false;
        } else if (!playerHouse.equals(other.playerHouse))
            return false;
        if (builderBaseLeague == null) {
            if (other.builderBaseLeague != null)
                return false;
        } else if (!builderBaseLeague.equals(other.builderBaseLeague))
            return false;
        return true;
    }
  
}
