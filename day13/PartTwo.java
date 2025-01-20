package day13;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class PartTwo {
    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("day13/input.txt"))) {
            List<String> lines = stream.toList();
            UltraSimultaneousEquations simultaneousEquation = new UltraSimultaneousEquations();
            double op = 0;

            for(String line: lines){
                if(line.contains("Button A")){
                    simultaneousEquation.setA(Integer.parseInt(line.split(":")[1].trim().split(",")[0].trim().replace("X+","")));
                    simultaneousEquation.setD(Integer.parseInt(line.split(":")[1].trim().split(",")[1].trim().replace("Y+","")));
                }else if(line.contains("Button B")){
                    simultaneousEquation.setB(Integer.parseInt(line.split(":")[1].trim().split(",")[0].trim().replace("X+","")));
                    simultaneousEquation.setE(Integer.parseInt(line.split(":")[1].trim().split(",")[1].trim().replace("Y+","")));
                }else if(line.contains("Prize")){
                    int c = Integer.parseInt(line.split(":")[1].trim().split(",")[0].trim().replace("X=",""));
                    int f = Integer.parseInt(line.split(":")[1].trim().split(",")[1].trim().replace("Y=",""));
                    simultaneousEquation.setC(10000000000000L + c);
                    simultaneousEquation.setF(10000000000000L + f);
                 }else{

                    double x = simultaneousEquation.getX();
                    double y = simultaneousEquation.getY(x);

                    if(x == Math.floor(x) && y == Math.floor(y)){
                        op = op + (3*x + y);
                    }


                    simultaneousEquation = new UltraSimultaneousEquations();
                }
            }

            System.out.printf("Part One: " + String.format("%.12f", op));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
