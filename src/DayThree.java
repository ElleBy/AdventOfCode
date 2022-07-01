import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/*

 */
public class DayThree {

    public static void main(String[] args) throws IOException {
        String filePath= "resources/daythree.txt";
        List<String> lines = Files.readAllLines(Path.of(filePath));

        int partOneResult = powerConsumption(lines);
        System.out.println(partOneResult);

        int partTwoResult = lifeSupportRating(lines);
        System.out.println(partTwoResult);
    }

    private static int powerConsumption(List<String> lines){
        String gamma = "";
        String epsilon = "";

        for (int i =0; i<12; i++) {
            String temp = "";
            for (String line : lines) {
                temp += line.charAt(i);
            }

            char[] strArr = temp.toCharArray();
            int zero =0;
            int one = 0;

            for (int j=1; j <strArr.length; j++){
                switch (strArr[j]){
                    case '0':
                        zero+=1;
                        break;
                    case '1':
                        one+=1;
                        break;
                }
            }

            if(zero>one){
                gamma += "0";
                epsilon += "1";
            } else{
                gamma += "1";
                epsilon += "0";
            }
        }
        int gammaDecimal = Integer.parseInt(gamma,2);
        int epsilonDecimal = Integer.parseInt(epsilon,2);

        return gammaDecimal*epsilonDecimal;
    }

    private static int lifeSupportRating(List<String> lines){
        return 0;
    }
}
