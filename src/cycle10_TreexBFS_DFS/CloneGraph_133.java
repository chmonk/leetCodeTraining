package cycle10_TreexBFS_DFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CloneGraph_133 {

//	BFS
	public Node cloneGraph_BFS(Node node) {

	        if (node == null)
	            return node;

	        // place the old node waiting to copy
	        Deque<Node> processList = new LinkedList<>();

	        // map old node: copy node
	        Map<Node, Node> map = new HashMap<>();

	        processList.add(node);

	        map.put(node, new Node(node.val));

	        while (!processList.isEmpty()) {

	            Node cur = processList.poll();

	            for (Node n : cur.neighbors) {

	                Node test = map.get(n);

	                if (test == null) {
	                    Node copy = new Node(n.val);
	                    // wait to deep copy
	                    processList.add(n);

	                    // record the old & new
	                    map.put(n, copy);

	                    // build the neighbor list
	                    map.get(cur).neighbors.add(copy);
	                } else {
	                    // build the neighbor list
	                    map.get(cur).neighbors.add(test);
	                }

	            }

	        }
	        return map.get(node);
	    }

	// DFS
	Map<Node, Node> record = new HashMap<>();

	// depth first
	public Node cloneGraph_DFS(Node node) {

		if (node == null)
			return null;

		Node cur = record.get(node);

		if (cur == null) {

			Node copy = new Node(node.val);
			record.put(node, copy);

			// build neighbor
			for (Node n : node.neighbors) {
				copy.neighbors.add(cloneGraph_DFS(n));
			}

		} else {
			return cur;
		}

		return record.get(node);

	}
	
	
	class Node {
	    public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}

}
