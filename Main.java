//20211080_20211093_20210329_20211075_S5,6
import java.io.*;
import java.util.*;
import static java.util.Map.entry;
public class Main {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new FileReader("input.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                int problemNumber = Integer.parseInt(line);
                bw.write(problemNumber + "\n");
                StringWriter sw = new StringWriter();
                BufferedWriter tempBw = new BufferedWriter(sw);
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null && !line.trim().equals("end")) {
                    sb.append(line).append("\n");
                }
                BufferedReader problemReader = new BufferedReader(new StringReader(sb.toString()));
                switch (problemNumber) {
                    case 1 -> new Problem1(problemReader, tempBw);
                    case 2 -> new Problem2(problemReader, tempBw);
                    case 3 -> new Problem3(problemReader, tempBw);
                    case 4 -> new Problem4(problemReader, tempBw);
                    case 5 -> new Problem5(problemReader, tempBw);
                    case 6 -> new Problem6(problemReader, tempBw);
                    case 7 -> new Problem7(problemReader, tempBw);
                    case 8 -> new Problem8(problemReader, tempBw);
                    case 9 -> new Problem9(problemReader, tempBw);
                    case 10 -> new Problem10(problemReader, tempBw);
                    default -> {
                        tempBw.write("Invalid problem number\n");
                        tempBw.flush();
                    }
                }
                tempBw.flush();
                bw.write(sw.toString());
                bw.write("x\n");
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class DFA {
    private final int[] states;
    private final int startState;
    private final Set<Integer> finalStates;
    private final char[] alphabet;
    private final Map<Integer, int[]> transitionTable;
    private final Map<Character, Integer> alphabetIndex;
    public DFA(int[] states, int startState, int[] finalState, char[] alphabet, Map<Integer, int[]> transitionTable) {
        this.states = states;
        this.startState = startState;
        this.finalStates = new HashSet<>();
        for (int f : finalState)
        {finalStates.add(f);}
        this.alphabet = alphabet;
        this.transitionTable = transitionTable;
        this.alphabetIndex = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            alphabetIndex.put(alphabet[i], i);
        }
    }
    public boolean isAccepted(String s) {
        int currentState = startState;
        for (char c : s.toCharArray()) {
            if (!alphabetIndex.containsKey(c)) {return false;}
            int symbolIndex = alphabetIndex.get(c);
            currentState = transitionTable.get(currentState)[symbolIndex];
        }
        return finalStates.contains(currentState);
    }
    public void solveProblem(BufferedReader br, BufferedWriter bw) {
        try {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                boolean result = isAccepted(line);
                bw.write(result ? "True" : "False");
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
class Problem1 {
    int[] states = {0, 1};
    int startState = 0;
    int[] finalState = {1};
    char[] alphabet = {'a', 'b'};
    public Map<Integer, int[]> transitionTable = Map.ofEntries(
            entry(0, new int[]{1, 0}),
            entry(1, new int[]{0, 1})
    );
    DFA dfa = new DFA(states, startState, finalState, alphabet, transitionTable);

    public Problem1(BufferedReader br, BufferedWriter bw) {
        dfa.solveProblem(br, bw);
    }
}
class Problem2 {
    int[] states = {0, 1,2,3,4};
    int startState = 0;
    int[] finalState = {3};
    char[] alphabet = {'0', '1'};
    public Map<Integer, int[]> transitionTable = Map.ofEntries(
            entry(0, new int[]{4, 1}),
            entry(1, new int[]{2, 2}),
            entry(2, new int[]{3, 3}),
            entry(3, new int[]{3, 3}),
            entry(4, new int[]{4, 4})
    );
    DFA dfa = new DFA(states, startState, finalState, alphabet, transitionTable);
    public Problem2(BufferedReader br, BufferedWriter bw) {
        dfa.solveProblem(br, bw);
    }
}
class Problem3 {
    int[] states = {0, 1, 2, 3};
    int startState = 0;
    int[] finalState = {3};
    char[] alphabet = {'x', 'y', 'z'};
    public Map<Integer, int[]> transitionTable = Map.ofEntries(
            entry(0, new int[]{1, 0, 0}),
            entry(1, new int[]{1, 2, 0}),
            entry(2, new int[]{1, 0, 3}),
            entry(3, new int[]{3, 3, 3})
    );
    DFA dfa = new DFA(states, startState, finalState, alphabet, transitionTable);
    public Problem3(BufferedReader br, BufferedWriter bw) {
        dfa.solveProblem(br, bw);
    }
}
class Problem4 {
    int[] states = {0, 1, 2, 3, 4, 5, 6};
    int startState = 0;
    int[] finalState = {0};
    char[] alphabet = {'0', '1'};
    public Map<Integer, int[]> transitionTable = Map.ofEntries(
            entry(0, new int[]{0, 1}),
            entry(1, new int[]{2, 3}),
            entry(2, new int[]{4, 5}),
            entry(3, new int[]{6, 0}),
            entry(4, new int[]{1, 2}),
            entry(5, new int[]{3, 4}),
            entry(6, new int[]{5, 6})
    );
    DFA dfa = new DFA(states, startState, finalState, alphabet, transitionTable);
    public Problem4(BufferedReader br, BufferedWriter bw) {
        dfa.solveProblem(br, bw);
    }
}
class Problem5 {
    int[] states = {0, 1, 2};
    int startState = 0;
    int[] finalState = {0};
    char[] alphabet = {'a', 'b'};
    public Map<Integer, int[]> transitionTable = Map.ofEntries(
            entry(0, new int[]{1, 0}),
            entry(1, new int[]{0, 2}),
            entry(2, new int[]{2, 2})
    );
    DFA dfa = new DFA(states, startState, finalState, alphabet, transitionTable);
    public Problem5(BufferedReader br, BufferedWriter bw) {
        dfa.solveProblem(br, bw);
    }
}
class Problem6 {
    int[] states = {0, 1,2,3};
    int startState = 0;
    int[] finalState = {3};
    char[] alphabet = {'a', 'b'};
    public Map<Integer, int[]> transitionTable = Map.ofEntries(
            entry(0, new int[]{1, 3}),
            entry(1, new int[]{0, 2}),
            entry(2, new int[]{3, 1}),
            entry(3, new int[]{2, 0})
    );
    DFA dfa = new DFA(states, startState, finalState, alphabet, transitionTable);
    public Problem6(BufferedReader br, BufferedWriter bw) {
        dfa.solveProblem(br, bw);
    }
}
class NFA {
    private final int[] states;
    private final int[] startStates;
    private final Set<Integer> finalStates;
    private final char[] alphabet;
    private final Map<Character, Integer> symbolIndex;
    private final Map<Integer, int[][]> transitionTable;

    public NFA(int[] states, int[] startStates, int[] finalStates, char[] alphabet, Map<Integer, int[][]> transitionTable) {
        this.states = states;
        this.startStates = startStates;
        this.finalStates = new HashSet<>();
        for (int s : finalStates) {
            this.finalStates.add(s);
        }
        this.alphabet = alphabet;
        this.transitionTable = transitionTable;
        this.symbolIndex = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            this.symbolIndex.put(alphabet[i], i);
        }
    }

    private Set<Integer> epsilonClosure(Set<Integer> states) {
        Set<Integer> closure = new HashSet<>(states);
        Stack<Integer> stack = new Stack<>();
        stack.addAll(states);

        while (!stack.isEmpty()) {
            int state = stack.pop();
            int[][] transitions = transitionTable.get(state);
            if (transitions == null) continue;

            int epsilonIdx = symbolIndex.getOrDefault('E', -1);
            if (epsilonIdx == -1) continue;

            int[] nextStates = transitions[epsilonIdx];
            if (nextStates == null) continue;

            for (int ns : nextStates) {
                if (ns != -1 && !closure.contains(ns)) {
                    closure.add(ns);
                    stack.push(ns);
                }
            }
        }
        return closure;
    }

    public boolean isAccepted(String input) {
        Set<Integer> currentStates = new HashSet<>();
        for (int s : startStates) {
            currentStates.add(s);
        }
        currentStates = epsilonClosure(currentStates);

        for (char c : input.toCharArray()) {
            if (!symbolIndex.containsKey(c)) {
                return false;
            }
            int symbolIdx = symbolIndex.get(c);

            Set<Integer> nextStates = new HashSet<>();
            for (int state : currentStates) {
                int[][] transitions = transitionTable.get(state);
                if (transitions == null) continue;

                int[] next = transitions[symbolIdx];
                if (next == null || next.length == 0 || (next.length == 1 && next[0] == -1)) {
                    continue;
                }

                for (int ns : next) {
                    if (ns != -1) {
                        nextStates.add(ns);
                    }
                }
            }

            currentStates = epsilonClosure(nextStates);
            if (currentStates.isEmpty()) {
                return false;
            }
        }

        return currentStates.stream().anyMatch(finalStates::contains);
    }

    public void solveProblem(BufferedReader br, BufferedWriter bw) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.equals("end")) break;
            boolean result = isAccepted(line);
            bw.write((result ? "True" : "False") + "\n");
        }
    }
}
class Problem7 {
    int[] states = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] startState = {0};
    int[] finalState = {5, 6, 7, 8};
    char[] alphabet = {'0', '1'};

    public Map<Integer, int[][]> transitionTable = Map.ofEntries(
            Map.entry(0, new int[][]{{1}, {3}}),
            Map.entry(1, new int[][]{{2}, {6}}),
            Map.entry(2, new int[][]{{9}, {6}}),
            Map.entry(3, new int[][]{{5}, {4}}),
            Map.entry(4, new int[][]{{5}, {9}}),
            Map.entry(5, new int[][]{{7}, {6}}),
            Map.entry(6, new int[][]{{5}, {8}}),
            Map.entry(7, new int[][]{{9}, {6}}),
            Map.entry(8, new int[][]{{5}, {9}}),
            Map.entry(9, new int[][]{{9}, {9}})
    );


    NFA nfa = new NFA(states, startState, finalState, alphabet, transitionTable);

    public Problem7(BufferedReader br, BufferedWriter bw) throws IOException {
        nfa.solveProblem(br, bw);
    }
}
class Problem8 {
    int[] states = {0, 1, 2, 3, 4};
    int[] startState = {0};
    int[] finalState = {4};
    char[] alphabet = {'a', 'b'};
    public Map<Integer, int[][]> transitionTable = Map.ofEntries(
            entry(0, new int[][]{{0, 1}, {0}}),
            entry(1, new int[][]{{}, {2}}),
            entry(2, new int[][]{{2, 3}, {2}}),
            entry(3, new int[][]{{}, {4}}),
            entry(4, new int[][]{{4}, {4}})
    );

