package day5;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class PartOne {

    private static List<String> orderings = new ArrayList<>();
    private static Map<String, Set<String>> rules = new HashMap<>();

    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("src/day5/input.txt"))) {
            stream.forEach(PartOne::process);
            int sol = orderings.stream()
                    .filter(PartOne::isValid)
                    .map(x -> Integer.parseInt(x.split(",")[(x.split(",").length)/2]))
                    .toList()
                    .stream()
                    .reduce(0, Integer::sum);
            System.out.println("Part one is " +sol);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isValid(String line){
        String[] split = line.split(",");
        for(int i=0; i < split.length; i++){
            String page = split[i].trim();
            //backward
            for(int k=i-1; k >=0; k--){
                if(rules.get(page) != null && rules.get(page).contains(split[k].trim())){
                    return false;
                }
            }
            //forward
            for(int j=i+1; j < split.length; j++){
                if(rules.get(split[j].trim()) != null && rules.get(split[j].trim()).contains(page)){
                    return false;
                }
            }
        }
        return true;
    }

    private static void process(String line){
        if(line.contains("|")){
            rules.computeIfAbsent(line.split("\\|")[0].trim(), k -> new HashSet<String>());
            rules.get(line.split("\\|")[0].trim()).add(line.split("\\|")[1].trim());
        }

        if(line.contains(",")){
            orderings.add(line);
        }
    }
}
