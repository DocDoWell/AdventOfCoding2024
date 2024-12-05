package day2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PartTwo {

    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("src/day2/input.txt"))) {
            System.out.println("Part Two: "+stream.filter(PartTwo::safe).toList().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean safe(String level){
        return safeLevel(level) || oneUnsafeLevel(level);
    }

    private static boolean safeLevel(String level){
        String[] split = level.split(" ");
        for(int i=1; i < split.length-1; i++){
            if(Integer.parseInt(split[i]) >= Integer.parseInt(split[i-1]) && Integer.parseInt(split[i]) >= Integer.parseInt(split[i+1])){
                return false;
            }
            if(Integer.parseInt(split[i]) <= Integer.parseInt(split[i-1]) && Integer.parseInt(split[i]) <= Integer.parseInt(split[i+1])){
                return false;
            }
        }

        for(int i=0; i < split.length-1; i++){
            int diff = Math.abs(Integer.parseInt(split[i]) - Integer.parseInt(split[i+1]));
            if(diff < 1 || diff > 3){
                return false;
            }
        }
        return true;
    }


    private static boolean oneUnsafeLevel(String level){
        List<String> strs = getStrings(level);
        for(String x : strs){
            if(safeLevel(x)){
                return true;
            }
        }
        return false;
    }

    private static List<String> getStrings(String level){
        String[] split = level.split(" ");
        int index = 0;
        StringBuilder s = new StringBuilder();
        List<String> strs = new ArrayList<>();
        while(index <= level.length()-1){
            for(int i =0; i < split.length; i++){
                if(index != i){
                    s.append(split[i]).append(" ");
                }
            }
            strs.add(s.toString().trim());
            index++;
            s = new StringBuilder();
        }
        return strs;
    }
}
