package academy.kovalevskyi.algorithms.week1.day0;

import java.util.Stack;

public class IntGraphHelper {

  public static GraphBinaryNode<Integer> createNode(Integer value) {
    return new GraphBinaryNode<>(null, null, value);
  }

  public static GraphBinaryNode<Integer> addNode(GraphBinaryNode<Integer> root, Integer value) {
    GraphBinaryNode<Integer> newLeft = null;
    GraphBinaryNode<Integer> newRight = null;
    if (value < root.value()) {
      if (root.left() != null) {
        newLeft = addNode(root.left(), value);
      } else {
        newLeft = new GraphBinaryNode<>(null, copy(root.right()), value);
      }
    }
    if (value > root.value()) {
      if (root.right() != null) {
        newRight = addNode(root.right(), value);
      } else {
        newRight = new GraphBinaryNode<>(copy(root.left()), null, value);
      }
    }
    if (newLeft == null && root.left() != null) {
      newLeft = copy(root.left());
    }
    if (newRight == null && root.right() != null) {
      newRight = copy(root.right());
    }
    return new GraphBinaryNode<>(newLeft, newRight, root.value());
  }

  public static GraphBinaryNode<Integer> copy(GraphBinaryNode<Integer> root) {
    if (root == null) {
      return null;
    }
    return new GraphBinaryNode(copy(root.left()), copy(root.right()), root.value());
  }

  public static boolean contains(GraphBinaryNode<Integer> root, Integer value) {
    if (root == null) {
      return false;
    }
    if (root.value().compareTo(value) < 0) {
      return contains(root.left(), value);
    } else if (root.value().compareTo(value) > 0) {
      return contains(root.right(), value);
    }
    return true;
  }

  public static void printTree(GraphBinaryNode<Integer> rootNode) {
    Stack<GraphBinaryNode<Integer>> globalStack = new Stack<>(); // общий стек для значений дерева
    globalStack.push(rootNode);
    int gaps = 32; // начальное значение расстояния между элементами
    boolean isRowEmpty = false;
    String separator = "-----------------------------------------------------------------";
    System.out.println(separator);
    // черта для указания начала нового дерева
    while (!isRowEmpty) {
      // локальный стек для задания потомков элемента
      Stack<GraphBinaryNode<Integer>> localStack = new Stack<>();
      isRowEmpty = true;

      for (int j = 0; j < gaps; j++) {
        System.out.print(' ');
      }
      while (!globalStack.isEmpty()) {
        // берем следующий, при этом удаляя его из стека
        GraphBinaryNode<Integer> temp = (GraphBinaryNode<Integer>) globalStack.pop();
        if (temp != null) {
          // выводим его значение в консоли
          System.out.print(temp.value());
          // соохраняем в локальный стек, наследники текущего элемента
          localStack.push(temp.left());
          localStack.push(temp.right());
          if (temp.left() != null || temp.right() != null) {
            isRowEmpty = false;
          }
        } else {
          // - если элемент пустой
          System.out.print("__");
          localStack.push(null);
          localStack.push(null);
        }
        for (int j = 0; j < gaps * 2 - 2; j++) {
          System.out.print(' ');
        }
      }
      System.out.println();
      // при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
      gaps /= 2;
      while (!localStack.isEmpty()) {
        // перемещаем все элементы из локального стека в глобальный
        globalStack.push(localStack.pop());
      }
    }
    System.out.println(separator);
  }

  public static void main(String[] args) {
    var leftRight5 = new GraphBinaryNode<Integer>(null, null, 5);
    var leftLeftM2 = new GraphBinaryNode<Integer>(null, null, -2);
    var left2 = new GraphBinaryNode<Integer>(leftLeftM2, leftRight5, 2);
    var right12 = new GraphBinaryNode<Integer>(null, null, 12);
    var root = new GraphBinaryNode<Integer>(left2, right12, 10);
    printTree(root);
    printTree(addNode(root, 7));
    printTree(addNode(root, 13));
  }
}
