package logic;

/**
 * 黑白棋
 */
public class Reversi extends ChessNP {
    @Override
    public Boolean isWin(int x, int y) {
        //黑白棋的判断胜负方式

        return winner;
    }

    @Override
    public void moveDown(int x, int y) {
        super.moveDown(x, y);
        //导致棋的黑白变换

    }

    @Override
    protected void initBoard(int n) {
        super.initBoard(n);
        //初始放置四个棋子

    }
}
