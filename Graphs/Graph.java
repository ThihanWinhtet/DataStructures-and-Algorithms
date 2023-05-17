import java.beans.Visibility;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
    private class Node{
        private String label;

        public Node(String label){
            this.label = label;
        }

        public String toString(){
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjac = new HashMap<>();

    public void addNode(String label){
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjac.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to){
        var fromNode = nodes.get(from);
        if(fromNode == null){
            System.out.println("from node null");
        }

        var toNode = nodes.get(to);
        if(toNode == null){
            System.out.println("to node null");
        }
        adjac.get(fromNode).add(toNode);
        adjac.get(toNode).add(fromNode);
    }

    public void print(){
        for(var source : adjac.keySet()){
            var target = adjac.get(source);
            if(!target.isEmpty()){
                System.out.println(source + " is connected to " + target);
            }
        }
    }

    public void remove(String label){
        var node = nodes.get(label);

        for(var n : adjac.keySet()){
            adjac.get(n).remove(node);
            nodes.remove(node);
        }
    }

    public void removeEdges(String from, String to){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if(fromNode == null || toNode == null){
            return;
        }
        adjac.get(fromNode).remove(toNode);
        adjac.get(toNode).remove(fromNode);
    }

    public void traverseDepthFirst(String root){
        var node = nodes.get(root);
        if(node == null){
            return;
        }
        traverseDepthFirst(node, new HashSet<>());
    }

    private void traverseDepthFirst(Node root, Set<Node> vistied){
        System.out.println(root);
        vistied.add(root);

        for(var node : adjac.get(root)){
            if(!vistied.contains(node)){
                traverseDepthFirst(node, vistied);
            }
        }
    }

    public void traverseDepthFirstLit(String root){
        var node = nodes.get(root);
        if(node==null){
            return;
        }
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            var current = stack.pop();
            if(visited.contains(current)){
                continue;
            }
            System.out.println(current);
            visited.add(current);

            for(var neigh : adjac.get(current)){
                if(!visited.contains(neigh)){
                    stack.push(neigh);
                }
            }
        }
    }

    public void traverseBreadthFirst(String root){
        var node = nodes.get(root);
        if(node == null){
            return;
        }
        
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while(!queue.isEmpty()){
            var current = queue.remove();
            if(visited.contains(current)){
                continue;
            }

            System.out.println(current);
            visited.add(current);

            for(var neigh : adjac.get(current)){
                if(!visited.contains(neigh)){
                    queue.add(neigh);
                }
            }
        }
    }

    public boolean hasCycle(){
        Set<Node> all = new HashSet<>();
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        
        all.addAll(nodes.values());
        while(!all.isEmpty()){
            var current = all.toArray(new Node[0])[0];
            var res = hasCycle(current, all, visiting, visited);
            if(res){
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited){
        all.remove(node);
        visiting.add(node);

        for(var neigh : adjac.get(node)){
            if(visited.contains(neigh)){
                continue;
            }
            if(visiting.contains(neigh)){
                return true;
            }
            if(hasCycle(neigh, all, visiting, visited)){
                return true;
            }
        }
        visiting.remove(node);
        visited.add(node);
        return false;
    }
    
}
