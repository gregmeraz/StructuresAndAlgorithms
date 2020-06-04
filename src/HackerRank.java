import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HackerRank {

    public static void main(String[] args) {
        System.out.println(fewestCoins("asdfkjeghfalawefhaef"));
    }

    public static int fewestCoins(String coins) {
        String[] stringSplit = coins.split("");
        Set<String> letters = new HashSet<>(Arrays.asList(stringSplit));
        System.out.println(letters);
        String result = coins;
        StringBuilder sb= new StringBuilder();
        for(int i = 0; i < stringSplit.length; i ++ ) {
            String[] subArray = Arrays.copyOfRange(stringSplit, i, stringSplit.length-1);
            for(int j = 0; j < subArray.length; j++){
                String currentLetter = subArray[j];
                if(letters.isEmpty()){


                    if(result.length() > sb.toString().length()){
                        result = sb.toString();
                        sb = new StringBuilder();
                    }
                    letters= new HashSet<>(Arrays.asList(stringSplit));
                }

                sb.append(currentLetter);
                letters.remove(currentLetter);
            }
            if(letters.isEmpty()){
                if(result.length() > sb.toString().length()){
                    result = sb.toString();
                    sb = new StringBuilder();
                }
            }

            letters= new HashSet<>(Arrays.asList(stringSplit));
            sb = new StringBuilder();

        }
        return result.length();
    }
}
