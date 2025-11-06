import java.util.Scanner;
import java.io.*;

/**
 * Creates a DirectedGraph and reads it out in breadth first closest order
 *
 * @author Conrad Hahn
 * @version 5/5/2025
 */
public class GraphExperiment
{
    /**
     * Runs a test of the DirectedGraph and breadthFirstClosest method in particular
     * Inputs are read out of the "graph.txt" file
     *
     * @param args not used
     */
    public static void main(String[] args)
    {
        try {
            Scanner scnr = new Scanner(new File("graph.txt"));
            String[] nodes = scnr.nextLine().split(" ");
            DirectedGraph<String> graph = new DirectedGraph<>();
            for (int i = 0; i < nodes.length; i++) {
                graph.addNode(nodes[i]);
            }

            while (scnr.hasNextLine()) {
                String[] edges = scnr.nextLine().split(" ");
                if (edges.length == 3) {
                    String start = edges[0];
                    String end = edges[1];
                    int weight = Integer.parseInt(edges[2]);
                    graph.addEdge(start, end, weight);
                }
            }

            graph.breadthFirstClosest(nodes[0]);
        
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
