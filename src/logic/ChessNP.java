package logic;

/**
 * 如果棋类设计时用户认为的坐标到程序里的坐标不需要改变请继承这个类
 * 其它同Chess类
 */
public abstract class ChessNP extends Chess {
    @Override
    protected final void initBoard(int n) {
        board = new Boolean[size+1][size+1];
    }

    @Override
    protected final int toRealX(int x) {
        return x;
    }

    @Override
    protected final int toRealY(int y) {
        return y;
    }

}
