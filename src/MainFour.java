import java.util.Scanner;

public class MainFour {
    static int[][] grid =
            {{1, 2},
             {3, 4}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] operations = sc.nextLine().toCharArray();
        for (char op :
                operations) {
            switch (op) {
                case 'H':
                    horizontalFlip();
                    break;
                case 'V':
                    verticalFlip();
            }
        }
        System.out.println(grid[0][0] + " " + grid[0][1]);
        System.out.println(grid[1][0] + " " + grid[1][1]);
    }

    static void horizontalFlip() {
        //flip left column
        int lTop = grid[0][0];
        int lBot = grid[1][0];
        grid[1][0] = lTop;
        grid[0][0] = lBot;

        //flip right column
        int rTop = grid[0][1];
        int rBot = grid[1][1];
        grid[1][1] = rTop;
        grid[0][1] = rBot;

    }

    static void verticalFlip() {
        // flip top row
        int lTop = grid[0][0];
        int rTop = grid[0][1];
        grid[0][0] = rTop;
        grid[0][1] = lTop;
        // flip bottom row

        int lBot = grid[1][0];
        int rBot = grid[1][1];
        grid[1][0] = rBot;
        grid[1][1] = lBot;
    }
}
