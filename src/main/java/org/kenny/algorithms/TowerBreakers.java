package org.kenny.algorithms;

import java.io.*;
import java.util.stream.IntStream;

/**
 *
 * Two players are playing a game of towerBreakers. The rules of the game are as follows:
 * • There are n towers.
 * • Each tower is of height m.
 * • The players move in alternating turns.
 * • In each turn, a player can choose a tower of height h > 1 and reduce its height to h-1 or h/2 (integer division).
 * • If it is impossible for the current player to make a move, they lose the game.
 * Given the values of n and m, determine whether the first player can win the game if both players play optimally.
 *
 */
public class TowerBreakers {
    /*
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int towerBreakers(int n, int m) {
        // Write your code here
        if (m == 1 || n % 2 == 0) {
            return 2;
        }
        return 1;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);
                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = TowerBreakers.towerBreakers(n, m);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }


}
