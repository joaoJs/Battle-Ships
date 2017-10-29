import java.util.Scanner;
public class BattleShips {

    public static int count = 1;
    public static int userShips = 5;
    public static int computerShips = 5;

    public static void main(String[] args) {
        char[][] ocean = new char[10][10];
        for (int row = 0; row < ocean.length; row++) {
            for (int col = 0; col < ocean[row].length; col++) {
                ocean[row][col] = ' ';
            }
        }
        printOcean(ocean);
        printScore();
        for (int i = 0; i < 5; i++) {
            ocean = placeUserShips(ocean);
        }
        printOcean(ocean);
        System.out.println("Computer is deploying ships");
        for (int i = 0; i < 5; i++) {
            ocean = placeComputerShips(ocean);
        }
        //printOcean(ocean);
        while (BattleShips.userShips > 0 && BattleShips.computerShips > 0) {
            ocean = usersTurn(ocean);
            ocean = computersTurn(ocean);
            printOcean(ocean);
            printScore();
        }
        if (BattleShips.computerShips == 0) {
            printOcean(ocean);
            printScore();
            System.out.println("Hooray! You win the battle!");
        } else {
            printOcean(ocean);
            printScore();
            System.out.println("You loose.");
        }
    }

    public static void printOcean(char[][] ocean) {
        int rowCount = 0;
        System.out.println("   0123456789");
        for (int row = 0; row < ocean.length; row++) {
            System.out.print(rowCount + " |");
            for (int col = 0; col < ocean[row].length; col++) {
                if (ocean[row][col] == ' ' || ocean[row][col] == '!' || ocean[row][col] == 'x' || ocean[row][col] == '-') {
                    System.out.print(ocean[row][col]);
                } else if (ocean[row][col] == 'c' || ocean[row][col] == '2') {
                    System.out.print(' ');
                } else {
                    System.out.print('@');
                }
            }
            System.out.println("| " + rowCount);
            rowCount++;
        }
        System.out.println("   0123456789");
    }

    public static void printScore() {
        System.out.println();
        System.out.println("Your ships: " + BattleShips.userShips + " | " + "Computer ships: " + BattleShips.computerShips);
        for (int i = 0; i < 40; i++) {
            System.out.print('-');
        }
        System.out.println();
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

    public static char[][] placeComputerShips(char[][] ocean) {
        int x = (int)Math.floor(Math.random() * 10);
        int y = (int)Math.floor(Math.random() * 10);
        if (ocean[y][x] != ' ') {
            //System.out.println("Computer cannot place its ship here.");
            placeComputerShips(ocean);
        } else {
            ocean[y][x] = '2';
            System.out.println(BattleShips.count + ". ship DEPLOYED");
            BattleShips.count++;
        }
        return ocean;
    }

    public static char[][] usersTurn(char[][] ocean) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter X coordinate: ");
        int x = input.nextInt();
        while (x < 0 || x > 9) {
            x = input.nextInt();
        }
        System.out.print("Enter Y coordinate: ");
        int y = input.nextInt();
        while (y < 0 || y > 9) {
            y = input.nextInt();
        }
        if (ocean[y][x] == '-') {
            usersTurn(ocean);
        } else {
            System.out.println("YOUR TURN");
            if (ocean[y][x] == '2') {
                System.out.println("Boom! You sunk the ship!");
                BattleShips.computerShips--;
                ocean[y][x] = '!';
            } else if (ocean[y][x] == '1') {
                System.out.println("Oh no, you sunk your own ship :(");
                BattleShips.userShips--;
                ocean[y][x] = 'x';
            } else {
                System.out.println("Sorry, you missed");
                ocean[y][x] = '-';
            }
        }
        return ocean;
    }

    public static char[][] computersTurn(char[][] ocean) {
        int x = (int)Math.floor(Math.random() * 10);
        int y = (int)Math.floor(Math.random() * 10);
        if (ocean[y][x] == 'c' || ocean[y][x] == '-' || ocean[y][x] == '!' || ocean[y][x] == 'x') {
            computersTurn(ocean);
        } else {
            System.out.println("COMPUTER TURN");
            if (ocean[y][x] == '2') {
                System.out.println("The Computer sunk one of its own ships");
                BattleShips.computerShips--;
                ocean[y][x] = '!';
            } else if (ocean[y][x] == '1') {
                System.out.println( "The Computer sunk one of your ships!");
                BattleShips.userShips--;
                ocean[y][x] = 'x';
            } else {
                System.out.println("Computer missed");
                ocean[y][x] = 'c';
            }
        }
        return ocean;
    }


}
