import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HackeRankRelateds {

    public static void main(String[] args) {
        List<String> related= new ArrayList<>();
        related.add("1100");
        related.add("1110");
        related.add("0110");
        related.add("0001");

        countGroups(related);

    }

    public static int countGroups(List<String> related) {
            Map<Integer, List<String>> relatedMaps= new LinkedHashMap<>();
          for(int i=0; i<related.size(); i++){
                relatedMaps.put(i, Arrays.asList(related.get(i).split("")));
            }
          int groups=0;

          System.out.println(relatedMaps);
          return 0;
    }

}
