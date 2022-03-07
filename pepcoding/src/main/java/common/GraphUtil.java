package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 01/03/22
 * @project ds-algo-2021
 */
public class GraphUtil {
    public static Map<Integer, List<Integer>> buildGraph(int[][] paths) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < paths.length; i++) {
            int[] currentEdge = paths[i];
            if(!adjList.containsKey(currentEdge[0])) {
                adjList.put(currentEdge[0], new ArrayList<>());
            }
            adjList.get(currentEdge[0]).add(currentEdge[1]);

            if(!adjList.containsKey(currentEdge[1])) {
                adjList.put(currentEdge[1], new ArrayList<>());
            }
            adjList.get(currentEdge[1]).add(currentEdge[0]);
        }
        return adjList;
    }

    public static int[][] buildGraph(int[][] paths, int nVertices) {
        int[][] adjMat = new int[nVertices][nVertices];

        for(int i = 0; i < paths.length; i++) {
            int[] currentPath = paths[i];
            adjMat[currentPath[0]][currentPath[1]] = 1;
            adjMat[currentPath[1]][currentPath[0]] = 1;
        }

        return adjMat;
    }
}
