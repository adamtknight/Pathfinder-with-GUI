package GUI;

import java.util.ArrayList;

import Graph.Vertex;

public class QueueEntry{
    Vertex<Integer> vertex;
    Integer weight;
    ArrayList<Vertex<Integer>> ancestors = new ArrayList<>();

    public QueueEntry(Vertex<Integer> vertex){
        this.vertex = vertex;
    }

    public Vertex<Integer> getVertex(){return vertex;}

    public void addAncestor(Vertex<Integer> vertex){
        ancestors.add(vertex);
    }
    public ArrayList<Vertex<Integer>> getAncestors(){
        return ancestors;
    }
}

