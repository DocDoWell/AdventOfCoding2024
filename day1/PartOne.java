package day1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PartOne {
    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("src/day1/input.txt"))) {
            List<Integer> first = new ArrayList<>();
            List<Integer> second = new ArrayList<>();

            stream.forEach(x -> {
                first.add(Integer.parseInt(x.split(" {3}")[0]));
                second.add(Integer.parseInt(x.split(" {3}")[1]));
            });


            Collections.sort(first);
            Collections.sort(second);

            int solution = IntStream.range(0, first.size())
                    .map(i -> Math.abs(first.get(i) - second.get(i)))
                    .sum();

            System.out.println("part one is " + solution);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
