package academy.kovalevskyi.algorithms.week1.day1;

import java.util.Arrays;

public class XoBoard {
  private XoFigure[][] board;

  public XoBoard() {
    board = new XoFigure[3][3];
  }

  public XoBoard(XoBoard copy) {
    board = new XoFigure[3][3];
    for (int y = 0; y < board.length; y++) {
      board[y] = Arrays.copyOf(copy.board[y], copy.board[y].length);
    }
  }

  public XoBoard(XoFigure[][] xoFigures) {}

  public XoFigure getFigure(int x, int y) {
    return board[y][x];
  }

  public void setFigure(int x, int y, XoFigure figure) {
    board[y][x] = figure;
  }

  public XoFigure hasWinner() {
    // horizontalUpper
    if (getFigure(0, 0) == XoFigure.figureX
        && getFigure(0, 1) == XoFigure.figureX
        && getFigure(0, 2) == XoFigure.figureX) {
      return XoFigure.figureX;
      // horizontalCenter
    } else if (getFigure(1, 0) == XoFigure.figureX
        && getFigure(1, 1) == XoFigure.figureX
        && getFigure(1, 2) == XoFigure.figureX) {
      return XoFigure.figureX;
      // horizontalDown
    } else if (getFigure(2, 0) == XoFigure.figureX
        && getFigure(2, 1) == XoFigure.figureX
        && getFigure(2, 2) == XoFigure.figureX) {
      return XoFigure.figureX;
      // diagonal1
    } else if (getFigure(0, 0) == XoFigure.figureX
        && getFigure(1, 1) == XoFigure.figureX
        && getFigure(2, 2) == XoFigure.figureX) {
      return XoFigure.figureX;
      // diagonal2
    } else if (getFigure(0, 2) == XoFigure.figureX
        && getFigure(1, 1) == XoFigure.figureX
        && getFigure(2, 0) == XoFigure.figureX) {
      return XoFigure.figureX;
      // verticalLeft
    } else if (getFigure(0, 0) == XoFigure.figureX
        && getFigure(1, 0) == XoFigure.figureX
        && getFigure(2, 0) == XoFigure.figureX) {
      return XoFigure.figureX;
      // verticalCenter
    } else if (getFigure(0, 1) == XoFigure.figureX
        && getFigure(1, 1) == XoFigure.figureX
        && getFigure(2, 1) == XoFigure.figureX) {
      return XoFigure.figureX;
      // verticalRight
    } else if (getFigure(0, 2) == XoFigure.figureX
        && getFigure(1, 2) == XoFigure.figureX
        && getFigure(2, 2) == XoFigure.figureX) {
      return XoFigure.figureX;
    }
    // horizontalUpper
    if (getFigure(0, 0) == XoFigure.figureO
        && getFigure(0, 1) == XoFigure.figureO
        && getFigure(0, 2) == XoFigure.figureO) {
      return XoFigure.figureO;
      // horizontalCenter
    } else if (getFigure(1, 0) == XoFigure.figureO
        && getFigure(1, 1) == XoFigure.figureO
        && getFigure(1, 2) == XoFigure.figureO) {
      return XoFigure.figureO;
      // horizontalDown
    } else if (getFigure(2, 0) == XoFigure.figureO
        && getFigure(2, 1) == XoFigure.figureO
        && getFigure(2, 2) == XoFigure.figureO) {
      return XoFigure.figureO;
      // diagonal1
    } else if (getFigure(0, 0) == XoFigure.figureO
        && getFigure(1, 1) == XoFigure.figureO
        && getFigure(2, 2) == XoFigure.figureO) {
      return XoFigure.figureO;
      // diagonal2
    } else if (getFigure(0, 2) == XoFigure.figureO
        && getFigure(1, 1) == XoFigure.figureO
        && getFigure(2, 0) == XoFigure.figureO) {
      return XoFigure.figureO;
      // verticalLeft
    } else if (getFigure(0, 0) == XoFigure.figureO
        && getFigure(1, 0) == XoFigure.figureO
        && getFigure(2, 0) == XoFigure.figureO) {
      return XoFigure.figureO;
      // verticalCenter
    } else if (getFigure(0, 1) == XoFigure.figureO
        && getFigure(1, 1) == XoFigure.figureO
        && getFigure(2, 1) == XoFigure.figureO) {
      return XoFigure.figureO;
      // verticalRight
    } else if (getFigure(0, 2) == XoFigure.figureO
        && getFigure(1, 2) == XoFigure.figureO
        && getFigure(2, 2) == XoFigure.figureO) {
      return XoFigure.figureO;
    }
    return null;
  }

  public boolean tie() {
    if (hasWinner() == null) {
      return false;
    }
    for (int i = 0; i < board.length; i++) {
      if (board[i] != null) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    XoBoard xoBoard = (XoBoard) o;
    return Arrays.deepEquals(this.board, xoBoard.board);
  }

  @Override
  public int hashCode() {
    return Arrays.deepHashCode(board);
  }

  @Override
  public String toString() {
    return "XoBoard{" + "board=" + Arrays.toString(board) + '}';
  }
}
