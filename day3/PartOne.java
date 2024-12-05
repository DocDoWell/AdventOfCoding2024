package day3;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class PartOne {
    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("src/day3/input.txt"))) {

            String regex="mul\\(\\d+,\\d+\\)";
            Pattern pattern = Pattern.compile(regex);
            ArrayList<String> list = new ArrayList<>();

            stream.forEach(x -> {
                Matcher mat = pattern.matcher(x);
                while(mat.find()){
                    list.add(mat.group());
                }
            });

            int solution = list.stream().mapToInt(s ->
                            Integer.parseInt(s.split(",")[0].trim().replace("mul(", "")) *
                            Integer.parseInt(s.split(",")[1].trim().replace(")", ""))
                    ).sum();

            System.out.println("Part one: " + solution);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
