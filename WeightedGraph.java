
/**
 * Write a description of class weightedGraph here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WeightedGraph<T> implements WeightedGraphInterface<T>
{
    // tests if graph is empty
    public boolean empty()
    {
        return false;
    }
    
    // tests if graph is full
    public boolean full()
    {
        return false;
    }
    
    // Precondition: Vertex is not already in graph
    // Precondition: Vertex is not null
    // adds vertex to graph
    public void addVertex(T vertex)
    {
    
    }
        
    // returns true if graph contains vertex
    public boolean hasVertex(T vertex)
    {
        return false;
    }
    
    // adds an edge with the specified weight from fromVertex to toVertex
    public void setEdge(T fromVertex, T toVertex,int weight)
    {
        
    }
    
    // if edge from fromVertex to toVertex exists, return the weight of
    // the edge; otherwise, returns a special "null-edge" value.
    public int weightIs(T fromVertex, T toVertex)
    {
        return -1;
    }
    
    // returns a queue of the vertices that are adjacent to the vertex
    public QueueInterface<T> getAdjacentVertices(T vertex)
    {
        return null;
    }
    
    // sets marks for all vertices to false
    public void clearMarks()
    {
    
    }
    
    // sets mark for vertex to true
    public void markVertex(T vertex)
    {
    
    }
    
    // returns true if vertex is marked
    public boolean isMarked(T vertex)
    {
        return false;
    }
    
    // returns an unmarked vertex if any exist, otherwise returns null
    public T getUnmarked()
    {
        return null;
    }
    
    // return a String representation of this graph
   public  String toString()
   {
       return "";
    }
}
