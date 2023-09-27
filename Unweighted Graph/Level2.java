import java.io.*;
import java.util.*;
import static java.lang.System.*;
class Level2{
    public static void main(String[] arg){
        int[][] graph;
        try{
            String str;
            FileReader fr = new FileReader("L2.txt");
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
                graph[token2][token1] = 1;
            }
            int lina = Integer.parseInt(obj.readLine());
            int nora = Integer.parseInt(obj.readLine());
            int lara = Integer.parseInt(obj.readLine());
            
            String[] color = new String[position];
            int[] dTime = new int[position];
            int[] parent = new int[position];
            
            for(int i = 0; i < color.length; i++)
                color[i] = "white";
            int start = lina;
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
            if(dTime[nora] == dTime[lara]){
                out.printf("Nora and Lara both reach Lina at the same time.%n");
            } else if(dTime[nora] < dTime[lara]){
                out.printf("Nora reaches Lina first.%n");
            } else {
                out.printf("Lara reaches Lina first.%n");
            }
        }
        catch(Exception a){}
    }
}