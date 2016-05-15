package navigation;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
	private int id;
	private double x, y;
	private List<Edge> neighbours;
	
	public GraphNode previous;
	public double dist;
	public boolean visited;
	
	public GraphNode(int id) {
		this.id = id;
		neighbours = new ArrayList<Edge>();
	}
    
    public GraphNode(int id, double x, double y) {
    	this.id = id;
    	this.x = x;
    	this.y = y;
		neighbours = new ArrayList<Edge>();
    }
    
    public int getId() {
    	return this.id;
    }
    
    public double getNodex() {
    	return this.x;
    }
    
    public double getNodey() {
    	return this.y;
    }
    public void addNeighbours(Edge e) { 
    	this.neighbours.add(e);
	}
 /*   public List<Edge> setNeighbours(Node node, List<Edge> myEdges) {
    	for(Edge i : myEdges) {
    		if(node.getId() == i.getStart().getId()) {
    			this.neighbours.add(i);
    		}
    	}
    	return this.neighbours;
    }
 */

	public List<Edge> getNeighbours() {
		return this.neighbours;
	}
}
