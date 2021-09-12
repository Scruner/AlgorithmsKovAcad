package academy.kovalevskyi.algorithms.week1.day1;

import academy.kovalevskyi.algorithms.week1.day0.GraphBinaryNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphHelper2 {

  public static boolean includesDepthFirstSearch(GraphBinaryNode<?> root, Object value) {
    Stack<GraphBinaryNode> dfsStack = new Stack<>();
    dfsStack.push(root);
    while (!dfsStack.isEmpty()) {
      var node = dfsStack.pop();
      if (node.value().equals(value)) {
        return true;
      }
      if (node.left() != null) {
        dfsStack.add(node.left());
      }
      if (node.right() != null) {
        dfsStack.add(node.right());
      }
    }
    return false;
  }

  public static boolean includesBreathFirstSearch(GraphBinaryNode<?> root, Object value) {
    Queue<GraphBinaryNode> bfsQueue = new LinkedList<>();
    bfsQueue.add(root);
    while (!bfsQueue.isEmpty()) {
      var node = bfsQueue.poll();
      if (node.value().equals(value)) {
        return true;
      }
      if (node.left() != null) {
        bfsQueue.add(node.left());
      }
      if (node.right() != null) {
        bfsQueue.add(node.right());
      }
    }
    return false;
  }
}
