package Xinxi.src;

import java.io.*;

/**
 * GameStorage类用于处理用户信息的保存和加载。
 */
public  class GameStorage {
//    private static final String USER_DATA_DIRECTORY = "C:\\Users\\<用户名>\\Desktop";
//    /**
//     * 将用户对象保存到指定文件路径。
//     *
//     * @param user 需要保存的用户对象。
//     * @param filePath 用户对象保存的文件路径。
//     */
    public static void main(String[] args) {

    }
    public static void saveUser(User user, String filePath) {
                try (FileOutputStream fos = new FileOutputStream(filePath);
                     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                    oos.writeObject(user);
                    oos.flush();
                    System.out.println(filePath);
                    System.out.println("User saved successfully.");
                } catch (IOException e) {
                    System.err.println("Error saving user: " + e.getMessage());
                }
            }

        /**
         * 从指定文件路径加载用户对象。
         *
         * @param filePath 用户对象加载的文件路径。
         * @return 加载成功的用户对象，如果加载失败则返回null。
         */
         public static User loadUser(String filePath) {
                User user = null;
                try (FileInputStream fis = new FileInputStream(filePath);
                     ObjectInputStream ois = new ObjectInputStream(fis)) {
                    user = (User) ois.readObject();
                    System.out.println("User loaded successfully.");
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println("Error loading user: " + e.getMessage());
                }
                return user;
            }

        public static void userStorage(String username,String password) {
            // 创建用户并初始化S
            System.out.println("Userspace方法调用");
            User user = new User(username, password);
            user.setId(1);//设置用户唯一id
            // 保存用户
            saveUser(user, ".\\filename");
            // 加载用户
            User loadedUser = loadUser(".\\filename");
            // 更新游戏统计
            if(loadedUser!=null) {
                loadedUser.updateGameStats(true); // 假设赢了一场五子棋游戏
                // 再次保存
                saveUser(loadedUser, ".\\filename");
            }
            else {
                System.out.println("User not found.");
            }
    }
}
