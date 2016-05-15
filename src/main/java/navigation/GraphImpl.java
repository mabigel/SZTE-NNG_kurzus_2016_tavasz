package navigation;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;

import java.io.File;
import java.lang.reflect.*;
import java.util.*;

/**
 * Implement your graph representation here. This class will be instantiated
 * during the unit tests.
 */
public class GraphImpl implements Graph {

	Map<Integer,GraphNode> nodes;
	
	@Override
	public void initializeFromFile(File inputXmlFile) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputXmlFile);

			Element graph = doc.getDocumentElement();
			String temp;
			String tempS[];
			nodes = new HashMap<Integer,GraphNode>();
			List<Edge> myEdges = new ArrayList<Edge>();

			NodeList nodeList = doc.getDocumentElement().getChildNodes();

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node childNode = nodeList.item(i);
				if (childNode.getNodeType() == Node.ELEMENT_NODE) {

					Element nodeElement = (Element)childNode;
					
					if("node".equals(nodeElement.getTagName())) {
						temp = nodeElement.getAttribute("id");
						tempS = nodeElement.getTextContent().trim().split("\n   ");
						//System.out.println(temp);
						//System.out.println(tempS[0] + " : " + tempS[1]);
						GraphNode oneNode = new GraphNode(Integer.parseInt(temp), Double.parseDouble(tempS[1]), Double.parseDouble(tempS[0]));
						nodes.put(Integer.parseInt(temp),oneNode);
						
							
					} else {
						temp = nodeElement.getAttribute("id");
						tempS = nodeElement.getTextContent().trim().split("\n   ");
						//System.out.println(temp);
						//System.out.println(tempS[0] + " : " + tempS[1] + " : " + tempS[2]);
						
						GraphNode start = nodes.get(Integer.parseInt(tempS[0]));
						GraphNode end = nodes.get(Integer.parseInt(tempS[1]));
						Edge oneEdge = new Edge(start, end, Double.parseDouble(tempS[2]));
						start.addNeighbours(oneEdge);
						end.addNeighbours(oneEdge);
						
						myEdges.add(oneEdge);
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return;

	}

	@Override
	public Map<Integer,GraphNode> getNodes() {
		// TODO Auto-generated method stub
		return nodes;
	}

}
