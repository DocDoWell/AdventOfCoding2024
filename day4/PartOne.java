package day4;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class PartOne {
    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("src/day4/input.txt"))) {
            List<String> lists = stream.toList();
            String[][] opArr =  convertToArray(lists);
            System.out.println("Part One: " + algorithm(opArr));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     private static int algorithm(String[][] opArr){
        int output = 0;
         for(int row=0; row < opArr.length; row++){
             for(int col=0; col< opArr[row].length; col++) {
                if(opArr[row][col].equals("X")){
                    //horiztonal
                    if(col - 3 >= 0){
                        if(opArr[row][col-1].equals("M") && opArr[row][col-2].equals("A") && opArr[row][col-3].equals("S")){
                            output++;
                        }
                    }
                    if(col + 3 < opArr[row].length){
                        if(opArr[row][col+1].equals("M") && opArr[row][col+2].equals("A") && opArr[row][col+3].equals("S")){
                            output++;
                        }
                    }

                    //vertical
                    if(row - 3 >= 0){
                        if(opArr[row-1][col].equals("M") && opArr[row-2][col].equals("A") && opArr[row-3][col].equals("S")){
                            output++;
                        }
                    }
                    if(row + 3 < opArr.length){
                        if(opArr[row+1][col].equals("M") && opArr[row+2][col].equals("A") && opArr[row+3][col].equals("S")){
                            output++;
                        }
                    }

                    //west diagonal
                    if(col - 3 >= 0 && row -3 >= 0) {
                        if(opArr[row-1][col-1].equals("M") && opArr[row-2][col-2].equals("A") && opArr[row-3][col-3].equals("S")){
                            output++;
                        }
                    }
                    if(col - 3 >= 0 && row + 3 < opArr.length) {
                        if(opArr[row+1][col-1].equals("M") && opArr[row+2][col-2].equals("A") && opArr[row+3][col-3].equals("S")){
                            output++;
                        }
                    }

                    //east diagonal
                    if(col + 3 < opArr[row].length && row + 3 < opArr.length) {
                        if(opArr[row+1][col+1].equals("M") && opArr[row+2][col+2].equals("A") && opArr[row+3][col+3].equals("S")){
                            output++;
                        }
                    }
                    if(col + 3 < opArr[row].length && row -3 >= 0) {
                        if(opArr[row-1][col+1].equals("M") && opArr[row-2][col+2].equals("A") && opArr[row-3][col+3].equals("S")){
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
