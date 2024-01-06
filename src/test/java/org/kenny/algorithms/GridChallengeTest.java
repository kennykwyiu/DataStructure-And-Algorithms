package org.kenny.algorithms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GridChallengeTest {

    @Test
    public void testGridChallenge() {
        List<String> grid1 = Arrays.asList(
                "abc",
                "def",
                "ghi"
        );
        String result1 = GridChallenge.gridChallenge(grid1);
        Assertions.assertEquals("YES", result1);

        List<String> grid2 = Arrays.asList(
                "cba",
                "daf",
                "ghi"
        );
        String result2 = GridChallenge.gridChallenge(grid2);
        Assertions.assertEquals("YES", result2);

        List<String> grid3 = Arrays.asList(
                "abc",
                "def",
                "ijk"
        );
        String result3 = GridChallenge.gridChallenge(grid3);
        Assertions.assertEquals("YES", result3);
    }
}
