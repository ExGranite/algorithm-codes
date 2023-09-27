import java.io.*;
import java.util.*;
import static java.lang.System.*;
class Level3{
    public static void main(String[] arg){
        int[][] graph;
        try{
            String str;
            FileReader fr = new FileReader("L3.txt");
            BufferedReader obj = new BufferedReader(fr);
            str = obj.readLine();
            int position = Integer.parseInt(str);
            int connections = Integer.parseInt(obj.readLine());
            graph = new int[position][position];
            while ((str = obj.readLine()).length() > 1){
                StringTokenizer st = new StringTokenizer(str, " ");
                int token1 = Integer.parseInt(st.nextToken());
                int token2 = Integer.parseInt(st.nextToken());
                graph[token2][token1] = 1;
            }
            int lina = Integer.parseInt(obj.readLine());
            int participant = Integer.parseInt(obj.readLine());
            int[] p = new int[participant];
            for(int i = 0; i < p.length; i++){
                p[i] = Integer.parseInt(obj.readLine());
            }
            
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
            out.printf("The participant at position %d reaches Lina first.%n", min(p)+1);
        }
        catch(Exception a){
            err.println(a);
        }
    }
    static int min(int[] a){
        int min = 0;
        for(int i = 1; i < a.length; i++){
            if(a[i] < a[min]){
                min = i;
            }
        }
        return min;
    }
}