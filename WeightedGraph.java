
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
        verticies[numVerticies] = vertex;
        for(int index = 0; index < numVerticies; index++)
        {
            edges[numVerticies][index] = NULL_EDGE;
            edges[index][numVerticies] = NULL_EDGE;
        }
        numVerticies++;
    }
        
    public int indexIs(T vertex)
    {
        int index = 0;
        while(!vertex.equals(verticies[index]))
        {
            index++;
        }
        return index;
    }
    
    // returns true if graph contains vertex
    public boolean hasVertex(T vertex)
    {
        for(int i = 0; i < verticies.length; i++)
        {
            if(verticies[i] != null && verticies[i].equals(vertex))
            {
                return true;
            }
        }
        return false;
    }
    
    // adds an edge with the specified weight from fromVertex to toVertex
    public void setEdge(T fromVertex, T toVertex,int weight)
    {
        int row = indexIs(fromVertex);
        int col = indexIs(toVertex);
        edges[row][col] = weight;
    }
    
    
    // if edge from fromVertex to toVertex exists, return the weight of
    // the edge; otherwise, returns a special "null-edge" value.
    public int weightIs(T fromVertex, T toVertex)
    {
        int row = indexIs(fromVertex);
        int col = indexIs(toVertex);
        return edges[row][col];
    }
    
    // returns a queue of the vertices that are adjacent to the vertex
    public QueueInterface<T> getAdjacentVertices(T vertex)
    {
        QueueInterface<T> adj = new LinkedQueue<T>();
        int fromIndex;
        int toIndex;
        fromIndex = indexIs(vertex);
        for(toIndex = 0; toIndex < numVerticies; toIndex++)
        {
            if(edges[fromIndex][toIndex] != NULL_EDGE)
            {
                adj.add(verticies[toIndex]);
            }
        }
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
       String result = "\nGraph representation:\n\t";
        for(int i = 0; i < verticies.length; i++)
            if(verticies[i] != null)
                result += ((String)verticies[i]).substring(0, 3) + "\t";
        result += "\n";
        for(int r = 0; r < verticies.length; r++)
            if(verticies[r] != null)
            {
                result += ((String)verticies[r]).substring(0, 3) + "\t";
                for(int c = 0; c < verticies.length; c++)
                {
                    if(verticies[c] != null)
                        result += edges[r][c] + "\t";
                }
                result += "\n";
            }
        return result;
    }
}
