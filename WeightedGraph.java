
/**
 * Write a description of class weightedGraph here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WeightedGraph<T> implements WeightedGraphInterface<T>
{
    public static final int NULL_EDGE = 0;
    private static final int DEFCAP = 50;
    private int numVerticies;
    private int maxVerticies;
    private T[] verticies;
    private int[][] edges;
    private boolean[] marks;
    
    public WeightedGraph()
    {
        numVerticies = 0;
        maxVerticies = DEFCAP;
        verticies = (T[]) new Object[DEFCAP];
        marks = new boolean[DEFCAP];
        edges = new int[DEFCAP][DEFCAP];
    }
    
    public WeightedGraph(int maxV)
    {
        numVerticies = 0;
        maxVerticies = DEFCAP;
        verticies = (T[]) new Object[maxV];
        marks = new boolean[maxV];
        edges = new int[maxV][maxV];
    }
    // tests if graph is empty
    public boolean empty()
    {
        return numVerticies == 0;
    }
    
    // tests if graph is full
    public boolean full()
    {
        return numVerticies == maxVerticies;
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
