package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class DualExpressionEvaluator {

    public static String[] processDualContainerOperations(int n, String[] operations, int[] values) {
        Deque<Integer> lifoContainer = new ArrayDeque<>();
        Deque<Integer> fifoContainer = new ArrayDeque<>();
        List<Integer> intermediateResults = new ArrayList<>();

        for (int index = 0; index < n; index++) {
            String command = operations[index].toUpperCase(Locale.ROOT);

            switch (command) {
                case "PUSH":
                    lifoContainer.push(values[index]);
                    break;

                case "POP":
                    if (!lifoContainer.isEmpty()) {
                        lifoContainer.pop();
                    }
                    break;

                case "ENQUEUE":
                    fifoContainer.offerLast(values[index]);
                    break;

                case "DEQUEUE":
                    if (!fifoContainer.isEmpty()) {
                        fifoContainer.pollFirst();
                    }
                    break;

                default:
                    if (lifoContainer.isEmpty() || fifoContainer.isEmpty()) {
                        throw new IllegalStateException(
                                "Both containers must have at least one element before arithmetic operations."
                        );
                    }

                    int lifoOperand = lifoContainer.pop();
                    int fifoOperand = fifoContainer.pollFirst();
                    int computedValue = evaluate(command, lifoOperand, fifoOperand);

                    intermediateResults.add(computedValue);
                    lifoContainer.push(computedValue);
                    fifoContainer.offerLast(computedValue);
            }
        }

        String intermediateLine = joinValues(intermediateResults);
        String lifoLine = joinValues(lifoContainer);   // top -> bottom
        String fifoLine = joinValues(fifoContainer);   // front -> back

        return new String[]{intermediateLine, lifoLine, fifoLine};
    }

    private static int evaluate(String command, int leftOperand, int rightOperand) {
        switch (command) {
            case "ADD":
            case "+":
                return leftOperand + rightOperand;

            case "SUB":
            case "-":
                return leftOperand - rightOperand;

            case "MUL":
            case "*":
                return leftOperand * rightOperand;

            case "DIV":
            case "/":
                return leftOperand / rightOperand; // integer division truncates toward zero in Java

            default:
                throw new IllegalArgumentException("Unsupported operation: " + command);
        }
    }

    private static String joinValues(Iterable<Integer> values) {
        StringBuilder output = new StringBuilder();
        boolean first = true;

        for (int number : values) {
            if (!first) {
                output.append(' ');
            }
            output.append(number);
            first = false;
        }

        return output.toString();
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();

        String[] operations = new String[n];
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            operations[i] = scanner.next();
        }

        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        String[] result = processDualContainerOperations(n, operations, values);

        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
    }

    private static class FastScanner {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer;

        String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String line = reader.readLine();
                if (line == null) {
                    return null;
                }
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer.nextToken();
        }

        int nextInt() throws IOException {
            String token = next();
            if (token == null) {
                throw new IOException("Unexpected end of input.");
            }
            return Integer.parseInt(token);
        }
    }
}
