package logic;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Go extends Chess{
    @Override
    public Boolean isWin(int x, int y) {
        return null;
    }

    @Override
    public boolean isMovePositionOk(int x, int y) {
        return super.isMovePositionOk(x, y);
    }

    @Override
    public void moveDown(int x, int y) {
        super.moveDown(x, y); //会直接改变board并交换turn

        ArrayList<Point> around = getAllAround(x, y);
        for(Point p: around){
            if(board[p.x][p.y] != null && board[p.x][p.y] != board[x][y]){//敌方棋子
                HashSet<Point> tribe = getTribe(p.x, p.y);
                HashSet<Point> gas = getGas(tribe);
                if(gas.isEmpty()){ //敌方棋子没气了
                    //提子
                    for(Point pt: tribe){
                        board[pt.x][pt.y] = null;
                    }
                }
            }
        }
    }

    /**
     * 从一个确认有棋子的点出发获取它所属部落的所有点的集合
     */
    private HashSet<Point> getTribe(int r, int c){
        HashSet<Point> points = new HashSet<>();
        points.add(new Point(r, c)); //添加第一个点
        dg(points, r, c);
        return points;
    }
    //下面这个方法是给上面方法递归调用的
    private void dg(HashSet<Point> points, int r, int c){
        boolean self = board[r][c];
        ArrayList<Point> around = getAllAround(r, c);
        for(Point pnt: around){
            if(board[pnt.x][pnt.y]!=null && board[pnt.x][pnt.y]==self && !points.contains(pnt)){
                points.add(pnt);
                dg(points, pnt.x, pnt.y); //保证每个点只被递归过一次
            }
        }
    }

    /**
     * 获取一个部落所有的气
     */
    private HashSet<Point> getGas(HashSet<Point> tribe){
        HashSet<Point> gas = new HashSet<>();
        for(Point pnt: tribe){
            ArrayList<Point> around = getAllAround(pnt.x, pnt.y);
            for(Point p: around){
                if(board[p.x][p.y]==null){
                    gas.add(p);
                }
            }
        }
        return gas;
    }

    /**
     * 获取一个点四周的点，排除超界的点
     * @param r 这个点的行
     * @param c 这个点的列
     * @return 四周的点的集合
     */
    private ArrayList<Point> getAllAround(int r, int c){
        ArrayList<Point> points = new ArrayList<>();
        int height = board.length;
        int width = board[0].length;
        if(r-1>=0)
            points.add(new Point(r-1, c));
        if(r+1<height)
            points.add(new Point(r+1, c));
        if(c-1>=0)
            points.add(new Point(r, c-1));
        if(c+1<width)
            points.add(new Point(r, c+1));
        return points;
    }
}
