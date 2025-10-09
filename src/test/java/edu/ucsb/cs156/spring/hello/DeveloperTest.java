package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Jayden", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("jaytan3966", Developer.getGithubId());
    }

    @Test
        public void getTeam_returns_team_with_correct_name() {
            Team  t = Developer.getTeam();
            assertEquals("f25-12", t.getName());
        }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("JOSHUA CHACKO"),"Team should contain JOSHUA CHACKO");
        assertTrue(t.getMembers().contains("ALVIN KEN"),"Team should contain ALVIN KEN");
        assertTrue(t.getMembers().contains("HAUKE SEBASTIAN"),"Team should contain HAUKE SEBASTIAN");
        assertTrue(t.getMembers().contains("JAYDEN JUN KHAI"),"Team should contain JAYDEN JUN KHAI");
        assertTrue(t.getMembers().contains("BEN"),"Team should contain BEN");
        assertTrue(t.getMembers().contains("TEJ SRI"),"Team should contain TEJ SRI");
    }



}
