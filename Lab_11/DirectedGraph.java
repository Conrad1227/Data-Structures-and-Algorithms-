import java.util.*;
/**
 * Write a description of class DirectedGraph here.
 *
 * @author Conrad Hahn
 * @version 5/5/2025
 */
public class DirectedGraph<K>
{
    private List<DirectedGraphNode> graph;

    /**
     * Constructor for a new DirectedGraph list
     */
    public DirectedGraph()
    {
        graph = new ArrayList<>();
    }

    /**
     * Adds a new node to the graph
     * 
     * @param k new value being added to the graph
     * @return True if the value was added, false if the value was already in the graph
     */
    public boolean addNode(K k){
        //search for node in the graph
        for(int i=0; i < graph.size();i++){
            if(graph.get(i).key.equals(k)){
                return false;
            }
        }
        //if its not found add the new Node
        graph.add(new DirectedGraphNode(k));
        return true;
    }

    /**
     * Adds a new edge between two nodes or resizes an existing one
     * 
     * @param k1 starting node of the edge
     * @param k2 end node of the edge
     * @param w weight of the new edge
     * @return True if the edge was added, false if either of the nodes dont exist
     */
    public boolean addEdge(K k1, K k2, int w){
        //search for node in the graph
        DirectedGraphNode start = null;
        DirectedGraphNode end = null;
        for(int i=0; i < graph.size();i++){
            DirectedGraphNode temp = graph.get(i);
            if(temp.key.equals(k1)){
                start = temp;
            } 
            if(temp.key.equals(k2)){
                end = temp;
            }
        }
        //if one of the nodes doesnt exist return false
        if(start == null || end == null){
            return false;
        }

        //check if it already exists
        for (int i = 0; i < start.outgoing.size(); i++) {
            DirectedGraphEdge tempEdge = start.outgoing.get(i);
            if (tempEdge.end == end) {
                tempEdge.weight = w;
                return true;
            }
        }
        //if neither add an edge
        start.outgoing.add(new DirectedGraphEdge(start, end, w));
        return true;
    }

    /**
     * Returns a list of the nodes neighbors that it can reach in one hop
     * 
     * @param k the value of the node whos neighbors are being found
     * @return a generic ArrayList of the nodes neighbors
     */
    public ArrayList<K> getNeighbors(K k) {
        //find the node with that value
        DirectedGraphNode temp = new DirectedGraphNode(null);
        for(int i=0; i < graph.size();i++){
            if(graph.get(i).key.equals(k)){
                temp = graph.get(i);
                break;
            }
        }
        ArrayList<K> out = new ArrayList<>();
        //go through its connections and get all the nodes its dirrectly connected to
        if (temp != null) {
            for (int i = 0; i < temp.outgoing.size(); i++) {
                DirectedGraphEdge edge = temp.outgoing.get(i);
                out.add(edge.end.key);
            }
        }
        return out;
    }

    /**
     *  prints out the closest neighbor of each node in the graph that they can reach in one hop
     * 
     * @param k1 the node that the breadth first order starts at when moving through the graph
     */
    public void breadthFirstClosest(K k1){
        //finds the node with value k1
        DirectedGraphNode start = new DirectedGraphNode(null);
        for(int i=0; i < graph.size();i++){
            if(graph.get(i).key.equals(k1)){
                start = graph.get(i);
                break;
            }
        }
        if(start == null){
            return;
        }
        //create a set to store visited nodes and a queue for reading them
        Set<K> visited = new HashSet<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start.key);
        while (!queue.isEmpty()) {
            DirectedGraphNode current = queue.poll();
            DirectedGraphNode closest = current.returnNeighbor();
            //prints the closest node if it is not null
            if(closest!=null){
                System.out.println(current.key + " " + closest.key);
            }else{
                System.out.println(current.key + " null");
            }
            for (DirectedGraphEdge edge : current.outgoing) {
                if (!visited.contains(edge.end.key)) {
                    visited.add(edge.end.key);
                    queue.add(edge.end);
                }
            }
        }
    }

    /**
     * Node class for the directed graph
     *
     * @author Conrad Hahn
     * @version 5/5/2025
     */
    private class DirectedGraphNode{
        K key;
        List<DirectedGraphEdge> outgoing;

        /**
         * Constructor for a new DirectedGraphNode with specified value
         * 
         * @param key the value of the node
         */
        DirectedGraphNode(K key) {
            this.key = key;
            this.outgoing = new ArrayList<>();
        }

        /**
         * returns the closest neighbor of the node
         * 
         * @return the clostest neighbor of this node
         */
        public DirectedGraphNode returnNeighbor() {
            if (outgoing.isEmpty()){
                return null;
            }
            DirectedGraphEdge closest = outgoing.get(0);
            for (int i = 1; i < outgoing.size(); i++) {
                if (outgoing.get(i).weight < closest.weight) {
                    closest = outgoing.get(i);
                }
            }
            return closest.end;
        }

    }

    /**
     * Edge class for the directed graph
     *
     * @author Conrad Hahn
     * @version 5/5/2025
     */
    private class DirectedGraphEdge {
        DirectedGraphNode start;
        DirectedGraphNode end;
        int weight;

        /**
         * Constructor for a new edge between two nodes with specified weight
         * 
         * @param weight the weight of the edge
         * @param start the node where the edge is starting
         * @param end the node where the edge is ending up
        */
        DirectedGraphEdge(DirectedGraphNode start, DirectedGraphNode end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
