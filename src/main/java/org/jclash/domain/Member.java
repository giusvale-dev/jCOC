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

public class Member {

    private String tag;
    private String name;
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

    public Member() {
    }

    /**
     * @return the tag
     */
    public String getTag() {
        return tag;
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
}
