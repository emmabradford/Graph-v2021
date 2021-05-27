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
        boolean found = false;
        QueueInterface<String> que = new LinkedQueue<String>();
        graph.clearMarks();
        que.add(startVertex);
        while(!que.empty() && found == false)
        {
            String vertex = que.remove();
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
                        que.add(adj.remove());
                    }
                }
            }
        }
        return found;
    }

    public static QueueInterface<Flight> shortestPaths(WeightedGraphInterface<String> graph, 
                                                       String startVertex)
    // Determines the shortest distance from startVertex to every other reachable vertex in graph.
    {
        graph.clearMarks();
        QueueInterface<Flight> result = new LinkedQueue<Flight>();
        QueueInterface<String> vertexs = new LinkedQueue<String>();
        PriorityQueue<Flight> priori = new Heap<Flight>();
        Flight f = new Flight(startVertex, startVertex, 0);
        priori.add(f);
        while(!priori.empty())
        {
            Flight flight = priori.remove();
            String vertex = flight.getToVertex();
            if(!graph.isMarked(flight.getToVertex()))
            {
                graph.markVertex(vertex);
                result.add(flight);
                flight.setFromVertex(flight.getToVertex());
                int minD = flight.getDistance();
                vertexs = graph.getAdjacentVertices(flight.getFromVertex());
                while(!vertexs.empty())
                {
                    vertex = vertexs.remove();
                    if(!graph.isMarked(vertex))
                    {
                        flight.setToVertex(vertex);
                        int d = minD + graph.weightIs(flight.getFromVertex(), vertex);
                        Flight f2 = new Flight(flight.getFromVertex(), vertex, d);
                        priori.add(f2);
                    }
                }
            }
        }
        return result;
    }
}