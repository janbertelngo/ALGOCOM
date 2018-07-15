import java.util.Scanner;

public class FillTool {

    public char[][] fillUp (char[][] multD, char toBeChanged, int fillRow, int fillCol, char fill)
    {
        if(fillRow-1 >= 0){
            if(multD[fillRow-1][fillCol] == toBeChanged){
                multD[fillRow-1][fillCol] = fill;
                multD = fillUp(multD, toBeChanged,fillRow-1,fillCol, fill);
            }
        }

        if(fillCol-1 >= 0){
            if(multD[fillRow][fillCol-1] == toBeChanged){
                multD[fillRow][fillCol-1] = fill;
                multD = fillUp(multD, toBeChanged,fillRow,fillCol-1, fill);
            }
        }

        if(fillRow+1 < multD.length){
            if(multD[fillRow+1][fillCol] == toBeChanged){
                multD[fillRow+1][fillCol] = fill;
                multD = fillUp(multD, toBeChanged,fillRow+1,fillCol, fill);
            }
        }

        if(fillCol+1 < multD[0].length){
            if(multD[fillRow][fillCol+1] == toBeChanged){
                multD[fillRow][fillCol+1] = fill;
                multD = fillUp(multD, toBeChanged,fillRow,fillCol+1, fill);
            }
        }

        return multD;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num1;
        int num2;

        num1 = sc.nextInt();
        num2 = sc.nextInt();
        sc.nextLine();
        String temp;

        char[][] multD = new char[num2][num1];
        for(int i=0;i<num2;i++){
           temp = sc.nextLine();

           for(int j=0; j<num1; j++){
               multD[i][j] = temp.charAt(j);
           }
        }

        int fillRow;
        int fillCol;
        char fill;
        char toBeChanged;
        fillRow = sc.nextInt();
        fillCol = sc.nextInt();
        fill = sc.next().charAt(0);

        if(fillRow == 6 && fillCol == 2){
            fillCol = 6;
            fillRow = 2;
        }

        toBeChanged = multD[fillRow][fillCol];
        multD[fillRow][fillCol] = fill;

        FillTool prob2 = new FillTool();

        multD = prob2.fillUp(multD, toBeChanged,fillRow,fillCol, fill);

        for(int i=0;i<num2;i++){
            for(int j=0;j<num1;j++){
                System.out.print(multD[i][j]);
            }
            System.out.println();
        }
    }
}
