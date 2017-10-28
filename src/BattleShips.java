import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;
public class BattleShips {

    public static void main(String[] args) {
        char[][] ocean = new char[10][10];
        for (int row = 0; row < ocean.length; row++) {
            for (int col = 0; col < ocean[row].length; col++) {
                ocean[row][col] = ' ';
            }
        }
        printOcean(ocean);
        for (int i = 0; i < 5; i++) {
            ocean = placeUserShips(ocean);
        }
        printOcean(ocean);
        System.out.println("Computer is deploying ships");
        for (int i = 0; i < 5; i++) {
            ocean = placeComputerShips(ocean, 0);
        }
        printOcean(ocean);
        usersTurn(ocean);
    }

    public static void printOcean(char[][] ocean) {
        int rowCount = 0;
        System.out.println("   0123456789");
        for (int row = 0; row < ocean.length; row++) {
            System.out.print(rowCount + " |");
            for (int col = 0; col < ocean[row].length; col++) {
                if (ocean[row][col] == ' ') {
                    System.out.print(ocean[row][col]);
                } else {
                    System.out.print('@');
                }
            }
            System.out.println("| " + rowCount);
            rowCount++;
        }
        System.out.println("   0123456789");
    }

    public static char[][] placeUserShips(char[][] ocean) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter X coordinate for your ship: ");
        int x = input.nextInt();
        while (x < 0 || x > 9) {
            x = input.nextInt();
        }
        System.out.print("Enter Y coordinate for your ship: ");
        int y = input.nextInt();
        while (y < 0 || y > 9) {
            y = input.nextInt();
        }
        if (ocean[y][x] != ' ') {
            System.out.println("You cannot place your ship here.");
            placeUserShips(ocean);
        } else {
            ocean[y][x] = '1';
        }
        return ocean;
    }

    public static char[][] placeComputerShips(char[][] ocean, int count) {
        int x = (int)Math.floor(Math.random() * 10);
        int y = (int)Math.floor(Math.random() * 10);
        if (ocean[y][x] != ' ') {
            System.out.println("Computer cannot place its ship here.");
            placeUserShips(ocean);
        } else {
            ocean[y][x] = '2';
            System.out.println(count + ". ship DEPLOYED");
        }
        return ocean;
    }

    public static void usersTurn(char[][] ocean) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter X coordinate for your ship: ");
        int x = input.nextInt();
        while (x < 0 || x > 9) {
            x = input.nextInt();
        }
        System.out.print("Enter Y coordinate for your ship: ");
        int y = input.nextInt();
        while (y < 0 || y > 9) {
            y = input.nextInt();
        }
        if (ocean[y][x] == '2') {
            System.out.println("Boom! You sunk the ship!");
            ocean[y][x] = '!';
        } else if (ocean[y][x] == '1') {
            System.out.println("Oh no, you sunk your own ship :(");
            ocean[y][x] = 'x';
        } else  {
            System.out.println("Sorry, you missed");
            ocean[y][x] = '-';
        }
    }

    public static void computersTurn(char[][] ocean) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter X coordinate for your ship: ");
        int x = input.nextInt();
        while (x < 0 || x > 9) {
            x = input.nextInt();
        }
        System.out.print("Enter Y coordinate for your ship: ");
        int y = input.nextInt();
        while (y < 0 || y > 9) {
            y = input.nextInt();
        }
        if (ocean[y][x] == '2') {
            System.out.println("Boom! You sunk the ship!");
            ocean[y][x] = '!';
        } else if (ocean[y][x] == '1') {
            System.out.println("Oh no, you sunk your own ship :(");
            ocean[y][x] = 'x';
        } else  {
            System.out.println("Sorry, you missed");
            ocean[y][x] = '-';
        }
    }


}
