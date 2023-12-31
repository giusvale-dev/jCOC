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

package org.jclash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;



import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import org.jclash.domain.Attack;
import org.jclash.domain.CapitalRaid;
import org.jclash.domain.CapitalRaidAttackLog;
import org.jclash.domain.CapitalRaidMember;
import org.jclash.domain.ClanInfo;
import org.jclash.domain.ClanType;
import org.jclash.domain.CurrentWar;
import org.jclash.domain.CurrentWarMember;
import org.jclash.domain.Element;
import org.jclash.domain.ClanInfoMember;
import org.jclash.domain.CapitalRaidClan;
import org.jclash.domain.ClanSearch;
import org.jclash.domain.PlayerHouse;
import org.jclash.domain.Search;
import org.jclash.domain.OldWar;
import org.jclash.exceptions.JCocException;
import org.jclash.utils.Utils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClanTest {

    private JCoc jcoc = null;

    @Before
    public void setUpTest() throws IOException, JCocException {

        // You need to insert the values in the application.properties
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
        if (inputStream == null) {
            throw new IOException(
                    "Please create an application.properties file in src/main/resource and add the properties username and password with your personal values!");
        }

        Properties properties = new Properties();
        properties.load(inputStream);

        // String username = properties.getProperty("username");
        // String password = properties.getProperty("password");
       String apiToken = properties.getProperty("token");

        // jcoc = new JCoc(username, password);
       jcoc = new JCoc(apiToken);

    }

    /**
     * Testing generic Clan deserialization
     */
    @Test
    public void testGenericClanDeserialization() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("clan.json");
        ClanInfo c = mapper.readValue(inputStream, ClanInfo.class);
        assertNotNull(c);
    }

    /**
     * Test the deserialization process
     * 
     * @throws IOException
     * @throws DatabindException
     * @throws StreamReadException
     */
    @Test
    public void testClanDeserialize() throws StreamReadException, DatabindException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("clan.json");
        ClanInfo c = mapper.readValue(inputStream, ClanInfo.class);
        assertNotNull(c);
        assertEquals("#VLL2CUVJ", c.getTag());
        assertEquals("Davros", c.getName());
        assertEquals("inviteOnly", ClanType.INVITE_ONLY.getCode());
        assertEquals("Description example", c.getDescription());
        assertEquals(32000120, c.getLocation().getId());
        assertEquals("Italy", c.getLocation().getName());
        assertEquals(true, c.getLocation().isCountry());
        assertEquals("IT", c.getLocation().getCountryCode());
        assertEquals(false, c.isFamilyFriendly());
        assertEquals(false, c.isFamilyFriendly());
        assertEquals("largeBadge", c.getBadgeUrls().getLarge());
        assertEquals("smallBadge", c.getBadgeUrls().getSmall());
        assertEquals("mediumBadge", c.getBadgeUrls().getMedium());
        assertEquals(19, c.getClanLevel());
        assertEquals(34328, c.getClanPoints());
        assertEquals(29722, c.getClanBuilderBasePoints());
        assertEquals(2368, c.getClanCapitalPoints());
        assertEquals(85000011, c.getCapitalLeague().getId());
        assertEquals("Crystal League II", c.getCapitalLeague().getName());
        assertEquals(2300, c.getRequiredTrophies());
        assertEquals("moreThanOncePerWeek", c.getWarFrequency().getFrequency());
        assertEquals(0, c.getWarWinStreak());
        assertEquals(232, c.getWarWins());
        assertEquals(4, c.getWarTies());
        assertEquals(65, c.getWarLosses());
        assertEquals(true, c.isWarLogPublic());
        assertEquals(48000013, c.getWarLeague().getId());
        assertEquals("Master League III", c.getWarLeague().getName());
        assertEquals(32, c.getMembers());
        assertEquals(32, c.getMemberList().size());
        ClanInfoMember m = c.getMemberList().get(0);
        assertEquals("#9JUUURU8Y", m.getTag());
        assertEquals("Cri", m.getName());
        assertEquals("coLeader", m.getRole());
        assertEquals(245, m.getExpLevel());
        assertEquals(5003, m.getTrophies());
        assertEquals(4142, m.getBuilderBaseTrophies());
        assertEquals(4142, m.getVersusTrophies());
        assertEquals(1, m.getClanRank());
        assertEquals(1, m.getPreviousClanRank());
        assertEquals(2559, m.getDonations());
        assertEquals(2321, m.getDonationsReceived());
        assertEquals(29000022, m.getLeague().getId());
        assertEquals("Legend League", m.getLeague().getName());
        assertEquals("small", m.getLeague().getIconUrls().getSmall());
        assertEquals("tiny", m.getLeague().getIconUrls().getTiny());
        assertEquals("medium", m.getLeague().getIconUrls().getMedium());
        PlayerHouse ph = m.getPlayerHouse();
        Element e = ph.getElements().get(0);
        assertEquals(82000002, e.getId());
        assertEquals("ground", e.getType());
        assertEquals(44000030, m.getBuilderBaseLeague().getId());
        assertEquals("Titanium League II", m.getBuilderBaseLeague().getName());

    }

    /**
     * This method test if the Clan Info is right.
     * After the call check if the tag of searched clan (immutable and existing) is
     * equals
     * to the retrieved tag
     */
    @Test
    public void testClanInfo() {

        try {
            assertNotNull(this.jcoc);
            String clanTag = "#VLL2CUVJ"; // This tag refers to an existing clan and the tag is immutable
            ClanInfo clan = this.jcoc.clanInfo(clanTag);
            assertNotNull(clan);
            assertEquals(clan.getTag(), clanTag);
        } catch (JCocException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * Test the clan Members search in paging mode and not
     * The test check if the results obtained from no limited search is equal
     * to the paged search
     */
    @Test
    public void testClanMembers() {

        try {
            assertNotNull(this.jcoc);
            String clanTag = "#VLL2CUVJ";
            Search<ClanInfoMember> search = this.jcoc.clanMembers(clanTag, 50, null, null);
            assertNotNull(search);
            assertNotEquals(search.getItems().size(), 0);

            List<ClanInfoMember> noPagingSearchList = search.getItems();
            List<ClanInfoMember> pagingList = new ArrayList<ClanInfoMember>(); // a temp list to check the paging results are equals to
                                                               // the one shot search

            // 10 elements per page
            int numberOfPage = (noPagingSearchList.size() / 10);
            if (noPagingSearchList.size() % 10 != 0) {
                numberOfPage += 1;
            }

            int currentPage = 0;
            while (currentPage < numberOfPage) {

                // First search
                if (currentPage == 0) {
                    search = this.jcoc.clanMembers(clanTag, 10, null, null);
                } else {
                    search = this.jcoc.clanMembers(clanTag, 10, null, search.getPaging().getCursors().getAfter());
                }

                assertNotNull(search);
                assertTrue(search.getItems().size() <= 10);
                pagingList.addAll(search.getItems());
                currentPage++;
            }

            assertTrue(noPagingSearchList.containsAll(pagingList)); // Check if the two lists are equal

        } catch (JCocException e) {
            e.printStackTrace();
            Assert.fail();
        }

    }

    /**
     * Test converting COC string date to java.util.Date
     * @throws ParseException
     */
    @Test
    public void dateConverterTest() throws ParseException {

        try {
            Date date = Utils.convertDate("20230809T111730.000Z");
            assertNotNull(date);
            GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
            gc.setTime(date);
            assertEquals(gc.get(GregorianCalendar.YEAR), 2023);
            assertEquals(gc.get(GregorianCalendar.MONTH), GregorianCalendar.AUGUST);
            assertEquals(gc.get(GregorianCalendar.DAY_OF_MONTH), 9);
            assertEquals(gc.get(GregorianCalendar.HOUR_OF_DAY), 11);
            assertEquals(gc.get(GregorianCalendar.MINUTE), 17);
            assertEquals(gc.get(GregorianCalendar.SECOND), 30);

            date = Utils.convertDate("20200618T183601.000Z");
            assertNotNull(date);
            gc.setTime(date);
            assertEquals(gc.get(GregorianCalendar.YEAR), 2020);
            assertEquals(gc.get(GregorianCalendar.MONTH), GregorianCalendar.JUNE);
            assertEquals(gc.get(GregorianCalendar.DAY_OF_MONTH), 18);
            assertEquals(gc.get(GregorianCalendar.HOUR_OF_DAY), 18);
            assertEquals(gc.get(GregorianCalendar.MINUTE), 36);
            assertEquals(gc.get(GregorianCalendar.SECOND), 1);


        } catch (JCocException e) {
            fail();
        }
    }

    /**
     * Test the worlog api
     */
    @Test
    public void testWarLog() {

        try {
            assertNotNull(this.jcoc);
            String clanTag = "#VLL2CUVJ"; //Clan exists
            Search<OldWar> search = this.jcoc.warLog(clanTag, 50, null, null);
            assertNotNull(search);
            assertNotEquals(search.getItems().size(), 0);

            List<OldWar> noPagingSearchList = search.getItems();
            List<OldWar> pagingList = new ArrayList<OldWar>(); // a temp list to check the paging results are equals to
            // the one shot search
            // 10 elements per page
            int numberOfPage = (noPagingSearchList.size() / 10);
            if (noPagingSearchList.size() % 10 != 0) {
                numberOfPage += 1;
            }

            int currentPage = 0;
            while (currentPage < numberOfPage) {

                // First search
                if (currentPage == 0) {
                    search = this.jcoc.warLog(clanTag, 10, null, null);
                } else {
                    search = this.jcoc.warLog(clanTag, 10, null, search.getPaging().getCursors().getAfter());
                }

                assertNotNull(search);
                assertTrue(search.getItems().size() <= 10);
                pagingList.addAll(search.getItems());
                currentPage++;
            }
            assertTrue(noPagingSearchList.containsAll(pagingList)); // Check if the two lists are equal
            for(OldWar w : noPagingSearchList) {
                assertEquals(w.getClan().getTag(), "#VLL2CUVJ"); //Check if the data is retrieved correctly
            }

        } catch (JCocException e) {
            e.printStackTrace();
            Assert.fail();
        }

    }
    

    /**
     * Test the current war deserialization (offline test)
     * @throws Exception
     */
    @Test
    public void testCurrentWarDeserialized() {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("currentwar.json");
        CurrentWar cw = null;
        try {
            cw = mapper.readValue(inputStream, CurrentWar.class);
        } catch(Exception e) {
            Assert.fail();
        }
        assertNotNull(cw);
        assertEquals(cw.getState(), "inWar");
        assertEquals(cw.getTeamSize(), 15);
        assertEquals(cw.getPreparationStartTime(), "20230917T193135.000Z");
        assertEquals(cw.getClan().getAttacks(), 10);

        for(CurrentWarMember cwm : cw.getClan().getMembers()) {
            if(cwm.getTag().equals("#8CJ922CPC")) {
                for(Attack a : cwm.getAttacks()) {
                    assertTrue(a.getStars() == 2 || a.getStars() == 3);
                }
            }
        }
    }

    @Test
    public void clanSearchDeserializeTest() throws StreamReadException, DatabindException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("clan-search.json");
        JavaType type = mapper.getTypeFactory().constructParametricType(Search.class, ClanSearch.class);
        Search<ClanSearch> resultSearch = mapper.readValue(inputStream, type);
        assertNotNull(resultSearch);
        assertTrue(resultSearch.getItems().size() == 11);
        assertNotNull(resultSearch);
        for(ClanSearch cs : resultSearch.getItems()) {
            assertNotNull(cs);
            assertTrue(cs.getName().toUpperCase().contains("DAVROS"));
        }
    }

    @Test
    public void clanSearchAPITest() {
        try {
            //Test with a real clan
            Search<ClanSearch> result = this.jcoc.searchClans(
                                                              "Davros", null, 32000120, 
                                                              null, null, null,
                                                              null, null, null, 
                                                              null, null
                                                            );
            Assert.assertNotNull(result);

            for(ClanSearch cs : result.getItems()) {
                assertTrue(cs.getName().equalsIgnoreCase("Davros") || cs.getName().equalsIgnoreCase("Davros junior"));
            }


        } catch (JCocException e) {
            e.printStackTrace();
            Assert.fail();
        }

    }

    @Test
    public void clanRaidDeserializedTest() {
        try {

            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("capital-raid.json");
            JavaType type = mapper.getTypeFactory().constructParametricType(Search.class, CapitalRaid.class);
            Search<CapitalRaid> resultSearch = mapper.readValue(inputStream, type);
            assertNotNull(resultSearch);
            CapitalRaid raid = resultSearch.getItems().get(0);
            assertNotNull(raid);
            assertEquals(raid.getCapitalTotalLoot(), 326877);
            assertEquals(raid.getMembers().size(), 17);
            for(CapitalRaidMember raidMember : raid.getMembers()) {
                assertNotNull(raidMember);
            }

            assertNotNull(raid.getAttackLog());
            for(CapitalRaidAttackLog attackLog : raid.getAttackLog()) {
                assertNotNull(attackLog);
            }

            assertNotNull(raid.getDefenseLog());
            for(CapitalRaidAttackLog defenseLog : raid.getDefenseLog()) {
                assertNotNull(defenseLog);
            }

        } catch(Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
        
    }

    /**
     * A simple paging test
     */
    @Test
    public void testClanRaidAPI() {

        try {
            Search<CapitalRaid> totalResult = this.jcoc.capitalRaidSeason("#VLL2CUVJ", null, null, null);
            assertNotNull(totalResult);
            assertNotNull(totalResult.getItems());
            
            //Compute the number of pages
            int limit = 5;
            int numberOfItems = totalResult.getItems().size();
            int numberOfPages = numberOfItems / limit;
            if(numberOfPages % limit != 0) {
                numberOfPages++;
            }
            
            Search<CapitalRaid> searchPage = this.jcoc.capitalRaidSeason("#VLL2CUVJ", limit, null, null);
            int currentPage = 0;
            int totalElements = 0;
            List<CapitalRaid> pagingRaids = new ArrayList<CapitalRaid>();
            while(currentPage < numberOfPages) {
                assertNotNull(searchPage);
                assertNotNull(searchPage.getItems());
                List<CapitalRaid> raids = searchPage.getItems();
                assertTrue(raids.size() <= limit);
                totalElements+=raids.size();
                pagingRaids.addAll(pagingRaids); //Add the elements in the page to the list
                searchPage = this.jcoc.capitalRaidSeason("#VLL2CUVJ", limit, searchPage.getPaging().getCursors().getAfter(), null);
                currentPage++;
            }
            //At the end, the numberOfItems without pagin should be equals to the sum of the totalElements for each page
            assertEquals(totalElements, numberOfItems);
            //Check if the two lists are equal
            assertTrue(totalResult.getItems().containsAll(pagingRaids));

        } catch(JCocException e) {
            Assert.fail(e.getMessage());
        }
        
    }
}
