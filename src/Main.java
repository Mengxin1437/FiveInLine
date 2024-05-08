public class Main {
    public static void main(String[] args) {
        FiveInLineOnCommand game = new FiveInLineOnCommand();
        game.init(16);
        game.initPlayer(new String[]{"张三", "李四", "王五", "赵六"});
        game.showRules();
        game.gameLoop();
    }
}