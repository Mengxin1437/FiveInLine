package Xinxi.src;
import graphic.awt.ChessOnAwt;
import logic.Chess;

import java.io.Serializable;
import java.io.*;
import java.io.Serializable;
import java.io.*;
import java.io.*;


import javax.print.DocFlavor;
import java.io.*;

public class User implements Serializable {
    private static final long serialVersionUID = 1L; // 保持版本一致性的序列号
    private String username;//用户名
    private String password;//密码
    private String chosenImage;//选择头像图片
    private int id;//唯一的编号id
    private int totalGames;//游戏总次数
    private int wonGames;//胜利次数
    private double winRate;//胜率

    //private enum gameType{
    //    FIVE_IN_LINE,//五子棋
    //    REVERSI,//黑白棋
    //    GO,//围棋
    //}
    private Chess type;

    public void setType(Chess type) {
        this.type = type;
    }

    public User() {
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void updateGameStats(boolean won) {
        totalGames++;
        if (won) {
            wonGames++;
            winRate = (double) wonGames / totalGames;
        }
    }

    public static long getSerialVersionUID() {return serialVersionUID;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChosenImage() {
        return chosenImage;
    }

    public void setChosenImage(String chosenImage) {
        this.chosenImage = chosenImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public int getWonGames() {
        return wonGames;
    }

    public void setWonGames(int wonGames) {
        this.wonGames = wonGames;
    }

    public double getWinRate() {
        return winRate;
    }

    public void setWinRate(double winRate) {
        this.winRate = winRate;
    }
}

