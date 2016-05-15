package navigation;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface Graph {

	/**
	 * Implement your graph construction here using an xml file of predefined
	 * format, see project_root_dir/graph.xml
	 *
	 * @param inputXmlFile
	 *            the xml file containing the graph data
	 */
	public void initializeFromFile(File inputXmlFile);
	
	public Map<Integer,GraphNode> getNodes();
}
