public class GraphPaths
{
    public static boolean isPathDF(WeightedGraphInterface<String> graph, 
                                   String startVertex, String endVertex)
    // Returns true if a path exists on graph, from startVertex to endVertex; 
    // otherwise returns false. Uses depth-first search algorithm.
    {
        boolean found = false;
        StackInterface<String> stack = new LinkedStack<String>();
        graph.clearMarks();
        stack.push(startVertex);
        while(!stack.empty() && found == false)
        {
            String vertex = stack.pop();
            if(vertex.equals(endVertex))
            {
                found = true;
            }
            else
            {
                if(!graph.isMarked(vertex))
                {
                    graph.markVertex(vertex);
                    QueueInterface<String> adj = graph.getAdjacentVertices(vertex);
                    while(!adj.empty())
                    {
                        stack.push(adj.remove());
                    }
                }
            }
        }
        return found;
    }

    public static boolean isPathBF(WeightedGraphInterface<String> graph, 
                                   String startVertex, String endVertex    )
    // Returns true if a path exists on graph, from startVertex to endVertex; 
    // otherwise returns false. Uses breadth-first search algorithm.
    {
        return false;
    }

    public static QueueInterface<Flight> shortestPaths(WeightedGraphInterface<String> graph, 
                                                       String startVertex)
    // Determines the shortest distance from startVertex to every other reachable vertex in graph.
    {
        return null;
    }
}