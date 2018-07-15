import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N;
        int M;
        int total = 0;
        int temp;
        N = sc.nextInt();
        M = sc.nextInt();
        for(int i=0; i < N ; i++){
            temp = sc.nextInt();
            total += temp;
        }

        if(total < N*M)
            System.out.println("NOT ENOUGH FOOD");
        else if(total == N*M)
            System.out.println("JUST ENOUGH FOR EVERYONE");
        else
            System.out.println("PARTY!");

    }

}
