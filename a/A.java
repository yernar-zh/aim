import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class A {

    void solve() {
        Set<Integer> a = Arrays.stream(in.nextInts(10)).boxed().collect(Collectors.toSet());
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int[] b = in.nextInts(6);
            int count = 0;
            for (int el : b) {
                if (a.contains(el)) count++;
            }
            if (count >= 3){
                out.println("Lucky");
            }else{
                out.println("Unlucky");
            }
        }
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
        String input = local ? "a/a.in" : null;

        A m = new A();
        m.in = new MyScanner(input);
        m.out = MyWriter.of(null);
        m.bm = new Benchmark();
        m.run();
        m.out.close();
    }
}
