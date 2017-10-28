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
        ocean = placeUserShips(ocean);
        printOcean(ocean);
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
        System.out.println("Coords --> "+ x + "," + y);
        for (int row = 0; row < ocean.length; row++) {
            for (int col = 0; col < ocean[row].length; col++) {
                if (row == y && col == x) {
                    if (ocean[row][col] != ' ') {
                        System.out.println("You cannot place your ship here.");
                        placeUserShips(ocean);
                    } else {
                        ocean[row][col] = '1';
                    }
                }
            }
        }
        return ocean;
    }


}
