/*
// Definition for a Node.
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
*/

class Solution {
//     public Node cloneGraph(Node node) {
        
//         HashMap<Integer, Node> visitedNodes = new HashMap<>();
//         return dfsClone(node, visitedNodes);
//     }
    
//     public Node dfsClone(Node node, HashMap<Integer, Node> visitedNodes){
//         if (node == null){
//             return null;
//         }
//         if(visitedNodes.containsKey(node.val)){
//             return visitedNodes.get(node.val);
//         }
        
//         Node clone = new Node(node.val);
//         visitedNodes.put(node.val, clone);
        
//         for (Node neighbor: node.neighbors){
//             clone.neighbors.add(dfsClone(neighbor, visitedNodes));
//         }
//         return clone;
//     }
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        HashMap<Node, Node> visited = new HashMap<>();
        Node newNode = new Node(node.val);
        visited.put(node, newNode);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            List<Node> newNeighbors = visited.get(cur).neighbors;
            for (Node n : cur.neighbors) {
                if (!visited.containsKey(n)) {
                    visited.put(n, new Node(n.val));
                    queue.offer(n);
                }
                newNeighbors.add(visited.get(n));
            }
        }

        return newNode;
    }
}