import java.util.Scanner;

public class FiveInLineOnCommand extends FiveInLine{
    private static final String blackChessman="🔴";
    private static final String whiteChessman="🔵";
    private static final String boardCompent="➕";
    private String playerBlack;
    private String playerWhite;
    private Scanner sc = new Scanner(System.in);
    /**
     * 选取两位玩家并猜先
     * @param names 候选玩家
     */
    public void initPlayer(String[] names) {
        printDelimiter();
        System.out.println("进行随机分配角色。。。");
        int a = (int)(Math.random()*names.length);
        int b;
        do{
            b = (int)(Math.random()*names.length);
        }while(a==b);
        System.out.println(" 分配玩家 A 角色："+names[a]);
        System.out.println(" 分配玩家 B 角色："+names[b]);
        printDelimiter();
        System.out.println("开始猜先。。。");
        if(Math.random()>0.5){
            playerBlack = names[a];
            playerWhite = names[b];
        }else{
            playerWhite = names[a];
            playerBlack = names[b];
        }
        //打印提示信息
        System.out.println(playerBlack+"玩家获得先手");
        printDelimiter();
        System.out.print("任意键开始游戏");
        sc.nextLine();
    }

    public void printDelimiter(){
        System.out.println("-----------------------");
    }

    @Override
    public void showBoard() {
        System.out.println("  壹贰叁肆伍陆柒捌玖拾屲亗岌岄岪峘");
        for(int i=4;i<size+4;i++){
            System.out.print((i-3)+(i<13?" ":""));
            for (int j = 4; j <size+4; j++) {
                if(board[i][j] == null){
                    System.out.print(boardCompent);
                }else if(board[i][j].equals(true)){
                    System.out.print(blackChessman);
                }else{
                    System.out.print(whiteChessman);
                }
            }
            System.out.println();
        }
    }

    @Override
    public int getX() {
        String current = getTurn()?playerBlack:playerWhite;
        System.out.print(current + "请输入落子的横坐标：");
        return sc.nextInt();
    }

    @Override
    public int getY() {
        String current = getTurn()?playerBlack:playerWhite;
        System.out.print(current + "请输入落子的纵坐标：");
        return sc.nextInt();
    }

    @Override
    public void positionNotAllowedInfo() {
        System.out.println("落子位置不合法，请重新落子");
    }

    @Override
    public void showWinner(Boolean result) {
        if(result.equals(true)){
            System.out.println(playerBlack+"胜利");
        }else{
            System.out.println(playerWhite+"胜利");
        }
    }

    /**
     * 展示游戏规则
     */
    public void showRules(){
        printDelimiter();
        System.out.println("五子棋对战规则：");
        System.out.println("\t\t1.一人一步");
        System.out.println("\t\t2.无禁手");
        System.out.println("\t\t3.五子连线获胜");
    }
}
