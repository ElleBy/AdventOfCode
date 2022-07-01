import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/*
Day one of 2021 advent of code
Part 1 - count the number of times a depth measurement increases
 */
public class DayOne {

    public static void main(String[] args) throws IOException {
        String filePath= "resources/dayone.txt";
        List<String> lines = Files.readAllLines(Path.of(filePath));

        // convert list of strings into list of integers
        List<Integer> list = lines.stream().map(Integer::parseInt).collect(Collectors.toList());

        int result = partOne(list);
        System.out.println("Part One: " + result);

        int result2 = partTwo(list);
        System.out.println("Part Two: " + result2);
    }

    private static int partOne(List<Integer> values) {
        int number = 0;

        for (int i = 1; i<values.size(); i++){
            if(values.get(i-1) < values.get(i)){
                number++;
            }
        }
        return number;
    }


    private static int partTwo(List<Integer> values) {
        int sum = 0;
        int countA;
        int countB;

        //-3 because we go up to i+3
        for (int i =0; i < values.size()-3; i++){
            countA = values.get(i) + values.get(i+1) + values.get(i+2);
            countB = values.get(i+1) + values.get(i+2) + values.get(i+3);

            if (countB > countA) {
                sum++;
            }

        }

        return sum;

    }

}
