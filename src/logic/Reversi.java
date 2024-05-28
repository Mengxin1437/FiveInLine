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
        //黑白棋的判断胜负方法
        try {
//            Boolean isBlackTurn = super.getTurn();// 假设getTurn返回当前是黑棋还是白棋
            if (isMovePositionOk(x,y)) {
                // 如果任何一方还有可下的棋，游戏未结束
                return null;
            }
            int blackCount = countPieces(true); // true 代表黑棋
            int whiteCount = countPieces(false); // false 代表白棋


            if (blackCount > whiteCount) {
                return true; // 黑方胜利
            } else if (whiteCount > blackCount) {
                return false; // 白方胜利
            } else {
                return null;// 未分胜负
            }

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }


    @Override
    public void moveDown(int x, int y) {
        super.moveDown(x, y);
        // 翻转
        List<Point> capturedPositions;
        try {
            capturedPositions = hasFlippablePieces(x, y);
            if (isInBoard(x, y) && isMovePositionOk(x, y)) {
                reverseCapturedPositions(capturedPositions);
                System.out.println("该单次下棋结束");
                capturedPositions.clear(); // 清空记录
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initBoard(int row, int column) {
        super.initBoard(row, column);
        //初始放置四个棋子
        int a = board.length / 2;
        board[a][a] = true;
        board[a - 1][a - 1] = true;
        board[a][a - 1] = false;
        board[a - 1][a] = false;
    }
    //    /**
//     * @return true存在可翻转棋子，false否则
//     */
    @Override
    public boolean isMovePositionOk(int x, int y) {

        boolean isOk = true;
//      List<Point> points = new ArrayList<>();
        try {
            if (hasFlippablePieces(x, y).isEmpty()) {

                isOk = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOk;
    }

    private boolean isInBoard(int x, int y) {
        //用于判断坐标(x, y)是否在棋盘内
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    private void reverseCapturedPositions(List<Point> capturedPositions) {

        for (Point position : capturedPositions) {
            // 遍历并反转每个捕获位置上的棋子
            if (super.getTurn())
                board[position.x][position.y] = false;
            else
                board[position.x][position.y] = true;
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


    private List<Point> hasFlippablePieces(int x, int y) throws Exception {
        //返回可翻转点的集合
        List<Point> points = new ArrayList<>();
        Boolean center = board[x][y];
        int row = board.length;
        int column = board[0].length;
        for (int i = 0; i < 5; i++) {
            //检查路径上是否存在可夹不同棋子
            if (y + i <= column && board[x][y + i] != null &&
                    !board[x][y + i].equals(center)) {
                points.add(new Point(x, y + i));
                //遇到相同棋子时结束
                if (y + i + 1 <= column && board[x][y + i] != null &&
                        board[x][y + 1 + i].equals(center)) {
                    break;
                }
            } else {
                break;
            }
        }
        //纵向向下
        for (int i = 1; i < 5; i++) {
            if (y - i > 0 && board[x][y - i] != null &&
                    !board[x][y - i].equals(center)) {
                points.add(new Point(x, y - i));
                if (y - i - 1 >= 0 && board[x][y - i - 1] != null &&
                        board[x][y - i - 1].equals(center)) {
                    break;
                }

            } else {
                break;
            }
        }
        //横向向右
        for (int i = 0; i < 5; i++) {
            if (x + i <= row && board[x + i][y] != null &&
                    !board[x + i][y].equals(center)) {
                points.add(new Point(x + i, y));
                //遇到相同棋子时结束
                if (x + i + 1 <= row && board[x + 1 + i][y] != null &&
                        board[x][y + 1 + i].equals(center)) {
                    break;
                }
            } else {
                break;
            }
        }
        //横向向左
        for (int i = 1; i < 5; i++) {
            if (x - i > 0 || board[x - i][y] != null ||
                    !board[x - i][y].equals(center)) {
                points.add(new Point(x - i, y));
                if (x - i - 1 >= 0 && board[x - 1 - i][y] != null &&
                        board[x - i - 1][y].equals(center)) {
                    break;
                }
            } else {
                break;
            }
        }
        //主对角线 右上
        for (int i = 0; i < 5; i++) {
            if (x + i <= row && y + i <= column && board[x + i][y + i] != null &&
                    !board[x + i][y + i].equals(center)) {
                points.add(new Point(x + i, y + i));
                if (x + i + 1 <= row && y + i + 1 <= column && board[x + i + 1][y + i + 1] != null
                        && board[x + i + 1][y + i + 1].equals(center)) {
                    break;
                }
            } else {
                break;
            }
        }
        //左下
        for (int i = 0; i < 5; i++) {
            if (x - i >= 0 && y - i >= 0 && board[x - i][y - i] != null
                    && !board[x - i][y - i].equals(center)) {
                points.add(new Point(x - i, y - i));
                if (x - i - 1 >= 0 && y - i - 1 >= 0 && board[x - i - 1][y - i - 1] != null
                        && board[x - i - 1][y - i - 1].equals(center)) {
                    break;
                }
            } else {
                break;
            }
        }
        //副对角线 右下
        for (int i = 0; i < 5; i++) {
            if (x + i <= row && y - i >= 0 && board[x + i][y - i] != null
                    && !board[x + i][y - i].equals(center)) {
                points.add(new Point(x + i, y - i));
                if (x + i + 1 <= row && y - i - 1 >= 0 && board[x + i + 1][y - i - 1] != null
                        && board[x + i + 1][y - i - 1].equals(center)) {
                    break;
                }

            } else {
                break;
            }
        }
        //副对角线 左上
        for (int i = 1; i < 5; i++) {
            if (x - i >= 0 && y + i <= column && board[x - i][y + i] != null
                    && !board[x - i][y + i].equals(center)) {
                points.add(new Point(x - i, y + i));
                if (x - i - 1 >= 0 && y + i + 1 <= column && board[x - i][y + i] != null
                        && board[x - i][y + i].equals(center)) {
                    break;
                }
            } else {
                break;
            }
        }
        return points;
    }
}
//    public Boolean isWin(int x, int y) {
//        //黑白棋的判断胜负方法
//        int blackCount = 0, whiteCount = 0;
//        Boolean hwfalg = super.getTurn();
//        int i = 0;
//        int j = 0;
//        while (board[i][j] != null && !isMovePositionOk(i, j)) {
//            for ( i = 0; i < board.length; i++) {
//                for (i = 0; j < board[0].length; j++) {
//                    if (hwfalg ==super.getTurn()) blackCount++;
//                    else whiteCount++;
//                }
//            }
//        }
//        Boolean winner1 = black;
//        Boolean winner2 = white;
//        if (blackCount > whiteCount) return winner1; // 黑方胜利
//        else (whiteCount > blackCount) return winner2;// 白方胜利
//    }
//        for (int dx = -1; dx <= 1; dx++) {
//            for (int dy = -1; dy <= 1; dy++) {
//                if (dx == 0 && dy == 0) continue;
//                int nx = x + dx;
//                int ny = y + dy;
//                if (board[nx][ny]!=super.getTurn()
//                    &&isMovePositionOk(x, y)) {
//                    int[] direction = {nx, ny};
//                    // 追踪并记录捉子路径
//                    while (isInBoard(nx, ny)
//                           && hasFlippablePieces(nx, ny,direction )) {
//                        capturedPositions.add(direction.clone());
//                        nx += dx;
//                        ny += dy;
//                    }
//                    // 翻转路径上被捉住的棋子
//                    reverseCapturedPositions(capturedPositions);
//                    System.out.println("该单次下棋结束");
//                    capturedPositions.clear(); // 清空记录
//                }
//            }
//        }
//纵向向上

//        while (isOk) {
//            if(( points = hasFlippablePieces(x, y, points))==null);
//           isOk = false;
//
//        }
//        return isOk;

//        if (!super.isMovePositionOk(x, y)) return false; // 先检查基础合法性
//
//        // 简化逻辑：检查上下左右是否有对手棋子可以翻转，实际应检查所有八个方向
//        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1},{-1,-1},{-1,1},{1,-1},{1,1}}; // 八个方向
//        for (int[] direction : directions) {
//            int newX = x + direction[0], newY = y + direction[1];
//            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
//                if (board[newX][newY] != turn && hasFlippablePieces(newX, newY, direction)) {
//                    System.out.println("已经判断位置合法");
//                    return true;
//                }
//            }
//        }
//
//        return false; // 无法翻转任何棋子

//    @Override
//    public boolean isMovePositionOk(int x, int y) {
//        if(!super.isMovePositionOk(x, y)) return false;
//        boolean result = false;
//        //合法性判断
//        for (int dx = -1; dx <= 1; dx++) {
//            for (int dy = -1; dy <= 1; dy++) {
//                int nx = x + dx;
//                int ny = y + dy;
//                if (isInBoard(nx, ny)
//                    && board[nx][ny] != null
//                    && board[nx][ny] != super.getTurn()) {
//                   result = true;
//                   break;
//                }
//
//            }
//        }
//        return  result;
//    }
//    private boolean hasOppositeBetween(int x1, int y1, int x2, int y2) {
//        //判断在棋盘上是否存在与给定两个坐标(x1, y1)和(x2, y2)之间且与当前轮到的棋子颜色相反的棋子。
//        // 具体实现是通过计算(x2, y2)到(x1, y1)的直线上的若干个点的坐标，
//        // 检查每个点上是否存在棋子，若存在且颜色与当前轮到的棋子颜色相反，则返回true，否则返回false。
//        int dx = x2 - x1;
//        int dy = y2 - y1;
//        int steps = Math.abs(dx) > Math.abs(dy) ? Math.abs(dx) : Math.abs(dy);
//        for (int i = 1; i < steps; i++) {
//            int nx = x1 + i * dx / steps;
//            int ny = y1 + i * dy / steps;
//            if (board[nx][ny] != null && board[nx][ny] != turn) {
//                return true;
//            }
//        }
//        return false;
//    }
//    private static class point extends Point {
//        public point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//        int x = startX + direction[0], y = startY + direction[1];
//        while (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
//            if (board[x][y] == null) return false; // 遇到空位停止
//            if (board[x][y] == turn) return true; // 遇到自己的棋子，说明有可翻转的对手棋子
//            x += direction[0]; y += direction[1]; // 继续探索
//        }
//        System.out.println("以判断是否可以反转");
//        return false; // 未遇到自己的棋子，不可翻转
//    }
//



