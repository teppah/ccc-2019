import java.util.*;
import java.util.stream.IntStream;

public class MainThree {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int nLines = sc.nextInt();
        sc.nextLine();
        List<String> things = new ArrayList<>();
        for (int i = 0; i < nLines; i++) {
            things.add(sc.nextLine());
        }



        for (int i = 0; i < things.size(); i++) {
            List<CharCounter> chars = new ArrayList<>();
            CharCounter temp = new CharCounter();
            temp.c = things.get(0).charAt(0);
            chars.add(temp);
            int index = 0;

            char[] characters = things.get(i).toCharArray();

            for (char c: characters) {
                if (chars.get(index).c == c) {
                    chars.get(index).count++;
                } else {
                    CharCounter newChar = new CharCounter();
                    newChar.c = c;
                    newChar.count++;
                    chars.add(newChar);
                    index++;
                }
            }
            chars.forEach(charCounter -> {
                StringBuilder sb = new StringBuilder();
                sb.append(charCounter.count);
                sb.append(charCounter.c);
                if (!sb.toString().equalsIgnoreCase("0+")) {
                    System.out.print(sb.toString());
                }
            });
            System.out.println();
        }


    }

    static class CharCounter {
        int count = 0;
        char c;


    }


}
