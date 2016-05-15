package navigation;

public class Edge {
	private GraphNode a, b;
    private double length, time;
    
    public Edge(GraphNode a, GraphNode b, double avgs) {
    	this.a = a;
    	this.b = b;
    	this.length = countLength(a, b);
    	this.time = countTime(this.length,avgs);
    }
    
    public double countLength(GraphNode a, GraphNode b) {
    	
    	return Math.sqrt(Math.pow(a.getNodex() - b.getNodex(), 2) + Math.pow(a.getNodey() - b.getNodey(), 2));
    }
    
    public double countTime(double length, double avgs) {
    	return length / avgs;
    }
    
    public void setLength(double length) {
    	this.length = length;
    }
    
    public double getLength() {
    	return this.length;
    }

    public GraphNode getStart() {
    	return this.a;
    }
    
    public GraphNode getTarget() {
    	return this.b;
    }
    public GraphNode getOtherNode(GraphNode n) {
    	return n==a?b:a;
	}

	public double getTime() {
		// TODO Auto-generated method stub
		return this.time;
	}
}
