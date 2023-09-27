import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class Q2{
    public static void main(String[] args){
        try{
            int[][] graph;
            String str; StringTokenizer st;
            FileReader fr = new FileReader("A:\\SUMMER 2020\\CSE221\\LAB\\Lab 02\\Q2.txt");
            BufferedReader obj = new BufferedReader(fr);
            int nodes = Integer.parseInt(obj.readLine());
            int routes = Integer.parseInt(obj.readLine());
            graph = new int[nodes][nodes];
            for (int i = 1; i <= routes; i++){
                str = obj.readLine();
                st = new StringTokenizer(str, ",");
                int token1 = Integer.parseInt(st.nextToken());
                int token2 = Integer.parseInt(st.nextToken());
                graph[token1][token2] = Integer.parseInt(st.nextToken());
            }
            int source = Integer.parseInt(obj.readLine());
            int destination = Integer.parseInt(obj.readLine());
            
            String[] color = new String[nodes];
            st = new StringTokenizer(obj.readLine(), ",");
            for(int i = 0; i < nodes; i++){
                color[Integer.parseInt(obj.readLine())] = "yellow";
            }
            
            String[] location = new String[nodes];
            location[0] = "Mouchak";
            location[1] = "Panthapath";
            location[4] = "Dhanmondi";
            location[5] = "Lalmatia";
            location[2] = "Rampura";
            location[6] = "Badda";
            location[7] = "Hatirjheel";
            location[3] = "Shahahbagh";
            location[8] = "Nilkhet";
            location[9] = "TSC";
            location[10] = "Dhaka University";
            location[11] = "BUET";
            
            int[] parent = new int[nodes];
            
            int start = source;
            int[] S = new int[nodes]; int s = 0;
            Queue q = new Queue();
            for(int i = 0; i < nodes; i++){
                q.enqueue(i);
            }
            q.find(start).dist = 0;
            while(q.check()){
                Node u = q.checkMin();
                if(color[u.position].equals("yellow")){
                    continue;
                }
                S[s++] = u.position;
                for(int v_i = 0; v_i < nodes; v_i++){
                    if((graph[u.position][v_i]) > 0){
                        Node v = q.find(v_i);
                        if((u.dist + graph[u.position][v_i]) < v.dist){
                            v.dist = u.dist + graph[u.position][v_i];
                            parent[v_i] = u.position;
                        }
                    }
                }
            }
            
            String path = location[destination];
            for(int i = destination; parent[i] != source; i++){
                path = location[i] + "-->" + path;
            }
            path = location[source] + "-->" + path;
            out.printf("John will go through the following sequence of locations: %s. ", path);
            out.printf("The path cost is %d.%n", q.find(destination).dist);
        }
        catch(Exception a){
            err.println(a);
            a.printStackTrace();
        }
    }
}