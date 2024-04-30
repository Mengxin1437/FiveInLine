/**
 * 实现五子棋的逻辑的抽象类，不提供展示方法
 * 用true表示黑棋，false表示白棋 null表示棋盘的空位置
 * turn为true时表示轮到黑方落子
 * winner为null时表示游戏还未结束，true黑方赢，false白方赢
 */
public abstract class FiveInLine {
    private Boolean turn; //当前轮到黑方还是白方下棋
    protected Boolean[][] board; //棋盘的状态
    protected Integer size;//棋盘的大小
    private Boolean winner; //胜利方
    /**
     * 初始化游戏
     */
    public void init(){
        this.init(16);
    }

    /**
     * 初始化游戏
     * @param n 棋盘的大小
     */
    public void init(int n){
        this.size = n;
        winner = null; //初始化胜利者为空
        turn = true; //黑方先
        //初始化棋盘
        board = new Boolean[size+8][size+8]; //为了判断胜负的方便起见
        //当前棋盘是个每个元素都是null的二维数组，正好也对应着未放入棋子的状态
    }

    /**
     * 需要用户在落子前进行判断是否合法
     * @param x 用户程序认为的横坐标[1,size]
     * @param y 用户程序认为的纵坐标
     * @return true合法
     */
    private boolean isMovePositionOk(int x, int y){
        //判断范围是否合法
        if(x<1 || x>size) return false;
        if(y<1 || y>size) return false;
        //实际的对应到board改变的点
        int realX = x+3;
        int realY = y+3;
        //判断落子点是否为空
        return board[realX][realY] == null;
    }

    /**
     * 落子并判断游戏是否结束
     * @param x 用户程序认为的横坐标
     * @param y 用户程序认为的纵坐标
     * @return null未结束 true黑方胜利 false白方胜利
     */
    private Boolean moveChessman(int x, int y){
        //实际的对应到board改变的点
        int realX = x+3;
        int realY = y+3;
        board[realX][realY] = turn;
        turn = !turn;
        this.isWin(realX, realY);
        return this.winner;
    }

    //内部的每次落子后从落子点出发用于判断胜负的方法，修改this.winner的值
    private void isWin(int x, int y){
        //刚落下的是黑子还是白子
        boolean center = board[x][y];
        int count = 0;
        //横向
        for(int i=0; i<5; i++){
            if(board[x][y+i]==null ||
                    !board[x][y+i].equals(center)){
                break;
            }else{
                count++;
            }
        }
        for(int i=1; i<5; i++){
            if(board[x][y-i]==null ||
                    !board[x][y-i].equals(center)){
                break;
            }else{
                count++;
            }
        }
        if(count >= 5){
            winner = center;
            return;
        }
        //纵向
        count = 0;
        for(int i=0; i<5; i++){
            if(board[x+i][y]==null ||
                    !board[x+i][y].equals(center)){
                break;
            }else{
                count++;
            }
        }
        for(int i=1; i<5; i++){
            if(board[x-i][y]==null ||
                    !board[x-i][y].equals(center)){
                break;
            }else{
                count++;
            }
        }
        if(count >= 5){
            winner = center;
            return;
        }
        //主对角线
        count = 0;
        for(int i=0; i<5; i++){
            if(board[x+i][y+i]==null ||
                    !board[x+i][y+i].equals(center)){
                break;
            }else{
                count++;
            }
        }
        for(int i=1; i<5; i++){
            if(board[x-i][y-i]==null ||
                    !board[x-i][y-i].equals(center)){
                break;
            }else{
                count++;
            }
        }
        if(count >= 5){
            winner = center;
            return;
        }
        //副对角线
        count = 0;
        for(int i=0; i<5; i++){
            if(board[x+i][y-i]==null ||
                    !board[x+i][y-i].equals(center)){
                break;
            }else{
                count++;
            }
        }
        for(int i=1; i<5; i++){
            if(board[x-i][y+i]==null ||
                    !board[x-i][y+i].equals(center)){
                break;
            }else{
                count++;
            }
        }
        if(count >= 5){
            winner = center;
        }
    }

    /**
     * 显示棋盘或更新界面
     */
    protected abstract void showBoard();

    /**
     * 获取横坐标的输入
     * @return 横坐标
     */
    protected abstract int getX();

    /**
     * 获取纵坐标的输入
     * @return 纵坐标
     */
    protected abstract int getY();

    /**
     * 当输入的位置不合法时的提示信息
     */
    protected abstract void positionNotAllowedInfo();

    /**
     * 显示胜利信息
     */
    protected abstract void showWinner(Boolean result);

    //游戏循环
    public void gameLoop(){
        showBoard();
        while (true){
            int x = getX();
            int y = getY();
            if(isMovePositionOk(x, y)){
                Boolean result = moveChessman(x, y);
                showBoard();
                if(result != null){
                    showWinner(result);
                    return;
                }
            }else{
                positionNotAllowedInfo();
            }
        }
    }
    public Boolean getTurn() {
        return turn;
    }
}
