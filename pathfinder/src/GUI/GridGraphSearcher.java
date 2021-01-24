package GUI;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JButton;

import Graph.UndirectedUnweightedGraph;
import Graph.Vertex;

public class GridGraphSearcher {
    UndirectedUnweightedGraph graph;
    int startIndex;
    int endIndex;
    

    public GridGraphSearcher(UndirectedUnweightedGraph graph){
        this.graph = graph;
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
    public List<Vertex<Integer>> depthFirst() throws Exception {
        ArrayList<Vertex<Integer>> vertices = graph.getVertices();
        // Reset 'explored' in nodes
        for(Vertex<Integer> vertex : vertices){
            vertex.setVisited(false);
        }

        // The stack of items to look through in the future
        Stack<Vertex<Integer>> frontier = new Stack<>();
        // Add our start node
        

        frontier.push(vertices.get(startIndex));

        // While there are still more things to search through
        while(!frontier.isEmpty()){
            Vertex<Integer> curEntry = frontier.pop();
            // If the curent node has been explored, skip it and move on
            if(curEntry.isVisited()){
                continue;
            }
            // If we're done
            if(curEntry.getData() == endIndex){
                // Format ancestors properly
                ArrayList<Vertex<Integer>> path = curEntry.getAncestors();
                path.add(curEntry);
                // return
                return path;
            }
            // Get neighbors of current node
            ArrayList<Vertex<Integer>> neighbors = graph.getAdjacentData(curEntry.getData());
            // For each neighbor
            for(Vertex<Integer> neighbor : neighbors){
                // If the node has not been explored, add it to frontier
                if(!neighbor.isVisited()){
                    // Search entry for the neighbor
                    
                    // Copy curNode's ancestors
                    for(Vertex<Integer> ancestor : curEntry.getAncestors()){
                        neighbor.addAncestor(ancestor);
                    }
                    // Add curNode's ID as ancestor
                    neighbor.addAncestor(curEntry);
                    // Push to frontier
                    frontier.push(neighbor);
                }
            }
            // Set our curent node to 'explored'
            curEntry.setVisited(true);
            MainWindowGUI.setButtonColor(curEntry.getData());

        }
        // There is no valid path, return null.
        return null;
    }
    
}
