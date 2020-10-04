import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class C {
    class Node {
        long x;
        long y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    boolean collinear(Node a0, Node a1, Node a2){
        long part1 = (a0.x - a2.x) * (a1.y - a0.y);
        long part2 = (a1.x - a0.x) * (a0.y - a2.y);
        return part1 == part2;
    }

    void solve() {
        int n = in.nextInt();
        Set<Node> aSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            if (t == 0) {
                in.nextInt();
                int x = in.nextInt();
                int y = in.nextInt();
                aSet.add(new Node(x * 2, y * 2));
            } else {
                int x1 = in.nextInt();
                int y1 = in.nextInt();
                in.nextInt();
                in.nextInt();
                int x3 = in.nextInt();
                int y3 = in.nextInt();
                in.nextInt();
                in.nextInt();
                aSet.add(new Node(x1 + x3, y1 + y3));
            }
        }
        List<Node> a = new ArrayList<>(aSet);
        for (int i = 2; i < a.size(); i++) {
            if (!collinear(a.get(0), a.get(1), a.get(i))) {
                out.println("No");
                return;
            }
        }
        out.println("Yes");
    }

    static final boolean MULTI_TEST = false;

    // --------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------HELPER------------------------------------------------------
    // --------------------------------------------------------------------------------------------------------------


    void run() {
        if (MULTI_TEST) {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                solve();
            }
        } else {
            solve();
        }
    }

    // --------------------ALGORITHM-------------------------

    static int MOD = 1000000007;

    public void sort(int[] arr) {
        List<Integer> tmp = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmp.get(i);
        }
    }

    public void sortRev(int[] arr) {
        List<Integer> tmp = Arrays.stream(arr).boxed().sorted(Comparator.comparing((Integer x) -> x).reversed())
                .collect(Collectors.toList());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmp.get(i);
        }
    }

    // --------------------SCANNER-------------------------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner(String fileName) {
            if (fileName != null) {
                try {
                    br = new BufferedReader(new FileReader(fileName));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] nextInts(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        boolean[] nextLineBools() {
            String line = nextLine();
            int n = line.length();
            boolean[] booleans = new boolean[n];
            for (int i = 0; i < n; i++) {
                booleans[i] = line.charAt(i) == '1';
            }
            return booleans;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        public long[] nextLongs(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            try {
                String line = br.readLine();
                if (line == null) {
                    throw new RuntimeException("empty line");
                }
                return line;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    // --------------------WRITER-------------------------
    public static class MyWriter extends PrintWriter {

        public static MyWriter of(String fileName) {
            if (fileName != null) {
                try {
                    return new MyWriter(new FileWriter(fileName));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                return new MyWriter(new BufferedOutputStream(System.out));
            }
        }

        public MyWriter(FileWriter fileWriter) {
            super(fileWriter);
        }

        public MyWriter(OutputStream out) {
            super(out);
        }

        void println(int[] arr) {
            String line = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            println(line);
        }

    }

    // -----------------------BENCHMARK-------------------------
    public static class Benchmark {
        long time;

        public void reset() {
            time = System.currentTimeMillis();
        }

        public long calc() {
            long curTime = System.currentTimeMillis();
            long tmp = curTime - time;
            time = curTime;
            return tmp;
        }

    }


    // --------------------MAIN-------------------------

    public MyScanner in;
    public MyWriter out;
    public Benchmark bm;

    /**
     * add `-Xss256m` to increase stack size
     */
    public static void main(String[] args) {
        boolean local = args.length > 0;
        String input = local ? "c/c.in" : null;

        C m = new C();
        m.in = new MyScanner(input);
        m.out = MyWriter.of(null);
        m.bm = new Benchmark();
        m.run();
        m.out.close();
    }
}
