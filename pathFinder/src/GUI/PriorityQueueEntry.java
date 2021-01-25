package GUI;

import java.util.ArrayList;

import Graph.Vertex;

public class PriorityQueueEntry implements Comparable<PriorityQueueEntry>{
    Vertex<Integer> vertex;
    Integer weight;
    ArrayList<Vertex<Integer>> ancestors = new ArrayList<>();

    public PriorityQueueEntry(Vertex<Integer> vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
    public Integer getWeight(){return weight;}
    
    public void addWeight(int weight){this.weight += weight;}

    public Vertex<Integer> getVertex(){return vertex;}

    public void addAncestor(Vertex<Integer> vertex){
        ancestors.add(vertex);
    }
    public ArrayList<Vertex<Integer>> getAncestors(){
        return ancestors;
    }
    @Override
    public int compareTo(PriorityQueueEntry o) {
        return this.getWeight().compareTo(o.getWeight());
    }
}
