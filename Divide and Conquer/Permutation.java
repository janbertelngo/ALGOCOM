import java.util.Scanner;

public class Permutation {

    static void printPermutation(int max, int r, String prefix)
    {
        if (r==1){
            for (int i=1; i<=max; i++)
                System.out.println(prefix + i + " ");
        }
        else {
            for (int i=1; i<=max; i++)
                printPermutation(max, r-1, prefix + i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        n = sc.nextInt();
        printPermutation(n, n, "");
    }

}