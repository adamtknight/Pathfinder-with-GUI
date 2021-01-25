package GUI;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JButton;

import Graph.UndirectedUnweightedGraph;
import Graph.Vertex;

public class GridGraphSearcher {
    UndirectedUnweightedGraph graph;
    int startIndex;
    int endIndex;
    ArrayList<Integer> visited;

    public GridGraphSearcher(UndirectedUnweightedGraph graph){
        this.graph = graph;
        visited = new ArrayList<>();
    }
    public void findStartIndex(JButton button){
        //TODO
        int i;
        for(i = 0; i < MainWindowGUI.getButtonArray().length; i++){
            if(button == MainWindowGUI.getButtonArray()[i]){
                break;
            }
        }
        setStartIndex(i);
    }
    public void setStartIndex(int i){
        startIndex = i;
    }
    public void resetVisited(){
        visited.removeAll(visited);
    }
    public void findEndIndex(JButton button){
        int i;
        for(i = 0; i < MainWindowGUI.getButtonArray().length; i++){
            if(button == MainWindowGUI.getButtonArray()[i]){
                break;
            }
        }
        setEndIndex(i);
    }
    public void setEndIndex(int i){
        endIndex = i;
    }
    public ArrayList<Vertex<Integer>> breadthFirst() throws Exception {
        ArrayList<Vertex<Integer>> vertices = graph.getVertices();
        // Reset 'explored' in nodes
        for(Vertex<Integer> vertex : vertices){
            vertex.setVisited(false);
        }

        // The stack of items to look through in the future
        Queue<QueueEntry> frontier = new LinkedList<>();
        // Add our start node  

        frontier.add(new QueueEntry(vertices.get(startIndex)));

        // While there are still more things to search through
        while(!frontier.isEmpty()){
            QueueEntry curEntry = frontier.remove();
            // If the curent node has been explored, skip it and move on
            if(curEntry.getVertex().isVisited()){
                continue;
            }
            // If we're done
            if(curEntry.getVertex().getData() == endIndex){
                // Format ancestors properly
                ArrayList<Vertex<Integer>> path = curEntry.getAncestors();
                path.add(curEntry.getVertex());
                // return
                return path;
            }
            // Get neighbors of current node
            ArrayList<Vertex<Integer>> neighbors = graph.getAdjacentData(curEntry.getVertex().getData());
            // For each neighbor
            for(Vertex<Integer> neighbor : neighbors){
                // If the node has not been explored, add it to frontier
                if(!neighbor.isVisited()){
                    // Search entry for the neighbor
                    QueueEntry nEntry = new QueueEntry(neighbor);
                    // Copy curNode's ancestors
                    for(Vertex<Integer> ancestor : curEntry.getAncestors()){
                        nEntry.addAncestor(ancestor);
                    }
                    // Add curNode's ID as ancestor
                    nEntry.addAncestor(curEntry.getVertex());
                    // Push to frontier
                    frontier.add(nEntry);
                }
            } 
            // Set our curent node to 'explored'
            curEntry.getVertex().setVisited(true);
            visited.add(curEntry.getVertex().getData());

        }
        // There is no valid path, return null.
        return null;
    }
    public ArrayList<Vertex<Integer>> dijkstra() throws Exception {
        // Reset 'explored' in nodes
        ArrayList<Vertex<Integer>> vertices = graph.getVertices();
        // Reset 'explored' in nodes
        for(Vertex<Integer> vertex : vertices){
            vertex.setVisited(false);
        }

        // The stack of items to look through in the future
        PriorityQueue<PriorityQueueEntry> frontier = new PriorityQueue<>();
        // Add our start node
        frontier.add(new PriorityQueueEntry(vertices.get(startIndex), 0));

        // While there are still more things to search through
        while(!frontier.isEmpty()){
            PriorityQueueEntry curEntry = frontier.remove();
            // If the curent node has been explored, skip it and move on
            if(curEntry.getVertex().isVisited()){
                continue;
            }
            // If we're done
            if(curEntry.getVertex().getData() == endIndex){
                // Format ancestors properly
                ArrayList<Vertex<Integer>> path = curEntry.getAncestors();
                path.add(curEntry.getVertex());
                // return
                return path;
            }

            // Get neighbors of current node
            ArrayList<Vertex<Integer>> neighbors = graph.getAdjacentData(curEntry.getVertex().getData());

            for(Vertex<Integer> neighbor : neighbors){
                // If the node has not been explored, add it to frontier
                if(!neighbor.isVisited()){
                    // Search entry for the neighbor
                    PriorityQueueEntry nEntry = new PriorityQueueEntry(neighbor, curEntry.getWeight() + 1);
                    // Copy curNode's ancestors
                    for(Vertex<Integer> ancestor : curEntry.getAncestors()){
                        nEntry.addAncestor(ancestor);
                    }
                    // Add curNode's ID as ancestor
                    nEntry.addAncestor(curEntry.getVertex());
                    // Push to frontier
                    frontier.add(nEntry);
                }
            } 
            // Set our curent node to 'explored'
            curEntry.getVertex().setVisited(true);
            visited.add(curEntry.getVertex().getData());
        }
        // There is no valid path, return null.
        return null;
    }
   public ArrayList<Integer> getVisited(){
       return visited;
   } 
   public ArrayList<Vertex<Integer>> depthFirst() throws Exception {
    ArrayList<Vertex<Integer>> vertices = graph.getVertices();
    // Reset 'explored' in nodes
    for(Vertex<Integer> vertex : vertices){
        vertex.setVisited(false);
    }

    // The stack of items to look through in the future
    Stack<QueueEntry> frontier = new Stack<>();
    // Add our start node  

    frontier.push(new QueueEntry(vertices.get(startIndex)));

    // While there are still more things to search through
    while(!frontier.isEmpty()){
        QueueEntry curEntry = frontier.pop();
        // If the curent node has been explored, skip it and move on
        if(curEntry.getVertex().isVisited()){
            continue;
        }
        // If we're done
        if(curEntry.getVertex().getData() == endIndex){
            // Format ancestors properly
            ArrayList<Vertex<Integer>> path = curEntry.getAncestors();
            path.add(curEntry.getVertex());
            // return
            return path;
        }
        // Get neighbors of current node
        ArrayList<Vertex<Integer>> neighbors = graph.getAdjacentData(curEntry.getVertex().getData());
        // For each neighbor
        for(Vertex<Integer> neighbor : neighbors){
            // If the node has not been explored, add it to frontier
            if(!neighbor.isVisited()){
                // Search entry for the neighbor
                QueueEntry nEntry = new QueueEntry(neighbor);
                // Copy curNode's ancestors
                for(Vertex<Integer> ancestor : curEntry.getAncestors()){
                    nEntry.addAncestor(ancestor);
                }
                // Add curNode's ID as ancestor
                nEntry.addAncestor(curEntry.getVertex());
                // Push to frontier
                frontier.add(nEntry);
            }
        } 
        // Set our curent node to 'explored'
        curEntry.getVertex().setVisited(true);
        visited.add(curEntry.getVertex().getData());

    }
    // There is no valid path, return null.
    return null;
}
}
