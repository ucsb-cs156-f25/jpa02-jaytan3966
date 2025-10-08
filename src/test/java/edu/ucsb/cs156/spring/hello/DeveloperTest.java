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
        assertTrue(t.getMembers().contains("Alvin"),"Team should contain Alvin");
        assertTrue(t.getMembers().contains("Ben"),"Team should contain Ben");
        assertTrue(t.getMembers().contains("Jayden"),"Team should contain Jayden");
        assertTrue(t.getMembers().contains("Joshua"),"Team should contain Joshua");
        assertTrue(t.getMembers().contains("Hauke"),"Team should contain Hauke");
        assertTrue(t.getMembers().contains("Tej"),"Team should contain Tej");
    }



}
