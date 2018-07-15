import java.io.*;
import java.util.*;
import java.text.*;

public class ThroughTheDesert
{
    static ArrayList<In> list;
    static double EPS = 1 * Math.pow(Math.E, -15);

    public static void main(String[] args)throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        DecimalFormat df = new DecimalFormat("0.000");

        while(true)
        {
            String line[] = in.readLine().split(" ");

            if(line[1].equals("Fuel") && line[3].equals("0"))
                break;

            list = new ArrayList<In>();
            char t = line[1].charAt(0);
            list.add(new In(t,new Integer(line[0]),new Double(line[3])));


            while(true)
            {
                line = in.readLine().split(" ");
                t = line[1].charAt(0);

                if(t == 'G' && line[1].charAt(1) == 'a')
                    t='g';

                In temp = new In(t,new Integer(line[0]));

                if(t=='F')
                    temp.value = new Double(line[3]);

                list.add(temp);

                if(t=='G')
                    break;
            }
            out.println(df.format(bs()));
            out.flush();
        }
    }
    static double bs()
    {
        double ini = 0.0;
        double fin = 10000.0;
        double m = 0.0;

        for(int i=0;i<50;++i)
        {
            m = (fin + ini) /2.0;

            if(can(m)){
                fin = m;
            }
            else{
                ini = m;
            }
        }
        return m;

    }
    static boolean can(double n)
    {
        double consumo_x_k=0;
        double leaks = 0;
        double gas = n;
        int distance=0;

        for(int i=0;i<list.size();++i)
        {
            In temp = list.get(i);
            int d = temp.ini - distance;
            gas -= (consumo_x_k + leaks) * (double)d;

            distance = temp.ini;

            if(gas < 0)
                return false;

            if(temp.c == 'F')
            {
                consumo_x_k = temp.value /100.0;
            }
            else if(temp.c == 'L')
            {
                ++leaks;
            }
            else if(temp.c == 'g')
            {
                gas = n;
            }
            else if(temp.c == 'M')
            {
                leaks = 0;
            }
        }
        return true;
    }

}
class In
{
    char c;
    int ini;
    double value;

    public In(char c, int in)
    {
        this.c = c;
        ini = in;
    }
    public In(char c, int in, double v)
    {
        this.c = c;
        ini = in;
        value =v;
    }
}