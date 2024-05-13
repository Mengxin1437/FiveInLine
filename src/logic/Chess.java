package logic;

/**
 * 棋类(黑棋和白棋，轮流下的棋类，棋盘是方格)，横纵坐标都是从1开始
 * 如果棋类设计时用户认为的坐标到程序里的坐标需要改变请继承这个类
 *  * 用true表示黑棋，false表示白棋 null表示棋盘的空位置
 *  * turn为true时表示轮到黑方落子
 *  * winner为null时表示游戏还未结束，true黑方赢，false白方赢
 */
public abstract class Chess {
    protected Boolean turn; //当前轮到黑方还是白方下棋
    protected Boolean[][] board; //棋盘的状态
    protected Integer size;//棋盘的大小
    protected Boolean winner; //胜利方

    public Boolean getTurn() {
        return turn;
    }

    //初始化游戏
    public void init(int n){
        this.size = n;
        winner = null; //初始化胜利者为空
        turn = true; //黑方先
        //初始化棋盘
        initBoard(n);
    }

    //初始化棋盘
    protected abstract void initBoard(int n);

    /**
     * 需要用户在落子前进行判断是否合法 一般来说落子点必须在范围内并为空
     * 如果子类有新的要求则需要重写并调用super.isMovePositionOk来判断是否合法
     * @param x 用户程序认为的横坐标[1,size]
     * @param y 用户程序认为的纵坐标
     * @return true合法
     */
    public boolean isMovePositionOk(int x, int y){
        //判断范围是否合法
        if(x<1 || x>size) return false;
        if(y<1 || y>size) return false;
        int realX = toRealX(x);
        int realY = toRealY(y);
        //判断落子点是否为空
        return board[realX][realY] == null;
    }

    protected abstract int toRealX(int x);
    protected abstract int toRealY(int y);
    public void moveDown(int x, int y){
        int realX = toRealX(x);
        int realY = toRealY(y);
        board[realX][realY] = turn;
        turn = !turn;
    }

    /**
     * 从落子点出发判断游戏是否结束
     * @param x 用户程序认为的横坐标
     * @param y 用户程序认为的纵坐标
     * @return null未结束 true黑方胜利 false白方胜利
     */
    public abstract Boolean isWin(int x, int y);
}
