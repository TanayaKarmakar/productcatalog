package assessment.airbnb;

import java.util.*;

/**
 * @author t0k02w6 on 02/05/22
 * @project ds-algo-2021
 */
public class BinarySearchTreeForm {
    private static int findRoot(List<List<Integer>> nodes) {
        Map<Integer, List<Integer>> parentChildMap = new HashMap<>();

        for(List<Integer> node: nodes) {
            parentChildMap.put(node.get(0), Arrays.asList(node.get(1), node.get(2)));
        }

        Map<Integer, Integer> childParentMap = new HashMap<>();
        for(List<Integer> node: nodes) {
            if(node.get(1) != -1 && (!parentChildMap.containsKey(node.get(1))
                    || childParentMap.containsKey(node.get(1))))
                return -1;
            if(node.get(2) != -1 && (!parentChildMap.containsKey(node.get(2))
                    || childParentMap.containsKey(node.get(2))))
                return -1;
            Integer key1 = node.get(1);
            Integer key2 = node.get(2);
            childParentMap.put(key1, node.get(0));
            childParentMap.put(key2, node.get(0));
        }

        int notContainingNode = 0;
        int parentNode = 0;
        for(List<Integer> node: nodes) {
            Integer currentNode = node.get(0);
            if(!childParentMap.containsKey(currentNode)) {
                notContainingNode++;
                if(notContainingNode > 1)
                    return -1;
                parentNode = currentNode;
            }
        }
        return parentNode;
    }

    public static void main(String[] args) {
        //List<List<Integer>> list =
    }
}
