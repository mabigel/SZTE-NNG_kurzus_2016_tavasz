package navigation;

import java.util.List;

public class DistanceResultImpl extends ResultImpl  implements DistanceResult {
	private double dist;
	
	void setTravelDistanceOfResultPath(double d) {
		dist = d;
	}

	@Override
	public double getTravelDistanceOfResultPath() {
		// TODO Auto-generated method stub
		return dist;
	}

}
