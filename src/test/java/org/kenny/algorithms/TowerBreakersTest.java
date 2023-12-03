package org.kenny.algorithms;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TowerBreakersTest {

    @Test
    public void testTowerBreakersWithEvenNAndM1() {
        int result = TowerBreakers.towerBreakers(6, 1);
        assertEquals(2, result);
    }

    @Test
    public void testTowerBreakersWithOddNAndM1() {
        int result = TowerBreakers.towerBreakers(5, 1);
        assertEquals(2, result);
    }

    @Test
    public void testTowerBreakersWithEvenNAndNonM1() {
        int result = TowerBreakers.towerBreakers(8, 3);
        assertEquals(2, result);
    }

    @Test
    public void testTowerBreakersWithOddNAndNonM1() {
        int result = TowerBreakers.towerBreakers(7, 4);
        assertEquals(1, result);
    }
}
