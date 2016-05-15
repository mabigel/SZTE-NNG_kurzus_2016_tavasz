package navigation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Implement your navigation algorithm here. This class will be instantiated
 * during the unit tests.
 */
public class AlgorithmImpl implements Algorithm {

	Graph myGraph;
	@Override
	public void preprocess(Graph graph) {
		// TODO Auto-generated method stub
		myGraph = graph;
	}

	@Override
	public DistanceResult findShortestPath(int startNodeId,
			int destinationNodeId) {
		// TODO Auto-generated method stub
		return (DistanceResult)Dijkstra(startNodeId,  destinationNodeId, myGraph,true);
	}

	@Override
	public TimeResult findFastestPath(int startNodeId, int destinationNodeId) {
		// TODO Auto-generated method stub
		return (TimeResult)Dijkstra(startNodeId,  destinationNodeId, myGraph,false);
	}

	@Override
	public boolean hasPath(int startNodeId, int destinationNodeId) {
		// TODO Auto-generated method stub
		return Double.POSITIVE_INFINITY!=((DistanceResultImpl)Dijkstra(startNodeId,  destinationNodeId, myGraph,true)).getTravelDistanceOfResultPath();
	}
	
	public Result Dijkstra(int source, int target, Graph mygraph,boolean DistanceTime) {
		Set<GraphNode> Q = new HashSet<GraphNode>();
		Iterator it = mygraph.getNodes().entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        GraphNode n = (GraphNode)pair.getValue();
	        n.dist=(n.getId() != source)?Double.POSITIVE_INFINITY:0;
	        n.previous=null;
	        Q.add(n);
	    }
	    while (!Q.isEmpty()) {
	    	
	    	GraphNode u = null;
	    	for (GraphNode node : Q) {	    		
	    		if (u==null || u.dist>node.dist)
	    			u=node;
	    	}
	    	
	    	if (u.dist == Double.POSITIVE_INFINITY) {
	    		break;
	    	}
	    	Q.remove(u);
	    
	    	for (Edge v : u.getNeighbours()) {
	    		double alt = u.dist + (DistanceTime?v.getLength():v.getTime());
	    		if (alt < v.getOtherNode(u).dist) {
	    			v.getOtherNode(u).dist = alt;
	    			v.getOtherNode(u).previous = u;
	    		}
	    	}
	    }
	    Result d;
	    if (DistanceTime) {
	    	d=new DistanceResultImpl();
	    	((DistanceResultImpl)d).setTravelDistanceOfResultPath(mygraph.getNodes().get(target).dist);
	    } else  {
	    	d=new TimeResultImpl();
	    	((TimeResultImpl)d).setTravelTimeOfResultPath(mygraph.getNodes().get(target).dist);
	    }
	    	GraphNode n = mygraph.getNodes().get(target);
	    	while (n!=null) { 
	    		//System.out.println(n.getId());
	    		((ResultImpl)d).addPath(n.getId());
	    		n=n.previous;
	    	}
	    return d;
	}
}
