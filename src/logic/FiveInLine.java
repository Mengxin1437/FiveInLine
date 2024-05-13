package logic;

/**
 * 实现五子棋的逻辑的抽象类
 */
public abstract class FiveInLine extends Chess {
    @Override
    protected void initBoard(int n) { //初始化棋盘
        board = new Boolean[size+8][size+8]; //为了判断胜负的方便起见
        //当前棋盘是个每个元素都是null的二维数组，正好也对应着未放入棋子的状态
    }

    @Override
    protected int toRealX(int x) {
        return x+3;
    }

    @Override
    protected int toRealY(int y) {
        return y+3;
    }

    //如果五子棋要求有禁手需要重写isMovePositionOk方法

    @Override
    public Boolean isWin(int x, int y){
        x = toRealX(x);
        y = toRealY(y);
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
            return winner;
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
            return winner;
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
            return winner;
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
        return winner;
    }
}
