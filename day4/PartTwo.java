package day4;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class PartTwo {
    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("src/day4/input.txt"))) {
            List<String> lists = stream.toList();
            String[][] opArr =  convertToArray(lists);
            System.out.println("Part Two: " + algorithm(opArr));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int algorithm(String[][] opArr){
        int output = 0;
        for(int row=1; row < opArr.length-1; row++){
            for(int col=1; col< opArr[row].length-1; col++) {
                if(opArr[row][col].equals("A")){
                    String topLeft = opArr[row-1][col-1];
                    String bottomLeft = opArr[row+1][col-1];

                    String topRight = opArr[row-1][col+1];
                    String bottomRight = opArr[row+1][col+1];

                    boolean makesUpAnX = (topRight.equals("M") && bottomLeft.equals("S")) || (topRight.equals("S") && bottomLeft.equals("M"));

                    if(topLeft.equals("M") && bottomRight.equals("S")) {
                        if(makesUpAnX){
                            output++;
                        }
                    }else if(topLeft.equals("S") && bottomRight.equals("M")) {
                        if(makesUpAnX){
                            output++;
                        }
                    }
                }
            }
        }
        return output;
    }

    private static String[][] convertToArray(List<String> lists){
        String[][] op = new String[lists.size()][lists.get(0).length()];
        for(int i=0; i < lists.size(); i++){
            for(int j=0; j< lists.get(i).length(); j++){
                op[i][j] = String.valueOf(lists.get(i).charAt(j));
            }
        }
        return op;
    }
}


