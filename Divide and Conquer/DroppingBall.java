import java.util.Scanner;

public class DroppingBall {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T;

        T=sc.nextInt();

        while(T!=-1){
            for(int i=0;i<T;i++){

                int D,I;
                D = sc.nextInt();
                I = sc.nextInt();

                int k=1;
                for(int j=0;j<D-1;j++) {
                    if (I % 2 == 0) {
                        k = 2 * k + 1;
                        I = I / 2;
                    } else {
                        k = 2 * k;
                        I = (I + 1) / 2;
                    }
                }

                System.out.println(k);
            }
            T =sc.nextInt();
        }
    }
}
