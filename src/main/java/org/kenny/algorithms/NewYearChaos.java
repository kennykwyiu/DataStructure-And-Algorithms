package org.kenny.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class NewYearChaos {
    /**
     * Complete the 'minimumBribes' function below.
     * <p>
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int totalCount = 0;
        for (int i = 0; i < q.size(); i++) {
            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                if (q.get(j) > q.get(i)) {
                    totalCount++;
                }
            }
        }
        System.out.println(totalCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

/**
 * Sure! Here's the question for the "New Year Chaos" problem on HackerRank:
 * <p>
 * ## New Year Chaos
 * <p>
 * It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride! There are a number of people queued up, and each person wears a sticker indicating their initial position in the queue. Initial positions increment by `1` from `1` at the front of the line to `n` at the back.
 * <p>
 * Any person in the queue can bribe the person directly in front of them to swap positions. If two people swap positions, they still wear the same sticker denoting their original places in line. One person can bribe at most two others.
 * <p>
 * That is to say, if `n = 8` and `Person 5` bribes `Person 4`, the queue will look like this: `1, 2, 3, 5, 4, 6, 7, 8`.
 * <p>
 * Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state!
 * <p>
 * Complete the function `minimumBribes` in the editor below. It must print an integer representing the minimum number of bribes necessary, or `"Too chaotic"` if the line configuration is not possible.
 * <p>
 * `minimumBribes` has the following parameter(s):
 * <p>
 * * `q`: an array of integers representing the final state of the queue.
 * <p>
 * ### Constraints
 * <p>
 * * `1 ≤ t ≤ 10` (the number of test cases)
 * * `1 ≤ n ≤ 10^5` (the length of the queue)
 * * `1 ≤ q[i] ≤ 10^5`
 * <p>
 * ### Input Format
 * <p>
 * The first line contains an integer `t`, the number of test cases.
 * <p>
 * Each of the next `t` pairs of lines are as follows:
 * - The first line contains an integer `n`, the number of people in the queue.
 * - The second line contains `n` space-separated integers describing the final state of the queue.
 * <p>
 * ### Output Format
 * <p>
 * Print an integer denoting the minimum number of bribes needed to get the queue into its final state. Print `"Too chaotic"` if the state is invalid, i.e., it requires a person to have bribed more than `2` people.
 * <p>
 * ### Sample Input
 * <p>
 * ```
 * 2
 * 5
 * 2 1 5 3 4
 * 5
 * 2 5 1 3 4
 * ```
 * <p>
 * ### Sample Output
 * <p>
 * ```
 * 3
 * Too chaotic
 * ```
 * <p>
 * ### Explanation
 * <p>
 * Test Case 1:
 * <p>
 * The initial state:
 * ```
 * 1 2 3 4 5
 * ```
 * <p>
 * After person `5` moves one position ahead by bribing person `4`:
 * ```
 * 1 2 3 5 4
 * ```
 * <p>
 * After person `5` moves another position ahead by bribing person `3`:
 * ```
 * 1 2 5 3 4
 * ```
 * <p>
 * After person `2` moves one position ahead by bribing person `1`:
 * ```
 * 2 1 5 3 4
 * ```
 * <p>
 * So, the minimum number of bribes required is `3`.
 * <p>
 * Test Case 2:
 * <p>
 * No person can bribe more than two others, so it's not possible to achieve the input state.
 * <p>
 * Therefore, the output is `"Too chaotic"`.
 */
