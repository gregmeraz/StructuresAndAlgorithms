import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static int[] solution(int area){
        if(area==1){
            return new int[]{1};
        }
        else if(area==0){
            return new int[]{};
        }

       List<Integer> resultsList= getResults(area, new ArrayList<>());
        int[] resultsArray= new int[resultsList.size()];
        for(int i=0; i<resultsList.size(); i++){
            resultsArray[i]=resultsList.get(i);
        }
        return resultsArray;
    }

    private static List<Integer> getResults(int area, List<Integer> resultsList){
        if(area>1){
            BigDecimal sqrt = BigDecimal.valueOf(Math.sqrt(area));
            BigInteger sqrtIntValue= sqrt.toBigInteger();
            resultsList.add((sqrtIntValue.pow(2)).intValue());
            int remainingArea=area-(sqrtIntValue.pow(2)).intValue();
            if(remainingArea>1){
                getResults(remainingArea, resultsList);
            }
            else if(remainingArea==1){
                resultsList.add(remainingArea);
            }
        }
        return resultsList;
    }

}
