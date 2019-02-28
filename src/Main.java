import javax.xml.transform.Transformer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static SubstitutionRule r1;
    static SubstitutionRule r2;
    static SubstitutionRule r3;

    static int max;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] o = sc.nextLine().split(" ");
        String[] tw = sc.nextLine().split(" ");
        String[] tr = sc.nextLine().split(" ");


        r1 = new SubstitutionRule(1, o[0], o[1]);
        r2 = new SubstitutionRule(2, tw[0], tw[1]);
        r3 = new SubstitutionRule(3, tr[0], tr[1]);

        CharSequence r1Seq = r1.initialS.subSequence(0, r1.initialS.length());
        CharSequence r2Seq = r2.initialS.subSequence(0, r2.initialS.length());
        CharSequence r3Seq = r3.initialS.subSequence(0, r3.initialS.length());

        String[] next = sc.nextLine().split(" ");

        max = Integer.parseInt(next[0]);
        String initialString = next[1];
        String finalString = next[2];


        String now = initialString;

        int count = 0;

        List<TransformationStack> stack = new ArrayList<>();


        if (now.equalsIgnoreCase(finalString)) {
            stack.forEach(transformationStack -> {
                System.out.println(transformationStack.rule.id + " " + transformationStack.result.startIndex + " " + transformationStack.result.transformed);

            });
        }
    }

    public List<TransformationStack> finalAfterTransform(String initial, SubstitutionRule rule) {

    }




    static class TransformationStack {
        SubstitutionRule rule;
        SubstitutionResult result;

        public TransformationStack(SubstitutionRule rule, SubstitutionResult result) {
            this.rule = rule;
            this.result = result;
        }
    }


    static class SubstitutionRule {
        int id;
        String initialS;
        String finalS;

        SubstitutionRule(int id, String initialS, String finalS) {
            this.id = id;
            this.initialS = initialS;
            this.finalS = finalS;
        }

        SubstitutionResult[] transform(String initial) {
            List<SubstitutionResult> results = new ArrayList<>();

            for (int i = 0; i < initial.length(); i++) {
                //if the substring is present somewhere
                try {
                    if (initial.substring(i, i + initialS.length()).equalsIgnoreCase(initialS)) {
                        String part1 = initial.substring(0, i);
                        String part3 = initial.substring(i + initialS.length());

                        String finalReplaced = part1 + finalS + part3;
                        SubstitutionResult sr = new SubstitutionResult(finalReplaced, i + 1);
                        results.add(sr);
                    }
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }
            return results.toArray(new SubstitutionResult[0]);
        }


    }

    static class SubstitutionResult {
        String transformed;
        int startIndex;

        public SubstitutionResult(String transformed, int startIndex) {
            this.transformed = transformed;
            this.startIndex = startIndex;
        }


        @Override
        public String toString() {
            return "SubstitutionResult{" +
                    "transformed='" + transformed + '\'' +
                    ", startIndex=" + startIndex +
                    '}';
        }
    }
}
