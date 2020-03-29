import com.sun.xml.internal.bind.v2.TODO;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args){
     //   System.out.println(getMostRepeatedNumber(new int[]{1,3,1,3,2,1,3,3,2,7,8,3,1,2}));
        int[] array1A = {1, 3, 4, 6, 7, 9};
        Arrays.stream(getMatchingNumbers(array1A, 2)).forEach(ints -> {
            System.out.println("{"+ints[0]+","+ints[1]+"}");
        });
       /* int[] array1A = {1, 3, 4, 6, 7, 9};
        int[] array2A = {1, 2, 4, 5, 9, 10};
        System.out.println(getCommonNumbersList(array1A, array2A));

        int[] array1B = {1, 2, 9, 10, 11, 12};
        int[] array2B = {0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15};
        System.out.println(getCommonNumbersList(array1B, array2B));

        int[] array1C = {0, 1, 2, 3, 4, 5};
        int[] array2C = {6, 7, 8, 9, 10, 11};
        System.out.println(getCommonNumbersList(array1C, array2C));*/

       /* int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int[] array2b = {4, 5, 6, 7, 1, 2, 3};
        System.out.println(isRotation(array1, array2b));*/


      /*  System.out.println(nonRepeating("abcab")); // should return 'c'
        System.out.println(nonRepeating("abab")); // should return null
        System.out.println(nonRepeating("aabbbc")); // should return 'c'
        System.out.println(nonRepeating("aabbdbc"));*/

     /*  System.out.println(isOneAway("abcde", "abcd"));  // should return true
        System.out.println(isOneAway("abde", "abcde"));  // should return true
        System.out.println(isOneAway("a", "a"));  // should return true
        System.out.println(isOneAway("abcdef", "abqdef"));  // should return true
        System.out.println(isOneAway("abcdef", "abccef"));  // should return true
        System.out.println(isOneAway("abcdef", "abcde"));  // should return true
        System.out.println(isOneAway("aaa", "abc"));  // should return false
        System.out.println(isOneAway("abcde", "abc"));  // should return false
        System.out.println(isOneAway("abc", "abcde"));  // should return false
        System.out.println(isOneAway("abc", "bcc"));*/


      /*  int[][] bombs3 = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
         mineSweeper(bombs3, 5, 5);*/

        // [[1, 2, 2, 1, 0],
        //  [1, -1, -1, 2, 0],
        //  [1, 3, -1, 2, 0],
        //  [0, 1, 2, 2, 1],
        //  [0, 0, 1, -1, 1]]
/*
        int[] a = {1,2,3,4,5, 25};
        int[] b = {8,1,3,9,4,3,8, 9, 3, 13, 20, 40, 25};

        System.out.println(getRepeatedNumbersFromSecondArray(a,b));
        System.out.println(getRepeatedNumbersWithoutMap(a,b));*/

       // printFibonacciNonRecursion(20);
      //  printPascalTriangle(10);
        //String palindrom1="hanan";
        //System.out.println(canMakePalindrom(palindrom1.toCharArray()));

        int[][] field2 = {{-1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, -1}};

      /*  int [][] result=click(field2, 4, 4, 1, 3);
        for(int [] row:result){
           System.out.println(Arrays.toString(row));
        }

        int[][] field1 = {{0, 0, 0, 0, 0},
                         {0, 1, 1, 1, 0},
                         {0, 1, -1, 1, 0}};

        result=click(field1, 3, 5, 1, 4);
        // [[-2, -2, -2, -2, -2],
        //  [-2, 1, 1, 1, -2],
        //  [-2, 1, -1, 1, -2]]
        for(int [] row:result){
            System.out.println(Arrays.toString(row));
        }

        // click(field2, 4, 4, 1, 3) should return:
        // [[-1, 1, -2, -2],
        //  [1, 1, -2, -2],
        //  [-2, -2, 1, 1],
        //  [-2, -2, 1, -1]]
        // [[-1, 1, 0, 0],
        //  [1, 1, 0, 0],
        //  [0, 0, 1, 1],
        //  [0, 0, 1, -1]]*/

    }

    static int [][] getMatchingNumbers(int [] arr, int targetNumber){
        List<int[]> result=new ArrayList<>();

        List<Integer> arrList=Arrays.stream(arr).boxed().collect(Collectors.toList());

        for(int number:arr){
            if(arrList.contains(number+targetNumber)){
                result.add(new int []{targetNumber, number});
            }
        }

        int[][] resultArr= new int[result.size()][];
        resultArr=result.toArray(resultArr);
        return resultArr;
    }


    static int [][] updateField(int [][] field, int numRows, int numCols){
       int stop=0;
        for(int i=0; i<numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if(field[i][j]==-2) {
                    if (i == 0 && j == 0) {
                        if (field[0][1] == 0) {
                            field[0][1]=-2;
                        }
                        if (field[1][0] == 0) {
                            field[1][0]=-2;
                        }
                        if (field[1][1] == 0) {
                            field[1][1]=-2;
                        }
                    }
                    else if (i == 0 && j == numCols - 1) {
                        if(field[0][numCols-2]==0){
                            field[0][numCols-2]=-2;
                        }
                        if(field[1][numCols-2]==0){
                            field[1][numCols-2]=-2;
                        }

                        if(field[1][numCols-1]==0){
                            field[1][numCols-1]=-2;
                        }
                    }
                    else if (i == numRows - 1 && j == numCols - 1) {
                        if(field[numRows-1][numCols-2]==0){
                            field[numRows-1][numCols-2]=-2;
                        }
                        if(field[numRows-2][numCols-1]==0){
                            field[numRows-2][numCols-1]=-2;
                        }
                        if(field[numRows-2][numCols-2]==0){
                            field[numRows-2][numCols-2]=-2;
                        }
                    }


                    else if (i == numRows - 1 && j == 0) {
                        if (field[numRows - 2][0] == 0) {
                            field[numRows-2][0]=-2;
                        }
                        if (field[numRows - 2][1] == 0) {
                            field[numRows-2][1]=-2;
                        }
                        if (field[numRows - 1][1] == 0) {
                            field[numRows-1][1]=-2;
                        }
                    }

                    else if(i==0){
                        if(field[i+1][j-1]==0){
                            field[i+1][j-1]=-2;
                        }
                        if(field[i+1][j]==0){
                            field[i+1][j]=-2;
                        }
                        if(field[i+1][j+1]==0){
                            field[i+1][j+1]=-2;
                        }
                        if(field[i][j+1]==0){
                            field[i][j+1]=-2;
                        }
                        if(field[i][j-1]==0){
                            field[i][j-1]=-2;
                        }
                    }

                    else if(i==numRows-1){
                        if(field[i-1][j+1]==0){
                            field[i-1][j+1]=-2;
                        }
                        if(field[i-1][j]==0){
                            field[i-1][j]=-2;
                        }
                        if(field[i-1][j-1]==0){
                            field[i-1][j-1]=-2;
                        }
                        if(field[i][j-1]==0){
                            field[i][j-1]=-2;
                        }
                        if(field[i][j+1]==0){
                            field[i][j+1]=-2;
                        }
                    }


                    else if(j==0){
                        if(field[i-1][j]==0){
                            field[i-1][j]=-2;
                        }
                        if(field[i-1][j+1]==0){
                            field[i-1][j+1]=-2;
                        }
                        if(field[i+1][j]==0){
                            field[i+1][j]=-2;
                        }
                        if(field[i+1][j+1]==0){
                            field[i+1][j+1]=-2;
                        }
                        if(field[i][j+1]==0){
                            field[i][j+1]=-2;
                        }
                    }
                    else if (j == numCols - 1) {
                        if (field[i - 1][j] == 0) {
                            field[i - 1][j] = -2;
                        }
                        if (field[i - 1][j - 1] == 0) {
                            field[i - 1][j - 1] = -2;
                        }
                        if (field[i + 1][j] == 0) {
                            field[i + 1][j] = -2;
                        }
                        if (field[i + 1][j - 1] == 0) {
                            field[i + 1][j - 1] = -2;
                        }
                        if (field[i][j - 1] == 0) {
                            field[i][j - 1] = -2;
                        }
                    }
                    else{
                        if(field[i-1][j-1]==0){
                            field[i-1][j-1]=-2;
                        }
                        if(field[i-1][j]==0){
                            field[i-1][j]=-2;
                        }
                        if(field[i-1][j+1]==0){
                            field[i-1][j+1]=-2;
                        }
                        if(field[i+1][j-1]==0){
                            field[i+1][j-1]=-2;
                        }
                        if(field[i+1][j]==0){
                            field[i+1][j]=-2;
                        }
                        if(field[i+1][j+1]==0){
                            field[i+1][j+1]=-2;
                        }
                        if(field[i][j+1]==0){
                            field[i][j+1]=-2;
                        }
                        if(field[i][j-1]==0){
                            field[i][j-1]=-2;
                        }
                    }
                }

                else if(field[i][j]==0){
                    stop++;
                }
            }
        }

        if(stop>0) {
            return updateField(field, numRows, numCols);
        }
        else{
            return field;
        }
    }

    static int[][] click(int[][] field, int numRows, int numCols, int givenI, int givenJ) {

        int[][] updatedField;
        if(field[givenI][givenJ]!=0){
            return field;
        }
        else{

            field[givenI][givenJ]=-2;

          updatedField=updateField(field, numRows, numCols);

        }

        return updateField(updatedField, numRows, numCols);
    }

    static boolean isAnagram(String word1, String word2){
        return false;
    }

    static boolean canMakePalindrom(char[] arr){
        Map<Character, Integer> countsMap= new HashMap<>();
        for(Character letter:arr){
            if(countsMap.containsKey(letter)){
                countsMap.put(letter, countsMap.get(letter)+1);
            }
            else{
                countsMap.put(letter, 1);
            }
        }

        boolean result=true;
        if(arr.length%2==0){
            //par

            for(Map.Entry<Character, Integer> entrySet:countsMap.entrySet()){
                if(entrySet.getValue()%2!=0){
                    result=false;
                }
            }
        }

        else{
            //odd
            int oddLimit=0;
            for(Map.Entry<Character, Integer> entrySet:countsMap.entrySet()){
                if(entrySet.getValue()%2!=0){
                    oddLimit++;
                }
            }
            if(oddLimit>1){
                result=false;
            }
        }


        return result;

    }

    static void printPascalTriangle(int numberOfRows){
        int[] previousRow=new int[0];
        for(int row=1; row<=numberOfRows; row++){
            int[] rowArray= new int[row];
            if(row==1){
                rowArray[0]=1;
            }

            else{
                rowArray[0]=1;
                rowArray[rowArray.length-1]=1;
                if(row>2){
                    for(int j=1; j<=rowArray.length-2; j++){
                        rowArray[j]=previousRow[j]+previousRow[j-1];
                    }
                }
            }

            previousRow=rowArray;
           // System.out.println(Arrays.toString(rowArray));
            prettyPrintPascalTriangleRow(rowArray, numberOfRows, row);
        }
    }

    static void prettyPrintPascalTriangleRow(int [] triangleRow, int triangleNumRows, int currentRow){
        int spaces=triangleNumRows-triangleRow.length;
        String[] prettyPrinted=new String[spaces];
        for(int i=0; i<=spaces-1; i++){
            if((triangleRow.length%2)==0){

            }

            else{

            }

        }

        System.out.println(Arrays.toString(prettyPrinted));

    }

    static void printFibonacciNonRecursion(int numberOfElements){
        int [] fiboArray= new int[numberOfElements-1];
        for(int i=0; i<numberOfElements-1; i++){
                if(i==0){
                    fiboArray[0]=1;
                }
                else if(i==1){
                    fiboArray[1]=1;
                }
                else{
                    fiboArray[i]=(fiboArray[i-2]+fiboArray[i-1]);
                }

        }

        System.out.println(Arrays.toString(fiboArray));
    }

    static Set<Integer> getRepeatedNumbersWithoutMap(int[] arr1, int[] arr2){

        Integer[]  sortedArray1 = Arrays.stream(arr1).boxed().distinct().sorted().toArray(Integer[]::new);
        Integer[]  sortedArray2= Arrays.stream(arr2).boxed().distinct().sorted().toArray(Integer[]::new);

        int sortedArray1Pointer=0;
        int sortedArray2Pointer=0;

        Set<Integer> repeatedNumbers=new HashSet<>();

        for(int i=0; i<=sortedArray2.length; i++){
            if(sortedArray1[sortedArray1Pointer]==sortedArray2[sortedArray2Pointer]){
                repeatedNumbers.add(sortedArray1[sortedArray1Pointer]);
                sortedArray2Pointer++;
                sortedArray1Pointer++;
            }
            else{
                if(sortedArray1[sortedArray1Pointer]>sortedArray2[sortedArray2Pointer]){
                    sortedArray2Pointer++;
                }
                else{
                    sortedArray1Pointer++;
                }
            }
        }

        return repeatedNumbers;
    }


    static Set<Integer> getRepeatedNumbersFromSecondArray(int[] arr1, int[] arr2){
        Map<Integer, Integer> countsMap= new HashMap<>();
        Set<Integer> repeatedNumbers= new HashSet<>();
        for(Integer number: arr1){
            countsMap.put(number, 0);
        }

        for(Integer number:arr2){
            if(countsMap.containsKey(number)){
                countsMap.replace(number, countsMap.get(number)+1);
            }
        }

        for(Map.Entry<Integer, Integer> entrySet:countsMap.entrySet()){
            if(entrySet.getValue()>0){
                repeatedNumbers.add(entrySet.getKey());
            }
        }

        return repeatedNumbers;
    }

    static int getMostRepeatedNumber(int[] arr){
        Map<Integer, Integer> numbersMap= new HashMap<>();
        for(int number : arr){
            if(numbersMap.containsKey(number)){
                numbersMap.replace(number, numbersMap.get(number)+1);
            }
            else{
                numbersMap.put(number, 1);
            }
        }

        int max=numbersMap.entrySet().stream().max((o1, o2) -> o1.getValue()>o2.getValue() ? 1 : -1).get().getKey();

        return max;
    }

    static Set<Integer> getCommonNumbersList(int[] arr1, int[] arr2){

        Set<Integer> arr1Set= Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        Set<Integer> result=new HashSet<>();

        for(int number:arr2){
            if(arr1Set.contains(number)){
                result.add(number);
            }
        }

        return result;

    }

    static Boolean isRotation(int[] array1, int[] array2) {

        boolean result=true;
        if(array1.length!=array2.length){
            return false;
        }
        int pivotIndex=Integer.MIN_VALUE;
        for(int i=0; i<=array2.length-1; i++){
            if(array2[i]==array1[0]){
                pivotIndex=i;
                break;
            }
        }

        if(pivotIndex==Integer.MIN_VALUE){
            return false;
        }

        System.out.println(pivotIndex);

        List<Integer> finalResult= new ArrayList<>();

        for(int i=pivotIndex; i<=array2.length-1; i++){
            finalResult.add(array2[i]);
        }


        for(int i=0; i<pivotIndex; i++){
            finalResult.add(array2[i]);
        }

        System.out.println(finalResult);
        System.out.println(Arrays.stream(array1).boxed().collect(Collectors.toList()));

        for(int i=0; i<finalResult.size(); i++){
            if(array1[i]!=finalResult.get(i)){
                result=false;
            }
        }

        return result;
    }

    public static Character nonRepeating(String s) {
       Map<String, Integer> countMap= new LinkedHashMap<>();

        for(int i=0; i<=s.length()-1; i++){
            if(countMap.containsKey(String.valueOf(s.charAt(i)))){
                countMap.replace(String.valueOf(s.charAt(i)), countMap.get(String.valueOf(s.charAt(i)))+1);
            }
            else{
                countMap.put(String.valueOf(s.charAt(i)), 0);
            }
        }

        for(Map.Entry<String, Integer> entry: countMap.entrySet()){
            if(entry.getValue()==0){
                return (entry.getKey().charAt(0));
            }
        }

        return null;
    }

    public static Boolean isOneAway(String s1, String s2) {
        if(s1.equalsIgnoreCase(s2)){
            return true;
        }
        List<String> array1=new ArrayList<>();
        List<String> array2= new ArrayList<>();
        char[] string1=s1.toCharArray();
        char[] string2=s2.toCharArray();

        for(char letter:string1){
            array1.add(String.valueOf(letter));
        }

        for(char letter:string2){
            array2.add(String.valueOf(letter));
        }


        int stringCharsDiff;

        if(array1.size()>array2.size()){

            stringCharsDiff=array1.size()-array2.size();
            if(stringCharsDiff>=2){
                return false;
            }

            List<String> result=new ArrayList<>();
            for(String letter:array2){
                if(array1.contains(letter)){
                    result.add(letter);
                }
            }
            if(result.equals(array2)){
                return true;
            }
        }
        else if(array1.size()<array2.size()){
            stringCharsDiff=array2.size()-array1.size();
            if(stringCharsDiff>=2){
                return false;
            }
            List<String> result=new ArrayList<>();
            for(String letter:array1){
                if(array2.contains(letter)){
                    result.add(letter);
                }
            }
            if(result.equals(array1)){
                return true;
            }
        }

        if(array1.size()==array2.size()){
            int count=0;
           for(int i=0; i<array1.size(); i++){
               if(!(array1.get(i).equalsIgnoreCase(array2.get(i)))){
                    count++;
               }

               if(count>=2){
                   return false;
               }
           }
           return true;
        }


        return false;
    }

    public static int[][] mineSweeper(int[][] bombs, int numRows, int numCols) {
        int[][] field = new int[numRows][numCols];

        for(int [] bomb: bombs){
            field[bomb[0]][bomb[1]]= -1;
        }

        for(int i=0; i<numRows; i++){
            for(int j=0; j<numCols; j++){
                if(field[i][j]!=-1){
                    if (i == 0 && j == 0) {
                        if (field[0][1] == -1) {
                            field[i][j]++;
                        }
                        if (field[1][0] == -1) {
                            field[i][j]++;
                        }
                        if (field[1][1] == -1) {
                            field[i][j]++;
                        }
                    }

                    else if (i == 0 && j == numCols - 1) {
                        if(field[0][numCols-2]==-1){
                            field[i][j]++;
                        }
                        if(field[1][numCols-2]==-1){
                            field[i][j]++;
                        }

                        if(field[1][numCols-1]==-1){
                            field[i][j]++;
                        }
                    }

                    else if (i == numRows - 1 && j == numCols - 1) {
                        if(field[numRows-1][numCols-2]==-1){
                            field[i][j]++;
                        }
                        if(field[numRows-2][numCols-1]==-1){
                            field[i][j]++;
                        }
                        if(field[numRows-2][numCols-2]==-1){
                            field[i][j]++;
                        }
                    }


                    else if (i == numRows - 1 && j == 0) {
                        if (field[numRows - 2][0] == -1) {
                            field[i][j]++;
                        }
                        if (field[numRows - 2][1] == -1) {
                            field[i][j]++;
                        }
                        if (field[numRows - 1][1] == -1) {
                            field[i][j]++;
                        }
                    }

                    else if(i==0){
                        if(field[i+1][j-1]==-1){
                            field[i][j]++;
                        }
                        if(field[i+1][j]==-1){
                            field[i][j]++;
                        }
                        if(field[i+1][j+1]==-1){
                            field[i][j]++;
                        }
                        if(field[i][j+1]==-1){
                            field[i][j]++;
                        }
                        if(field[i][j-1]==-1){
                            field[i][j]++;
                        }
                    }

                    else if(i==numRows-1){
                        if(field[i-1][j+1]==-1){
                            field[i][j]++;
                        }
                        if(field[i-1][j]==-1){
                            field[i][j]++;
                        }
                        if(field[i-1][j-1]==-1){
                            field[i][j]++;
                        }
                        if(field[i][j-1]==-1){
                            field[i][j]++;
                        }
                        if(field[i][j+1]==-1){
                            field[i][j]++;
                        }
                    }


                    else if(j==0){
                        if(field[i-1][j]==-1){
                            field[i][j]++;
                        }
                        if(field[i-1][j+1]==-1){
                            field[i][j]++;
                        }
                        if(field[i+1][j]==-1){
                            field[i][j]++;
                        }
                        if(field[i+1][j+1]==-1){
                            field[i][j]++;
                        }
                        if(field[i][j+1]==-1){
                            field[i][j]++;
                        }
                    }

                    else if(j==numCols-1){
                        if(field[i-1][j]==-1){
                            field[i][j]++;
                        }
                        if(field[i-1][j-1]==-1){
                            field[i][j]++;
                        }
                        if(field[i+1][j]==-1){
                            field[i][j]++;
                        }
                        if(field[i+1][j-1]==-1){
                            field[i][j]++;
                        }
                        if(field[i][j-1]==-1){
                            field[i][j]++;
                        }
                    }

                    else{
                        if(field[i-1][j-1]==-1){
                            field[i][j]++;
                        }
                        if(field[i-1][j]==-1){
                            field[i][j]++;
                        }
                        if(field[i-1][j+1]==-1){
                            field[i][j]++;
                        }
                        if(field[i+1][j-1]==-1){
                            field[i][j]++;
                        }
                        if(field[i+1][j]==-1){
                            field[i][j]++;
                        }
                        if(field[i+1][j+1]==-1){
                            field[i][j]++;
                        }
                        if(field[i][j+1]==-1){
                            field[i][j]++;
                        }
                        if(field[i][j-1]==-1){
                            field[i][j]++;
                        }
                    }

                }
            }
        }

        for(int[] row: field){

            System.out.println(Arrays.toString(row));

        }

        return field;
    }



}
