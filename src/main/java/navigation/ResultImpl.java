package navigation;

import java.util.ArrayList;
import java.util.List;

public class ResultImpl implements Result {
	private List<Integer> l;
		
	public ResultImpl() {
		l = new ArrayList<Integer>();
	}
	
	public void addPath(int i) {
		l.add(0,i);
	}
	@Override
	public List<Integer> getResultPath() {
		
		return l;
	}

}
