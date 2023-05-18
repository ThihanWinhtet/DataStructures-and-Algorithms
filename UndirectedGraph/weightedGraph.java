import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class weightedGraph {
    private class Node{
        private String label;
        private List<Edge> edges;

        public Node(String label){
            this.label = label;
        }

        public String toString(){
            return label;
        }

        public void addEdge(Node to, int weight){
            edges.add(new Edge(this, to, weight));
        }
    }

    private class Edge{
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public String toString(){
            return from + "->" + to;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Edge>> adjac = new HashMap<>();

    public void addNode(String label){
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjac.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight){
        var fromNode = nodes.get(from);
        if(fromNode == null){
            System.out.println("from node null");
        }

        var toNode = nodes.get(to);
        if(toNode == null){
            System.out.println("to node null");
        }
        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
        // adjac.get(fromNode).add(new Edge(fromNode, toNode, weight));
        // adjac.get(toNode).add(new Edge(toNode, fromNode, weight));
    }

    public void print(){
        for(var source : adjac.keySet()){
            var target = adjac.get(source);
            if(!target.isEmpty()){
                System.out.println(source + " is connected to " + target);
            }
        }
    }

    private class NodeEntry{
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority){
            this.node = node;
            this.priority = priority;
        }
    }

    public Path getShortestDistance(String from, String to){
        Map<Node, Integer> distance = new HashMap<>();
        for(var node : nodes.values()){
            distance.put(node, Integer.MAX_VALUE);
        }
        Map<Node, Node> previousNode = new HashMap<>();
        distance.replace( nodes.get(from), 0);
        Set<Node> visited = new HashSet<>();
        PriorityQueue<NodeEntry> queues = new PriorityQueue<>(
            Comparator.comparingInt(ne -> ne.priority));
        queues.add(new NodeEntry(nodes.get(from), 0));
        while(!queues.isEmpty()){
            var current = queues.remove().node;
            visited.add(current);

            for(var edge : current.edges){
                if(visited.contains(edge.to)){
                    continue;
                }
                var newdistance = distance.get(current) + edge.weight;
                if(newdistance < distance.get(edge.to)){
                    distance.replace(edge.to, newdistance);
                    previousNode.put(edge.to, current);
                    queues.add(new NodeEntry(edge.to, newdistance));
                }
            }
        }
        Stack<Node> stack = new Stack<>();
        stack.push(nodes.get(to));
        var previous = previousNode.get(nodes.get(to));
        while(previous != null){
            stack.push(previous);
            previous = previousNode.get(previous);
        }

        var path = new Path();
        while(path != null){
            path.add(stack.pop().label);
        }
        return path;
        // return distance.get(nodes.get(to));
    }

    public boolean hasCycle(){
        Set<Node> visited = new HashSet<>();
        for(var node : nodes.values()){
            if(!visited.contains(node)){
                var res = hasCycle(node, null, visited);
                if(res){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited){
        visited.add(node);

        for(var edge : node.edges){
            if(edge.to == parent){
                continue;
            }
            if(visited.contains(edge)){
                return true;
            }
            var res = hasCycle(edge.to, node, visited);
            if(res){
                return true;
            }
        }
        return false;
    }

}
