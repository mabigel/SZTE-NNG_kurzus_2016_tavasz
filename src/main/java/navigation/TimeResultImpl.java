package navigation;

public class TimeResultImpl extends ResultImpl implements TimeResult {
	private double time;
	
	void setTravelTimeOfResultPath(double t) {
		time = t;
	}
	
	@Override
	public double getTravelTimeOfResultPath() {
		// TODO Auto-generated method stub
		return time;
	}

}
