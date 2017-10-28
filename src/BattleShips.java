public class BattleShips {

    public static void main(String[] args) {
        char[][] ocean = new char[10][10];
        for (int row = 0; row < ocean.length; row++) {
            for (int col = 0; col < ocean[row].length; col++) {
                ocean[row][col] = ' ';
            }
        }
        printOcean(ocean);
    }

    public static void printOcean(char[][] ocean) {
        //char[][] ocean = new char[10][10];
        int rowCount = 0;
        System.out.println("   0123456789");
        for (int row = 0; row < ocean.length; row++) {
            System.out.print(rowCount + " |");
            for (int col = 0; col < ocean[row].length; col++) {
                System.out.print(ocean[row][col]);
            }
            System.out.println("| " + rowCount);
            rowCount++;
        }
        System.out.println("   0123456789");
    }


}
