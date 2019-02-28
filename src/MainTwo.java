import java.util.*;

public class MainTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nLines = sc.nextInt();
        sc.nextLine();

        List<OutStuff> stuff = new ArrayList<>();

        for (int i = 0; i < nLines; i++) {
            String[] thingToOut = sc.nextLine().split(" ");
            OutStuff thing = new OutStuff();
            thing.times = Integer.parseInt(thingToOut[0]);
            thing.stuff = thingToOut[1];
            stuff.add(thing);
        }

        stuff.forEach(thing -> {
            for (int i = 0; i < thing.times; i++) {
                System.out.print(thing.stuff);
            }
            System.out.println();
        });
    }

    static class OutStuff {
        int times;
        String stuff;
    }
}
