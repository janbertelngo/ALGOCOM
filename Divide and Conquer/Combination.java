import java.util.Scanner;

public class Combination {

    static void printCombination(int max, int r, String prefix, int last)
    {
        if (r==1)
        {
            for(int i = last + 1 ; i <= max; i++)
                System.out.println(prefix + i + " ");
        }
        else
        {
            for(int i = last + 1 ; i<=max-r+1; i++)
                printCombination(max,r-1,prefix + i + " ", i);
        }
    }

    public static void main (String[] args) {

        Scanner sc=new Scanner(System.in);

        int num1;
        int num2;

        num1 = sc.nextInt();
        num2 = sc.nextInt();


        int[] arr = new int[num1];

        for(int i=0; i<num1; i++){
            arr[i] = i+1;
        }

        printCombination(num1, num2, "", 0);
    }
}