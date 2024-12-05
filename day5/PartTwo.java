package day5;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class PartTwo {
    private static List<String> orderings = new ArrayList<>();
    private static Map<String, Set<String>> rules = new HashMap<>();

    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("src/day5/input.txt"))) {
            stream.forEach(PartTwo::process);
            System.out.println("Part Two is " +orderings.stream()
                    .filter(y -> !isValid(y)).map(PartTwo::swapUntilValid)
                    .map(x -> Integer.parseInt(x.split(",")[(x.split(",").length)/2].trim()))
                    .toList()
                    .stream()
                    .reduce(0, Integer::sum)
            );
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

    private static String swapUntilValid(String line){
        while(!isValid(line)){
            String[] split = line.split(",");
            for(int i=0; i < split.length; i++){
                String page = split[i].trim();
                //backward
                for(int k=i-1; k >=0; k--){
                    if(rules.get(page) != null && rules.get(page).contains(split[k].trim())){
                        split = swap(split, i, k);
                    }
                }
                //forward
                for(int j=i+1; j < split.length; j++){
                    if(rules.get(split[j].trim()) != null && rules.get(split[j].trim()).contains(page)){
                        split = swap(split, i, j);
                    }
                }
            }

            line = arrayToString(split);
        }
        return line;
    }

    private static String[] swap(String[] input, int first, int second){
        String[] op = input;
        String temp = input[first].trim();
        op[first] = input[second].trim();
        op[second] = temp;
        return op;
    }

    private static String arrayToString(String[] arr){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i <arr.length; i++){
            sb.append(arr[i].trim()).append(",");
        }
        return sb.toString().substring(0, sb.toString().length()-1);
    }

    private static void process(String line){
        if(line.contains("|")){
            rules.computeIfAbsent(line.split("\\|")[0].trim(), k -> new HashSet<String>());
            rules.get(line.split("\\|")[0].trim()).add(line.split("\\|")[1].trim());
        }
        if(line.contains(",")){orderings.add(line);}
    }
}
