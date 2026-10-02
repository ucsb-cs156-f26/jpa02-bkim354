package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_value() {
        //Case 1: Same team
        assertEquals(team.equals(team), true);

        //Case 2: Different object
        int a = 5;
        assertEquals(team.equals(a), false);

        //Case 3
        //Same name, same members
        Team team1 = new Team("test-team");
        Team team2 = new Team("test-team");
        assertEquals(team1.equals(team2), true);

        //Same name, different members
        team2.addMember("Bob");
        assertEquals(team1.equals(team2), false);

        //Different names, same members
        team1.addMember("Bob");
        team2.setName("buh");
        assertEquals(team1.equals(team2), false);
    }

    @Test
    public void hashCode_returns_correct_value() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }


}
