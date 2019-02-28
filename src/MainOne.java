import java.util.Scanner;

public class MainOne {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int threeApple = sc.nextInt();
        sc.nextLine();
        int twoApple = sc.nextInt();
        sc.nextLine();
        int oneApple = sc.nextInt();
        sc.nextLine();

        int threeBanana = sc.nextInt();
        sc.nextLine();
        int twoBanana = sc.nextInt();
        sc.nextLine();
        int oneBanana = sc.nextInt();
        sc.nextLine();
        if (threeApple * 3 + twoApple * 2 + oneApple > threeBanana * 3 + twoBanana * 2 + oneBanana) {
            System.out.println("A");
        } else if (threeApple * 3 + twoApple * 2 + oneApple < threeBanana * 3 + twoBanana * 2 + oneBanana) {
            System.out.println("B");
        } else {
            System.out.println("T");
        }
    }
}
