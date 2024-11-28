/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimax;

import java.util.Random;

/**
 *
 * @author MarcoAntônio
 */
public class AlphaBetaMinimaxTTT {
    public static void main(String[] args) { 
        Board b = new Board();
        Random rand = new Random();

        b.displayBoard();

        System.out.println("Who's gonna move first? (1)Computer (2)User: ");
        int choice = b.scan.nextInt();
        if (choice == 1) {
            Point p = new Point(rand.nextInt(3), rand.nextInt(3));
            b.placeAMove(p, 1);
            b.displayBoard();
        }

        while (!b.isGameOver()) {
            System.out.println("Your move: ");
            Point userMove = new Point(b.scan.nextInt(), b.scan.nextInt());

            b.placeAMove(userMove, 2); //2 for O and O is the user
            b.displayBoard();
            if (b.isGameOver()) break;
            
            b.alphaBetaMinimax(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 1);
            for (PointsAndScores pas : b.rootsChildrenScore) 
                System.out.println("Point: " + pas.point + " Score: " + pas.score);
            
            b.placeAMove(b.returnBestMove(), 1);
            b.displayBoard();
        }
        if (b.hasXWon()) {
            System.out.println("Unfortunately, you lost!");
        } else if (b.hasOWon()) {
            System.out.println("You win!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
