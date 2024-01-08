package org.kenny.algorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class ActiveTraders {
    public static List<String> mostActive(List<String> customers) {
        double MIN_THRESHOLD = 0.05;
        // Write your code here

        Map<String, Integer> countMap = new HashMap<>();

        for (String trader : customers) {
            countMap.put(trader, countMap.getOrDefault(trader, 0) + 1);
        }

        int totalCount = 0;

        for (int count : countMap.values()) {
            totalCount += count;
        }

        List<String> returnedList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            String entryName = entry.getKey();
            double eachTraderPercentage = calculatePercentage(countMap, entryName, totalCount);
            if (eachTraderPercentage >= MIN_THRESHOLD) {
                returnedList.add(entryName);
            }
        }

        return returnedList;
    }

    private static double calculatePercentage(Map<String, Integer> countMap, String activeTrader, int totalCount) {
        return (double) countMap.get(activeTrader) / totalCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int customersCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> customers = IntStream.range(0, customersCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = ActiveTraders.mostActive(customers);
        for (String name : result) {
            System.out.println(name);
        }


        bufferedReader.close();
    }
}
