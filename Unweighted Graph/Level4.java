import java.io.*;
import java.util.*;
import static java.lang.System.*;
class Level4{
    public static void main(String[] q){
        int[][] graph;
        try{
            //creating a graph
            String str;
            FileReader fr = new FileReader("L4.txt");
            BufferedReader obj = new BufferedReader(fr);
            str = obj.readLine();
            int position = Integer.parseInt(str);
            int connections = Integer.parseInt(obj.readLine());
            graph = new int[position][position];
            while ((str = obj.readLine()).length() > 1){
                StringTokenizer st = new StringTokenizer(str, " ");
                int token1 = Integer.parseInt(st.nextToken());
                int token2 = Integer.parseInt(st.nextToken());
                graph[token1][token2] = 1;
            }
            //finding the number edges directed towards
            int[] total = new int[position];
            for(int column = 0; column < position; column++){
                for(int row = 0; row < position; row++){
                    total[column] += graph[row][column];
                }
            }
            //finding the least position
            String min = "0";
            for(int i = 0; i < position-1; i++){
                if(total[i] > total[i+1]){
                    min = String.valueOf(i+1);
                } else if (total[i] == total[i+1]){
                    min = min + " and " + String.valueOf(i+1);
                }
            }
            out.printf("The optimal position(s) for Nora to start is %s%n", min);
        }
        catch(Exception a){
            err.println("An error occured!");
        }
        finally{}
    }
}