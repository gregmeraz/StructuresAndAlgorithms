import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {
      //  System.out.println(birthdayCakeCandles(new int[]{82,49,82,82,41,82,15,63,38,25}));
        //System.out.println(convertToHttps("https://lochost:8080/lawyere-law"));
       // System.out.println(binarySearch(Arrays.asList(82,49,2,82,82,41,82,15,63,38,25,35, 87), 2));
        System.out.println(timeConversion("03:05:45PM"));
    }

    public static int binarySearch(List<Integer> array, int numberToSearch){
        Collections.sort(array);

        if((array.size()==1)){
            if(numberToSearch==array.get(0)){
                return 1;
            }
            else {
                return 0;
            }
        }
        else {
            int arrayLastIndex = array.size() - 1;
            int arrayMiddleIndex = ((array.size() -1) / 2) ;

            if (numberToSearch == (array.get(arrayMiddleIndex))) {
                return 1;
            } else if (numberToSearch < (array.get(arrayMiddleIndex))) {
                List<Integer> leftSide = array.subList(0, arrayMiddleIndex);
                return binarySearch(leftSide, numberToSearch);
            } else if (numberToSearch > (array.get(arrayMiddleIndex))) {
                List<Integer> rightSide;
                if(array.size()<=2){
                     rightSide = array.subList(arrayLastIndex, arrayLastIndex+1);
                }
               else{
                   rightSide = array.subList(arrayMiddleIndex, array.size());
                }

                return binarySearch(rightSide, numberToSearch);
            }

            return -1;
        }
    }

    public static void printNumbers(int startingNumber) {
        System.out.println(startingNumber);
        if (startingNumber > 0) {
            printNumbers(startingNumber - 1);
        }
    }

    public static int getFactorial(int numberToBeEvaluated) {
        if (numberToBeEvaluated == 0) {
            return 1;
        }

        return (numberToBeEvaluated * getFactorial(numberToBeEvaluated - 1));

    }

    public static int printFibonacci(int fiboNumber) {
        if (fiboNumber < 1) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (fiboNumber == 1 || fiboNumber == 2) {
            return fiboNumber - 1;
        }
        return (printFibonacci(fiboNumber - 1) + printFibonacci(fiboNumber - 2));
    }

    public static int getBiggestNumber(int[] numbers) {
        int biggestNumber = numbers[0];
        for (int number : numbers) {
            if (number > biggestNumber) {
                biggestNumber = number;
            }
        }
        return biggestNumber;
    }

    public static void printFibonacciWithoutRecursion() {
        System.out.println("0");
        int x = 1;
        System.out.println(x);
        System.out.println(x);
        int previous = 1;
        int newNum;
        while (x <= 10000000) {
            newNum = x + previous;
            System.out.println(newNum);
            previous = x;
            x = newNum;
        }
    }

    public static int getFactorialWithoutRecursion(int number) {

        int currentSum = 1;
        for (int i = 1; i < number; i++) {
            currentSum = currentSum * (i + 1);
        }
        return currentSum;

    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int matrixSize = arr.get(0).size();
        List<Integer> rightDiagonal = new ArrayList<>();
        List<Integer> leftDiagonal = new ArrayList<>();
        for (int i = 0; i <= matrixSize - 1; i++) {
            rightDiagonal.add(arr.get(i).get(i));
            leftDiagonal.add(arr.get(i).get(matrixSize - 1 - i));
        }

        Integer rightSum = rightDiagonal.stream().mapToInt(value -> value.intValue()).sum();
        Integer leftSum = leftDiagonal.stream().mapToInt(value -> value.intValue()).sum();
        int result = rightSum - leftSum;
        return Math.abs(result);
    }

    static void plusMinus(int[] arr) {
        Map<String, Float> numbers = new LinkedHashMap<>();
        numbers.put("positives", new Float(0));
        numbers.put("negatives", new Float(0));
        numbers.put("zeros", new Float(0));
        for (int number : arr) {
            if (number == 0) {
                numbers.replace("zeros", numbers.get("zeros") + 1);
            } else if (number + (Math.abs(number)) == 0) {
                numbers.replace("negatives", numbers.get("negatives") + 1);
            } else {
                numbers.replace("positives", numbers.get("positives") + 1);
            }
        }

        numbers.entrySet().stream().forEach(stringIntegerEntry -> {
            System.out.println(stringIntegerEntry.getValue() / new Float(arr.length));
        });


    }

    static void staircase(int n) {
        StringBuilder string = new StringBuilder();
        int y = 0;
        while (y < n) {
            for (int x = n - y; x >= 0; x--) {
                string.append(" ");
            }
            for (int z = y; z >= 0; z--) {
                string.append("#");
            }

            y++;
            string.append("\n");
        }
        System.out.println(string.toString());
    }

    static void miniMaxSum(int[] arr) {
        List<Long> orderedList = new ArrayList<>();
        for (long number : arr) {
            orderedList.add(number);
        }
        Collections.sort(orderedList);
        long totalSum = orderedList.stream().reduce(new Long(0), (integer, integer2) -> integer + integer2);
        long minSum = totalSum - orderedList.get(orderedList.size() - 1);
        long maxSum = totalSum - orderedList.get(0);
        System.out.println(minSum + " " + maxSum);
    }

    static int birthdayCakeCandles(int[] ar) {
        List<Integer> numbers = Arrays.stream(ar).boxed().collect(Collectors.toList());
        int biggestNumber = Arrays.stream(ar).max().getAsInt();
        System.out.println("biggest number of array:" + biggestNumber);
        numbers = numbers.stream().filter(integer -> integer == biggestNumber).collect(Collectors.toList());
        return numbers.size();
    }

    public static String convertToHttps(String url){
        return url.replace("http://", "https://");
    }

    static String timeConversion(String time) {

        if(time.length()==10){
            if(time.endsWith("AM")){
                if(time.substring(0,2).equalsIgnoreCase("12")){
                    return ("00"+time.substring(2, time.length()-2)).trim();
                }
                return (time.substring(0, time.length()-2)).trim();
            }
            else if(time.endsWith("PM")){
                if(time.substring(0,2).equalsIgnoreCase("12")){
                    return (time.substring(0, time.length()-2)).trim();
                }
                int hour= Integer.valueOf(time.substring(0, 2))+12;
                if(hour<24 && hour >12)
                    return (String.valueOf(hour)+time.substring(2, time.length()-2)).trim();
            }
            else{
                return "invalid date format";
            }
        }

        return "invalid date format";
    }

}




