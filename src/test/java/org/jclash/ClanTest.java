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
import static org.junit.Assert.assertNotNull;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.jclash.domain.Clan;
import org.jclash.domain.ClanType;
import org.jclash.domain.Element;
import org.jclash.domain.Member;
import org.jclash.domain.PlayerHouse;
import org.jclash.exceptions.JCocException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
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

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        jcoc = new JCoc(username, password);

    }

    /**
     * Testing generic Clan deserialization
     */
    @Test
    public void testGenericClanDeserialization() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("clan.json");
        Clan c = mapper.readValue(inputStream, Clan.class);
        assertNotNull(c);
    }

    /**
     * Test all properties during deserialization process are read correctly
     * 
     * @throws IOException
     * @throws DatabindException
     * @throws StreamReadException
     */
    @Test
    public void testClanDeserialize() throws StreamReadException, DatabindException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("clan.json");
        Clan c = mapper.readValue(inputStream, Clan.class);
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
        Member m = c.getMemberList().get(0);
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

    @Test
    public void testClanInfo() {

        try {
            assertNotNull(this.jcoc);
            String clanTag = "#VLL2CUVJ";
            Clan clan = this.jcoc.getClanInfo(clanTag);
            assertNotNull(clan);
            assertEquals(clan.getTag(), clanTag);
        } catch (JCocException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
