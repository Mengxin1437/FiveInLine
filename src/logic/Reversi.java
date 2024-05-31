package logic;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 黑白棋
 */
public class Reversi extends Chess {
    @Override
    public Boolean isWin(int x, int y) {
//        Boolean center = super.getTurn();
////        boolean noMoveForCurrent = hasMovePieces(center ? 2 : 1, x, y);
////        boolean noMoveForOpponent = hasMovePieces(center ? 1 : 2, x, y);
////        if (noMoveForCurrent && noMoveForOpponent) {
//        if (blackCount == whiteCount) {
//            return null; // 平局
//        } else if (!center && blackCount > whiteCount) {
//            return true;
//        } else if (center && whiteCount > blackCount) {
//            return false;
//        }
////        }

        //循环判断棋盘上每一个空位，如果有可以下的位置就跳出循环，返回null; 否则如果每个空位都判断不能下棋
        //turn = !turn 判断另一方能不能下，。。。如果也不能下则游戏结束，清点各方棋子数

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //如果有棋子，这个位置不判断
                if (board[i][j] != null) continue;

                if (isMovePositionOk(i, j)) { //有可以下的位置
                    return null;
                }
            }
        }
        //执行到这个位置说明无子可下

        turn = !turn; //交换回合判断对方
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //如果有棋子，这个位置不判断
                if (board[i][j] != null) continue;

                if (isMovePositionOk(i, j)) { //有可以下的位置
                    return null;
                }
            }
        }
        //执行到这个位置说明双方都无子可下

        //清点棋子数判断胜负
        int blackCount = countPieces(true); // true 代表黑棋
        int whiteCount = countPieces(false); // false 代表白棋
        if (blackCount > whiteCount) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void moveDown(int x, int y) {
        super.moveDown(x, y);
        System.out.println(board[x][y]);
        // 翻转
        List<Point> capturedPositions;
        capturedPositions = hasFlippablePieces(x, y);
        reverseCapturedPositions(capturedPositions);
    }


    @Override
    protected void initBoard(int row, int column) {
        if (row == 0 && column == 0) {
            // 如果未指定大小，使用默认值
            row = board.length;
            column = board[0].length;
        }
        super.initBoard(row, column);
        //初始放置四个棋子
        int a = board.length / 2;
        board[a][a] = true;
        board[a - 1][a - 1] = true;
        board[a][a - 1] = false;
        board[a - 1][a] = false;
    }

    @Override
    public boolean isMovePositionOk(int x, int y) {
        if (!super.isMovePositionOk(x, y)) return false;
        board[x][y] = turn;
        List<Point> sets = hasFlippablePieces(x, y);
        if (sets.isEmpty()) {
            board[x][y] = null;
            return false;
        } else {
            board[x][y] = null;
            return true;
        }
    }

    private void reverseCapturedPositions(List<Point> capturedPositions) {

        for (Point position : capturedPositions) {
            //将改动过的棋子均放入操作链表里
            operations.getLast().add(new Operation(position, board[position.x][position.y]));
            // 遍历并反转每个捕获位置上的棋子
            board[position.x][position.y] = !super.getTurn();
        }
        System.out.println("已经遍历翻转棋子");
    }

    // 计算指定颜色的棋子数量
    private int countPieces(Boolean color) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == color) {
                    count++;
                }
            }
        }
        return count;
    }


    private List<Point> hasFlippablePieces(int x, int y) {
        //返回可翻转点的集合
        List<Point> points = new ArrayList<>();
        List<Point> temp = new ArrayList<>();
        Boolean center = board[x][y];
        int row = board.length;
        int column = board[0].length;
        for (int i = 1; ; i++) {
            //横向向右
            if (y + i < column && board[x][y + i] != null) {
                if (!board[x][y + i].equals(center)) {
                    temp.add(new Point(x, y + i));
                } else {//遇到相同棋子结束
                    points.addAll(temp);
                    break;
                }
            } else {
                break;
            }
        }
        temp.clear();

        //横向向左
        for (int i = 1; ; i++) {
            if (y - i >= 0 && board[x][y - i] != null) {
                if (!board[x][y - i].equals(center)) {
                    temp.add(new Point(x, y - i));
                } else {
                    points.addAll(temp);
                    break;
                }
            } else {
                break;
            }
        }
        temp.clear();

        //纵向向上
        for (int i = 1; ; i++) {
            if (x + i < row && board[x + i][y] != null) {
                if (!board[x + i][y].equals(center)) {
                    temp.add(new Point(x + i, y));
                } else {
                    points.addAll(temp);
                    break;
                }
            } else {
                break;
            }
        }
        temp.clear();
        //纵向向下
        for (int i = 1; ; i++) {
            if (x - i >= 0 && board[x - i][y] != null) {
                if (!board[x - i][y].equals(center)) {
                    temp.add(new Point(x - i, y));
                } else {
                    points.addAll(temp);
                    break;
                }
            } else {
                break;
            }
        }
        temp.clear();
        //主对角线 右上
        for (int i = 1; ; i++) {
            if (x + i < row && y + i < column && board[x + i][y + i] != null) {
                if (!board[x + i][y + i].equals(center)) {
                    temp.add(new Point(x + i, y + i));
                } else {
                    points.addAll(temp);
                    break;
                }
            } else {
                break;
            }
        }
        temp.clear();
        //左下
        for (int i = 1; ; i++) {
            if (x - i >= 0 && y - i >= 0 && board[x - i][y - i] != null) {
                if (!board[x - i][y - i].equals(center)) {
                    temp.add(new Point(x - i, y - i));
                } else {
                    points.addAll(temp);
                    break;
                }
            } else {
                break;
            }
        }
        temp.clear();
        //副对角线 右下
        for (int i = 1; ; i++) {
            if (x - i >= 0 && y + i < column && board[x - i][y + i] != null) {
                if (!board[x - i][y + i].equals(center)) {
                    temp.add(new Point(x - i, y + i));
                } else {
                    points.addAll(temp);
                    break;
                }
            } else {
                break;
            }
        }
        temp.clear();
        //副对角线 左上
        for (int i = 1; ; i++) {
            if (x + i < row && y - i >= 0 && board[x + i][y - i] != null) {
                if (!board[x + i][y - i].equals(center)) {
                    temp.add(new Point(x + i, y - i));
                } else {
                    points.addAll(temp);
                    break;
                }
            } else {
                break;
            }
        }
        temp.clear();
        return points;
    }
}



