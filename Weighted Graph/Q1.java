import java.io.*;
import java.util.*;
import static java.lang.System.*;
class Q1{
    public static void main(String[] args){
        try{
            int[][] graph;
            String str;
            FileReader fr = new FileReader("A:\\SUMMER 2020\\CSE221\\LAB\\Lab 02\\Q1.txt");
            BufferedReader obj = new BufferedReader(fr);
            str = obj.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            int countries = Integer.parseInt(st.nextToken());
            int connections = Integer.parseInt(st.nextToken());
            int hotel = Integer.parseInt(st.nextToken());
            int missions = Integer.parseInt(st.nextToken());
            graph = new int[countries][countries];
            for (int i = 1; i <= connections; i++){
                str = obj.readLine();
                st = new StringTokenizer(str, " ");
                int token1 = Integer.parseInt(st.nextToken());
                int token2 = Integer.parseInt(st.nextToken());
                graph[token1-1][token2-1] = Integer.parseInt(st.nextToken());
            }
            int[] source = new int[missions], destination = new int[missions];
            for(int i = 0; i < missions; i++){
                str = obj.readLine();
                st = new StringTokenizer(str, " ");
                source[i] = Integer.parseInt(st.nextToken());
                destination[i] = Integer.parseInt(st.nextToken());
            }
            
            int[] parent = new int[countries];
            
            for(int c = 0; c < 2; c++){
                int start = source[c] - 1;
                int[] S = new int[countries]; int s = 0;
                Queue q = new Queue();
                for(int i = 0; i < countries; i++){
                    q.enqueue(i);
                }
                q.find(start).dist = 0;
                while(q.check()){
                    Node u = q.checkMin();
                    S[s++] = u.position;
                    for(int v_i = 0; v_i < countries; v_i++){
                        if((graph[u.position][v_i]) > 0){
                            Node v = q.find(v_i);
                            if((u.dist + graph[u.position][v_i]) < v.dist){
                                v.dist = u.dist + graph[u.position][v_i];
                                parent[v_i] = u.position;
                            }
                        }
                    }
                }
                String path = Integer.toString(destination[c]);
                for(int i = destination[c]-1; parent[i] != (hotel-1); i++){
                    path = Integer.toString(parent[i]+1) + "-->" + path;
                }
                path = Integer.toString(hotel) + "-->" + path;
                
                for(int i = hotel-1; parent[i] != (source[c]-1); i++){
                    path = Integer.toString(parent[i]+1) + "-->" + path;
                }
                path = Integer.toString(source[c]) + "-->" + path;
                out.printf("For case %d, John will go through the following sequence of countries: %s. ", c, path);
                out.printf("The path cost is %d.%n", q.find(destination[c]-1).dist);
            }
        }
        catch(Exception a){}
    }
}