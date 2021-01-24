package Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Vertex<T>{
   
    T data;
    int color;
    boolean visited;
    ArrayList<Vertex<T>> ancestors;

    
    public Vertex(T data){
       this.data = data;
       color = -1;
       visited = false;
       ancestors = new ArrayList<>();
    }
    
    public T getData() {return data;}
    
    public int getColor(){return color;}
    
    public void setColor(int color){this.color = color;}
    
    public boolean isVisited(){return visited;}
    
    public void setVisited(boolean visited){this.visited = visited;}

    public void addAncestor(Vertex<T> vertex){ancestors.add(vertex);}
    
    public ArrayList<Vertex<T>> getAncestors(){return ancestors;}

 
 
 }
