import java.util.Scanner;

public class TTT {
    
    private static int[][] tArray = new int[3][3];
    private static int count = 2;
    private static int moves = 0;
    private static int gameWinner = 0; 
    private static String confirm;
    private static TTT t = new TTT();
    private static boolean win = true;
    private static int p1 = 0;
    private static int p2 = 0;
    static Scanner scan = new Scanner(System.in);
    int x;
    int y;
    int currentPlayer = 0;
    public static void main(String[] args) {
        t.drawBoard();
        while (!t.gameWon() && !t.fullBoard()) {
            if (count % 2 == 0) {
                t.playerMove(1);
                count++;
                moves++;
            } else {
                t.playerMove(2);
                count++;
                moves++;
            }
        }
        if (t.fullBoard()) {
            System.out.println("No one won! The score is: " + p1 + " point(s) for player one, and " + p2 + " point(s) for player two.");
            System.out.println("Do you want to play again? [YES/NO]");
            confirm = scan.next();
            if (confirm.equals("YES")) {
                playAgain();
            } else {
                System.out.println("Incorrect key word to restart. Re-run the program to play again.");
            }
        } else if (t.gameWon()) {
            if (gameWinner == 1) {
                p1++;
            } else if (gameWinner == 2) {
                p2++;
            }
            System.out.println("You have won player " + gameWinner + ". The score is: " + p1 + " point(s) for player one, and " + p2 + " point(s) for player two.");
            System.out.println("Do you want to play again? [YES/NO]");
            confirm = scan.next();
            if (confirm.equals("YES")) {
                playAgain();
            } else {
                System.out.println("Incorrect key word to restart. Re-run the program to play again.");
            }
        }
    }
    
    public static void playAgain() {
        t.resetBoard();
        count = 2;
        moves = 0;
        win = false;
        while (!t.gameWon() && !t.fullBoard()) {
            if (count % 2 == 0) {
                t.playerMove(1);
                count++;
                moves++;
            } else {
                t.playerMove(2);
                count++;
                moves++;
            }
        }
        if (t.fullBoard()) {
            System.out.println("No one won! The score is: " + p1 + " point(s) for player one, and " + p2 + " point(s) for player two.");
            System.out.println("Do you want to play again? [YES/NO]");
            confirm = scan.next();
            if (confirm.equals("YES")) {
                playAgain();
            } else {
                System.out.println("Incorrect key word to restart. Re-run the program to play again.");
            }
        } else if (t.gameWon()) {
            if (gameWinner == 1) {
                p1++;
            } else if (gameWinner == 2) {
                p2++;
            }
            System.out.println("You have won player " + gameWinner + ". The score is: " + p1 + " point(s) for player one, and " + p2 + " point(s) for player two.");
            System.out.println("Do you want to play again? [YES/NO]");
            confirm = scan.next();
            if (confirm.equals("YES")) {
                playAgain();
            } else {
                System.out.println("Incorrect key word to restart. Re-run the program to play again.");
            }
        }
    }
    
    public void resetBoard() {
        for (int i = 0; i < tArray.length; i++) {
            for (int j = 0; j < tArray.length; j++) {
                tArray[i][j] = 0;
                System.out.print(tArray[i][j]);
            }
            System.out.println("");
        }
    }
    
    public void drawBoard() {
        for (int i = 0; i < tArray.length; i++) {
            for (int j = 0; j < tArray.length; j++) {
                System.out.print(tArray[i][j]);
            }
            System.out.println("");
        }
    }
    
    public void playerMove(int player) {
        currentPlayer = player;
        System.out.println("Enter the row you want to play in player " + player + ".");
        x = scan.nextInt();
        System.out.println("Enter the column you want to play in player " + player + ".");
        y = scan.nextInt();
        if (t.xValid() && t.yValid()) {
            if (tArray[x][y] == 0) {
                tArray[x][y] = player;
                t.drawBoard();
            } else {
                System.out.println("Invalid move, try another move.");
                t.playerMove(player);
            }
        } else {
            System.out.println("Invalid move, try another move.");
            t.playerMove(player);
        }
    }
    
    public boolean xValid() {
        if (x >= 0 && x <= 2) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean yValid() {
        if (y >= 0 && y <= 2) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean fullBoard() {
        if (moves == 9 && !gameWon()){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean gameWon() {
        for (int i = 0; i < tArray.length; i++) {
            for (int j = 0; j < tArray.length - 2; j++) {
               if (tArray[i][j] != 0 && tArray[i][j + 1] != 0 && tArray[i][j + 2] != 0 && tArray[i][j] == tArray[i][j + 1] && tArray[i][j + 1] == tArray[i][j + 2]) {
                   gameWinner = currentPlayer;
                   win = true;
                   return win;
               }
            }
        }
        for (int i = 0; i < tArray.length - 2; i++) {
            for (int j = 0; j < tArray.length; j++) {
               if (tArray[i][j] != 0 && tArray[i + 1][j] != 0 && tArray[i + 2][j] != 0 && tArray[i][j] == tArray[i + 1][j] && tArray[i + 1][j] == tArray[i + 2][j]) {
                   gameWinner = currentPlayer;
                   win = true;
                   return win;
               }
            }
        }
        for (int i = 0; i < tArray.length - 2; i++) {
            for (int j = 0; j < tArray.length - 2; j++) {
               if (tArray[i][j] != 0 && tArray[i + 1][j + 1] != 0 && tArray[i + 2][j + 2] != 0 && tArray[i][j] == tArray[i + 1][j + 1] && tArray[i + 1][j + 1] == tArray[i + 2][j + 2]){
                   gameWinner = currentPlayer;
                   win = true;
                   return win;
               }
            }
        }
        for (int i = 0; i < tArray.length - 3; i++) {
            for (int j = 0; j < tArray.length - 2; j++) {
               if (tArray[i][j] != 0 && tArray[i + 1][j - 1] != 0 && tArray[i + 2][j - 2] != 0 && tArray[i][j] == tArray[i + 1][j - 1] && tArray[i + 1][j - 1] == tArray[i + 2][j - 2]) { 
                   gameWinner = currentPlayer;
                   win = true;
                   return win;
               }
            }
        }
        return false;
    }
}