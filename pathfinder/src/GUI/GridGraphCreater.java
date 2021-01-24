package GUI;

import Graph.UndirectedUnweightedGraph;

public class GridGraphCreater {
    UndirectedUnweightedGraph<Integer> graph;

    public GridGraphCreater(int numVertices) throws Exception {
        graph = new UndirectedUnweightedGraph<>(numVertices);
        for(int i = 0; i < numVertices; i++){
            graph.addVertex(i);
        }
        for(int i = 0; i < numVertices; i++){
            if(i == 0){
                addEdgesCorner(i);
                continue;
            }
            if(i == 29){
                addEdgesCorner(i);
                continue;
            }
            if(i == 870){
                addEdgesCorner(i);
                continue;
            }
            if(i == 899){
                addEdgesCorner(i);
                continue;
            }
            if(i > 0 && i < 29){
                addEdgeTopBorder(i);
                continue;
            }
            if(i % 30 == 0){
                addEdgeLeftBorder(i);
                continue;
            }
            if(i % 30 == 29){
                addEdgeRightBorder(i);
                continue;
            }
            if(i > 870 && i < 899){
                addEdgeBottomBorder(i);
                continue;
            }
            addEdgeNormal(i);
        }
    }
    private void addEdgesCorner(int i) throws Exception {
        if(i == 0){
            graph.addEdge(i, i + 30);
            graph.addEdge(i, i + 1);
        }
        if(i == 29){
            graph.addEdge(i, i + 30);
            graph.addEdge(i, i - 1);
        }
        if(i == 870){
            graph.addEdge(i, i - 30);
            graph.addEdge(i, i + 1);
        }
        if(i == 899){
            graph.addEdge(i, i - 30);
            graph.addEdge(i, i - 1);
        }

    }
    private void addEdgeTopBorder(int i) throws Exception {
        graph.addEdge(i, i + 1);
        graph.addEdge(i, i - 1);
        graph.addEdge(i, i + 30);
    }
    private void addEdgeLeftBorder(int i) throws Exception {
        graph.addEdge(i, i + 1);
        graph.addEdge(i, i - 30);
        graph.addEdge(i, i + 30);
    }
    private void addEdgeRightBorder(int i) throws Exception {
        graph.addEdge(i, i - 30);
        graph.addEdge(i, i - 1);
        graph.addEdge(i, i + 30);
    }
    private void addEdgeBottomBorder(int i) throws Exception {
        graph.addEdge(i, i + 1);
        graph.addEdge(i, i - 1);
        graph.addEdge(i, i - 30);
    }
    private void addEdgeNormal(int i) throws Exception {
        graph.addEdge(i, i + 1);
        graph.addEdge(i, i - 1);
        graph.addEdge(i, i + 30);
        graph.addEdge(i, i - 30);
    }
    public UndirectedUnweightedGraph<Integer> getGraph(){
        return graph;
    }
}
