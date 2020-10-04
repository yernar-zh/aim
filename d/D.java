import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class D {

    static final boolean MULTI_TEST = true;
    static int MOD = 1000000007;

    // --------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------HELPER------------------------------------------------------
    // --------------------------------------------------------------------------------------------------------------
    public MyScanner in;

    // --------------------ALGORITHM-------------------------
    public MyWriter out;
    public Benchmark bm;

    /**
     * add `-Xss256m` to increase stack size
     */
    public static void main(String[] args) {
        boolean local = args.length > 0;
        String input = local ? "d/d.in" : null;

        D m = new D();
        m.in = new MyScanner(input);
        m.out = MyWriter.of(null);
        m.bm = new Benchmark();
        m.run();
        m.out.close();
    }

    void solve() {
        int a = in.nextInt();
        int b = in.nextInt();
        out.println(a + b);
    }

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

    public void sort(int[] arr) {
        List<Integer> tmp = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmp.get(i);
        }
    }


    // --------------------MAIN-------------------------

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

        public MyWriter(FileWriter fileWriter) {
            super(fileWriter);
        }

        public MyWriter(OutputStream out) {
            super(out);
        }

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
}
