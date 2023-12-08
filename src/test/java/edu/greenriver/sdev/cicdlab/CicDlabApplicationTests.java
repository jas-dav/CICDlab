package edu.greenriver.sdev.cicdlab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CicDlabApplicationTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate rest;
    private Dice sixSidedGreenDice;


    @Test
    void contextLoads() {
    }

    @BeforeEach
    public void setup() {
        sixSidedGreenDice = new Dice(6, "green");
    }

    @Test
    public void testGetSides() {
        assertEquals(6, sixSidedGreenDice.getSides());
    }

    @Test
    public void testGetColor() {
        assertEquals("green", sixSidedGreenDice.getColor());
    }

    @Test
    public void testRollInRange() {
        int rollResult = sixSidedGreenDice.roll();
        assertTrue(rollResult >= 1 && rollResult <= 6);
    }

    @Test
    public void testRollMany() {
        int[] rolls = sixSidedGreenDice.rollMany(5);
        assertEquals(5, rolls.length);
        for (int roll : rolls) {
            assertTrue(roll >= 1 && roll <= 6);
        }
    }

    @Test
    public void testToString() {
        assertEquals("A 6 sided die", sixSidedGreenDice.toString());
    }

}
