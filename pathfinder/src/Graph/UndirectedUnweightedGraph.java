package Graph;

import java.util.ArrayList;

/**
 * This class implements general operations on a graph as specified by UndirectedGraphADT.
 * It implements a graph where data is contained in Vertex class instances.
 * Edges between verticies are unweighted and undirected.
 * A graph coloring algorithm determines the chromatic number. 
 * Colors are represented by integers. 
 * The maximum number of vertices and colors must be specified when the graph is instantiated.
 * You may implement the graph in the manner you choose. See instructions and course material for background.
 */
 
  public class UndirectedUnweightedGraph<T> {
   // private class variables here.
   
   
    // TODO: Declare class variables here.
   Boolean[][] graph;
   ArrayList<Vertex<T>> vertices;
   int numEdges;
   int numVertices;

   
   /**
    * Initialize all class variables and data structures. 
   */   
    public UndirectedUnweightedGraph (int maxVertices){
     // TODO: Implement the rest of this method.
      graph = new Boolean[maxVertices][maxVertices];
      vertices = new ArrayList<Vertex<T>>();
      numEdges = 0;
      numVertices = 0;
   }

   /**
    * Add a vertex containing this data to the graph.
    * Throws Exception if trying to add more than the max number of vertices.
   */
   public void addVertex(T data) throws Exception {
    // TODO: Implement this method.
    numVertices++;
    vertices.add(new Vertex<T>(data));
    
   }
   
   /**
    * Return true if the graph contains a vertex with this data, false otherwise.
   */   
   public boolean hasVertex(T data){
    // TODO: Implement this method.
    for(Vertex<T> vertex : vertices){
      if(vertex.getData().equals(data)){
        return true;
      }
    }
    return false;
   } 

   /**
    * Add an edge between the vertices that contain these data.
    * Throws Exception if one or both vertices do not exist.
   */   
   public void addEdge(T data1, T data2) throws Exception{
    // TODO: Implement this method.
    int indexData1 = -1;
    int indexData2 = -1;
    for(int index = 0; index < vertices.size(); index++){
      if(vertices.get(index).getData().equals(data1)){
        indexData1 = index;
      }
      if(vertices.get(index).getData().equals(data2)){
        indexData2 = index;
      }
    }
    if(indexData1 == -1 || indexData2 == -1){
      throw new Exception();
    }
    graph[indexData1][indexData2] = true;
    graph[indexData2][indexData1] = true;
    numEdges++;

   }

   /**
    * Get an ArrayList of the data contained in all vertices adjacent to the vertex that
    * contains the data passed in. Returns an array of zero length if no adjacencies exist in the graph.
    * Throws Exception if a vertex containing the data passed in does not exist.
   */   
   public ArrayList<Vertex<T>> getAdjacentData(T data) throws Exception{
    // TODO: Implement this method.
    int index = -1;
    for(index = 0; index < vertices.size(); index++){
      if(vertices.get(index).getData().equals(data)){
        break;
      }
    }
    if(index == -1){
      throw new Exception();
    }
    ArrayList<Vertex<T>> adjacentData = new ArrayList<>();
    for(int i = 0; i < numVertices; i++){
      if(graph[index][i] != null){
        adjacentData.add(vertices.get(i));
      }
    }
    return adjacentData;
   }
   
   /**
    * Returns the total number of vertices in the graph.
   */   
   public int getNumVertices(){
    // TODO: Implement this method.
      return numVertices;
   }

   /**
    * Returns the total number of edges in the graph.
   */   
   public int getNumEdges(){
    // TODO: Implement this method.
      return numEdges;
   }

   public ArrayList<Vertex<T>> getVertices(){
     return vertices;
   }
   
  }
   
