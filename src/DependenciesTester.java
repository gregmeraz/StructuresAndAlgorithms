import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DependenciesTester {

    public static void main(String[] args) {

        Map<String, List<String>> packagesMap= new LinkedHashMap<>();
        Map<String, List<String>> dependenciesMap=new LinkedHashMap<>();
        List<String> dep1= Arrays.asList("dep2", "dep3");
        List<String> dep2= Arrays.asList("dep4", "dep5");
        List<String> dep4= Collections.singletonList("dep2");
        List<String> dep5= Collections.singletonList("dep6");
        List<String> dep8= Collections.singletonList("dep5");
        List<String> dep10= Arrays.asList("dep1", "dep6");
        List<String> dep11= Collections.singletonList("dep10");

        dependenciesMap.put("dep1", dep1);
        dependenciesMap.put("dep2", dep2);
        dependenciesMap.put("dep4", dep4);
        dependenciesMap.put("dep5", dep5);
        dependenciesMap.put("dep8", dep8);
        dependenciesMap.put("dep10", dep10);
        dependenciesMap.put("dep11", dep11);

        packagesMap.put("pkgA", new ArrayList<>());
        packagesMap.put("pkgB", Arrays.asList("dep1", "dep2"));
        packagesMap.put("pkgC", Arrays.asList("dep2", "dep3"));
        packagesMap.put("pkgD", Arrays.asList("dep1", "dep4"));
        System.out.println(dependenciesMap);
        System.out.println(packagesMap);

        System.out.println(getPackagesUsingDependency(packagesMap, dependenciesMap, "dep6"));

    }


    public static Set<String> getPackagesUsingDependency(Map<String, List<String>> packagesMap, Map<String, List<String>> dependenciesMap, String givenDependency){
        Queue<String> queue=new NoDuplicateElemementsQueue();
        queue.add(givenDependency);
        Set<String> dependenciesForGiven=solveDeepDependencies(queue, dependenciesMap, new LinkedHashSet<>());
        Set<String> finalResult= new LinkedHashSet<>();
        for(Map.Entry<String, List<String>> packagesEntry:packagesMap.entrySet()){
                   for(String dependency:dependenciesForGiven){
                       if(packagesEntry.getValue().contains(dependency)){
                           finalResult.add(packagesEntry.getKey());
                       }
                   }
               }

        return finalResult;
    }
    public static Set<String> solveDeepDependencies(Queue<String> dependenciesQueue, Map<String, List<String>> dependenciesMap, Set<String> result){
        while(dependenciesQueue.peek()!=null){
                result.add(dependenciesQueue.peek());
                String polledElement= dependenciesQueue.poll();
                dependenciesMap.forEach((dependencyKey, dependenciesList) -> {
                    if(dependenciesList.contains(polledElement)){
                        if(!result.contains(dependencyKey)){
                            dependenciesQueue.add(dependencyKey);
                        }
                        result.add(dependencyKey);
                    }
                });
            solveDeepDependencies(dependenciesQueue, dependenciesMap, result);
        }

        return result;
    }

}
