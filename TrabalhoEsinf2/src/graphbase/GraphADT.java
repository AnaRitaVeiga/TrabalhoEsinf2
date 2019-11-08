/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphbase;

/**
 *
 * @author Ana Rita Veiga
 */
public class GraphADT {

    public interface GraphInterface<V, E> {

        int numVertices();

        Iterable<V> vertices();

        int numEdges();

        Iterable<Edge<V, E>> edges();

        Edge<V, E> getEdge(V vOrig, V vDest);

        V[] endVertices(Edge<V, E> edge);

        V opposite(V vert, Edge<V, E> edge);

        int outDegree(V vert);

        int inDegree(V vert);

        Iterable<Edge<V, E>> outgoingEdges(V vert);

        Iterable<Edge<V, E>> incomingEdges(V vert);
        

        boolean insertVertex(V newVert);

        boolean insertEdge(V vOrig, V vDest, E edge, double eWeight);

        boolean removeVertex(V vert);

        boolean removeEdge(V vOrig, V vDest);
    }
}
