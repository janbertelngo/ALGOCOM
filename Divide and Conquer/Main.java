import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        int num1;
        int num2;

        n = sc.nextInt();

        for(int i=0; i<n; i++){
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            System.out.println(num1 + num2);
        }

    }
}
