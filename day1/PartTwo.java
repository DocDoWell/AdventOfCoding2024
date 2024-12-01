package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PartTwo {
    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("src/day1/input.txt"))) {
            List<Integer> first = new ArrayList<>();
            Map<Integer, Integer> second = new HashMap<>();

            stream.forEach(x -> {
                first.add(Integer.parseInt(x.split(" {3}")[0]));
                second.merge(Integer.parseInt(x.split(" {3}")[1]), 1, Integer::sum);
            });

            int solution = first.stream()
                    .filter(x -> second.get(x) != null)
                    .map(i -> i*second.get(i))
                    .toList().stream()
                    .reduce(0, Integer::sum);

            System.out.println("part two is " + solution);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