    NFA nfa = new NFA(states, startState, finalState, alphabet, transitionTable);

    public Problem8(BufferedReader br, BufferedWriter bw) throws IOException {
        nfa.solveProblem(br, bw);
    }
}
class Problem9 {
    int[] states = {0, 1, 2};
    int[] startState = {0};
    int[] finalState = {0, 1, 2};
    char[] alphabet = {'0', '1'};
    public Map<Integer, int[][]> transitionTable = Map.ofEntries(
            entry(0, new int[][]{{0}, {1}}),
            entry(1, new int[][]{{2}, {1}}),
            entry(2, new int[][]{{}, {1}})
    );

    NFA nfa = new NFA(states, startState, finalState, alphabet, transitionTable);

    public Problem9(BufferedReader br, BufferedWriter bw) throws IOException {
        nfa.solveProblem(br, bw);
    }
}
class Problem10 {
    int[] states = {0, 1};
    int[] startState = {0};
    int[] finalState = {0, 1};
    char[] alphabet = {'x', 'y'};
    public Map<Integer, int[][]> transitionTable = Map.ofEntries(
            entry(0, new int[][]{{0}, {1}}),
            entry(1, new int[][]{{0}, {}})
    );

    NFA nfa = new NFA(states, startState, finalState, alphabet, transitionTable);

    public Problem10(BufferedReader br, BufferedWriter bw) throws IOException {
        nfa.solveProblem(br, bw);
    }
}
