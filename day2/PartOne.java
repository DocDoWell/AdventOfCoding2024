package day2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class PartOne {
    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("src/day2/input.txt"))) {
        System.out.println("Part One: "+stream.filter(PartOne::safeLevels).toList().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean safeLevels(String level){
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
}
