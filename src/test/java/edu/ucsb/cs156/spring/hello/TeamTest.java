package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_sameObject_returns_true(){
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_null_returns_false(){
        assertFalse(team.equals(null));
    }

    @Test
    public void equals_diffObject_returns_false(){
        assertFalse(team.equals("team"));
    }

    @Test
    public void equals_sameName_and_sameMembers_returns_true(){
        
        Team other = new Team("test-team");
        assertTrue(team.equals(other));
    }

    @Test
    public void equals_sameName_and_diffMembers_returns_false(){
        ArrayList<String> otherMembers = new ArrayList<>();
        otherMembers.add("Bobby");
        Team other = new Team("test-team");
        other.setMembers(otherMembers);
        assertFalse(team.equals(other));
    }

    @Test
    public void equals_diffName_and_sameMembers_returns_false(){
        Team other = new Team("test-team1");
        assertFalse(team.equals(other));
    }

    @Test
    public void equals_diffName_and_diffMembers_returns_false(){
        ArrayList<String> otherMembers = new ArrayList<>();
        otherMembers.add("Bobby");
        Team other = new Team("test-team1");
        other.setMembers(otherMembers);
        assertFalse(team.equals(other));
    }

    @Test
    public void hashCode_sameName_and_sameMembers_returns_true(){
        Team other = new Team("test-team");
        assertTrue(team.hashCode() == other.hashCode());
    }

    @Test
    public void hashCode_sameName_and_diffMembers_returns_false(){
        ArrayList<String> otherMembers = new ArrayList<>();
        otherMembers.add("Bobby");
        Team other = new Team("test-team");
        other.setMembers(otherMembers);

        assertFalse(team.hashCode() == other.hashCode());
    }

    @Test
    public void hashCode_diffName_and_sameMembers_returns_false(){
        Team other = new Team("test-team1");
        
        assertFalse(team.hashCode() == other.hashCode());
    }

    @Test
    public void hashCode_diffName_and_diffMembers_returns_false(){
        ArrayList<String> otherMembers = new ArrayList<>();
        otherMembers.add("Bobby");
        Team other = new Team("test-team1");
        other.setMembers(otherMembers);

        assertFalse(team.hashCode() == other.hashCode());
    }

    @Test
    public void hashCode_expectedValue_returns_true(){
        Team t = new Team("test-team");
        int result = t.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }
}
