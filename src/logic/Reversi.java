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
        return  null;
        //黑白棋的判断胜负方法
//        try {
////            Boolean isBlackTurn = super.getTurn();// 假设getTurn返回当前是黑棋还是白棋
//            if (isMovePositionOk(x,y)) {
//                // 如果任何一方还有可下的棋，游戏未结束
//                return null;
//            }
//            int blackCount = countPieces(true); // true 代表黑棋
//            int whiteCount = countPieces(false); // false 代表白棋
//
//
//            if (blackCount > whiteCount) {
//                return true; // 黑方胜利
//            } else if (whiteCount > blackCount) {
//                return false; // 白方胜利
//            } else {
//                return null;// 未分胜负
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//            return null;
//        }
    }

    @Override
    public void moveDown(int x, int y) {
        super.moveDown(x, y);
        System.out.println(board[x][y]);
        // 翻转
        List<Point> capturedPositions;
        capturedPositions = hasFlippablePieces(x, y);
        //翻转记录的棋
        reverseCapturedPositions(capturedPositions);
    }

    @Override
    protected void initBoard(int row, int column) {
        if(row == 0 && column == 0) {
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
        if(!super.isMovePositionOk(x, y)) return false;
        board[x][y] = turn;
        List<Point> sets = hasFlippablePieces(x, y);
        if(sets.isEmpty()){
            board[x][y] = null;
            return false;
        }else{
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

    private List<Point> hasFlippablePieces(int x, int y) {
        //返回可翻转点的集合
        List<Point> points = new ArrayList<>();
        List<Point> temp = new ArrayList<>();
//        System.out.println(board[x][y]);
        Boolean center = board[x][y];
        int row = board.length;
        int column = board[0].length;
        for (int i = 1; ; i++) {
            //横向向右
            if (y + i < column && board[x][y + i] != null) {
                if (!board[x][y + i].equals(center)) {
                    temp.add(new Point(x, y + i));
                    System.out.println(board[x][y+i]+"  "+center);
                    System.out.println("横向向右1个");
                } else {//遇到相同棋子结束
                    System.out.println(1);
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


