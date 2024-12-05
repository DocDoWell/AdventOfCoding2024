package day3;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class PartTwo {
    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("src/day3/input.txt"))) {

            String regex= "mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)";
            Pattern pattern = Pattern.compile(regex);
            ArrayList<String> list = new ArrayList<>();
            final boolean[] flag = {true};
            stream.forEach(x -> {
                Matcher mat = pattern.matcher(x);
                while(mat.find()){
                    if(mat.group().equals("do()")){
                        flag[0] = true;
                    }else if(mat.group().equals("don't()")){
                        flag[0] = false;
                    }else{
                        if(flag[0]){
                            list.add(mat.group());
                        }
                    }
                }
            });

            int solution = list.stream().mapToInt(s -> Integer.parseInt(s.split(",")[0].trim().replace("mul(", "")) *
                            Integer.parseInt(s.split(",")[1].trim().replace(")", "")))
                    .sum();

            System.out.println("Part two: " + solution);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
