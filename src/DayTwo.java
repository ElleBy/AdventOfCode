import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/*
Day two of 2021 advent of code
Part 1 - work out where a submarine is, multiple distance and horizontal together
Part 2 - change calculations to incorporate 'aim'
 */
public class DayTwo {
    public static void main(String[] args) throws IOException {
        String filePath= "resources/daytwo.txt";
        List<String> lines = Files.readAllLines(Path.of(filePath));

        int partOneResult = position(lines);
        System.out.println(partOneResult);

        int partTwoResult = aim(lines);
        System.out.println(partTwoResult);
    }

    private static int position(List<String> lines){
        int horizontalPosition = 0;
        int depth = 0;
        // get each line and split between dir and value
        for (String line : lines){
            String [] split = line.split(" ");
            int value = Integer.parseInt(split[1]);
            switch (split[0]){
                case "forward":
                    horizontalPosition += value;
                    break;
                case "up":
                    depth -= value;
                    break;
                case "down":
                    depth += value;
                    break;
            }
        }

        return depth*horizontalPosition;
    }

    private static int aim(List<String> lines){
        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;

        // get each line and split between dir and value
        for (String line : lines){
            String [] split = line.split(" ");
            int value = Integer.parseInt(split[1]);

            switch (split[0]){
                case "forward":
                    horizontalPosition += value;
                    depth += aim*value;
                    break;
                case "up":
                    aim -= value;
                    break;
                case "down":
                    aim += value;
                    break;
            }
        }

        return depth*horizontalPosition;
    }
}

