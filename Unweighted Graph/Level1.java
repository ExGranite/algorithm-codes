import java.io.*;
import java.util.*;
import static java.lang.System.*;
class Level1{
    public static void main(String[] arg){
        try{
            int[][] graph;
            String str;
            FileReader fr = new FileReader("L1.txt");
            BufferedReader obj = new BufferedReader(fr);
            str = obj.readLine();
            int position = Integer.parseInt(str);
            int connections = Integer.parseInt(obj.readLine());
            graph = new int[position][position];
            for (int i = 1; i <= connections; i++){
                str = obj.readLine();
                StringTokenizer st = new StringTokenizer(str, " ");
                int token1 = Integer.parseInt(st.nextToken());
                int token2 = Integer.parseInt(st.nextToken());
                graph[token1][token2] = 1;
                graph[token2][token1] = 1;
            }
            int lina = Integer.parseInt(obj.readLine());
            
            String[] color = new String[position];
            int[] dTime = new int[position];
            int[] parent = new int[position];
            
            for(int i = 0; i < color.length; i++)
                color[i] = "white";
            int start = 0;
            Queue q = new Queue();
            color[start] = "grey";
            dTime[start] = 0;
            parent[start] = 0;
            q.enqueue(start);
            while(q.check()){
                int a = q.dequeue();
                for(int column = 0; column <= position; column++){
                    if((graph[a][column]) == 1){
                        if(color[column].equals("white")){
                            color[column] = "grey"; dTime[column] = dTime[a] + 1; parent[column] = a;
                            q.enqueue(column);
                        }
                    }
                }
                color[a] = "black";
            }
            out.printf("The minimum number of moves for Nora to reach Lina is %d.%n", dTime[lina]);
        }
        catch(Exception a){}
    }
}
