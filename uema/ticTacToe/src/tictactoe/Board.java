/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author MarcoAntônio
 */
public class Board {
    List<Point> availablePoints;
    Scanner scan = new Scanner(System.in);
    int[][] board = new int[3][3];
 
    public Board() {
    }
 
    public boolean isGameOver() {
        //Game is over is someone has won, or board is full (draw)
        return (hasXWon() || hasOWon() || getAvailableStates().isEmpty());
    }
 
    public boolean hasXWon() {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 1) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 1)) {
            //System.out.println("X Diagonal Win");
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 1)
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 1))) {
                // System.out.println("X Row or Column win");
                return true;
            }
        }
        return false;
    }
    public boolean hasOWon() {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 2) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 2)) {
            // System.out.println("O Diagonal Win");
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 2)
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 2)) {
                //  System.out.println("O Row or Column win");
                return true;
            }
        }
 
        return false;
    }
 
    public List<Point> getAvailableStates() {
        availablePoints = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == 0) {
                    availablePoints.add(new Point(i, j));
                }
            }
        }
        return availablePoints;
    }
    public void placeAMove(Point point, int player) {
        board[point.x][point.y] = player;   //player = 1 for X, 2 for O
    }
 
    void takeHumanInput() {
        System.out.println("Your move: ");
        int x = scan.nextInt();
        int y = scan.nextInt();
        Point point = new Point(x, y);
        placeAMove(point, 2);
    }
 
    public void displayBoard() {
        System.out.println();
 
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if(board[i][j]==1){
                    System.out.print("X ");
                }else if(board[i][j]==2){
                    System.out.print("O ");
                }else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
    
    Point computersMove;
 
    public int minimax(int depth, int turn) {
        if (hasXWon()) return +10;
        if (hasOWon()) return -10;
 
        List<Point> pointsAvailable = getAvailableStates();
        if (pointsAvailable.isEmpty()) return 0;
 
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
 
        for (int i = 0; i < pointsAvailable.size(); ++i) {
            Point point = pointsAvailable.get(i);
            if (turn == 1) {
                placeAMove(point, 1);
                int currentScore = minimax(depth + 1, 2);
                max = Math.max(currentScore, max);
 
                if(currentScore >= 0){ if(depth == 0) computersMove = point;}
                if(currentScore == 1){board[point.x][point.y] = 0; break;}
                if(i == pointsAvailable.size()-1 && max < 0){if(depth == 0)computersMove = point;}
            } else if (turn == 2) {
                placeAMove(point, 2);
                int currentScore = minimax(depth + 1, 1);
                min = Math.min(currentScore, min);
                if(min == -1){board[point.x][point.y] = 0; break;}
            }
            board[point.x][point.y] = 0; //Reset this point
        }
        return turn == 1?max:min;
    }
    
}
