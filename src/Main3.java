import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main3 {

    public static void main(String[] args) {


        int intStream = IntStream.rangeClosed(0, 100).sum();
        System.out.println(intStream);

        List<Integer> listOfNumbers = Arrays.asList(1, 1, 2, 2, 2, 3, 3, 10, 10, 1, 2, 6, 7, 4, 12, 34, 345, 234, 123, 321);


        listOfNumbers = listOfNumbers.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(listOfNumbers);



    }




}
