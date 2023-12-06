/*
Aarav Dev
Problem 9.3
*/

// Imports
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main 
{
    public static void main(String[] args) 
    {
        // Testing topologicalSort method
        int numCourses = 6;
        int[][] prerequisites = {{1,0},{2,1},{3,2},{4,3},{5,3}};

        List<Integer> result = topologicalSort(numCourses, prerequisites);
        System.out.println(result); // Output: [0, 1, 2, 3, 4, 5]
    }
    
    public static List<Integer> topologicalSort(int numCourses, int[][] prerequisites) 
    {
        List<Integer> result = new ArrayList<>(); // List to store the sorted elements
        int[] inDegree = new int[numCourses]; // Array to store in-degree of each vertex
        Queue<Integer> queue = new LinkedList<>(); // Queue to store vertices with in-degree 0
        List<List<Integer>> adjList = new ArrayList<>(); // Adjacency list to store the graph

        for (int i = 0; i < numCourses; i++) { // Initialize the adjacency list
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) { // Build the adjacency list and in-degree array
            int parent = prerequisites[i][1];
            int child = prerequisites[i][0];
            inDegree[child]++;
            adjList.get(parent).add(child);
        }

        for (int i = 0; i < numCourses; i++) { // Add vertices with in-degree 0 to the queue
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) { // Start the BFS
            int curr = queue.poll();
            result.add(curr);
            for (int neighbor : adjList.get(curr)) { // Decrement the in-degree of each neighbor of the current vertex
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) { // If the in-degree becomes 0, add it to the queue
                    queue.offer(neighbor);
                }
            }
        }

        if (result.size() != numCourses) { // If all vertices are not processed, there is a cycle in the graph
            return new ArrayList<>();
        }

        return result; // Return the sorted list of vertices
    }
}
