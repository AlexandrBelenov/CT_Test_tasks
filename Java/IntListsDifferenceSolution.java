import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class IntListsDifferenceSolution {
	
	public static void main(String... args) {
        List<Integer> first = Arrays.asList(1, 3, 3, 4, 6, 5, 4);
        List<Integer> second = Arrays.asList(6, 3, 5, 2, 2);
        
        //main task
        //Implement a logic that finds difference between "first" and "secord" lists
        // and prints the result to the console:
        // [1, 2, 4]
        //enhanced task
        //** try to come up with solution wich doesn't use set data structure
        List<Integer> diffsEnhanced = solutionEnhanced(first, second);
        System.out.println(diffsEnhanced);
    }
    
    public static List<Integer> solutionEnhanced(List<Integer> first, List<Integer> second) {
    	List<Integer> mergedList = new ArrayList<Integer>();
    	mergedList.addAll(first);
    	mergedList.addAll(second);
    	mergedList.sort(null);
    	
    	List<Integer> diffList = new LinkedList<Integer>();
    	
    	for (Integer element : mergedList) {
    		if (first.contains(element) && second.contains(element)) {
    			continue;
    		}
    		if (!diffList.contains(element)) {
    			diffList.add(element);
    		}
    	}
   
    	return diffList;
    }
}
