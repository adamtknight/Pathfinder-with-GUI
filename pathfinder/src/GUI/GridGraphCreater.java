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
            if(i == 69){
                addEdgesCorner(i);
                continue;
            }
            if(i == 4830){
                addEdgesCorner(i);
                continue;
            }
            if(i == 4899){
                addEdgesCorner(i);
                continue;
            }
            if(i > 0 && i < 69){
                addEdgeTopBorder(i);
                continue;
            }
            if(i % 70 == 0){
                addEdgeLeftBorder(i);
                continue;
            }
            if(i % 70 == 69){
                addEdgeRightBorder(i);
                continue;
            }
            if(i > 4830 && i < 4899){
                addEdgeBottomBorder(i);
                continue;
            }
            addEdgeNormal(i);
        }
    }
    private void addEdgesCorner(int i) throws Exception {
        if(i == 0){
            graph.addEdge(i, i + 70);
            graph.addEdge(i, i + 1);
        }
        if(i == 69){
            graph.addEdge(i, i + 70);
            graph.addEdge(i, i - 1);
        }
        if(i == 4830){
            graph.addEdge(i, i - 70);
            graph.addEdge(i, i + 1);
        }
        if(i == 4899){
            graph.addEdge(i, i - 70);
            graph.addEdge(i, i - 1);
        }

    }
    private void addEdgeTopBorder(int i) throws Exception {
        graph.addEdge(i, i + 1);
        graph.addEdge(i, i - 1);
        graph.addEdge(i, i + 70);
    }
    private void addEdgeLeftBorder(int i) throws Exception {
        graph.addEdge(i, i + 1);
        graph.addEdge(i, i - 70);
        graph.addEdge(i, i + 70);
    }
    private void addEdgeRightBorder(int i) throws Exception {
        graph.addEdge(i, i - 70);
        graph.addEdge(i, i - 1);
        graph.addEdge(i, i + 70);
    }
    private void addEdgeBottomBorder(int i) throws Exception {
        graph.addEdge(i, i + 1);
        graph.addEdge(i, i - 1);
        graph.addEdge(i, i - 70);
    }
    private void addEdgeNormal(int i) throws Exception {
        graph.addEdge(i, i + 1);
        graph.addEdge(i, i - 1);
        graph.addEdge(i, i + 70);
        graph.addEdge(i, i - 70);
    }
    public UndirectedUnweightedGraph<Integer> getGraph(){
        return graph;
    }
}
