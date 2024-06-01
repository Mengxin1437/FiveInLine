package Dingzhihua;

import graphic.awt.AwtShow;
import logic.Chess;
import logic.FiveInLine;

public class Machine {
    private Chess chess;

    public Machine(Chess chess, boolean center) {
        this.chess = chess;
        this.center = center;
    }
    public static void main(String[] args) {
        Chess chess = new FiveInLine();
        Machine machine = new Machine(chess);
        AwtShow awtShow = new AwtShow(chess);
    }
//输入人落子坐标 返回人机的坐标
    public void ai(int x,int y){
        board[x][y] = 1;//棋盘有子 ture是人 falee是人机b null为空
        boolean center = Ture;//人下的子
        // 遍历整个棋盘 人机下  （1个子）
        int p = 0;
        if(p<1) {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                // 如果找到空位，则放置当前人机的棋子，并结束方法
                if (board[i][j] == null) {
                    board[i][j] = Ture;
                }
            }
          }
        p=p+1;
        }
        //三个子

        center = board[x][y];
        int count = 0;
        int row = board.length;
        int column = board[0].length;
        //横向
        for(int i=0; i<4; i++){
            if(y+i>=column || board[x][y+i]==null ||
                    !board[x][y+i].equals(center)){
                break;
            }else{
                count++;
            }
        }
        if(count >= 5){
            winner = center;
            return winner;
        }
        if(count>=3){
            if (board[x][y+i] =null)
                board[x][y+i] =Ture;
        }

        for(int i=1; i<5; i++){
            if(y-i<0 || board[x][y-i]==null ||
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
        if(count>=3){
            if (board[x][y-i] =null)
                board[x][y-i] =Ture;

        }


        //纵向
        count = 0;
        for(int i=0; i<5; i++){
            if(x+i>=row || board[x+i][y]==null ||
                    !board[x+i][y].equals(center)){
                break;
            }else{
                count++;
            }
        }
        if(count >= 5){
            winner = center;
            return winner;
        }
        if(count>=3){
            if (board[x+i][y] =null)
                board[x+i][y] =Ture;
        }

        for(int i=1; i<5; i++){
            if(x-i<0 || board[x-i][y]==null ||
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

        if(count>=3){
            if (board[x][y-i] =null)
                board[x][y-i] =Ture;
        }



        //主对角线
        count = 0;
        for(int i=0; i<5; i++){
            if(x+i>=row || y+i>=column || board[x+i][y+i]==null ||
                    !board[x+i][y+i].equals(center)){
                break;
            }else{
                count++;
            }
        }
        if(count >= 5){
            winner = center;
            return winner;
        }
        if(count>=3){
            if (board[x+i][y+i] =null)
                board[x+i][y+i] =Ture;
        }

        for(int i=1; i<5; i++){
            if(x-i<0 || y-i<0 || board[x-i][y-i]==null ||
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
        if(count>=3){
            if (board[x-i][y-i] =null)
                board[x-i][y-i] =Ture;
        }

        //副对角线
        count = 0;
        for(int i=0; i<5; i++){
            if(x+i>=row || y-i<0 || board[x+i][y-i]==null ||
                    !board[x+i][y-i].equals(center)){
                break;
            }else{
                count++;
            }
        }
        if(count >= 5){
            winner = center;
            return winner;
        }
        if(count>=3){
            if (board[x+i][y-i] =null)
                board[x+i][y-i] =Ture;
        }

        for(int i=1; i<5; i++){
            if(x-i<0 || y+i>=column || board[x-i][y+i]==null ||
                    !board[x-i][y+i].equals(center)){
                break;
            }else{
                count++;
            }
        }
        if(count >= 5){
            winner = center;
            return winner;
        }
        if(count>=3){
            if (board[x-i][y+i] =null)
                board[x-i][y+i] =Ture;
        }


    }


}




