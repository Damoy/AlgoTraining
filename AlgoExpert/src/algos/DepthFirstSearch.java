package algos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch {

  public static class Node {
    public String name;
    public List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }
    
    // Time O(V+E) | Space O(V)
    public List<String> depthFirstSearch(List<String> array) {
      Set<String> visited = new HashSet<>();
      Stack<Node> stack = new Stack<>();
      stack.push(this);
      Node currentNode;
      
      while(!stack.isEmpty()) {
        currentNode = stack.pop();
        
        if(!visited.contains(currentNode.name)) {
          array.add(currentNode.name);
          visited.add(currentNode.name);
        }
        
        for(int i = currentNode.children.size() - 1; i >= 0; --i) {
          if(!visited.contains(currentNode.children.get(i).name)) {
            stack.push(currentNode.children.get(i));
          }
        }
      }
      
      return array;
    }

    public Node addChild(String name) {
      Node child = new Node(name);
      children.add(child);
      return this;
    }
    
    public Node addChild(Node child) {
      children.add(child);
      return this;
    }
  }
  
}
