package academy.kovalevskyi.algorithms.week0.day1;

public class Tasks {

  public static class Node {
    public Node next;
    public int value;
  }

  public static int findMiddleInOneGo(Node start) {
    Node current = start;
    Node middle = start;
    int length = 0;

    while (current != null) {
      length++;
      if (length % 2 == 0) {
        middle = middle.next;
      }
      current = current.next;
    }
    if (length % 2 == 1) {
      middle = middle.next;
    }
    return middle.value;
  }

  public static boolean hasCycle(Node start) {
    Node turtle = start;
    Node hare = start;
    while (hare != null && hare.next != null) {
      turtle = turtle.next;
      hare = hare.next.next;
      if (turtle == hare) {
        return true;
      }
    }
    return false;
  }
}
