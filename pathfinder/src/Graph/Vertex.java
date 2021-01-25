package Graph;



public class Vertex<T>{
   
    T data;
    boolean visited;
    
    
    public Vertex(T data){
       this.data = data;
       visited = false;
    }
    
    public T getData() {return data;}
    
    public boolean isVisited(){return visited;}
    
    public void setVisited(boolean visited){this.visited = visited;}
 }
