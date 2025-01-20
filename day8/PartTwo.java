package day8;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class PartTwo {
   /* public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("day8/input.txt"))) {
            List<String> lines = stream.toList();
            Map<String, List<Pair>> pairs = getPairs(lines);
            Set<Pair> uniqueLocations = new HashSet<>();
            for(var pair : pairs.entrySet()){
                uniqueLocations = getAntiNodesInBoundary(pair.getValue(), lines.get(0).length(), lines.size(), uniqueLocations);
            }
            System.out.println("Part Two: "+ uniqueLocations.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<String, List<Pair>> getPairs(List<String> lines){
        Map<String, List<Pair>> op = new HashMap<>();
        int row = -1;
        for(String line : lines){
            row++;
            String[] split = line.split("");
            int col = -1;
            for(String s : split){
                col++;
                if(!s.equals(".") && !s.equals("#")){
                    op.computeIfAbsent(s, k -> new ArrayList<>());
                    op.get(s).add(new Pair(row, col));
                }
            }
        }
        return op;
    }

    private static Set<Pair> getAntiNodesInBoundary(List<Pair> pairs,
                                                    int horizontalBoundary,
                                                    int verticalBoundary,
                                                    Set<Pair> uniqueLocations){
        for(int i = 0; i < pairs.size()-1; i++){
            Pair firstPair = pairs.get(i);
            for(int j = i+1; j < pairs.size(); j++){
                Pair secondPair = pairs.get(j);
                if(isAntiNodeOnGrid(firstPair,secondPair,horizontalBoundary,verticalBoundary)){
                    uniqueLocations.add(new Pair(
                            firstPair.row + (firstPair.row - secondPair.row),
                            firstPair.col +(firstPair.col - secondPair.col))
                    );
                }else{

                }
                if(isAntiNodeOnGrid(secondPair,firstPair,horizontalBoundary,verticalBoundary)){
                    uniqueLocations.add(new Pair(
                            secondPair.row + (secondPair.row - firstPair.row),
                            secondPair.col +(secondPair.col - firstPair.col))
                    );
                }
            }
        }
        return uniqueLocations;
    }

    private static boolean isAntiNodeOnGrid(Pair firstPair, Pair secondPair,int horizontalBoundary, int verticalBoundary){

        int colDiff =  firstPair.col - secondPair.col;
        int rowDiff =  firstPair.row - secondPair.row;

        if(firstPair.col + colDiff >= horizontalBoundary || firstPair.col + colDiff < 0){
            return false;
        }

        if(firstPair.row + rowDiff >= verticalBoundary || firstPair.row + rowDiff < 0){
            return false;
        }

        return true;
    }*/
}
