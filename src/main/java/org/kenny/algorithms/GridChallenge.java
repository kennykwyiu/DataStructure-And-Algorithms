package org.kenny.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
public class GridChallenge {
    public static String gridChallenge(List<String> grid) {
        // Write your code here
        int rows = grid.size();
        int cols = grid.get(0).length();

        // Convert each row to a sorted char array
        char[][] sortedGrid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            char[] row = grid.get(i).toCharArray();
            Arrays.sort(row);
            sortedGrid[i] = row;
        }

        // Check if each column is sorted in non-decreasing order
        for (int col = 0; col < cols; col++) {
            for (int row = 1; row < rows; row++) {
                if (sortedGrid[row][col] < sortedGrid[row - 1][col]) {
                    return "NO"; // Grid is not sortable
                }
            }
        }

        return "YES"; // Grid is sortable
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String result = GridChallenge.gridChallenge(grid);
                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
