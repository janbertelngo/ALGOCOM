import java.util.*;
import java.io.*;
import java.text.*;

public class NewRuleInEuphomia {

    private Scanner in;
    private StringTokenizer st;
    private PrintWriter out;

    private DecimalFormat fmt = new DecimalFormat("0.0000000000");

    private int[] primes;
    private int primesEnd = 1;

    public void solve() throws Exception {
        int n;
        int caseNum = 0;

        sieve();

        while ((n = in.nextInt()) > 0) {
            out.print("Case " + (++caseNum) + ": ");

            long ans = 0;
            for (int i=2; primes[i] < n; i++) {
                ans += binarySearch(i, n);
            }

            out.println(ans);
        }
    }

    private int binarySearch(int index, int goal) {
        int l = 0;
        int r = index;

        int v = primes[index];

        while (l + 1 < r) {
            int m = (l + r) / 2;
            if (v + primes[m] < goal) {
                l = m;
            } else if (v + primes[m] > goal){
                r = m;
            } else {
                return m;
            }
        }

        return (l + r) / 2;
    }

    private void sieve() {
        boolean[] notPrime = new boolean[1000000];
        notPrime[0] = notPrime[1] = true;
        primes = new int[1000000];

        for (int i=2; i * i <= notPrime.length; i++) {
            if (!notPrime[i]) {
                for (int j = i + i; j < notPrime.length; j += i) {
                    notPrime[j] = true;
                }
            }
        }

        for (int i=2; i < notPrime.length; i++) {
            if (!notPrime[i]) {
                primes[primesEnd++] = i;
            }
        }
    }

    public NewRuleInEuphomia() {
        this.in = new Scanner(System.in);
        this.out = new PrintWriter(System.out);
    }

    public void end() {
        try {
            this.out.flush();
            this.out.close();
            this.in.close();
        } catch (Exception e){
            //do nothing then :)
        }
    }

    public static void main(String[] args) throws Exception {
        NewRuleInEuphomia solver = new NewRuleInEuphomia();
        solver.solve();
        solver.end();
    }
}